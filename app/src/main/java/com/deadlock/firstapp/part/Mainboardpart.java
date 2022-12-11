package com.deadlock.firstapp.part;

public class Mainboardpart {
    private String manufacturer;
    private String name;
    private int price;

    private String standard;
    private String socket;
    private String chipset;
    private boolean choice_enable;
    public Mainboardpart(){
        manufacturer="";
        name="";
        price=0;
        standard="";
        socket="";
        chipset="";
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

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public String getChipset() {
        return chipset;
    }

    public void setChipset(String chipset) {
        this.chipset = chipset;
    }
    public boolean getChoice_enable(){return choice_enable;}

    public void setChoice_enable(boolean choice_enable) { this.choice_enable = choice_enable; }
}
