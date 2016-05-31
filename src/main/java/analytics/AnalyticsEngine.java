package analytics;

import interfaces.IAnalyticsEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import mannyobjects.Location;
import mannyobjects.UserMatrix;
import mannyobjects.UserProfile;

@Service
public class AnalyticsEngine implements IAnalyticsEngine {

	public AnalyticsEngine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean buildUserMatrix() {
		List<UserProfile> users = new ArrayList<UserProfile>();

		// get user profiles
		UserMatrix userMatrix = null;
		int updateSuccess = 0;
		for (UserProfile user : users) {
			try {
				AnalyticsEngine.updateCurrentLocation(user);
				updateSuccess++;
			} catch (Exception ex) {
				// log record of failed updated users
				ex.printStackTrace();
			}
		}
		return (users.size() == updateSuccess);
	}

	public Location getCurrentLocation(UserProfile userProfile) {
		UserMatrix userMatrix = new UserMatrix();
		return userMatrix.getCurrentLocation();
	}

	// build logic to make best guess of user's current location
	private static void updateCurrentLocation(UserProfile userProfile) {
		List<Location> locations = AnalyticsEngine.getLocations(userProfile
				.getUserId());

		// analyze locations and fill up userLocations map

		Map<Integer, Location> userLocations = new HashMap<Integer, Location>();

		for (int i = 0; i < 24; i++)
			userLocations.put(i, new Location()); // user location at each hour
													// of day

		// fetch user location at 1 to 24 o'clock
		userProfile.getUserMatrix().setUserLocations(userLocations);

	}

	// fetch users' historic locations
	private static List<Location> getLocations(UUID userId) {
		return new ArrayList<Location>();
	}

}
