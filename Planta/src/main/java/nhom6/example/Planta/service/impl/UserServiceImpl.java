package nhom6.example.Planta.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nhom6.example.Planta.entity.User;
import nhom6.example.Planta.payload.response.UserResponse;
import nhom6.example.Planta.repository.UserRepository;
import nhom6.example.Planta.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserResponse getUserByToken(String token) {
		User user = userRepository.getUserByToken(token);
		UserResponse userResponse = new UserResponse(user.getName(),user.getPhone(),user.getAddress(),user.getEmail(),user.getToken());
		return userResponse;
	}
	
	public UserResponse login(User userRequest) {
		User user = userRepository.findByUsernameAndPassword(userRequest.getUsername(), userRequest.getPassword());
		UserResponse userResponse = new UserResponse(user.getName(),user.getPhone(),user.getAddress(),user.getEmail(),user.getToken());
		return userResponse;
	}
	
	public int register(User userRequest) {
		if(userRepository.findByUsernameAndPassword(userRequest.getUsername(), userRequest.getPassword()) == null)
			return userRepository.register(userRequest.getAddress(),userRequest.getEmail(),userRequest.getName(),userRequest.getPassword(),userRequest.getPhone(),userRequest.getUsername());
		else {
			return 0;
		}
	}

	@Override
	public int updateUser(User userRequest) {
		return userRepository.update(userRequest.getAddress(), userRequest.getEmail(), userRequest.getName(), userRequest.getPhone(), userRequest.getId());
	}

	@Override
	public int updateUserToken(User userRequest) {
		return userRepository.updateToken(userRequest.getToken(), userRequest.getId());
	}

	@Override
	public int updateUserPassword(User userRequest) {
		return userRepository.updatePassword(userRequest.getPassword(), userRequest.getId());
	}
}
