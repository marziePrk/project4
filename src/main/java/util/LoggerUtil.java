package util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Dotin school 6 on 9/3/2016.
 */
public class LoggerUtil {
    public static Logger createLogger() {
        Logger logger = LogManager.getRootLogger();
        logger.debug("create logger manager...");
        return logger;
    }
}
