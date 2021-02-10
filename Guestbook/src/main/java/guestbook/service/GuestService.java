package guestbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import guestbook.entity.Guest;
import guestbook.repository.GuestRepository;

@Service
@Transactional
public class GuestService {

	@Autowired
	private GuestRepository repo;
	
	public List<Guest> listAll() {
		return repo.findAll();
	}
	
	public void save(Guest guest) {
		repo.save(guest);
	}
	
	public Guest get(long id) {
		return repo.findById(id).get();
	}
	
	public void delete(long id) {
		repo.deleteById(id);
	}
}
