package nhom6.example.Planta.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nhom6.example.Planta.entity.MyPlant;
import nhom6.example.Planta.entity.MySchedule;
import nhom6.example.Planta.entity.User;
import nhom6.example.Planta.payload.CareSchedule;
import nhom6.example.Planta.payload.response.CareScheduleResponse;
import nhom6.example.Planta.payload.response.MyPlantScheduleResponse;
import nhom6.example.Planta.repository.MyPlantRepository;
import nhom6.example.Planta.service.MyPlantService;

@Service
public class MyPlantServiceImpl implements MyPlantService {

	@Autowired
	private MyPlantRepository myPlantRepository;
	
	@Override
	public List<MyPlant> getAllMyPlantByUser(User user){
		List<MyPlant> myPlants = myPlantRepository.getAllMyPlantByUser(user.getId());
		return myPlants;
	}
	
	@Override
	public MyPlant getMyPlantByUser(User user, int id) {
		MyPlant myPlant = myPlantRepository.getMyPlantByUser(user.getId(), id);
		return myPlant;
	}
	
	@Override
	public List<CareScheduleResponse> getAllMyPlantToDayByUser(int userId) {
		List<MyPlant> myPlants = myPlantRepository.getAllMyPlantByUserId(userId)
	    		.orElseThrow(() -> new RuntimeException("Not found"));
		
	    Map<String, List<CareSchedule>> groupedSchedules = new HashMap<>();

	    LocalDate todayLocal = LocalDate.now();
	    
	    // Nhóm các CareSchedule theo tên bài tập
	    for (MyPlant myPlant : myPlants) {
	        List<MySchedule> mySchedules = myPlant.getMySchedules();
	        for (MySchedule mySchedule : mySchedules) {
	        	
	        	LocalDate startDateLocal = mySchedule.getStartDate().toLocalDate();
	        	LocalDate endDateLocal = mySchedule.getEndDate().toLocalDate();
	        	
	        	if ((todayLocal.isAfter(startDateLocal) || todayLocal.isEqual(startDateLocal)) && 
	        			(todayLocal.isBefore(endDateLocal) || todayLocal.isEqual(endDateLocal))) {
	        		
	                 long daysBetween = java.time.temporal.ChronoUnit.DAYS.between(startDateLocal, todayLocal);
	                 if (daysBetween % mySchedule.getFrequency() == 0) {
			            String scheduleName = mySchedule.getName();
			            CareSchedule careSchedule = CareSchedule.builder()
			            		.myPlantId(myPlant.getId())
			            		.myPlantName(myPlant.getName())
			            		.image(myPlant.getImage())
			            		.startDate(mySchedule.getStartDate())
			            		.endDate(mySchedule.getEndDate())
			            		.time(mySchedule.getTime())
			            		.frequency(mySchedule.getFrequency())
			            		.build();
		
			            groupedSchedules.computeIfAbsent(scheduleName, k -> new ArrayList<>()).add(careSchedule);
	                 }
	        	 }
	        }
	    }

	    // Tạo danh sách MyCareScheduleResponse từ map đã nhóm
	    List<CareScheduleResponse> scheduleResponses = new ArrayList<>();
	    for (Map.Entry<String, List<CareSchedule>> entry : groupedSchedules.entrySet()) {
	        CareScheduleResponse myCareScheduleResponse = new CareScheduleResponse();
	        myCareScheduleResponse.setName(entry.getKey());
	        myCareScheduleResponse.setCareSchedules(entry.getValue());
	        scheduleResponses.add(myCareScheduleResponse);
	    }

	    return scheduleResponses;
	}
	
	@Override
	public List<MyPlantScheduleResponse> getAllMyPlantCalendarByUser(int userId) {
		List<MyPlant> myPlants = myPlantRepository.getAllMyPlantByUserId(userId)
	    		.orElseThrow(() -> new RuntimeException("Not found"));
		
		List<MyPlantScheduleResponse> myPlantResponses = new ArrayList<>();
		for(MyPlant myPlant : myPlants) {
			MyPlantScheduleResponse myPlantResponse = MyPlantScheduleResponse.builder()
					.id(myPlant.getId())
					.name(myPlant.getName())
					.image(myPlant.getImage())
					.mySchedules(myPlant.getMySchedules())
					.build();
			myPlantResponses.add(myPlantResponse);
		}
		return myPlantResponses;
	}
	
	// Test
	public List<CareScheduleResponse> geMyPlantToDayByUser(int userId) {
	    List<MyPlant> myPlants = myPlantRepository.getAllMyPlantByUserId(userId)
	    		.orElseThrow(() -> new RuntimeException("Not found"));
	    
	    Map<String, List<CareSchedule>> groupedSchedules = new HashMap<>();

	    // Nhóm các CareSchedule theo tên bài tập
	    for (MyPlant myPlant : myPlants) {
	        List<MySchedule> mySchedules = myPlant.getMySchedules();
	        for (MySchedule mySchedule : mySchedules) {
	            String scheduleName = mySchedule.getName();
	            CareSchedule careSchedule = CareSchedule.builder()
	            		.myPlantId(myPlant.getId())
	            		.myPlantName(myPlant.getName())
	            		.image(myPlant.getImage())
	            		.startDate(mySchedule.getStartDate())
	            		.endDate(mySchedule.getEndDate())
	            		.time(mySchedule.getTime())
	            		.frequency(mySchedule.getFrequency())
	            		.build();
	         

	            groupedSchedules.computeIfAbsent(scheduleName, k -> new ArrayList<>()).add(careSchedule);
	        }
	    }

	    // Tạo danh sách MyCareScheduleResponse từ map đã nhóm
	    List<CareScheduleResponse> scheduleResponses = new ArrayList<>();
	    for (Map.Entry<String, List<CareSchedule>> entry : groupedSchedules.entrySet()) {
	        CareScheduleResponse myCareScheduleResponse = new CareScheduleResponse();
	        myCareScheduleResponse.setName(entry.getKey());
	        myCareScheduleResponse.setCareSchedules(entry.getValue());
	        scheduleResponses.add(myCareScheduleResponse);
	    }

	    return scheduleResponses;
	}

}
