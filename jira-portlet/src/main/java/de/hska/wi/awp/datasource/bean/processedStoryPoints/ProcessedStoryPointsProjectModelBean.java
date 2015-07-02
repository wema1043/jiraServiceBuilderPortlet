package de.hska.wi.awp.datasource.bean.processedStoryPoints;

import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.chart.DonutChartModel;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import de.hska.wi.awp.datasource.model.Field;
import de.hska.wi.awp.datasource.model.Issue;
import de.hska.wi.awp.datasource.service.FieldLocalServiceUtil;
import de.hska.wi.awp.datasource.service.IssueLocalServiceUtil;

@ManagedBean(name = "processedStoryPointsProjectModelBean")
@SessionScoped
public class ProcessedStoryPointsProjectModelBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6126510254626256402L;

	/**
	 * Logger Util
	 */
	private static Log log = LogFactoryUtil.getLog(ProcessedStoryPointsProjectModelBean.class);
	
	private String projectKey; //AWP
	private String projectId; //12345
	private int totalProcessedStoryPointsGruppe;
	private DonutChartModel processedStoryPointsDonutModel;

	public String getProjectKey() {
		return projectKey;
	}

	public void setProjectKey(String projectKey) {
		this.projectKey = projectKey;
	}
	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public int getTotalProcessedStoryPointsGruppe() {
		createProcessedStoryPointsDonutModel();
		return totalProcessedStoryPointsGruppe;
	}

	public DonutChartModel getProcessedStoryPointsDonutModel() {
		return processedStoryPointsDonutModel;
	}
	
	private void createProcessedStoryPointsDonutModel() {
		log.info("BEGIN: ProcessedStoryPointsProjectModelBean-createProcessedStoryPointsDonutModel");
		
		processedStoryPointsDonutModel = initDonutModel();
		processedStoryPointsDonutModel.setTitle("Verteilung - Processed Story Points pro Student");
		processedStoryPointsDonutModel.setLegendPosition("e");
		processedStoryPointsDonutModel.setSliceMargin(5);
		processedStoryPointsDonutModel.setShowDataLabels(true);
		processedStoryPointsDonutModel.setDataFormat("value");
		processedStoryPointsDonutModel.setShadow(false);
		
		log.info("END: ProcessedStoryPointsProjectModelBean-createProcessedStoryPointsDonutModel");
    }
 
    private DonutChartModel initDonutModel() {
    	log.info("END: ProcessedStoryPointsProjectModelBean-initDonutModel");
    	
        DonutChartModel model = new DonutChartModel();
        Map<String, Number> circle1 = new LinkedHashMap<String, Number>();
        String jiraProjectId = projectId;
        
        List<Issue> allIssuesForProject = IssueLocalServiceUtil.getAllIssuesForProjectId(jiraProjectId);
        
        int totalProcessedStoryPointsGruppe = 0;
		List<Field> allFieldsForIssues = FieldLocalServiceUtil.getAllFieldsForIsses(allIssuesForProject);
		
		Set<String> students = new HashSet<String>();
		for(Field field : allFieldsForIssues){
			if(field.getStatusId() == 5 || field.getStatusId() == 6){
				students.add(field.getAssigneeId());
				totalProcessedStoryPointsGruppe += field.getStorypoints();
			}
		}
		this.totalProcessedStoryPointsGruppe = totalProcessedStoryPointsGruppe;
		
		for(String student : students){
			int processedStoryPoints = 0;
			for(Field field : allFieldsForIssues){
				if(student.equals(field.getAssigneeId())){
					processedStoryPoints += field.getStorypoints();
				}
			}
			circle1.put(student, processedStoryPoints);
		}
        model.addCircle(circle1);
        
        log.info("END: ProcessedStoryPointsProjectModelBean-initDonutModel");
        
        return model;
    }
}
