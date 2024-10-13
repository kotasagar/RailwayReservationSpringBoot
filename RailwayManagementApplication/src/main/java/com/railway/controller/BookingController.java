package com.railway.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import com.railway.model.Booking;
import com.railway.model.User;
import com.railway.service.BookingService;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping
    public ResponseEntity<?> bookSeat(@RequestParam Long trainId, @RequestParam int seats, @AuthenticationPrincipal User user) {
        Booking booking = bookingService.bookSeat(trainId, user, seats);
        return ResponseEntity.ok(booking);
    }
    
    @GetMapping
    public List<Booking> getBookingDetails()
    {
    	return bookingService.getBookingDetails();
    }
}
