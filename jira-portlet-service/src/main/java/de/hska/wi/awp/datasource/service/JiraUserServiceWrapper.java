package de.hska.wi.awp.datasource.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link JiraUserService}.
 *
 * @author Brian Wing Shun Chan
 * @see JiraUserService
 * @generated
 */
public class JiraUserServiceWrapper implements JiraUserService,
    ServiceWrapper<JiraUserService> {
    private JiraUserService _jiraUserService;

    public JiraUserServiceWrapper(JiraUserService jiraUserService) {
        _jiraUserService = jiraUserService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _jiraUserService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _jiraUserService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _jiraUserService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public JiraUserService getWrappedJiraUserService() {
        return _jiraUserService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedJiraUserService(JiraUserService jiraUserService) {
        _jiraUserService = jiraUserService;
    }

    @Override
    public JiraUserService getWrappedService() {
        return _jiraUserService;
    }

    @Override
    public void setWrappedService(JiraUserService jiraUserService) {
        _jiraUserService = jiraUserService;
    }
}
