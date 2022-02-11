package com.zee.zee5app.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zee.zee5app.dto.EROLE;
import com.zee.zee5app.dto.Role;
import com.zee.zee5app.dto.User;
import com.zee.zee5app.exception.AlreadyExistsException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.payload.request.LoginRequest;
import com.zee.zee5app.payload.request.SignupRequest;
import com.zee.zee5app.payload.response.JwtResponse;
import com.zee.zee5app.payload.response.MessageResponse;
import com.zee.zee5app.repository.RoleRepository;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.security.jwt.JwtUtils;
import com.zee.zee5app.security.services.UserDetailsImpl;
import com.zee.zee5app.service.UserService;

@RestController //===> 4  @ResponseBody @Controller
// REST API : RESPONSE wherever we have to share the response that method 
// must be marked with @ResponseBody
//1000emethods ---> @Responsebody--->1000times 
// 
@RequestMapping("/api/auth")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	JwtUtils jwtUtils;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	
	@PostMapping("/signin")
	  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername()
						, loginRequest.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateToken(authentication);
		UserDetailsImpl userDetailsImpl = (UserDetailsImpl) authentication.getPrincipal();
		
		List<String> roles = userDetailsImpl.getAuthorities()
				.stream()
				.map(i->i.getAuthority())
				.collect(Collectors.toList());
		
		
	
		return ResponseEntity.ok(new JwtResponse(jwt,
				userDetailsImpl.getId(),
				userDetailsImpl.getUsername(),
				userDetailsImpl.getEmail(),
				roles));
	}
	
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signupRequest ){
		
		
		if(userRepository.existsByUsername(signupRequest.getUsername())) {
			return ResponseEntity
			          .badRequest()
			          .body(new MessageResponse("Error: Username is already taken!"));
		}
		
		  if (userRepository.existsByEmail(signupRequest.getEmail())) {
		      return ResponseEntity
		          .badRequest()
		          .body(new MessageResponse("Error: Email is already in use!"));
		    }
		  
		  
		  // user's account
		  
		  User user  = new User(signupRequest.getUsername(), 
				  signupRequest.getEmail(), 
				  passwordEncoder.encode(signupRequest.getPassword()),
				  signupRequest.getFirstName(), 
				  signupRequest.getLastName());
		  // retrieving the roles details
		  
		  Set<String> strRoles= signupRequest.getRole();
		  
		  Set<Role> roles = new HashSet<>();
		  
		  if(strRoles ==null) {
			  Role userRole = roleRepository.findByRoleName(EROLE.ROLE_USER)
					  .orElseThrow(
							  ()->new RuntimeException("Error:role not found")
							  );
			  roles.add(userRole);
		  }
		  
		  else {
			  strRoles.forEach(e->{
				  switch (e) {
				case "admin":
					Role roleAdmin	= roleRepository.findByRoleName(EROLE.ROLE_ADMIN)
							  .orElseThrow(
									  ()->new RuntimeException("Error:role not found")
									  );
					roles.add(roleAdmin);
					break;
					
				case "mod":
				Role roleMod	= roleRepository.findByRoleName(EROLE.ROLE_MODERATOR)
					  .orElseThrow(
							  ()->new RuntimeException("Error:role not found")
							  );
			roles.add(roleMod);
			break;
					
					
						

				default:
					 Role userRole = roleRepository.findByRoleName(EROLE.ROLE_USER)
					  .orElseThrow(
							  ()->new RuntimeException("Error:role not found")
							  );
					 roles.add(userRole);
				}
			  });
			  
			  
			  
		  }
		  user.setRoles(roles);
		  userRepository.save(user);
		return ResponseEntity.status(201).body(new MessageResponse("user created successfully"));
		  
		  
		  
		
	}
	
	
//	
//	// adding user info into the table 
//	// info will be shared by the client in terms of JSON object
//	// do we need to read that json Object? ===> yes
//	// where is this json object is available in request?  ==> requestbody
//	// do we need to read that requestbody content ? yes
//	// do we need to transform json object to Java object?yes==> @RequestBody
//	//
//	
//	// do we need to inform that when this method should be called?
//	// for that we have to specify the end point 
//	// 
//	@PostMapping("/addUser")
//	public ResponseEntity<?> addUser(@Valid @RequestBody User register) throws AlreadyExistsException {
//		//1. it should store the rcvd info into DB.
//		
//		User result =	userService.addUser(register);
//		// 2. validation
//		System.out.println(result);
//		return ResponseEntity.status(201).body(result);
//		
//	
//		// 3. return the crispy info to the client.
//		// 4.a. customization in error response
//		// 4.b declartion of custom exception
//		// here we are support to return a json object with status : problem
//		
//	}
//	// insert 20 records
//	
//	// 1. retrieve a specific record
//	
//	@GetMapping("/{id}")
//	public ResponseEntity<?> getUserById(@PathVariable("id") String id) throws IdNotFoundException{
//	User register =	userService.getUserById(id);
//		return ResponseEntity.ok(register);
//	}
//	// 2. retrieving all records
//	
//	@GetMapping("/all")
//	
//	public ResponseEntity<?> getAllUserDetails()  {
//	Optional<List<User>> optional= userService.getAllUserDetails();
//	
//	if(optional.isEmpty()) {
////		Map<String, String> map = new HashMap<>();
////		map.put("message", "no record found");
//		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new MessageResponse("no record found"));
//	}
//		return ResponseEntity.ok(optional.get());
//	}
//	// 3. page wise records
//	

}
