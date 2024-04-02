package nhom6.example.Planta.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import nhom6.example.Planta.entity.MyPlant;

@Repository
public interface MyPlantRepository extends JpaRepository<MyPlant, Integer>{

	@Query(value = "SELECT * FROM myplant mp WHERE mp.iduser = :idUser", nativeQuery = true)
	List<MyPlant> getAllMyPlantByUser(@Param("idUser") int idUser);
	
	@Query(value = "SELECT * FROM myplant mp WHERE mp.iduser = :idUser AND mp.id = :id", nativeQuery = true)
	MyPlant getMyPlantByUser(@Param("idUser") int idUser, @Param("id") int id);
	
	@Query("SELECT mp FROM MyPlant mp JOIN mp.user u WHERE u.id = :userId")
	Optional<List<MyPlant>> getAllMyPlantByUserId(@Param("userId") int userId);

}
