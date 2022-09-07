package RCB.TestVagrant.RCB.Utility;

import java.nio.file.Files;
import java.nio.file.Paths;

public class TextFileClass {

	public static String ReadJSONFile(String file)
	{
		String Content = "";
		
		try
		{
			Content = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir").replace("\\", "/").trim()
					+ "/src/main/java/RCB/TestVagrant/RCB/TestData/"+file)));
			
			if(Content.trim().length() > 0)
			{
//				System.out.println(Content);
			}
		}
		catch(Exception ex)
		{
			
			ex.printStackTrace();
		}
		
		return Content;
	}
	
	public static String ReadReportTemplate(String file)
	{
		String Content = "";
		
		try
		{
			Content = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir").replace("\\", "/").trim()
					+ "/src/main/java/RCB/TestVagrant/RCB/Utility/Template/"+file)));
			
			if(Content.trim().length() > 0)
			{
				System.out.println(Content);
			}
		}
		catch(Exception ex)
		{
			
			ex.printStackTrace();
		}
		
		return Content;
	}
	
	public static void main(String[] args) {
		
		ReadReportTemplate("Report_Template.html");
		
	}

}
