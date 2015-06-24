package de.hska.wi.awp.datasource.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.primefaces.json.JSONArray;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.Base64;

import de.hska.wi.awp.datasource.NoSuchProjectException;
import de.hska.wi.awp.datasource.model.Project;
import de.hska.wi.awp.datasource.service.ProjectLocalServiceUtil;
import de.hska.wi.awp.datasource.service.base.ProjectLocalServiceBaseImpl;
import de.hska.wi.awp.datasource.service.persistence.ProjectUtil;
import de.hska.wi.awp.datasource.utils.Constants;

/**
 * The implementation of the project local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link de.hska.wi.awp.datasource.service.ProjectLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Marc Weisenburger
 * @see de.hska.wi.awp.datasource.service.base.ProjectLocalServiceBaseImpl
 * @see de.hska.wi.awp.datasource.service.ProjectLocalServiceUtil
 */
public class ProjectLocalServiceImpl extends ProjectLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link de.hska.wi.awp.datasource.service.ProjectLocalServiceUtil} to access the project local service.
     */
	
	private static Log log = LogFactoryUtil.getLog(ProjectLocalServiceImpl.class);

	
	public String getProjectIdForProjectName(String projectName){
		log.debug("BEGIN: getProjectIdForProjectName");
		String result = null;
		
		try {
			result = ProjectUtil.findByKey(projectName).getProjectId();
		} catch (NoSuchProjectException e) {
			// TODO Auto-generated catch block
			log.error("es wurden keine Projekte für den Projektnamen " + projectName + "gefunden!");
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		log.debug("END: getProjectIdForProjectName");

		return result;
	}
	
	
	
	public String getAllProjects(){
		log.debug("BEGIN: getAllProjects");

		String url = Constants.JIRA_HOST_NAME + Constants.JIRA_API_ALL_PROJECTS;
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

			log.debug("END: getAllProjects");
			return responseBody;
		}
	}

	public void ParseJsonToProjects(String response){
		log.debug("BEGIN: ParseJsonToProjects");

		try {
			this.deleteAllProjects();
			JSONArray jsonresponse = new JSONArray(response);
			
			for (int zl = 0; zl < jsonresponse.length(); zl++) {
				Project project = ProjectLocalServiceUtil.createProject(jsonresponse.getJSONObject(zl).getString("id"));
				project.setKey(jsonresponse.getJSONObject(zl).getString("key"));
				project.setName(jsonresponse.getJSONObject(zl).getString("name"));


				ProjectLocalServiceUtil.addProject(project);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		log.debug("END: ParseJsonToProjects");
	}
	
	public void deleteAllProjects(){
		log.debug("BEGIN: deleteAllProjects");

		List<Project> allProjects = new ArrayList<Project>();
		try {
			allProjects = ProjectLocalServiceUtil.getProjects(0, ProjectLocalServiceUtil.getProjectsCount());
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int zl = 0; zl < allProjects.size(); zl++) {
			try {
				ProjectLocalServiceUtil.deleteProject(allProjects.get(zl));
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		log.debug("END: deleteAllProjects");
	}
}
