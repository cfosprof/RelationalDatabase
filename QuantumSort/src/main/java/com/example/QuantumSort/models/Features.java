package com.example.QuantumSort.models;

public class Features {
    private int beds;
    private int bath;
    private int lotSize;
    private int sqFt;
    private int yearBuilt;
    private int zipCode;
    private int garage;
    private int listPrice;
    private boolean hasPool;
    private boolean isActive;

    @Override
    public String toString() {
        return "Features{" +
                "beds=" + beds +
                ", bath=" + bath +
                ", lotSize=" + lotSize +
                ", sqFt=" + sqFt +
                ", yearBuilt=" + yearBuilt +
                ", zipCode=" + zipCode +
                ", garage=" + garage +
                ", listPrice=" + listPrice +
                ", hasPool=" + hasPool +
                ", isActive=" + isActive +
                '}';
    }

    public int getBeds() {
        return beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }

    public int getBath() {
        return bath;
    }

    public void setBath(int bath) {
        this.bath = bath;
    }

    public int getLotSize() {
        return lotSize;
    }

    public void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }

    public int getSqFt() {
        return sqFt;
    }

    public void setSqFt(int sqFt) {
        this.sqFt = sqFt;
    }

    public int getYearBuilt() {
        return yearBuilt;
    }

    public void setYearBuilt(int yearBuilt) {
        this.yearBuilt = yearBuilt;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public int getGarage() {
        return garage;
    }

    public void setGarage(int garage) {
        this.garage = garage;
    }

    public int getListPrice() {
        return listPrice;
    }

    public void setListPrice(int listPrice) {
        this.listPrice = listPrice;
    }

    public boolean isHasPool() {
        return hasPool;
    }

    public void setHasPool(boolean hasPool) {
        this.hasPool = hasPool;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
