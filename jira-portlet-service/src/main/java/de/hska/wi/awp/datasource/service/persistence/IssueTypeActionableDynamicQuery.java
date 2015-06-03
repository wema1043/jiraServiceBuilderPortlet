package de.hska.wi.awp.datasource.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import de.hska.wi.awp.datasource.model.IssueType;
import de.hska.wi.awp.datasource.service.IssueTypeLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class IssueTypeActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public IssueTypeActionableDynamicQuery() throws SystemException {
        setBaseLocalService(IssueTypeLocalServiceUtil.getService());
        setClass(IssueType.class);

        setClassLoader(de.hska.wi.awp.datasource.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("issueId");
    }
}
