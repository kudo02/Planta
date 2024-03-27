package nhom6.example.Planta.service;

import java.util.List;

import nhom6.example.Planta.entity.MyPlant;
import nhom6.example.Planta.entity.User;

public interface MyPlantService {

	public List<MyPlant> getAllMyPlantByUser(User user);
	public MyPlant getMyPlantByUser(User user, int id);
}
