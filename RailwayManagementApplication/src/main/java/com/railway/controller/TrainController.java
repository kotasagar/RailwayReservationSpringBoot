package com.railway.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.railway.model.Train;
import com.railway.service.TrainService;

import java.util.List;

@RestController
@RequestMapping("/api/trains")
public class TrainController {
    @Autowired
    private TrainService trainService;

    @PostMapping
    public ResponseEntity<?> addTrain(@RequestBody Train train) {
        trainService.addTrain(train);
        return ResponseEntity.ok("Train added successfully");
    }

    @GetMapping
    public List<Train> getTrains(@RequestParam String source, @RequestParam String destination) {
        return trainService.getAvailableTrains(source, destination);
    }
}
