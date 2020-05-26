package PowerLifters.PowerLiften.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import PowerLifters.PowerLiften.domein.User;
import PowerLifters.PowerLiften.persistence.UserService;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.websocket.server.PathParam;

@CrossOrigin("*")
@RequestMapping("/user")
@RestController
public class UserEndpoint {
	private final UserService userService;
	
	@Autowired
	public UserEndpoint(UserService userService) {
	    this.userService = userService;
	}
	
	@GetMapping("/all")
	public ResponseEntity getAllUsers() {
		return ResponseEntity.ok(userService.getAllUsers());
	}
	
	@GetMapping("/{username}")
	public ResponseEntity getUserByUsername(@PathParam("username") @NotBlank String username) {
		return ResponseEntity.ok(userService.getUserByUsername(username));
	}
	
	@GetMapping("/exist/{username}")
	public ResponseEntity isUserExist(@PathParam("username") @NotBlank String username) {
		return ResponseEntity.ok(userService.isUserExists(username));
	}
	
	@PostMapping("/add")
	public ResponseEntity addUser(@RequestBody @Valid User user) {
		return ResponseEntity.ok(userService.addUser(user));
	}
	
	@DeleteMapping("/{username}")
	public ResponseEntity deleteUser(@PathParam("username") @NotBlank String username) {
	    return ResponseEntity.ok(userService.deleteUser(username));
	}
	
}
