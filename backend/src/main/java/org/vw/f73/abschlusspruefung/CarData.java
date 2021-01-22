package org.vw.f73.abschlusspruefung;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;

@Data
@EqualsAndHashCode
public class CarData {

    @Id
    String vin;
    GpsPosition gpsPosition;
    int embt;                           //electro motive belt tensioning
    double lightOperatingHours;
    Mileage mileage;
    double tirePressure;
    int temperature;
    int nodsa;                          //number of driver seat adjustments
    int nomi;                           //number of media inserted
    int sblc;                           //starter battery loading cycles

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
