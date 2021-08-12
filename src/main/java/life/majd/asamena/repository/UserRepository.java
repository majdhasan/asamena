package life.majd.asamena.repository;

import life.majd.asamena.domain.Event;
import life.majd.asamena.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

/*
    @Query(value = "SELECT * FROM EVENT WHERE ADDRESS.CITY = ?1")
    List<Event> findByCity(String city);
*/


}
