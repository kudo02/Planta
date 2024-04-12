package nhom6.example.Planta.service;

import java.util.List;

import nhom6.example.Planta.entity.MyPlant;
import nhom6.example.Planta.entity.User;
import nhom6.example.Planta.payload.request.MyPlantRequest;
import nhom6.example.Planta.payload.response.CareScheduleResponse;
import nhom6.example.Planta.payload.response.MyPlantResponse;
import nhom6.example.Planta.payload.response.MyPlantScheduleResponse;

public interface MyPlantService {

	public List<MyPlantResponse> getAllMyPlantByUser(int id);
	public MyPlantResponse getMyPlantByUser(int idUser, int idMyPlant);
	public boolean addMyPlant(int idUser, MyPlantRequest myPlantRequest);
	public boolean updateMyPlant(int idUser, MyPlant myPlant);
	public boolean deleteMyPlant(int idMyPlant);
	
	public List<CareScheduleResponse> getAllMyPlantToDayByUser(int userId);
	public List<MyPlantScheduleResponse> getAllMyPlantCalendarByUser(int userId);
}

