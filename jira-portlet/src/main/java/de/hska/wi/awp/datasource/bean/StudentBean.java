package de.hska.wi.awp.datasource.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

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
public class StudentBean {

	@PostConstruct
	public void init() {

		this.fillDatabase();
		
		countMarcsIssues = FieldLocalServiceUtil.countAllFieldsForAssignee("wema1043");
	}
	
	public void fillDatabase(){
//		String str2 = JiraUserLocalServiceUtil.getAllMembers("HWB");
//		JiraUserLocalServiceUtil.ParseJsonToMember(str2);
//
//		String str1 = IssueLocalServiceUtil.getAllIssues();
//		IssueLocalServiceUtil.ParseJsonToIssue(str1);
//
//		String stati = StatusLocalServiceUtil.getAllStatus();
//		StatusLocalServiceUtil.ParseJsonToStatus(stati);
//
//		String projectResponse = ProjectLocalServiceUtil.getAllProjects();
//		ProjectLocalServiceUtil.ParseJsonToProjects(projectResponse);
		
//		String thisProjectID = ProjectLocalServiceUtil.getProjectIdForProjectName("HWB");
//		System.out.println("ID: " + thisProjectID);
//
//		List<Issue> allIssues = IssueLocalServiceUtil.getAllIssuesForProjectId(thisProjectID);
//		System.out.println("SIZE Issue: " + allIssues.size());
//		
//		List<Field> allFields = FieldLocalServiceUtil.getAllFieldsForIsses(allIssues);
//		System.out.println("SIZE Field: " + allFields.size());
//		for (int zl = 0; zl < allFields.size(); zl++) {
//			System.out.println("summary: " + allFields.get(zl).getSummary());
//
//			
//		}

	}

	private Integer countMarcsIssues;

	public Integer getCountMarcsIssues() {
		return countMarcsIssues;

	}

	private String student;

	public String getStudent() throws Exception {

		String str2 = JiraUserLocalServiceUtil.getAllMembers("HWB");
		JiraUserLocalServiceUtil.ParseJsonToMember(str2);
		//
		// String str1 = IssueLocalServiceUtil.getAllIssues();
		// IssueLocalServiceUtil.ParseJsonToIssue(str1);

		return "correct ";

	}

	public void setStudent(String student) {
		this.student = student;
	}

}
