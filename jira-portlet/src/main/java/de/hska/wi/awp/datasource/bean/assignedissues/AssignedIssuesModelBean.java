/**
 * 
 */
package de.hska.wi.awp.datasource.bean.assignedissues;

import java.util.Date;

/**
 * @author Chris Ramroth
 *
 */
public class AssignedIssuesModelBean {
	private String issueName;
	private Date createdDate;
	private Date resolutionDate;
	private String summary;
	private double timespent;
	private double timeestimate;
	private double timeoriginalestimate;
	private double aggregatetimespent;
	private double aggregatetimeoriginalestimate;
	private double aggregatetimeestimate;
	private String description;
	private long storyPoints;
	private String creatorId;
	private String assigneeid;
	/**
	 * @return the issueName
	 */
	public String getIssueName() {
		return issueName;
	}
	/**
	 * @param issueName the issueName to set
	 */
	public void setIssueName(String issueName) {
		this.issueName = issueName;
	}
	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}
	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	/**
	 * @return the resolutionDate
	 */
	public Date getResolutionDate() {
		return resolutionDate;
	}
	/**
	 * @param resolutionDate the resolutionDate to set
	 */
	public void setResolutionDate(Date resolutionDate) {
		this.resolutionDate = resolutionDate;
	}
	/**
	 * @return the timespent
	 */
	public double getTimespent() {
		return timespent;
	}
	/**
	 * @param timespent the timespent to set
	 */
	public void setTimespent(double timespent) {
		this.timespent = timespent;
	}
	/**
	 * @return the timeestimate
	 */
	public double getTimeestimate() {
		return timeestimate;
	}
	/**
	 * @param timeestimate the timeestimate to set
	 */
	public void setTimeestimate(double timeestimate) {
		this.timeestimate = timeestimate;
	}
	/**
	 * @return the timeorigionalestimate
	 */
	public double getTimeoriginalestimate() {
		return timeoriginalestimate;
	}
	/**
	 * @param timeorigionalestimate the timeorigionalestimate to set
	 */
	public void setTimeoriginalestimate(double timeoriginalestimate) {
		this.timeoriginalestimate = timeoriginalestimate;
	}
	/**
	 * @return the aggregatetimespent
	 */
	public double getAggregatetimespent() {
		return aggregatetimespent;
	}
	/**
	 * @param aggregatetimespent the aggregatetimespent to set
	 */
	public void setAggregatetimespent(double aggregatetimespent) {
		this.aggregatetimespent = aggregatetimespent;
	}
	/**
	 * @return the aggregatetimeoriginalestimate
	 */
	public double getAggregatetimeoriginalestimate() {
		return aggregatetimeoriginalestimate;
	}
	/**
	 * @param aggregatetimeoriginalestimate the aggregatetimeoriginalestimate to set
	 */
	public void setAggregatetimeoriginalestimate(
			double aggregatetimeoriginalestimate) {
		this.aggregatetimeoriginalestimate = aggregatetimeoriginalestimate;
	}
	/**
	 * @return the aggregatetimeestimate
	 */
	public double getAggregatetimeestimate() {
		return aggregatetimeestimate;
	}
	/**
	 * @param aggregatetimeestimate the aggregatetimeestimate to set
	 */
	public void setAggregatetimeestimate(double aggregatetimeestimate) {
		this.aggregatetimeestimate = aggregatetimeestimate;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the storyPoints
	 */
	public long getStoryPoints() {
		return storyPoints;
	}
	/**
	 * @param l the storyPoints to set
	 */
	public void setStoryPoints(long l) {
		this.storyPoints = l;
	}
	/**
	 * @return the creatorId
	 */
	public String getCreatorId() {
		return creatorId;
	}
	/**
	 * @param creatorId the creatorId to set
	 */
	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}
	/**
	 * @return the assigneeid
	 */
	public String getAssigneeid() {
		return assigneeid;
	}
	/**
	 * @param assigneeid the assigneeid to set
	 */
	public void setAssigneeid(String assigneeid) {
		this.assigneeid = assigneeid;
	}
	private String status;
	
	

	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
