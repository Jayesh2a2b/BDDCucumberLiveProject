package utills;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CommonUtils {
	static Properties prop;
public static Properties loadPropertyFiles()
{
	prop=new Properties();
	String filePath=System.getProperty("user.dir")+"\\src\\test\\resources\\config\\ProjectConfig.properties";
	File file=new File(filePath);
	try {
		FileInputStream fis=new FileInputStream(file);
		prop.load(fis);

	} catch (IOException e) {
		e.printStackTrace();
	}
	return prop;
}
	
public static String generateNewEmail() {
	return System.currentTimeMillis()+"@gmail.com";
}
	
	
	
	
	
	
	
	
	
	
	
}
