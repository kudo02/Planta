package nhom6.example.Planta.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nhom6.example.Planta.entity.MyPlant;
import nhom6.example.Planta.entity.User;
import nhom6.example.Planta.repository.MyPlantRepository;
import nhom6.example.Planta.service.MyPlantService;

@Service
public class MyPlantServiceImpl implements MyPlantService {

	@Autowired
	private MyPlantRepository myPlantRepository;
	
	@Override
	public List<MyPlant> getAllMyPlantByUser(User user){
		List<MyPlant> myPlants = myPlantRepository.getAllMyPlantByUser(user.getId());
		return myPlants;
	}
	
	@Override
	public MyPlant getMyPlantByUser(User user, int id) {
		MyPlant myPlant = myPlantRepository.getMyPlantByUser(user.getId(), id);
		return myPlant;
	}
}
