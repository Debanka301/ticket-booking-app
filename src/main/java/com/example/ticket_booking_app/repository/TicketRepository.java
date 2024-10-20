package com.example.ticket_booking_app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ticket_booking_app.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer>{
	List<Ticket> findByEventNameAndStatus(String eventName, Ticket.TicketStatus status);
}
