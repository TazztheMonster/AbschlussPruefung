package org.vw.f73.abschlusspruefung;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/genericData")
@Slf4j
@CrossOrigin(origins="*")
public class GenericRestController {

    @Autowired
    private GenericDataClassRepository repository;

    @GetMapping("/get/{data1}")
    public GenericDataClass getGenericData(@PathVariable String data1) {
        log.debug("Get data for " + data1);
        return repository.findByData1(data1);
    }

    @PostMapping("/add")
    public ResponseEntity addGenericData(@RequestBody GenericDataClass genericDataClass) {
        if (repository.findByData1(genericDataClass.getData1()) != null) {
            log.error("Object already exist in the database:\n" + genericDataClass.toString());
            return ResponseEntity.ok().build();
        } else {
            log.debug("Added to database.");
            repository.save(genericDataClass);
            return ResponseEntity.badRequest().build();
        }
    }

}
