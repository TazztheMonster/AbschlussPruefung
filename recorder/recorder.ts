const fs = require('fs');
const yaml = require('js-yaml');

class FillLevels {
    fuel; //in percent
    coolant; //in percent
    brakeFluid; //in percent
    washingWater; //in percent

    constructor(){}
}
class GpsPosition {

    lat;
    lon;

}
class Mileage {
    city; // in km
    autobahn;  // in km
    country;  // in km
}

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

try {
    let fileContents = fs.readFileSync('./recorder.yaml', 'utf8');
    let data = yaml.load(fileContents);
    let singleCarData = data[0];
    console.log(singleCarData);
} catch (e) {
    console.log(e);
}



