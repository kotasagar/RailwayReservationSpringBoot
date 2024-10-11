package com.railway.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.railway.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
