package de.hska.wi.awp.datasource.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link StudentService}.
 *
 * @author Brian Wing Shun Chan
 * @see StudentService
 * @generated
 */
public class StudentServiceWrapper implements StudentService,
    ServiceWrapper<StudentService> {
    private StudentService _studentService;

    public StudentServiceWrapper(StudentService studentService) {
        _studentService = studentService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _studentService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _studentService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _studentService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public StudentService getWrappedStudentService() {
        return _studentService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedStudentService(StudentService studentService) {
        _studentService = studentService;
    }

    @Override
    public StudentService getWrappedService() {
        return _studentService;
    }

    @Override
    public void setWrappedService(StudentService studentService) {
        _studentService = studentService;
    }
}
