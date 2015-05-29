package de.hska.wi.awp.datasource.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link FieldService}.
 *
 * @author Brian Wing Shun Chan
 * @see FieldService
 * @generated
 */
public class FieldServiceWrapper implements FieldService,
    ServiceWrapper<FieldService> {
    private FieldService _fieldService;

    public FieldServiceWrapper(FieldService fieldService) {
        _fieldService = fieldService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _fieldService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _fieldService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _fieldService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public FieldService getWrappedFieldService() {
        return _fieldService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedFieldService(FieldService fieldService) {
        _fieldService = fieldService;
    }

    @Override
    public FieldService getWrappedService() {
        return _fieldService;
    }

    @Override
    public void setWrappedService(FieldService fieldService) {
        _fieldService = fieldService;
    }
}
