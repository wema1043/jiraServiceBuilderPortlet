package de.hska.wi.awp.datasource.bean.burndownchartstorypointbean;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.portlet.faces.GenericFacesPortlet;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import de.hska.wi.awp.datasource.model.Field;
import de.hska.wi.awp.datasource.model.Issue;
import de.hska.wi.awp.datasource.service.FieldLocalServiceUtil;
import de.hska.wi.awp.datasource.service.IssueLocalServiceUtil;
import de.hska.wi.awp.datasource.service.ProjectLocalServiceUtil;

@RequestScoped
@ManagedBean
public class BurnDownViewBean implements Serializable{

	 
	/**
	 * 
	 */
	private static final long serialVersionUID = -94301266401513498L;
	
	
	private LineChartModel areaModel;
	private TreeMap<String, Integer> storyPointVelocity;
	private int currentStoryPoints = 0;
	private String studenthskaId;
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

	
	
	public void setAreaModel(LineChartModel areaModel) {
		this.areaModel = areaModel;
	}
	
	public String getStudenthskaId() {
		return studenthskaId;
	}

	public void setStudenthskaId(String studenthskaId) {
		System.out.println("setter" + studenthskaId);
		this.studenthskaId = studenthskaId;
	}
	
	private String projektId;
	
	public String getProjektId() {
		return projektId;
	}

	public void setProjektId(String projektId) {
		this.projektId = projektId;

	}
	
	private List<Field> getAllFieldsForProjekt(){
		String thisProjectID = ProjectLocalServiceUtil
				.getProjectIdForProjectName(projektId);

		List<Issue> allIssues = IssueLocalServiceUtil
				.getAllIssuesForProjectId(thisProjectID);

		List<Field> allFields = FieldLocalServiceUtil
				.getAllFieldsForIsses(allIssues);
		
		return allFields;
	}


	
	public LineChartModel getAreaModel() {
		createAreaModel();
		return areaModel;
	}

	private void createAreaModel() {
		
		List<Field> allFields = getAllFieldsForProjekt();

		storyPointVelocity = new TreeMap<String, Integer>();

		Date firstDate = allFields.get(1).getCreatedDate();
		Date todayDate = new Date();

		Calendar start = Calendar.getInstance();
		start.setTime(firstDate);

		Calendar end = Calendar.getInstance();
		end.setTime(todayDate);


		while (!start.after(end)) {
			Date targetDay = start.getTime();
			// Do Your Work Here
			String reportDate = df.format(targetDay);
			storyPointVelocity.put(reportDate, 0);
			start.add(Calendar.DATE, 1);
		}

		for (String key : storyPointVelocity.keySet()) {

			for (int zl = 0; zl < allFields.size(); zl++) {
				Date createdDate = allFields.get(zl).getCreatedDate();
				String createdDateString = df.format(createdDate);
				Date resolutionDate = allFields.get(zl).getResolutionDate();
				String resolutionDateString = null;
				if (resolutionDate != null) {
					resolutionDateString = df.format(resolutionDate);
				}

				if (key.equals(createdDateString)) {
					 currentStoryPoints += allFields.get(zl).getStorypoints();
					 storyPointVelocity.put(key, currentStoryPoints);

				} else if (resolutionDateString != null) {
					if (key.equals(resolutionDateString)) {
						 currentStoryPoints -= allFields.get(zl).getStorypoints();
						 storyPointVelocity.put(key, currentStoryPoints);
					}
				} else {
					 storyPointVelocity.put(key, currentStoryPoints);
				}

			}

		}
		
		areaModel = new LineChartModel();
		LineChartSeries created = new LineChartSeries();
		created.setFill(true);
		created.setLabel("created");

		for (Entry<String, Integer> entry : storyPointVelocity.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			created.set(key, (Number) value);
		}

		areaModel.addSeries(created);

		areaModel.setTitle("Story Point Velocity");
		areaModel.setLegendPosition("w");
		areaModel.setStacked(true); 
		areaModel.setShowPointLabels(true);

		Axis xAxis = new CategoryAxis("Zeit");
		xAxis.setTickAngle(-50);

		areaModel.getAxes().put(AxisType.X, xAxis);
		Axis yAxis = areaModel.getAxis(AxisType.Y);
		yAxis.setLabel("StoryPoints");
		yAxis.setMin(0);
		yAxis.setMax(700);
	}

}
