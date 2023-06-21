package com.lax.springjwt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lax.springjwt.models.CoachReviews;

@Repository
public interface CoachReviewsRepository extends JpaRepository<CoachReviews, Long> {

	List<CoachReviews> findAll();

	CoachReviews findByClientidAndCoachid(Long clientid, Long coachid);

	List<CoachReviews> findByCoachid(Long coachid);

}
