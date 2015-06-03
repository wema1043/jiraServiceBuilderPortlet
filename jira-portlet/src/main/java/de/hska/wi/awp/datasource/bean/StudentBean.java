package de.hska.wi.awp.datasource.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import com.liferay.portal.kernel.exception.SystemException;

import de.hska.wi.awp.datasource.service.FieldLocalServiceUtil;
import de.hska.wi.awp.datasource.service.IssueLocalServiceUtil;
import de.hska.wi.awp.datasource.service.JiraUserLocalServiceUtil;
import de.hska.wi.awp.datasource.service.JiraUserServiceUtil;

@ManagedBean
public class StudentBean {

	@PostConstruct
	public void init() {
		countMarcsIssues = FieldLocalServiceUtil.countAllFieldsForAssignee("wema1043");
		String str2 = JiraUserLocalServiceUtil.getAllMembers("HWB");
		JiraUserLocalServiceUtil.ParseJsonToMember(str2);

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
