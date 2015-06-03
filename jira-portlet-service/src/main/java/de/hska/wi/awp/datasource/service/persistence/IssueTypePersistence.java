package de.hska.wi.awp.datasource.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import de.hska.wi.awp.datasource.model.IssueType;

/**
 * The persistence interface for the issue type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see IssueTypePersistenceImpl
 * @see IssueTypeUtil
 * @generated
 */
public interface IssueTypePersistence extends BasePersistence<IssueType> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link IssueTypeUtil} to access the issue type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the issue type in the entity cache if it is enabled.
    *
    * @param issueType the issue type
    */
    public void cacheResult(de.hska.wi.awp.datasource.model.IssueType issueType);

    /**
    * Caches the issue types in the entity cache if it is enabled.
    *
    * @param issueTypes the issue types
    */
    public void cacheResult(
        java.util.List<de.hska.wi.awp.datasource.model.IssueType> issueTypes);

    /**
    * Creates a new issue type with the primary key. Does not add the issue type to the database.
    *
    * @param issueId the primary key for the new issue type
    * @return the new issue type
    */
    public de.hska.wi.awp.datasource.model.IssueType create(long issueId);

    /**
    * Removes the issue type with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param issueId the primary key of the issue type
    * @return the issue type that was removed
    * @throws de.hska.wi.awp.datasource.NoSuchIssueTypeException if a issue type with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.hska.wi.awp.datasource.model.IssueType remove(long issueId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.hska.wi.awp.datasource.NoSuchIssueTypeException;

    public de.hska.wi.awp.datasource.model.IssueType updateImpl(
        de.hska.wi.awp.datasource.model.IssueType issueType)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the issue type with the primary key or throws a {@link de.hska.wi.awp.datasource.NoSuchIssueTypeException} if it could not be found.
    *
    * @param issueId the primary key of the issue type
    * @return the issue type
    * @throws de.hska.wi.awp.datasource.NoSuchIssueTypeException if a issue type with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.hska.wi.awp.datasource.model.IssueType findByPrimaryKey(
        long issueId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.hska.wi.awp.datasource.NoSuchIssueTypeException;

    /**
    * Returns the issue type with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param issueId the primary key of the issue type
    * @return the issue type, or <code>null</code> if a issue type with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.hska.wi.awp.datasource.model.IssueType fetchByPrimaryKey(
        long issueId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the issue types.
    *
    * @return the issue types
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.hska.wi.awp.datasource.model.IssueType> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.hska.wi.awp.datasource.model.IssueType> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.hska.wi.awp.datasource.model.IssueType> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the issue types from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of issue types.
    *
    * @return the number of issue types
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
