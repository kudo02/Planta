package nhom6.example.Planta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nhom6.example.Planta.entity.MyPlant;
import nhom6.example.Planta.entity.User;
import nhom6.example.Planta.service.MyPlantService;

@CrossOrigin
@RestController
@RequestMapping("/api/my_plant")
public class MyPlantController {
	
	@Autowired
	private MyPlantService myPlantService;
	
	@GetMapping("/all")
	public List<MyPlant> getAllMyPlantByUser(@RequestBody User user){
		List<MyPlant> myPlants = myPlantService.getAllMyPlantByUser(user);

		return myPlants;
	}
}
