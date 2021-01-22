package org.vw.f73.abschlusspruefung;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/adl-api/v1")
@Slf4j
@CrossOrigin(origins="*")
public class CarDataRestController {

    @Autowired
    private CarDataRepository repository;

    @GetMapping("/cars/{vin}")
    public ResponseEntity retrieveADLByVin(@PathVariable String vin) {
        log.debug("Get data for " + vin);
        try {
            CarData carData = repository.findByVin(vin);
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

    @PostMapping()
    public ResponseEntity saveADL(@RequestBody CarData car) {
        log.debug("Saving " + car);
        try {
            repository.save(car);
            return ResponseEntity.status(201).build();
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.status(500).build();
        }
    }

}
