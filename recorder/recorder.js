const fs = require('fs');
const yaml = require('js-yaml');
const https = require('https')

class FillLevels {
    fuel; //in percent
    coolant; //in percent
    brakeFluid; //in percent
    washingWater; //in percent
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
    allRandom(singleCarData);



    const data2 = JSON.stringify({
      singleCarData
    })
    
    const options = {
      hostname: 'localhost',
      port: 8080,
      path: '/adl-api/v1/cars',
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
        'Content-Length': data2.length
      }
    }
    
    const req = https.request(options, res => {
      console.log(`statusCode: ${res.statusCode}`)
    
      res.on('data', d => {
        process.stdout.write(d)
      })
    })
    
    req.on('error', error => {
      console.error(error)
    })
    
    req.write(data2)
    req.end()




    console.log(singleCarData);
} catch (e) {
    console.log(e);
}

function addRandomAmount(number, multiplyer, isDecimal) {
    let additionalNumber;
    if (isDecimal) {
        additionalNumber = Math.floor(Math.random() * multiplyer);
    } else {
        additionalNumber = Math.random() * multiplyer;
    }
    return number + additionalNumber;
}

function fuelLevelChange(number) {
    if (number <= 5) {
        return addition(number);
    } else if (number <= 20) {
        if (Math.random() >= 0.7) {
            return addition(number);
        } else {
            return subtraction(number);
        }
    } else {
        return subtraction(number)
    }
    function addition(number) {
        return Math.floor(Math.random() * 21 + 80);
    }
    function subtraction(number) {
        return number - Math.floor(Math.random()*5);
    }
}

function fullRandom(multiplyer, isDecimal) {
    if (isDecimal) {
        return Math.floor(Math.random()) * multiplyer;
    } else {
        return Math.random() * multiplyer;
    }
}

function allRandom(car) {
    car.gpsPosition.lon = fullRandom(5, false);
    car.gpsPosition.lat = fullRandom(5, false);
    car.mileage.city = addRandomAmount(car.mileage.city, 51, true);
    car.mileage.autobahn = addRandomAmount(car.mileage.autobahn, 51, true);
    car.mileage.country = addRandomAmount(car.mileage.country, 51, true);
    car.fillLevels.fuel = fuelLevelChange(car.fillLevels.fuel);
    car.fillLevels.coolant = fuelLevelChange(car.fillLevels.coolant);
    car.fillLevels.brakeFluid = fuelLevelChange(car.fillLevels.brakeFluid);
    car.fillLevels.washingWater = fuelLevelChange(car.fillLevels.washingWater);
    car.embt = addRandomAmount(car.embt, 10, true);
    car.lightOperatingHours = addRandomAmount(car.lightOperatingHours, 5, false);
    car.tirePressure = fullRandom(3, false);
    car.nodsa = addRandomAmount(car.nodsa, 11, true);
    car.sblc = addRandomAmount(car.sblc, 11, true);
}

