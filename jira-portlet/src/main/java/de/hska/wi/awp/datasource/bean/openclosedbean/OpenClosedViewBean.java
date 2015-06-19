package de.hska.wi.awp.datasource.bean.openclosedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.chart.PieChartModel;

import de.hska.wi.awp.datasource.model.Field;
import de.hska.wi.awp.datasource.model.Issue;
import de.hska.wi.awp.datasource.service.FieldLocalServiceUtil;
import de.hska.wi.awp.datasource.service.IssueLocalServiceUtil;
import de.hska.wi.awp.datasource.service.JiraUserLocalServiceUtil;
import de.hska.wi.awp.datasource.service.ProjectLocalServiceUtil;

@SessionScoped
@ManagedBean
public class OpenClosedViewBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6393291273408020985L;
			
	private PieChartModel pieModel;

	private String projektId;

	public String getProjektId() {
		return projektId;
	}

	public void setProjektId(String projektId) {
		this.projektId = projektId;

	}
	
	private String studenthskaId;

	
	public String getStudenthskaId() {
		return studenthskaId;
	}

	public void setStudenthskaId(String studenthskaId) {
		System.out.println("setter" + studenthskaId);
		this.studenthskaId = studenthskaId;
	}
	
	public PieChartModel getPieModel() {
		if(createPieModel() == null){
			System.out.println("Pie Chart ist null");
		} else {
			System.out.println("Pie Chart ist nicht null");

		}
		return createPieModel();

	}

	public void setPieModel(PieChartModel pieModel) {
		this.pieModel = pieModel;
	}

	

	private PieChartModel createPieModel() {
		System.out.println("create PieModel");
		System.out.println("studentId: " + studenthskaId);
		PieChartModel pieModel = new PieChartModel();
		pieModel.setLegendPosition("w");
		pieModel.setTitle("Issues from Team");
		pieModel.setDataFormat("value");
		pieModel.setShowDataLabels(true);


		List<Field> allFields = new ArrayList<Field>();
		if(projektId != null){
			System.out.println("alle Fields für das Projekt");
			allFields = FieldLocalServiceUtil.getAllFieldsforProject(projektId);
			pieModel.setTitle("Issue Verteilung des ausgewählten Teams");
		} else {
			System.out.println("alle Fields für den Assignee");
			allFields = FieldLocalServiceUtil.getAllFieldsForAssignee(studenthskaId);
			pieModel.setTitle("Issues Verteilung des ausgewählten Teammitglieds");


		}
			

		int open = 0;
		int progress = 0;
		int reopend = 0;
		int resolved = 0;
		int closed = 0;

		for (int i = 0; i < allFields.size(); i++) {
			if (allFields.get(i).getStatusId() == 1) {
				open += 1;
			} else if (allFields.get(i).getStatusId() == 3) {
				progress += 1;
			} else if (allFields.get(i).getStatusId() == 4) {
				reopend += 1;
			} else if (allFields.get(i).getStatusId() == 5) {
				resolved += 1;
			} else if (allFields.get(i).getStatusId() == 6) {
				closed += 1;
			}

		}

		pieModel.set("Open ", open);
		pieModel.set("In Progress ", progress);
		pieModel.set("Reopend ", reopend);
		pieModel.set("Resolved ", resolved);
		pieModel.set("Closed ", closed);
		
		return pieModel;
	}

}
