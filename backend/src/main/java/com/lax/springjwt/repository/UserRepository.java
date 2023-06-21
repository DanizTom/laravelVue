package com.lax.springjwt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lax.springjwt.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
	
	List<User> getUsersByUsertype(String usertype);
	
	Optional<User> findById(Long id);
	
	Optional<User> findTopByResettoken(String resetToken);

	Optional<User> findByEmail(String email);
	
}
