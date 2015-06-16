package de.hska.wi.awp.datasource.bean;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.portlet.faces.GenericFacesPortlet;

import com.liferay.portal.kernel.exception.SystemException;

import de.hska.wi.awp.datasource.model.Field;
import de.hska.wi.awp.datasource.model.Issue;
import de.hska.wi.awp.datasource.model.Project;
import de.hska.wi.awp.datasource.service.FieldLocalServiceUtil;
import de.hska.wi.awp.datasource.service.IssueLocalServiceUtil;
import de.hska.wi.awp.datasource.service.JiraUserLocalServiceUtil;
import de.hska.wi.awp.datasource.service.JiraUserServiceUtil;
import de.hska.wi.awp.datasource.service.ProjectLocalServiceUtil;
import de.hska.wi.awp.datasource.service.StatusLocalServiceUtil;

@ManagedBean
@RequestScoped
public class StudentBean{
	
	
	public void buttonAction(ActionEvent actionEvent) {
		fillDatabase();
    }
     
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

	public void fillDatabase(){
        addMessage("Datenbank wird neu geladen");
	 	String str2 = JiraUserLocalServiceUtil.getAllMembers("HWB");
		JiraUserLocalServiceUtil.ParseJsonToMember(str2);

		String str1 = IssueLocalServiceUtil.getAllIssues();
		IssueLocalServiceUtil.ParseJsonToIssue(str1);

		String stati = StatusLocalServiceUtil.getAllStatus();
		StatusLocalServiceUtil.ParseJsonToStatus(stati);

		String projectResponse = ProjectLocalServiceUtil.getAllProjects();
		ProjectLocalServiceUtil.ParseJsonToProjects(projectResponse);
		
		Project project = ProjectLocalServiceUtil.createProject("10007");
		project.setKey("MobCo");
		project.setName("Kollaborationsplattform");
		
		Issue issue = IssueLocalServiceUtil.createIssue("50000");
		issue.setProjectId("10007");
		issue.setKey("MobCo");	
		Issue issue2 = IssueLocalServiceUtil.createIssue("50001");
		issue2.setProjectId("10007");
		issue2.setKey("MobCo");
		
		
		Field field = FieldLocalServiceUtil.createField(500);
		field.setIssueId("50000");
		field.setCreatedDate(new Date());
		field.setStatusId(3);
		field.setStorypoints(15);
		Field field2 = FieldLocalServiceUtil.createField(501);
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

		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Database is now up to date");
        addMessage("Datenbank erfolgreich geladen");

	}

}
