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
    void carDataUpdateValidation() {
        CarData car = generateRandomVehicle();
        Mileage mileage = car.getMileage();
        CarData car2 = car.toBuilder().mileage(new Mileage(mileage.getCity(), mileage.getAutobahn(), mileage.getCountry())).build();

        Assertions.assertTrue(car.validateUpdate(car2), "Update without changes");

        car2.setEmbt(car.getEmbt()+1);
        Assertions.assertTrue(car.validateUpdate(car2), "Update wit embt +1");
        car2.setEmbt(car.getEmbt()-1);
        Assertions.assertFalse(car.validateUpdate(car2), "Update wit embt -1");
        car2.setEmbt(car.getEmbt());

        car2.getMileage().setCity(car.getMileage().getCity()+1);
        Assertions.assertTrue(car.validateUpdate(car2), "Update wit mileageCity +1");
        car2.getMileage().setCity(car.getMileage().getCity()-1);
        Assertions.assertFalse(car.validateUpdate(car2), "Update wit mileageCity -1");

    }

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
        CarData car = generateRandomVehicle();
        System.out.println(car);
        repository.save(car);
        CarData car2 = repository.findTopByVinOrderByTimeStampDesc(car.getVin());
        Assertions.assertNotNull(car2);
        Assertions.assertEquals(car2, car, "Car saved and loaded.");
        repository.delete(car);
        Assertions.assertNull(repository.findTopByVinOrderByTimeStampDesc(car.getVin()), "car deleted.");
    }

    private CarData generateRandomVehicle() {
        RandomString randomString = new RandomString(20);
        Random random = new Random();
        return CarData.builder()
                .gpsPosition(new GpsPosition(random.nextDouble(), random.nextDouble()))
                .lightOperatingHours(random.nextDouble())
                .mileage(generateRandomMileage(random))
                .tirePressure(random.nextDouble())
                .vin(randomString.nextString())
                .temperature(random.nextInt())
                .nodsa(random.nextInt())
                .nomi(random.nextInt())
                .sblc(random.nextInt())
                .embt(random.nextInt())
                .fillLevels(new FillLevels(random.nextInt(100), random.nextInt(100), random.nextInt(100), random.nextInt(100)))
                .build();
    }

    private Mileage generateRandomMileage(Random random) {
        return new Mileage(random.nextInt(200000), random.nextInt(200000), random.nextInt(200000));
    }

}
