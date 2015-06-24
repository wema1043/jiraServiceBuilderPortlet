package de.hska.wi.awp.datasource.bean.openclosedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.chart.PieChartModel;

import de.hska.wi.awp.datasource.model.Field;
import de.hska.wi.awp.datasource.model.Status;
import de.hska.wi.awp.datasource.service.FieldLocalServiceUtil;
import de.hska.wi.awp.datasource.service.StatusLocalServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;



/**
 * Bean for the OpenClosed Portlet
 * @author 	Marc Weisenburger
 * @date	03.06.15
*/
@SessionScoped
@ManagedBean
public class OpenClosedViewBean implements Serializable {

	/**
	 * Serializable
	 */
	private static final long serialVersionUID = -6393291273408020985L;

	/**
     * Logger Util
     */
	private static Log log = LogFactoryUtil.getLog(OpenClosedViewBean.class);

	/**
     * projektId
     * recieved from the navigationportlet
     */
	private String projektId;
	
	/**
     * studenthskaId
     * recieved from the navigationportlet
     */
	private String studenthskaId;
	
	/**
     * counts all Fields for the selected project
     */
	public Integer countFieldsForProjekt;
	
	/**
     * counts all Fields for the selected user
     */
	public Integer countFieldsForUser;
	
	/**
     * The PieChartModel to display
     */
	public PieChartModel pieModel;

	
	/**
	   * Method to create the PieChartModel
	   * @return 	PieChartModel
	   * @author 	Marc Weisenburger
	*/
	private PieChartModel createPieModel() {
		log.info("creating PieChartModel");

		PieChartModel pieModel = new PieChartModel();
		pieModel.setLegendPosition("w");
		pieModel.setTitle("Issues from Team");
		pieModel.setDataFormat("value");
		pieModel.setShowDataLabels(true);

		List<Field> allFields = new ArrayList<Field>();

		if (projektId != null) {
			allFields = FieldLocalServiceUtil.getAllFieldsforProject(projektId);
			pieModel.setTitle("Issue Verteilung des ausgewählten Teams");
		} else {
			allFields = FieldLocalServiceUtil.getAllFieldsForAssignee(studenthskaId);
			pieModel.setTitle("Issues Verteilung des ausgewählten Teammitglieds");

		}

		List<Status> allStati = StatusLocalServiceUtil.getAllJiraStati();
		TreeMap<String, Integer> statusMap = new TreeMap<String, Integer>();

		for (int i = 0; i < allStati.size(); i++) {
			statusMap.put(allStati.get(i).getStatusId(), 0);
		}

		for (int i = 0; i < allFields.size(); i++) {

			for (Entry<String, Integer> entry : statusMap.entrySet()) {
				if (String.valueOf(allFields.get(i).getStatusId()).equals(entry.getKey())) {
					statusMap.put(entry.getKey(),statusMap.get(entry.getKey()) + 1);
				}
			}
		}

		for (Entry<String, Integer> entry : statusMap.entrySet()) {
			if (entry.getValue() != 0) {

				pieModel.set(StatusLocalServiceUtil
						.getStatusNameForStatusId(entry.getKey().toString()),
						entry.getValue());
			}
		}


		return pieModel;
	}
	
	public String getProjektId() {
		return projektId;
	}

	public void setProjektId(String projektId) {
		this.projektId = projektId;
	}

	public String getStudenthskaId() {
		return studenthskaId;
	}

	public void setStudenthskaId(String studenthskaId) {
		this.studenthskaId = studenthskaId;
	}

	public PieChartModel getPieModel() {
		return createPieModel();

	}

	public void setPieModel(PieChartModel pieModel) {
		this.pieModel = pieModel;
	}
	
	/**
     * method to check if the project has fields
     * @return Integer with the amount of Fields for the selected project
     */
	public Integer getCountFieldsForProjekt(){
		return 	FieldLocalServiceUtil.getAllFieldsforProject(projektId).size();
	}
	
	/**
     * method to check if the user has fields
     * @return Integer with the amount of Fields for the selected user
     */
	public Integer getCountFieldsForUser(){
		return 	FieldLocalServiceUtil.getAllFieldsForAssignee(studenthskaId).size();
	}
	
}
