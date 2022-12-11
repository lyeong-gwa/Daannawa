package com.deadlock.firstapp.part;

public class Powerpart {
    private String powercol;
    private String manufacturer;
    private String name;
    private int price;
    private int power;
    private boolean choice_enable;
    public Powerpart(){
        manufacturer="";
        name="";
        price=0;
        powercol="";
        power=0;
        choice_enable=true;
    }

    public String getPowercol() {
        return powercol;
    }

    public void setPowercol(String powercol) {
        this.powercol = powercol;
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

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
    public boolean getChoice_enable(){return choice_enable;}

    public void setChoice_enable(boolean choice_enable) { this.choice_enable = choice_enable; }
}
