package nhom6.example.Planta.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import nhom6.example.Planta.entity.MySchedule;

@Repository
public interface MyScheduleResponsitory extends JpaRepository<MySchedule, Integer> {
	
	@Query("SELECT ms FROM MySchedule ms JOIN ms.myPlant mp JOIN mp.user u WHERE u.id = :userId")
    List<MySchedule> findByUserId(@Param("userId") int userId);
}
