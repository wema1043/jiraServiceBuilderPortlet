package de.hska.wi.awp.datasource.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import de.hska.wi.awp.datasource.model.Field;

/**
 * The persistence interface for the field service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FieldPersistenceImpl
 * @see FieldUtil
 * @generated
 */
public interface FieldPersistence extends BasePersistence<Field> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link FieldUtil} to access the field persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns the field where issueId = &#63; or throws a {@link de.hska.wi.awp.datasource.NoSuchFieldException} if it could not be found.
    *
    * @param issueId the issue ID
    * @return the matching field
    * @throws de.hska.wi.awp.datasource.NoSuchFieldException if a matching field could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.hska.wi.awp.datasource.model.Field findByFieldForIssue(
        java.lang.String issueId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.hska.wi.awp.datasource.NoSuchFieldException;

    /**
    * Returns the field where issueId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param issueId the issue ID
    * @return the matching field, or <code>null</code> if a matching field could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.hska.wi.awp.datasource.model.Field fetchByFieldForIssue(
        java.lang.String issueId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the field where issueId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param issueId the issue ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching field, or <code>null</code> if a matching field could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.hska.wi.awp.datasource.model.Field fetchByFieldForIssue(
        java.lang.String issueId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the field where issueId = &#63; from the database.
    *
    * @param issueId the issue ID
    * @return the field that was removed
    * @throws SystemException if a system exception occurred
    */
    public de.hska.wi.awp.datasource.model.Field removeByFieldForIssue(
        java.lang.String issueId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.hska.wi.awp.datasource.NoSuchFieldException;

    /**
    * Returns the number of fields where issueId = &#63;.
    *
    * @param issueId the issue ID
    * @return the number of matching fields
    * @throws SystemException if a system exception occurred
    */
    public int countByFieldForIssue(java.lang.String issueId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the fields where assigneeId = &#63;.
    *
    * @param assigneeId the assignee ID
    * @return the matching fields
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.hska.wi.awp.datasource.model.Field> findByFieldsForUser(
        java.lang.String assigneeId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the fields where assigneeId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.hska.wi.awp.datasource.model.impl.FieldModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param assigneeId the assignee ID
    * @param start the lower bound of the range of fields
    * @param end the upper bound of the range of fields (not inclusive)
    * @return the range of matching fields
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.hska.wi.awp.datasource.model.Field> findByFieldsForUser(
        java.lang.String assigneeId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the fields where assigneeId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.hska.wi.awp.datasource.model.impl.FieldModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param assigneeId the assignee ID
    * @param start the lower bound of the range of fields
    * @param end the upper bound of the range of fields (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching fields
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.hska.wi.awp.datasource.model.Field> findByFieldsForUser(
        java.lang.String assigneeId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first field in the ordered set where assigneeId = &#63;.
    *
    * @param assigneeId the assignee ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching field
    * @throws de.hska.wi.awp.datasource.NoSuchFieldException if a matching field could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.hska.wi.awp.datasource.model.Field findByFieldsForUser_First(
        java.lang.String assigneeId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.hska.wi.awp.datasource.NoSuchFieldException;

    /**
    * Returns the first field in the ordered set where assigneeId = &#63;.
    *
    * @param assigneeId the assignee ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching field, or <code>null</code> if a matching field could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.hska.wi.awp.datasource.model.Field fetchByFieldsForUser_First(
        java.lang.String assigneeId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last field in the ordered set where assigneeId = &#63;.
    *
    * @param assigneeId the assignee ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching field
    * @throws de.hska.wi.awp.datasource.NoSuchFieldException if a matching field could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.hska.wi.awp.datasource.model.Field findByFieldsForUser_Last(
        java.lang.String assigneeId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.hska.wi.awp.datasource.NoSuchFieldException;

    /**
    * Returns the last field in the ordered set where assigneeId = &#63;.
    *
    * @param assigneeId the assignee ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching field, or <code>null</code> if a matching field could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.hska.wi.awp.datasource.model.Field fetchByFieldsForUser_Last(
        java.lang.String assigneeId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the fields before and after the current field in the ordered set where assigneeId = &#63;.
    *
    * @param fieldId the primary key of the current field
    * @param assigneeId the assignee ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next field
    * @throws de.hska.wi.awp.datasource.NoSuchFieldException if a field with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.hska.wi.awp.datasource.model.Field[] findByFieldsForUser_PrevAndNext(
        long fieldId, java.lang.String assigneeId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.hska.wi.awp.datasource.NoSuchFieldException;

    /**
    * Removes all the fields where assigneeId = &#63; from the database.
    *
    * @param assigneeId the assignee ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByFieldsForUser(java.lang.String assigneeId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of fields where assigneeId = &#63;.
    *
    * @param assigneeId the assignee ID
    * @return the number of matching fields
    * @throws SystemException if a system exception occurred
    */
    public int countByFieldsForUser(java.lang.String assigneeId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the fields where statusId = &#63;.
    *
    * @param statusId the status ID
    * @return the matching fields
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.hska.wi.awp.datasource.model.Field> findByFieldsForStatus(
        long statusId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the fields where statusId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.hska.wi.awp.datasource.model.impl.FieldModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param statusId the status ID
    * @param start the lower bound of the range of fields
    * @param end the upper bound of the range of fields (not inclusive)
    * @return the range of matching fields
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.hska.wi.awp.datasource.model.Field> findByFieldsForStatus(
        long statusId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the fields where statusId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.hska.wi.awp.datasource.model.impl.FieldModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param statusId the status ID
    * @param start the lower bound of the range of fields
    * @param end the upper bound of the range of fields (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching fields
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.hska.wi.awp.datasource.model.Field> findByFieldsForStatus(
        long statusId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first field in the ordered set where statusId = &#63;.
    *
    * @param statusId the status ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching field
    * @throws de.hska.wi.awp.datasource.NoSuchFieldException if a matching field could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.hska.wi.awp.datasource.model.Field findByFieldsForStatus_First(
        long statusId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.hska.wi.awp.datasource.NoSuchFieldException;

    /**
    * Returns the first field in the ordered set where statusId = &#63;.
    *
    * @param statusId the status ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching field, or <code>null</code> if a matching field could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.hska.wi.awp.datasource.model.Field fetchByFieldsForStatus_First(
        long statusId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last field in the ordered set where statusId = &#63;.
    *
    * @param statusId the status ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching field
    * @throws de.hska.wi.awp.datasource.NoSuchFieldException if a matching field could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.hska.wi.awp.datasource.model.Field findByFieldsForStatus_Last(
        long statusId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.hska.wi.awp.datasource.NoSuchFieldException;

    /**
    * Returns the last field in the ordered set where statusId = &#63;.
    *
    * @param statusId the status ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching field, or <code>null</code> if a matching field could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.hska.wi.awp.datasource.model.Field fetchByFieldsForStatus_Last(
        long statusId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the fields before and after the current field in the ordered set where statusId = &#63;.
    *
    * @param fieldId the primary key of the current field
    * @param statusId the status ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next field
    * @throws de.hska.wi.awp.datasource.NoSuchFieldException if a field with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.hska.wi.awp.datasource.model.Field[] findByFieldsForStatus_PrevAndNext(
        long fieldId, long statusId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.hska.wi.awp.datasource.NoSuchFieldException;

    /**
    * Removes all the fields where statusId = &#63; from the database.
    *
    * @param statusId the status ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByFieldsForStatus(long statusId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of fields where statusId = &#63;.
    *
    * @param statusId the status ID
    * @return the number of matching fields
    * @throws SystemException if a system exception occurred
    */
    public int countByFieldsForStatus(long statusId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the field in the entity cache if it is enabled.
    *
    * @param field the field
    */
    public void cacheResult(de.hska.wi.awp.datasource.model.Field field);

    /**
    * Caches the fields in the entity cache if it is enabled.
    *
    * @param fields the fields
    */
    public void cacheResult(
        java.util.List<de.hska.wi.awp.datasource.model.Field> fields);

    /**
    * Creates a new field with the primary key. Does not add the field to the database.
    *
    * @param fieldId the primary key for the new field
    * @return the new field
    */
    public de.hska.wi.awp.datasource.model.Field create(long fieldId);

    /**
    * Removes the field with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param fieldId the primary key of the field
    * @return the field that was removed
    * @throws de.hska.wi.awp.datasource.NoSuchFieldException if a field with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.hska.wi.awp.datasource.model.Field remove(long fieldId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.hska.wi.awp.datasource.NoSuchFieldException;

    public de.hska.wi.awp.datasource.model.Field updateImpl(
        de.hska.wi.awp.datasource.model.Field field)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the field with the primary key or throws a {@link de.hska.wi.awp.datasource.NoSuchFieldException} if it could not be found.
    *
    * @param fieldId the primary key of the field
    * @return the field
    * @throws de.hska.wi.awp.datasource.NoSuchFieldException if a field with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.hska.wi.awp.datasource.model.Field findByPrimaryKey(long fieldId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.hska.wi.awp.datasource.NoSuchFieldException;

    /**
    * Returns the field with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param fieldId the primary key of the field
    * @return the field, or <code>null</code> if a field with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.hska.wi.awp.datasource.model.Field fetchByPrimaryKey(long fieldId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the fields.
    *
    * @return the fields
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.hska.wi.awp.datasource.model.Field> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the fields.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.hska.wi.awp.datasource.model.impl.FieldModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of fields
    * @param end the upper bound of the range of fields (not inclusive)
    * @return the range of fields
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.hska.wi.awp.datasource.model.Field> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the fields.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.hska.wi.awp.datasource.model.impl.FieldModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of fields
    * @param end the upper bound of the range of fields (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of fields
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.hska.wi.awp.datasource.model.Field> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the fields from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of fields.
    *
    * @return the number of fields
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
