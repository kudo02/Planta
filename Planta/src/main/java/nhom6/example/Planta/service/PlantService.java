package nhom6.example.Planta.service;

import java.util.List;

import nhom6.example.Planta.entity.Plant;
import nhom6.example.Planta.payload.PlantRequest;

public interface PlantService {

	public Plant getPlantDetail(int id);
	
	public List<PlantRequest> getListPlants();
}
