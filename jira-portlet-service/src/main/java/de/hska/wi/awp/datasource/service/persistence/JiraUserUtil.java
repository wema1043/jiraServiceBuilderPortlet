package de.hska.wi.awp.datasource.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import de.hska.wi.awp.datasource.model.JiraUser;

import java.util.List;

/**
 * The persistence utility for the jira user service. This utility wraps {@link JiraUserPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see JiraUserPersistence
 * @see JiraUserPersistenceImpl
 * @generated
 */
public class JiraUserUtil {
    private static JiraUserPersistence _persistence;

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
    public static void clearCache(JiraUser jiraUser) {
        getPersistence().clearCache(jiraUser);
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
    public static List<JiraUser> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<JiraUser> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<JiraUser> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static JiraUser update(JiraUser jiraUser) throws SystemException {
        return getPersistence().update(jiraUser);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static JiraUser update(JiraUser jiraUser,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(jiraUser, serviceContext);
    }

    /**
    * Returns the jira user where displayname = &#63; or throws a {@link de.hska.wi.awp.datasource.NoSuchJiraUserException} if it could not be found.
    *
    * @param displayname the displayname
    * @return the matching jira user
    * @throws de.hska.wi.awp.datasource.NoSuchJiraUserException if a matching jira user could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.hska.wi.awp.datasource.model.JiraUser findBybyName(
        java.lang.String displayname)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.hska.wi.awp.datasource.NoSuchJiraUserException {
        return getPersistence().findBybyName(displayname);
    }

    /**
    * Returns the jira user where displayname = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param displayname the displayname
    * @return the matching jira user, or <code>null</code> if a matching jira user could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.hska.wi.awp.datasource.model.JiraUser fetchBybyName(
        java.lang.String displayname)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchBybyName(displayname);
    }

    /**
    * Returns the jira user where displayname = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param displayname the displayname
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching jira user, or <code>null</code> if a matching jira user could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.hska.wi.awp.datasource.model.JiraUser fetchBybyName(
        java.lang.String displayname, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchBybyName(displayname, retrieveFromCache);
    }

    /**
    * Removes the jira user where displayname = &#63; from the database.
    *
    * @param displayname the displayname
    * @return the jira user that was removed
    * @throws SystemException if a system exception occurred
    */
    public static de.hska.wi.awp.datasource.model.JiraUser removeBybyName(
        java.lang.String displayname)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.hska.wi.awp.datasource.NoSuchJiraUserException {
        return getPersistence().removeBybyName(displayname);
    }

    /**
    * Returns the number of jira users where displayname = &#63;.
    *
    * @param displayname the displayname
    * @return the number of matching jira users
    * @throws SystemException if a system exception occurred
    */
    public static int countBybyName(java.lang.String displayname)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countBybyName(displayname);
    }

    /**
    * Caches the jira user in the entity cache if it is enabled.
    *
    * @param jiraUser the jira user
    */
    public static void cacheResult(
        de.hska.wi.awp.datasource.model.JiraUser jiraUser) {
        getPersistence().cacheResult(jiraUser);
    }

    /**
    * Caches the jira users in the entity cache if it is enabled.
    *
    * @param jiraUsers the jira users
    */
    public static void cacheResult(
        java.util.List<de.hska.wi.awp.datasource.model.JiraUser> jiraUsers) {
        getPersistence().cacheResult(jiraUsers);
    }

    /**
    * Creates a new jira user with the primary key. Does not add the jira user to the database.
    *
    * @param creatorId the primary key for the new jira user
    * @return the new jira user
    */
    public static de.hska.wi.awp.datasource.model.JiraUser create(
        java.lang.String creatorId) {
        return getPersistence().create(creatorId);
    }

    /**
    * Removes the jira user with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param creatorId the primary key of the jira user
    * @return the jira user that was removed
    * @throws de.hska.wi.awp.datasource.NoSuchJiraUserException if a jira user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.hska.wi.awp.datasource.model.JiraUser remove(
        java.lang.String creatorId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.hska.wi.awp.datasource.NoSuchJiraUserException {
        return getPersistence().remove(creatorId);
    }

    public static de.hska.wi.awp.datasource.model.JiraUser updateImpl(
        de.hska.wi.awp.datasource.model.JiraUser jiraUser)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(jiraUser);
    }

    /**
    * Returns the jira user with the primary key or throws a {@link de.hska.wi.awp.datasource.NoSuchJiraUserException} if it could not be found.
    *
    * @param creatorId the primary key of the jira user
    * @return the jira user
    * @throws de.hska.wi.awp.datasource.NoSuchJiraUserException if a jira user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.hska.wi.awp.datasource.model.JiraUser findByPrimaryKey(
        java.lang.String creatorId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.hska.wi.awp.datasource.NoSuchJiraUserException {
        return getPersistence().findByPrimaryKey(creatorId);
    }

    /**
    * Returns the jira user with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param creatorId the primary key of the jira user
    * @return the jira user, or <code>null</code> if a jira user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.hska.wi.awp.datasource.model.JiraUser fetchByPrimaryKey(
        java.lang.String creatorId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(creatorId);
    }

    /**
    * Returns all the jira users.
    *
    * @return the jira users
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.hska.wi.awp.datasource.model.JiraUser> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<de.hska.wi.awp.datasource.model.JiraUser> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the jira users.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.hska.wi.awp.datasource.model.impl.JiraUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of jira users
    * @param end the upper bound of the range of jira users (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of jira users
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.hska.wi.awp.datasource.model.JiraUser> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the jira users from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of jira users.
    *
    * @return the number of jira users
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static JiraUserPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (JiraUserPersistence) PortletBeanLocatorUtil.locate(de.hska.wi.awp.datasource.service.ClpSerializer.getServletContextName(),
                    JiraUserPersistence.class.getName());

            ReferenceRegistry.registerReference(JiraUserUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(JiraUserPersistence persistence) {
    }
}
