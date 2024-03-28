package nhom6.example.Planta.service;

import nhom6.example.Planta.entity.User;
import nhom6.example.Planta.payload.response.UserResponse;

public interface UserService{
	
	public UserResponse getUserByToken(String token);
	public UserResponse login(User user);
	public int register(User user);
	public int updateUser(User user);
	public int updateUserToken(User user);
	public int updateUserPassword(User user);
}
