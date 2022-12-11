package com.deadlock.firstapp.part;

public class Vgapart {
    private String manufacturer;
    private String name;
    private int price;
    private String chipset;
    private int gddr;
    private int length;
    private int power;
    private boolean choice_enable;

    public Vgapart(){
        manufacturer="";
        name="";
        price=0;
        chipset="";
        gddr=0;
        length=0;
        power=0;
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

    public String getChipset() {
        return chipset;
    }

    public void setChipset(String chipset) {
        this.chipset = chipset;
    }

    public int getGddr() {
        return gddr;
    }

    public void setGddr(int gddr) {
        this.gddr = gddr;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
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
