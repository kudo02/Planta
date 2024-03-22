package nhom6.example.Planta.payload;

public class PlantRequest {
	private int id;
	private String name;
	private String typePlant;
	private String mainImage;
	
	public PlantRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PlantRequest(int id, String name, String typePlant, String mainImage) {
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
