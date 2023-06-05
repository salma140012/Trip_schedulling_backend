package trip_scheduling.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import trip_scheduling.project.entities.Admin;
import trip_scheduling.project.entities.Station;
import trip_scheduling.project.services.AdminService;
import trip_scheduling.project.services.StationService;
import trip_scheduling.project.entities.Trip;
import trip_scheduling.project.services.TripService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/tripScheduling")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "*")

public class AdminController {
	@Autowired
	private final TripService tripS;
	private final StationService stationS;
	private final AdminService adminS;

	public AdminController(StationService StationS, TripService tripS, AdminService adminS) {
		this.tripS = tripS;
		this.stationS = StationS;
		this.adminS = adminS;
	}

	@PostMapping("/signUp")

	public void addAdmin(@RequestBody Admin ad) {
		adminS.addAdmin(ad);
	}

	@PostMapping("/signIn")
	public ResponseEntity<Admin> adminSignInCheck(@RequestBody Admin ad) {
		return adminS.adminSignInCheck(ad);
	}

	@PostMapping("/stationC")
	public String addStation(@RequestBody Station station) {
		return stationS.addStation(station);
	}

	@GetMapping("/stationR")
	public List<Station> listAllStations() {
		return stationS.listAllStations();

	}

	@GetMapping("stationR/{stationId}")
	public Optional<Station> getStation(@PathVariable("stationId") Long station_id) {
		return stationS.getStation(station_id);

	}

	@PutMapping("/stationU/{stationId}")
	public String stationUpdate(@PathVariable("stationId") Long station_id, @RequestBody Station st) {
		return stationS.stationUpdate(station_id, st);
	}

	@DeleteMapping("/stationD/{stationId}")
	public String stationDelete(@PathVariable("stationId") Long station_id) {
		return stationS.stationDelete(station_id);

	}

	@PostMapping("/tripC")
	public String makeTrip(@RequestBody Trip tr) {
		return tripS.makeTrip(tr);
	}

	@GetMapping("/tripR")
	public List<Trip> listAllTrips() {
		return tripS.listAllTrips();

	}

	@GetMapping("/tripR/{tripId}")
	public Optional<Trip> getTrip(@PathVariable("tripId") Long id_trip) {
		return tripS.getTrip(id_trip);

	}

	@PutMapping("/tripU/{tripId}")
	public String tripUpdate(@PathVariable("tripId") Long id_trip, @RequestBody Trip tr) {
		return tripS.tripUpdate(id_trip, tr);
	}

	@DeleteMapping("/tripD/{tripId}")
	public String tripDelete(@PathVariable("tripId") Long id_trip) {
		return tripS.tripDelete(id_trip);
	}

}