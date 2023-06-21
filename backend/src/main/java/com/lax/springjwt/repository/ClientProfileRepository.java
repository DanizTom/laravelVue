package com.lax.springjwt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lax.springjwt.models.ClientProfile;

@Repository
public interface ClientProfileRepository extends JpaRepository<ClientProfile, Long>{

	Optional<ClientProfile> findById(Long id);
}
