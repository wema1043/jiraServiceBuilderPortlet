package de.hska.wi.awp.datasource.bean.burndownchartstorypointbean;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

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

@ManagedBean
public class BurnDownViewBean {

	private LineChartModel areaModel;
	private TreeMap<String, Integer> storyPointVelocity;
	private int currentStoryPoints = 0;

	@PostConstruct
	public void init() {

		String thisProjectID = ProjectLocalServiceUtil
				.getProjectIdForProjectName("HWB");

		List<Issue> allIssues = IssueLocalServiceUtil
				.getAllIssuesForProjectId(thisProjectID);

		List<Field> allFields = FieldLocalServiceUtil
				.getAllFieldsForIsses(allIssues);

		storyPointVelocity = new TreeMap<String, Integer>();
		
		for (int zl = 0; zl < allFields.size(); zl++) {
			if (storyPointVelocity.containsKey(allFields.get(zl).getCreatedDate().substring(0, 10))) {
				currentStoryPoints += (int) allFields.get(zl).getStorypoints();
//				System.out.println("plus " + allFields.get(zl).getStorypoints());

				storyPointVelocity.put(allFields.get(zl).getCreatedDate().substring(0, 10), currentStoryPoints);

			} else {
				currentStoryPoints += (int) allFields.get(zl).getStorypoints();
//				System.out.println("plus " + allFields.get(zl).getStorypoints());
				storyPointVelocity.put(allFields.get(zl).getCreatedDate().substring(0, 10), currentStoryPoints);
			}
			if (!allFields.get(zl).getResolutionDate().equals("null")) {

				if (storyPointVelocity.containsKey(allFields.get(zl).getResolutionDate().substring(0, 10))) {
//					System.out.println("minus " + allFields.get(zl).getStorypoints());
					currentStoryPoints -= (int) allFields.get(zl).getStorypoints();
					storyPointVelocity.put(allFields.get(zl).getResolutionDate().substring(0, 10),currentStoryPoints);

				} else {
//					System.out.println("minus " + allFields.get(zl).getStorypoints());
					currentStoryPoints -= (int) allFields.get(zl).getStorypoints();
					storyPointVelocity.put(allFields.get(zl).getResolutionDate().substring(0, 10),currentStoryPoints);
				}
			}
			
			System.out.println(storyPointVelocity.get("2015-05-05"));
		}

		createAreaModel();
	}

	public LineChartModel getAreaModel() {
		return areaModel;
	}

	private void createAreaModel() {
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
