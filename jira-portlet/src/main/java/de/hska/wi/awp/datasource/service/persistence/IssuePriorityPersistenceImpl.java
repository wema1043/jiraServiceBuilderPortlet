package de.hska.wi.awp.datasource.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import de.hska.wi.awp.datasource.NoSuchIssuePriorityException;
import de.hska.wi.awp.datasource.model.IssuePriority;
import de.hska.wi.awp.datasource.model.impl.IssuePriorityImpl;
import de.hska.wi.awp.datasource.model.impl.IssuePriorityModelImpl;
import de.hska.wi.awp.datasource.service.persistence.IssuePriorityPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the issue priority service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see IssuePriorityPersistence
 * @see IssuePriorityUtil
 * @generated
 */
public class IssuePriorityPersistenceImpl extends BasePersistenceImpl<IssuePriority>
    implements IssuePriorityPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link IssuePriorityUtil} to access the issue priority persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = IssuePriorityImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(IssuePriorityModelImpl.ENTITY_CACHE_ENABLED,
            IssuePriorityModelImpl.FINDER_CACHE_ENABLED,
            IssuePriorityImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(IssuePriorityModelImpl.ENTITY_CACHE_ENABLED,
            IssuePriorityModelImpl.FINDER_CACHE_ENABLED,
            IssuePriorityImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(IssuePriorityModelImpl.ENTITY_CACHE_ENABLED,
            IssuePriorityModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_ISSUEPRIORITY = "SELECT issuePriority FROM IssuePriority issuePriority";
    private static final String _SQL_COUNT_ISSUEPRIORITY = "SELECT COUNT(issuePriority) FROM IssuePriority issuePriority";
    private static final String _ORDER_BY_ENTITY_ALIAS = "issuePriority.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No IssuePriority exists with the primary key ";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(IssuePriorityPersistenceImpl.class);
    private static IssuePriority _nullIssuePriority = new IssuePriorityImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<IssuePriority> toCacheModel() {
                return _nullIssuePriorityCacheModel;
            }
        };

    private static CacheModel<IssuePriority> _nullIssuePriorityCacheModel = new CacheModel<IssuePriority>() {
            @Override
            public IssuePriority toEntityModel() {
                return _nullIssuePriority;
            }
        };

    public IssuePriorityPersistenceImpl() {
        setModelClass(IssuePriority.class);
    }

    /**
     * Caches the issue priority in the entity cache if it is enabled.
     *
     * @param issuePriority the issue priority
     */
    @Override
    public void cacheResult(IssuePriority issuePriority) {
        EntityCacheUtil.putResult(IssuePriorityModelImpl.ENTITY_CACHE_ENABLED,
            IssuePriorityImpl.class, issuePriority.getPrimaryKey(),
            issuePriority);

        issuePriority.resetOriginalValues();
    }

    /**
     * Caches the issue priorities in the entity cache if it is enabled.
     *
     * @param issuePriorities the issue priorities
     */
    @Override
    public void cacheResult(List<IssuePriority> issuePriorities) {
        for (IssuePriority issuePriority : issuePriorities) {
            if (EntityCacheUtil.getResult(
                        IssuePriorityModelImpl.ENTITY_CACHE_ENABLED,
                        IssuePriorityImpl.class, issuePriority.getPrimaryKey()) == null) {
                cacheResult(issuePriority);
            } else {
                issuePriority.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all issue priorities.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(IssuePriorityImpl.class.getName());
        }

        EntityCacheUtil.clearCache(IssuePriorityImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the issue priority.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(IssuePriority issuePriority) {
        EntityCacheUtil.removeResult(IssuePriorityModelImpl.ENTITY_CACHE_ENABLED,
            IssuePriorityImpl.class, issuePriority.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<IssuePriority> issuePriorities) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (IssuePriority issuePriority : issuePriorities) {
            EntityCacheUtil.removeResult(IssuePriorityModelImpl.ENTITY_CACHE_ENABLED,
                IssuePriorityImpl.class, issuePriority.getPrimaryKey());
        }
    }

    /**
     * Creates a new issue priority with the primary key. Does not add the issue priority to the database.
     *
     * @param priorityId the primary key for the new issue priority
     * @return the new issue priority
     */
    @Override
    public IssuePriority create(long priorityId) {
        IssuePriority issuePriority = new IssuePriorityImpl();

        issuePriority.setNew(true);
        issuePriority.setPrimaryKey(priorityId);

        return issuePriority;
    }

    /**
     * Removes the issue priority with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param priorityId the primary key of the issue priority
     * @return the issue priority that was removed
     * @throws de.hska.wi.awp.datasource.NoSuchIssuePriorityException if a issue priority with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public IssuePriority remove(long priorityId)
        throws NoSuchIssuePriorityException, SystemException {
        return remove((Serializable) priorityId);
    }

    /**
     * Removes the issue priority with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the issue priority
     * @return the issue priority that was removed
     * @throws de.hska.wi.awp.datasource.NoSuchIssuePriorityException if a issue priority with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public IssuePriority remove(Serializable primaryKey)
        throws NoSuchIssuePriorityException, SystemException {
        Session session = null;

        try {
            session = openSession();

            IssuePriority issuePriority = (IssuePriority) session.get(IssuePriorityImpl.class,
                    primaryKey);

            if (issuePriority == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchIssuePriorityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(issuePriority);
        } catch (NoSuchIssuePriorityException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected IssuePriority removeImpl(IssuePriority issuePriority)
        throws SystemException {
        issuePriority = toUnwrappedModel(issuePriority);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(issuePriority)) {
                issuePriority = (IssuePriority) session.get(IssuePriorityImpl.class,
                        issuePriority.getPrimaryKeyObj());
            }

            if (issuePriority != null) {
                session.delete(issuePriority);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (issuePriority != null) {
            clearCache(issuePriority);
        }

        return issuePriority;
    }

    @Override
    public IssuePriority updateImpl(
        de.hska.wi.awp.datasource.model.IssuePriority issuePriority)
        throws SystemException {
        issuePriority = toUnwrappedModel(issuePriority);

        boolean isNew = issuePriority.isNew();

        Session session = null;

        try {
            session = openSession();

            if (issuePriority.isNew()) {
                session.save(issuePriority);

                issuePriority.setNew(false);
            } else {
                session.merge(issuePriority);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        EntityCacheUtil.putResult(IssuePriorityModelImpl.ENTITY_CACHE_ENABLED,
            IssuePriorityImpl.class, issuePriority.getPrimaryKey(),
            issuePriority);

        return issuePriority;
    }

    protected IssuePriority toUnwrappedModel(IssuePriority issuePriority) {
        if (issuePriority instanceof IssuePriorityImpl) {
            return issuePriority;
        }

        IssuePriorityImpl issuePriorityImpl = new IssuePriorityImpl();

        issuePriorityImpl.setNew(issuePriority.isNew());
        issuePriorityImpl.setPrimaryKey(issuePriority.getPrimaryKey());

        issuePriorityImpl.setPriorityId(issuePriority.getPriorityId());
        issuePriorityImpl.setPriorityName(issuePriority.getPriorityName());

        return issuePriorityImpl;
    }

    /**
     * Returns the issue priority with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the issue priority
     * @return the issue priority
     * @throws de.hska.wi.awp.datasource.NoSuchIssuePriorityException if a issue priority with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public IssuePriority findByPrimaryKey(Serializable primaryKey)
        throws NoSuchIssuePriorityException, SystemException {
        IssuePriority issuePriority = fetchByPrimaryKey(primaryKey);

        if (issuePriority == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchIssuePriorityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return issuePriority;
    }

    /**
     * Returns the issue priority with the primary key or throws a {@link de.hska.wi.awp.datasource.NoSuchIssuePriorityException} if it could not be found.
     *
     * @param priorityId the primary key of the issue priority
     * @return the issue priority
     * @throws de.hska.wi.awp.datasource.NoSuchIssuePriorityException if a issue priority with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public IssuePriority findByPrimaryKey(long priorityId)
        throws NoSuchIssuePriorityException, SystemException {
        return findByPrimaryKey((Serializable) priorityId);
    }

    /**
     * Returns the issue priority with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the issue priority
     * @return the issue priority, or <code>null</code> if a issue priority with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public IssuePriority fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        IssuePriority issuePriority = (IssuePriority) EntityCacheUtil.getResult(IssuePriorityModelImpl.ENTITY_CACHE_ENABLED,
                IssuePriorityImpl.class, primaryKey);

        if (issuePriority == _nullIssuePriority) {
            return null;
        }

        if (issuePriority == null) {
            Session session = null;

            try {
                session = openSession();

                issuePriority = (IssuePriority) session.get(IssuePriorityImpl.class,
                        primaryKey);

                if (issuePriority != null) {
                    cacheResult(issuePriority);
                } else {
                    EntityCacheUtil.putResult(IssuePriorityModelImpl.ENTITY_CACHE_ENABLED,
                        IssuePriorityImpl.class, primaryKey, _nullIssuePriority);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(IssuePriorityModelImpl.ENTITY_CACHE_ENABLED,
                    IssuePriorityImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return issuePriority;
    }

    /**
     * Returns the issue priority with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param priorityId the primary key of the issue priority
     * @return the issue priority, or <code>null</code> if a issue priority with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public IssuePriority fetchByPrimaryKey(long priorityId)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) priorityId);
    }

    /**
     * Returns all the issue priorities.
     *
     * @return the issue priorities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<IssuePriority> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

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
    @Override
    public List<IssuePriority> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

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
    @Override
    public List<IssuePriority> findAll(int start, int end,
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

        List<IssuePriority> list = (List<IssuePriority>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_ISSUEPRIORITY);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_ISSUEPRIORITY;

                if (pagination) {
                    sql = sql.concat(IssuePriorityModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<IssuePriority>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<IssuePriority>(list);
                } else {
                    list = (List<IssuePriority>) QueryUtil.list(q,
                            getDialect(), start, end);
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
     * Removes all the issue priorities from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (IssuePriority issuePriority : findAll()) {
            remove(issuePriority);
        }
    }

    /**
     * Returns the number of issue priorities.
     *
     * @return the number of issue priorities
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

                Query q = session.createQuery(_SQL_COUNT_ISSUEPRIORITY);

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
     * Initializes the issue priority persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.de.hska.wi.awp.datasource.model.IssuePriority")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<IssuePriority>> listenersList = new ArrayList<ModelListener<IssuePriority>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<IssuePriority>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(IssuePriorityImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
