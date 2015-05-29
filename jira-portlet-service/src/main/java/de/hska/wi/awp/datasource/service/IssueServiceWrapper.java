package de.hska.wi.awp.datasource.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link IssueService}.
 *
 * @author Brian Wing Shun Chan
 * @see IssueService
 * @generated
 */
public class IssueServiceWrapper implements IssueService,
    ServiceWrapper<IssueService> {
    private IssueService _issueService;

    public IssueServiceWrapper(IssueService issueService) {
        _issueService = issueService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _issueService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _issueService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _issueService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public IssueService getWrappedIssueService() {
        return _issueService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedIssueService(IssueService issueService) {
        _issueService = issueService;
    }

    @Override
    public IssueService getWrappedService() {
        return _issueService;
    }

    @Override
    public void setWrappedService(IssueService issueService) {
        _issueService = issueService;
    }
}
