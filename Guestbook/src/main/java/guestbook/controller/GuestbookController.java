package guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import guestbook.entity.Guest;
import guestbook.service.GuestService;



@Controller
public class GuestbookController {

	@Autowired
	private GuestService service; 
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Guest> listGuests = service.listAll();
		model.addAttribute("listGuests", listGuests);
		
		return "index";
	}
	@RequestMapping("/new")
	public String showNewGuestPage(Model model) {
		Guest guest = new Guest();
		model.addAttribute("guest", guest);
		
		return "new_guest";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveGuest(@ModelAttribute("guest") Guest guest) {
		service.save(guest);
		
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditGuestPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_guest");
		Guest guest = service.get(id);
		mav.addObject("guest", guest);
		
		return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteGuest(@PathVariable(name = "id") int id) {
		service.delete(id);
		return "redirect:/";		
	}
	
}
