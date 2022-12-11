package com.deadlock.firstapp.DO;

public class ListData {
    private String name;
    private String detail;
    private int price;
    private int what_part;
    private boolean choice_enable;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getWhat_part(){return what_part;}

    public void setWhat_part(int what_part){this.what_part=what_part;}

    public boolean getChoice_enable(){return choice_enable;}

    public void setChoice_enable(boolean choice_enable) { this.choice_enable = choice_enable; }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
