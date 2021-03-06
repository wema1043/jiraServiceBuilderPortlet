
package de.hska.wi.awp.datasource.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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

import de.hska.wi.awp.datasource.NoSuchStatusException;
import de.hska.wi.awp.datasource.model.Field;
import de.hska.wi.awp.datasource.model.Issue;
import de.hska.wi.awp.datasource.model.Status;
import de.hska.wi.awp.datasource.service.FieldLocalServiceUtil;
import de.hska.wi.awp.datasource.service.IssueLocalServiceUtil;
import de.hska.wi.awp.datasource.service.StatusLocalServiceUtil;
import de.hska.wi.awp.datasource.service.base.StatusLocalServiceBaseImpl;
import de.hska.wi.awp.datasource.service.persistence.StatusUtil;
import de.hska.wi.awp.datasource.utils.Constants;

/**
 * The implementation of the status local service. <p> All custom service
 * methods should be put in this class. Whenever methods are added, rerun
 * ServiceBuilder to copy their definitions into the
 * {@link de.hska.wi.awp.datasource.service.StatusLocalService} interface. <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM. </p>
 *
 * @author Marc Weisenburger
 * @see de.hska.wi.awp.datasource.service.base.StatusLocalServiceBaseImpl
 * @see de.hska.wi.awp.datasource.service.StatusLocalServiceUtil
 */
public class StatusLocalServiceImpl extends StatusLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link de.hska.wi.awp.datasource.service.StatusLocalServiceUtil} to
	 * access the status local service.
	 */

	private static Log log = LogFactoryUtil.getLog(StatusLocalServiceImpl.class);

	public String getAllStatus() {

		log.debug("BEGIN: getAllStatus");

		String url = Constants.JIRA_HOST_NAME + "/rest/api/2/status";
		Properties configFile = this.loadConfigFile();
		configFile.getProperty("username");
		String auth = new String(Base64.encode(configFile.getProperty("username") + ":" + configFile.getProperty("password")));

		// get Date
		DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd");
		Calendar cal = Calendar.getInstance();
		String date = dateFormat.format(cal.getTime());

		// jersey lib
		Client client = Client.create();
		WebResource webResource = client.resource(url);

		ClientResponse response =
			webResource.header("Authorization", "Basic " + auth).type(
				"application/json").accept("application/json").get(
				ClientResponse.class);

		String responseBody = response.getEntity(String.class);

		log.debug("END: getAllStatus");

		return responseBody;
	}

	public List<Status> getAllJiraStati() {

		log.debug("BEGIN: getAllJiraStati");

		List<Status> allStati = new ArrayList<Status>();
		try {
			allStati = StatusUtil.findAll();
		}
		catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.debug("END: getAllJiraStati");

		return allStati;
	}

	public String getStatusNameForStatusId(String statusId) {
		log.debug("BEGIN: getStatusNameForStatusId");

		String name = "";
		try {
			name = StatusUtil.findByPrimaryKey(statusId).getName();
		}
		catch (NoSuchStatusException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.debug("END: getStatusNameForStatusId");

		return name;
	}

	public void ParseJsonToStatus(String response) {

		log.debug("BEGIN: ParseJsonToStatus");

		this.deleteAllStatus();
		JSONArray issues = null;
		try {
			issues = new JSONArray(response);
		}
		catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int zl = 0; zl < issues.length(); zl++) {
			Integer counter = zl;

			Status myStatus =
				StatusLocalServiceUtil.createStatus(counter.toString());

			try {
				myStatus.setStatusId(issues.getJSONObject(zl).getString("id"));
				myStatus.setName(issues.getJSONObject(zl).getString("name"));

			}
			catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				StatusLocalServiceUtil.addStatus(myStatus);
			}
			catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		log.debug("END: ParseJsonToStatus");
	}

	public void deleteAllStatus() {

		log.debug("BEGIN: deleteAllStatus");

		List<Status> allStatus = null;
		try {
			allStatus =
				StatusLocalServiceUtil.getStatuses(
					0, StatusLocalServiceUtil.getStatusesCount());
		}
		catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int zl = 0; zl < allStatus.size(); zl++) {
			try {
				StatusLocalServiceUtil.deleteStatus(allStatus.get(zl));
			}
			catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		log.debug("END: deleteAllStatus");

	}
	
	public Properties loadConfigFile(){
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
    		
    	} catch (IOException ex) {
    		ex.printStackTrace();
        } finally{
        	if(input!=null){
        		try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
        	}
        }
    	
    	return prop;
	}
	
}
