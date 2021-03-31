package com.cg.security.a1d;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.security.a1d.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByUserName(String userName);


}
