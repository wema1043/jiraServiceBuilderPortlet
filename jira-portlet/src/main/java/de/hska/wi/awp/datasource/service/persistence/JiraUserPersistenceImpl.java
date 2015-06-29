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

import de.hska.wi.awp.datasource.NoSuchJiraUserException;
import de.hska.wi.awp.datasource.model.JiraUser;
import de.hska.wi.awp.datasource.model.impl.JiraUserImpl;
import de.hska.wi.awp.datasource.model.impl.JiraUserModelImpl;
import de.hska.wi.awp.datasource.service.persistence.JiraUserPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the jira user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see JiraUserPersistence
 * @see JiraUserUtil
 * @generated
 */
public class JiraUserPersistenceImpl extends BasePersistenceImpl<JiraUser>
    implements JiraUserPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link JiraUserUtil} to access the jira user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = JiraUserImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(JiraUserModelImpl.ENTITY_CACHE_ENABLED,
            JiraUserModelImpl.FINDER_CACHE_ENABLED, JiraUserImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(JiraUserModelImpl.ENTITY_CACHE_ENABLED,
            JiraUserModelImpl.FINDER_CACHE_ENABLED, JiraUserImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(JiraUserModelImpl.ENTITY_CACHE_ENABLED,
            JiraUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_FETCH_BY_BYNAME = new FinderPath(JiraUserModelImpl.ENTITY_CACHE_ENABLED,
            JiraUserModelImpl.FINDER_CACHE_ENABLED, JiraUserImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchBybyName",
            new String[] { String.class.getName() },
            JiraUserModelImpl.CREATORID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_BYNAME = new FinderPath(JiraUserModelImpl.ENTITY_CACHE_ENABLED,
            JiraUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBybyName",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_BYNAME_CREATORID_1 = "jiraUser.id.creatorId IS NULL";
    private static final String _FINDER_COLUMN_BYNAME_CREATORID_2 = "jiraUser.id.creatorId = ?";
    private static final String _FINDER_COLUMN_BYNAME_CREATORID_3 = "(jiraUser.id.creatorId IS NULL OR jiraUser.id.creatorId = '')";
    private static final String _SQL_SELECT_JIRAUSER = "SELECT jiraUser FROM JiraUser jiraUser";
    private static final String _SQL_SELECT_JIRAUSER_WHERE = "SELECT jiraUser FROM JiraUser jiraUser WHERE ";
    private static final String _SQL_COUNT_JIRAUSER = "SELECT COUNT(jiraUser) FROM JiraUser jiraUser";
    private static final String _SQL_COUNT_JIRAUSER_WHERE = "SELECT COUNT(jiraUser) FROM JiraUser jiraUser WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "jiraUser.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No JiraUser exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No JiraUser exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(JiraUserPersistenceImpl.class);
    private static JiraUser _nullJiraUser = new JiraUserImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<JiraUser> toCacheModel() {
                return _nullJiraUserCacheModel;
            }
        };

    private static CacheModel<JiraUser> _nullJiraUserCacheModel = new CacheModel<JiraUser>() {
            @Override
            public JiraUser toEntityModel() {
                return _nullJiraUser;
            }
        };

    public JiraUserPersistenceImpl() {
        setModelClass(JiraUser.class);
    }

    /**
     * Returns the jira user where creatorId = &#63; or throws a {@link de.hska.wi.awp.datasource.NoSuchJiraUserException} if it could not be found.
     *
     * @param creatorId the creator ID
     * @return the matching jira user
     * @throws de.hska.wi.awp.datasource.NoSuchJiraUserException if a matching jira user could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public JiraUser findBybyName(String creatorId)
        throws NoSuchJiraUserException, SystemException {
        JiraUser jiraUser = fetchBybyName(creatorId);

        if (jiraUser == null) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("creatorId=");
            msg.append(creatorId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchJiraUserException(msg.toString());
        }

        return jiraUser;
    }

    /**
     * Returns the jira user where creatorId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param creatorId the creator ID
     * @return the matching jira user, or <code>null</code> if a matching jira user could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public JiraUser fetchBybyName(String creatorId) throws SystemException {
        return fetchBybyName(creatorId, true);
    }

    /**
     * Returns the jira user where creatorId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param creatorId the creator ID
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching jira user, or <code>null</code> if a matching jira user could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public JiraUser fetchBybyName(String creatorId, boolean retrieveFromCache)
        throws SystemException {
        Object[] finderArgs = new Object[] { creatorId };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_BYNAME,
                    finderArgs, this);
        }

        if (result instanceof JiraUser) {
            JiraUser jiraUser = (JiraUser) result;

            if (!Validator.equals(creatorId, jiraUser.getCreatorId())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_SELECT_JIRAUSER_WHERE);

            boolean bindCreatorId = false;

            if (creatorId == null) {
                query.append(_FINDER_COLUMN_BYNAME_CREATORID_1);
            } else if (creatorId.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_BYNAME_CREATORID_3);
            } else {
                bindCreatorId = true;

                query.append(_FINDER_COLUMN_BYNAME_CREATORID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindCreatorId) {
                    qPos.add(creatorId);
                }

                List<JiraUser> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BYNAME,
                        finderArgs, list);
                } else {
                    if ((list.size() > 1) && _log.isWarnEnabled()) {
                        _log.warn(
                            "JiraUserPersistenceImpl.fetchBybyName(String, boolean) with parameters (" +
                            StringUtil.merge(finderArgs) +
                            ") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
                    }

                    JiraUser jiraUser = list.get(0);

                    result = jiraUser;

                    cacheResult(jiraUser);

                    if ((jiraUser.getCreatorId() == null) ||
                            !jiraUser.getCreatorId().equals(creatorId)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BYNAME,
                            finderArgs, jiraUser);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_BYNAME,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (JiraUser) result;
        }
    }

    /**
     * Removes the jira user where creatorId = &#63; from the database.
     *
     * @param creatorId the creator ID
     * @return the jira user that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public JiraUser removeBybyName(String creatorId)
        throws NoSuchJiraUserException, SystemException {
        JiraUser jiraUser = findBybyName(creatorId);

        return remove(jiraUser);
    }

    /**
     * Returns the number of jira users where creatorId = &#63;.
     *
     * @param creatorId the creator ID
     * @return the number of matching jira users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countBybyName(String creatorId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_BYNAME;

        Object[] finderArgs = new Object[] { creatorId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_JIRAUSER_WHERE);

            boolean bindCreatorId = false;

            if (creatorId == null) {
                query.append(_FINDER_COLUMN_BYNAME_CREATORID_1);
            } else if (creatorId.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_BYNAME_CREATORID_3);
            } else {
                bindCreatorId = true;

                query.append(_FINDER_COLUMN_BYNAME_CREATORID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindCreatorId) {
                    qPos.add(creatorId);
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
     * Caches the jira user in the entity cache if it is enabled.
     *
     * @param jiraUser the jira user
     */
    @Override
    public void cacheResult(JiraUser jiraUser) {
        EntityCacheUtil.putResult(JiraUserModelImpl.ENTITY_CACHE_ENABLED,
            JiraUserImpl.class, jiraUser.getPrimaryKey(), jiraUser);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BYNAME,
            new Object[] { jiraUser.getCreatorId() }, jiraUser);

        jiraUser.resetOriginalValues();
    }

    /**
     * Caches the jira users in the entity cache if it is enabled.
     *
     * @param jiraUsers the jira users
     */
    @Override
    public void cacheResult(List<JiraUser> jiraUsers) {
        for (JiraUser jiraUser : jiraUsers) {
            if (EntityCacheUtil.getResult(
                        JiraUserModelImpl.ENTITY_CACHE_ENABLED,
                        JiraUserImpl.class, jiraUser.getPrimaryKey()) == null) {
                cacheResult(jiraUser);
            } else {
                jiraUser.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all jira users.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(JiraUserImpl.class.getName());
        }

        EntityCacheUtil.clearCache(JiraUserImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the jira user.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(JiraUser jiraUser) {
        EntityCacheUtil.removeResult(JiraUserModelImpl.ENTITY_CACHE_ENABLED,
            JiraUserImpl.class, jiraUser.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(jiraUser);
    }

    @Override
    public void clearCache(List<JiraUser> jiraUsers) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (JiraUser jiraUser : jiraUsers) {
            EntityCacheUtil.removeResult(JiraUserModelImpl.ENTITY_CACHE_ENABLED,
                JiraUserImpl.class, jiraUser.getPrimaryKey());

            clearUniqueFindersCache(jiraUser);
        }
    }

    protected void cacheUniqueFindersCache(JiraUser jiraUser) {
        if (jiraUser.isNew()) {
            Object[] args = new Object[] { jiraUser.getCreatorId() };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_BYNAME, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BYNAME, args,
                jiraUser);
        } else {
            JiraUserModelImpl jiraUserModelImpl = (JiraUserModelImpl) jiraUser;

            if ((jiraUserModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_BYNAME.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { jiraUser.getCreatorId() };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_BYNAME, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BYNAME, args,
                    jiraUser);
            }
        }
    }

    protected void clearUniqueFindersCache(JiraUser jiraUser) {
        JiraUserModelImpl jiraUserModelImpl = (JiraUserModelImpl) jiraUser;

        Object[] args = new Object[] { jiraUser.getCreatorId() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYNAME, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_BYNAME, args);

        if ((jiraUserModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_BYNAME.getColumnBitmask()) != 0) {
            args = new Object[] { jiraUserModelImpl.getOriginalCreatorId() };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYNAME, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_BYNAME, args);
        }
    }

    /**
     * Creates a new jira user with the primary key. Does not add the jira user to the database.
     *
     * @param jiraUserPK the primary key for the new jira user
     * @return the new jira user
     */
    @Override
    public JiraUser create(JiraUserPK jiraUserPK) {
        JiraUser jiraUser = new JiraUserImpl();

        jiraUser.setNew(true);
        jiraUser.setPrimaryKey(jiraUserPK);

        return jiraUser;
    }

    /**
     * Removes the jira user with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param jiraUserPK the primary key of the jira user
     * @return the jira user that was removed
     * @throws de.hska.wi.awp.datasource.NoSuchJiraUserException if a jira user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public JiraUser remove(JiraUserPK jiraUserPK)
        throws NoSuchJiraUserException, SystemException {
        return remove((Serializable) jiraUserPK);
    }

    /**
     * Removes the jira user with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the jira user
     * @return the jira user that was removed
     * @throws de.hska.wi.awp.datasource.NoSuchJiraUserException if a jira user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public JiraUser remove(Serializable primaryKey)
        throws NoSuchJiraUserException, SystemException {
        Session session = null;

        try {
            session = openSession();

            JiraUser jiraUser = (JiraUser) session.get(JiraUserImpl.class,
                    primaryKey);

            if (jiraUser == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchJiraUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(jiraUser);
        } catch (NoSuchJiraUserException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected JiraUser removeImpl(JiraUser jiraUser) throws SystemException {
        jiraUser = toUnwrappedModel(jiraUser);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(jiraUser)) {
                jiraUser = (JiraUser) session.get(JiraUserImpl.class,
                        jiraUser.getPrimaryKeyObj());
            }

            if (jiraUser != null) {
                session.delete(jiraUser);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (jiraUser != null) {
            clearCache(jiraUser);
        }

        return jiraUser;
    }

    @Override
    public JiraUser updateImpl(
        de.hska.wi.awp.datasource.model.JiraUser jiraUser)
        throws SystemException {
        jiraUser = toUnwrappedModel(jiraUser);

        boolean isNew = jiraUser.isNew();

        Session session = null;

        try {
            session = openSession();

            if (jiraUser.isNew()) {
                session.save(jiraUser);

                jiraUser.setNew(false);
            } else {
                session.merge(jiraUser);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !JiraUserModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        EntityCacheUtil.putResult(JiraUserModelImpl.ENTITY_CACHE_ENABLED,
            JiraUserImpl.class, jiraUser.getPrimaryKey(), jiraUser);

        clearUniqueFindersCache(jiraUser);
        cacheUniqueFindersCache(jiraUser);

        return jiraUser;
    }

    protected JiraUser toUnwrappedModel(JiraUser jiraUser) {
        if (jiraUser instanceof JiraUserImpl) {
            return jiraUser;
        }

        JiraUserImpl jiraUserImpl = new JiraUserImpl();

        jiraUserImpl.setNew(jiraUser.isNew());
        jiraUserImpl.setPrimaryKey(jiraUser.getPrimaryKey());

        jiraUserImpl.setCreatorId(jiraUser.getCreatorId());
        jiraUserImpl.setDisplayname(jiraUser.getDisplayname());
        jiraUserImpl.setGroupId(jiraUser.getGroupId());

        return jiraUserImpl;
    }

    /**
     * Returns the jira user with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the jira user
     * @return the jira user
     * @throws de.hska.wi.awp.datasource.NoSuchJiraUserException if a jira user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public JiraUser findByPrimaryKey(Serializable primaryKey)
        throws NoSuchJiraUserException, SystemException {
        JiraUser jiraUser = fetchByPrimaryKey(primaryKey);

        if (jiraUser == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchJiraUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return jiraUser;
    }

    /**
     * Returns the jira user with the primary key or throws a {@link de.hska.wi.awp.datasource.NoSuchJiraUserException} if it could not be found.
     *
     * @param jiraUserPK the primary key of the jira user
     * @return the jira user
     * @throws de.hska.wi.awp.datasource.NoSuchJiraUserException if a jira user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public JiraUser findByPrimaryKey(JiraUserPK jiraUserPK)
        throws NoSuchJiraUserException, SystemException {
        return findByPrimaryKey((Serializable) jiraUserPK);
    }

    /**
     * Returns the jira user with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the jira user
     * @return the jira user, or <code>null</code> if a jira user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public JiraUser fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        JiraUser jiraUser = (JiraUser) EntityCacheUtil.getResult(JiraUserModelImpl.ENTITY_CACHE_ENABLED,
                JiraUserImpl.class, primaryKey);

        if (jiraUser == _nullJiraUser) {
            return null;
        }

        if (jiraUser == null) {
            Session session = null;

            try {
                session = openSession();

                jiraUser = (JiraUser) session.get(JiraUserImpl.class, primaryKey);

                if (jiraUser != null) {
                    cacheResult(jiraUser);
                } else {
                    EntityCacheUtil.putResult(JiraUserModelImpl.ENTITY_CACHE_ENABLED,
                        JiraUserImpl.class, primaryKey, _nullJiraUser);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(JiraUserModelImpl.ENTITY_CACHE_ENABLED,
                    JiraUserImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return jiraUser;
    }

    /**
     * Returns the jira user with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param jiraUserPK the primary key of the jira user
     * @return the jira user, or <code>null</code> if a jira user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public JiraUser fetchByPrimaryKey(JiraUserPK jiraUserPK)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) jiraUserPK);
    }

    /**
     * Returns all the jira users.
     *
     * @return the jira users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<JiraUser> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

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
    @Override
    public List<JiraUser> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

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
    @Override
    public List<JiraUser> findAll(int start, int end,
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

        List<JiraUser> list = (List<JiraUser>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_JIRAUSER);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_JIRAUSER;

                if (pagination) {
                    sql = sql.concat(JiraUserModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<JiraUser>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<JiraUser>(list);
                } else {
                    list = (List<JiraUser>) QueryUtil.list(q, getDialect(),
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
     * Removes all the jira users from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (JiraUser jiraUser : findAll()) {
            remove(jiraUser);
        }
    }

    /**
     * Returns the number of jira users.
     *
     * @return the number of jira users
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

                Query q = session.createQuery(_SQL_COUNT_JIRAUSER);

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
     * Initializes the jira user persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.de.hska.wi.awp.datasource.model.JiraUser")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<JiraUser>> listenersList = new ArrayList<ModelListener<JiraUser>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<JiraUser>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(JiraUserImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
