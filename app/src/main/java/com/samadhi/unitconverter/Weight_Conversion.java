package com.samadhi.unitconverter;

import java.text.NumberFormat;

public class Weight_Conversion {

    final double gram = 1000;
    final double kilogram = 1;
    final double pound = 2.205;
    final double ounce = 35.274;
    final double ton = 0.0011;

    private double beginingQty;
    private double endingQty;
    private String beginingUnitType;
    private String endingUnitType;

    public Weight_Conversion(){
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
        if(unit_type == "gram"){return gram;}
        if(unit_type == "kilogram"){return kilogram;}
        if(unit_type == "pound"){return pound;}
        if(unit_type == "ounce"){return ounce;}
        if(unit_type == "ton"){return ton;}
        return 0;
    }

    public double calculateEndingQty(){
        double biginingQty = getBeginingQty();
        double endingQty = getEndingQty();
        double begin_unitType = getUnitTypeConstant(getBeginingUnitType());
        double end_unitType = getUnitTypeConstant(getEndingUnitType());

        endingQty = kilogram/begin_unitType;
        endingQty = endingQty*end_unitType;

        endingQty = endingQty * beginingQty;
        return endingQty;

    }

    public String toString(){

        NumberFormat nf = NumberFormat.getNumberInstance();

        if(endingUnitType.equals("pound") || endingUnitType.equals("ounce")) {
            nf.setMaximumFractionDigits(2);
        }else{
            nf.setMaximumFractionDigits(4);
        }
        return nf.format(getEndingQty() )+ " " + getEndingUnitType();
    }


}
