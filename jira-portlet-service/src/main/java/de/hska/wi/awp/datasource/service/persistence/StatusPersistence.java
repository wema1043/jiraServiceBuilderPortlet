package de.hska.wi.awp.datasource.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import de.hska.wi.awp.datasource.model.Status;

/**
 * The persistence interface for the status service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StatusPersistenceImpl
 * @see StatusUtil
 * @generated
 */
public interface StatusPersistence extends BasePersistence<Status> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link StatusUtil} to access the status persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the statuses where name = &#63;.
    *
    * @param name the name
    * @return the matching statuses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.hska.wi.awp.datasource.model.Status> findBystatusName(
        java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the statuses where name = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.hska.wi.awp.datasource.model.impl.StatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param name the name
    * @param start the lower bound of the range of statuses
    * @param end the upper bound of the range of statuses (not inclusive)
    * @return the range of matching statuses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.hska.wi.awp.datasource.model.Status> findBystatusName(
        java.lang.String name, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the statuses where name = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.hska.wi.awp.datasource.model.impl.StatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param name the name
    * @param start the lower bound of the range of statuses
    * @param end the upper bound of the range of statuses (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching statuses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.hska.wi.awp.datasource.model.Status> findBystatusName(
        java.lang.String name, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first status in the ordered set where name = &#63;.
    *
    * @param name the name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching status
    * @throws de.hska.wi.awp.datasource.NoSuchStatusException if a matching status could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.hska.wi.awp.datasource.model.Status findBystatusName_First(
        java.lang.String name,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.hska.wi.awp.datasource.NoSuchStatusException;

    /**
    * Returns the first status in the ordered set where name = &#63;.
    *
    * @param name the name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching status, or <code>null</code> if a matching status could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.hska.wi.awp.datasource.model.Status fetchBystatusName_First(
        java.lang.String name,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last status in the ordered set where name = &#63;.
    *
    * @param name the name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching status
    * @throws de.hska.wi.awp.datasource.NoSuchStatusException if a matching status could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.hska.wi.awp.datasource.model.Status findBystatusName_Last(
        java.lang.String name,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.hska.wi.awp.datasource.NoSuchStatusException;

    /**
    * Returns the last status in the ordered set where name = &#63;.
    *
    * @param name the name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching status, or <code>null</code> if a matching status could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.hska.wi.awp.datasource.model.Status fetchBystatusName_Last(
        java.lang.String name,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the statuses before and after the current status in the ordered set where name = &#63;.
    *
    * @param statusId the primary key of the current status
    * @param name the name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next status
    * @throws de.hska.wi.awp.datasource.NoSuchStatusException if a status with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.hska.wi.awp.datasource.model.Status[] findBystatusName_PrevAndNext(
        long statusId, java.lang.String name,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.hska.wi.awp.datasource.NoSuchStatusException;

    /**
    * Removes all the statuses where name = &#63; from the database.
    *
    * @param name the name
    * @throws SystemException if a system exception occurred
    */
    public void removeBystatusName(java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of statuses where name = &#63;.
    *
    * @param name the name
    * @return the number of matching statuses
    * @throws SystemException if a system exception occurred
    */
    public int countBystatusName(java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the status in the entity cache if it is enabled.
    *
    * @param status the status
    */
    public void cacheResult(de.hska.wi.awp.datasource.model.Status status);

    /**
    * Caches the statuses in the entity cache if it is enabled.
    *
    * @param statuses the statuses
    */
    public void cacheResult(
        java.util.List<de.hska.wi.awp.datasource.model.Status> statuses);

    /**
    * Creates a new status with the primary key. Does not add the status to the database.
    *
    * @param statusId the primary key for the new status
    * @return the new status
    */
    public de.hska.wi.awp.datasource.model.Status create(long statusId);

    /**
    * Removes the status with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param statusId the primary key of the status
    * @return the status that was removed
    * @throws de.hska.wi.awp.datasource.NoSuchStatusException if a status with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.hska.wi.awp.datasource.model.Status remove(long statusId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.hska.wi.awp.datasource.NoSuchStatusException;

    public de.hska.wi.awp.datasource.model.Status updateImpl(
        de.hska.wi.awp.datasource.model.Status status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the status with the primary key or throws a {@link de.hska.wi.awp.datasource.NoSuchStatusException} if it could not be found.
    *
    * @param statusId the primary key of the status
    * @return the status
    * @throws de.hska.wi.awp.datasource.NoSuchStatusException if a status with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.hska.wi.awp.datasource.model.Status findByPrimaryKey(
        long statusId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.hska.wi.awp.datasource.NoSuchStatusException;

    /**
    * Returns the status with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param statusId the primary key of the status
    * @return the status, or <code>null</code> if a status with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.hska.wi.awp.datasource.model.Status fetchByPrimaryKey(
        long statusId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the statuses.
    *
    * @return the statuses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.hska.wi.awp.datasource.model.Status> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.hska.wi.awp.datasource.model.Status> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the statuses.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.hska.wi.awp.datasource.model.impl.StatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of statuses
    * @param end the upper bound of the range of statuses (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of statuses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.hska.wi.awp.datasource.model.Status> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the statuses from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of statuses.
    *
    * @return the number of statuses
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
