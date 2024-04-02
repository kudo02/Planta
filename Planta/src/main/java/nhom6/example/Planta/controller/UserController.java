package nhom6.example.Planta.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nhom6.example.Planta.entity.User;
import nhom6.example.Planta.service.UserService;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {
	
	@Autowired
	private UserService userService;
	
//	@PostMapping("/login")
//	public ResponseEntity<String> login(@RequestBody User user){
//		try {
//			User loginUser = userService.loginUser(user);
//			return ResponseEntity.ok().body("{\"status\": \"success\", \"message\": \"Login successful\"}");
//		} catch (Exception e) {
//			return ResponseEntity.status(404).body("{\"status\": \"failure\", \"message\": \""+ e.getMessage()+"\"}");
//		}
//	}
	
	@PostMapping("/login")
	public User login(@RequestBody User user){
		try {
			System.out.println(user);
			return userService.loginUser(user);
		} catch (Exception e) {
			return null;
		}
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody User user){
		try {
			User registerUser = userService.registerUser(user);
			return ResponseEntity.ok().body("{\"status\": \"success\", \"message\": \"Register successful\"}");
		} catch (Exception e) {
			return ResponseEntity.status(404).body("{\"status\": \"failure\", \"message\": \""+ e.getMessage()+"\"}");
		}
	}
	
	@PatchMapping("/{id}")
    public User updateProductFields(@PathVariable int id,@RequestBody Map<String, Object> fields){
//		Gson gson = new Gson(); //String json
//        Type type = new TypeToken<Map<String, Object>>(){}.getType();
//        Map<String, Object> fields = gson.fromJson(json, type);
        return userService.updateUserByFields(id,fields);
    }
}
