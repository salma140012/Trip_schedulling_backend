package trip_scheduling.project.entities;
import javax.persistence.*;

@Entity
@Table
public class Station {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_station;
	private String name;
	
	public Station() {
		
	}
	public Station(Long id_station, String name) {
		this.id_station = id_station;
		this.name = name;
	}
	
	
	public Long getIdStation() {
		return id_station;
	}
	public void setIdStation(Long id_station) {
		this.id_station = id_station;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	

}