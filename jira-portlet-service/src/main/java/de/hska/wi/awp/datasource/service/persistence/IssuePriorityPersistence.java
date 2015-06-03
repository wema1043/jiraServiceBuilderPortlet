package de.hska.wi.awp.datasource.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import de.hska.wi.awp.datasource.model.IssuePriority;

/**
 * The persistence interface for the issue priority service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see IssuePriorityPersistenceImpl
 * @see IssuePriorityUtil
 * @generated
 */
public interface IssuePriorityPersistence extends BasePersistence<IssuePriority> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link IssuePriorityUtil} to access the issue priority persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the issue priority in the entity cache if it is enabled.
    *
    * @param issuePriority the issue priority
    */
    public void cacheResult(
        de.hska.wi.awp.datasource.model.IssuePriority issuePriority);

    /**
    * Caches the issue priorities in the entity cache if it is enabled.
    *
    * @param issuePriorities the issue priorities
    */
    public void cacheResult(
        java.util.List<de.hska.wi.awp.datasource.model.IssuePriority> issuePriorities);

    /**
    * Creates a new issue priority with the primary key. Does not add the issue priority to the database.
    *
    * @param priorityId the primary key for the new issue priority
    * @return the new issue priority
    */
    public de.hska.wi.awp.datasource.model.IssuePriority create(long priorityId);

    /**
    * Removes the issue priority with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param priorityId the primary key of the issue priority
    * @return the issue priority that was removed
    * @throws de.hska.wi.awp.datasource.NoSuchIssuePriorityException if a issue priority with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.hska.wi.awp.datasource.model.IssuePriority remove(long priorityId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.hska.wi.awp.datasource.NoSuchIssuePriorityException;

    public de.hska.wi.awp.datasource.model.IssuePriority updateImpl(
        de.hska.wi.awp.datasource.model.IssuePriority issuePriority)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the issue priority with the primary key or throws a {@link de.hska.wi.awp.datasource.NoSuchIssuePriorityException} if it could not be found.
    *
    * @param priorityId the primary key of the issue priority
    * @return the issue priority
    * @throws de.hska.wi.awp.datasource.NoSuchIssuePriorityException if a issue priority with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.hska.wi.awp.datasource.model.IssuePriority findByPrimaryKey(
        long priorityId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.hska.wi.awp.datasource.NoSuchIssuePriorityException;

    /**
    * Returns the issue priority with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param priorityId the primary key of the issue priority
    * @return the issue priority, or <code>null</code> if a issue priority with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.hska.wi.awp.datasource.model.IssuePriority fetchByPrimaryKey(
        long priorityId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the issue priorities.
    *
    * @return the issue priorities
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.hska.wi.awp.datasource.model.IssuePriority> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.hska.wi.awp.datasource.model.IssuePriority> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.hska.wi.awp.datasource.model.IssuePriority> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the issue priorities from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of issue priorities.
    *
    * @return the number of issue priorities
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
