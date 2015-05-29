package de.hska.wi.awp.datasource.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import de.hska.wi.awp.datasource.model.Issue;
import de.hska.wi.awp.datasource.service.IssueLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class IssueActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public IssueActionableDynamicQuery() throws SystemException {
        setBaseLocalService(IssueLocalServiceUtil.getService());
        setClass(Issue.class);

        setClassLoader(de.hska.wi.awp.datasource.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("issueId");
    }
}
