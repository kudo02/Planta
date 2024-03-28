package nhom6.example.Planta.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nhom6.example.Planta.entity.MyPlant;
import nhom6.example.Planta.entity.MySchedule;
import nhom6.example.Planta.payload.request.MyScheduleRequest;
import nhom6.example.Planta.repository.MyPlantRepository;
import nhom6.example.Planta.repository.MyScheduleRepository;
import nhom6.example.Planta.service.MyScheduleService;

@Service
public class MyScheduleServiceImpl implements MyScheduleService {
	
	@Autowired
	private MyScheduleRepository myScheduleRepository;
	
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
		
		return myScheduleRepository.save(mySchedule);
	}
	
	@Override
	public MySchedule updateMySchedule(int myScheduleId, MyScheduleRequest request) {
		MySchedule mySchedule = getMySchedule(myScheduleId);
		
		mySchedule.setName(request.getName());
		mySchedule.setStartDate(request.getStartDate());
		mySchedule.setEndDate(request.getEndDate());
		mySchedule.setTime(request.getTime());
		mySchedule.setFrequency(request.getFrequency());
		
		return myScheduleRepository.save(mySchedule);
	}
	
	@Override
	public MySchedule getMySchedule(int myScheduleId) {
		return myScheduleRepository.findById(myScheduleId)
				.orElseThrow(() -> new RuntimeException("Not found"));
	}
	
	@Override
	public List<MySchedule> getListMyScheduleByIdUser(int id) {
		return myScheduleRepository.findByUserId(id)
				.orElseThrow(() -> new RuntimeException("Not found"));
	}
	
	@Override
	public List<MySchedule> getListMyScheduleByIdMyPlant(int id) {
	
		return myScheduleRepository.findByMyPlantId(id)
				.orElseThrow(() -> new RuntimeException("Not found"));
	}
	
	@Override
	public void deleteMySchedule(int myScheduleId) {
		myScheduleRepository.deleteById(myScheduleId);
	}
	
	private MyPlant getMyPlant(int myPlantId) {
		return myPlantRepository.findById(myPlantId)
				.orElseThrow(() -> new RuntimeException("Not found"));
	}
}
