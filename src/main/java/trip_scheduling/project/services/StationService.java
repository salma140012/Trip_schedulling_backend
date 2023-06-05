package trip_scheduling.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trip_scheduling.project.entities.Station;
import trip_scheduling.project.repositories.StationRepository;
import java.util.List;
import java.util.Optional;

@Service
public class StationService {
	private final StationRepository stationR;

	@Autowired
	public StationService(StationRepository stationR) {
		this.stationR = stationR;
	}

	public String addStation(Station st) {
		stationR.save(st);
		return "Station Added Successfuly!";
	}

	public List<Station> listAllStations() {
		return stationR.findAll();

	}

	public String stationUpdate(Long station_id, Station st) {
		boolean yes = stationR.existsById(station_id);
		if (!yes) {
			throw new IllegalStateException("Station with id " + station_id + " does not exist");
		}
		for (int i = 0; i < stationR.findAll().size(); i++) {
			if (stationR.findAll().get(i).getIdStation().equals(station_id)) {
				Station updateStation = stationR.findAll().get(i);
				updateStation.setName(st.getName());
				stationR.save(updateStation);
			}

		}
		return "Station specified has been updated.";
	}

	public String stationDelete(Long id_station) {
		boolean yes = stationR.existsById(id_station);
		if (!yes) {

			throw new IllegalStateException(
					"Station with id " + id_station + " does not exist or has already been deleted");
		}
		stationR.deleteById(id_station);
		return "Station specified has been deleted.";

	}

	public Optional<Station> getStation(Long station_id) {
		Optional<Station> st = stationR.findById(station_id);
		return st;
	}

}