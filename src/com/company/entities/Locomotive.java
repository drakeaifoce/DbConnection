package com.company.entities;

public class Locomotive
{
    private int id;
    private String name;
    private int trainId;

    public Locomotive(){

    }

    public Locomotive(String name, int trainId){
        setName(name);
        setTrainId(trainId);
    }

    public Locomotive(int id, String name, int trainId){
        setId(id);
        setName(name);
        setTrainId(trainId);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return "Locomotive[id: " + getId() + ", name: " + getName() + ", train_id: " + getTrainId();
    }
}

