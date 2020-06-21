package com.company;

public class Avion {
    private float capConbustible;
    private float costoXkm;
    private int sizePasajeros;
    private float velMaxima;
    private Motor motor;
    private String tipoAvion;
    private int id;
    private int tarifa;


    public Avion(float capConbustible,float costoXkm, int sizePasajeros, float velMaxima, Motor motor,String tipoAvion,int id,int tarifa){
        this.capConbustible = capConbustible;
        this.costoXkm = costoXkm;
        this.sizePasajeros = sizePasajeros;
        this.velMaxima = velMaxima;
        this.motor = motor;
        this.tipoAvion = tipoAvion;
        this.id = id;
        this.tarifa = tarifa;
    }

    ///-------------------------------- GETS AND SETS ---------------------------------------------
/*
    @Override
    public String toString() {
        return " Capacidad conbustible: " + capConbustible +
                "| Costo por KM: " + costoXkm +
                "| Cantidad maxima Pasajeros: " + sizePasajeros +
                "| Velocidad Maxima: " + velMaxima +
                "| Tipo de motor: " + motor;
    }*/

    public int getTarifa() { return tarifa; }

    public void setTarifa(int tarifa) { this.tarifa = tarifa; }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getTipoAvion() {
        return tipoAvion;
    }

    public void setTipoAvion(String tipoAvion) {
        this.tipoAvion = tipoAvion;
    }

    public float getCapConbustible() {
        return capConbustible;
    }

    public void setCapConbustible(float capConbustible) {
        this.capConbustible = capConbustible;
    }

    public float getCostoXkm() {
        return costoXkm;
    }

    public void setCostoXkm(float costoXkm) {
        this.costoXkm = costoXkm;
    }

    public int getSizePasajeros() {
        return sizePasajeros;
    }

    public void setSizePasajeros(int sizePasajeros) {
        this.sizePasajeros = sizePasajeros;
    }

    public float getVelMaxima() {
        return velMaxima;
    }

    public void setVelMaxima(float velMaxima) {
        this.velMaxima = velMaxima;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }


    ///----------------------------------------------------------------------------------------------
}
