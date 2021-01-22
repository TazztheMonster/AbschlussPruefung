package org.vw.f73.abschlusspruefung;

import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

@SpringBootTest
class AbschlusspruefungApplicationTests {

    @Autowired
    private CarDataRepository repository;

    @Autowired
    private CarDataRestController carDataRestController;

    @Test
    void carDataRestController() {
        CarData car = generateRandomVehicle();
        carDataRestController.saveADL(car);
        CarData car2 = (CarData) carDataRestController.retrieveADLByVin(car.getVin()).getBody();
        Assertions.assertEquals(car, car2);
        repository.delete(car);
    }

    @Test
    void dataBaseBasicFunctions() {
        CarData car = new CarData();
        System.out.println(car);
        repository.save(car);
        CarData car2 = repository.findByVin(car.getVin());
        Assertions.assertNotNull(car2);
        Assertions.assertEquals(car2, car, "Car saved and loaded.");
        repository.delete(car);
        Assertions.assertNull(repository.findByVin(car.getVin()), "car deleted.");
    }

    private CarData generateRandomVehicle() {
        RandomString randomString = new RandomString(20);
        Random random = new Random();
        CarData car = new CarData();
        car.setGpsPosition(new GpsPosition(random.nextDouble(), random.nextDouble()));
        car.setLightOperatingHours(random.nextDouble());
        car.setMileage(generateRandomMileage(random));
        car.setTirePressure(random.nextDouble());
        car.setVin(randomString.nextString());
        car.setTemperature(random.nextInt());
        car.setNodsa(random.nextInt());
        car.setNomi(random.nextInt());
        car.setSblc(random.nextInt());
        car.setEmbt(random.nextInt());
        return car;
    }

    private Mileage generateRandomMileage(Random random) {
        Mileage mileage = new Mileage();
        mileage.setAutobahn(random.nextInt(200000));
        mileage.setAutobahn(random.nextInt(200000));
        mileage.setCity(random.nextInt(200000));
        return mileage;
    }

}
