package com.deadlock.firstapp.part;

public class Storagepart {
    private String manufacturer;
    private String name;
    private int price;
    private String type;
    private String capacity;
    private boolean choice_enable;
    public Storagepart(){
        manufacturer="";
        name="";
        price=0;
        type="";
        capacity="";
        choice_enable=true;
    }
    public String getManufacturer() {
        return manufacturer;
    }
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    public String getName() { return name; }
    public void setName(String name) {
        this.name = name;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public String getType() { return type; }
    public void setType(String type) {
        this.type = type;
    }
    public String getCapacity() {
        return capacity;
    }
    public void setCapacity(String capacity) { this.capacity = capacity; }
    public boolean getChoice_enable(){return choice_enable;}
    public void setChoice_enable(boolean choice_enable) { this.choice_enable = choice_enable; }
}
