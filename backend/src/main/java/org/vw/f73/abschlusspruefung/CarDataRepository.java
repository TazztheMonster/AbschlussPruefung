package org.vw.f73.abschlusspruefung;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CarDataRepository extends MongoRepository<CarData, String> {

    public CarData findByVin(String s);

}
