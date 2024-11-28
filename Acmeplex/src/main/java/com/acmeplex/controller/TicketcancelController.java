//package com.acmeplex.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.acmeplex.service.PaymentService;
//
//import ch.qos.logback.core.model.Model;
//
//public class TicketcancelController {
//@Autowired
//private PaymentService paymentService;
//@GetMapping("/CancelForm")
//public String getCancelForm(
//        @RequestParam String theater,
//        @RequestParam String movie,
//        @RequestParam String showTime,
//        @RequestParam String selectedSeats,
//        Model model) {
//
//    model.addAttribute("theater", theater);
//    model.addAttribute("movie", movie);
//    model.addAttribute("showTime", showTime);
//    model.addAttribute("selectedSeats", selectedSeats);
//    return "CancelForm"; // Create a Thymeleaf template for cancellation
//}
//@PostMapping("/processCancel")
//public String processCancel(
//        @RequestParam String theater,
//        @RequestParam String movie,
//        @RequestParam String showTime,
//        @RequestParam String selectedSeats,
//        Model model) {
//
//    // Logic to cancel the ticket
//    String message = paymentService.cancelTicket(theater, movie, showTime, selectedSeats);
//
//    model.addAttribute("successMessage", message);
//    return "CancelConfirmation"; // Create a confirmation page for cancellation
//}
//}