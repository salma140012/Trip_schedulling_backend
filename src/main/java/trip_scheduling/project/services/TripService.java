package trip_scheduling.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import trip_scheduling.project.entities.Trip;
import trip_scheduling.project.repositories.TripRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TripService {
	private final TripRepository tripR;

	@Autowired
	public TripService(TripRepository tripRepository) {
		this.tripR = tripRepository;
	}

	public String makeTrip(Trip tr) {
		tripR.save(tr);
		return "Trip created successfuly!";
	}

	public List<Trip> listAllTrips() {
		return tripR.findAll();

	}

	public String tripUpdate(Long id_trip, Trip tr) {
		boolean yes = tripR.existsById(id_trip);
		if (!yes) {
			throw new IllegalStateException("Trip with id " + id_trip + " does not exist");
		}
		for (int i = 0; i < tripR.findAll().size(); i++) {
			if (tripR.findAll().get(i).getIdTrip().equals(id_trip)) {
				Trip updateTrip = tripR.findAll().get(i);
				updateTrip.setStartTime(tr.getStartTime());
				updateTrip.setEndTime(tr.getEndTime());
				updateTrip.setFromStation(tr.getFromStation());
				updateTrip.setToStation(tr.getToStation());
				tripR.save(updateTrip);
			}

		}
		return "Trip Specified has been updated.";
	}

	public String tripDelete(Long id_trip) {
		boolean yes = tripR.existsById(id_trip);
		if (!yes) {
			throw new IllegalStateException("Trip with id " + id_trip + " does not exist or already has been deleted");
		}
		tripR.deleteById(id_trip);
		return "Trip specified has been deleted.";
	}

	public Optional<Trip> getTrip(Long id_trip) {
		Optional<Trip> tr=tripR.findById(id_trip);
		return tr;
	}
}
