package flighthome.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import flighthome.model.User;

public interface UserRepository extends MongoRepository<User, String> {
    
    User findByEmail(String email);
}
