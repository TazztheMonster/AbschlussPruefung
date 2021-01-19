package org.vw.f73.abschlusspruefung;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AbschlusspruefungApplication implements CommandLineRunner {

    @Autowired
    private GenericDataClassRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(AbschlusspruefungApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        repository.save(new GenericDataClass("test", "zwei", 3));
        repository.save(new GenericDataClass("zweiterTest", "drei", 4));

        for (GenericDataClass data : repository.findAll()) {
            System.out.println(data.toString());
        }
    }

}
