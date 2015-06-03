package de.hska.wi.awp.datasource.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;

import de.hska.wi.awp.datasource.model.Field;
import de.hska.wi.awp.datasource.service.base.FieldLocalServiceBaseImpl;
import de.hska.wi.awp.datasource.service.persistence.FieldUtil;

/**
 * The implementation of the field local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link de.hska.wi.awp.datasource.service.FieldLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
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
     * Never reference this interface directly. Always use {@link de.hska.wi.awp.datasource.service.FieldLocalServiceUtil} to access the field local service.
     */
	
	public Integer countAllFieldsForAssignee(String assigneeId){
		
		List<Field> allFieldsForAssignee = new ArrayList<Field>();
		try {
			allFieldsForAssignee = FieldUtil.findByFieldsForUser(assigneeId);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allFieldsForAssignee.size();
		
	}
}
