package com.lax.springjwt.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.apache.commons.lang3.RandomStringUtils;
import org.hibernate.internal.build.AllowSysOut;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.jasypt.util.text.AES256TextEncryptor;
import org.jasypt.util.text.StrongTextEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lax.springjwt.models.ERole;
import com.lax.springjwt.models.Role;
import com.lax.springjwt.models.ClientProfile;
import com.lax.springjwt.models.CoachProfile;
import com.lax.springjwt.models.User;
import com.lax.springjwt.payload.request.LoginRequest;
import com.lax.springjwt.payload.request.SignupRequest;
import com.lax.springjwt.payload.request.SocialLoginRequest;
import com.lax.springjwt.payload.response.JwtResponse;
import com.lax.springjwt.payload.response.MessageResponse;
import com.lax.springjwt.repository.ClientProfileRepository;
import com.lax.springjwt.repository.CoachProfileRepository;
import com.lax.springjwt.repository.RoleRepository;
import com.lax.springjwt.repository.UserRepository;
import com.lax.springjwt.security.jwt.JwtUtils;
import com.lax.springjwt.security.services.UserDetailsImpl;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;
	
	@Autowired
	CoachProfileRepository coachProfileRepository;
	
	@Autowired
	ClientProfileRepository clientProfileRepository;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		//if usertype is 'coach' then add jwt response for coachprofile for the particular userid and same for Clientprofile for usertype 'Client'
		Optional<CoachProfile> coachProfile = coachProfileRepository.findById(userDetails.getId());
		Optional<ClientProfile> ClientProfile = clientProfileRepository.findById(userDetails.getId());
		Object usertypeProfile = null;
		
		
		//usertype as coach
		if (userDetails.getUsertype().equalsIgnoreCase("coach")) {	// usertype is coach
			System.out.println("userDetails.getUsertype()  is====" + userDetails.getUsertype());
			if (coachProfile.isPresent()) {
				if (userDetails.getUsertype().equalsIgnoreCase("coach")) {
					usertypeProfile = coachProfile;
					System.out.println("usertypeProfile is " + usertypeProfile);
				}
			} else {
				CoachProfile coachProfileTemp = new CoachProfile();
				coachProfileTemp.setCity("");
				coachProfileTemp.setSkills("");
				coachProfileTemp.setProfpic(null);
				usertypeProfile = coachProfileTemp;
			}
		}
		
		// usertype as Client
		if (userDetails.getUsertype().equalsIgnoreCase("client")) {
			System.out.println("userDetails.getUsertype()  is====" + userDetails.getUsertype());
			if (ClientProfile.isPresent()) {
				if (userDetails.getUsertype().equalsIgnoreCase("client")) {
					usertypeProfile = ClientProfile;
					System.out.println("usertypeProfile is " + usertypeProfile);
				}

			} else {
				ClientProfile ClientProfileTemp = new ClientProfile();
				ClientProfileTemp.setCity("");
				ClientProfileTemp.setGrade("");
				ClientProfileTemp.setProfpic(null);
				usertypeProfile = ClientProfileTemp;
			}
		}

		return ResponseEntity.ok(new JwtResponse(jwt, 
				 userDetails.getId(), 
				 userDetails.getUsername(), 
				 userDetails.getEmail(),
				 userDetails.getfirstName(),
				 userDetails.getlasttName(),
				 userDetails.getAge(),
				 userDetails.getUsertype(),
				 roles,usertypeProfile));
	
	}

	
	
	
	
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new user's account
		User user = new User(signUpRequest.getUsername(), 
							 signUpRequest.getEmail(),
							 encoder.encode(signUpRequest.getPassword()),signUpRequest.getUsertype());

		Set<String> strRoles = signUpRequest.getRole();
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
		User userCreated = userRepository.save(user);
		

		//Update ClientProfile or CoachProfile based on userType
		if (userCreated.getUsertype().equalsIgnoreCase("client")) {
			ClientProfile clientProfile = new ClientProfile();
			clientProfile.setId(userCreated.getId());
			clientProfileRepository.save(clientProfile);
		} else if (userCreated.getUsertype().equalsIgnoreCase("coach")) {
			CoachProfile coachProfile = new CoachProfile();
			coachProfile.setId(userCreated.getId());
			coachProfileRepository.save(coachProfile);
		}

		

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
	
	
	
	
	public String generateRandomPassword() {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?";
		String pwd = RandomStringUtils.random( 15, characters );
		System.out.println( pwd );
		return pwd;
	}

	@PostMapping("/social/signin")
	public ResponseEntity<?> registerSocialUser(@Valid @RequestBody SocialLoginRequest socialLoginRequest) {

		User user = new User();

		String passwd = generateRandomPassword();
		String encodedPasswd = encoder.encode(passwd);

		System.out.println("socialLoginRequest.getUsername()======== is "+socialLoginRequest.getUsername());
		System.out.println("socialLoginRequest.getEmail()======= is "+socialLoginRequest.getEmail());
		// Find user in table User to check if it exists before creating in the mysql DB
		if (!userRepository.existsByEmail(socialLoginRequest.getEmail())) {
			System.out.println("User Does NOT exist in DB ============== "+socialLoginRequest.getUsername());
			// create user in User table
			user.setUsername(socialLoginRequest.getUsername());
			user.setPassword(encodedPasswd);
			user.setDecryptedpassword(passwd);
			user.setEmail(socialLoginRequest.getEmail());
			user.setSocialuser("true");
			Set<Role> roles = new HashSet<>();
			Role userRole = roleRepository.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
			user.setRoles(roles);
			socialLoginRequest.setUsertype("client");
			if (socialLoginRequest.getUsertype().equalsIgnoreCase("client")) {
				user.setUsertype("client");
			} else {
				user.setUsertype("coach");
			}
			//Save the user before authenticating using authenticationManager
			System.out.println("Goign to save user in DB ============ ");
			userRepository.save(user);
		}
		else// If social user exists, then fetch its encoded password from DB and decode it before authenticating
		{
			Optional<User> userFecthed = userRepository.findByEmail(socialLoginRequest.getEmail());
			passwd = userFecthed.get().getDecryptedpassword();
			System.out.println("Decrypted passwd from DB is ====" + passwd);
		}

		//Optional<User> userFetchedFromDB = userRepository.findByEmail(socialLoginRequest.getEmail());

		//Dummy Authentication
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				socialLoginRequest.getUsername(), passwd));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());

		// if usertype is 'coach' then add jwt response for coachprofile for the
		// particular userid and same for Clientprofile for usertype 'Client'
		Optional<CoachProfile> coachProfile = coachProfileRepository.findById(userDetails.getId());
		Optional<ClientProfile> ClientProfile = clientProfileRepository.findById(userDetails.getId());
		Object usertypeProfile = null;

		// usertype as coach
		if (userDetails.getUsertype().equalsIgnoreCase("coach")) { // usertype is coach
			System.out.println("userDetails.getUsertype()  is====" + userDetails.getUsertype());
			if (coachProfile.isPresent()) {
				if (userDetails.getUsertype().equalsIgnoreCase("coach")) {
					usertypeProfile = coachProfile;
					System.out.println("usertypeProfile is " + usertypeProfile);
				}
			} else {
				CoachProfile coachProfileTemp = new CoachProfile();
				coachProfileTemp.setCity("");
				coachProfileTemp.setSkills("");
				coachProfileTemp.setProfpic(null);
				usertypeProfile = coachProfileTemp;
			}
		}

		// usertype as Client
		if (userDetails.getUsertype().equalsIgnoreCase("client")) {
			System.out.println("userDetails.getUsertype()  is====" + userDetails.getUsertype());
			if (ClientProfile.isPresent()) {
				if (userDetails.getUsertype().equalsIgnoreCase("client")) {
					usertypeProfile = ClientProfile;
					System.out.println("usertypeProfile is " + usertypeProfile);
				}

			} else {
				ClientProfile ClientProfileTemp = new ClientProfile();
				ClientProfileTemp.setCity("");
				ClientProfileTemp.setGrade("");
				ClientProfileTemp.setProfpic(null);
				usertypeProfile = ClientProfileTemp;
			}
		}

		return ResponseEntity.ok(new JwtResponse(
				jwt, 
				userDetails.getId(),
				userDetails.getUsername(),
				userDetails.getEmail(), 
				userDetails.getfirstName(), 
				userDetails.getlasttName(), 
				userDetails.getAge(),
				userDetails.getUsertype(), 
				roles, 
				usertypeProfile));
	}
}
