package de.hska.wi.awp.datasource.event;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;
import java.util.Map.Entry;

import javax.el.ELContext;
import javax.el.ValueExpression;
import javax.faces.context.FacesContext;
import javax.portlet.Event;
import javax.portlet.faces.BridgeEventHandler;
import javax.portlet.faces.event.EventNavigationResult;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.PieChartModel;

import com.liferay.faces.bridge.event.EventPayloadWrapper;

import de.hska.wi.awp.datasource.bean.burndownchartstorypointbean.BurnDownViewBean;
import de.hska.wi.awp.datasource.bean.openclosedbean.OpenClosedViewBean;
import de.hska.wi.awp.datasource.model.Field;
import de.hska.wi.awp.datasource.model.Issue;
import de.hska.wi.awp.datasource.service.FieldLocalServiceUtil;
import de.hska.wi.awp.datasource.service.IssueLocalServiceUtil;
import de.hska.wi.awp.datasource.service.ProjectLocalServiceUtil;


public class BurnDownChartStoryPointEventHandler  implements BridgeEventHandler{

	@Override
	public EventNavigationResult handleEvent(FacesContext facesContext, Event event) {
		 EventNavigationResult eventNavigationResult = null;
         String eventQName = event.getQName().toString();

         if (eventQName.equals("{http://liferay.com/events}ipc.studentSelected")) {
             System.out.print("EVENT RECIVED STUDENT");
             
             Serializable value = event.getValue();
             

             
            if (value instanceof EventPayloadWrapper) {
 				value = ((EventPayloadWrapper) value).getWrapped();
 			}

 			String hskaId = (String) value;
 			BurnDownViewBean burnDownViewBean = getBurnDownViewBean(facesContext);
 			burnDownViewBean.setStudenthskaId(hskaId);
 			burnDownViewBean.setProjektId(null);

 			OpenClosedViewBean openClosedViewBean = getOpenClosedViewBean(facesContext);
  			openClosedViewBean.setStudenthskaId(hskaId);
  			openClosedViewBean.setProjektId(null);



 			String fromAction = null;
 			String outcome = "ipc.customerSelected";
 			eventNavigationResult = new EventNavigationResult(fromAction, outcome);
             
         }

         if(eventQName.equals("{http://liferay.com/events}ipc.projectSelected")) {
        	 System.out.print("EVENT RECIVED PROJECT");
        	 
        	 
        	 Serializable value = event.getValue();
             
             if (value instanceof EventPayloadWrapper) {
  				value = ((EventPayloadWrapper) value).getWrapped();
  			}

  			String projektId = (String) value;
  			BurnDownViewBean burnDownViewBean = getBurnDownViewBean(facesContext);
  			burnDownViewBean.setProjektId(projektId);
  			burnDownViewBean.setStudenthskaId(null);
  			
  			OpenClosedViewBean openClosedViewBean = getOpenClosedViewBean(facesContext);
  			openClosedViewBean.setProjektId(projektId);
  			openClosedViewBean.setStudenthskaId(null);


//  			openClosedViewBean.setPieModel(createPieModel(projektId));
  			
  			String fromAction = null;
  			String outcome = "ipc.customerSelected";
  			eventNavigationResult = new EventNavigationResult(fromAction, outcome); 
        	 
         }
         
         return eventNavigationResult;
	}
	
	protected OpenClosedViewBean getOpenClosedViewBean(FacesContext facesContext) {
		String elExpression = "#{openClosedViewBean}";
		ELContext elContext = facesContext.getELContext();
		ValueExpression valueExpression = facesContext.getApplication().getExpressionFactory().createValueExpression(
				elContext, elExpression, OpenClosedViewBean.class);

		return (OpenClosedViewBean) valueExpression.getValue(elContext);
	}
	
	protected BurnDownViewBean getBurnDownViewBean(FacesContext facesContext) {
		String elExpression = "#{burnDownViewBean}";
		ELContext elContext = facesContext.getELContext();
		ValueExpression valueExpression = facesContext.getApplication().getExpressionFactory().createValueExpression(
				elContext, elExpression, BurnDownViewBean.class);

		return (BurnDownViewBean) valueExpression.getValue(elContext);
	}
	
	
	
//	private PieChartModel createPieModel(String hskaId) {
//		
//		
//		String thisProjectID = ProjectLocalServiceUtil
//				.getProjectIdForProjectName(hskaId);
//		
//		List<Issue> allIssues = IssueLocalServiceUtil
//				.getAllIssuesForProjectId(thisProjectID);
//
//		List<Field> allFields = FieldLocalServiceUtil
//				.getAllFieldsForIsses(allIssues);
//
//		PieChartModel pieModel = new PieChartModel();
//
//		pieModel.setLegendPosition("w");
//		pieModel.setTitle("Issues from " + hskaId + " Team");
//		pieModel.setShowDataLabels(true);
//		
//		int open = 0;
//		int progress = 0;
//		int reopend = 0;
//		int resolved = 0;
//		int closed = 0;
//
//		
//		for (int i = 0; i < allFields.size(); i++){
//			if(allFields.get(i).getStatusId() == 1){
//				open += 1;
//			} else if(allFields.get(i).getStatusId() == 3){
//				progress += 1;
//			}	else if(allFields.get(i).getStatusId() == 4){
//				reopend += 1;
//			}	else if(allFields.get(i).getStatusId() == 5){
//				resolved += 1;
//			}	else if(allFields.get(i).getStatusId() == 6){
//				closed += 1;
//			}
//			
//		
//		}
//
//		pieModel.set("Open", open);
//		System.out.println("OPEN " + open);
//		
//		pieModel.set("In Progress", progress);
//		System.out.println("Progress " + progress);
//
//		pieModel.set("Reopend", reopend);
//		System.out.println("Reopend " + reopend);
//
//		pieModel.set("Resolved", resolved);
//		System.out.println("Resolved " + resolved);
//
//		pieModel.set("Closed", closed);
//		System.out.println("Closed " + closed);
//		return pieModel;
//	}
	
	
	
	
	private TreeMap<String, Integer> storyPointVelocity;
	private int currentStoryPoints = 0;
	
	public LineChartModel bitte(String hskaId) {
		currentStoryPoints = 0;
		
		String thisProjectID = ProjectLocalServiceUtil
				.getProjectIdForProjectName(hskaId);
		
		List<Issue> allIssues = IssueLocalServiceUtil
				.getAllIssuesForProjectId(thisProjectID);

		List<Field> allFields = FieldLocalServiceUtil
				.getAllFieldsForIsses(allIssues);

		storyPointVelocity = new TreeMap<String, Integer>();

		Date firstDate = allFields.get(1).getCreatedDate();
		Date todayDate = new Date();

		Calendar start = Calendar.getInstance();
		if (start == null) {
			System.out.println("ist null");
			;
		}
		start.setTime(firstDate);

		Calendar end = Calendar.getInstance();
		if (end == null) {
			System.out.println("ist null");
			;
		}
		end.setTime(todayDate);

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

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

		LineChartModel areaModel = new LineChartModel();
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
		
		return areaModel;
	}
	

}
