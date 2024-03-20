package nhom6.example.Planta.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nhom6.example.Planta.entity.MySchedule;
import nhom6.example.Planta.respository.MyScheduleResponsitory;
import nhom6.example.Planta.service.MyScheduleService;

@Service
public class MyScheduleServiceImpl implements MyScheduleService {
	
	@Autowired
	private MyScheduleResponsitory myScheduleResponsitory;
	
	@Override
	public List<MySchedule> getListMyScheduleByIdUser(int id) {
		
		return myScheduleResponsitory.findByUserId(id);
	}
}
