package analytics;

import interfaces.IAnalyticsEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import mannyobjects.Location;
import mannyobjects.UserMatrix;
import mannyobjects.UserProfile;

public class AnalyticsEngine implements IAnalyticsEngine {

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

	}

	// fetch users' historic locations
	private static List<Location> getLocations(UUID userId) {
		return new ArrayList<Location>();
	}

}
