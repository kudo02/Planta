package nhom6.example.Planta.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import nhom6.example.Planta.entity.Plant;
import nhom6.example.Planta.payload.PlantRequest;

@Repository
public interface PlantRespository extends JpaRepository<Plant, Integer> {
	
	@Query("SELECT new nhom6.example.Planta.payload.PlantRequest(p.id, p.name, p.typePlant, p.mainImage) FROM Plant p")
    List<PlantRequest> findAllProjected();
	
}
