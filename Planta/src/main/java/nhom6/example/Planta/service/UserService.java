package nhom6.example.Planta.service;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import nhom6.example.Planta.entity.User;
import nhom6.example.Planta.repository.UserRepository;

@Service
public class UserService{

	@Autowired
	private UserRepository userRepository;
	
	public User loginUser(User user) {
		return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
	}
	
	public User registerUser(User user) {
		return userRepository.save(user);
	}
	
	public User updateUserByFields(int id, Map<String, Object> fields) {
        Optional<User> existingProduct = userRepository.findById(id);

        if (existingProduct.isPresent()) {
            fields.forEach((key, value) -> {
                Field field = ReflectionUtils.findField(User.class, key);
                field.setAccessible(true);
                ReflectionUtils.setField(field, existingProduct.get(), value);
            });
            return userRepository.save(existingProduct.get());
        }
        return null;
    }
	
}
