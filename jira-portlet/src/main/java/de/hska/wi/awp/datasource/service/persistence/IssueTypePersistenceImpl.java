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

import de.hska.wi.awp.datasource.NoSuchIssueTypeException;
import de.hska.wi.awp.datasource.model.IssueType;
import de.hska.wi.awp.datasource.model.impl.IssueTypeImpl;
import de.hska.wi.awp.datasource.model.impl.IssueTypeModelImpl;
import de.hska.wi.awp.datasource.service.persistence.IssueTypePersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the issue type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see IssueTypePersistence
 * @see IssueTypeUtil
 * @generated
 */
public class IssueTypePersistenceImpl extends BasePersistenceImpl<IssueType>
    implements IssueTypePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link IssueTypeUtil} to access the issue type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = IssueTypeImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(IssueTypeModelImpl.ENTITY_CACHE_ENABLED,
            IssueTypeModelImpl.FINDER_CACHE_ENABLED, IssueTypeImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(IssueTypeModelImpl.ENTITY_CACHE_ENABLED,
            IssueTypeModelImpl.FINDER_CACHE_ENABLED, IssueTypeImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(IssueTypeModelImpl.ENTITY_CACHE_ENABLED,
            IssueTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_ISSUETYPE = "SELECT issueType FROM IssueType issueType";
    private static final String _SQL_COUNT_ISSUETYPE = "SELECT COUNT(issueType) FROM IssueType issueType";
    private static final String _ORDER_BY_ENTITY_ALIAS = "issueType.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No IssueType exists with the primary key ";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(IssueTypePersistenceImpl.class);
    private static IssueType _nullIssueType = new IssueTypeImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<IssueType> toCacheModel() {
                return _nullIssueTypeCacheModel;
            }
        };

    private static CacheModel<IssueType> _nullIssueTypeCacheModel = new CacheModel<IssueType>() {
            @Override
            public IssueType toEntityModel() {
                return _nullIssueType;
            }
        };

    public IssueTypePersistenceImpl() {
        setModelClass(IssueType.class);
    }

    /**
     * Caches the issue type in the entity cache if it is enabled.
     *
     * @param issueType the issue type
     */
    @Override
    public void cacheResult(IssueType issueType) {
        EntityCacheUtil.putResult(IssueTypeModelImpl.ENTITY_CACHE_ENABLED,
            IssueTypeImpl.class, issueType.getPrimaryKey(), issueType);

        issueType.resetOriginalValues();
    }

    /**
     * Caches the issue types in the entity cache if it is enabled.
     *
     * @param issueTypes the issue types
     */
    @Override
    public void cacheResult(List<IssueType> issueTypes) {
        for (IssueType issueType : issueTypes) {
            if (EntityCacheUtil.getResult(
                        IssueTypeModelImpl.ENTITY_CACHE_ENABLED,
                        IssueTypeImpl.class, issueType.getPrimaryKey()) == null) {
                cacheResult(issueType);
            } else {
                issueType.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all issue types.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(IssueTypeImpl.class.getName());
        }

        EntityCacheUtil.clearCache(IssueTypeImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the issue type.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(IssueType issueType) {
        EntityCacheUtil.removeResult(IssueTypeModelImpl.ENTITY_CACHE_ENABLED,
            IssueTypeImpl.class, issueType.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<IssueType> issueTypes) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (IssueType issueType : issueTypes) {
            EntityCacheUtil.removeResult(IssueTypeModelImpl.ENTITY_CACHE_ENABLED,
                IssueTypeImpl.class, issueType.getPrimaryKey());
        }
    }

    /**
     * Creates a new issue type with the primary key. Does not add the issue type to the database.
     *
     * @param issueId the primary key for the new issue type
     * @return the new issue type
     */
    @Override
    public IssueType create(String issueId) {
        IssueType issueType = new IssueTypeImpl();

        issueType.setNew(true);
        issueType.setPrimaryKey(issueId);

        return issueType;
    }

    /**
     * Removes the issue type with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param issueId the primary key of the issue type
     * @return the issue type that was removed
     * @throws de.hska.wi.awp.datasource.NoSuchIssueTypeException if a issue type with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public IssueType remove(String issueId)
        throws NoSuchIssueTypeException, SystemException {
        return remove((Serializable) issueId);
    }

    /**
     * Removes the issue type with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the issue type
     * @return the issue type that was removed
     * @throws de.hska.wi.awp.datasource.NoSuchIssueTypeException if a issue type with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public IssueType remove(Serializable primaryKey)
        throws NoSuchIssueTypeException, SystemException {
        Session session = null;

        try {
            session = openSession();

            IssueType issueType = (IssueType) session.get(IssueTypeImpl.class,
                    primaryKey);

            if (issueType == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchIssueTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(issueType);
        } catch (NoSuchIssueTypeException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected IssueType removeImpl(IssueType issueType)
        throws SystemException {
        issueType = toUnwrappedModel(issueType);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(issueType)) {
                issueType = (IssueType) session.get(IssueTypeImpl.class,
                        issueType.getPrimaryKeyObj());
            }

            if (issueType != null) {
                session.delete(issueType);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (issueType != null) {
            clearCache(issueType);
        }

        return issueType;
    }

    @Override
    public IssueType updateImpl(
        de.hska.wi.awp.datasource.model.IssueType issueType)
        throws SystemException {
        issueType = toUnwrappedModel(issueType);

        boolean isNew = issueType.isNew();

        Session session = null;

        try {
            session = openSession();

            if (issueType.isNew()) {
                session.save(issueType);

                issueType.setNew(false);
            } else {
                session.merge(issueType);
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

        EntityCacheUtil.putResult(IssueTypeModelImpl.ENTITY_CACHE_ENABLED,
            IssueTypeImpl.class, issueType.getPrimaryKey(), issueType);

        return issueType;
    }

    protected IssueType toUnwrappedModel(IssueType issueType) {
        if (issueType instanceof IssueTypeImpl) {
            return issueType;
        }

        IssueTypeImpl issueTypeImpl = new IssueTypeImpl();

        issueTypeImpl.setNew(issueType.isNew());
        issueTypeImpl.setPrimaryKey(issueType.getPrimaryKey());

        issueTypeImpl.setIssueId(issueType.getIssueId());
        issueTypeImpl.setIssueName(issueType.getIssueName());

        return issueTypeImpl;
    }

    /**
     * Returns the issue type with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the issue type
     * @return the issue type
     * @throws de.hska.wi.awp.datasource.NoSuchIssueTypeException if a issue type with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public IssueType findByPrimaryKey(Serializable primaryKey)
        throws NoSuchIssueTypeException, SystemException {
        IssueType issueType = fetchByPrimaryKey(primaryKey);

        if (issueType == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchIssueTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return issueType;
    }

    /**
     * Returns the issue type with the primary key or throws a {@link de.hska.wi.awp.datasource.NoSuchIssueTypeException} if it could not be found.
     *
     * @param issueId the primary key of the issue type
     * @return the issue type
     * @throws de.hska.wi.awp.datasource.NoSuchIssueTypeException if a issue type with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public IssueType findByPrimaryKey(String issueId)
        throws NoSuchIssueTypeException, SystemException {
        return findByPrimaryKey((Serializable) issueId);
    }

    /**
     * Returns the issue type with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the issue type
     * @return the issue type, or <code>null</code> if a issue type with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public IssueType fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        IssueType issueType = (IssueType) EntityCacheUtil.getResult(IssueTypeModelImpl.ENTITY_CACHE_ENABLED,
                IssueTypeImpl.class, primaryKey);

        if (issueType == _nullIssueType) {
            return null;
        }

        if (issueType == null) {
            Session session = null;

            try {
                session = openSession();

                issueType = (IssueType) session.get(IssueTypeImpl.class,
                        primaryKey);

                if (issueType != null) {
                    cacheResult(issueType);
                } else {
                    EntityCacheUtil.putResult(IssueTypeModelImpl.ENTITY_CACHE_ENABLED,
                        IssueTypeImpl.class, primaryKey, _nullIssueType);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(IssueTypeModelImpl.ENTITY_CACHE_ENABLED,
                    IssueTypeImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return issueType;
    }

    /**
     * Returns the issue type with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param issueId the primary key of the issue type
     * @return the issue type, or <code>null</code> if a issue type with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public IssueType fetchByPrimaryKey(String issueId)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) issueId);
    }

    /**
     * Returns all the issue types.
     *
     * @return the issue types
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<IssueType> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

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
    @Override
    public List<IssueType> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

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
    @Override
    public List<IssueType> findAll(int start, int end,
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

        List<IssueType> list = (List<IssueType>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_ISSUETYPE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_ISSUETYPE;

                if (pagination) {
                    sql = sql.concat(IssueTypeModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<IssueType>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<IssueType>(list);
                } else {
                    list = (List<IssueType>) QueryUtil.list(q, getDialect(),
                            start, end);
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
     * Removes all the issue types from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (IssueType issueType : findAll()) {
            remove(issueType);
        }
    }

    /**
     * Returns the number of issue types.
     *
     * @return the number of issue types
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

                Query q = session.createQuery(_SQL_COUNT_ISSUETYPE);

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
     * Initializes the issue type persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.de.hska.wi.awp.datasource.model.IssueType")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<IssueType>> listenersList = new ArrayList<ModelListener<IssueType>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<IssueType>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(IssueTypeImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
