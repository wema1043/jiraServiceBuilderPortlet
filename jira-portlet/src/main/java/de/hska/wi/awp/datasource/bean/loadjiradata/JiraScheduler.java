
package de.hska.wi.awp.datasource.bean.loadjiradata;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;

import de.hska.wi.awp.datasource.model.Field;
import de.hska.wi.awp.datasource.model.Issue;
import de.hska.wi.awp.datasource.model.Project;
import de.hska.wi.awp.datasource.service.FieldLocalServiceUtil;
import de.hska.wi.awp.datasource.service.IssueLocalServiceUtil;
import de.hska.wi.awp.datasource.service.JiraUserLocalServiceUtil;
import de.hska.wi.awp.datasource.service.ProjectLocalServiceUtil;
import de.hska.wi.awp.datasource.service.StatusLocalServiceUtil;

public class JiraScheduler implements MessageListener {

	public void receive(Message arg0)
		throws MessageListenerException {

		// Here is the buisness logic to be written as per your requirement

		this.fillDatabase();

	}

	public void fillDatabase() {

		String projectResponse = ProjectLocalServiceUtil.getAllProjects();
		ProjectLocalServiceUtil.ParseJsonToProjects(projectResponse);

		List<Project> allProjects = new ArrayList<Project>();
		try {
			allProjects =
				ProjectLocalServiceUtil.getProjects(
					0, ProjectLocalServiceUtil.getProjectsCount());
		}
		catch (SystemException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		JiraUserLocalServiceUtil.deleteAllJiraUser();
		try {
			IssueLocalServiceUtil.deleteAllIssues();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (Project temp : allProjects) {
			String str2 = JiraUserLocalServiceUtil.getAllMembers(temp.getKey());
			JiraUserLocalServiceUtil.ParseJsonToMember(str2);

			String str1 = IssueLocalServiceUtil.getAllIssues(temp.getKey());
			IssueLocalServiceUtil.ParseJsonToIssue(str1);
		}

		String stati = StatusLocalServiceUtil.getAllStatus();
		StatusLocalServiceUtil.ParseJsonToStatus(stati);

		Project project = ProjectLocalServiceUtil.createProject("20007");
		project.setKey("MobCo");
		project.setName("Kollaborationsplattform");

		Issue issue = IssueLocalServiceUtil.createIssue("50000");
		issue.setProjectId("20007");
		issue.setKey("MobCo");
		Issue issue2 = IssueLocalServiceUtil.createIssue("50001");
		issue2.setProjectId("20007");
		issue2.setKey("MobCo");

		Field field = FieldLocalServiceUtil.createField(50000);
		field.setIssueId("50000");
		field.setCreatedDate(new Date());
		field.setStatusId(3);
		field.setStorypoints(15);
		Field field2 = FieldLocalServiceUtil.createField(50001);
		field2.setIssueId("50001");
		field2.setCreatedDate(new Date());
		field2.setStatusId(5);
		field2.setStorypoints(20);

		try {
			ProjectLocalServiceUtil.addProject(project);
			IssueLocalServiceUtil.addIssue(issue);
			IssueLocalServiceUtil.addIssue(issue2);
			FieldLocalServiceUtil.addField(field);
			FieldLocalServiceUtil.addField(field2);

		}
		catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Datenbank wurde aktuallisiert");
	}

}
