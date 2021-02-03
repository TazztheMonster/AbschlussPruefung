package org.vw.f73.abschlusspruefung;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CarDataRepository extends MongoRepository<CarData, String> {

    public CarData findTopByVinOrderByTimeStampDesc (String vin);
    public List<CarData> findByVinOrderByTimeStampDesc(String vin);

}
