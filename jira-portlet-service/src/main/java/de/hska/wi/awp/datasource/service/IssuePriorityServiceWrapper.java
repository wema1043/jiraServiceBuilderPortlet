package de.hska.wi.awp.datasource.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link IssuePriorityService}.
 *
 * @author Brian Wing Shun Chan
 * @see IssuePriorityService
 * @generated
 */
public class IssuePriorityServiceWrapper implements IssuePriorityService,
    ServiceWrapper<IssuePriorityService> {
    private IssuePriorityService _issuePriorityService;

    public IssuePriorityServiceWrapper(
        IssuePriorityService issuePriorityService) {
        _issuePriorityService = issuePriorityService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _issuePriorityService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _issuePriorityService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _issuePriorityService.invokeMethod(name, parameterTypes,
            arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public IssuePriorityService getWrappedIssuePriorityService() {
        return _issuePriorityService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedIssuePriorityService(
        IssuePriorityService issuePriorityService) {
        _issuePriorityService = issuePriorityService;
    }

    @Override
    public IssuePriorityService getWrappedService() {
        return _issuePriorityService;
    }

    @Override
    public void setWrappedService(IssuePriorityService issuePriorityService) {
        _issuePriorityService = issuePriorityService;
    }
}
