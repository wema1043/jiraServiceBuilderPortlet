package de.hska.wi.awp.datasource.bean.assignedissues;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.model.chart.PieChartModel;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import de.hska.wi.awp.datasource.model.Field;
import de.hska.wi.awp.datasource.model.Issue;
import de.hska.wi.awp.datasource.service.FieldLocalServiceUtil;
import de.hska.wi.awp.datasource.service.IssueLocalServiceUtil;
import de.hska.wi.awp.datasource.service.JiraUserLocalServiceUtil;
import de.hska.wi.awp.datasource.service.ProjectLocalServiceUtil;
import de.hska.wi.awp.datasource.service.StatusLocalServiceUtil;

/**
 * Portlet implementation class AssignedIssuesBackingBean
 * 
 * @author Chris Ramroth
 */
@ManagedBean(name = "assignedIssues")
@RequestScoped
public class AssignedIssuesBackingBean {

	private String studentHskaId;
	private String projectHskaId;
	private List<Field> allAssignedFields = new ArrayList<Field>();
	private List<Issue> allIssues = new ArrayList<Issue>();
	private List<Field> allFields;

	public void init() {

		if(studentHskaId != null){
		setAllAssignedFields(FieldLocalServiceUtil
				.getAllFieldsForAssignee(studentHskaId));
		}
		if(projectHskaId != null){
		setAllIssues(IssueLocalServiceUtil
				.getAllIssuesForProjectId(ProjectLocalServiceUtil
						.getProjectIdForProjectName(projectHskaId)));
		}
		// System.out.println(getStudentHskaId());
		// System.out.println(studentHskaId);
		// System.out.println(FieldLocalServiceUtil.getAllFieldsForAssignee(getStudentHskaId()).size());

	}

	public List<AssignedIssuesModelBean> getAssignedIssues()
			throws PortalException, SystemException {
		List<AssignedIssuesModelBean> assignedIssuesList = new ArrayList<AssignedIssuesModelBean>();
		List<Field> modifyableList = new ArrayList<Field>(
				getAllAssignedFields());
		Collections.sort(modifyableList,
				new AssignedIsssuesComparatorByStatus());
		for (Field singleField : modifyableList) {
			AssignedIssuesModelBean assignedIssue = new AssignedIssuesModelBean();
			// Setting the values, which are already in Field
			assignedIssue.setCreatedDate(singleField.getCreatedDate());
			assignedIssue.setResolutionDate(singleField.getResolutionDate());
			assignedIssue.setSummary(singleField.getSummary());
			if (!singleField.getTimespent().equals("null")) {
				assignedIssue.setTimespent(Double.parseDouble(singleField
						.getTimespent()) / 3600);
			} else {
				assignedIssue.setTimespent(-1);
			}
			if (!singleField.getTimeestimate().equals("null")) {
				assignedIssue.setTimeestimate(Double.parseDouble(singleField
						.getTimeestimate()) / 3600);
			} else {
				assignedIssue.setTimeestimate(-1);
			}
			if (!singleField.getTimeoriginalestimate().equals("null")) {
				assignedIssue
						.setTimeoriginalestimate(Double.parseDouble(singleField
								.getTimeoriginalestimate()) / 3600);
			} else {
				assignedIssue.setTimeoriginalestimate(-1);
			}
			if (!singleField.getAggregatetimespent().equals("null")) {
				assignedIssue
						.setAggregatetimespent(Double.parseDouble(singleField
								.getAggregatetimespent()) / 3600);
			} else {
				assignedIssue.setAggregatetimespent(-1);
			}
			if (!singleField.getAggregatetimeestimate().equals("null")) {
				assignedIssue
						.setAggregatetimeestimate(Double
								.parseDouble(singleField
										.getAggregatetimeestimate()) / 3600);
			} else {
				assignedIssue.setAggregatetimeestimate(-1);
			}
			if (!singleField.getAggregatetimeoriginalestimate().equals("null")) {
				assignedIssue.setAggregatetimeoriginalestimate(Double
						.parseDouble(singleField
								.getAggregatetimeoriginalestimate()) / 3600);
			} else {
				assignedIssue.setAggregatetimeoriginalestimate(-1);
			}
			assignedIssue.setDescription(singleField.getDescription());
			assignedIssue.setStoryPoints(singleField.getStorypoints());
			assignedIssue.setCreatorId(singleField.getCreatorId());

			// Set Issue Name
			assignedIssue.setIssueName((IssueLocalServiceUtil
					.getIssue(singleField.getIssueId())).getKey());
			// Set Status Name
			try {
				assignedIssue
						.setStatus((StatusLocalServiceUtil.getStatus(String
								.valueOf((singleField.getStatusId()))))
								.getName());
			} catch (SystemException e) {
				e.printStackTrace();
			}

			assignedIssuesList.add(assignedIssue);

		}

		return assignedIssuesList;
	}

	public PieChartModel getAssignedIssuesPieModel() {
		System.out.println("getAssignedIssuesPieModel: ");

		HashMap<String, Integer> myMap = new HashMap<String, Integer>();

		for (Issue singleIssue : getAllIssues()) {
			String assignee = FieldLocalServiceUtil
					.getAssigneeForIssue(singleIssue.getIssueId());

			if (assignee != null && !assignee.equals("")) {
				String displayName = JiraUserLocalServiceUtil
						.getDisplayNameForUserId(assignee);
				if (displayName.isEmpty()) {
					displayName = "Unassigned";
				}
				if (myMap.containsKey(displayName)) {
					myMap.put(displayName, myMap.get(displayName) + 1);
				} else {
					myMap.put(displayName, 1);
				}
			}
		}

		PieChartModel pieModel = new PieChartModel();
		pieModel.setLegendPosition("w");
		pieModel.setTitle("Assigned Issues");
		pieModel.setShowDataLabels(true);
		pieModel.setDataFormat("value");
		for (Entry<String, Integer> entry : myMap.entrySet()) {
			pieModel.set(entry.getKey(), entry.getValue());
		}

		return pieModel;
	}

	public int getIssuesCount() {
		return getAllIssues().size();
	}

	public int getFieldsCount() {
		return getAllAssignedFields().size();
	}

	public String getStudentHskaId() {
		return studentHskaId;
	}

	public void setStudentHskaId(String studentHskaId) {
		this.studentHskaId = studentHskaId;
	}

	public List<Field> getAllAssignedFields() {
		return allAssignedFields;
	}

	public void setAllAssignedFields(List<Field> allAssignedFields) {
		this.allAssignedFields = allAssignedFields;
	}

	public String getProjectHskaId() {
		return projectHskaId;
	}

	public void setProjectHskaId(String projectHskaId) {
		this.projectHskaId = projectHskaId;
	}

	public List<Field> getAllFields() {
		return allFields;
	}

	public void setAllFields(List<Field> allFields) {
		this.allFields = allFields;
	}

	public List<Issue> getAllIssues() {
		return allIssues;
	}

	public void setAllIssues(List<Issue> allIssues) {
		this.allIssues = allIssues;
	}

}
