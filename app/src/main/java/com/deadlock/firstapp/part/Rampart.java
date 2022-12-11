package com.deadlock.firstapp.part;

public class Rampart {
    private String manufacturer;
    private String name;
    private int price;
    private int capacity;
    private int clock;
    private int set;
    private boolean choice_enable;
    public Rampart(){
        manufacturer="";
        name="";
        price=0;
        capacity=0;
        clock=0;
        choice_enable=true;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) { this.capacity = capacity; }

    public int getClock() {
        return clock;
    }

    public void setClock(int clock) {
        this.clock = clock;
    }
    public boolean getChoice_enable(){return choice_enable;}

    public void setChoice_enable(boolean choice_enable) { this.choice_enable = choice_enable; }

    public int getSet() {
        return set;
    }

    public void setSet(int set) {
        this.set = set;
    }
}
