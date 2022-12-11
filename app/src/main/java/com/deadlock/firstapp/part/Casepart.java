package com.deadlock.firstapp.part;

public class Casepart {
    private String manufacturer;
    private String name;
    private int price;
    private String size;
    private String standard;
    private int cooler_size;
    private int vga_size;
    private int radiator_size;
    private boolean choice_enable;
    public Casepart(){
        manufacturer="";
        name="";
        price=0;
        size="";
        standard="";
        cooler_size=0;
        vga_size=0;
        radiator_size=0;
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public int getCooler_size() {
        return cooler_size;
    }

    public void setCooler_size(int cooler_size) {
        this.cooler_size = cooler_size;
    }

    public int getVga_size() {
        return vga_size;
    }

    public void setVga_size(int vga_size) {
        this.vga_size = vga_size;
    }

    public int getRadiator_size() {
        return radiator_size;
    }

    public void setRadiator_size(int radiator_size) {
        this.radiator_size = radiator_size;
    }

    public boolean getChoice_enable(){return choice_enable;}

    public void setChoice_enable(boolean choice_enable) { this.choice_enable = choice_enable; }
}
