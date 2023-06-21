package com.lax.springjwt.controllers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.aspectj.weaver.ArrayAnnotationValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lax.springjwt.models.ERole;
import com.lax.springjwt.models.Message;
import com.lax.springjwt.models.Role;
import com.lax.springjwt.models.SendEmailVO;
import com.lax.springjwt.models.SendInboxMessageVO;
import com.lax.springjwt.models.ClientProfile;
import com.lax.springjwt.models.ClientProfileVO;
import com.lax.springjwt.models.ClientPublicProfileVO;
import com.lax.springjwt.models.CoachProfile;
import com.lax.springjwt.models.CoachProfileVO;
import com.lax.springjwt.models.CoachPublicProfileVO;
import com.lax.springjwt.models.CoachReviews;
import com.lax.springjwt.models.CoachReviewsVO;
import com.lax.springjwt.models.UploadImageVO;
import com.lax.springjwt.models.User;
import com.lax.springjwt.models.UserVO;
import com.lax.springjwt.payload.response.MessageResponse;
import com.lax.springjwt.repository.ClientProfileRepository;
import com.lax.springjwt.repository.CoachProfileRepository;
import com.lax.springjwt.repository.CoachReviewsRepository;
import com.lax.springjwt.repository.MessageRepository;
import com.lax.springjwt.repository.RoleRepository;
import com.lax.springjwt.repository.UserRepository;
import com.lax.springjwt.security.services.EmailService;
import com.lax.springjwt.security.services.MessageService;
import com.lax.springjwt.security.services.UserDetailsImpl;
import com.lax.springjwt.security.services.UserDetailsServiceImpl;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class AppController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired 
	private MessageService messageService;
	

	
	@Autowired
	CoachProfileRepository coachProfileRepository;
	
	@Autowired
	ClientProfileRepository clientProfileRepository;
	
	@Autowired
	CoachReviewsRepository coachReviewsRepository;
	
	@Autowired
	MessageRepository messageRepository;
	
	
	
	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}
	
	@GetMapping("/user")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public String userAccess() {
		return "User Content.";
	}

	@GetMapping("/mod")
	@PreAuthorize("hasRole('MODERATOR')")
	public String moderatorAccess() {
		return "Moderator Board.";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Admin Board.";
	}
	
	
