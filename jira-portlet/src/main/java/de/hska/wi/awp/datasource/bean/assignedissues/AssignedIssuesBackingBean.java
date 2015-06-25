package de.hska.wi.awp.datasource.bean.assignedissues;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.chart.PieChartModel;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import de.hska.wi.awp.datasource.bean.openclosedbean.OpenClosedViewBean;
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
 * @date 11.06.2015
 */
/**
 * @author Chris Ramroth
 *
 */
@ManagedBean(name = "assignedIssues")
@SessionScoped
public class AssignedIssuesBackingBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7550897281266754431L;
	private String studentHskaId;
	private String projectHskaId;
	private List<Field> allAssignedFields = new ArrayList<Field>();
	private List<Issue> allIssues = new ArrayList<Issue>();
	private List<Field> allFields;

	private static Log log = LogFactoryUtil
			.getLog(AssignedIssuesBackingBean.class);

	
	/**
	 * This Method finds a list of assigned Issues for the selected student
	 * @return List<AssignedIssuesModelBean>
	 * @throws PortalException
	 * @throws SystemException
	 * @author Chris Ramroth
	 */
	public List<AssignedIssuesModelBean> getAssignedIssues()
			throws PortalException, SystemException {

		if (studentHskaId != null) {
			setAllAssignedFields(FieldLocalServiceUtil
					.getAllFieldsForAssignee(studentHskaId));
		}

		List<AssignedIssuesModelBean> assignedIssuesList = new ArrayList<AssignedIssuesModelBean>();
		List<Field> modifyableList = new ArrayList<Field>(
				getAllAssignedFields());
		Collections.sort(modifyableList,
				new AssignedIssuesComparatorByStatus());
		for (Field singleField : modifyableList) {
			AssignedIssuesModelBean assignedIssue = new AssignedIssuesModelBean();
			// Setting the values, which are already in Field
			assignedIssue.setCreatedDate(singleField.getCreatedDate());
			assignedIssue.setResolutionDate(singleField.getResolutionDate());
			assignedIssue.setSummary(singleField.getSummary());
			if (singleField.getTimespent() != 0) {
				assignedIssue.setTimespent(singleField
						.getTimespent() / 3600);
			} else {
				assignedIssue.setTimespent(-1);
			}
			if (singleField.getTimeestimate() != 0) {
				assignedIssue.setTimeestimate(singleField
						.getTimeestimate() / 3600);
			} else {
				assignedIssue.setTimeestimate(-1);
			}
			if (singleField.getTimeoriginalestimate() != 0) {
				assignedIssue
						.setTimeoriginalestimate(singleField
								.getTimeoriginalestimate() / 3600);
			} else {
				assignedIssue.setTimeoriginalestimate(-1);
			}
			if (singleField.getAggregatetimespent() != 0) {
				assignedIssue
						.setAggregatetimespent(singleField
								.getAggregatetimespent() / 3600);
			} else {
				assignedIssue.setAggregatetimespent(-1);
			}
			if (singleField.getAggregatetimeestimate() != 0) {
				assignedIssue
						.setAggregatetimeestimate(singleField
										.getAggregatetimeestimate() / 3600);
			} else {
				assignedIssue.setAggregatetimeestimate(-1);
			}
			if (singleField.getAggregatetimeoriginalestimate() != 0) {
				assignedIssue.setAggregatetimeoriginalestimate(singleField
								.getAggregatetimeoriginalestimate() / 3600);
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
	
	
	/**
	 * This method returns a PieChartModel of all the projects issues and their assignees
	 * @return PieChartModel
	 * @author Chris Ramroth
	 */
	public PieChartModel getAssignedIssuesPieModel() {
		System.out.println("getAssignedIssuesPieModel: ");

		if (studentHskaId != null) {
			setAllAssignedFields(FieldLocalServiceUtil
					.getAllFieldsForAssignee(studentHskaId));
		}
		if (projectHskaId != null) {
			setAllIssues(IssueLocalServiceUtil
					.getAllIssuesForProjectId(ProjectLocalServiceUtil
							.getProjectIdForProjectName(projectHskaId)));
		}

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

	/**
	 * This method returns the amount of issues in this project
	 * @return int
	 * @author Chris Ramroth
	 */
	public int getIssuesCount() {
		if (projectHskaId != null) {
			return IssueLocalServiceUtil.getAllIssuesForProjectId(
					ProjectLocalServiceUtil
							.getProjectIdForProjectName(projectHskaId)).size();
		} else {
			return 0;
		}
	}

	/**
	 * this method returns the amount of assigned issues for the selected student
	 * @return int 
	 * @author Chris Ramroth
	 */
	public int getFieldsCount() {
		if (studentHskaId != null) {
			return FieldLocalServiceUtil.getAllFieldsForAssignee(studentHskaId)
					.size();
		} else {
			return 0;
		}
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
