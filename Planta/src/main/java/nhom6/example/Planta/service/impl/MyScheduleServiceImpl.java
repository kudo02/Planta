package nhom6.example.Planta.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nhom6.example.Planta.entity.MyPlant;
import nhom6.example.Planta.entity.MySchedule;
import nhom6.example.Planta.payload.request.MyScheduleRequest;
import nhom6.example.Planta.repository.MyPlantRepository;
import nhom6.example.Planta.repository.MyScheduleReponsitory;
import nhom6.example.Planta.service.MyScheduleService;

@Service
public class MyScheduleServiceImpl implements MyScheduleService {
	
	@Autowired
	private MyScheduleReponsitory myScheduleReponsitory;
	
	@Autowired
	private MyPlantRepository myPlantRepository;
	
	@Override
	public MySchedule createMySchedule(MyScheduleRequest request) {
		
		MySchedule mySchedule = new MySchedule();
		mySchedule.setName(request.getName());
		mySchedule.setStartDate(request.getStartDate());
		mySchedule.setEndDate(request.getEndDate());
		mySchedule.setTime(request.getTime());
		mySchedule.setFrequency(request.getFrequency());
		mySchedule.setMyPlant(getMyPlant(request.getMyPlantId()));
		
		return myScheduleReponsitory.save(mySchedule);
	}
	
	@Override
	public MySchedule updateMySchedule(int myScheduleId, MyScheduleRequest request) {
		MySchedule mySchedule = getMySchedule(myScheduleId);
		
		mySchedule.setName(request.getName());
		mySchedule.setStartDate(request.getStartDate());
		mySchedule.setEndDate(request.getEndDate());
		mySchedule.setTime(request.getTime());
		mySchedule.setFrequency(request.getFrequency());
		
		return myScheduleReponsitory.save(mySchedule);
	}
	
	@Override
	public MySchedule getMySchedule(int myScheduleId) {
		return myScheduleReponsitory.findById(myScheduleId)
				.orElseThrow(() -> new RuntimeException("Not found"));
	}
	
	@Override
	public List<MySchedule> getListMyScheduleByIdUser(int id) {
		
		return myScheduleReponsitory.findByUserId(id)
				.orElseThrow(() -> new RuntimeException("Not found"));
	}
	
	@Override
	public List<MySchedule> getListMyScheduleByIdMyPlant(int id) {
	
		return myScheduleReponsitory.findByMyPlantId(id)
				.orElseThrow(() -> new RuntimeException("Not found"));
	}
	
	@Override
	public void deleteMySchedule(int myScheduleId) {
		myScheduleReponsitory.deleteById(myScheduleId);
	}
	
	private MyPlant getMyPlant(int myPlantId) {
		return myPlantRepository.findById(myPlantId)
				.orElseThrow(() -> new RuntimeException("Not found"));
		
	}
}
