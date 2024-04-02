package nhom6.example.Planta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nhom6.example.Planta.entity.MyPlant;
import nhom6.example.Planta.entity.User;
import nhom6.example.Planta.payload.ApiResponse;
import nhom6.example.Planta.payload.response.CareScheduleResponse;
import nhom6.example.Planta.payload.response.MyPlantScheduleResponse;
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
	
	@GetMapping("/today/{userid}")
	public ApiResponse<List<CareScheduleResponse>> getMyPlantToDayByUser(@PathVariable int userid){
		List<CareScheduleResponse> myPlants = myPlantService.getAllMyPlantToDayByUser(userid);
		
		return ApiResponse.<List<CareScheduleResponse>>builder()
				.code(200)
				.success(true)
				.message("success")
				.result(myPlants)
				.build();
	}
	
	@GetMapping("/calendar/{userid}")
	public ApiResponse<List<MyPlantScheduleResponse>> getAllMyPlantCalendarByUser(@PathVariable int userid){
		List<MyPlantScheduleResponse> mPlantScheduleResponses = myPlantService.getAllMyPlantCalendarByUser(userid);
		
		return ApiResponse.<List<MyPlantScheduleResponse>>builder()
				.code(200)
				.success(true)
				.message("success")
				.result(mPlantScheduleResponses)
				.build();
	}
}
