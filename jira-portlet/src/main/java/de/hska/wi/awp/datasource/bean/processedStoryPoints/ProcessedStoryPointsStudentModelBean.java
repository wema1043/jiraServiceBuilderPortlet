package de.hska.wi.awp.datasource.bean.processedStoryPoints;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import de.hska.wi.awp.datasource.model.Field;
import de.hska.wi.awp.datasource.model.Issue;
import de.hska.wi.awp.datasource.service.FieldLocalServiceUtil;
import de.hska.wi.awp.datasource.service.IssueLocalServiceUtil;
/**
 * 
 * @author Mihai Sava und Simon Hämmerle
 *
 */
@SessionScoped
@ManagedBean(name = "processedStoryPointsStudentModelBean")
public class ProcessedStoryPointsStudentModelBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4415219164331561873L;
	
	private int summeStoryPointsStudent;
	private int summeBacklogStoryPointsGruppe;
	private int summeProcessedStoryPointsGruppe;
	private int percentProcessedStoryPointsStudent;
	private int percentProcessedStoryPointsGruppe;
	private String studentId;	//maxi1010	
	private String projectId;	//12345
	private String projectKey; 	//AWP
	
	/**
	 * Logger Util
	 */
	private static Log log = LogFactoryUtil.getLog(ProcessedStoryPointsStudentModelBean.class);
	
	public int getSummeStoryPointsStudent() {
		return summeStoryPointsStudent;
	}
	public int getSummeBacklogStoryPointsGruppe() {
		this.setProperties();
		return summeBacklogStoryPointsGruppe;
	}
	public int getSummeProcessedStoryPointsGruppe() {
		return summeProcessedStoryPointsGruppe;
	}
	public int getPercentProcessedStoryPointsStudent() {
		return percentProcessedStoryPointsStudent;
	}
	public int getPercentProcessedStoryPointsGruppe() {
		return percentProcessedStoryPointsGruppe;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	
	public String getProjectKey() {
		return projectKey;
	}
	public void setProjectKey(String projectKey) {
		this.projectKey = projectKey;
	}
	public void setProperties(){
		log.info("BEGIN: setProperties");
		
		String studentName = studentId;
		String jiraProjectId = projectId;
		List<Issue> allIssuesForProject = IssueLocalServiceUtil.getAllIssuesForProjectId(jiraProjectId);
		
		int totalBacklogStoryPoints = 0;
		int studentStoryPoints = 0;
		int totalProcessedStoryPointsGruppe = 0;
		List<Field> allFieldsForIssues = FieldLocalServiceUtil.getAllFieldsForIsses(allIssuesForProject);
		
		for(Field field : allFieldsForIssues){
			if(field.getStatusId() == 5 || field.getStatusId() == 6){
				if(studentName.equals(field.getAssigneeId())){
					studentStoryPoints += field.getStorypoints();
				}
				totalProcessedStoryPointsGruppe += field.getStorypoints();
			}
			totalBacklogStoryPoints += field.getStorypoints();
		}
		
		summeBacklogStoryPointsGruppe = totalBacklogStoryPoints;
		summeStoryPointsStudent = studentStoryPoints;
		summeProcessedStoryPointsGruppe = totalProcessedStoryPointsGruppe;
		percentProcessedStoryPointsStudent = (summeStoryPointsStudent*100)/summeProcessedStoryPointsGruppe;
		percentProcessedStoryPointsGruppe = (summeProcessedStoryPointsGruppe*100)/summeBacklogStoryPointsGruppe;
		
		log.info("BEGIN: setProperties");
	}

}
