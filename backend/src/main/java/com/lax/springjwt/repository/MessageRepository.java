package com.lax.springjwt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lax.springjwt.models.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
	Optional<Message> findByCoachid(Long id);

	Optional<Message> findByClientid(Long id);

	List<Message> findAllByCoachid(Long coachid);
	
	List<Message> findAllByCoachidAndFromemail(Long coachid,String fromEmail);
	
	List<Message> findAllByCoachidAndToemail(Long coachid,String toEmail);

	List<Message> findAllByClientid(Long clientid);
	
	List<Message> findAllByClientidAndFromemail(Long clientid, String fromEmail);
	
	List<Message> findAllByClientidAndToemail(Long clientid, String toEmail);
	
	

}
