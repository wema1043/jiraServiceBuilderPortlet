package de.hska.wi.awp.datasource.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link JiraUserLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see JiraUserLocalService
 * @generated
 */
public class JiraUserLocalServiceWrapper implements JiraUserLocalService,
    ServiceWrapper<JiraUserLocalService> {
    private JiraUserLocalService _jiraUserLocalService;

    public JiraUserLocalServiceWrapper(
        JiraUserLocalService jiraUserLocalService) {
        _jiraUserLocalService = jiraUserLocalService;
    }

    /**
    * Adds the jira user to the database. Also notifies the appropriate model listeners.
    *
    * @param jiraUser the jira user
    * @return the jira user that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public de.hska.wi.awp.datasource.model.JiraUser addJiraUser(
        de.hska.wi.awp.datasource.model.JiraUser jiraUser)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _jiraUserLocalService.addJiraUser(jiraUser);
    }

    /**
    * Creates a new jira user with the primary key. Does not add the jira user to the database.
    *
    * @param jiraUserPK the primary key for the new jira user
    * @return the new jira user
    */
    @Override
    public de.hska.wi.awp.datasource.model.JiraUser createJiraUser(
        de.hska.wi.awp.datasource.service.persistence.JiraUserPK jiraUserPK) {
        return _jiraUserLocalService.createJiraUser(jiraUserPK);
    }

    /**
    * Deletes the jira user with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param jiraUserPK the primary key of the jira user
    * @return the jira user that was removed
    * @throws PortalException if a jira user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public de.hska.wi.awp.datasource.model.JiraUser deleteJiraUser(
        de.hska.wi.awp.datasource.service.persistence.JiraUserPK jiraUserPK)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _jiraUserLocalService.deleteJiraUser(jiraUserPK);
    }

    /**
    * Deletes the jira user from the database. Also notifies the appropriate model listeners.
    *
    * @param jiraUser the jira user
    * @return the jira user that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public de.hska.wi.awp.datasource.model.JiraUser deleteJiraUser(
        de.hska.wi.awp.datasource.model.JiraUser jiraUser)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _jiraUserLocalService.deleteJiraUser(jiraUser);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _jiraUserLocalService.dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _jiraUserLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.hska.wi.awp.datasource.model.impl.JiraUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _jiraUserLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.hska.wi.awp.datasource.model.impl.JiraUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _jiraUserLocalService.dynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _jiraUserLocalService.dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _jiraUserLocalService.dynamicQueryCount(dynamicQuery, projection);
    }

    @Override
    public de.hska.wi.awp.datasource.model.JiraUser fetchJiraUser(
        de.hska.wi.awp.datasource.service.persistence.JiraUserPK jiraUserPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _jiraUserLocalService.fetchJiraUser(jiraUserPK);
    }

    /**
    * Returns the jira user with the primary key.
    *
    * @param jiraUserPK the primary key of the jira user
    * @return the jira user
    * @throws PortalException if a jira user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public de.hska.wi.awp.datasource.model.JiraUser getJiraUser(
        de.hska.wi.awp.datasource.service.persistence.JiraUserPK jiraUserPK)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _jiraUserLocalService.getJiraUser(jiraUserPK);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _jiraUserLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the jira users.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.hska.wi.awp.datasource.model.impl.JiraUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of jira users
    * @param end the upper bound of the range of jira users (not inclusive)
    * @return the range of jira users
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<de.hska.wi.awp.datasource.model.JiraUser> getJiraUsers(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _jiraUserLocalService.getJiraUsers(start, end);
    }

    /**
    * Returns the number of jira users.
    *
    * @return the number of jira users
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getJiraUsersCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _jiraUserLocalService.getJiraUsersCount();
    }

    /**
    * Updates the jira user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param jiraUser the jira user
    * @return the jira user that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public de.hska.wi.awp.datasource.model.JiraUser updateJiraUser(
        de.hska.wi.awp.datasource.model.JiraUser jiraUser)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _jiraUserLocalService.updateJiraUser(jiraUser);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _jiraUserLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _jiraUserLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _jiraUserLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public java.lang.String getAllMembers(java.lang.String projectId) {
        return _jiraUserLocalService.getAllMembers(projectId);
    }

    @Override
    public void ParseJsonToMember(java.lang.String response) {
        _jiraUserLocalService.ParseJsonToMember(response);
    }

    @Override
    public java.lang.String getDisplayNameForUserId(java.lang.String userId) {
        return _jiraUserLocalService.getDisplayNameForUserId(userId);
    }

    @Override
    public java.lang.String getProjectNameForUserId(java.lang.String userId) {
        return _jiraUserLocalService.getProjectNameForUserId(userId);
    }

    @Override
    public void deleteAllJiraUser() {
        _jiraUserLocalService.deleteAllJiraUser();
    }

    @Override
    public java.util.Properties loadConfigFile() {
        return _jiraUserLocalService.loadConfigFile();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public JiraUserLocalService getWrappedJiraUserLocalService() {
        return _jiraUserLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedJiraUserLocalService(
        JiraUserLocalService jiraUserLocalService) {
        _jiraUserLocalService = jiraUserLocalService;
    }

    @Override
    public JiraUserLocalService getWrappedService() {
        return _jiraUserLocalService;
    }

    @Override
    public void setWrappedService(JiraUserLocalService jiraUserLocalService) {
        _jiraUserLocalService = jiraUserLocalService;
    }
}
