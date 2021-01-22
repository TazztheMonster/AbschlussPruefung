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



}
