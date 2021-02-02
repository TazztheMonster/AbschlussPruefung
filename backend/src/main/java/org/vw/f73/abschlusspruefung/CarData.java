package org.vw.f73.abschlusspruefung;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode
@Builder(toBuilder=true)
public class CarData {
    private LocalDateTime timeStamp;
    private String vin;
    private GpsPosition gpsPosition;
    private Mileage mileage;
    private FillLevels fillLevels;
    //private boolean valid;
    private int embt;                           //electro motive belt tensioning
    private double lightOperatingHours;
    private double tirePressure;
    private int temperature;
    private int nodsa;                          //number of driver seat adjustments
    private int nomi;                           //number of media inserted
    private int sblc;                           //starter battery loading cycles

    public boolean validateUpdate(CarData carData) {
        return carData.getVin().equals(vin) &&
                embt <= carData.getEmbt() &&
                lightOperatingHours <= carData.getLightOperatingHours() &&
                mileage.validateUpdate(carData.getMileage()) &&
                nodsa <= carData.getNodsa() &&
                nomi <= carData.getNomi() &&
                sblc <= carData.getSblc();
    }



}
