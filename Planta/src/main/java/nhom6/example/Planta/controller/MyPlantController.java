package nhom6.example.Planta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nhom6.example.Planta.entity.MyPlant;
import nhom6.example.Planta.entity.User;
import nhom6.example.Planta.payload.ApiResponse;
import nhom6.example.Planta.payload.response.CareScheduleResponse;
import nhom6.example.Planta.payload.response.MyPlantScheduleResponse;
import nhom6.example.Planta.payload.response.MyPlantResponse;
import nhom6.example.Planta.service.MyPlantService;

@CrossOrigin
@RestController
@RequestMapping("/api/my_plant")
public class MyPlantController {
	
	@Autowired
	private MyPlantService myPlantService;
	
	@GetMapping("/all")
	public ApiResponse<List<MyPlantResponse>> getAllMyPlantByUser(@RequestBody User user){
		List<MyPlantResponse> myPlantResponses = myPlantService.getAllMyPlantByUser(user);
		ApiResponse<List<MyPlantResponse>> apiResponse;
		if(myPlantResponses != null) {
			apiResponse = ApiResponse.<List<MyPlantResponse>>builder()
					.success(true)
					.code(200)
					.message("success")
					.result(myPlantResponses)
					.build();
		}
		else {
			apiResponse = ApiResponse.<List<MyPlantResponse>>builder()
					.success(false)
					.code(404)
					.message("fail")
					.result(null)
					.build();
		}
		return apiResponse;
	}
	
	@GetMapping("/{id}")
	public ApiResponse<MyPlantResponse> getMyPlantByUser(@RequestBody User user, @PathVariable("id") int id){
		MyPlantResponse myPlantResponse = myPlantService.getMyPlantByUser(user, id);
		ApiResponse<MyPlantResponse> apiResponse;
		if(myPlantResponse != null) {
			apiResponse = ApiResponse.<MyPlantResponse>builder()
					.success(true)
					.code(200)
					.message("success")
					.result(myPlantResponse)
					.build();
		}
		else {
			apiResponse = ApiResponse.<MyPlantResponse>builder()
					.success(false)
					.code(404)
					.message("fail")
					.result(null)
					.build();
		}
		return apiResponse;
	}
	
	@PostMapping("/add")
	public ApiResponse<Boolean> addMyPlant(@RequestBody MyPlant myPlant){
		boolean check = myPlantService.addMyPlant(myPlant);
		ApiResponse<Boolean> apiResponse;
		if(check) {
			apiResponse = ApiResponse.<Boolean>builder()
					.success(true)
					.code(200)
					.message("Add my plant success")
					.result(check)
					.build();
		}
		else {
			apiResponse = ApiResponse.<Boolean>builder()
					.success(false)
					.code(404)
					.message("Add my plant fail")
					.result(check)
					.build();
		}
		return apiResponse;
	}
	
	@PutMapping("/update")
	public ApiResponse<Boolean> updateMyPlant(@RequestBody MyPlant myPlant){
		boolean check = myPlantService.updateMyPlant(myPlant);
		ApiResponse<Boolean> apiResponse;
		if(check) {
			apiResponse = ApiResponse.<Boolean>builder()
					.success(true)
					.code(200)
					.message("Update my plant success")
					.result(check)
					.build();
		}
		else {
			apiResponse = ApiResponse.<Boolean>builder()
					.success(false)
					.code(404)
					.message("Update my plant fail")
					.result(check)
					.build();
		}
		return apiResponse;
	}
	
	@DeleteMapping("/delete/{id}")
	public ApiResponse<Boolean> deleteMyPlant(@PathVariable("id") int id){
		boolean check = myPlantService.deleteMyPlant(id);
		ApiResponse<Boolean> apiResponse;
		if(check) {
			apiResponse = ApiResponse.<Boolean>builder()
					.success(true)
					.code(200)
					.message("Delete my plant success")
					.result(check)
					.build();
		}
		else {
			apiResponse = ApiResponse.<Boolean>builder()
					.success(false)
					.code(404)
					.message("Delete my plant fail")
					.result(check)
					.build();
		}
		return apiResponse;
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
	
	@GetMapping("/schedule/{userid}")
	public ApiResponse<List<MyPlantScheduleResponse>> getMyPlantScheduleByUser(@PathVariable int userid){
		List<MyPlantScheduleResponse> mPlantScheduleResponses = myPlantService.getMyPlantScheduleByUser(userid);
		
		return ApiResponse.<List<MyPlantScheduleResponse>>builder()
				.code(200)
				.success(true)
				.message("success")
				.result(mPlantScheduleResponses)
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
