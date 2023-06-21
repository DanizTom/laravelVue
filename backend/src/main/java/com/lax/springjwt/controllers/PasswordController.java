package com.lax.springjwt.controllers;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lax.springjwt.models.ForgotPasswordVO;
import com.lax.springjwt.models.ResetPasswordVO;
import com.lax.springjwt.models.User;
import com.lax.springjwt.payload.response.MessageResponse;
import com.lax.springjwt.repository.UserRepository;
import com.lax.springjwt.security.services.EmailService;
import com.lax.springjwt.security.services.UserDetailsServiceImpl;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class PasswordController {
	
	@Autowired
	UserRepository userRepository;

	@Autowired
	private UserDetailsServiceImpl userService;

	@Autowired
	private EmailService emailService;

	@Autowired(required=true)
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
   /*@Bean
	public BCryptPasswordEncoder passwordEncoderNew() {
		return new BCryptPasswordEncoder();
	}*/
	

	// Display forgotPassword page
/*	@RequestMapping(value = "/forgot", method = RequestMethod.GET)
	public ModelAndView displayForgotPasswordPage() {
		return new ModelAndView("forgotPassword");
    }*/
    
    // Process form submission from forgotPassword page
	//@RequestMapping(value = "/forgot", method = RequestMethod.POST)
	@PostMapping(value = "/forgot")
	//@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<Object> processForgotPasswordForm(@RequestBody ForgotPasswordVO forgotPasswordVO, HttpServletRequest request) {

		// Lookup user in database by e-mail
		Optional<User> optional = userService.findUserByEmail(forgotPasswordVO.getEmail());

		if (!optional.isPresent()) {
			//modelAndView.addObject("errorMessage", "We didn't find an account for that e-mail address.");
			return ResponseEntity.ok(new MessageResponse("We didn't find an account for that e-mail address.::"+forgotPasswordVO.getEmail()));
		} else {
			
			// Generate random 36-character string token for reset password 
			User user = optional.get();
			user.setResettoken(UUID.randomUUID().toString());

			// Save token to database
			userRepository.save(user);

			String appUrl = request.getScheme() + "://" + request.getServerName()+":8080";
			
			// Email message
			SimpleMailMessage passwordResetEmail = new SimpleMailMessage();
			passwordResetEmail.setFrom("support@demo.com");
			passwordResetEmail.setTo(user.getEmail());
			passwordResetEmail.setSubject("Password Reset Request");
			passwordResetEmail.setText("To reset your password, click the link below:\n" + appUrl
					+ "/reset?token=" + user.getResettoken());
			
			emailService.sendEmail(passwordResetEmail);
			return ResponseEntity.ok(new MessageResponse("A password reset link has been sent to " + forgotPasswordVO.getEmail()));

			// Add success message to view
			//modelAndView.addObject("successMessage", "A password reset link has been sent to " + userEmail);
		}

		//modelAndView.setViewName("forgotPassword");
		//return modelAndView;

	}

	// Display form to reset password
/*	@RequestMapping(value = "/reset", method = RequestMethod.GET)
	public ModelAndView displayResetPasswordPage(ModelAndView modelAndView, @RequestParam("token") String token) {
		
		Optional<User> user = userService.findUserByResetToken(token);

		if (user.isPresent()) { // Token found in DB
			modelAndView.addObject("resetToken", token);
		} else { // Token not found in DB
			modelAndView.addObject("errorMessage", "Oops!  This is an invalid password reset link.");
		}

		modelAndView.setViewName("resetPassword");
		return modelAndView;
	}*/

	// Process reset password form
	//@RequestMapping(value = "/reset", method = RequestMethod.POST)
	@PostMapping (value = "/reset")
	//@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<Object> setNewPassword(@RequestBody ResetPasswordVO resetPasswordVO) {

		// Find the user associated with the reset token
		Optional<User> user = userService.findUserByResetToken(resetPasswordVO.getToken());

		// This should always be non-null but we check just in case
		if (user.isPresent()) {
			
			User resetUser = user.get(); 
            
			// Set new password    
            resetUser.setPassword(bCryptPasswordEncoder.encode(resetPasswordVO.getPassword()));
            
			// Set the reset token to null so it cannot be used again
			resetUser.setResettoken(null);

			// Save user
			userRepository.save(resetUser);

			// In order to set a model attribute on a redirect, we must use
			// RedirectAttributes
			//redir.addFlashAttribute("successMessage", "You have successfully reset your password.  You may now login.");
			return ResponseEntity.ok(new MessageResponse("Password reset successfully"));

			//modelAndView.setViewName("redirect:login");
			//return modelAndView;
			
		} else {
			//modelAndView.addObject("errorMessage", "Oops!  This is an invalid password reset link.");
			//modelAndView.setViewName("resetPassword");	
			return ResponseEntity.ok(new MessageResponse("Oops!  This is an invalid password reset link."));
		}
		
		//return modelAndView;
   }
   
    // Going to reset page without a token redirects to login page
/*	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ModelAndView handleMissingParams(MissingServletRequestParameterException ex) {
		return new ModelAndView("redirect:login");
	}*/
}