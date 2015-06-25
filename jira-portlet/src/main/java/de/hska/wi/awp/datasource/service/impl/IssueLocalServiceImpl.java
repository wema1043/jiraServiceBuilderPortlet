
package de.hska.wi.awp.datasource.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONException;
import org.primefaces.json.JSONObject;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
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
 * The implementation of the issue local service. <p> All custom service methods
 * should be put in this class. Whenever methods are added, rerun ServiceBuilder
 * to copy their definitions into the
 * {@link de.hska.wi.awp.datasource.service.IssueLocalService} interface. <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM. </p>
 *
 * @author Marc Weisenburger
 * @see de.hska.wi.awp.datasource.service.base.IssueLocalServiceBaseImpl
 * @see de.hska.wi.awp.datasource.service.IssueLocalServiceUtil
 */
public class IssueLocalServiceImpl extends IssueLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link de.hska.wi.awp.datasource.service.IssueLocalServiceUtil} to access
	 * the issue local service.
	 */

	private static Log log = LogFactoryUtil.getLog(IssueLocalServiceImpl.class);

	public List<Issue> getAllIssuesForProjectId(String projectId) {

		log.debug("BEGIN: getAllIssuesForProjectId");

		List<Issue> allIssuesForProjectId = new ArrayList<Issue>();
		try {
			allIssuesForProjectId =
				IssueUtil.findByIssuesForProjectId(projectId);
			System.out.println("SIZE allIssuesForProjectId: " +
				allIssuesForProjectId.size());

		}
		catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		log.debug("END: getAllIssuesForProjectId");

		return allIssuesForProjectId;
	}

	public String getAllIssues(String key) {

		log.debug("BEGIN: getAllIssues");

		String url =
			Constants.JIRA_HOST_NAME + "/rest/api/2/search?jql=project=" + key +
				"&maxResults=-1";
		Properties configFile = this.loadConfigFile();
		configFile.getProperty("username");
		String auth =
			new String(Base64.encode(configFile.getProperty("username") + ":" +
				configFile.getProperty("password")));

		// jersey lib
		Client client = Client.create();
		WebResource webResource = client.resource(url);

		ClientResponse response =
			webResource.header("Authorization", "Basic " + auth).type(
				"application/json").accept("application/json").get(
				ClientResponse.class);

		String responseBody = response.getEntity(String.class);

		log.debug("END: getAllIssues");

		return responseBody;
	}

	public void ParseJsonToIssue(String response) {

		log.debug("BEGIN: ParseJsonToIssue");

		JSONObject jsonObject = null;
		try {
			jsonObject = new JSONObject(response);
		}
		catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JSONArray tasks = null;
		try {
			tasks = jsonObject.getJSONArray("issues");
		}
		catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");

		for (int zl = 0; zl < tasks.length(); zl++) {
			Integer counter = zl;
			Issue myIssue;
			try {
				myIssue =
					IssueLocalServiceUtil.createIssue(tasks.getJSONObject(zl).getString(
						"id"));

				Field myField =
					FieldLocalServiceUtil.createField(FieldLocalServiceUtil.getFieldsCount() + 1);

				myIssue.setKey(tasks.getJSONObject(zl).getString("key"));
				myIssue.setProjectId(tasks.getJSONObject(zl).getJSONObject(
					"fields").getJSONObject("project").getString("id"));

				String self =
					Constants.JIRA_HOST_NAME + "/browse/" +
						tasks.getJSONObject(zl).getString("key");
				myIssue.setSelf(self);

				myField.setIssueId(tasks.getJSONObject(zl).getString("id"));
				myField.setSummary(tasks.getJSONObject(zl).getJSONObject(
					"fields").getString("summary"));

				if (!tasks.getJSONObject(zl).getJSONObject("fields").isNull(
					"created")) {
					String createdDateString =
						tasks.getJSONObject(zl).getJSONObject("fields").getString(
							"created").substring(0, 10) +
							" " +
							tasks.getJSONObject(zl).getJSONObject("fields").getString(
								"created").substring(11, 16);
					Date createdDate = format.parse(createdDateString);
					myField.setCreatedDate(createdDate);
				}

				if (!tasks.getJSONObject(zl).getJSONObject("fields").isNull(
					"resolutiondate")) {
					String resolutionDateString =
						tasks.getJSONObject(zl).getJSONObject("fields").getString(
							"resolutiondate").substring(0, 10) +
							" " +
							tasks.getJSONObject(zl).getJSONObject("fields").getString(
								"resolutiondate").substring(11, 16);
					Date resolutionDate = format.parse(resolutionDateString);
					myField.setResolutionDate(resolutionDate);
				}

				if (!tasks.getJSONObject(zl).getJSONObject("fields").isNull(
					"updated")) {
					String updatedDateString =
						tasks.getJSONObject(zl).getJSONObject("fields").getString(
							"updated").substring(0, 10) +
							" " +
							tasks.getJSONObject(zl).getJSONObject("fields").getString(
								"updated").substring(11, 16);
					Date updatedDate = format.parse(updatedDateString);
					myField.setUpdated(updatedDate);
				}
				if (!tasks.getJSONObject(zl).getJSONObject("fields").isNull("timespent")) {
					myField.setTimespent(tasks.getJSONObject(zl).getJSONObject(
						"fields").getLong("timespent"));
				}
				if (!tasks.getJSONObject(zl).getJSONObject("fields").isNull("timeestimate")) {

				myField.setTimeestimate(tasks.getJSONObject(zl).getJSONObject(
					"fields").getLong("timeestimate"));
				}
				if (!tasks.getJSONObject(zl).getJSONObject("fields").isNull("timeoriginalestimate")) {
				myField.setTimeoriginalestimate(tasks.getJSONObject(zl).getJSONObject(
					"fields").getLong("timeoriginalestimate"));
				}
				if (!tasks.getJSONObject(zl).getJSONObject("fields").isNull("aggregatetimespent")) {
				myField.setAggregatetimespent(tasks.getJSONObject(zl).getJSONObject(
					"fields").getLong("aggregatetimespent"));
				}
				if (!tasks.getJSONObject(zl).getJSONObject("fields").isNull("aggregatetimeoriginalestimate")) {
				myField.setAggregatetimeoriginalestimate(tasks.getJSONObject(zl).getJSONObject(
					"fields").getLong("aggregatetimeoriginalestimate"));
				}
				if (!tasks.getJSONObject(zl).getJSONObject("fields").isNull("aggregatetimeestimate")) {
				myField.setAggregatetimeestimate(tasks.getJSONObject(zl).getJSONObject(
					"fields").getLong("aggregatetimeestimate"));
				}
				myField.setDescription(tasks.getJSONObject(zl).getJSONObject(
					"fields").getString("description"));
				
				if (!tasks.getJSONObject(zl).getJSONObject("fields").isNull(
					"customfield_10002")) {
					myField.setStorypoints(tasks.getJSONObject(zl).getJSONObject(
						"fields").getLong("customfield_10002"));
				}

				myField.setCreatorId(tasks.getJSONObject(zl).getJSONObject(
					"fields").getJSONObject("creator").getString("name"));
				if (!tasks.getJSONObject(zl).getJSONObject("fields").isNull(
					"assignee")) {
					myField.setAssigneeId(tasks.getJSONObject(zl).getJSONObject(
						"fields").getJSONObject("assignee").getString("name"));
				}

				myField.setStatusId(tasks.getJSONObject(zl).getJSONObject(
					"fields").getJSONObject("status").getLong("id"));

				 FieldLocalServiceUtil.addField(myField);
				 IssueLocalServiceUtil.addIssue(myIssue);

			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		log.debug("END: ParseJsonToIssue");

	}

	public void deleteAllIssues() {

		log.debug("BEGIN: deleteAllIssues");

		List<Issue> allIssues = null;
		try {
			allIssues =
				IssueLocalServiceUtil.getIssues(
					0, IssueLocalServiceUtil.getIssuesCount());
		}
		catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int zl = 0; zl < allIssues.size(); zl++) {
			try {
				IssueLocalServiceUtil.deleteIssue(allIssues.get(zl));
			}
			catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		List<Field> allFields = null;
		try {
			allFields =
				FieldLocalServiceUtil.getFields(
					0, FieldLocalServiceUtil.getFieldsCount());
		}
		catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int zl = 0; zl < allFields.size(); zl++) {
			try {
				FieldLocalServiceUtil.deleteField(allFields.get(zl));
			}
			catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		log.debug("End: deleteAllIssues");
	}

	public Properties loadConfigFile() {

		Properties prop = new Properties();
		InputStream input = null;

		try {

			String filename = "jira.properties";
			input = getClass().getClassLoader().getResourceAsStream(filename);
			if (input == null) {
				System.out.println("Sorry, unable to find " + filename);
				return null;
			}

			prop.load(input);

		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
		finally {
			if (input != null) {
				try {
					input.close();
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return prop;
	}
}
