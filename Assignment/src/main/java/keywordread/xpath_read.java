package keywordread;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class xpath_read {


	public static String pathread(String keyname) throws Exception {
		String path="C:\\Users\\shivanand.chachadi\\framework\\workspace\\Assignment\\src\\main\\resources\\keywords_package\\keywordfile.properties";
		Properties prop=new Properties();		
		FileInputStream file=new FileInputStream(path);
		prop.load(file);
		return prop.getProperty(keyname);
	}









}
