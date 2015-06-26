package de.hska.wi.awp.datasource.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import de.hska.wi.awp.datasource.model.IssueType;

import java.util.List;

/**
 * The persistence utility for the issue type service. This utility wraps {@link IssueTypePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see IssueTypePersistence
 * @see IssueTypePersistenceImpl
 * @generated
 */
public class IssueTypeUtil {
    private static IssueTypePersistence _persistence;

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
    public static void clearCache(IssueType issueType) {
        getPersistence().clearCache(issueType);
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
    public static List<IssueType> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<IssueType> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<IssueType> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static IssueType update(IssueType issueType)
        throws SystemException {
        return getPersistence().update(issueType);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static IssueType update(IssueType issueType,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(issueType, serviceContext);
    }

    /**
    * Caches the issue type in the entity cache if it is enabled.
    *
    * @param issueType the issue type
    */
    public static void cacheResult(
        de.hska.wi.awp.datasource.model.IssueType issueType) {
        getPersistence().cacheResult(issueType);
    }

    /**
    * Caches the issue types in the entity cache if it is enabled.
    *
    * @param issueTypes the issue types
    */
    public static void cacheResult(
        java.util.List<de.hska.wi.awp.datasource.model.IssueType> issueTypes) {
        getPersistence().cacheResult(issueTypes);
    }

    /**
    * Creates a new issue type with the primary key. Does not add the issue type to the database.
    *
    * @param issueTypeId the primary key for the new issue type
    * @return the new issue type
    */
    public static de.hska.wi.awp.datasource.model.IssueType create(
        long issueTypeId) {
        return getPersistence().create(issueTypeId);
    }

    /**
    * Removes the issue type with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param issueTypeId the primary key of the issue type
    * @return the issue type that was removed
    * @throws de.hska.wi.awp.datasource.NoSuchIssueTypeException if a issue type with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.hska.wi.awp.datasource.model.IssueType remove(
        long issueTypeId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.hska.wi.awp.datasource.NoSuchIssueTypeException {
        return getPersistence().remove(issueTypeId);
    }

    public static de.hska.wi.awp.datasource.model.IssueType updateImpl(
        de.hska.wi.awp.datasource.model.IssueType issueType)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(issueType);
    }

    /**
    * Returns the issue type with the primary key or throws a {@link de.hska.wi.awp.datasource.NoSuchIssueTypeException} if it could not be found.
    *
    * @param issueTypeId the primary key of the issue type
    * @return the issue type
    * @throws de.hska.wi.awp.datasource.NoSuchIssueTypeException if a issue type with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.hska.wi.awp.datasource.model.IssueType findByPrimaryKey(
        long issueTypeId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.hska.wi.awp.datasource.NoSuchIssueTypeException {
        return getPersistence().findByPrimaryKey(issueTypeId);
    }

    /**
    * Returns the issue type with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param issueTypeId the primary key of the issue type
    * @return the issue type, or <code>null</code> if a issue type with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.hska.wi.awp.datasource.model.IssueType fetchByPrimaryKey(
        long issueTypeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(issueTypeId);
    }

    /**
    * Returns all the issue types.
    *
    * @return the issue types
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.hska.wi.awp.datasource.model.IssueType> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<de.hska.wi.awp.datasource.model.IssueType> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the issue types.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.hska.wi.awp.datasource.model.impl.IssueTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of issue types
    * @param end the upper bound of the range of issue types (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of issue types
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.hska.wi.awp.datasource.model.IssueType> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the issue types from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of issue types.
    *
    * @return the number of issue types
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static IssueTypePersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (IssueTypePersistence) PortletBeanLocatorUtil.locate(de.hska.wi.awp.datasource.service.ClpSerializer.getServletContextName(),
                    IssueTypePersistence.class.getName());

            ReferenceRegistry.registerReference(IssueTypeUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(IssueTypePersistence persistence) {
    }
}
