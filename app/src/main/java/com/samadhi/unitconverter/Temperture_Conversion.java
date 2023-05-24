package com.samadhi.unitconverter;

import java.text.NumberFormat;

public class Temperture_Conversion {

    private double celsius;
    private double kelvin;
    private double fahrenheit;

    private double beginingQty;
    private double endingQty;
    private String beginingUnitType;
    private String endingUnitType;

    public Temperture_Conversion(){
        beginingQty = 0;
        endingQty = 0;
        beginingUnitType = "";
        endingUnitType = "";

    }

    public double getBeginingQty() {
        return beginingQty;
    }

    public void setBeginingQty(double beginingQty) {
        this.beginingQty = beginingQty;
    }

    public double getEndingQty() {
        return endingQty;
    }

    public void setEndingQty(double endingQty) {
        this.endingQty = endingQty;
    }

    public String getBeginingUnitType() {
        return beginingUnitType;
    }

    public void setBeginingUnitType(String beginingUnitType) {
        this.beginingUnitType = beginingUnitType;
    }

    public String getEndingUnitType() {
        return endingUnitType;
    }

    public void setEndingUnitType(String endingUnitType) {
        this.endingUnitType = endingUnitType;
    }

    public double getUnitTypeConstant (String unit_type){
        if(unit_type == "celsius"){return celsius;}
        if(unit_type == "kelvin"){return kelvin;}
        if(unit_type == "fahrenheit"){return fahrenheit;}
        return 0;
    }

    public double convertCelsiustoFahrenheit(){
        double biginingQty = getBeginingQty();
        endingQty = (beginingQty*1.8)+32;
        return endingQty;
    }

    public double convertCelsiustoKelvin(){
        double biginingQty = getBeginingQty();
        endingQty = beginingQty+273.15;
        return endingQty;
    }

    public double convertFahrenheittoCelsius(){
        double biginingQty = getBeginingQty();
        endingQty = (beginingQty-32)/1.8;
        return endingQty;
    }

    public double convertFahrenheittoKelvin(){
        double biginingQty = getBeginingQty();
        endingQty = ((beginingQty-32)*1.8) + 273.15;
        return endingQty;
    }

    public double convertKelvintoCelsius(){
        double biginingQty = getBeginingQty();
        endingQty = beginingQty-273.15;
        return endingQty;
    }

    public double convertKelvintoFahrenheit(){
        double biginingQty = getBeginingQty();
        endingQty = ((beginingQty-273.15)*1.8) + 32;
        return endingQty;
    }



    public String toString(){

        NumberFormat nf = NumberFormat.getNumberInstance();

        if(endingUnitType.equals("celsius") || endingUnitType.equals("kelvin") || endingUnitType.equals("fahrenheit")) {
            nf.setMaximumFractionDigits(2);
        }else{
            nf.setMaximumFractionDigits(4);
        }
        return nf.format(getEndingQty() )+ " " + getEndingUnitType();
    }
}
