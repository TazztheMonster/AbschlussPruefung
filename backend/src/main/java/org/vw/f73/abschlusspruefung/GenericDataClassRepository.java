package org.vw.f73.abschlusspruefung;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface GenericDataClassRepository extends MongoRepository<GenericDataClass, String> {

    public GenericDataClass findByData1(String s);

}
