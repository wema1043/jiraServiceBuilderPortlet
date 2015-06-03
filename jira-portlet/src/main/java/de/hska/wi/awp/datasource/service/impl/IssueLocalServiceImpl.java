package de.hska.wi.awp.datasource.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONObject;

import com.liferay.portal.kernel.exception.SystemException;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.Base64;

import de.hska.wi.awp.datasource.model.Field;
import de.hska.wi.awp.datasource.model.Issue;
import de.hska.wi.awp.datasource.service.FieldLocalServiceUtil;
import de.hska.wi.awp.datasource.service.IssueLocalServiceUtil;
import de.hska.wi.awp.datasource.service.base.IssueLocalServiceBaseImpl;
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

	private String username = "stda1024";
	private String password = "hoppe1gang";

	public String getAllIssues() throws Exception {
		System.out.println("BEGINN getAllIssues()");

		String url = Constants.JIRA_HOST_NAME + "/rest/api/2/search?jql=project=HWB&maxResults=-1";
		String auth = new String(Base64.encode(username + ":" + password));

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

	public void ParseJsonToIssue(String response) throws Exception {
		System.out.println("BEGINN ParseJsonToIssue()");

		IssueLocalServiceUtil.deleteAllIssues();

		JSONObject jsonObject = new JSONObject(response);

		JSONArray tasks = jsonObject.getJSONArray("issues");

		for (int zl = 0; zl < tasks.length(); zl++) {
			Issue myIssue = IssueLocalServiceUtil.createIssue(tasks
					.getJSONObject(zl).getString("id"));
			Field myField = FieldLocalServiceUtil.createField(zl);

			myIssue.setKey(tasks.getJSONObject(zl).getString("key"));
			myIssue.setSelf(tasks.getJSONObject(zl).getString("self"));

			myIssue.setFieldId(zl);

			myField.setSummary(tasks.getJSONObject(zl).getJSONObject("fields")
					.getString("summary"));
			myField.setCreatedDate(tasks.getJSONObject(zl)
					.getJSONObject("fields").getString("created"));
			myField.setResolutionDate(tasks.getJSONObject(zl)
					.getJSONObject("fields").getString("resolutiondate"));
			myField.setUpdated(tasks.getJSONObject(zl).getJSONObject("fields")
					.getString("updated"));

			myField.setTimespent(tasks.getJSONObject(zl)
					.getJSONObject("fields").getString("timespent"));
			myField.setTimeestimate(tasks.getJSONObject(zl)
					.getJSONObject("fields").getString("timeestimate"));
			myField.setTimeoriginalestimate(tasks.getJSONObject(zl)
					.getJSONObject("fields").getString("timeoriginalestimate"));
			myField.setAggregatetimespent(tasks.getJSONObject(zl)
					.getJSONObject("fields").getString("aggregatetimespent"));
			myField.setAggregatetimeoriginalestimate(tasks.getJSONObject(zl)
					.getJSONObject("fields")
					.getString("aggregatetimeoriginalestimate"));
			myField.setAggregatetimeestimate(tasks.getJSONObject(zl)
					.getJSONObject("fields").getString("aggregatetimeestimate"));
			myField.setDescription(tasks.getJSONObject(zl)
					.getJSONObject("fields").getString("description"));

			if (!tasks.getJSONObject(zl).getJSONObject("fields")
					.isNull("customfield_10002")) {
				myField.setStorypoints(tasks.getJSONObject(zl)
						.getJSONObject("fields").getLong("customfield_10002"));
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

			FieldLocalServiceUtil.addField(myField);
			IssueLocalServiceUtil.addIssue(myIssue);
		}
		System.out.println("END ParseJsonToIssue()");

	}

	public void deleteAllIssues() throws SystemException {
		List<Issue> allIssues = IssueLocalServiceUtil.getIssues(0,
				IssueLocalServiceUtil.getIssuesCount());
		for (int zl = 0; zl < allIssues.size(); zl++) {
			IssueLocalServiceUtil.deleteIssue(allIssues.get(zl));
		}

		List<Field> allFields = FieldLocalServiceUtil.getFields(0,
				FieldLocalServiceUtil.getFieldsCount());
		for (int zl = 0; zl < allFields.size(); zl++) {
			FieldLocalServiceUtil.deleteField(allFields.get(zl));
		}
	}
}
