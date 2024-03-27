package nhom6.example.Planta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nhom6.example.Planta.entity.MySchedule;
import nhom6.example.Planta.payload.ApiResponse;
import nhom6.example.Planta.payload.request.MyScheduleRequest;
import nhom6.example.Planta.service.MyScheduleService;

@CrossOrigin
@RestController
@RequestMapping("/api/schedule")
public class MyScheduleController {
	
	@Autowired
	private MyScheduleService myScheduleService;
	
	@PostMapping
    public ApiResponse<MySchedule> createUser(@RequestBody MyScheduleRequest request){
        ApiResponse<MySchedule> apiResponse = new ApiResponse<>();
    	apiResponse.setResult(myScheduleService.createMySchedule(request));
    	apiResponse.setSuccess(true);
    	apiResponse.setMessage("success");
    	apiResponse.setCode(200);
    	return apiResponse;
    }
	
	@GetMapping("/user/{id}")
	public ResponseEntity<List<MySchedule>>getListMyScheduleByIdUser(@PathVariable int id){
		List<MySchedule> plants = myScheduleService.getListMyScheduleByIdUser(id);
		return new ResponseEntity<>(plants, HttpStatus.OK);
	}
	
	@GetMapping("/plant/{id}")
	public ResponseEntity<List<MySchedule>>getListMyScheduleByIdMyPlant(@PathVariable int id){
		List<MySchedule> mySchedules = myScheduleService.getListMyScheduleByIdMyPlant(id);
		return new ResponseEntity<>(mySchedules, HttpStatus.OK);
	}
	
	@GetMapping("/{myScheduleId}")
    public ApiResponse<MySchedule> getMySchedule(@PathVariable int myScheduleId){
        
		return ApiResponse.<MySchedule>builder()
				.code(200)
				.success(true)
				.message("success")
				.result(myScheduleService.getMySchedule(myScheduleId))
				.build();
    }
	
	@PutMapping("/{myScheduleId}")
    public ApiResponse<MySchedule> updateMySchedule(@PathVariable int myScheduleId, @RequestBody MyScheduleRequest request){
        
		return ApiResponse.<MySchedule>builder()
				.code(200)
				.success(true)
				.message("success")
				.result(myScheduleService.updateMySchedule(myScheduleId, request))
				.build();
    }
	
	@DeleteMapping("/{myScheduleId}")
	public String deleteMySchedule(@PathVariable int myScheduleId) {
		myScheduleService.deleteMySchedule(myScheduleId);
		return "My Schedule has been deleted";
	}

}
