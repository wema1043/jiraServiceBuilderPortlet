package de.hska.wi.awp.datasource.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import de.hska.wi.awp.datasource.model.Field;
import de.hska.wi.awp.datasource.service.FieldLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class FieldActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public FieldActionableDynamicQuery() throws SystemException {
        setBaseLocalService(FieldLocalServiceUtil.getService());
        setClass(Field.class);

        setClassLoader(de.hska.wi.awp.datasource.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("fieldId");
    }
}
