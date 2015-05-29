package de.hska.wi.awp.datasource.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link StatusService}.
 *
 * @author Brian Wing Shun Chan
 * @see StatusService
 * @generated
 */
public class StatusServiceWrapper implements StatusService,
    ServiceWrapper<StatusService> {
    private StatusService _statusService;

    public StatusServiceWrapper(StatusService statusService) {
        _statusService = statusService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _statusService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _statusService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _statusService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public StatusService getWrappedStatusService() {
        return _statusService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedStatusService(StatusService statusService) {
        _statusService = statusService;
    }

    @Override
    public StatusService getWrappedService() {
        return _statusService;
    }

    @Override
    public void setWrappedService(StatusService statusService) {
        _statusService = statusService;
    }
}
