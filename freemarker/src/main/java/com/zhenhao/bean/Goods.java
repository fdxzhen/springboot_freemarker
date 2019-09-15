package com.zhenhao.bean;

public class Goods {
    private String name;
    private String desc;
    private Double price;
    private boolean onCar;
    private int saleAmount;
    private int remainAmount;
    private int limitAmount;
    private int addAmount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public boolean isOnCar() {
        return onCar;
    }

    public void setOnCar(boolean onCar) {
        this.onCar = onCar;
    }

    public int getSaleAmount() {
        return saleAmount;
    }

    public void setSaleAmount(int saleAmount) {
        this.saleAmount = saleAmount;
    }

    public int getRemainAmount() {
        return remainAmount;
    }

    public void setRemainAmount(int remainAmount) {
        this.remainAmount = remainAmount;
    }

    public int getLimitAmount() {
        return limitAmount;
    }

    public void setLimitAmount(int limitAmount) {
        this.limitAmount = limitAmount;
    }

    public int getAddAmount() {
        return addAmount;
    }

    public void setAddAmount(int addAmount) {
        this.addAmount = addAmount;
    }
}
