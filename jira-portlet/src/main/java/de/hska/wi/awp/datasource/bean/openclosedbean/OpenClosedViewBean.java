package de.hska.wi.awp.datasource.bean.openclosedbean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.PieChartModel;

import de.hska.wi.awp.datasource.service.FieldLocalServiceUtil;

@ManagedBean
public class OpenClosedViewBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6393291273408020985L;
	
	
	private PieChartModel pieModel;

//	@PostConstruct
//	public void init() {
//		System.out.println("init");
//
//		createPieModel();
//	}

	public PieChartModel getPieModel() {
		return pieModel;
	}
	
	

	public void setPieModel(PieChartModel pieModel) {
		this.pieModel = pieModel;
	}

//	private void createPieModel() {
//
//		pieModel = new PieChartModel();
//
//		pieModel.setLegendPosition("w");
//		pieModel.setTitle("Issues from HWB Team");
//		pieModel.setShowDataLabels(true);
//		pieModel.set("Open", FieldLocalServiceUtil.countAllFieldsForStatus(1));
//		pieModel.set("In Progress", FieldLocalServiceUtil.countAllFieldsForStatus(3));
//		pieModel.set("Reopend", FieldLocalServiceUtil.countAllFieldsForStatus(4));
//		pieModel.set("Resolved", FieldLocalServiceUtil.countAllFieldsForStatus(5));
//		pieModel.set("Closed", FieldLocalServiceUtil.countAllFieldsForStatus(6));
//
//
//
//		System.out.println("done");
//	}

}
