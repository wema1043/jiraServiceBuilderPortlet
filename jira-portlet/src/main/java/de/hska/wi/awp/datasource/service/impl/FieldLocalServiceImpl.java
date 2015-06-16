package de.hska.wi.awp.datasource.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;

import de.hska.wi.awp.datasource.NoSuchFieldException;
import de.hska.wi.awp.datasource.model.Field;
import de.hska.wi.awp.datasource.model.Issue;
import de.hska.wi.awp.datasource.service.FieldLocalServiceUtil;
import de.hska.wi.awp.datasource.service.IssueLocalServiceUtil;
import de.hska.wi.awp.datasource.service.ProjectLocalServiceUtil;
import de.hska.wi.awp.datasource.service.base.FieldLocalServiceBaseImpl;
import de.hska.wi.awp.datasource.service.persistence.FieldUtil;

/**
 * The implementation of the field local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link de.hska.wi.awp.datasource.service.FieldLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see de.hska.wi.awp.datasource.service.base.FieldLocalServiceBaseImpl
 * @see de.hska.wi.awp.datasource.service.FieldLocalServiceUtil
 */
public class FieldLocalServiceImpl extends FieldLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * de.hska.wi.awp.datasource.service.FieldLocalServiceUtil} to access the
	 * field local service.
	 */

	public List<Field> getAllFieldsForIsses(List<Issue> issues) {
		List<Field> allFields = new ArrayList<Field>();
		for (int zl = 0; zl < issues.size(); zl++) {
			try {
				allFields.add(FieldUtil.findByFieldForIssue(issues.get(zl).getIssueId()));
			} catch (NoSuchFieldException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return allFields;
	}

	public Integer countAllFieldsForAssignee(String assigneeId) {

		List<Field> allFieldsForAssignee = new ArrayList<Field>();
		try {
			allFieldsForAssignee = FieldUtil.findByFieldsForUser(assigneeId);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allFieldsForAssignee.size();

	}
	
	public List<Field> getAllFieldsForAssignee(String assigneeId) {

		List<Field> allFieldsForAssignee = new ArrayList<Field>();
		try {
			allFieldsForAssignee = FieldUtil.findByFieldsForUser(assigneeId);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Anzahl" + allFieldsForAssignee.size());
		return allFieldsForAssignee;

	}
	
	public List<Field> getAllFieldsforProject(String projektId){
		String thisProjectID = ProjectLocalServiceUtil
				.getProjectIdForProjectName(projektId);

		List<Issue> allIssues = IssueLocalServiceUtil
				.getAllIssuesForProjectId(thisProjectID);

		List<Field> allFields = FieldLocalServiceUtil
				.getAllFieldsForIsses(allIssues);
		
		return allFields;
	}

	public Integer countAllFieldsForStatus(Integer statusId, List<Field> issues) {

		List<Field> allFieldsForStatus = new ArrayList<Field>();
		try {
//			 allFieldsForStatus = FieldUtil.findByFieldsForStatus(statusId);
			for (int i = 0; i < issues.size(); i++){
				System.out.println("IssueID:" + issues.get(i).getStatusId());
				allFieldsForStatus = FieldUtil.findByFieldsForStatus(statusId, Long.toString(issues.get(i).getStatusId()));
			}

		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allFieldsForStatus.size();

	}
}
