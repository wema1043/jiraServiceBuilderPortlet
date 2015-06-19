package de.hska.wi.awp.datasource.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONException;
import org.primefaces.json.JSONObject;

import com.liferay.portal.kernel.exception.SystemException;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.Base64;

import de.hska.wi.awp.datasource.model.Field;
import de.hska.wi.awp.datasource.model.Issue;
import de.hska.wi.awp.datasource.model.Status;
import de.hska.wi.awp.datasource.service.FieldLocalServiceUtil;
import de.hska.wi.awp.datasource.service.IssueLocalServiceUtil;
import de.hska.wi.awp.datasource.service.StatusLocalServiceUtil;
import de.hska.wi.awp.datasource.service.base.IssueLocalServiceBaseImpl;
import de.hska.wi.awp.datasource.service.persistence.IssueUtil;
import de.hska.wi.awp.datasource.utils.Constants;

/**
 * The implementation of the issue local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link de.hska.wi.awp.datasource.service.IssueLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see de.hska.wi.awp.datasource.service.base.IssueLocalServiceBaseImpl
 * @see de.hska.wi.awp.datasource.service.IssueLocalServiceUtil
 */
public class IssueLocalServiceImpl extends IssueLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * de.hska.wi.awp.datasource.service.IssueLocalServiceUtil} to access the
	 * issue local service.
	 */
	
	public List<Issue> getAllIssuesForProjectId(String projectId){
		System.out.println("INPUT: " + projectId);

		List<Issue> allIssuesForProjectId = new ArrayList<Issue>();
		try {
			allIssuesForProjectId = IssueUtil.findByIssuesForProjectId(projectId);
			System.out.println("SIZE allIssuesForProjectId: " + allIssuesForProjectId.size());

		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return allIssuesForProjectId;
	}

	public String getAllIssues(String key) {
		System.out.println("BEGINN getAllIssues()");

		String url = Constants.JIRA_HOST_NAME
				+ "/rest/api/2/search?jql=project=" + key + "&maxResults=-1";
		String auth = new String(Base64.encode(Constants.JIRA_USERNAME + ":"
				+ Constants.JIRA_PASSWORD));

		// get Date
		DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd");
		Calendar cal = Calendar.getInstance();
		String date = dateFormat.format(cal.getTime());

		// jersey lib
		Client client = Client.create();
		WebResource webResource = client.resource(url);

		ClientResponse response = webResource
				.header("Authorization", "Basic " + auth)
				.type("application/json").accept("application/json")
				.get(ClientResponse.class);

		String responseBody = response.getEntity(String.class);
		System.out.println("END getAllIssues()");

		return responseBody;
	}

	public void ParseJsonToIssue(String response) {
		System.out.println("BEGINN ParseJsonToIssue()");

		

		JSONObject jsonObject = null;
		try {
			jsonObject = new JSONObject(response);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JSONArray tasks = null;
		try {
			tasks = jsonObject.getJSONArray("issues");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");


		for (int zl = 0; zl < tasks.length(); zl++) {
			Integer counter = zl;
			Issue myIssue;
			try {
				myIssue = IssueLocalServiceUtil.createIssue(tasks
						.getJSONObject(zl).getString("id"));

				Field myField = FieldLocalServiceUtil.createField(FieldLocalServiceUtil.getFieldsCount()+1);

				myIssue.setKey(tasks.getJSONObject(zl).getString("key"));
				myIssue.setProjectId(tasks.getJSONObject(zl).getJSONObject("fields").getJSONObject("project").getString("id"));
				
				String self = Constants.JIRA_HOST_NAME + "/browse/" + tasks.getJSONObject(zl).getString("key");			
				myIssue.setSelf(self);

				
				myField.setIssueId(tasks.getJSONObject(zl).getString("id"));
				myField.setSummary(tasks.getJSONObject(zl)
						.getJSONObject("fields").getString("summary"));
				
				if (!tasks.getJSONObject(zl).getJSONObject("fields").isNull("created")) {
					String createdDateString = tasks.getJSONObject(zl).getJSONObject("fields").getString("created").substring(0, 10) + " " +  tasks.getJSONObject(zl).getJSONObject("fields").getString("created").substring(11, 16);
					Date createdDate = format.parse(createdDateString);
					myField.setCreatedDate(createdDate);
				}
				
				if (!tasks.getJSONObject(zl).getJSONObject("fields").isNull("resolutiondate")) {
					String resolutionDateString = tasks.getJSONObject(zl).getJSONObject("fields").getString("resolutiondate").substring(0, 10) + " " + tasks.getJSONObject(zl).getJSONObject("fields").getString("resolutiondate").substring(11, 16);
					Date resolutionDate = format.parse(resolutionDateString);
					myField.setResolutionDate(resolutionDate);
				}
				
				if (!tasks.getJSONObject(zl).getJSONObject("fields").isNull("updated")) {
					String updatedDateString = tasks.getJSONObject(zl).getJSONObject("fields").getString("updated").substring(0, 10) + " " + tasks.getJSONObject(zl).getJSONObject("fields").getString("updated").substring(11, 16);
					Date updatedDate = format.parse(updatedDateString);
					myField.setUpdated(updatedDate);
				}

				myField.setTimespent(tasks.getJSONObject(zl)
						.getJSONObject("fields").getString("timespent"));
				myField.setTimeestimate(tasks.getJSONObject(zl)
						.getJSONObject("fields").getString("timeestimate"));
				myField.setTimeoriginalestimate(tasks.getJSONObject(zl)
						.getJSONObject("fields")
						.getString("timeoriginalestimate"));
				myField.setAggregatetimespent(tasks.getJSONObject(zl)
						.getJSONObject("fields")
						.getString("aggregatetimespent"));
				myField.setAggregatetimeoriginalestimate(tasks
						.getJSONObject(zl).getJSONObject("fields")
						.getString("aggregatetimeoriginalestimate"));
				myField.setAggregatetimeestimate(tasks.getJSONObject(zl)
						.getJSONObject("fields")
						.getString("aggregatetimeestimate"));
				myField.setDescription(tasks.getJSONObject(zl)
						.getJSONObject("fields").getString("description"));

				if (!tasks.getJSONObject(zl).getJSONObject("fields")
						.isNull("customfield_10002")) {
					myField.setStorypoints(tasks.getJSONObject(zl)
							.getJSONObject("fields")
							.getLong("customfield_10002"));
				}

				myField.setCreatorId(tasks.getJSONObject(zl)
						.getJSONObject("fields").getJSONObject("creator")
						.getString("name"));
				if (!tasks.getJSONObject(zl).getJSONObject("fields")
						.isNull("assignee")) {
					myField.setAssigneeId(tasks.getJSONObject(zl)
							.getJSONObject("fields").getJSONObject("assignee")
							.getString("name"));
				}

				myField.setStatusId(tasks.getJSONObject(zl)
						.getJSONObject("fields").getJSONObject("status")
						.getLong("id"));

				FieldLocalServiceUtil.addField(myField);
				IssueLocalServiceUtil.addIssue(myIssue);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		System.out.println("END ParseJsonToIssue()");

	}

	public void deleteAllIssues() {
		List<Issue> allIssues = null;
		try {
			allIssues = IssueLocalServiceUtil.getIssues(0,
					IssueLocalServiceUtil.getIssuesCount());
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int zl = 0; zl < allIssues.size(); zl++) {
			try {
				IssueLocalServiceUtil.deleteIssue(allIssues.get(zl));
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		List<Field> allFields = null;
		try {
			allFields = FieldLocalServiceUtil.getFields(0,
					FieldLocalServiceUtil.getFieldsCount());
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int zl = 0; zl < allFields.size(); zl++) {
			try {
				FieldLocalServiceUtil.deleteField(allFields.get(zl));
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
