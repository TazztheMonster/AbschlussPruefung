package org.vw.f73.abschlusspruefung;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class AbschlusspruefungApplication implements CommandLineRunner {

    @Autowired
    private GenericDataClassRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(AbschlusspruefungApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.debug("Database at start:\n---------------------------------------------------------------------");
        for (GenericDataClass data : repository.findAll()) {
            log.debug(data.toString());
        }
        log.debug("---------------------------------------------------------------------");
    }

}
