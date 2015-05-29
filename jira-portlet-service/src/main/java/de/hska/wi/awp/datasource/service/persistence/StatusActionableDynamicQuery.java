package de.hska.wi.awp.datasource.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import de.hska.wi.awp.datasource.model.Status;
import de.hska.wi.awp.datasource.service.StatusLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class StatusActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public StatusActionableDynamicQuery() throws SystemException {
        setBaseLocalService(StatusLocalServiceUtil.getService());
        setClass(Status.class);

        setClassLoader(de.hska.wi.awp.datasource.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("statusId");
    }
}
