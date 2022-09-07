package RCB.TestVagrant.RCB.BusinessLogic;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import RCB.TestVagrant.RCB.Utility.ReportClass;
import RCB.TestVagrant.RCB.Utility.TextFileClass;

public class TeamVerificationClass {

	public String GetTeamList() {
		// Retrieving the JSON response from the text file and assigning to a global
		// variable TeamInfo
		return TextFileClass.ReadJSONFile("Team.txt");
	}

	public void TeamSorterBasedOnCountry_Testcase1(String TeamInfo) {
		boolean res = false;
		JSONParser JP = new JSONParser();
		System.out.println("----------------------------------");
		System.out.println("TEAM PLAYERS BASED ON COUNTRY");
		System.out.println("----------------------------------");
		try {
			// Assigning the String value of TeamInfo to JSONObject for parsing the JSON
			// Body
			JSONObject JB = (JSONObject) JP.parse(TeamInfo);

			JSONArray JA = (JSONArray) JB.get("player");

			Iterator<?> i = JA.iterator();
			int cnt = 0;
			int pcnt = 1;

			while (i.hasNext()) {
				Object O = i.next();

				JSONObject JO = (JSONObject) O;

				// Below two variables signifies retrieving of Country and Player Names
				// from the JSON response using JSONObject
				String PlayerName = (String) JO.get("name");
				String Country = (String) JO.get("country");

				// This if condition signifies all the players to be retrieved excluding Indian
				// Players
				if (!Country.trim().equalsIgnoreCase("India")) {

					// This if condition signifies only 4 foreign players to be present in the team.
					// There cant be more than 4 foreign players.
					if (cnt < 5) {
						System.out.println("Player Name: " + PlayerName);
						System.out.println("Country: " + Country);
						System.out.println("");
						pcnt = pcnt + 1;

						res = true;
					}

					cnt = cnt + 1;
				}
			}

			if (pcnt < 4) {
				System.out.println("We donot have sufficient foreign players. Expected: 4 but Actual: " + pcnt);

				res = false;

			} else {
				res = true;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		// REPORTING BLOCK
		ReportClass.slcnt = ReportClass.slcnt + 1;
		LocalDateTime LDT = LocalDateTime.now();
		DateTimeFormatter DTF = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/YYYY");
		if (res) {

			ReportClass.ReportContent = ReportClass.ReportContent + "<tr><td>" + ReportClass.slcnt
					+ "</td><td>Testcase - Sort Players based on Country</td><td>PASS</td><td>" + LDT.format(DTF)
					+ "</td></tr><!--REPORT-->";
		} else {

			ReportClass.ReportContent = ReportClass.ReportContent + "<tr><td>" + ReportClass.slcnt
					+ "</td><td>Testcase - Sort Players based on Country</td><td>FAIL</td><td>" + LDT.format(DTF)
					+ "</td></tr><!--REPORT-->";
		}
	}

	public void TeamSorterBasedOnRole_Testcase2(String TeamInfo) {
		boolean res = false;
		JSONParser JP = new JSONParser();
		System.out.println("----------------------------------");
		System.out.println("TEAM PLAYERS BASED ON ROLE");
		System.out.println("----------------------------------");
		try {
			// Assigning the String value of TeamInfo to JSONObject for parsing the JSON
			// Body
			JSONObject JB = (JSONObject) JP.parse(TeamInfo);

			JSONArray JA = (JSONArray) JB.get("player");

			Iterator<?> i = JA.iterator();
			int cnt = 1;
			while (i.hasNext()) {

				Object O = i.next();

				JSONObject JO = (JSONObject) O;

				// Below three variables signifies retrieving of Country and Player Names and
				// Role
				// from the JSON response using JSONObject
				String PlayerName = (String) JO.get("name");
				String Country = (String) JO.get("country");
				String Role = (String) JO.get("role");

				// Below if condition signifies - only the players whose role is Wicket-keeper
				// should be retrieved
				if (Role.trim().equalsIgnoreCase("Wicket-keeper")) {
					// Below if condition signifies that there should be atleast one wicket keeper.
					// it can be more but minimum number of wicket keeper is 1.
					if (cnt > 0) {
						System.out.println("Player Name: " + PlayerName);
						System.out.println("Country: " + Country);
						System.out.println("Role: " + Role);
					}
					cnt = cnt + 1;

					res = true;
				}

			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		// REPORTING BLOCK
		ReportClass.slcnt = ReportClass.slcnt + 1;

		LocalDateTime LDT = LocalDateTime.now();
		DateTimeFormatter DTF = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/YYYY");

		if (res) {

			ReportClass.ReportContent = ReportClass.ReportContent + "<tr><td>" + ReportClass.slcnt
					+ "</td><td>Testcase - Sort Players based on Role-Wicket Keeper</td><td>PASS</td><td>"
					+ LDT.format(DTF) + "</td></tr><!--REPORT-->";
		} else {

			ReportClass.ReportContent = ReportClass.ReportContent + "<tr><td>" + ReportClass.slcnt
					+ "</td><td>Testcase - Sort Players based on Role-Wicket Keeper</td><td>FAIL</td><td>"
					+ LDT.format(DTF) + "</td></tr><!--REPORT-->";
		}
	}
}
