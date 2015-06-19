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

import com.liferay.portal.kernel.exception.SystemException;

import de.hska.wi.awp.datasource.model.Field;
import de.hska.wi.awp.datasource.model.Issue;
import de.hska.wi.awp.datasource.model.Status;
import de.hska.wi.awp.datasource.service.FieldLocalServiceUtil;
import de.hska.wi.awp.datasource.service.IssueLocalServiceUtil;
import de.hska.wi.awp.datasource.service.JiraUserLocalServiceUtil;
import de.hska.wi.awp.datasource.service.ProjectLocalServiceUtil;
import de.hska.wi.awp.datasource.service.StatusLocalServiceUtil;
import de.hska.wi.awp.datasource.service.persistence.StatusUtil;

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
		if (createPieModel() == null) {
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

		if (projektId != null) {
			System.out.println("alle Fields für das Projekt");
			allFields = FieldLocalServiceUtil.getAllFieldsforProject(projektId);
			pieModel.setTitle("Issue Verteilung des ausgewählten Teams");
		} else {
			System.out.println("alle Fields für den Assignee");
			allFields = FieldLocalServiceUtil
					.getAllFieldsForAssignee(studenthskaId);
			pieModel.setTitle("Issues Verteilung des ausgewählten Teammitglieds");

		}

		List<Status> allStati = StatusLocalServiceUtil.getAllJiraStati();
		TreeMap<String, Integer> statusMap = new TreeMap<String, Integer>();

		for (int i = 0; i < allStati.size(); i++) {
			statusMap.put(allStati.get(i).getStatusId(), 0);
		}

		System.out.println(statusMap);

		for (int i = 0; i < allFields.size(); i++) {

			for (Entry<String, Integer> entry : statusMap.entrySet()) {
				if (String.valueOf(allFields.get(i).getStatusId()).equals(
						entry.getKey())) {
					statusMap.put(entry.getKey(),
							statusMap.get(entry.getKey()) + 1);

				}

			}
		}

		System.out.println("!!!!!!" + statusMap);

		for (Entry<String, Integer> entry : statusMap.entrySet()) {
			System.out.println("Entry" + entry.getKey());
			if (entry.getValue() != 0) {
				System.out.println("Entry!!!!!"
						+ StatusLocalServiceUtil.getStatusNameForStatusId(entry
								.getKey().toString()));

				pieModel.set(StatusLocalServiceUtil
						.getStatusNameForStatusId(entry.getKey().toString()),
						entry.getValue());
			}
		}

		System.out.println("LLLLLLL" + pieModel.getData());

		return pieModel;
	}
}
