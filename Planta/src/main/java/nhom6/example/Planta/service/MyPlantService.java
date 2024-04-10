package nhom6.example.Planta.service;

import java.util.List;

import nhom6.example.Planta.entity.MyPlant;
import nhom6.example.Planta.entity.User;
import nhom6.example.Planta.payload.response.CareScheduleResponse;
import nhom6.example.Planta.payload.response.MyPlantResponse;
import nhom6.example.Planta.payload.response.MyPlantScheduleResponse;

public interface MyPlantService {

	public List<MyPlantResponse> getAllMyPlantByUser(User user);
	
	public MyPlantResponse getMyPlantByUser(User user, int id);
	
	public boolean addMyPlant(MyPlant myPlant);
	
	public boolean updateMyPlant(MyPlant myPlant);
	
	public boolean deleteMyPlant(int id);
	
	//
	public List<CareScheduleResponse> getAllMyPlantToDayByUser(int userId);
	
	public List<MyPlantScheduleResponse> getMyPlantScheduleByUser(int userId);
	
	public List<MyPlantScheduleResponse> getAllMyPlantCalendarByUser(int userId);
}

