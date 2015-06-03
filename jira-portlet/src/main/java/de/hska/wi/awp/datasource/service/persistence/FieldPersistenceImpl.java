package de.hska.wi.awp.datasource.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import de.hska.wi.awp.datasource.NoSuchFieldException;
import de.hska.wi.awp.datasource.model.Field;
import de.hska.wi.awp.datasource.model.impl.FieldImpl;
import de.hska.wi.awp.datasource.model.impl.FieldModelImpl;
import de.hska.wi.awp.datasource.service.persistence.FieldPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the field service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FieldPersistence
 * @see FieldUtil
 * @generated
 */
public class FieldPersistenceImpl extends BasePersistenceImpl<Field>
    implements FieldPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link FieldUtil} to access the field persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = FieldImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FieldModelImpl.ENTITY_CACHE_ENABLED,
            FieldModelImpl.FINDER_CACHE_ENABLED, FieldImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FieldModelImpl.ENTITY_CACHE_ENABLED,
            FieldModelImpl.FINDER_CACHE_ENABLED, FieldImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FieldModelImpl.ENTITY_CACHE_ENABLED,
            FieldModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FIELDSFORUSER =
        new FinderPath(FieldModelImpl.ENTITY_CACHE_ENABLED,
            FieldModelImpl.FINDER_CACHE_ENABLED, FieldImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFieldsForUser",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIELDSFORUSER =
        new FinderPath(FieldModelImpl.ENTITY_CACHE_ENABLED,
            FieldModelImpl.FINDER_CACHE_ENABLED, FieldImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFieldsForUser",
            new String[] { String.class.getName() },
            FieldModelImpl.ASSIGNEEID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_FIELDSFORUSER = new FinderPath(FieldModelImpl.ENTITY_CACHE_ENABLED,
            FieldModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFieldsForUser",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_FIELDSFORUSER_ASSIGNEEID_1 = "field.assigneeId IS NULL";
    private static final String _FINDER_COLUMN_FIELDSFORUSER_ASSIGNEEID_2 = "field.assigneeId = ?";
    private static final String _FINDER_COLUMN_FIELDSFORUSER_ASSIGNEEID_3 = "(field.assigneeId IS NULL OR field.assigneeId = '')";
    private static final String _SQL_SELECT_FIELD = "SELECT field FROM Field field";
    private static final String _SQL_SELECT_FIELD_WHERE = "SELECT field FROM Field field WHERE ";
    private static final String _SQL_COUNT_FIELD = "SELECT COUNT(field) FROM Field field";
    private static final String _SQL_COUNT_FIELD_WHERE = "SELECT COUNT(field) FROM Field field WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "field.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Field exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Field exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(FieldPersistenceImpl.class);
    private static Field _nullField = new FieldImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Field> toCacheModel() {
                return _nullFieldCacheModel;
            }
        };

    private static CacheModel<Field> _nullFieldCacheModel = new CacheModel<Field>() {
            @Override
            public Field toEntityModel() {
                return _nullField;
            }
        };

    public FieldPersistenceImpl() {
        setModelClass(Field.class);
    }

    /**
     * Returns all the fields where assigneeId = &#63;.
     *
     * @param assigneeId the assignee ID
     * @return the matching fields
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Field> findByFieldsForUser(String assigneeId)
        throws SystemException {
        return findByFieldsForUser(assigneeId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

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
    @Override
    public List<Field> findByFieldsForUser(String assigneeId, int start, int end)
        throws SystemException {
        return findByFieldsForUser(assigneeId, start, end, null);
    }

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
    @Override
    public List<Field> findByFieldsForUser(String assigneeId, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIELDSFORUSER;
            finderArgs = new Object[] { assigneeId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FIELDSFORUSER;
            finderArgs = new Object[] { assigneeId, start, end, orderByComparator };
        }

        List<Field> list = (List<Field>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Field field : list) {
                if (!Validator.equals(assigneeId, field.getAssigneeId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_FIELD_WHERE);

            boolean bindAssigneeId = false;

            if (assigneeId == null) {
                query.append(_FINDER_COLUMN_FIELDSFORUSER_ASSIGNEEID_1);
            } else if (assigneeId.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_FIELDSFORUSER_ASSIGNEEID_3);
            } else {
                bindAssigneeId = true;

                query.append(_FINDER_COLUMN_FIELDSFORUSER_ASSIGNEEID_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(FieldModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindAssigneeId) {
                    qPos.add(assigneeId);
                }

                if (!pagination) {
                    list = (List<Field>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Field>(list);
                } else {
                    list = (List<Field>) QueryUtil.list(q, getDialect(), start,
                            end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the first field in the ordered set where assigneeId = &#63;.
     *
     * @param assigneeId the assignee ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching field
     * @throws de.hska.wi.awp.datasource.NoSuchFieldException if a matching field could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Field findByFieldsForUser_First(String assigneeId,
        OrderByComparator orderByComparator)
        throws NoSuchFieldException, SystemException {
        Field field = fetchByFieldsForUser_First(assigneeId, orderByComparator);

        if (field != null) {
            return field;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("assigneeId=");
        msg.append(assigneeId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchFieldException(msg.toString());
    }

    /**
     * Returns the first field in the ordered set where assigneeId = &#63;.
     *
     * @param assigneeId the assignee ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching field, or <code>null</code> if a matching field could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Field fetchByFieldsForUser_First(String assigneeId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Field> list = findByFieldsForUser(assigneeId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last field in the ordered set where assigneeId = &#63;.
     *
     * @param assigneeId the assignee ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching field
     * @throws de.hska.wi.awp.datasource.NoSuchFieldException if a matching field could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Field findByFieldsForUser_Last(String assigneeId,
        OrderByComparator orderByComparator)
        throws NoSuchFieldException, SystemException {
        Field field = fetchByFieldsForUser_Last(assigneeId, orderByComparator);

        if (field != null) {
            return field;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("assigneeId=");
        msg.append(assigneeId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchFieldException(msg.toString());
    }

    /**
     * Returns the last field in the ordered set where assigneeId = &#63;.
     *
     * @param assigneeId the assignee ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching field, or <code>null</code> if a matching field could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Field fetchByFieldsForUser_Last(String assigneeId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByFieldsForUser(assigneeId);

        if (count == 0) {
            return null;
        }

        List<Field> list = findByFieldsForUser(assigneeId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

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
    @Override
    public Field[] findByFieldsForUser_PrevAndNext(long fieldId,
        String assigneeId, OrderByComparator orderByComparator)
        throws NoSuchFieldException, SystemException {
        Field field = findByPrimaryKey(fieldId);

        Session session = null;

        try {
            session = openSession();

            Field[] array = new FieldImpl[3];

            array[0] = getByFieldsForUser_PrevAndNext(session, field,
                    assigneeId, orderByComparator, true);

            array[1] = field;

            array[2] = getByFieldsForUser_PrevAndNext(session, field,
                    assigneeId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Field getByFieldsForUser_PrevAndNext(Session session,
        Field field, String assigneeId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_FIELD_WHERE);

        boolean bindAssigneeId = false;

        if (assigneeId == null) {
            query.append(_FINDER_COLUMN_FIELDSFORUSER_ASSIGNEEID_1);
        } else if (assigneeId.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_FIELDSFORUSER_ASSIGNEEID_3);
        } else {
            bindAssigneeId = true;

            query.append(_FINDER_COLUMN_FIELDSFORUSER_ASSIGNEEID_2);
        }

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(FieldModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindAssigneeId) {
            qPos.add(assigneeId);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(field);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Field> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the fields where assigneeId = &#63; from the database.
     *
     * @param assigneeId the assignee ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByFieldsForUser(String assigneeId)
        throws SystemException {
        for (Field field : findByFieldsForUser(assigneeId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(field);
        }
    }

    /**
     * Returns the number of fields where assigneeId = &#63;.
     *
     * @param assigneeId the assignee ID
     * @return the number of matching fields
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByFieldsForUser(String assigneeId)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_FIELDSFORUSER;

        Object[] finderArgs = new Object[] { assigneeId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_FIELD_WHERE);

            boolean bindAssigneeId = false;

            if (assigneeId == null) {
                query.append(_FINDER_COLUMN_FIELDSFORUSER_ASSIGNEEID_1);
            } else if (assigneeId.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_FIELDSFORUSER_ASSIGNEEID_3);
            } else {
                bindAssigneeId = true;

                query.append(_FINDER_COLUMN_FIELDSFORUSER_ASSIGNEEID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindAssigneeId) {
                    qPos.add(assigneeId);
                }

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Caches the field in the entity cache if it is enabled.
     *
     * @param field the field
     */
    @Override
    public void cacheResult(Field field) {
        EntityCacheUtil.putResult(FieldModelImpl.ENTITY_CACHE_ENABLED,
            FieldImpl.class, field.getPrimaryKey(), field);

        field.resetOriginalValues();
    }

    /**
     * Caches the fields in the entity cache if it is enabled.
     *
     * @param fields the fields
     */
    @Override
    public void cacheResult(List<Field> fields) {
        for (Field field : fields) {
            if (EntityCacheUtil.getResult(FieldModelImpl.ENTITY_CACHE_ENABLED,
                        FieldImpl.class, field.getPrimaryKey()) == null) {
                cacheResult(field);
            } else {
                field.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all fields.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(FieldImpl.class.getName());
        }

        EntityCacheUtil.clearCache(FieldImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the field.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Field field) {
        EntityCacheUtil.removeResult(FieldModelImpl.ENTITY_CACHE_ENABLED,
            FieldImpl.class, field.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Field> fields) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Field field : fields) {
            EntityCacheUtil.removeResult(FieldModelImpl.ENTITY_CACHE_ENABLED,
                FieldImpl.class, field.getPrimaryKey());
        }
    }

    /**
     * Creates a new field with the primary key. Does not add the field to the database.
     *
     * @param fieldId the primary key for the new field
     * @return the new field
     */
    @Override
    public Field create(long fieldId) {
        Field field = new FieldImpl();

        field.setNew(true);
        field.setPrimaryKey(fieldId);

        return field;
    }

    /**
     * Removes the field with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param fieldId the primary key of the field
     * @return the field that was removed
     * @throws de.hska.wi.awp.datasource.NoSuchFieldException if a field with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Field remove(long fieldId)
        throws NoSuchFieldException, SystemException {
        return remove((Serializable) fieldId);
    }

    /**
     * Removes the field with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the field
     * @return the field that was removed
     * @throws de.hska.wi.awp.datasource.NoSuchFieldException if a field with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Field remove(Serializable primaryKey)
        throws NoSuchFieldException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Field field = (Field) session.get(FieldImpl.class, primaryKey);

            if (field == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchFieldException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(field);
        } catch (NoSuchFieldException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Field removeImpl(Field field) throws SystemException {
        field = toUnwrappedModel(field);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(field)) {
                field = (Field) session.get(FieldImpl.class,
                        field.getPrimaryKeyObj());
            }

            if (field != null) {
                session.delete(field);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (field != null) {
            clearCache(field);
        }

        return field;
    }

    @Override
    public Field updateImpl(de.hska.wi.awp.datasource.model.Field field)
        throws SystemException {
        field = toUnwrappedModel(field);

        boolean isNew = field.isNew();

        FieldModelImpl fieldModelImpl = (FieldModelImpl) field;

        Session session = null;

        try {
            session = openSession();

            if (field.isNew()) {
                session.save(field);

                field.setNew(false);
            } else {
                session.merge(field);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !FieldModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((fieldModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIELDSFORUSER.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        fieldModelImpl.getOriginalAssigneeId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FIELDSFORUSER,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIELDSFORUSER,
                    args);

                args = new Object[] { fieldModelImpl.getAssigneeId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FIELDSFORUSER,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIELDSFORUSER,
                    args);
            }
        }

        EntityCacheUtil.putResult(FieldModelImpl.ENTITY_CACHE_ENABLED,
            FieldImpl.class, field.getPrimaryKey(), field);

        return field;
    }

    protected Field toUnwrappedModel(Field field) {
        if (field instanceof FieldImpl) {
            return field;
        }

        FieldImpl fieldImpl = new FieldImpl();

        fieldImpl.setNew(field.isNew());
        fieldImpl.setPrimaryKey(field.getPrimaryKey());

        fieldImpl.setFieldId(field.getFieldId());
        fieldImpl.setCreatedDate(field.getCreatedDate());
        fieldImpl.setResolutionDate(field.getResolutionDate());
        fieldImpl.setSummary(field.getSummary());
        fieldImpl.setUpdated(field.getUpdated());
        fieldImpl.setTimespent(field.getTimespent());
        fieldImpl.setTimeestimate(field.getTimeestimate());
        fieldImpl.setTimeoriginalestimate(field.getTimeoriginalestimate());
        fieldImpl.setAggregatetimespent(field.getAggregatetimespent());
        fieldImpl.setAggregatetimeoriginalestimate(field.getAggregatetimeoriginalestimate());
        fieldImpl.setAggregatetimeestimate(field.getAggregatetimeestimate());
        fieldImpl.setDescription(field.getDescription());
        fieldImpl.setStorypoints(field.getStorypoints());
        fieldImpl.setCreatorId(field.getCreatorId());
        fieldImpl.setAssigneeId(field.getAssigneeId());
        fieldImpl.setStatusId(field.getStatusId());

        return fieldImpl;
    }

    /**
     * Returns the field with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the field
     * @return the field
     * @throws de.hska.wi.awp.datasource.NoSuchFieldException if a field with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Field findByPrimaryKey(Serializable primaryKey)
        throws NoSuchFieldException, SystemException {
        Field field = fetchByPrimaryKey(primaryKey);

        if (field == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchFieldException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return field;
    }

    /**
     * Returns the field with the primary key or throws a {@link de.hska.wi.awp.datasource.NoSuchFieldException} if it could not be found.
     *
     * @param fieldId the primary key of the field
     * @return the field
     * @throws de.hska.wi.awp.datasource.NoSuchFieldException if a field with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Field findByPrimaryKey(long fieldId)
        throws NoSuchFieldException, SystemException {
        return findByPrimaryKey((Serializable) fieldId);
    }

    /**
     * Returns the field with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the field
     * @return the field, or <code>null</code> if a field with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Field fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Field field = (Field) EntityCacheUtil.getResult(FieldModelImpl.ENTITY_CACHE_ENABLED,
                FieldImpl.class, primaryKey);

        if (field == _nullField) {
            return null;
        }

        if (field == null) {
            Session session = null;

            try {
                session = openSession();

                field = (Field) session.get(FieldImpl.class, primaryKey);

                if (field != null) {
                    cacheResult(field);
                } else {
                    EntityCacheUtil.putResult(FieldModelImpl.ENTITY_CACHE_ENABLED,
                        FieldImpl.class, primaryKey, _nullField);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(FieldModelImpl.ENTITY_CACHE_ENABLED,
                    FieldImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return field;
    }

    /**
     * Returns the field with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param fieldId the primary key of the field
     * @return the field, or <code>null</code> if a field with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Field fetchByPrimaryKey(long fieldId) throws SystemException {
        return fetchByPrimaryKey((Serializable) fieldId);
    }

    /**
     * Returns all the fields.
     *
     * @return the fields
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Field> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

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
    @Override
    public List<Field> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

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
    @Override
    public List<Field> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<Field> list = (List<Field>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_FIELD);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_FIELD;

                if (pagination) {
                    sql = sql.concat(FieldModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Field>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Field>(list);
                } else {
                    list = (List<Field>) QueryUtil.list(q, getDialect(), start,
                            end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the fields from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Field field : findAll()) {
            remove(field);
        }
    }

    /**
     * Returns the number of fields.
     *
     * @return the number of fields
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_FIELD);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Initializes the field persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.de.hska.wi.awp.datasource.model.Field")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Field>> listenersList = new ArrayList<ModelListener<Field>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Field>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(FieldImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
