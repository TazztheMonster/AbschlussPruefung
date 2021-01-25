function allRandom(car) {
    car.gpsPosition.lon = fullRandom(5, false);
    car.gpsPosition.lat = fullRandom(5, false);
    car.mileage.city = addRandomAmount(car.mileage.city, 51, true);
    car.mileage.autobahn = addRandomAmount(car.mileage.autobahn, 51, true);
    car.mileage.country = addRandomAmount(car.mileage.country, 51, true);
    car.embt = addRandomAmount(car.embt, 10, true);
    car.lightOperatingHours = addRandomAmount(car.lightOperatingHours, 5, false);
    car.tirePressure = fullRandom(3, false);
    car.nodsa = addRandomAmount(car.nodsa, 11, true);
    car.sblc = addRandomAmount(car.sblc, 11, true);
}