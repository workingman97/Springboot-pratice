package net.codejava.controllers;

import org.springframework.http.MediaType;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import net.codejava.entity.AuthRequest;
import net.codejava.entity.JwtResponse;
import net.codejava.entity.User;
import net.codejava.repo.UserRepository;
import net.codejava.util.JwtUtil;

@Controller
public class AppController {
	
	@Autowired
	private UserRepository repo;
	
	@Autowired 
	JwtUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	

	
	@GetMapping("/register")
	public String showSignUpForm(Model model) {
		model.addAttribute("user", new User());
		return "signup_form";
	}
	
	@PostMapping("/process_register")
	public String processRegister(User user) {
	    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    String encodedPassword = passwordEncoder.encode(user.getPassword());
	    user.setPassword(encodedPassword);
	     
	    repo.save(user);
	     
	    return "register_success";
	}
	
	@GetMapping("/list_users")
	public String listUsers(Model model) {
	    List<User> listUsers = repo.findAll();
	    model.addAttribute("listUsers", listUsers);
	     
	    return "users";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
	    User user = repo.findById(id)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	    repo.delete(user);
	    List<User> listUsers = repo.findAll();
	    model.addAttribute("listUsers", listUsers);
	     
	    return "users";
	}
	
	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, @RequestHeader("Authorization") String authHeader, Model model) {
		
	    User user = repo.findById(id)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	    
	    model.addAttribute("user", user);
	    System.out.println("Edit user "+ user.getId());
	    System.out.println("with authHeader "+ authHeader);
	    return "update-user";
	}
	
	@PostMapping("/update/{id}")
	public String updateUser(@PathVariable("id") long id, User user,  Model model) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    String encodedPassword = passwordEncoder.encode(user.getPassword());
	    user.setPassword(encodedPassword);
	    repo.save(user);
	    List<User> listUsers = repo.findAll();
	    model.addAttribute("listUsers", listUsers);
	    return "users";
	}
	
	@PostMapping(path = "/authenticate", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> generateToken(@RequestBody AuthRequest authRequest) throws Exception {
		System.out.println("/authenticate" + authRequest.getUsername()+" "+authRequest.getPassword());
		try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("invalid username or password");
        }
		final String token = jwtUtil.generateToken(authRequest.getUsername());
		System.out.println(token);
		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	

}
