package com.deadlock.firstapp.part;

public class Cpupart {
    private String manufacturer;
    private String name;
    private int price;
    private String socket;
    private int core;
    private int thread;
    private float clock;
    private Boolean graphic;
    private boolean choice_enable;
    public Cpupart(){
        manufacturer="";
        name="";
        price=0;
        socket="";
        core=0;
        thread=0;
        clock=0;
        graphic=false;
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

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public int getCore() {
        return core;
    }

    public void setCore(int core) {
        this.core = core;
    }

    public int getThread() {
        return thread;
    }

    public void setThread(int thread) {
        this.thread = thread;
    }

    public float getClock() {
        return clock;
    }

    public void setClock(float clock) {
        this.clock = clock;
    }

    public Boolean getGraphic() {
        return graphic;
    }

    public void setGraphic(Boolean graphic) {
        this.graphic = graphic;
    }
    public boolean getChoice_enable(){return choice_enable;}

    public void setChoice_enable(boolean choice_enable) { this.choice_enable = choice_enable; }

}
