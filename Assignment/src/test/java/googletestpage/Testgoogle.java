package googletestpage;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import google_automate.GoogleApp_automation;

public class Testgoogle extends GoogleApp_automation {

	GoogleApp_automation object=new GoogleApp_automation();
	@BeforeClass
	public void initialisefile() throws Exception
	{
		object.main_class();
	}
	
	@Test
	public void fetchdata() throws Exception
	{
		object.search_item();
	}
	
	@Test
	public void writedata() throws Exception
	{
		object.writedataintoexcel();
	}
	
	@AfterClass
	public void closeall()
	{
		object.close();
	}
	
	
}
