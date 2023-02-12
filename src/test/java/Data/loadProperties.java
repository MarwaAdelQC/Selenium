package Data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class loadProperties {
	//load properties from file
	
	public static Properties userData = loadPropertiess (System.getProperty("user.dir")+"\\src\\main\\java\\Properties\\userDataproperties") ;
	
	private static Properties loadPropertiess (String path)
	{
		Properties pro = new Properties() ;
		//stream for reading the file 
		try {
			FileInputStream stream = new FileInputStream(path);
			pro.load(stream);
		} catch (FileNotFoundException e) {
			System.out.println("error occured: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("error occured: " + e.getMessage());e.printStackTrace();
		}
		return pro;
	}


}
