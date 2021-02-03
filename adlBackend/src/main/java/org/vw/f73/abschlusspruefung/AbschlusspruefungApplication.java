package org.vw.f73.abschlusspruefung;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class AbschlusspruefungApplication {

    @Autowired
    private CarDataRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(AbschlusspruefungApplication.class, args);
    }


}
