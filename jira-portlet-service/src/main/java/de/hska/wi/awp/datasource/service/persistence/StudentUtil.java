package de.hska.wi.awp.datasource.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import de.hska.wi.awp.datasource.model.Student;

import java.util.List;

/**
 * The persistence utility for the student service. This utility wraps {@link StudentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StudentPersistence
 * @see StudentPersistenceImpl
 * @generated
 */
public class StudentUtil {
    private static StudentPersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(Student student) {
        getPersistence().clearCache(student);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<Student> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Student> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Student> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static Student update(Student student) throws SystemException {
        return getPersistence().update(student);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static Student update(Student student, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(student, serviceContext);
    }

    /**
    * Returns all the students where studentGender = &#63;.
    *
    * @param studentGender the student gender
    * @return the matching students
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.hska.wi.awp.datasource.model.Student> findByGender(
        int studentGender)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByGender(studentGender);
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
    public static java.util.List<de.hska.wi.awp.datasource.model.Student> findByGender(
        int studentGender, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByGender(studentGender, start, end);
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
    public static java.util.List<de.hska.wi.awp.datasource.model.Student> findByGender(
        int studentGender, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByGender(studentGender, start, end, orderByComparator);
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
    public static de.hska.wi.awp.datasource.model.Student findByGender_First(
        int studentGender,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.hska.wi.awp.datasource.NoSuchStudentException {
        return getPersistence()
                   .findByGender_First(studentGender, orderByComparator);
    }

    /**
    * Returns the first student in the ordered set where studentGender = &#63;.
    *
    * @param studentGender the student gender
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching student, or <code>null</code> if a matching student could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.hska.wi.awp.datasource.model.Student fetchByGender_First(
        int studentGender,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByGender_First(studentGender, orderByComparator);
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
    public static de.hska.wi.awp.datasource.model.Student findByGender_Last(
        int studentGender,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.hska.wi.awp.datasource.NoSuchStudentException {
        return getPersistence()
                   .findByGender_Last(studentGender, orderByComparator);
    }

    /**
    * Returns the last student in the ordered set where studentGender = &#63;.
    *
    * @param studentGender the student gender
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching student, or <code>null</code> if a matching student could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.hska.wi.awp.datasource.model.Student fetchByGender_Last(
        int studentGender,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByGender_Last(studentGender, orderByComparator);
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
    public static de.hska.wi.awp.datasource.model.Student[] findByGender_PrevAndNext(
        long studentId, int studentGender,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.hska.wi.awp.datasource.NoSuchStudentException {
        return getPersistence()
                   .findByGender_PrevAndNext(studentId, studentGender,
            orderByComparator);
    }

    /**
    * Removes all the students where studentGender = &#63; from the database.
    *
    * @param studentGender the student gender
    * @throws SystemException if a system exception occurred
    */
    public static void removeByGender(int studentGender)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByGender(studentGender);
    }

    /**
    * Returns the number of students where studentGender = &#63;.
    *
    * @param studentGender the student gender
    * @return the number of matching students
    * @throws SystemException if a system exception occurred
    */
    public static int countByGender(int studentGender)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByGender(studentGender);
    }

    /**
    * Caches the student in the entity cache if it is enabled.
    *
    * @param student the student
    */
    public static void cacheResult(
        de.hska.wi.awp.datasource.model.Student student) {
        getPersistence().cacheResult(student);
    }

    /**
    * Caches the students in the entity cache if it is enabled.
    *
    * @param students the students
    */
    public static void cacheResult(
        java.util.List<de.hska.wi.awp.datasource.model.Student> students) {
        getPersistence().cacheResult(students);
    }

    /**
    * Creates a new student with the primary key. Does not add the student to the database.
    *
    * @param studentId the primary key for the new student
    * @return the new student
    */
    public static de.hska.wi.awp.datasource.model.Student create(long studentId) {
        return getPersistence().create(studentId);
    }

    /**
    * Removes the student with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param studentId the primary key of the student
    * @return the student that was removed
    * @throws de.hska.wi.awp.datasource.NoSuchStudentException if a student with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.hska.wi.awp.datasource.model.Student remove(long studentId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.hska.wi.awp.datasource.NoSuchStudentException {
        return getPersistence().remove(studentId);
    }

    public static de.hska.wi.awp.datasource.model.Student updateImpl(
        de.hska.wi.awp.datasource.model.Student student)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(student);
    }

    /**
    * Returns the student with the primary key or throws a {@link de.hska.wi.awp.datasource.NoSuchStudentException} if it could not be found.
    *
    * @param studentId the primary key of the student
    * @return the student
    * @throws de.hska.wi.awp.datasource.NoSuchStudentException if a student with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.hska.wi.awp.datasource.model.Student findByPrimaryKey(
        long studentId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.hska.wi.awp.datasource.NoSuchStudentException {
        return getPersistence().findByPrimaryKey(studentId);
    }

    /**
    * Returns the student with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param studentId the primary key of the student
    * @return the student, or <code>null</code> if a student with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.hska.wi.awp.datasource.model.Student fetchByPrimaryKey(
        long studentId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(studentId);
    }

    /**
    * Returns all the students.
    *
    * @return the students
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.hska.wi.awp.datasource.model.Student> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<de.hska.wi.awp.datasource.model.Student> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
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
    public static java.util.List<de.hska.wi.awp.datasource.model.Student> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the students from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of students.
    *
    * @return the number of students
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static StudentPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (StudentPersistence) PortletBeanLocatorUtil.locate(de.hska.wi.awp.datasource.service.ClpSerializer.getServletContextName(),
                    StudentPersistence.class.getName());

            ReferenceRegistry.registerReference(StudentUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(StudentPersistence persistence) {
    }
}
