package org.vw.f73.abschlusspruefung;

import lombok.Data;

@Data
public class FillLevels {

    private int fuel;               //in percent
    private int coolant;            //in percent
    private int brakeFluid;         //in percent
    private int washingWater;       //in percent

    public FillLevels(int fuel, int coolant, int brakeFluid, int washingWater) {
        this.fuel = fuel;
        this.coolant = coolant;
        this.brakeFluid = brakeFluid;
        this.washingWater = washingWater;
    }

}
