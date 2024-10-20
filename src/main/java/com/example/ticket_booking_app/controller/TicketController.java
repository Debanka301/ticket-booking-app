package com.example.ticket_booking_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ticket_booking_app.entity.Ticket;
import com.example.ticket_booking_app.service.TicketService;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {
	
	@Autowired
	private TicketService ticketService;
	
	 @GetMapping("/available/{eventName}")
	    public List<Ticket> getAvailableTickets(@PathVariable String eventName) {
	        return ticketService.getAvailableTickets(eventName);
	    }

	    @PostMapping("/reserve/{ticketId}")
	    public ResponseEntity<Ticket> reserveTicket(@PathVariable Integer ticketId) {
	        return ticketService.reserveTicket(ticketId)
	                .map(ResponseEntity::ok)
	                .orElse(ResponseEntity.badRequest().build());
	    }

	    @PostMapping("/book/{ticketId}")
	    public ResponseEntity<Ticket> bookTicket(@PathVariable Integer ticketId) {
	        return ticketService.bookTicket(ticketId)
	                .map(ResponseEntity::ok)
	                .orElse(ResponseEntity.badRequest().build());
	    }
	
	

}
