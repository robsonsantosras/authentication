package boasentregas.user.repositories;

import boasentregas.user.models.Login;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<Login,String> {

 }
