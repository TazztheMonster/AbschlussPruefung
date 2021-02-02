package org.vw.f73.abschlusspruefung;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CarDataRepository extends MongoRepository<CarData, String> {

    public CarData findFirstByVin (String s);
    public List<CarData> findTopNByVinOrderByTimeStamp(String vin, int n);
    public List<CarData> findTopByVinOrderByTimeStamp(String vin);

}
