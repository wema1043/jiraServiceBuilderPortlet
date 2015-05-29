package de.hska.wi.awp.datasource.bean;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.faces.bean.ManagedBean;

import org.apache.commons.io.IOUtils;
import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONObject;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.Base64;

import de.hska.wi.awp.datasource.model.JiraUser;
import de.hska.wi.awp.datasource.model.Student;
import de.hska.wi.awp.datasource.service.JiraUserLocalServiceUtil;
import de.hska.wi.awp.datasource.service.StudentLocalServiceUtil;

@ManagedBean
public class StudentBean {

	private String student;
	private String username= "";
	private String passowrd  ="";

	public String getStudent() throws Exception {

//		int count = StudentLocalServiceUtil.getStudentsCount();
//		System.out.println("getStudentMethode");
//
//		Student p2 = StudentLocalServiceUtil.createStudent(count + 1);
//		p2.setFirstName("Daniel");
//		p2.setLastName("Storch ");
//		StudentLocalServiceUtil.addStudent(p2);

		Student ausgabe = StudentLocalServiceUtil.getStudent(4);

		String str = getAllIssues();
		ParseJsonToIssue(str);
		
		return ausgabe.getFirstName();
	}

	public String getAllIssues() throws Exception {

		String url = "http://www.iwi.hs-karlsruhe.de/awpjira/rest/api/2/user/assignable/search?project=HWB";
		String auth = new String(Base64.encode(username + ":" + passowrd));

		// get Date
		DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd");
		Calendar cal = Calendar.getInstance();
		String date = dateFormat.format(cal.getTime());

		{
			// jersey lib
			Client client = Client.create();
			WebResource webResource = client.resource(url);

			ClientResponse response = webResource
					.header("Authorization", "Basic " + auth)
					.type("application/json").accept("application/json")
					.get(ClientResponse.class);

			String responseBody = response.getEntity(String.class);

			return responseBody;
		}
	}
	
	
	public void ParseJsonToIssue(String response) throws Exception {

		JSONArray jsonresponse = new JSONArray(response);

		for (int zl = 0; zl < jsonresponse.length(); zl++) {
			JiraUser jiraUser = JiraUserLocalServiceUtil.createJiraUser(jsonresponse.getJSONObject(zl).getString("key"));
			jiraUser.setDisplayname(jsonresponse.getJSONObject(zl).getString("displayName"));
		
			JiraUserLocalServiceUtil.updateJiraUser(jiraUser);
		}

	}

	public void setStudent(String student) {
		this.student = student;
	}

}
