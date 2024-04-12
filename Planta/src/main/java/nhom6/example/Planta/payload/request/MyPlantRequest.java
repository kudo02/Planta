package nhom6.example.Planta.payload.request;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import nhom6.example.Planta.payload.response.MyPlantResponse;
import nhom6.example.Planta.payload.response.PlantResponseOfMyPlant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MyPlantRequest {

	private int id;
	private String name;
	private Date grownDate;
	private String kindOfLight;
	private String image;
	private PlantResponseOfMyPlant plantResponseOfMyPlant;
}