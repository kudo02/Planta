package nhom6.example.Planta.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nhom6.example.Planta.entity.MySchedule;
import nhom6.example.Planta.repository.MyScheduleReponsitory;
import nhom6.example.Planta.service.MyScheduleService;

@Service
public class MyScheduleServiceImpl implements MyScheduleService {
	
	@Autowired
	private MyScheduleReponsitory myScheduleReponsitory;
	
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
}
