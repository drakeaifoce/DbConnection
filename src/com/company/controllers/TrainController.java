package com.company.controllers;

import com.company.entities.Train;
import com.company.entities.User;
import com.company.repositories.interfaces.ITrainRepository;

import java.util.List;

public class TrainController
{
    private final ITrainRepository repo;

    public TrainController(ITrainRepository repo){
        this.repo = repo;
    }

    public String createTrain(String name, int capacity) {
        Train train = new Train(name, capacity);

        boolean created = repo.createTrain(train);

        return (created ? "Train was created!" : "Train creation was failed!");
    }

    public String getTrain(int id) {
        Train train = repo.getTrain(id);

        return (train == null ? "Train was not found!" : train.toString());
    }

    public String getAllTrains() {
        List<Train> trains = repo.getAllTrains();

        return trains.toString();
    }
}
