package de.hska.wi.awp.datasource.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for IssuePriority. This utility wraps
 * {@link de.hska.wi.awp.datasource.service.impl.IssuePriorityLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see IssuePriorityLocalService
 * @see de.hska.wi.awp.datasource.service.base.IssuePriorityLocalServiceBaseImpl
 * @see de.hska.wi.awp.datasource.service.impl.IssuePriorityLocalServiceImpl
 * @generated
 */
public class IssuePriorityLocalServiceUtil {
    private static IssuePriorityLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link de.hska.wi.awp.datasource.service.impl.IssuePriorityLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the issue priority to the database. Also notifies the appropriate model listeners.
    *
    * @param issuePriority the issue priority
    * @return the issue priority that was added
    * @throws SystemException if a system exception occurred
    */
    public static de.hska.wi.awp.datasource.model.IssuePriority addIssuePriority(
        de.hska.wi.awp.datasource.model.IssuePriority issuePriority)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addIssuePriority(issuePriority);
    }

    /**
    * Creates a new issue priority with the primary key. Does not add the issue priority to the database.
    *
    * @param priorityId the primary key for the new issue priority
    * @return the new issue priority
    */
    public static de.hska.wi.awp.datasource.model.IssuePriority createIssuePriority(
        long priorityId) {
        return getService().createIssuePriority(priorityId);
    }

    /**
    * Deletes the issue priority with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param priorityId the primary key of the issue priority
    * @return the issue priority that was removed
    * @throws PortalException if a issue priority with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.hska.wi.awp.datasource.model.IssuePriority deleteIssuePriority(
        long priorityId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteIssuePriority(priorityId);
    }

    /**
    * Deletes the issue priority from the database. Also notifies the appropriate model listeners.
    *
    * @param issuePriority the issue priority
    * @return the issue priority that was removed
    * @throws SystemException if a system exception occurred
    */
    public static de.hska.wi.awp.datasource.model.IssuePriority deleteIssuePriority(
        de.hska.wi.awp.datasource.model.IssuePriority issuePriority)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteIssuePriority(issuePriority);
    }

    public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return getService().dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.hska.wi.awp.datasource.model.impl.IssuePriorityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.hska.wi.awp.datasource.model.impl.IssuePriorityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery, projection);
    }

    public static de.hska.wi.awp.datasource.model.IssuePriority fetchIssuePriority(
        long priorityId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchIssuePriority(priorityId);
    }

    /**
    * Returns the issue priority with the primary key.
    *
    * @param priorityId the primary key of the issue priority
    * @return the issue priority
    * @throws PortalException if a issue priority with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.hska.wi.awp.datasource.model.IssuePriority getIssuePriority(
        long priorityId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getIssuePriority(priorityId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the issue priorities.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.hska.wi.awp.datasource.model.impl.IssuePriorityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of issue priorities
    * @param end the upper bound of the range of issue priorities (not inclusive)
    * @return the range of issue priorities
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.hska.wi.awp.datasource.model.IssuePriority> getIssuePriorities(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getIssuePriorities(start, end);
    }

    /**
    * Returns the number of issue priorities.
    *
    * @return the number of issue priorities
    * @throws SystemException if a system exception occurred
    */
    public static int getIssuePrioritiesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getIssuePrioritiesCount();
    }

    /**
    * Updates the issue priority in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param issuePriority the issue priority
    * @return the issue priority that was updated
    * @throws SystemException if a system exception occurred
    */
    public static de.hska.wi.awp.datasource.model.IssuePriority updateIssuePriority(
        de.hska.wi.awp.datasource.model.IssuePriority issuePriority)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateIssuePriority(issuePriority);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    public static void clearService() {
        _service = null;
    }

    public static IssuePriorityLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    IssuePriorityLocalService.class.getName());

            if (invokableLocalService instanceof IssuePriorityLocalService) {
                _service = (IssuePriorityLocalService) invokableLocalService;
            } else {
                _service = new IssuePriorityLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(IssuePriorityLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(IssuePriorityLocalService service) {
    }
}
