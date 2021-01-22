package org.vw.f73.abschlusspruefung;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;

@Data
@EqualsAndHashCode
@Builder(toBuilder=true)
public class CarData {

    @Id
    private String vin;
    private GpsPosition gpsPosition;
    private int embt;                           //electro motive belt tensioning
    private double lightOperatingHours;
    private Mileage mileage;
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
