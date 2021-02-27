package util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public String getCurrentDate(String pattern){
		return new SimpleDateFormat(pattern).format(new Date());		
	}
	
	public static boolean isFolderExistsInLogs(String currentDate){		
		File file = new File(Constants.LOG_DIR);
		File[] listOfFolders = file.listFiles();
		for(int i=0; i< listOfFolders.length;i++){
			if(listOfFolders[i].isDirectory() && listOfFolders[i].getName().equals(currentDate))
				return true;
			 else
				return false;
		}
		return false;
	}
	
	public static String placeLogLocation() throws IOException{
		String folderName= new SimpleDateFormat("YYYYMMdd").format(new Date());
		if(isFolderExistsInLogs(folderName)){
			return folderName;
		}else{
			File file= new File(Constants.LOG_DIR+"\\"+folderName);
			file.mkdir();
			folderName = file.getName();
		}
			return folderName;
	}
	
	public static String convertTileMillsToString(long timeMills){
		return new SimpleDateFormat("YYYY-MM-dd HH:mm:ss:SSS").format(timeMills);
	}
}