/*	@PutMapping("/users/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<Object> updateClient(@RequestBody User user, @PathVariable String id) {
		
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		
		Optional<User> userFound = userRepository.findById(Long.parseLong(id));
		if (userFound==null)
			return ResponseEntity.notFound().build();
		user.setId(Long.parseLong(id));
		user.setEmail(userFound.get().getEmail());
		user.setUsername(userFound.get().getUsername());
		user.setPassword(encoder.encode(userFound.get().getPassword()));
		
		//System.out.println("userDetails.getUsername() is"+userDetails.getUsername());
	//	System.out.println("userDetails.getPassword() is"+userDetails.getPassword());
		
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(userFound.get().getUsername(), encoder.encode(userFound.get().getPassword())));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		
		List<String> strRoles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role userRole = roleRepository.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);

					break;
				case "mod":
					Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(modRole);

					break;
				default:
					Role userRole = roleRepository.findByName(ERole.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
				}
			});
		}
		user.setRoles(roles);
		userRepository.save(user);
		return ResponseEntity.noContent().build();
		
	}*/

	
	/*@PutMapping("/users/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<Object> updateUser(@RequestBody UserVO user, @PathVariable String id) {

		if (userRepository.findById(Long.parseLong(id)) != null) {
			Optional<User> userFound = userRepository.findById(Long.parseLong(id));
			if (userFound.get() != null) {
				userFound.get().setFirstname(user.getFirstname());
				userFound.get().setLastname(user.getLastname());
				userFound.get().setAge(user.getAge());
				User userNew = userFound.get();
				userRepository.save(userNew);
			}
			
			return ResponseEntity.ok(new MessageResponse("User udpated successfully!"));
		} else {
			return (ResponseEntity<Object>) ResponseEntity.badRequest();
		}
	}*/
	
	

	
	@PutMapping("/users/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<Object> updateUser(@RequestBody UserVO userVO, @PathVariable String id) {

		if (userRepository.findById(Long.parseLong(id)) != null) {
			Optional<User> userFound = userRepository.findById(Long.parseLong(id));
			if (userFound.get() != null) {
				userFound.get().setFirstname(userVO.getFirstname());
				userFound.get().setLastname(userVO.getLastname());
				userFound.get().setAge(userVO.getAge());
				User userNew = userFound.get();
				userRepository.save(userNew);
			}
			
			//System.out.println("====userVO.getCoachSkills()==="+userVO.getCoachSkills().toString());
			String [] coachSkills= userVO.getCoachSkills();
			StringBuffer listOfSkillsBuffer= new StringBuffer();
			//If it is a coach, get coachprofile attributes from coachprofile table
			if (userFound.get().getUsertype().equalsIgnoreCase("coach")) {
				if ((coachProfileRepository.findById(userFound.get().getId())).isPresent()) {

					for (int i = 0; i < coachSkills.length; i++) {
						System.out.println("@@@@@@@@@@@@@@@@"+ coachSkills[i]+"@@@@@@@@@@@@@@@@@@@@@@@@@");
						listOfSkillsBuffer.append(coachSkills[i]).append(":");
					}
					
					
					Optional<CoachProfile> coachProfileTobeUpdated = coachProfileRepository
							.findById(userFound.get().getId());
					coachProfileTobeUpdated.get().setId(userVO.getId());
					coachProfileTobeUpdated.get().setSkills(listOfSkillsBuffer.toString());
					coachProfileTobeUpdated.get().setAddress1(userVO.getAddress1());
					coachProfileTobeUpdated.get().setAddress2(userVO.getAddress2());
					coachProfileTobeUpdated.get().setCity(userVO.getCity());
					coachProfileTobeUpdated.get().setState(userVO.getState());
					coachProfileTobeUpdated.get().setZipcode(userVO.getZipcode());
					coachProfileTobeUpdated.get().setHomephone(userVO.getHomephone());
					coachProfileTobeUpdated.get().setMobile(userVO.getMobile());
					coachProfileTobeUpdated.get().setAboutme(userVO.getAboutme());
					coachProfileTobeUpdated.get().setEducation(userVO.getEducation());
					coachProfileTobeUpdated.get().setExperience(userVO.getExperience());
					
					coachProfileTobeUpdated.get().setFacebook(userVO.getFacebook());
					coachProfileTobeUpdated.get().setTwitter(userVO.getTwitter());
					coachProfileTobeUpdated.get().setLinkedin(userVO.getLinkedin());
					coachProfileTobeUpdated.get().setWebsitelink(userVO.getWebsitelink());
					coachProfileRepository.save(coachProfileTobeUpdated.get());
				} else {
					System.out.println("====userVO.getCoachSkills()==="+userVO.getCoachSkills());
					CoachProfile coachProfileTobeUpdated = new CoachProfile();
					coachProfileTobeUpdated.setAddress1(userVO.getAddress1());
					coachProfileTobeUpdated.setAddress2(userVO.getAddress2());
					coachProfileTobeUpdated.setCity(userVO.getCity());
					coachProfileTobeUpdated.setState(userVO.getState());
					coachProfileTobeUpdated.setZipcode(userVO.getZipcode());
					coachProfileTobeUpdated.setHomephone(userVO.getHomephone());
					coachProfileTobeUpdated.setMobile(userVO.getMobile());
					coachProfileTobeUpdated.setAboutme(userVO.getAboutme());
					coachProfileTobeUpdated.setEducation(userVO.getEducation());
					coachProfileTobeUpdated.setExperience(userVO.getExperience());
					
					coachProfileTobeUpdated.setSkills(listOfSkillsBuffer.toString());
					coachProfileTobeUpdated.setId(userVO.getId());
					coachProfileRepository.save(coachProfileTobeUpdated);
				}
			}
			// for usertype 'client'
			else if (userFound.get().getUsertype().equalsIgnoreCase("client")) {
				if ((clientProfileRepository.findById(userFound.get().getId())).isPresent()) {
					Optional<ClientProfile> clientProfileTobeUpdated = clientProfileRepository
							.findById(userFound.get().getId());
					clientProfileTobeUpdated.get().setId(userVO.getId());
					clientProfileTobeUpdated.get().setAddress1(userVO.getAddress1());
					clientProfileTobeUpdated.get().setAddress2(userVO.getAddress2());
					clientProfileTobeUpdated.get().setCity(userVO.getCity());
					clientProfileTobeUpdated.get().setState(userVO.getState());
					clientProfileTobeUpdated.get().setZipcode(userVO.getZipcode());
					clientProfileTobeUpdated.get().setHomephone(userVO.getHomephone());
					clientProfileTobeUpdated.get().setMobile(userVO.getMobile());
					clientProfileRepository.save(clientProfileTobeUpdated.get());
				} else {
					ClientProfile clientProfileTobeUpdated = new ClientProfile();
					clientProfileTobeUpdated.setAddress1(userVO.getAddress1());
					clientProfileTobeUpdated.setAddress2(userVO.getAddress2());
					clientProfileTobeUpdated.setCity(userVO.getCity());
					clientProfileTobeUpdated.setState(userVO.getState());
					clientProfileTobeUpdated.setZipcode(userVO.getZipcode());
					clientProfileTobeUpdated.setHomephone(userVO.getHomephone());
					clientProfileTobeUpdated.setMobile(userVO.getMobile());
					clientProfileTobeUpdated.setId(userVO.getId());
					clientProfileRepository.save(clientProfileTobeUpdated);
				}
			}
			
			return ResponseEntity.ok(new MessageResponse("User udpated successfully!"));
			
		} else {
			return (ResponseEntity<Object>) ResponseEntity.badRequest();
		}
	}
	
	@RequestMapping(value = "users/uploadimage/{id}", method = RequestMethod.POST)
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<Object> uploadImage(@RequestParam("file") MultipartFile file, @PathVariable String id) {
		try {
			// Handle the received file here
			// ...
			byte[] bytes = file.getBytes();
			System.out.println("bytes received is " + bytes.toString());
			if (userRepository.findById(Long.parseLong(id)) != null) {
				Optional<User> userFound = userRepository.findById(Long.parseLong(id));
				// If it is a coach, get coachprofile attributes from coachprofile table
				if (userFound.get().getUsertype().equalsIgnoreCase("coach")) {
					if (coachProfileRepository.findById(userFound.get().getId()) != null) {
						Optional<CoachProfile> coachProfileTobeUpdated = coachProfileRepository
								.findById(userFound.get().getId());
						coachProfileTobeUpdated.get().setProfpic(bytes);
						coachProfileRepository.save(coachProfileTobeUpdated.get());
					}
				}
				// If it is a client, get clientprofile attributes from clientprofile table
				else if (userFound.get().getUsertype().equalsIgnoreCase("client")) {
					if (clientProfileRepository.findById(userFound.get().getId()) != null) {
						Optional<ClientProfile> clientTobeUpdated = clientProfileRepository
								.findById(userFound.get().getId());
						clientTobeUpdated.get().setProfpic(bytes);
						clientProfileRepository.save(clientTobeUpdated.get());
					}
				}
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("/users/coachreview")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<Object> submitReviewByClient(@RequestBody CoachReviews coachReviews) {

		System.out.println("coachReviews.getClientid() is " + coachReviews.getClientid());
		System.out.println("coachReviews.getCoachid() is " + coachReviews.getCoachid());
		
		CoachReviews coachReviewByClientIdAndCoachId = coachReviewsRepository
				.findByClientidAndCoachid(coachReviews.getClientid(),coachReviews.getCoachid());
		
		if (coachReviewByClientIdAndCoachId == null)// if no review by the Client then post a new one
		{
			coachReviews.setReview(coachReviews.getReview());
			coachReviews.setClientid(coachReviews.getClientid());
			coachReviews.setCoachid((coachReviews.getCoachid()));
			coachReviewsRepository.save(coachReviews);
			return ResponseEntity.ok(new MessageResponse("Review Submitted successfully!"));

		} else {
			// return (ResponseEntity<Object>) ResponseEntity.badRequest();
			System.out.println("=====Bad request=====");
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/users/coachreview")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<Object> editReviewByClient(@RequestBody CoachReviews coachReviews) {

		System.out.println("coachReviews.getClientid() is " + coachReviews.getClientid());
		System.out.println("coachReviews.getCoachid() is " + coachReviews.getCoachid());

		CoachReviews coachReviewByClientIdAndCoachId = coachReviewsRepository
				.findByClientidAndCoachid(coachReviews.getClientid(), coachReviews.getCoachid());

		if (coachReviewByClientIdAndCoachId != null) {
			coachReviewByClientIdAndCoachId.setReview(coachReviews.getReview());
			coachReviewByClientIdAndCoachId.setRating(coachReviews.getRating());
			coachReviewsRepository.save(coachReviewByClientIdAndCoachId);
			return ResponseEntity.ok(new MessageResponse("Review Edited successfully!"));
		} else {
			// return (ResponseEntity<Object>) ResponseEntity.badRequest();
			System.out.println("=====Bad request=====");
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
	
	/*@GetMapping("/users/{usertype}")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public List<User> getUsersByUsertype(@PathVariable String usertype) {
		return userDetailsService.getUsersByUsertype(usertype);
	}*/
	
	public String[] getArrayOfCoachSkills(String skills) {
		if (skills != null) {
			return skills.split(":");
		} else {
			return new String[0];
		}

	}
	
	@GetMapping("/users/{usertype}")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public List<UserVO> getUsersByUsertype(@PathVariable String usertype) {
		List<UserVO> listOfUserProfiles = new ArrayList<>();
		List<User> listOfUsers = userDetailsService.getUsersByUsertype(usertype);
		for (Iterator iterator = listOfUsers.iterator(); iterator.hasNext();) {
			User user = (User) iterator.next();
			UserVO userProfile = new UserVO();
			userProfile.setId(user.getId());
			userProfile.setFirstname(user.getFirstname());
			userProfile.setLastname(user.getLastname());
			userProfile.setEmail(user.getEmail());
			userProfile.setAge(user.getAge());
			userProfile.setUsername(user.getUsername());
			if (usertype.equalsIgnoreCase("coach")) {
				// Add extra attributes of coachprofile
				if (coachProfileRepository.findById(user.getId()).isPresent()) {
					Optional<CoachProfile> coachProfile = coachProfileRepository.findById(user.getId());
					userProfile.setHomephone(coachProfile.get().getHomephone());
					userProfile.setMobile(coachProfile.get().getMobile());
					userProfile.setAddress1(coachProfile.get().getAddress1());
					userProfile.setAddress2(coachProfile.get().getAddress2());
					userProfile.setCity(coachProfile.get().getCity());
					userProfile.setState(coachProfile.get().getState());
					userProfile.setZipcode(coachProfile.get().getZipcode());
					userProfile.setCoachProfpic(coachProfile.get().getProfpic());
					userProfile.setAboutme(coachProfile.get().getAboutme());
					userProfile.setCoachSkills(getArrayOfCoachSkills(coachProfile.get().getSkills()));
				}

			} else if (usertype.equalsIgnoreCase("client")) {
				// Add extra attributes of clientprofile
				if (clientProfileRepository.findById(user.getId()).isPresent()) {
					Optional<ClientProfile> clientProfile = clientProfileRepository.findById(user.getId());
					userProfile.setHomephone(clientProfile.get().getHomephone());
					userProfile.setMobile(clientProfile.get().getMobile());
					userProfile.setAddress1(clientProfile.get().getAddress1());
					userProfile.setAddress2(clientProfile.get().getAddress2());
					userProfile.setCity(clientProfile.get().getCity());
					userProfile.setState(clientProfile.get().getState());
					userProfile.setZipcode(clientProfile.get().getZipcode());
					userProfile.setClientProfpic(clientProfile.get().getProfpic());
				}
			}

			listOfUserProfiles.add(userProfile);
		}

		return listOfUserProfiles;

	}
	
	
	@GetMapping("/users/userid/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public Optional<User> getUserById(@PathVariable Long id) {
		return userDetailsService.findById(id);
	}
	
	@GetMapping("/users/coachpublicprofile/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public CoachPublicProfileVO getCoachPublicProfileById(@PathVariable Long id) {
		Optional<User> userDetails = userDetailsService.findById(id);
		Optional<CoachProfile> coachProfile=coachProfileRepository.findById(id); 
		
		List<CoachReviews> coachReviews= coachReviewsRepository.findByCoachid(id);
		
		//user details properties
		CoachPublicProfileVO coachPublicProfileVO = new CoachPublicProfileVO();
		coachPublicProfileVO.setFirstname(userDetails.get().getFirstname());
		coachPublicProfileVO.setLastname(userDetails.get().getLastname());
		coachPublicProfileVO.setId(userDetails.get().getId());
		coachPublicProfileVO.setEmail(userDetails.get().getEmail());
		coachPublicProfileVO.setAge(userDetails.get().getAge());
		coachPublicProfileVO.setUsername(userDetails.get().getUsername());
		
		//coach profile properties
		coachPublicProfileVO.setSkills(getArrayOfCoachSkills(coachProfile.get().getSkills()));
		coachPublicProfileVO.setCity(coachProfile.get().getCity());
		coachPublicProfileVO.setProfpic(coachProfile.get().getProfpic());
		coachPublicProfileVO.setHomephone(coachProfile.get().getHomephone());
		coachPublicProfileVO.setMobile(coachProfile.get().getMobile());
		coachPublicProfileVO.setAboutme(coachProfile.get().getAboutme());
		coachPublicProfileVO.setEducation(coachProfile.get().getEducation());
		coachPublicProfileVO.setExperience(coachProfile.get().getExperience());
		coachPublicProfileVO.setFacebook(coachProfile.get().getFacebook());
		coachPublicProfileVO.setTwitter(coachProfile.get().getTwitter());
		coachPublicProfileVO.setYoutube(coachProfile.get().getYoutube());
		coachPublicProfileVO.setLinkedin(coachProfile.get().getLinkedin());
		
		
		//coachreview properties
		coachPublicProfileVO.setCoachReviewsByCoachId(coachReviews);
		
		return coachPublicProfileVO;
	}
	
	@GetMapping("/users/coachprofile/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public CoachProfileVO getCoachProfileById(@PathVariable Long id) {
		Optional<User> userDetails = userDetailsService.findById(id);
		Optional<CoachProfile> coachProfile=coachProfileRepository.findById(id); 

		//user details properties
		CoachProfileVO coachProfileVO = new CoachProfileVO();
		coachProfileVO.setFirstname(userDetails.get().getFirstname());
		coachProfileVO.setLastname(userDetails.get().getLastname());
		coachProfileVO.setId(userDetails.get().getId());
		coachProfileVO.setEmail(userDetails.get().getEmail());
		coachProfileVO.setAge(userDetails.get().getAge());
		coachProfileVO.setUsername(userDetails.get().getUsername());
		
		//coach profile properties
		if (coachProfile.isPresent()) {
			coachProfileVO.setSkills(getArrayOfCoachSkills(coachProfile.get().getSkills()));
			coachProfileVO.setAddress1(coachProfile.get().getAddress1());
			coachProfileVO.setAddress2(coachProfile.get().getAddress2());
			coachProfileVO.setHomephone(coachProfile.get().getHomephone());
			coachProfileVO.setMobile(coachProfile.get().getMobile());
			coachProfileVO.setCity(coachProfile.get().getCity());
			coachProfileVO.setState(coachProfile.get().getState());
			coachProfileVO.setZipcode(coachProfile.get().getZipcode());
			coachProfileVO.setAboutme(coachProfile.get().getAboutme());
			coachProfileVO.setEducation(coachProfile.get().getEducation());
			coachProfileVO.setExperience(coachProfile.get().getExperience());
			coachProfileVO.setProfpic(coachProfile.get().getProfpic());
			coachProfileVO.setWebsitelink(coachProfile.get().getWebsitelink());
			coachProfileVO.setTwitter(coachProfile.get().getTwitter());
			coachProfileVO.setLinkedin(coachProfile.get().getLinkedin());
			coachProfileVO.setFacebook(coachProfile.get().getFacebook());
		}
		
		return coachProfileVO;
	}
	
	@GetMapping("/users/clientprofile/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ClientProfileVO getClientProfileById(@PathVariable Long id) {
		Optional<User> userDetails = userDetailsService.findById(id);
		Optional<ClientProfile> clientProfile = clientProfileRepository.findById(id);

		// user details properties
		ClientProfileVO clientProfileVO = new ClientProfileVO();
		clientProfileVO.setFirstname(userDetails.get().getFirstname());
		clientProfileVO.setLastname(userDetails.get().getLastname());
		clientProfileVO.setId(userDetails.get().getId());
		clientProfileVO.setEmail(userDetails.get().getEmail());
		clientProfileVO.setAge(userDetails.get().getAge());
		clientProfileVO.setUsername(userDetails.get().getUsername());

		// client profile properties
		if (clientProfile.isPresent()) {
			clientProfileVO.setAddress1(clientProfile.get().getAddress1());
			clientProfileVO.setAddress2(clientProfile.get().getAddress2());
			clientProfileVO.setHomephone(clientProfile.get().getHomephone());
			clientProfileVO.setMobile(clientProfile.get().getMobile());
			clientProfileVO.setCity(clientProfile.get().getCity());
			clientProfileVO.setState(clientProfile.get().getState());
			clientProfileVO.setZipcode(clientProfile.get().getZipcode());
			clientProfileVO.setProfpic(clientProfile.get().getProfpic());
		}
		return clientProfileVO;
	}
	
	@GetMapping("/users/clientpublicprofile/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ClientPublicProfileVO getClientPublicProfileById(@PathVariable Long id) {
		Optional<User> userDetails = userDetailsService.findById(id);
		Optional<ClientProfile> clientProfile=clientProfileRepository.findById(id); 
		
		
		//user details properties
		ClientPublicProfileVO clientPublicProfileVO = new ClientPublicProfileVO();
		clientPublicProfileVO.setFirstname(userDetails.get().getFirstname());
		clientPublicProfileVO.setLastname(userDetails.get().getLastname());
		clientPublicProfileVO.setId(userDetails.get().getId());
		clientPublicProfileVO.setEmail(userDetails.get().getEmail());
		clientPublicProfileVO.setAge(userDetails.get().getAge());
		clientPublicProfileVO.setUsername(userDetails.get().getUsername());
		
		//coach profile properties
		if (clientProfile.isPresent()) {
			clientPublicProfileVO.setGrade(clientProfile.get().getGrade());
			clientPublicProfileVO.setCity(clientProfile.get().getCity());
			clientPublicProfileVO.setProfpic(clientProfile.get().getProfpic());
		}
		
		return clientPublicProfileVO;
	}
	
	@GetMapping("/users/coachpublicprofile/reviewavailable/{coachid}/{clientid}")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public boolean isCoachReviewByClientIdAvailable(@PathVariable Long coachid, @PathVariable Long clientid) {
		CoachReviews coachReview = coachReviewsRepository.findByClientidAndCoachid(clientid, coachid);
		System.out.println("====coachReview is===== "+coachReview);
		if (coachReview !=null) {
			return true;
		} else {
			return false;
		}
	}
	
	//There is always one review by a client for a specific coach
	@GetMapping("/users/coachpublicprofile/review/{coachid}/{clientid}")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public CoachReviews getCoachReviewByCoachIdAndClientId(@PathVariable Long coachid, @PathVariable Long clientid) {
		CoachReviews coachReview = coachReviewsRepository.findByClientidAndCoachid(clientid, coachid);
		System.out.println("====coachReview is===== "+coachReview);
		return coachReview;
	}
	
	
	/*@PostMapping("/users/sendemail")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<MessageResponse> sendEmail(@RequestBody SendEmailVO sendEmailVO) {
		
		System.out.println("sendEmailVO.getFromEmailId() is: "+sendEmailVO.getFromEmailId());
		System.out.println("sendEmailVO.getToEmailId() is: "+sendEmailVO.getToEmailId());
		// Email message
		SimpleMailMessage emailMessage = new SimpleMailMessage();
		emailMessage.setFrom(sendEmailVO.getFromEmailId());
		emailMessage.setTo(sendEmailVO.getToEmailId());
		emailMessage.setSubject("Message from " + sendEmailVO.getName());
		emailMessage.setText(sendEmailVO.getMessage());

		
		emailService.sendEmail(emailMessage);
		
		//Save the email message in DB
		System.out.println("Saving message in DB");
		Message message = new Message();
		message.setClientid(Long.parseLong(sendEmailVO.getClientId()));
		message.setCoachid(Long.parseLong(sendEmailVO.getCoachId()));
		message.setFromemail(sendEmailVO.getFromEmailId());
		message.setToemail(sendEmailVO.getToEmailId());
		message.setMessage(sendEmailVO.getMessage());
		message.setName(sendEmailVO.getName());
		messageService.saveMessage(message);
		
		return ResponseEntity.ok(new MessageResponse("Emailhas been sent to  " + sendEmailVO.getToEmailId()));

	}*/
	
	@Autowired
	private JavaMailSender mailSender;
	
	//Working Code with File attachment
	/*@PostMapping(value = "/users/sendemail")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<MessageResponse> sendEmail(@ModelAttribute  SendEmailVO sendEmailVO) {
		
		System.out.println("sendEmailVO.getFromEmailId() is: "+sendEmailVO.getFromEmailId());
		System.out.println("sendEmailVO.getToEmailId() is: "+sendEmailVO.getToEmailId());
		// Email message
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			public void prepare(MimeMessage mimeMessage) throws Exception {
				byte[] bytes = null;


				mimeMessage.setRecipient(javax.mail.Message.RecipientType.TO,
						new InternetAddress(sendEmailVO.getToEmailId()));
				mimeMessage.setFrom(new InternetAddress(sendEmailVO.getFromEmailId()));
				mimeMessage.setSubject("Message from " + sendEmailVO.getName());
				mimeMessage.setText(sendEmailVO.getMessage());

				if (sendEmailVO.getFile() != null) {
					try {
						bytes = sendEmailVO.getFile().getBytes();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					String extension = sendEmailVO.getFile().getOriginalFilename().split("\\.")[1];
					String fileName = sendEmailVO.getFile().getOriginalFilename().split("\\.")[0];
					MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
					helper.addAttachment(fileName + "." + extension, new ByteArrayResource(bytes));
					// helper.addAttachment(sendEmailVO.getFile().getName(), new
					// File(bytes.toString()));
				}
			}
		};

	    try {
	        mailSender.send(preparator);
	    }
	    catch (MailException ex) {
	        // simply log it and go on...
	        System.err.println(ex.getMessage());
	    }
		
		//Save the email message in DB
		System.out.println("Saving message in DB");
		Message message = new Message();
		message.setClientid(Long.parseLong(sendEmailVO.getClientId()));
		message.setCoachid(Long.parseLong(sendEmailVO.getCoachId()));
		message.setFromemail(sendEmailVO.getFromEmailId());
		message.setToemail(sendEmailVO.getToEmailId());
		message.setMessage(sendEmailVO.getMessage());
		message.setName(sendEmailVO.getName());
		message.setSubject(sendEmailVO.getSubject());
		try {
			if (sendEmailVO.getFile() != null) {
				message.setFile(sendEmailVO.getFile().getBytes());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		messageService.saveMessage(message);
		
		return ResponseEntity.ok(new MessageResponse("Emailhas been sent to  " + sendEmailVO.getToEmailId()));

	}*/
	
	
	@PostMapping(value = "/users/sendemail")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<MessageResponse> sendEmail(@ModelAttribute  SendEmailVO sendEmailVO ,@RequestParam(name="file",required = false ) MultipartFile file) {
		
		System.out.println("sendEmailVO.getFromEmailId() is: "+sendEmailVO.getFromEmailId());
		System.out.println("sendEmailVO.getToEmailId() is: "+sendEmailVO.getToEmailId());
		
		// Email message
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			public void prepare(MimeMessage mimeMessage) throws Exception {
				byte[] bytes = null;


				mimeMessage.setRecipient(javax.mail.Message.RecipientType.TO,
						new InternetAddress(sendEmailVO.getToEmailId()));
				mimeMessage.setFrom(new InternetAddress(sendEmailVO.getFromEmailId()));
				mimeMessage.setSubject("Message from " + sendEmailVO.getName());
				mimeMessage.setText(sendEmailVO.getMessage());

				if (file!=null) {
					try {
						bytes = file.getBytes();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					String extension = file.getOriginalFilename().split("\\.")[1];
					String fileName = file.getOriginalFilename().split("\\.")[0];
					MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
					helper.addAttachment(fileName + "." + extension, new ByteArrayResource(bytes));
				}
			}
		};

	    try {
	        mailSender.send(preparator);
	    }
	    catch (MailException ex) {
	        // simply log it and go on...
	        System.err.println(ex.getMessage());
	    }
		
		//Save the email message in DB
		System.out.println("Saving message in DB");
		Message message = new Message();
		message.setClientid(Long.parseLong(sendEmailVO.getClientId()));
		message.setCoachid(Long.parseLong(sendEmailVO.getCoachId()));
		message.setFromemail(sendEmailVO.getFromEmailId());
		message.setToemail(sendEmailVO.getToEmailId());
		message.setMessage(sendEmailVO.getMessage());
		message.setName(sendEmailVO.getName());
		message.setSubject(sendEmailVO.getSubject());
		try {
			if (file !=null) {
				message.setFile(file.getBytes());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		messageService.saveMessage(message);
		
		return ResponseEntity.ok(new MessageResponse("Emailhas been sent to  " + sendEmailVO.getToEmailId()));
	}
	
	@PostMapping(value = "/users/sendinboxemail")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<MessageResponse> sendInboxMessage(@ModelAttribute  SendInboxMessageVO sendInboxMessageVO ,@RequestParam(name="file",required = false ) MultipartFile file) {
		
		System.out.println("sendEmailVO.getFromEmailId() is: "+sendInboxMessageVO.getFromEmailId());
		System.out.println("sendEmailVO.getToEmailId() is: "+sendInboxMessageVO.getToEmailId());
		
		// Email message
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			public void prepare(MimeMessage mimeMessage) throws Exception {
				byte[] bytes = null;


				mimeMessage.setRecipient(javax.mail.Message.RecipientType.TO,
						new InternetAddress(sendInboxMessageVO.getToEmailId()));
				mimeMessage.setFrom(new InternetAddress(sendInboxMessageVO.getFromEmailId()));
				mimeMessage.setSubject(sendInboxMessageVO.getSubject());
				mimeMessage.setText(sendInboxMessageVO.getMessage());

				if (file!=null) {
					try {
						bytes = file.getBytes();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					String extension = file.getOriginalFilename().split("\\.")[1];
					String fileName = file.getOriginalFilename().split("\\.")[0];
					MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
					helper.addAttachment(fileName + "." + extension, new ByteArrayResource(bytes));
				}
			}
		};

	    try {
	        mailSender.send(preparator);
	    }
	    catch (MailException ex) {
	        // simply log it and go on...
	        System.err.println(ex.getMessage());
	    }
		
		//Save the email message in DB
		System.out.println("Saving message in DB");
		Message message = new Message();
		if (sendInboxMessageVO.getUserType().equalsIgnoreCase("client")) {
			message.setClientid(Long.parseLong(sendInboxMessageVO.getId()));
		} else if (sendInboxMessageVO.getUserType().equalsIgnoreCase("coach")) {
			message.setCoachid(Long.parseLong(sendInboxMessageVO.getId()));

		}
		message.setFromemail(sendInboxMessageVO.getFromEmailId());
		message.setToemail(sendInboxMessageVO.getToEmailId());
		message.setMessage(sendInboxMessageVO.getMessage());
		message.setName(sendInboxMessageVO.getName());
		message.setSubject(sendInboxMessageVO.getSubject());
		try {
			if (file !=null) {
				message.setFile(file.getBytes());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		messageService.saveMessage(message);
		
		return ResponseEntity.ok(new MessageResponse("Emailhas been sent to  " + sendInboxMessageVO.getToEmailId()));
	}
	
	
	
	
	@GetMapping("/users/getinboxmessages/{usertype}/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public List<Message> getInboxMessagesById(@PathVariable String usertype, @PathVariable Long id) {
		System.out.println("==========SecurityContextHolder.getContext().getAuthentication().getName()=======:"+SecurityContextHolder.getContext().getAuthentication().getName());
		if (SecurityContextHolder.getContext().getAuthentication().getName() != null) {
			List<Message> inboxMessages = null;
			Optional<User> user = userRepository.findById(id);
			String email = user.get().getEmail();
			if (usertype.equalsIgnoreCase("client")) {
				inboxMessages = messageRepository.findAllByClientidAndToemail(id, email);
			} else if (usertype.equalsIgnoreCase("coach")) {
				inboxMessages = messageRepository.findAllByCoachidAndToemail(id, email);
			}
			return inboxMessages;
		} else
			return null;

	}
	
	
	 /*@RequestMapping("/users/web-socket")
	 //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	    public String getWebSocket() {
	        return "ws-broadcast";
	    }*/
	 
	 
/*	 @MessageMapping("/hello")
	 @SendTo("/topic/greetings")
	  public String greeting(String hello) throws Exception {
	    Thread.sleep(1000); // simulated delay
	    System.out.println("Executed greeting method !!!!");
	    return hello;
	  }
	*/

}
