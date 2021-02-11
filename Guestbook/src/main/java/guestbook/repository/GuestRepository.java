package guestbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import guestbook.entity.Guest;

public interface GuestRepository extends JpaRepository<Guest, Long> {
	
	@Modifying
	@Query(value = "update Guest g set g.status = :status where  g.id= :id")
	void setUpdateStatus (@Param("status") String status, @Param("id") Long id);

}
