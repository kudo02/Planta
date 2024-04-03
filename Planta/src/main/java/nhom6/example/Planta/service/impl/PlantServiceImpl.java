package nhom6.example.Planta.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nhom6.example.Planta.entity.Plant;
import nhom6.example.Planta.payload.response.PlantResponse;
import nhom6.example.Planta.repository.PlantRepository;
import nhom6.example.Planta.service.PlantService;

@Service
public class PlantServiceImpl implements PlantService {

	@Autowired
	private PlantRepository plantRepository;
	
	@Override
	public Plant getPlantDetail(int id) {
		return plantRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Not found"));
	}
	
	@Override
	public List<PlantResponse> getListPlants() {
        List<PlantResponse> allPlants = plantRepository.findAllProjected();
        
        if (allPlants.isEmpty()) {
            return allPlants;
        }
        
        long seed = System.nanoTime(); // Sử dụng seed từ thời gian hiện tại để tạo số ngẫu nhiên
        Collections.shuffle(allPlants, new Random(seed));
        
        return allPlants;
    }
}
