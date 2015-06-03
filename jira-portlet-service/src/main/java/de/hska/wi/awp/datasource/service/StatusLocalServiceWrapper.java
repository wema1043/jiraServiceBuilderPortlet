package de.hska.wi.awp.datasource.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link StatusLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see StatusLocalService
 * @generated
 */
public class StatusLocalServiceWrapper implements StatusLocalService,
    ServiceWrapper<StatusLocalService> {
    private StatusLocalService _statusLocalService;

    public StatusLocalServiceWrapper(StatusLocalService statusLocalService) {
        _statusLocalService = statusLocalService;
    }

    /**
    * Adds the status to the database. Also notifies the appropriate model listeners.
    *
    * @param status the status
    * @return the status that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public de.hska.wi.awp.datasource.model.Status addStatus(
        de.hska.wi.awp.datasource.model.Status status)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _statusLocalService.addStatus(status);
    }

    /**
    * Creates a new status with the primary key. Does not add the status to the database.
    *
    * @param statusId the primary key for the new status
    * @return the new status
    */
    @Override
    public de.hska.wi.awp.datasource.model.Status createStatus(
        java.lang.String statusId) {
        return _statusLocalService.createStatus(statusId);
    }

    /**
    * Deletes the status with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param statusId the primary key of the status
    * @return the status that was removed
    * @throws PortalException if a status with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public de.hska.wi.awp.datasource.model.Status deleteStatus(
        java.lang.String statusId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _statusLocalService.deleteStatus(statusId);
    }

    /**
    * Deletes the status from the database. Also notifies the appropriate model listeners.
    *
    * @param status the status
    * @return the status that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public de.hska.wi.awp.datasource.model.Status deleteStatus(
        de.hska.wi.awp.datasource.model.Status status)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _statusLocalService.deleteStatus(status);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _statusLocalService.dynamicQuery();
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
        return _statusLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.hska.wi.awp.datasource.model.impl.StatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _statusLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.hska.wi.awp.datasource.model.impl.StatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _statusLocalService.dynamicQuery(dynamicQuery, start, end,
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
        return _statusLocalService.dynamicQueryCount(dynamicQuery);
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
        return _statusLocalService.dynamicQueryCount(dynamicQuery, projection);
    }

    @Override
    public de.hska.wi.awp.datasource.model.Status fetchStatus(
        java.lang.String statusId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _statusLocalService.fetchStatus(statusId);
    }

    /**
    * Returns the status with the primary key.
    *
    * @param statusId the primary key of the status
    * @return the status
    * @throws PortalException if a status with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public de.hska.wi.awp.datasource.model.Status getStatus(
        java.lang.String statusId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _statusLocalService.getStatus(statusId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _statusLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the statuses.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.hska.wi.awp.datasource.model.impl.StatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of statuses
    * @param end the upper bound of the range of statuses (not inclusive)
    * @return the range of statuses
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<de.hska.wi.awp.datasource.model.Status> getStatuses(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _statusLocalService.getStatuses(start, end);
    }

    /**
    * Returns the number of statuses.
    *
    * @return the number of statuses
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getStatusesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _statusLocalService.getStatusesCount();
    }

    /**
    * Updates the status in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param status the status
    * @return the status that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public de.hska.wi.awp.datasource.model.Status updateStatus(
        de.hska.wi.awp.datasource.model.Status status)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _statusLocalService.updateStatus(status);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _statusLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _statusLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _statusLocalService.invokeMethod(name, parameterTypes, arguments);
    }

    @Override
    public java.lang.String getAllStatus() {
        return _statusLocalService.getAllStatus();
    }

    @Override
    public void ParseJsonToStatus(java.lang.String response) {
        _statusLocalService.ParseJsonToStatus(response);
    }

    @Override
    public void deleteAllStatus() {
        _statusLocalService.deleteAllStatus();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public StatusLocalService getWrappedStatusLocalService() {
        return _statusLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedStatusLocalService(
        StatusLocalService statusLocalService) {
        _statusLocalService = statusLocalService;
    }

    @Override
    public StatusLocalService getWrappedService() {
        return _statusLocalService;
    }

    @Override
    public void setWrappedService(StatusLocalService statusLocalService) {
        _statusLocalService = statusLocalService;
    }
}
