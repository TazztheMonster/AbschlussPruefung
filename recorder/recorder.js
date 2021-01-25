const fs = require('fs');
const yaml = require('js-yaml');
const AllRandom = require('./AllRandom')

try {
    let fileContents = fs.readFileSync('./recorder.yaml', 'utf8');
    let data = yaml.load(fileContents);
    let singleCarData = data[0];
    console.log(singleCarData);
    AllRandom.allRandom(singleCarData);
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
        return addition(number)
    } else if (number <= 20) {
        if (Math.random() >= 0.7) {
            return addition(number)
        } else {
            subtraction(number)
        }
    } else {
        subtraction(number)
    }
    function addition(number) {
        return Math.floor(Math.random())*21 + 80
    }
    function subtraction(number) {
        return number - Math.floor(Math.random()*5)
    }
}

function fullRandom(multiplyer, isDecimal) {
    if (isDecimal) {
        return Math.floor(Math.random()) * multiplyer
    } else {
        return Math.random() * multiplyer
    }
}