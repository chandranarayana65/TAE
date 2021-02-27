package util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;


public class Log {
	public static Logger log = null;
	
	static{
		log = Logger.getLogger(Log.class);
		try {
			System.setProperty("logFileName", DateUtil.placeLogLocation()+"\\"+new SimpleDateFormat("HHmmss").format(new Date()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		DOMConfigurator.configure("configure/log4j.xml");
	}
	public static void debug(String msg) {
		log.debug(msg);
	}

	public static void fatal(String msg) {
		log.fatal(msg);
	}
	
	public static void info(String msg) {
		log.info(msg);
	}
	
	public static void warn(String msg){
		log.warn(msg);
	}
	
	public static void error(String msg){
		log.error(msg);
	}	
}
