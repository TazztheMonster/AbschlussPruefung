package org.vw.f73.abschlusspruefung;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/genericData")
public class GenericRestController {

    @Autowired
    private GenericDataClassRepository repository;

    @GetMapping("/get/{data1}")
    public GenericDataClass getGenericData(@PathVariable String data1) {
        return repository.findByData1(data1);
    }

    @PostMapping("/add")
    public boolean addGenericData(@RequestBody GenericDataClass genericDataClass) {
        if (repository.findByData1(genericDataClass.getData1()) != null) {
            return false;
        } else {
            repository.save(genericDataClass);
            return true;
        }
    }

}
