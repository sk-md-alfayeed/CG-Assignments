package flighthome.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import flighthome.model.Role;

public interface RoleRepository extends MongoRepository<Role, String> {
    
    Role findByRole(String role);

}
