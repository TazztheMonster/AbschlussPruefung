package org.vw.f73.abschlusspruefung;

import lombok.Data;

@Data
public class Mileage {
    private int city;           //in km
    private int autobahn;       //in km
    private int country;        //in km

    public Mileage (int city, int autobahn, int country) {
        this.city = city;
        this.autobahn = autobahn;
        this.country = country;
    }

    public boolean validateUpdate(Mileage mileage) {
        return city <= mileage.getCity() &&
                autobahn <= mileage.getAutobahn() &&
                country <= mileage.getCountry();
    }
}
