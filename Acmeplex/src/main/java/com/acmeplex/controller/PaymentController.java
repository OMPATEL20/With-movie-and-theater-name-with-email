package com.acmeplex.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.acmeplex.model.Payment;
import com.acmeplex.service.EmailService;
import com.acmeplex.service.PaymentService;

	   @Controller
	   public class PaymentController {

	       @Autowired
	       private PaymentService paymentService;

	       @Autowired
	       private EmailService emailService;
//	       
//	       @Autowired
//	       private SeatService seatService;

   @GetMapping("/PurchaseForm")
	   public String getPurchaseForm(
       @RequestParam String theater,
	       @RequestParam String movie,
       @RequestParam String showTime,
	       @RequestParam String selectedSeats,
       @RequestParam double totalPrice,
       @RequestParam("theaterText") String theaterText,
       @RequestParam("movieText") String movieText,
	       Model model) {
	       
	       model.addAttribute("theater", theater);
	       model.addAttribute("movie", movie);
       model.addAttribute("showTime", showTime);
       model.addAttribute("selectedSeats", selectedSeats);
       model.addAttribute("totalPrice", totalPrice);
       model.addAttribute("theaterText", theaterText);
       model.addAttribute("movieText", movieText);
	       return "PurchaseForm";
   }
//   @PostMapping("/processPayment")
//   public String processPayment(
//           @RequestParam String email,
//           @RequestParam String theater,
//           @RequestParam String movie,
//           @RequestParam String showTime,
//           @RequestParam String totalPrice,
//           @RequestParam String selectedSeats, // Added selectedSeats parameter
//           Model model) {
//	   System.out.println("Selected Seats: " + selectedSeats);
//       boolean paymentSuccess = true; // Simulating successful payment
//       String paymentStatus = paymentSuccess ? "Success" : "Failed";
//
//       // Save payment details to the database
//       Payment payment = new Payment();
//       payment.setEmail(email);
//       payment.setTheater(theater);
//       payment.setMovie(movie);
//       payment.setShowTime(showTime);
//       payment.setTotalPrice(new BigDecimal(totalPrice));
//       payment.setPaymentStatus(paymentStatus);
//       payment.setCreatedAt(LocalDateTime.now());
//       payment.setSelectedSeats(selectedSeats); // Set selectedSeats in the payment object
//       paymentService.savePayment(payment);
//
//       if (paymentSuccess) {
//           // Send confirmation email
//           emailService.sendTicketDetails(email, theater, movie, showTime, totalPrice,selectedSeats);
//
//           model.addAttribute("successMessage", "Payment completed successfully! Reservation details sent to your email.");
//           return "ConfirmationPage";
//       } else {
//           model.addAttribute("errorMessage", "Payment failed. Please try again.");
//           return "PurchaseForm";
//       }
//   }
//
//	   
	   
   @PostMapping("/processPayment")
   public String processPayment(
		   @RequestParam String email,
           @RequestParam String theater,
           @RequestParam String movie,
           @RequestParam String showTime,
           @RequestParam String totalPrice,
           @RequestParam String selectedSeats,
           // Receives selected seats
//           @RequestParam String theaterText,
//           @RequestParam String movieText,
           Model model) {

       System.out.println("Selected Seats: " + selectedSeats);

       boolean paymentSuccess = true; // Simulating successful payment
       String paymentStatus = paymentSuccess ? "Success" : "Failed";

       
 
       
       // Mock payment saving (you can integrate with your PaymentService)
       Payment payment = new Payment();
       payment.setEmail(email);
       payment.setTheater(theater);
       payment.setMovie(movie);
       payment.setShowTime(showTime);
       payment.setTotalPrice(new BigDecimal(totalPrice));
       payment.setPaymentStatus(paymentStatus);
       payment.setSelectedSeats(selectedSeats);
       payment.setCreatedAt(LocalDateTime.now());
   
       paymentService.savePayment(payment);

       // Add a success message
       if (paymentSuccess) {
    	      
    	   emailService.sendTicketDetails(email, theater, movie, showTime, totalPrice,selectedSeats);

    	   model.addAttribute("successMessage", "Payment completed successfully! Reservation details sent to your email.");
    	    return "ConfirmationPage"; // Return confirmation page
    	     } else {
    	       model.addAttribute("errorMessage", "Payment failed. Please try again.");
    	       return "PurchaseForm"; // Redirect back to the payment form
    	   }

   }
	   
   	   
	   
//	working done with email this code
//	 @PostMapping("/processPayment")
//	    public String processPayment(
//	            @RequestParam String email,
//	            @RequestParam String theater,
//	            @RequestParam String movie,
//	            @RequestParam String showTime,
//	            @RequestParam String totalPrice,
//	            Model model) {
//	        
//	        // Mock payment processing logic
//	        boolean paymentSuccess = true; // Assume payment is successful for now
//	        
//	        if (paymentSuccess) {
//	            // Send reservation details via email
//	            emailService.sendTicketDetails(email, theater, movie, showTime, totalPrice);
//	            
//	            model.addAttribute("successMessage", "Payment completed successfully! Reservation details sent to your email.");
//	            return "ConfirmationPage"; // Return confirmation page
//	        } else {
//	            model.addAttribute("errorMessage", "Payment failed. Please try again.");
//	            return "PurchaseForm"; // Redirect back to the payment form
//	        }
//	    }

//    @PostMapping("/apply-coupon")
//    @ResponseBody
//    public double applyCoupon(@RequestParam String couponCode, @RequestParam double ticketPrice) {
//        // Define coupon discounts
//        Map<String, Integer> couponDiscounts = Map.of(
//                "SAVE10", 10,  // 10% discount
//                "SAVE20", 20,  // 20% discount
//                "VIP50", 50    // 50% discount
//        );
//
//        // Normalize couponCode to uppercase for case-insensitive matching
//        int discount = couponDiscounts.getOrDefault(couponCode.toUpperCase(), 0);
//
//        // If coupon code is not found, return the original ticket price (or throw an error if required)
//        if (discount == 0) {
//            throw new IllegalArgumentException("Invalid coupon code!");
//        }
//
//        // Calculate the discounted price
//        return ticketPrice - (ticketPrice * discount / 100);
//    }

//    @PostMapping("/cancel-ticket")
//    @ResponseBody
//    public String cancelTicket(@RequestParam boolean isRegistered,
//                               @RequestParam double ticketPrice,
//                               @RequestParam String showTime) {
//        LocalDateTime currentTime = LocalDateTime.now();
//        LocalDateTime showDateTime = LocalDateTime.parse(showTime);
//
//        if (Duration.between(currentTime, showDateTime).toHours() < 72) {
//            return "Tickets cannot be cancelled less than 72 hours prior to the show.";
//        }
//
//        if (!isRegistered) {
//            double adminFee = ticketPrice * 0.15; // 15% fee
//            return String.format("Ticket cancelled. An admin fee of $%.2f has been applied.", adminFee);
//        }
//        return "Ticket cancelled successfully without any admin fee.";
//    }

    @PostMapping("/complete-payment")
    public String completePayment(@RequestParam String creditCard,
                                   @RequestParam String expiryDate,
                                   @RequestParam String cvc,
                                   @RequestParam String email,
                                   @RequestParam String cardholderName,
                                   @RequestParam double grandTotal,
                                   Model model) {
        // Example logic to process payment
        System.out.println("Processing payment with grand total: $" + grandTotal);

      //  model.addAttribute("message", "Payment completed successfully!");
        return "SuccessPage"; // Redirect to a success page
    }

}

