package com.lax.springjwt.security.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lax.springjwt.models.User;
import com.lax.springjwt.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

		return UserDetailsImpl.build(user);
	}
	


	public List<User> getUsersByUsertype(String usertype) {
		List<User> listOfUsers= userRepository.getUsersByUsertype(usertype);
		return listOfUsers;
	}
	
	public Optional<User> findById(Long id) {
		Optional<User> user= userRepository.findById(id);
		return user;
	}
	

	public Optional<User> findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	
	public Optional<User> findUserByResetToken(String resetToken) {
		return userRepository.findTopByResettoken(resetToken);
	}
	
	

}
