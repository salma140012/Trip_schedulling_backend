package trip_scheduling.project.entities;

import javax.persistence.*;

@Entity
@Table
public class Trip {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTrip;
	private String startTime;
	private String endTime;
	private String toStation;
	private String fromStation;

	public Trip(String startTime, String endTime, String toStation, String fromStation) {
		this.startTime = startTime;
		this.endTime = endTime;
		this.toStation = toStation;
		this.fromStation = fromStation;
	}

	public Trip() {
	}

	public Long getIdTrip() {
		return idTrip;
	}

	public void setIdTrip(Long idTrip) {
		this.idTrip = idTrip;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getToStation() {
		return toStation;
	}

	public void setToStation(String toStation) {
		this.toStation = toStation;
	}

	public String getFromStation() {
		return fromStation;
	}

	public void setFromStation(String fromStation) {
		this.fromStation = fromStation;
	}

}
