package org.vw.f73.abschlusspruefung;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@Slf4j
@CrossOrigin(origins="*")
public class CarDataRestController {

    @Autowired
    private CarDataRepository repository;

    @GetMapping("/adl-api/v1/cars/{vin}")
    public ResponseEntity retrieveADLByVin(@PathVariable String vin) {
        log.debug("Get data for " + vin);
        try {
            CarData carData = repository.findFirstByVin(vin);
            if (carData != null) {
                return ResponseEntity.status(200).body(carData);
            } else {
                return ResponseEntity.status(404).build();
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/adl-api/v1/cars/{vin}/{number}")
    public ResponseEntity retrieveADLByVin(@PathVariable String vin, @PathVariable int number) {
        List<CarData> cars = repository.findTopByVinOrderByTimeStamp(vin);
        return ResponseEntity.status(200).body(cars);
    }

    @PostMapping("/adl-api/v1/cars")
    public ResponseEntity saveADL(@RequestBody CarData newCar) {
        newCar.setTimeStamp(LocalDateTime.now());
        log.debug("Saving " + newCar);
        try {
            CarData oldCar = repository.findFirstByVin(newCar.getVin());
            if (oldCar != null && !oldCar.validateUpdate(newCar)) {
                return ResponseEntity.status(409).build();
            }
            repository.save(newCar);
            log.info(newCar.getTimeStamp().toString());
            return ResponseEntity.status(201).build();
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/")
    public ResponseEntity tellIngressEverythingIsFine() {
            return ResponseEntity.status(200).build();
    }

}
