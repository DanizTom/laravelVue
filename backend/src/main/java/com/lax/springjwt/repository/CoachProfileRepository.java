package com.lax.springjwt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lax.springjwt.models.CoachProfile;

@Repository
public interface CoachProfileRepository extends JpaRepository<CoachProfile, Long>{

	Optional<CoachProfile> findById(Long id);
}
