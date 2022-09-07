package RCB.TestVagrant.RCB;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import RCB.TestVagrant.RCB.BusinessLogic.TeamVerificationClass;
import RCB.TestVagrant.RCB.Utility.ReportClass;

public class TeamSorter_Sanity {

	public static String TeamInfo = "";

	@BeforeTest
	public void init()
	{
		TeamVerificationClass TVC = new TeamVerificationClass();
		TeamInfo = TVC.GetTeamList();
	}
	
	@Test (priority=1)
	public void Testcase1()
	{
		TeamVerificationClass TVC = new TeamVerificationClass();
		TVC.TeamSorterBasedOnCountry_Testcase1(TeamInfo);
	}
	
	@Test (priority=2)
	public void Testcas2()
	{
		TeamVerificationClass TVC = new TeamVerificationClass();
		TVC.TeamSorterBasedOnRole_Testcase2(TeamInfo);
	}
	
	@AfterSuite
	public void UpdateReport()
	{
		String Output = ReportClass.UpdateContent(ReportClass.ReportContent);
		ReportClass.WriteReport("Final_Report.html",Output);
	}
	
}
