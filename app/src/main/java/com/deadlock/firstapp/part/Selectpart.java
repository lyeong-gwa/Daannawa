package com.deadlock.firstapp.part;

import java.io.Serializable;

public class Selectpart implements Serializable {
    private Casepart casepart;
    private Coolerpart coolerpart;
    private Cpupart cpupart;
    private Mainboardpart mainboardpart;
    private Powerpart powerpart;
    private Rampart rampart;
    private Storagepart storagepart;
    private Vgapart vgapart;
    private boolean choice_enable;

    public Selectpart(){
        casepart=null;
        coolerpart=null;
        cpupart=null;
        mainboardpart=null;
        powerpart=null;
        rampart=null;
        storagepart=null;
        vgapart=null;
        choice_enable=true;
    }
    public Casepart getCasepart() {
        return casepart;
    }
    public void setCasepart(Casepart casepart) {
        this.casepart = casepart;
    }
    public Coolerpart getCoolerpart() {
        return coolerpart;
    }
    public void setCoolerpart(Coolerpart coolerpart) {
        this.coolerpart = coolerpart;
    }
    public Cpupart getCpupart() {
        return cpupart;
    }
    public void setCpupart(Cpupart cpupart) {
        this.cpupart = cpupart;
    }
    public Mainboardpart getMainboardpart() {
        return mainboardpart;
    }
    public void setMainboardpart(Mainboardpart mainboardpart) {
        this.mainboardpart = mainboardpart;
    }
    public Powerpart getPowerpart() {
        return powerpart;
    }
    public void setPowerpart(Powerpart powerpart) {
        this.powerpart = powerpart;
    }
    public Rampart getRampart() {
        return rampart;
    }
    public void setRampart(Rampart rampart) {
        this.rampart = rampart;
    }
    public Storagepart getStoragepart() {
        return storagepart;
    }
    public void setStoragepart(Storagepart storagepart) {
        this.storagepart = storagepart;
    }
    public Vgapart getVgapart() {
        return vgapart;
    }
    public void setVgapart(Vgapart vgapart) {
        this.vgapart = vgapart;
    }
    public boolean getAChoice_enable(){return choice_enable;}
    public void setChoice_enable(boolean choice_enable) { this.choice_enable = choice_enable; }
}
