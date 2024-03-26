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
import nhom6.example.Planta.service.MyScheduleService;

@CrossOrigin
@RestController
@RequestMapping("/api/schedule/")
public class MyScheduleController {
	
	@Autowired
	private MyScheduleService myScheduleService;
	
	@GetMapping("user/{id}")
	public ResponseEntity<List<MySchedule>>getListMyScheduleByIdUser(@PathVariable int id){
		List<MySchedule> plants = myScheduleService.getListMyScheduleByIdUser(id);
		return new ResponseEntity<>(plants, HttpStatus.OK);
	}
	
	@GetMapping("plant/{id}")
	public ResponseEntity<List<MySchedule>>getListMyScheduleByIdMyPlant(@PathVariable int id){
		List<MySchedule> mySchedules = myScheduleService.getListMyScheduleByIdMyPlant(id);
		return new ResponseEntity<>(mySchedules, HttpStatus.OK);
	}

}
