package org.vw.f73.abschlusspruefung;

import lombok.Data;

@Data
public class GpsPosition {
    private double lat;
    private double lon;

    public GpsPosition(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }
}
