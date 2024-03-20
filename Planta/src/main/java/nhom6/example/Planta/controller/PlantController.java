package nhom6.example.Planta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nhom6.example.Planta.entity.MySchedule;
import nhom6.example.Planta.entity.Plant;
import nhom6.example.Planta.payload.PlantRequest;
import nhom6.example.Planta.service.MyScheduleService;
import nhom6.example.Planta.service.PlantService;

@CrossOrigin
@RestController
@RequestMapping("/api/plant/")
public class PlantController {
	
	@Autowired
	private PlantService plantService;
	
	@Autowired
	private MyScheduleService myScheduleService;

	@GetMapping("all")
	public ResponseEntity<List<PlantRequest>> getAllPlant(){
		List<PlantRequest>plants = plantService.getListPlants();
		return new ResponseEntity<>(plants, HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Plant> getPlantDetail(@PathVariable int id){
		
	    Plant plant = plantService.getPlantDetail(id);
	    if (plant != null) {
	        return new ResponseEntity<>(plant, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@GetMapping("schedule")
	public ResponseEntity<List<MySchedule>>getListMyScheduleByIdUser(){
		List<MySchedule> plants = myScheduleService.getListMyScheduleByIdUser(1);
		return new ResponseEntity<>(plants, HttpStatus.OK);
	}

}
