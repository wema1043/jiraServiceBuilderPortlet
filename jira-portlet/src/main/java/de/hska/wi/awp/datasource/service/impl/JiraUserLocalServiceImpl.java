package de.hska.wi.awp.datasource.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONException;

import com.liferay.portal.kernel.exception.SystemException;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.Base64;

import de.hska.wi.awp.datasource.model.Issue;
import de.hska.wi.awp.datasource.model.JiraUser;
import de.hska.wi.awp.datasource.service.IssueLocalServiceUtil;
import de.hska.wi.awp.datasource.service.JiraUserLocalServiceUtil;
import de.hska.wi.awp.datasource.service.base.JiraUserLocalServiceBaseImpl;
import de.hska.wi.awp.datasource.utils.Constants;

/**
 * The implementation of the jira user local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link de.hska.wi.awp.datasource.service.JiraUserLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see de.hska.wi.awp.datasource.service.base.JiraUserLocalServiceBaseImpl
 * @see de.hska.wi.awp.datasource.service.JiraUserLocalServiceUtil
 */
public class JiraUserLocalServiceImpl extends JiraUserLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link de.hska.wi.awp.datasource.service.JiraUserLocalServiceUtil} to access the jira user local service.
     */

	
	public String getAllMembers(String projectId){
		System.out.println("BEGINN getAllMembers()");

		String url = Constants.JIRA_HOST_NAME + Constants.JIRA_API_ALL_MEMBERS_FOR_PROJECT+ projectId;
		String auth = new String(Base64.encode(Constants.JIRA_USERNAME + ":" + Constants.JIRA_PASSWORD));

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

			System.out.println("END getAllMembers()");
			return responseBody;
		}
	}

	public void ParseJsonToMember(String response){
		System.out.println("BEGINN ParseJsonToMember()");

		try {
			JiraUserLocalServiceUtil.deleteAllJiraUser();
			JSONArray jsonresponse = new JSONArray(response);
			
			for (int zl = 0; zl < jsonresponse.length(); zl++) {
				JiraUser jiraUser = JiraUserLocalServiceUtil
						.createJiraUser(jsonresponse.getJSONObject(zl).getString(
								"key"));
				jiraUser.setDisplayname(jsonresponse.getJSONObject(zl).getString(
						"displayName"));

				JiraUserLocalServiceUtil.addJiraUser(jiraUser);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("END ParseJsonToMember()");
	}
	
	public void deleteAllJiraUser(){
		List<JiraUser> allJiraUser = new ArrayList<JiraUser>();
		try {
			allJiraUser = JiraUserLocalServiceUtil.getJiraUsers(0, JiraUserLocalServiceUtil.getJiraUsersCount());
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int zl = 0; zl < allJiraUser.size(); zl++) {
			try {
				JiraUserLocalServiceUtil.deleteJiraUser(allJiraUser.get(zl));
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
