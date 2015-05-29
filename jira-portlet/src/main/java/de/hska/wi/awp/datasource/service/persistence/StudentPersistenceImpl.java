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
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import de.hska.wi.awp.datasource.NoSuchStudentException;
import de.hska.wi.awp.datasource.model.Student;
import de.hska.wi.awp.datasource.model.impl.StudentImpl;
import de.hska.wi.awp.datasource.model.impl.StudentModelImpl;
import de.hska.wi.awp.datasource.service.persistence.StudentPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the student service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StudentPersistence
 * @see StudentUtil
 * @generated
 */
public class StudentPersistenceImpl extends BasePersistenceImpl<Student>
    implements StudentPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link StudentUtil} to access the student persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = StudentImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
            StudentModelImpl.FINDER_CACHE_ENABLED, StudentImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
            StudentModelImpl.FINDER_CACHE_ENABLED, StudentImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
            StudentModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GENDER = new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
            StudentModelImpl.FINDER_CACHE_ENABLED, StudentImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGender",
            new String[] {
                Integer.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GENDER =
        new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
            StudentModelImpl.FINDER_CACHE_ENABLED, StudentImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGender",
            new String[] { Integer.class.getName() },
            StudentModelImpl.STUDENTGENDER_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_GENDER = new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
            StudentModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGender",
            new String[] { Integer.class.getName() });
    private static final String _FINDER_COLUMN_GENDER_STUDENTGENDER_2 = "student.studentGender = ?";
    private static final String _SQL_SELECT_STUDENT = "SELECT student FROM Student student";
    private static final String _SQL_SELECT_STUDENT_WHERE = "SELECT student FROM Student student WHERE ";
    private static final String _SQL_COUNT_STUDENT = "SELECT COUNT(student) FROM Student student";
    private static final String _SQL_COUNT_STUDENT_WHERE = "SELECT COUNT(student) FROM Student student WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "student.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Student exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Student exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(StudentPersistenceImpl.class);
    private static Student _nullStudent = new StudentImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Student> toCacheModel() {
                return _nullStudentCacheModel;
            }
        };

    private static CacheModel<Student> _nullStudentCacheModel = new CacheModel<Student>() {
            @Override
            public Student toEntityModel() {
                return _nullStudent;
            }
        };

    public StudentPersistenceImpl() {
        setModelClass(Student.class);
    }

    /**
     * Returns all the students where studentGender = &#63;.
     *
     * @param studentGender the student gender
     * @return the matching students
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Student> findByGender(int studentGender)
        throws SystemException {
        return findByGender(studentGender, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the students where studentGender = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.hska.wi.awp.datasource.model.impl.StudentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param studentGender the student gender
     * @param start the lower bound of the range of students
     * @param end the upper bound of the range of students (not inclusive)
     * @return the range of matching students
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Student> findByGender(int studentGender, int start, int end)
        throws SystemException {
        return findByGender(studentGender, start, end, null);
    }

    /**
     * Returns an ordered range of all the students where studentGender = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.hska.wi.awp.datasource.model.impl.StudentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param studentGender the student gender
     * @param start the lower bound of the range of students
     * @param end the upper bound of the range of students (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching students
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Student> findByGender(int studentGender, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GENDER;
            finderArgs = new Object[] { studentGender };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GENDER;
            finderArgs = new Object[] {
                    studentGender,
                    
                    start, end, orderByComparator
                };
        }

        List<Student> list = (List<Student>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Student student : list) {
                if ((studentGender != student.getStudentGender())) {
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

            query.append(_SQL_SELECT_STUDENT_WHERE);

            query.append(_FINDER_COLUMN_GENDER_STUDENTGENDER_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(StudentModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(studentGender);

                if (!pagination) {
                    list = (List<Student>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Student>(list);
                } else {
                    list = (List<Student>) QueryUtil.list(q, getDialect(),
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
     * Returns the first student in the ordered set where studentGender = &#63;.
     *
     * @param studentGender the student gender
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching student
     * @throws de.hska.wi.awp.datasource.NoSuchStudentException if a matching student could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Student findByGender_First(int studentGender,
        OrderByComparator orderByComparator)
        throws NoSuchStudentException, SystemException {
        Student student = fetchByGender_First(studentGender, orderByComparator);

        if (student != null) {
            return student;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("studentGender=");
        msg.append(studentGender);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchStudentException(msg.toString());
    }

    /**
     * Returns the first student in the ordered set where studentGender = &#63;.
     *
     * @param studentGender the student gender
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching student, or <code>null</code> if a matching student could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Student fetchByGender_First(int studentGender,
        OrderByComparator orderByComparator) throws SystemException {
        List<Student> list = findByGender(studentGender, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last student in the ordered set where studentGender = &#63;.
     *
     * @param studentGender the student gender
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching student
     * @throws de.hska.wi.awp.datasource.NoSuchStudentException if a matching student could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Student findByGender_Last(int studentGender,
        OrderByComparator orderByComparator)
        throws NoSuchStudentException, SystemException {
        Student student = fetchByGender_Last(studentGender, orderByComparator);

        if (student != null) {
            return student;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("studentGender=");
        msg.append(studentGender);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchStudentException(msg.toString());
    }

    /**
     * Returns the last student in the ordered set where studentGender = &#63;.
     *
     * @param studentGender the student gender
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching student, or <code>null</code> if a matching student could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Student fetchByGender_Last(int studentGender,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByGender(studentGender);

        if (count == 0) {
            return null;
        }

        List<Student> list = findByGender(studentGender, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the students before and after the current student in the ordered set where studentGender = &#63;.
     *
     * @param studentId the primary key of the current student
     * @param studentGender the student gender
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next student
     * @throws de.hska.wi.awp.datasource.NoSuchStudentException if a student with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Student[] findByGender_PrevAndNext(long studentId,
        int studentGender, OrderByComparator orderByComparator)
        throws NoSuchStudentException, SystemException {
        Student student = findByPrimaryKey(studentId);

        Session session = null;

        try {
            session = openSession();

            Student[] array = new StudentImpl[3];

            array[0] = getByGender_PrevAndNext(session, student, studentGender,
                    orderByComparator, true);

            array[1] = student;

            array[2] = getByGender_PrevAndNext(session, student, studentGender,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Student getByGender_PrevAndNext(Session session, Student student,
        int studentGender, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_STUDENT_WHERE);

        query.append(_FINDER_COLUMN_GENDER_STUDENTGENDER_2);

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
            query.append(StudentModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(studentGender);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(student);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Student> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the students where studentGender = &#63; from the database.
     *
     * @param studentGender the student gender
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByGender(int studentGender) throws SystemException {
        for (Student student : findByGender(studentGender, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(student);
        }
    }

    /**
     * Returns the number of students where studentGender = &#63;.
     *
     * @param studentGender the student gender
     * @return the number of matching students
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByGender(int studentGender) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_GENDER;

        Object[] finderArgs = new Object[] { studentGender };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_STUDENT_WHERE);

            query.append(_FINDER_COLUMN_GENDER_STUDENTGENDER_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(studentGender);

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
     * Caches the student in the entity cache if it is enabled.
     *
     * @param student the student
     */
    @Override
    public void cacheResult(Student student) {
        EntityCacheUtil.putResult(StudentModelImpl.ENTITY_CACHE_ENABLED,
            StudentImpl.class, student.getPrimaryKey(), student);

        student.resetOriginalValues();
    }

    /**
     * Caches the students in the entity cache if it is enabled.
     *
     * @param students the students
     */
    @Override
    public void cacheResult(List<Student> students) {
        for (Student student : students) {
            if (EntityCacheUtil.getResult(
                        StudentModelImpl.ENTITY_CACHE_ENABLED,
                        StudentImpl.class, student.getPrimaryKey()) == null) {
                cacheResult(student);
            } else {
                student.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all students.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(StudentImpl.class.getName());
        }

        EntityCacheUtil.clearCache(StudentImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the student.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Student student) {
        EntityCacheUtil.removeResult(StudentModelImpl.ENTITY_CACHE_ENABLED,
            StudentImpl.class, student.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Student> students) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Student student : students) {
            EntityCacheUtil.removeResult(StudentModelImpl.ENTITY_CACHE_ENABLED,
                StudentImpl.class, student.getPrimaryKey());
        }
    }

    /**
     * Creates a new student with the primary key. Does not add the student to the database.
     *
     * @param studentId the primary key for the new student
     * @return the new student
     */
    @Override
    public Student create(long studentId) {
        Student student = new StudentImpl();

        student.setNew(true);
        student.setPrimaryKey(studentId);

        return student;
    }

    /**
     * Removes the student with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param studentId the primary key of the student
     * @return the student that was removed
     * @throws de.hska.wi.awp.datasource.NoSuchStudentException if a student with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Student remove(long studentId)
        throws NoSuchStudentException, SystemException {
        return remove((Serializable) studentId);
    }

    /**
     * Removes the student with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the student
     * @return the student that was removed
     * @throws de.hska.wi.awp.datasource.NoSuchStudentException if a student with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Student remove(Serializable primaryKey)
        throws NoSuchStudentException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Student student = (Student) session.get(StudentImpl.class,
                    primaryKey);

            if (student == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchStudentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(student);
        } catch (NoSuchStudentException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Student removeImpl(Student student) throws SystemException {
        student = toUnwrappedModel(student);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(student)) {
                student = (Student) session.get(StudentImpl.class,
                        student.getPrimaryKeyObj());
            }

            if (student != null) {
                session.delete(student);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (student != null) {
            clearCache(student);
        }

        return student;
    }

    @Override
    public Student updateImpl(de.hska.wi.awp.datasource.model.Student student)
        throws SystemException {
        student = toUnwrappedModel(student);

        boolean isNew = student.isNew();

        StudentModelImpl studentModelImpl = (StudentModelImpl) student;

        Session session = null;

        try {
            session = openSession();

            if (student.isNew()) {
                session.save(student);

                student.setNew(false);
            } else {
                session.merge(student);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !StudentModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((studentModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GENDER.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        studentModelImpl.getOriginalStudentGender()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GENDER, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GENDER,
                    args);

                args = new Object[] { studentModelImpl.getStudentGender() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GENDER, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GENDER,
                    args);
            }
        }

        EntityCacheUtil.putResult(StudentModelImpl.ENTITY_CACHE_ENABLED,
            StudentImpl.class, student.getPrimaryKey(), student);

        return student;
    }

    protected Student toUnwrappedModel(Student student) {
        if (student instanceof StudentImpl) {
            return student;
        }

        StudentImpl studentImpl = new StudentImpl();

        studentImpl.setNew(student.isNew());
        studentImpl.setPrimaryKey(student.getPrimaryKey());

        studentImpl.setStudentId(student.getStudentId());
        studentImpl.setFirstName(student.getFirstName());
        studentImpl.setLastName(student.getLastName());
        studentImpl.setStudentAge(student.getStudentAge());
        studentImpl.setStudentGender(student.getStudentGender());
        studentImpl.setStudentAddress(student.getStudentAddress());

        return studentImpl;
    }

    /**
     * Returns the student with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the student
     * @return the student
     * @throws de.hska.wi.awp.datasource.NoSuchStudentException if a student with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Student findByPrimaryKey(Serializable primaryKey)
        throws NoSuchStudentException, SystemException {
        Student student = fetchByPrimaryKey(primaryKey);

        if (student == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchStudentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return student;
    }

    /**
     * Returns the student with the primary key or throws a {@link de.hska.wi.awp.datasource.NoSuchStudentException} if it could not be found.
     *
     * @param studentId the primary key of the student
     * @return the student
     * @throws de.hska.wi.awp.datasource.NoSuchStudentException if a student with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Student findByPrimaryKey(long studentId)
        throws NoSuchStudentException, SystemException {
        return findByPrimaryKey((Serializable) studentId);
    }

    /**
     * Returns the student with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the student
     * @return the student, or <code>null</code> if a student with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Student fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Student student = (Student) EntityCacheUtil.getResult(StudentModelImpl.ENTITY_CACHE_ENABLED,
                StudentImpl.class, primaryKey);

        if (student == _nullStudent) {
            return null;
        }

        if (student == null) {
            Session session = null;

            try {
                session = openSession();

                student = (Student) session.get(StudentImpl.class, primaryKey);

                if (student != null) {
                    cacheResult(student);
                } else {
                    EntityCacheUtil.putResult(StudentModelImpl.ENTITY_CACHE_ENABLED,
                        StudentImpl.class, primaryKey, _nullStudent);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(StudentModelImpl.ENTITY_CACHE_ENABLED,
                    StudentImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return student;
    }

    /**
     * Returns the student with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param studentId the primary key of the student
     * @return the student, or <code>null</code> if a student with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Student fetchByPrimaryKey(long studentId) throws SystemException {
        return fetchByPrimaryKey((Serializable) studentId);
    }

    /**
     * Returns all the students.
     *
     * @return the students
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Student> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the students.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.hska.wi.awp.datasource.model.impl.StudentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of students
     * @param end the upper bound of the range of students (not inclusive)
     * @return the range of students
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Student> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the students.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.hska.wi.awp.datasource.model.impl.StudentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of students
     * @param end the upper bound of the range of students (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of students
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Student> findAll(int start, int end,
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

        List<Student> list = (List<Student>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_STUDENT);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_STUDENT;

                if (pagination) {
                    sql = sql.concat(StudentModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Student>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Student>(list);
                } else {
                    list = (List<Student>) QueryUtil.list(q, getDialect(),
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
     * Removes all the students from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Student student : findAll()) {
            remove(student);
        }
    }

    /**
     * Returns the number of students.
     *
     * @return the number of students
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

                Query q = session.createQuery(_SQL_COUNT_STUDENT);

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
     * Initializes the student persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.de.hska.wi.awp.datasource.model.Student")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Student>> listenersList = new ArrayList<ModelListener<Student>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Student>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(StudentImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
