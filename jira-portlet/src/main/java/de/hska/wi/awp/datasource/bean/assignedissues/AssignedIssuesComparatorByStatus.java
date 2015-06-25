/**
 * 
 */
package de.hska.wi.awp.datasource.bean.assignedissues;

import java.util.Comparator;

import de.hska.wi.awp.datasource.model.Field;

/**
 * @author Chris Ramroth
 * provides the Comparator to sort a List of Fields by its StatusId
 * 1-Open, 3-In Progress, 4-Reopend, 5-Resolved, 6-Closed 
 */
public class AssignedIssuesComparatorByStatus implements Comparator<Field> {
	@Override
	public int compare(Field field1, Field field2){
		return (int) (field1.getStatusId() - field2.getStatusId());
	}
}
