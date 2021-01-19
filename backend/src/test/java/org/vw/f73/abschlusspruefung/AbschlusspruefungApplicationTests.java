package org.vw.f73.abschlusspruefung;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootTest
class AbschlusspruefungApplicationTests {

    @Autowired
    private GenericDataClassRepository repository;

    @Test
    void dataBaseBasicFunctions() {
        GenericDataClass g1 = new GenericDataClass("TestSzenario1", "dies ist ein Test", 152);
        GenericDataClass g2 = new GenericDataClass("TestSzenario2", "immer noch ein Test", 847);

        repository.save(g1);
        repository.save(g2);

        Assertions.assertEquals(repository.findByData1("TestSzenario1"), g1, "G1 saved and loaded.");
        Assertions.assertEquals(repository.findByData1("TestSzenario2"), g2, "G2 saved and loaded.");

        repository.delete(g1);
        repository.delete(g2);

        Assertions.assertNull(repository.findByData1("TestSzenario1"), "G1 deleted.");
        Assertions.assertNull(repository.findByData1("TestSzenario2"), "G2 deleted.");
    }

}
