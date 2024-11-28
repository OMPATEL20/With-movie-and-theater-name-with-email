//package com.acmeplex.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.acmeplex.model.Seat;
//import com.acmeplex.service.SeatService;
//
//@RestController
//@RequestMapping("/seats")
//public class SeatController {
//
//    @Autowired
//    private SeatService seatService;
//
//    @GetMapping("/{showtimeId}")
//    public ResponseEntity<List<Seat>> getSeats(@PathVariable Long showtimeId) {
//        return ResponseEntity.ok(seatService.getSeatsByShowtime(showtimeId));
//    }
//
//    @PostMapping("/update")
//    public ResponseEntity<String> updateSeatAvailability(
//            @RequestParam Long seatId,
//            @RequestParam boolean isAvailable) {
////        seatService.updateSeatAvailability(seatId, isAvailable);
//        return ResponseEntity.ok("Seat availability updated.");
//    }
//}
