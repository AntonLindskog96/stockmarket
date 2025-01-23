package com.stock.stockmarket.model;

public class StockQuote {
    private double c; // current price
    private double h; // highest price today
    private double l; // lowest price today
    private double o; // Openingprice
    private double pc; //Previous close
    private double d; // Price change since previous close
    private double dp; // Procentchange since previous close
    private double t; // Unix timestamp

    public double getT() {
        return t;
    }

    public void setT(double t) {
        this.t = t;
    }

    public double getDp() {
        return dp;
    }

    public void setDp(double dp) {
        this.dp = dp;
    }

    public double getD() {
        return d;
    }

    public void setD(double d) {
        this.d = d;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getPc() {
        return pc;
    }

    public void setPc(double pc) {
        this.pc = pc;
    }

    public double getO() {
        return o;
    }

    public void setO(double o) {
        this.o = o;
    }

    public double getL() {
        return l;
    }

    public void setL(double l) {
        this.l = l;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }
}
