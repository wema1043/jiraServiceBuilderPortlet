package de.hska.wi.awp.datasource.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link IssueTypeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see IssueTypeLocalService
 * @generated
 */
public class IssueTypeLocalServiceWrapper implements IssueTypeLocalService,
    ServiceWrapper<IssueTypeLocalService> {
    private IssueTypeLocalService _issueTypeLocalService;

    public IssueTypeLocalServiceWrapper(
        IssueTypeLocalService issueTypeLocalService) {
        _issueTypeLocalService = issueTypeLocalService;
    }

    /**
    * Adds the issue type to the database. Also notifies the appropriate model listeners.
    *
    * @param issueType the issue type
    * @return the issue type that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public de.hska.wi.awp.datasource.model.IssueType addIssueType(
        de.hska.wi.awp.datasource.model.IssueType issueType)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _issueTypeLocalService.addIssueType(issueType);
    }

    /**
    * Creates a new issue type with the primary key. Does not add the issue type to the database.
    *
    * @param issueId the primary key for the new issue type
    * @return the new issue type
    */
    @Override
    public de.hska.wi.awp.datasource.model.IssueType createIssueType(
        long issueId) {
        return _issueTypeLocalService.createIssueType(issueId);
    }

    /**
    * Deletes the issue type with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param issueId the primary key of the issue type
    * @return the issue type that was removed
    * @throws PortalException if a issue type with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public de.hska.wi.awp.datasource.model.IssueType deleteIssueType(
        long issueId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _issueTypeLocalService.deleteIssueType(issueId);
    }

    /**
    * Deletes the issue type from the database. Also notifies the appropriate model listeners.
    *
    * @param issueType the issue type
    * @return the issue type that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public de.hska.wi.awp.datasource.model.IssueType deleteIssueType(
        de.hska.wi.awp.datasource.model.IssueType issueType)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _issueTypeLocalService.deleteIssueType(issueType);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _issueTypeLocalService.dynamicQuery();
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
        return _issueTypeLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.hska.wi.awp.datasource.model.impl.IssueTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _issueTypeLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.hska.wi.awp.datasource.model.impl.IssueTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _issueTypeLocalService.dynamicQuery(dynamicQuery, start, end,
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
        return _issueTypeLocalService.dynamicQueryCount(dynamicQuery);
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
        return _issueTypeLocalService.dynamicQueryCount(dynamicQuery, projection);
    }

    @Override
    public de.hska.wi.awp.datasource.model.IssueType fetchIssueType(
        long issueId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _issueTypeLocalService.fetchIssueType(issueId);
    }

    /**
    * Returns the issue type with the primary key.
    *
    * @param issueId the primary key of the issue type
    * @return the issue type
    * @throws PortalException if a issue type with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public de.hska.wi.awp.datasource.model.IssueType getIssueType(long issueId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _issueTypeLocalService.getIssueType(issueId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _issueTypeLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the issue types.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.hska.wi.awp.datasource.model.impl.IssueTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of issue types
    * @param end the upper bound of the range of issue types (not inclusive)
    * @return the range of issue types
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<de.hska.wi.awp.datasource.model.IssueType> getIssueTypes(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _issueTypeLocalService.getIssueTypes(start, end);
    }

    /**
    * Returns the number of issue types.
    *
    * @return the number of issue types
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getIssueTypesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _issueTypeLocalService.getIssueTypesCount();
    }

    /**
    * Updates the issue type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param issueType the issue type
    * @return the issue type that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public de.hska.wi.awp.datasource.model.IssueType updateIssueType(
        de.hska.wi.awp.datasource.model.IssueType issueType)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _issueTypeLocalService.updateIssueType(issueType);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _issueTypeLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _issueTypeLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _issueTypeLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public IssueTypeLocalService getWrappedIssueTypeLocalService() {
        return _issueTypeLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedIssueTypeLocalService(
        IssueTypeLocalService issueTypeLocalService) {
        _issueTypeLocalService = issueTypeLocalService;
    }

    @Override
    public IssueTypeLocalService getWrappedService() {
        return _issueTypeLocalService;
    }

    @Override
    public void setWrappedService(IssueTypeLocalService issueTypeLocalService) {
        _issueTypeLocalService = issueTypeLocalService;
    }
}
