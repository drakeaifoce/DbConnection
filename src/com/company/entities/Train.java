package com.company.entities;

public class Train
{
    private int id;
    private String name;
    private int capacity;

    public Train(){

    }

    public Train(String name, int capacity){
        setCapacity(capacity);
        setName(name);
    }

    public Train(int id, String name, int capacity){
        setId(id);
        setName(name);
        setCapacity(capacity);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
       return "Train: " + name + " |  capacity: " +capacity;
    }
}
