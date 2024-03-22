package nhom6.example.Planta.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nhom6.example.Planta.entity.Plant;
import nhom6.example.Planta.payload.PlantRequest;
import nhom6.example.Planta.respository.PlantRespository;
import nhom6.example.Planta.service.PlantService;

@Service
public class PlantServiceImpl implements PlantService {

	@Autowired
	private PlantRespository plantRespository;
	
	@Override
	public Plant getPlantDetail(int id) {

		return plantRespository.findById(id).orElse(null);
	}
	
	@Override
	public List<PlantRequest> getListPlants() {
	
		return plantRespository.findAllProjected();
	}
}
