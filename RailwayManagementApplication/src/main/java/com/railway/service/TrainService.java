package com.railway.service;

import com.railway.model.Train;
import com.railway.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainService {
    @Autowired
    private TrainRepository trainRepository;

    public Train addTrain(Train train) {
        return trainRepository.save(train);
    }

    public List<Train> getAvailableTrains(String source, String destination) {
        return trainRepository.findBySourceAndDestination(source, destination);
    }

    public synchronized boolean bookSeat(Long trainId) {
        Train train = trainRepository.findById(trainId).orElse(null);
        if (train != null && train.getAvailableSeats() > 0) {
            train.setAvailableSeats(train.getAvailableSeats() - 1);
            trainRepository.save(train);
            return true;
        }
        return false;
    }
}
