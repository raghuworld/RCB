package RCB.TestVagrant.RCB.Utility;

import java.io.File;
import java.io.FileOutputStream;

public class ReportClass {
	
	public static String ReportContent = "";
	public static int slcnt = 0;
	
	public static String ReadReportTemplate()
	{
		return TextFileClass.ReadReportTemplate("Report_Template.html");
	}
	
	public static String UpdateContent(String content)
	{
		String Template = ReadReportTemplate();
		
		String output = Template.replace("<!--REPORT-->", content);
		
		return output;
	}
	
	public static void WriteReport(String file, String Output)
	{
		try
		{
			File f = new File(System.getProperty("user.dir")+"/src/test/java/RCB/TestVagrant/RCB/Reports/"+file);
						
			FileOutputStream FOS = new FileOutputStream(f);
			FOS.write(Output.getBytes());
			FOS.close();
		}
		catch(Exception es)
		{
			es.printStackTrace();
		}
	}

}
