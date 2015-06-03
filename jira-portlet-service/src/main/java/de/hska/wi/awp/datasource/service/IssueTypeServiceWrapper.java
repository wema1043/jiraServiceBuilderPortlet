package de.hska.wi.awp.datasource.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link IssueTypeService}.
 *
 * @author Brian Wing Shun Chan
 * @see IssueTypeService
 * @generated
 */
public class IssueTypeServiceWrapper implements IssueTypeService,
    ServiceWrapper<IssueTypeService> {
    private IssueTypeService _issueTypeService;

    public IssueTypeServiceWrapper(IssueTypeService issueTypeService) {
        _issueTypeService = issueTypeService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _issueTypeService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _issueTypeService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _issueTypeService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public IssueTypeService getWrappedIssueTypeService() {
        return _issueTypeService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedIssueTypeService(IssueTypeService issueTypeService) {
        _issueTypeService = issueTypeService;
    }

    @Override
    public IssueTypeService getWrappedService() {
        return _issueTypeService;
    }

    @Override
    public void setWrappedService(IssueTypeService issueTypeService) {
        _issueTypeService = issueTypeService;
    }
}
