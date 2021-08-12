package life.majd.asamena.repository;

import life.majd.asamena.domain.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends MongoRepository<Event, String> {

/*
    @Query(value = "SELECT * FROM EVENT WHERE ADDRESS.CITY = ?1")
    List<Event> findByCity(String city);
*/


}
