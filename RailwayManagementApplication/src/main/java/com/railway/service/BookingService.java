package com.railway.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.railway.repository.BookingRepository;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private TrainRepository trainRepository;

    @Transactional
    public Booking bookSeat(Long trainId, User user, int seats) {
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
}
