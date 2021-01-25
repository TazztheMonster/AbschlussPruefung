class CarData{

    vin;
    gpsPosition;
    embt; // electromotive belt tensioning
    lightOperatingHours;
    mileage;
    fillLevels;
    tirePressure;
    temperature;
    nodsa; //number of driver seat adjustments
    nomi; //number of media inserted
    sblc; //starter battery loading cycles
    
    constructor(){
    
        this.gpsPosition = new GpsPosition();
        this.mileage = new Mileage();
        this.fillLevels = new FillLevels();
    
    }
}