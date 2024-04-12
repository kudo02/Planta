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
import nhom6.example.Planta.payload.ApiResponse;
import nhom6.example.Planta.payload.request.MyPlantRequest;
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
	
	@GetMapping("/{id}/all")
	public ApiResponse<List<MyPlantResponse>> getAllMyPlantByUser(@PathVariable("id") int id){
		List<MyPlantResponse> myPlantResponses = myPlantService.getAllMyPlantByUser(id);
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
	
	@GetMapping("/{idUser}/{idMyPlant}")
	public ApiResponse<MyPlantResponse> getMyPlantByUser(@PathVariable("idUser") int idUser, @PathVariable("idMyPlant") int idMyPlant){
		MyPlantResponse myPlantResponse = myPlantService.getMyPlantByUser(idUser, idMyPlant);
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
	
	@PostMapping("/{idUser}/add")
	public ApiResponse<Boolean> addMyPlant(@PathVariable("idUser") int idUser, @RequestBody MyPlantRequest myPlantRequest){
		System.out.println(myPlantRequest);
		boolean check = myPlantService.addMyPlant(idUser, myPlantRequest);
		ApiResponse<Boolean> apiResponse;
		if(check) {
			apiResponse = ApiResponse.<Boolean>builder()
					.success(true)
					.code(200)
					.message("Add my plant success!")
					.result(check)
					.build();
		}
		else {
			apiResponse = ApiResponse.<Boolean>builder()
					.success(false)
					.code(404)
					.message("Add my plant fail!")
					.result(check)
					.build();
		}
		return apiResponse;
	}
	
	@PutMapping("/update/{id}")
	public ApiResponse<Boolean> updateMyPlant(@PathVariable("id") Integer id, @RequestBody MyPlant myPlant){
		System.out.println(myPlant);
		boolean check = myPlantService.updateMyPlant(id, myPlant);
		ApiResponse<Boolean> apiResponse;
		if(check) {
			apiResponse = ApiResponse.<Boolean>builder()
					.success(true)
					.code(200)
					.message("Update my plant success!")
					.result(check)
					.build();
		}
		else {
			apiResponse = ApiResponse.<Boolean>builder()
					.success(false)
					.code(404)
					.message("Update my plant fail!")
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
					.message("Delete my plant success!")
					.result(check)
					.build();
		}
		else {
			apiResponse = ApiResponse.<Boolean>builder()
					.success(false)
					.code(404)
					.message("Delete my plant fail!")
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