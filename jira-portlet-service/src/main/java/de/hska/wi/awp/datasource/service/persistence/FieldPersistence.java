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
