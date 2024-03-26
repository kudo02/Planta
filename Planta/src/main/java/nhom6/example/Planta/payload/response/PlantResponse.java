package nhom6.example.Planta.payload.response;

public class PlantResponse {
	private int id;
	private String name;
	private String typePlant;
	private String mainImage;
	
	public PlantResponse() {
		super();
	}
	public PlantResponse(int id, String name, String typePlant, String mainImage) {
		super();
		this.id = id;
		this.name = name;
		this.typePlant = typePlant;
		this.mainImage = mainImage;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getTypePlant() {
		return typePlant;
	}
	public String getMainImage() {
		return mainImage;
	}
	
	
}
