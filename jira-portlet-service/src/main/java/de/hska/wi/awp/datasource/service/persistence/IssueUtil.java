package de.hska.wi.awp.datasource.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import de.hska.wi.awp.datasource.model.Issue;

import java.util.List;

/**
 * The persistence utility for the issue service. This utility wraps {@link IssuePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see IssuePersistence
 * @see IssuePersistenceImpl
 * @generated
 */
public class IssueUtil {
    private static IssuePersistence _persistence;

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
    public static void clearCache(Issue issue) {
        getPersistence().clearCache(issue);
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
    public static List<Issue> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Issue> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Issue> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static Issue update(Issue issue) throws SystemException {
        return getPersistence().update(issue);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static Issue update(Issue issue, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(issue, serviceContext);
    }

    /**
    * Returns all the issues where issueId = &#63;.
    *
    * @param issueId the issue ID
    * @return the matching issues
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.hska.wi.awp.datasource.model.Issue> findByIssueId(
        java.lang.String issueId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByIssueId(issueId);
    }

    /**
    * Returns a range of all the issues where issueId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.hska.wi.awp.datasource.model.impl.IssueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param issueId the issue ID
    * @param start the lower bound of the range of issues
    * @param end the upper bound of the range of issues (not inclusive)
    * @return the range of matching issues
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.hska.wi.awp.datasource.model.Issue> findByIssueId(
        java.lang.String issueId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByIssueId(issueId, start, end);
    }

    /**
    * Returns an ordered range of all the issues where issueId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.hska.wi.awp.datasource.model.impl.IssueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param issueId the issue ID
    * @param start the lower bound of the range of issues
    * @param end the upper bound of the range of issues (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching issues
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.hska.wi.awp.datasource.model.Issue> findByIssueId(
        java.lang.String issueId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByIssueId(issueId, start, end, orderByComparator);
    }

    /**
    * Returns the first issue in the ordered set where issueId = &#63;.
    *
    * @param issueId the issue ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching issue
    * @throws de.hska.wi.awp.datasource.NoSuchIssueException if a matching issue could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.hska.wi.awp.datasource.model.Issue findByIssueId_First(
        java.lang.String issueId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.hska.wi.awp.datasource.NoSuchIssueException {
        return getPersistence().findByIssueId_First(issueId, orderByComparator);
    }

    /**
    * Returns the first issue in the ordered set where issueId = &#63;.
    *
    * @param issueId the issue ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching issue, or <code>null</code> if a matching issue could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.hska.wi.awp.datasource.model.Issue fetchByIssueId_First(
        java.lang.String issueId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByIssueId_First(issueId, orderByComparator);
    }

    /**
    * Returns the last issue in the ordered set where issueId = &#63;.
    *
    * @param issueId the issue ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching issue
    * @throws de.hska.wi.awp.datasource.NoSuchIssueException if a matching issue could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.hska.wi.awp.datasource.model.Issue findByIssueId_Last(
        java.lang.String issueId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.hska.wi.awp.datasource.NoSuchIssueException {
        return getPersistence().findByIssueId_Last(issueId, orderByComparator);
    }

    /**
    * Returns the last issue in the ordered set where issueId = &#63;.
    *
    * @param issueId the issue ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching issue, or <code>null</code> if a matching issue could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.hska.wi.awp.datasource.model.Issue fetchByIssueId_Last(
        java.lang.String issueId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByIssueId_Last(issueId, orderByComparator);
    }

    /**
    * Removes all the issues where issueId = &#63; from the database.
    *
    * @param issueId the issue ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByIssueId(java.lang.String issueId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByIssueId(issueId);
    }

    /**
    * Returns the number of issues where issueId = &#63;.
    *
    * @param issueId the issue ID
    * @return the number of matching issues
    * @throws SystemException if a system exception occurred
    */
    public static int countByIssueId(java.lang.String issueId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByIssueId(issueId);
    }

    /**
    * Caches the issue in the entity cache if it is enabled.
    *
    * @param issue the issue
    */
    public static void cacheResult(de.hska.wi.awp.datasource.model.Issue issue) {
        getPersistence().cacheResult(issue);
    }

    /**
    * Caches the issues in the entity cache if it is enabled.
    *
    * @param issues the issues
    */
    public static void cacheResult(
        java.util.List<de.hska.wi.awp.datasource.model.Issue> issues) {
        getPersistence().cacheResult(issues);
    }

    /**
    * Creates a new issue with the primary key. Does not add the issue to the database.
    *
    * @param issueId the primary key for the new issue
    * @return the new issue
    */
    public static de.hska.wi.awp.datasource.model.Issue create(
        java.lang.String issueId) {
        return getPersistence().create(issueId);
    }

    /**
    * Removes the issue with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param issueId the primary key of the issue
    * @return the issue that was removed
    * @throws de.hska.wi.awp.datasource.NoSuchIssueException if a issue with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.hska.wi.awp.datasource.model.Issue remove(
        java.lang.String issueId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.hska.wi.awp.datasource.NoSuchIssueException {
        return getPersistence().remove(issueId);
    }

    public static de.hska.wi.awp.datasource.model.Issue updateImpl(
        de.hska.wi.awp.datasource.model.Issue issue)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(issue);
    }

    /**
    * Returns the issue with the primary key or throws a {@link de.hska.wi.awp.datasource.NoSuchIssueException} if it could not be found.
    *
    * @param issueId the primary key of the issue
    * @return the issue
    * @throws de.hska.wi.awp.datasource.NoSuchIssueException if a issue with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.hska.wi.awp.datasource.model.Issue findByPrimaryKey(
        java.lang.String issueId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.hska.wi.awp.datasource.NoSuchIssueException {
        return getPersistence().findByPrimaryKey(issueId);
    }

    /**
    * Returns the issue with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param issueId the primary key of the issue
    * @return the issue, or <code>null</code> if a issue with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.hska.wi.awp.datasource.model.Issue fetchByPrimaryKey(
        java.lang.String issueId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(issueId);
    }

    /**
    * Returns all the issues.
    *
    * @return the issues
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.hska.wi.awp.datasource.model.Issue> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<de.hska.wi.awp.datasource.model.Issue> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the issues.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.hska.wi.awp.datasource.model.impl.IssueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of issues
    * @param end the upper bound of the range of issues (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of issues
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.hska.wi.awp.datasource.model.Issue> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the issues from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of issues.
    *
    * @return the number of issues
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static IssuePersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (IssuePersistence) PortletBeanLocatorUtil.locate(de.hska.wi.awp.datasource.service.ClpSerializer.getServletContextName(),
                    IssuePersistence.class.getName());

            ReferenceRegistry.registerReference(IssueUtil.class, "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(IssuePersistence persistence) {
    }
}
