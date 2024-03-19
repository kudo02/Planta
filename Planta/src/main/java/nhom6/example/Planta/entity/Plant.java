package nhom6.example.Planta.entity;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "plant")
public class Plant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "typeplant")
	private String typePlant;
	
	@Column(name = "mainimage")
	private String mainImage;
	
	@Column(name = "secondaryimage")
	private String secondaryImage;
	
	@Column(name = "typesoil")
	private String typeSoil;
	
	@Column(name = "keysearch")
	private String keySearch;

	@Column(name = "maturesize")
	private String matureSize;
	
	@Column(name = "maturetime")
	private String matureTime;
	
	@Column(name = "description")
	private String description;
	
	@OneToMany(mappedBy = "plant", cascade = CascadeType.ALL)
	private List<Schedule> schedules;
	
	@OneToMany(mappedBy = "plant", cascade = CascadeType.ALL)
	private List<Weather> weathers;
	
	@OneToMany(mappedBy = "plant", cascade = CascadeType.ALL)
	private List<HarvestSeason> harvestSeasons;
}
