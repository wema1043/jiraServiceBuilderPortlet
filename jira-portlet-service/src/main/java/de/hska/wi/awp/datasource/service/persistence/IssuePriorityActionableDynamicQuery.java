package de.hska.wi.awp.datasource.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import de.hska.wi.awp.datasource.model.IssuePriority;
import de.hska.wi.awp.datasource.service.IssuePriorityLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class IssuePriorityActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public IssuePriorityActionableDynamicQuery() throws SystemException {
        setBaseLocalService(IssuePriorityLocalServiceUtil.getService());
        setClass(IssuePriority.class);

        setClassLoader(de.hska.wi.awp.datasource.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("priorityId");
    }
}
