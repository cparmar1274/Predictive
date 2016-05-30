package interfaces;

import mannyobjects.Location;
import mannyobjects.UserProfile;

public interface IAnalyticsEngine {

	boolean buildUserMatrix();

	Location getCurrentLocation(UserProfile userProfile);
	
}
