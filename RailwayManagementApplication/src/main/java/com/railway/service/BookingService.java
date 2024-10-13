package com.railway.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.railway.model.Booking;
import com.railway.model.Train;
import com.railway.model.User;
import com.railway.repository.BookingRepository;
import com.railway.repository.TrainRepository;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private TrainRepository trainRepository;
    
    
    
  /*  @RestController
    public class MyController {
        
        private final Object lock = new Object();

        @PostMapping("/execute")
        public ResponseEntity<String> execute() {
            synchronized (lock) {
                // Only one user can execute this block at a time.
                try {
                    // Your business logic here.
                    Thread.sleep(5000); // Simulating a time-consuming process
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                return ResponseEntity.ok("Executed successfully");
            }
        }
    }
    
    */
    
    
    

    @Transactional
    public synchronized Booking bookSeat(Long trainId, User user, int seats) 
    {
        Train train = trainRepository.findById(trainId).orElseThrow();
        if (train.getAvailableSeats() >= seats) {
            train.setAvailableSeats(train.getAvailableSeats() - seats);
            Booking booking = new Booking();
            booking.setTrain(train);
            booking.setUser(user);
            booking.setSeatsBooked(seats);
            bookingRepository.save(booking);
            return booking;
        }
        throw new RuntimeException("Not enough seats available");
    }
    public List<Booking> getBookingDetails()
    {
    	return bookingRepository.findAll();
    }
}
