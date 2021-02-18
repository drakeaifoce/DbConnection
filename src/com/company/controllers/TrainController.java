package com.company.controllers;

import com.company.entities.Locomotive;
import com.company.entities.Train;
import com.company.entities.User;
import com.company.repositories.interfaces.ILocomotiveRepository;
import com.company.repositories.interfaces.ITrainRepository;

import java.util.List;

public class TrainController
{
    private final ITrainRepository trainRepository;
    private final ILocomotiveRepository locomotiveRepository;

    public TrainController(ITrainRepository trainRepository, ILocomotiveRepository locomotiveRepository){
        this.locomotiveRepository = locomotiveRepository;
        this.trainRepository = trainRepository;
    }

    public String createTrain(String name, int capacity) {
        Train train = new Train(name, capacity);

        boolean created = trainRepository.createTrain(train);

        return (created ? "Train was created!" : "Train creation was failed!");
    }

    public Train getTrain(int id) {
        Train train = trainRepository.getTrain(id);

        return train;
    }

    public String getAllTrains() {
        List<Train> trains = trainRepository.getAllTrains();

        return trains.toString();
    }

    public String createLocomotive(String name, int trainid) {
        Locomotive locomotive = new Locomotive(name, trainid);

        boolean created = locomotiveRepository.createLocomotive(locomotive);

        return (created ? "Locomotive was created!" : "Locomotive creation was failed!");
    }

    public String getLocomotive(int id) {
        Locomotive locomotive = locomotiveRepository.getLocomotive(id);

        return (locomotive == null ? "Train was not found!" : locomotive.toString());
    }

    public String getAllLocomotives() {
        List<Locomotive> locomotives = locomotiveRepository.getAllLocomotives();

        return locomotives.toString();
    }
}
