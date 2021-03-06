package de.hska.wi.awp.datasource.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import de.hska.wi.awp.datasource.model.IssuePriority;

import java.util.List;

/**
 * The persistence utility for the issue priority service. This utility wraps {@link IssuePriorityPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see IssuePriorityPersistence
 * @see IssuePriorityPersistenceImpl
 * @generated
 */
public class IssuePriorityUtil {
    private static IssuePriorityPersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(IssuePriority issuePriority) {
        getPersistence().clearCache(issuePriority);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<IssuePriority> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<IssuePriority> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<IssuePriority> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static IssuePriority update(IssuePriority issuePriority)
        throws SystemException {
        return getPersistence().update(issuePriority);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static IssuePriority update(IssuePriority issuePriority,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(issuePriority, serviceContext);
    }

    /**
    * Caches the issue priority in the entity cache if it is enabled.
    *
    * @param issuePriority the issue priority
    */
    public static void cacheResult(
        de.hska.wi.awp.datasource.model.IssuePriority issuePriority) {
        getPersistence().cacheResult(issuePriority);
    }

    /**
    * Caches the issue priorities in the entity cache if it is enabled.
    *
    * @param issuePriorities the issue priorities
    */
    public static void cacheResult(
        java.util.List<de.hska.wi.awp.datasource.model.IssuePriority> issuePriorities) {
        getPersistence().cacheResult(issuePriorities);
    }

    /**
    * Creates a new issue priority with the primary key. Does not add the issue priority to the database.
    *
    * @param priorityId the primary key for the new issue priority
    * @return the new issue priority
    */
    public static de.hska.wi.awp.datasource.model.IssuePriority create(
        long priorityId) {
        return getPersistence().create(priorityId);
    }

    /**
    * Removes the issue priority with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param priorityId the primary key of the issue priority
    * @return the issue priority that was removed
    * @throws de.hska.wi.awp.datasource.NoSuchIssuePriorityException if a issue priority with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.hska.wi.awp.datasource.model.IssuePriority remove(
        long priorityId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.hska.wi.awp.datasource.NoSuchIssuePriorityException {
        return getPersistence().remove(priorityId);
    }

    public static de.hska.wi.awp.datasource.model.IssuePriority updateImpl(
        de.hska.wi.awp.datasource.model.IssuePriority issuePriority)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(issuePriority);
    }

    /**
    * Returns the issue priority with the primary key or throws a {@link de.hska.wi.awp.datasource.NoSuchIssuePriorityException} if it could not be found.
    *
    * @param priorityId the primary key of the issue priority
    * @return the issue priority
    * @throws de.hska.wi.awp.datasource.NoSuchIssuePriorityException if a issue priority with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.hska.wi.awp.datasource.model.IssuePriority findByPrimaryKey(
        long priorityId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.hska.wi.awp.datasource.NoSuchIssuePriorityException {
        return getPersistence().findByPrimaryKey(priorityId);
    }

    /**
    * Returns the issue priority with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param priorityId the primary key of the issue priority
    * @return the issue priority, or <code>null</code> if a issue priority with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.hska.wi.awp.datasource.model.IssuePriority fetchByPrimaryKey(
        long priorityId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(priorityId);
    }

    /**
    * Returns all the issue priorities.
    *
    * @return the issue priorities
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.hska.wi.awp.datasource.model.IssuePriority> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<de.hska.wi.awp.datasource.model.IssuePriority> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the issue priorities.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.hska.wi.awp.datasource.model.impl.IssuePriorityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of issue priorities
    * @param end the upper bound of the range of issue priorities (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of issue priorities
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.hska.wi.awp.datasource.model.IssuePriority> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the issue priorities from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of issue priorities.
    *
    * @return the number of issue priorities
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static IssuePriorityPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (IssuePriorityPersistence) PortletBeanLocatorUtil.locate(de.hska.wi.awp.datasource.service.ClpSerializer.getServletContextName(),
                    IssuePriorityPersistence.class.getName());

            ReferenceRegistry.registerReference(IssuePriorityUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(IssuePriorityPersistence persistence) {
    }
}
