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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import de.hska.wi.awp.datasource.NoSuchProjectException;
import de.hska.wi.awp.datasource.model.Project;
import de.hska.wi.awp.datasource.model.impl.ProjectImpl;
import de.hska.wi.awp.datasource.model.impl.ProjectModelImpl;
import de.hska.wi.awp.datasource.service.persistence.ProjectPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the project service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProjectPersistence
 * @see ProjectUtil
 * @generated
 */
public class ProjectPersistenceImpl extends BasePersistenceImpl<Project>
    implements ProjectPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link ProjectUtil} to access the project persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = ProjectImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ProjectModelImpl.ENTITY_CACHE_ENABLED,
            ProjectModelImpl.FINDER_CACHE_ENABLED, ProjectImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ProjectModelImpl.ENTITY_CACHE_ENABLED,
            ProjectModelImpl.FINDER_CACHE_ENABLED, ProjectImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProjectModelImpl.ENTITY_CACHE_ENABLED,
            ProjectModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_FETCH_BY_KEY = new FinderPath(ProjectModelImpl.ENTITY_CACHE_ENABLED,
            ProjectModelImpl.FINDER_CACHE_ENABLED, ProjectImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByKey",
            new String[] { String.class.getName() },
            ProjectModelImpl.KEY_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_KEY = new FinderPath(ProjectModelImpl.ENTITY_CACHE_ENABLED,
            ProjectModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByKey",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_KEY_KEY_1 = "project.key IS NULL";
    private static final String _FINDER_COLUMN_KEY_KEY_2 = "project.key = ?";
    private static final String _FINDER_COLUMN_KEY_KEY_3 = "(project.key IS NULL OR project.key = '')";
    private static final String _SQL_SELECT_PROJECT = "SELECT project FROM Project project";
    private static final String _SQL_SELECT_PROJECT_WHERE = "SELECT project FROM Project project WHERE ";
    private static final String _SQL_COUNT_PROJECT = "SELECT COUNT(project) FROM Project project";
    private static final String _SQL_COUNT_PROJECT_WHERE = "SELECT COUNT(project) FROM Project project WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "project.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Project exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Project exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(ProjectPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "key"
            });
    private static Project _nullProject = new ProjectImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Project> toCacheModel() {
                return _nullProjectCacheModel;
            }
        };

    private static CacheModel<Project> _nullProjectCacheModel = new CacheModel<Project>() {
            @Override
            public Project toEntityModel() {
                return _nullProject;
            }
        };

    public ProjectPersistenceImpl() {
        setModelClass(Project.class);
    }

    /**
     * Returns the project where key = &#63; or throws a {@link de.hska.wi.awp.datasource.NoSuchProjectException} if it could not be found.
     *
     * @param key the key
     * @return the matching project
     * @throws de.hska.wi.awp.datasource.NoSuchProjectException if a matching project could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Project findByKey(String key)
        throws NoSuchProjectException, SystemException {
        Project project = fetchByKey(key);

        if (project == null) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("key=");
            msg.append(key);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchProjectException(msg.toString());
        }

        return project;
    }

    /**
     * Returns the project where key = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param key the key
     * @return the matching project, or <code>null</code> if a matching project could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Project fetchByKey(String key) throws SystemException {
        return fetchByKey(key, true);
    }

    /**
     * Returns the project where key = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param key the key
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching project, or <code>null</code> if a matching project could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Project fetchByKey(String key, boolean retrieveFromCache)
        throws SystemException {
        Object[] finderArgs = new Object[] { key };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_KEY,
                    finderArgs, this);
        }

        if (result instanceof Project) {
            Project project = (Project) result;

            if (!Validator.equals(key, project.getKey())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_SELECT_PROJECT_WHERE);

            boolean bindKey = false;

            if (key == null) {
                query.append(_FINDER_COLUMN_KEY_KEY_1);
            } else if (key.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_KEY_KEY_3);
            } else {
                bindKey = true;

                query.append(_FINDER_COLUMN_KEY_KEY_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindKey) {
                    qPos.add(key);
                }

                List<Project> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KEY,
                        finderArgs, list);
                } else {
                    if ((list.size() > 1) && _log.isWarnEnabled()) {
                        _log.warn(
                            "ProjectPersistenceImpl.fetchByKey(String, boolean) with parameters (" +
                            StringUtil.merge(finderArgs) +
                            ") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
                    }

                    Project project = list.get(0);

                    result = project;

                    cacheResult(project);

                    if ((project.getKey() == null) ||
                            !project.getKey().equals(key)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KEY,
                            finderArgs, project);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_KEY,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (Project) result;
        }
    }

    /**
     * Removes the project where key = &#63; from the database.
     *
     * @param key the key
     * @return the project that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Project removeByKey(String key)
        throws NoSuchProjectException, SystemException {
        Project project = findByKey(key);

        return remove(project);
    }

    /**
     * Returns the number of projects where key = &#63;.
     *
     * @param key the key
     * @return the number of matching projects
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByKey(String key) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_KEY;

        Object[] finderArgs = new Object[] { key };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_PROJECT_WHERE);

            boolean bindKey = false;

            if (key == null) {
                query.append(_FINDER_COLUMN_KEY_KEY_1);
            } else if (key.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_KEY_KEY_3);
            } else {
                bindKey = true;

                query.append(_FINDER_COLUMN_KEY_KEY_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindKey) {
                    qPos.add(key);
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
     * Caches the project in the entity cache if it is enabled.
     *
     * @param project the project
     */
    @Override
    public void cacheResult(Project project) {
        EntityCacheUtil.putResult(ProjectModelImpl.ENTITY_CACHE_ENABLED,
            ProjectImpl.class, project.getPrimaryKey(), project);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KEY,
            new Object[] { project.getKey() }, project);

        project.resetOriginalValues();
    }

    /**
     * Caches the projects in the entity cache if it is enabled.
     *
     * @param projects the projects
     */
    @Override
    public void cacheResult(List<Project> projects) {
        for (Project project : projects) {
            if (EntityCacheUtil.getResult(
                        ProjectModelImpl.ENTITY_CACHE_ENABLED,
                        ProjectImpl.class, project.getPrimaryKey()) == null) {
                cacheResult(project);
            } else {
                project.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all projects.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(ProjectImpl.class.getName());
        }

        EntityCacheUtil.clearCache(ProjectImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the project.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Project project) {
        EntityCacheUtil.removeResult(ProjectModelImpl.ENTITY_CACHE_ENABLED,
            ProjectImpl.class, project.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(project);
    }

    @Override
    public void clearCache(List<Project> projects) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Project project : projects) {
            EntityCacheUtil.removeResult(ProjectModelImpl.ENTITY_CACHE_ENABLED,
                ProjectImpl.class, project.getPrimaryKey());

            clearUniqueFindersCache(project);
        }
    }

    protected void cacheUniqueFindersCache(Project project) {
        if (project.isNew()) {
            Object[] args = new Object[] { project.getKey() };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_KEY, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KEY, args, project);
        } else {
            ProjectModelImpl projectModelImpl = (ProjectModelImpl) project;

            if ((projectModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_KEY.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { project.getKey() };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_KEY, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KEY, args,
                    project);
            }
        }
    }

    protected void clearUniqueFindersCache(Project project) {
        ProjectModelImpl projectModelImpl = (ProjectModelImpl) project;

        Object[] args = new Object[] { project.getKey() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_KEY, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_KEY, args);

        if ((projectModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_KEY.getColumnBitmask()) != 0) {
            args = new Object[] { projectModelImpl.getOriginalKey() };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_KEY, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_KEY, args);
        }
    }

    /**
     * Creates a new project with the primary key. Does not add the project to the database.
     *
     * @param projectId the primary key for the new project
     * @return the new project
     */
    @Override
    public Project create(String projectId) {
        Project project = new ProjectImpl();

        project.setNew(true);
        project.setPrimaryKey(projectId);

        return project;
    }

    /**
     * Removes the project with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param projectId the primary key of the project
     * @return the project that was removed
     * @throws de.hska.wi.awp.datasource.NoSuchProjectException if a project with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Project remove(String projectId)
        throws NoSuchProjectException, SystemException {
        return remove((Serializable) projectId);
    }

    /**
     * Removes the project with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the project
     * @return the project that was removed
     * @throws de.hska.wi.awp.datasource.NoSuchProjectException if a project with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Project remove(Serializable primaryKey)
        throws NoSuchProjectException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Project project = (Project) session.get(ProjectImpl.class,
                    primaryKey);

            if (project == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchProjectException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(project);
        } catch (NoSuchProjectException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Project removeImpl(Project project) throws SystemException {
        project = toUnwrappedModel(project);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(project)) {
                project = (Project) session.get(ProjectImpl.class,
                        project.getPrimaryKeyObj());
            }

            if (project != null) {
                session.delete(project);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (project != null) {
            clearCache(project);
        }

        return project;
    }

    @Override
    public Project updateImpl(de.hska.wi.awp.datasource.model.Project project)
        throws SystemException {
        project = toUnwrappedModel(project);

        boolean isNew = project.isNew();

        Session session = null;

        try {
            session = openSession();

            if (project.isNew()) {
                session.save(project);

                project.setNew(false);
            } else {
                session.merge(project);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !ProjectModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        EntityCacheUtil.putResult(ProjectModelImpl.ENTITY_CACHE_ENABLED,
            ProjectImpl.class, project.getPrimaryKey(), project);

        clearUniqueFindersCache(project);
        cacheUniqueFindersCache(project);

        return project;
    }

    protected Project toUnwrappedModel(Project project) {
        if (project instanceof ProjectImpl) {
            return project;
        }

        ProjectImpl projectImpl = new ProjectImpl();

        projectImpl.setNew(project.isNew());
        projectImpl.setPrimaryKey(project.getPrimaryKey());

        projectImpl.setProjectId(project.getProjectId());
        projectImpl.setKey(project.getKey());
        projectImpl.setName(project.getName());

        return projectImpl;
    }

    /**
     * Returns the project with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the project
     * @return the project
     * @throws de.hska.wi.awp.datasource.NoSuchProjectException if a project with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Project findByPrimaryKey(Serializable primaryKey)
        throws NoSuchProjectException, SystemException {
        Project project = fetchByPrimaryKey(primaryKey);

        if (project == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchProjectException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return project;
    }

    /**
     * Returns the project with the primary key or throws a {@link de.hska.wi.awp.datasource.NoSuchProjectException} if it could not be found.
     *
     * @param projectId the primary key of the project
     * @return the project
     * @throws de.hska.wi.awp.datasource.NoSuchProjectException if a project with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Project findByPrimaryKey(String projectId)
        throws NoSuchProjectException, SystemException {
        return findByPrimaryKey((Serializable) projectId);
    }

    /**
     * Returns the project with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the project
     * @return the project, or <code>null</code> if a project with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Project fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Project project = (Project) EntityCacheUtil.getResult(ProjectModelImpl.ENTITY_CACHE_ENABLED,
                ProjectImpl.class, primaryKey);

        if (project == _nullProject) {
            return null;
        }

        if (project == null) {
            Session session = null;

            try {
                session = openSession();

                project = (Project) session.get(ProjectImpl.class, primaryKey);

                if (project != null) {
                    cacheResult(project);
                } else {
                    EntityCacheUtil.putResult(ProjectModelImpl.ENTITY_CACHE_ENABLED,
                        ProjectImpl.class, primaryKey, _nullProject);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(ProjectModelImpl.ENTITY_CACHE_ENABLED,
                    ProjectImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return project;
    }

    /**
     * Returns the project with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param projectId the primary key of the project
     * @return the project, or <code>null</code> if a project with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Project fetchByPrimaryKey(String projectId)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) projectId);
    }

    /**
     * Returns all the projects.
     *
     * @return the projects
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Project> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the projects.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.hska.wi.awp.datasource.model.impl.ProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of projects
     * @param end the upper bound of the range of projects (not inclusive)
     * @return the range of projects
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Project> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the projects.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.hska.wi.awp.datasource.model.impl.ProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of projects
     * @param end the upper bound of the range of projects (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of projects
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Project> findAll(int start, int end,
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

        List<Project> list = (List<Project>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_PROJECT);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_PROJECT;

                if (pagination) {
                    sql = sql.concat(ProjectModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Project>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Project>(list);
                } else {
                    list = (List<Project>) QueryUtil.list(q, getDialect(),
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
     * Removes all the projects from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Project project : findAll()) {
            remove(project);
        }
    }

    /**
     * Returns the number of projects.
     *
     * @return the number of projects
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

                Query q = session.createQuery(_SQL_COUNT_PROJECT);

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

    @Override
    protected Set<String> getBadColumnNames() {
        return _badColumnNames;
    }

    /**
     * Initializes the project persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.de.hska.wi.awp.datasource.model.Project")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Project>> listenersList = new ArrayList<ModelListener<Project>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Project>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(ProjectImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
