package com.railway.repository;

import com.railway.model.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TrainRepository extends JpaRepository<Train, Long> {
    List<Train> findBySourceAndDestination(String source, String destination);
    
    @Query(value="select available_seats from train t where t.id=?1",nativeQuery=true)
    public int findByAvailableSeats(long id);
}
