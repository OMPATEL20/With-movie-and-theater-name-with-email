//package com.acmeplex.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.acmeplex.model.Seat;
//import com.acmeplex.repository.SeatRepository;
//
//@Service
//public class SeatService {
//
//    @Autowired
//    private SeatRepository seatRepository;
//
//    public List<Seat> getSeatsByShowtime(Long showtimeId) {
//        return seatRepository.findByShowtimeId(showtimeId);
//    }
//
//    public void updateSeatAvailability(List<Integer> seatIds, boolean isAvailable) {
//        Object seat = ((Object) seatRepository.findAll(seatIds));
//        ((Seat) seat).setAvailable(isAvailable);
////        seatRepository.saveAll seat);
//    }
//}
