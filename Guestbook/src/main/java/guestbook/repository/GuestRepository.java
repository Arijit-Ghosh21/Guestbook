package guestbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import guestbook.entity.Guest;

public interface GuestRepository extends JpaRepository<Guest, Long> {

}
