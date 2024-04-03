package nhom6.example.Planta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nhom6.example.Planta.entity.User;
import nhom6.example.Planta.payload.ApiResponse;
import nhom6.example.Planta.payload.response.UserResponse;
import nhom6.example.Planta.service.UserService;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
	public ApiResponse<UserResponse> login(@RequestBody User user){
		System.out.println(user);
		UserResponse userResponse = userService.login(user);
		ApiResponse<UserResponse> apiResponse;
		if(userResponse != null) {
			apiResponse = ApiResponse.<UserResponse>builder()
					.success(true)
					.code(200)
					.message("Login success!")
					.result(userResponse)
					.build();
		}
		else {
			apiResponse = ApiResponse.<UserResponse>builder()
					.success(false)
					.code(200)
					.message("Username or password wrong!")
					.result(null)
					.build();
		}
		return apiResponse;
	}
	
	@PostMapping("/register")
	public ApiResponse<UserResponse> register(@RequestBody User user){
		int check = userService.register(user);
		ApiResponse<UserResponse> apiResponse;
		if(check > 0) {
			UserResponse userResponse = new UserResponse(user.getId(), user.getName(),user.getPhone(),user.getAddress(),user.getEmail(),user.getToken());
			apiResponse = ApiResponse.<UserResponse>builder()
					.success(true)
					.code(200)
					.message("Register success!")
					.result(userResponse)
					.build();
		}
		else{
			apiResponse = ApiResponse.<UserResponse>builder()
					.success(false)
					.code(404)
					.message("Account already exist!")
					.result(null)
					.build();
		}
		
		return apiResponse;
	}
	
//	@PutMapping("/update/information")
//	public ApiResponse<UserResponse> updateInformation(@RequestBody User user){
//		int check = userService.updateUser(user);
//		ApiResponse<UserResponse> apiResponse;
//		if(check > 0) {
//			UserResponse userResponse = new UserResponse(user.getId(), user.getName(),user.getPhone(),user.getAddress(),user.getEmail(),user.getToken());
//			apiResponse = ApiResponse.<UserResponse>builder()
//					.success(true)
//					.code(200)
//					.message("Update information success!")
//					.result(userResponse)
//					.build();
//		}
//		else{
//			apiResponse = ApiResponse.<UserResponse>builder()
//					.success(false)
//					.code(404)
//					.message("Update information fail!")
//					.result(null)
//					.build();
//		}
//		
//		return apiResponse;
//	}
	
	@PatchMapping("/update/information")
	public ApiResponse<UserResponse> updateInformation(@RequestBody User user){
		int check = userService.updateUser(user);
		ApiResponse<UserResponse> apiResponse;
		if(check > 0) {
			UserResponse userResponse = new UserResponse(user.getId(), user.getName(),user.getPhone(),user.getAddress(),user.getEmail(),user.getToken());
			apiResponse = ApiResponse.<UserResponse>builder()
					.success(true)
					.code(200)
					.message("Update information success!")
					.result(userResponse)
					.build();
		}
		else{
			apiResponse = ApiResponse.<UserResponse>builder()
					.success(false)
					.code(404)
					.message("Update information fail!")
					.result(null)
					.build();
		}
		
		return apiResponse;
	}
	
	@PutMapping("/update/password")
	public ApiResponse<UserResponse> updatePassword(@RequestBody User user){
		int check = userService.updateUserPassword(user);
		ApiResponse<UserResponse> apiResponse;
		if(check > 0) {
			UserResponse userResponse = new UserResponse(user.getId(), user.getName(),user.getPhone(),user.getAddress(),user.getEmail(),user.getToken());
			apiResponse = ApiResponse.<UserResponse>builder()
					.success(true)
					.code(200)
					.message("Update password success!")
					.result(userResponse)
					.build();
		}
		else{
			apiResponse = ApiResponse.<UserResponse>builder()
					.success(false)
					.code(404)
					.message("Update password fail!")
					.result(null)
					.build();
		}
		
		return apiResponse;
	}
}
