package de.hska.wi.awp.datasource.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import de.hska.wi.awp.datasource.model.Student;
import de.hska.wi.awp.datasource.service.StudentLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class StudentActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public StudentActionableDynamicQuery() throws SystemException {
        setBaseLocalService(StudentLocalServiceUtil.getService());
        setClass(Student.class);

        setClassLoader(de.hska.wi.awp.datasource.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("studentId");
    }
}
