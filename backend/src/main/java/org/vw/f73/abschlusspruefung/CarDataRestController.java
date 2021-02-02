package org.vw.f73.abschlusspruefung;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
            CarData carData = repository.findTopByVinOrderByTimeStampDesc(vin);
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

    @GetMapping("/adl-api/v1/cars/{vin}/{numberOfEntries}")
    public ResponseEntity retrieveADLByVin(@PathVariable String vin, @PathVariable int numberOfEntries) {
        List<CarData> cars = repository.findByVinOrderByTimeStampDesc(vin);
        return ResponseEntity.status(200).body(cars.stream().limit(numberOfEntries).collect(Collectors.toList()));
    }

    @PostMapping("/adl-api/v1/cars")
    public ResponseEntity saveADL(@RequestBody CarData newCar) {
        log.debug("Saving " + newCar);
        try {
            //CarData oldCar = repository.findTopByVinOrderByTimeStampDesc(newCar.getVin());
            newCar.setTimeStamp(LocalDateTime.now());
            //newCar.setValid(newCar.validateUpdate(oldCar));
            repository.save(newCar);
            //if (newCar.isValid()) {
            //    return ResponseEntity.status(409).build();
            //} else {
                return ResponseEntity.status(201).build();
            //}
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
