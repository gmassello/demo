package automation.logging;

import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

public class Logging {
	
	private  FileHandler fileTxt;
	private  CustomFormatter formatterTxt;
	private  Logger logger;
	private static Logging instance = null;

	
	/**
	 * Logging constructor
	 */
	private Logging() {
		try {
			logger = Logger.getAnonymousLogger();
			fileTxt = new FileHandler("Logging.txt");
			formatterTxt = new CustomFormatter();
			fileTxt.setFormatter(formatterTxt);
			logger.addHandler(fileTxt);
		} catch (Exception ex) {
			System.out.println("An error has occur during the Logger setUp "+ex.getMessage());
		}
	}
	
	
	/**
	 * Creates the instance
	 */
	private synchronized static void createInstance() {
        if (instance == null) { 
        	instance = new Logging();
        }
    }
 
	/**
	 * Returns the instance
	 * @return instance
	 */
    public static Logging getInstance() {
        if (instance == null) createInstance();
        return instance;
    }
    
    /**
	 * Returns the current logger
	 * @return logger
	 */
    public Logger getLogger(){
    	return logger;
    }
    
    /**
     * Close handlers
     */
    public static void closeHandler() {
    	Logger logger = Logging.getInstance().getLogger();
        Handler[] handlers = logger.getHandlers();
        for (Handler h : handlers) {
            try {
                h.close();
            } catch (SecurityException e) {}
        }
    }

}
