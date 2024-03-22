package nhom6.example.Planta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nhom6.example.Planta.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	User getUserByToken(String token);
	
	User save(User user);
	
	User findByUsernameAndPassword(String username, String password);
}
