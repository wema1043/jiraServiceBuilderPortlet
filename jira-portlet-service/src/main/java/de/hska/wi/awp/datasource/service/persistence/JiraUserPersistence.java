package de.hska.wi.awp.datasource.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import de.hska.wi.awp.datasource.model.JiraUser;

/**
 * The persistence interface for the jira user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see JiraUserPersistenceImpl
 * @see JiraUserUtil
 * @generated
 */
public interface JiraUserPersistence extends BasePersistence<JiraUser> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link JiraUserUtil} to access the jira user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns the jira user where creatorId = &#63; or throws a {@link de.hska.wi.awp.datasource.NoSuchJiraUserException} if it could not be found.
    *
    * @param creatorId the creator ID
    * @return the matching jira user
    * @throws de.hska.wi.awp.datasource.NoSuchJiraUserException if a matching jira user could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.hska.wi.awp.datasource.model.JiraUser findBybyName(
        java.lang.String creatorId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.hska.wi.awp.datasource.NoSuchJiraUserException;

    /**
    * Returns the jira user where creatorId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param creatorId the creator ID
    * @return the matching jira user, or <code>null</code> if a matching jira user could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.hska.wi.awp.datasource.model.JiraUser fetchBybyName(
        java.lang.String creatorId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the jira user where creatorId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param creatorId the creator ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching jira user, or <code>null</code> if a matching jira user could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.hska.wi.awp.datasource.model.JiraUser fetchBybyName(
        java.lang.String creatorId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the jira user where creatorId = &#63; from the database.
    *
    * @param creatorId the creator ID
    * @return the jira user that was removed
    * @throws SystemException if a system exception occurred
    */
    public de.hska.wi.awp.datasource.model.JiraUser removeBybyName(
        java.lang.String creatorId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.hska.wi.awp.datasource.NoSuchJiraUserException;

    /**
    * Returns the number of jira users where creatorId = &#63;.
    *
    * @param creatorId the creator ID
    * @return the number of matching jira users
    * @throws SystemException if a system exception occurred
    */
    public int countBybyName(java.lang.String creatorId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the jira user in the entity cache if it is enabled.
    *
    * @param jiraUser the jira user
    */
    public void cacheResult(de.hska.wi.awp.datasource.model.JiraUser jiraUser);

    /**
    * Caches the jira users in the entity cache if it is enabled.
    *
    * @param jiraUsers the jira users
    */
    public void cacheResult(
        java.util.List<de.hska.wi.awp.datasource.model.JiraUser> jiraUsers);

    /**
    * Creates a new jira user with the primary key. Does not add the jira user to the database.
    *
    * @param creatorId the primary key for the new jira user
    * @return the new jira user
    */
    public de.hska.wi.awp.datasource.model.JiraUser create(
        java.lang.String creatorId);

    /**
    * Removes the jira user with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param creatorId the primary key of the jira user
    * @return the jira user that was removed
    * @throws de.hska.wi.awp.datasource.NoSuchJiraUserException if a jira user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.hska.wi.awp.datasource.model.JiraUser remove(
        java.lang.String creatorId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.hska.wi.awp.datasource.NoSuchJiraUserException;

    public de.hska.wi.awp.datasource.model.JiraUser updateImpl(
        de.hska.wi.awp.datasource.model.JiraUser jiraUser)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the jira user with the primary key or throws a {@link de.hska.wi.awp.datasource.NoSuchJiraUserException} if it could not be found.
    *
    * @param creatorId the primary key of the jira user
    * @return the jira user
    * @throws de.hska.wi.awp.datasource.NoSuchJiraUserException if a jira user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.hska.wi.awp.datasource.model.JiraUser findByPrimaryKey(
        java.lang.String creatorId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.hska.wi.awp.datasource.NoSuchJiraUserException;

    /**
    * Returns the jira user with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param creatorId the primary key of the jira user
    * @return the jira user, or <code>null</code> if a jira user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.hska.wi.awp.datasource.model.JiraUser fetchByPrimaryKey(
        java.lang.String creatorId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the jira users.
    *
    * @return the jira users
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.hska.wi.awp.datasource.model.JiraUser> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.hska.wi.awp.datasource.model.JiraUser> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.hska.wi.awp.datasource.model.JiraUser> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the jira users from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of jira users.
    *
    * @return the number of jira users
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
