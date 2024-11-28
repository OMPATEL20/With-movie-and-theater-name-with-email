package com.acmeplex.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acmeplex.model.Payment;
import com.acmeplex.repository.PaymentRepository;

@Service
public class TicketcancelService {

    @Autowired
    private PaymentRepository paymentRepository; // Inject repository

    public String cancelTicket(String theater, String movie, String showTime, String selectedSeats) {
        Optional<Payment> payment = paymentRepository.findByTheaterAndMovieAndShowTimeAndSelectedSeats(theater, movie, showTime, selectedSeats);

        if (payment.isPresent()) {
            Payment ticket = payment.get();
            if ("Cancelled".equals(ticket.getPaymentStatus())) {
                return "Ticket is already cancelled.";
            }
            ticket.setPaymentStatus("Cancelled");
            paymentRepository.save(ticket);
            return "Ticket cancelled successfully.";
        }
        return "No matching ticket found.";
    }
}
