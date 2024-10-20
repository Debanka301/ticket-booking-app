package com.example.ticket_booking_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ticket_booking_app.entity.Ticket;
import com.example.ticket_booking_app.entity.Ticket.TicketStatus;
import com.example.ticket_booking_app.repository.TicketRepository;

@Service
public class TicketService {

	@Autowired
	private TicketRepository ticketRepository;
	
	public List<Ticket> getAvailableTickets(String eventName){
		return ticketRepository.findByEventNameAndStatus(eventName, TicketStatus.AVAILABLE);		
	}
	
	public Optional<Ticket> reserveTicket(Integer ticketId) {
        Optional<Ticket> ticket = ticketRepository.findById(ticketId);
        if (ticket.isPresent() && ticket.get().getStatus() == Ticket.TicketStatus.AVAILABLE) {
            ticket.get().setStatus(Ticket.TicketStatus.RESERVED);
            return Optional.of(ticketRepository.save(ticket.get()));
        }
        return Optional.empty();
    }
	
	public Optional<Ticket> bookTicket(Integer ticketId) {
        Optional<Ticket> ticket = ticketRepository.findById(ticketId);
        if (ticket.isPresent() && ticket.get().getStatus() == Ticket.TicketStatus.RESERVED) {
            ticket.get().setStatus(Ticket.TicketStatus.BOOKED);
            return Optional.of(ticketRepository.save(ticket.get()));
        }
        return Optional.empty();
    }
	
}
