package org.vw.f73.abschlusspruefung;

import lombok.Data;

@Data
public class Mileage {
    int city;           //in km
    int autobahn;       //in km
    int country;        //in km

    public boolean validateUpdate(Mileage mileage) {
        return city <= mileage.getCity() &&
                autobahn <= mileage.getAutobahn() &&
                country <= mileage.getCountry();
    }
}
