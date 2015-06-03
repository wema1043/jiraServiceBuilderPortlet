package de.hska.wi.awp.datasource.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link IssueLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see IssueLocalService
 * @generated
 */
public class IssueLocalServiceWrapper implements IssueLocalService,
    ServiceWrapper<IssueLocalService> {
    private IssueLocalService _issueLocalService;

    public IssueLocalServiceWrapper(IssueLocalService issueLocalService) {
        _issueLocalService = issueLocalService;
    }

    /**
    * Adds the issue to the database. Also notifies the appropriate model listeners.
    *
    * @param issue the issue
    * @return the issue that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public de.hska.wi.awp.datasource.model.Issue addIssue(
        de.hska.wi.awp.datasource.model.Issue issue)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _issueLocalService.addIssue(issue);
    }

    /**
    * Creates a new issue with the primary key. Does not add the issue to the database.
    *
    * @param issueId the primary key for the new issue
    * @return the new issue
    */
    @Override
    public de.hska.wi.awp.datasource.model.Issue createIssue(
        java.lang.String issueId) {
        return _issueLocalService.createIssue(issueId);
    }

    /**
    * Deletes the issue with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param issueId the primary key of the issue
    * @return the issue that was removed
    * @throws PortalException if a issue with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public de.hska.wi.awp.datasource.model.Issue deleteIssue(
        java.lang.String issueId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _issueLocalService.deleteIssue(issueId);
    }

    /**
    * Deletes the issue from the database. Also notifies the appropriate model listeners.
    *
    * @param issue the issue
    * @return the issue that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public de.hska.wi.awp.datasource.model.Issue deleteIssue(
        de.hska.wi.awp.datasource.model.Issue issue)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _issueLocalService.deleteIssue(issue);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _issueLocalService.dynamicQuery();
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
        return _issueLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.hska.wi.awp.datasource.model.impl.IssueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _issueLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.hska.wi.awp.datasource.model.impl.IssueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _issueLocalService.dynamicQuery(dynamicQuery, start, end,
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
        return _issueLocalService.dynamicQueryCount(dynamicQuery);
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
        return _issueLocalService.dynamicQueryCount(dynamicQuery, projection);
    }

    @Override
    public de.hska.wi.awp.datasource.model.Issue fetchIssue(
        java.lang.String issueId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _issueLocalService.fetchIssue(issueId);
    }

    /**
    * Returns the issue with the primary key.
    *
    * @param issueId the primary key of the issue
    * @return the issue
    * @throws PortalException if a issue with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public de.hska.wi.awp.datasource.model.Issue getIssue(
        java.lang.String issueId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _issueLocalService.getIssue(issueId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _issueLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the issues.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.hska.wi.awp.datasource.model.impl.IssueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of issues
    * @param end the upper bound of the range of issues (not inclusive)
    * @return the range of issues
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<de.hska.wi.awp.datasource.model.Issue> getIssues(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _issueLocalService.getIssues(start, end);
    }

    /**
    * Returns the number of issues.
    *
    * @return the number of issues
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getIssuesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _issueLocalService.getIssuesCount();
    }

    /**
    * Updates the issue in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param issue the issue
    * @return the issue that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public de.hska.wi.awp.datasource.model.Issue updateIssue(
        de.hska.wi.awp.datasource.model.Issue issue)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _issueLocalService.updateIssue(issue);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _issueLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _issueLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _issueLocalService.invokeMethod(name, parameterTypes, arguments);
    }

    @Override
    public java.lang.String getAllIssues() throws java.lang.Exception {
        return _issueLocalService.getAllIssues();
    }

    @Override
    public void ParseJsonToIssue(java.lang.String response)
        throws java.lang.Exception {
        _issueLocalService.ParseJsonToIssue(response);
    }

    @Override
    public void deleteAllIssues()
        throws com.liferay.portal.kernel.exception.SystemException {
        _issueLocalService.deleteAllIssues();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public IssueLocalService getWrappedIssueLocalService() {
        return _issueLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedIssueLocalService(IssueLocalService issueLocalService) {
        _issueLocalService = issueLocalService;
    }

    @Override
    public IssueLocalService getWrappedService() {
        return _issueLocalService;
    }

    @Override
    public void setWrappedService(IssueLocalService issueLocalService) {
        _issueLocalService = issueLocalService;
    }
}
