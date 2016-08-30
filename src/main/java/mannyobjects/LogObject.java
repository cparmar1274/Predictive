package mannyobjects;

import org.apache.log4j.Logger;

public class LogObject {

	private Logger logger;

	public LogObject(Object object) {
		logger = Logger.getLogger(object.getClass());
	}

	public void logInfo(String... message) {
		this.logger.info(getLogMessage(message));
	}

	public void logDebug(String... message) {
		this.logger.debug(getLogMessage(message));
	}

	public void logError(String... message) {
		this.logger.error(getLogMessage(message));
	}

	private String getLogMessage(String... message) {
		StringBuffer logMessage = new StringBuffer();
		for (String msg : message)
			logMessage.append(msg).append(" - ");
		return logMessage.toString();
	}

}
