/**
 * The ViewBean to display the BurnDownChart for the StoryPoint Velocity
 * of the selected team or student
 *
 * @author Marc Weisenburger
 */

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
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.portlet.faces.GenericFacesPortlet;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.DateAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import de.hska.wi.awp.datasource.bean.openclosedbean.OpenClosedViewBean;
import de.hska.wi.awp.datasource.model.Field;
import de.hska.wi.awp.datasource.model.Issue;
import de.hska.wi.awp.datasource.service.FieldLocalServiceUtil;
import de.hska.wi.awp.datasource.service.IssueLocalServiceUtil;
import de.hska.wi.awp.datasource.service.ProjectLocalServiceUtil;

@SessionScoped
@ManagedBean
public class BurnDownViewBean implements Serializable{

	 
	/**
	 * Serializable
	 */
	private static final long serialVersionUID = -94301266401513498L;
	
	/**
     * Logger Util
     */
	private static Log log = LogFactoryUtil.getLog(BurnDownViewBean.class);

	
	/**
     * The LineChartModel to display
     */
	private LineChartModel areaModel;
	
	/**
     * currentStoryPoints for the team or user
     */
	private int currentStoryPoints = 0;
	
	/**
     * highest Storypoints for the team or user
     */
	private int highestStoryPoints = 0;
	
	/**
     * studenthskaId
     * recieved from the navigationportlet
     */
	private String studenthskaId;
	
	/**
     * projektId
     * recieved from the navigationportlet
     */
	private String projektId;

	/**
     * current date to set x-Axis
     */
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	Date todayDate = new Date();



	/**
     * counts all Fields for the selected project
     */
	public Integer countFieldsForProjekt;
	
	/**
     * method to check if the project has fields
     * @return Integer with the amount of Fields for the selected project
     */
	public Integer getCountFieldsForProjekt(){
		return 	FieldLocalServiceUtil.getAllFieldsforProject(projektId).size();
	}
	
	/**
     * counts all Fields for the selected user
     */
	public Integer countFieldsForUser;
	
	/**
     * method to check if the user has fields
     * @return Integer with the amount of Fields for the selected user
     */
	public Integer getCountFieldsForUser(){
		return 	FieldLocalServiceUtil.getAllFieldsForAssignee(studenthskaId).size();
	}
	

	/**
     * 
     * creates the LineChartModel for the selected team user
     * 
     * @return current LineChartModel for team or user
     */
	private LineChartModel createAreaModel() {
		log.info("creating LineChartModel");
		
		TreeMap<String, Integer> areaMap = getTreeMapForAreaModel();
		
		LineChartModel areaModel = new LineChartModel();
		areaModel.setTitle("Story Point Velocity");
		areaModel.setLegendPosition("w");
		areaModel.setStacked(true); 
		areaModel.setShowPointLabels(false);
		
		LineChartSeries created = new LineChartSeries();
		created.setFill(true);
		created.setLabel("created");

		for (Entry<String, Integer> entry : areaMap.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			created.set(key, (Number) value);
		}
		areaModel.addSeries(created);

		
		Axis xAxis2 = new DateAxis("Zeit");
		xAxis2.setTickAngle(-50);
		xAxis2.setTickFormat("%b %#d, %y");

		areaModel.getAxes().put(AxisType.X, xAxis2);
		Axis yAxis = areaModel.getAxis(AxisType.Y);
		yAxis.setLabel("StoryPoints");
		yAxis.setMin(0);
		if(projektId != null){
			areaModel.setTitle("Story Point Velocity des gesamten Teams");
		} else {
			areaModel.setTitle("Story Point Velocity des Teammitgliedes");
		}
		
		return areaModel;
	}
	
	/**
     * 
     * creates the TreeMap with datas for the team or user
     * the method decides automatically if team or user is selected
     * 
     * 
     * @return TreeMap with Datas for the LineChartModel
     */
	public TreeMap<String, Integer> getTreeMapForAreaModel(){
		log.info("creating TreeMap for StorypointVelocity");
		currentStoryPoints = 0;
		highestStoryPoints = 0;
		
		TreeMap<String, Integer> resultMap = new TreeMap<String, Integer>();
		
		List<Field> allFields = null;
		if(projektId != null){
			allFields = FieldLocalServiceUtil.getAllFieldsforProject(projektId);

		} else {
			allFields = FieldLocalServiceUtil.getAllFieldsForAssignee(studenthskaId);
		}	
		
		Date firstDate = allFields.get(1).getCreatedDate();

		Calendar start = Calendar.getInstance();
		start.setTime(firstDate);

		Calendar end = Calendar.getInstance();
		end.setTime(todayDate);
		end.add(Calendar.DATE, 1);

		

		while (!start.after(end)) {
			Date targetDay = start.getTime();
			// Do Your Work Here
			String reportDate = df.format(targetDay);
			resultMap.put(reportDate, 0);
			start.add(Calendar.DATE, 1);
		}

		for (String key : resultMap.keySet()) {
			if(highestStoryPoints < currentStoryPoints){
				highestStoryPoints = currentStoryPoints;
			}

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
					 resultMap.put(key, currentStoryPoints);

				} else if (resolutionDateString != null) {
					if (key.equals(resolutionDateString)) {
						 currentStoryPoints -= allFields.get(zl).getStorypoints();
						 resultMap.put(key, currentStoryPoints);
					}
				} else {
					resultMap.put(key, currentStoryPoints);
				}

			}


		}
		
		
		return resultMap;
		
	}
	
	/**
     * create the AreaModel
     */
	public LineChartModel getAreaModel() {
		return createAreaModel();

	}
	
	public void setAreaModel(LineChartModel areaModel) {
		this.areaModel = areaModel;
	}
	
	public String getStudenthskaId() {
		return studenthskaId;
	}

	public void setStudenthskaId(String studenthskaId) {
		this.studenthskaId = studenthskaId;
	}
	
	
	public String getProjektId() {
		return projektId;
	}

	public void setProjektId(String projektId) {
		this.projektId = projektId;

	}
	
	

}
