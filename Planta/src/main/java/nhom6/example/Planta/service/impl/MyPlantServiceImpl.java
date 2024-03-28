package nhom6.example.Planta.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nhom6.example.Planta.entity.MyPlant;
import nhom6.example.Planta.entity.User;
import nhom6.example.Planta.payload.response.MyPlantResponse;
import nhom6.example.Planta.payload.response.PlantResponse;
import nhom6.example.Planta.repository.MyPlantRepository;
import nhom6.example.Planta.service.MyPlantService;

@Service
public class MyPlantServiceImpl implements MyPlantService {

	@Autowired
	private MyPlantRepository myPlantRepository;
	
	
	@Override
	public List<MyPlantResponse> getAllMyPlantByUser(User user){
		List<MyPlant> myPlants = myPlantRepository.getAllMyPlantByUser(user.getId());

		List<MyPlantResponse> myPlantResponses = new ArrayList<>();
		for(MyPlant myPlant : myPlants) {
			PlantResponse plantResponse = new PlantResponse();
			plantResponse.setId(myPlant.getPlant().getId());
			plantResponse.setName(myPlant.getPlant().getName());
			plantResponse.setTypePlant(myPlant.getPlant().getTypePlant());
			plantResponse.setMainImage(myPlant.getPlant().getMainImage());
			
			MyPlantResponse myPlantResponse = new MyPlantResponse();
			myPlantResponse.setId(myPlant.getId());
			myPlantResponse.setName(myPlant.getName());
			myPlantResponse.setGrownDate(myPlant.getGrownDate());
			myPlantResponse.setKindOfLight(myPlant.getKindOfLight());
			myPlantResponse.setImage(myPlant.getImage());
			myPlantResponse.setPlantResponse(plantResponse);
			
			myPlantResponses.add(myPlantResponse);
		}

		return myPlantResponses;
	}
	
	@Override
	public MyPlantResponse getMyPlantByUser(User user, int id) {
		MyPlant myPlant = myPlantRepository.getMyPlantByUser(user.getId(), id);
		
		PlantResponse plantResponse = new PlantResponse();
		plantResponse.setId(myPlant.getPlant().getId());
		plantResponse.setName(myPlant.getPlant().getName());
		plantResponse.setTypePlant(myPlant.getPlant().getTypePlant());
		plantResponse.setMainImage(myPlant.getPlant().getMainImage());
		
		MyPlantResponse myPlantResponse = new MyPlantResponse();
		myPlantResponse.setId(myPlant.getId());
		myPlantResponse.setName(myPlant.getName());
		myPlantResponse.setGrownDate(myPlant.getGrownDate());
		myPlantResponse.setKindOfLight(myPlant.getKindOfLight());
		myPlantResponse.setImage(myPlant.getImage());
		myPlantResponse.setPlantResponse(plantResponse);
		
		return myPlantResponse;
	}

	@Override
	public boolean addMyPlant(MyPlant myPlant) {
		int check = myPlantRepository.addMyPlant(myPlant.getGrownDate(), myPlant.getImage(), myPlant.getKindOfLight(), myPlant.getName(), 
				myPlant.getPlant().getId(), myPlant.getUser().getId());
		if(check > 0) 
			return true;
		else
			return false;
	}

	@Override
	public boolean updateMyPlant(MyPlant myPlant) {
		int check = myPlantRepository.updateMyPlant(myPlant.getGrownDate(), myPlant.getImage(), myPlant.getKindOfLight(), myPlant.getName(), myPlant.getId());
		if(check > 0) 
			return true;
		else
			return false;
	}

	@Override
	public boolean deleteMyPlant(int id) {
		int check = myPlantRepository.deleteMyPlant(id);
		if(check > 0) 
			return true;
		else
			return false;
	}
}
