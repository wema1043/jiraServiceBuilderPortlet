package de.hska.wi.awp.datasource.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.persistence.UserPersistence;

import de.hska.wi.awp.datasource.model.Student;
import de.hska.wi.awp.datasource.service.StudentService;
import de.hska.wi.awp.datasource.service.persistence.FieldPersistence;
import de.hska.wi.awp.datasource.service.persistence.IssuePersistence;
import de.hska.wi.awp.datasource.service.persistence.JiraUserPersistence;
import de.hska.wi.awp.datasource.service.persistence.StatusPersistence;
import de.hska.wi.awp.datasource.service.persistence.StudentPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the student remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link de.hska.wi.awp.datasource.service.impl.StudentServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see de.hska.wi.awp.datasource.service.impl.StudentServiceImpl
 * @see de.hska.wi.awp.datasource.service.StudentServiceUtil
 * @generated
 */
public abstract class StudentServiceBaseImpl extends BaseServiceImpl
    implements StudentService, IdentifiableBean {
    @BeanReference(type = de.hska.wi.awp.datasource.service.FieldLocalService.class)
    protected de.hska.wi.awp.datasource.service.FieldLocalService fieldLocalService;
    @BeanReference(type = de.hska.wi.awp.datasource.service.FieldService.class)
    protected de.hska.wi.awp.datasource.service.FieldService fieldService;
    @BeanReference(type = FieldPersistence.class)
    protected FieldPersistence fieldPersistence;
    @BeanReference(type = de.hska.wi.awp.datasource.service.IssueLocalService.class)
    protected de.hska.wi.awp.datasource.service.IssueLocalService issueLocalService;
    @BeanReference(type = de.hska.wi.awp.datasource.service.IssueService.class)
    protected de.hska.wi.awp.datasource.service.IssueService issueService;
    @BeanReference(type = IssuePersistence.class)
    protected IssuePersistence issuePersistence;
    @BeanReference(type = de.hska.wi.awp.datasource.service.JiraUserLocalService.class)
    protected de.hska.wi.awp.datasource.service.JiraUserLocalService jiraUserLocalService;
    @BeanReference(type = de.hska.wi.awp.datasource.service.JiraUserService.class)
    protected de.hska.wi.awp.datasource.service.JiraUserService jiraUserService;
    @BeanReference(type = JiraUserPersistence.class)
    protected JiraUserPersistence jiraUserPersistence;
    @BeanReference(type = de.hska.wi.awp.datasource.service.StatusLocalService.class)
    protected de.hska.wi.awp.datasource.service.StatusLocalService statusLocalService;
    @BeanReference(type = de.hska.wi.awp.datasource.service.StatusService.class)
    protected de.hska.wi.awp.datasource.service.StatusService statusService;
    @BeanReference(type = StatusPersistence.class)
    protected StatusPersistence statusPersistence;
    @BeanReference(type = de.hska.wi.awp.datasource.service.StudentLocalService.class)
    protected de.hska.wi.awp.datasource.service.StudentLocalService studentLocalService;
    @BeanReference(type = de.hska.wi.awp.datasource.service.StudentService.class)
    protected de.hska.wi.awp.datasource.service.StudentService studentService;
    @BeanReference(type = StudentPersistence.class)
    protected StudentPersistence studentPersistence;
    @BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
    protected com.liferay.counter.service.CounterLocalService counterLocalService;
    @BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
    protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
    @BeanReference(type = com.liferay.portal.service.UserLocalService.class)
    protected com.liferay.portal.service.UserLocalService userLocalService;
    @BeanReference(type = com.liferay.portal.service.UserService.class)
    protected com.liferay.portal.service.UserService userService;
    @BeanReference(type = UserPersistence.class)
    protected UserPersistence userPersistence;
    private String _beanIdentifier;
    private ClassLoader _classLoader;
    private StudentServiceClpInvoker _clpInvoker = new StudentServiceClpInvoker();

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link de.hska.wi.awp.datasource.service.StudentServiceUtil} to access the student remote service.
     */

    /**
     * Returns the field local service.
     *
     * @return the field local service
     */
    public de.hska.wi.awp.datasource.service.FieldLocalService getFieldLocalService() {
        return fieldLocalService;
    }

    /**
     * Sets the field local service.
     *
     * @param fieldLocalService the field local service
     */
    public void setFieldLocalService(
        de.hska.wi.awp.datasource.service.FieldLocalService fieldLocalService) {
        this.fieldLocalService = fieldLocalService;
    }

    /**
     * Returns the field remote service.
     *
     * @return the field remote service
     */
    public de.hska.wi.awp.datasource.service.FieldService getFieldService() {
        return fieldService;
    }

    /**
     * Sets the field remote service.
     *
     * @param fieldService the field remote service
     */
    public void setFieldService(
        de.hska.wi.awp.datasource.service.FieldService fieldService) {
        this.fieldService = fieldService;
    }

    /**
     * Returns the field persistence.
     *
     * @return the field persistence
     */
    public FieldPersistence getFieldPersistence() {
        return fieldPersistence;
    }

    /**
     * Sets the field persistence.
     *
     * @param fieldPersistence the field persistence
     */
    public void setFieldPersistence(FieldPersistence fieldPersistence) {
        this.fieldPersistence = fieldPersistence;
    }

    /**
     * Returns the issue local service.
     *
     * @return the issue local service
     */
    public de.hska.wi.awp.datasource.service.IssueLocalService getIssueLocalService() {
        return issueLocalService;
    }

    /**
     * Sets the issue local service.
     *
     * @param issueLocalService the issue local service
     */
    public void setIssueLocalService(
        de.hska.wi.awp.datasource.service.IssueLocalService issueLocalService) {
        this.issueLocalService = issueLocalService;
    }

    /**
     * Returns the issue remote service.
     *
     * @return the issue remote service
     */
    public de.hska.wi.awp.datasource.service.IssueService getIssueService() {
        return issueService;
    }

    /**
     * Sets the issue remote service.
     *
     * @param issueService the issue remote service
     */
    public void setIssueService(
        de.hska.wi.awp.datasource.service.IssueService issueService) {
        this.issueService = issueService;
    }

    /**
     * Returns the issue persistence.
     *
     * @return the issue persistence
     */
    public IssuePersistence getIssuePersistence() {
        return issuePersistence;
    }

    /**
     * Sets the issue persistence.
     *
     * @param issuePersistence the issue persistence
     */
    public void setIssuePersistence(IssuePersistence issuePersistence) {
        this.issuePersistence = issuePersistence;
    }

    /**
     * Returns the jira user local service.
     *
     * @return the jira user local service
     */
    public de.hska.wi.awp.datasource.service.JiraUserLocalService getJiraUserLocalService() {
        return jiraUserLocalService;
    }

    /**
     * Sets the jira user local service.
     *
     * @param jiraUserLocalService the jira user local service
     */
    public void setJiraUserLocalService(
        de.hska.wi.awp.datasource.service.JiraUserLocalService jiraUserLocalService) {
        this.jiraUserLocalService = jiraUserLocalService;
    }

    /**
     * Returns the jira user remote service.
     *
     * @return the jira user remote service
     */
    public de.hska.wi.awp.datasource.service.JiraUserService getJiraUserService() {
        return jiraUserService;
    }

    /**
     * Sets the jira user remote service.
     *
     * @param jiraUserService the jira user remote service
     */
    public void setJiraUserService(
        de.hska.wi.awp.datasource.service.JiraUserService jiraUserService) {
        this.jiraUserService = jiraUserService;
    }

    /**
     * Returns the jira user persistence.
     *
     * @return the jira user persistence
     */
    public JiraUserPersistence getJiraUserPersistence() {
        return jiraUserPersistence;
    }

    /**
     * Sets the jira user persistence.
     *
     * @param jiraUserPersistence the jira user persistence
     */
    public void setJiraUserPersistence(JiraUserPersistence jiraUserPersistence) {
        this.jiraUserPersistence = jiraUserPersistence;
    }

    /**
     * Returns the status local service.
     *
     * @return the status local service
     */
    public de.hska.wi.awp.datasource.service.StatusLocalService getStatusLocalService() {
        return statusLocalService;
    }

    /**
     * Sets the status local service.
     *
     * @param statusLocalService the status local service
     */
    public void setStatusLocalService(
        de.hska.wi.awp.datasource.service.StatusLocalService statusLocalService) {
        this.statusLocalService = statusLocalService;
    }

    /**
     * Returns the status remote service.
     *
     * @return the status remote service
     */
    public de.hska.wi.awp.datasource.service.StatusService getStatusService() {
        return statusService;
    }

    /**
     * Sets the status remote service.
     *
     * @param statusService the status remote service
     */
    public void setStatusService(
        de.hska.wi.awp.datasource.service.StatusService statusService) {
        this.statusService = statusService;
    }

    /**
     * Returns the status persistence.
     *
     * @return the status persistence
     */
    public StatusPersistence getStatusPersistence() {
        return statusPersistence;
    }

    /**
     * Sets the status persistence.
     *
     * @param statusPersistence the status persistence
     */
    public void setStatusPersistence(StatusPersistence statusPersistence) {
        this.statusPersistence = statusPersistence;
    }

    /**
     * Returns the student local service.
     *
     * @return the student local service
     */
    public de.hska.wi.awp.datasource.service.StudentLocalService getStudentLocalService() {
        return studentLocalService;
    }

    /**
     * Sets the student local service.
     *
     * @param studentLocalService the student local service
     */
    public void setStudentLocalService(
        de.hska.wi.awp.datasource.service.StudentLocalService studentLocalService) {
        this.studentLocalService = studentLocalService;
    }

    /**
     * Returns the student remote service.
     *
     * @return the student remote service
     */
    public de.hska.wi.awp.datasource.service.StudentService getStudentService() {
        return studentService;
    }

    /**
     * Sets the student remote service.
     *
     * @param studentService the student remote service
     */
    public void setStudentService(
        de.hska.wi.awp.datasource.service.StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * Returns the student persistence.
     *
     * @return the student persistence
     */
    public StudentPersistence getStudentPersistence() {
        return studentPersistence;
    }

    /**
     * Sets the student persistence.
     *
     * @param studentPersistence the student persistence
     */
    public void setStudentPersistence(StudentPersistence studentPersistence) {
        this.studentPersistence = studentPersistence;
    }

    /**
     * Returns the counter local service.
     *
     * @return the counter local service
     */
    public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
        return counterLocalService;
    }

    /**
     * Sets the counter local service.
     *
     * @param counterLocalService the counter local service
     */
    public void setCounterLocalService(
        com.liferay.counter.service.CounterLocalService counterLocalService) {
        this.counterLocalService = counterLocalService;
    }

    /**
     * Returns the resource local service.
     *
     * @return the resource local service
     */
    public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
        return resourceLocalService;
    }

    /**
     * Sets the resource local service.
     *
     * @param resourceLocalService the resource local service
     */
    public void setResourceLocalService(
        com.liferay.portal.service.ResourceLocalService resourceLocalService) {
        this.resourceLocalService = resourceLocalService;
    }

    /**
     * Returns the user local service.
     *
     * @return the user local service
     */
    public com.liferay.portal.service.UserLocalService getUserLocalService() {
        return userLocalService;
    }

    /**
     * Sets the user local service.
     *
     * @param userLocalService the user local service
     */
    public void setUserLocalService(
        com.liferay.portal.service.UserLocalService userLocalService) {
        this.userLocalService = userLocalService;
    }

    /**
     * Returns the user remote service.
     *
     * @return the user remote service
     */
    public com.liferay.portal.service.UserService getUserService() {
        return userService;
    }

    /**
     * Sets the user remote service.
     *
     * @param userService the user remote service
     */
    public void setUserService(
        com.liferay.portal.service.UserService userService) {
        this.userService = userService;
    }

    /**
     * Returns the user persistence.
     *
     * @return the user persistence
     */
    public UserPersistence getUserPersistence() {
        return userPersistence;
    }

    /**
     * Sets the user persistence.
     *
     * @param userPersistence the user persistence
     */
    public void setUserPersistence(UserPersistence userPersistence) {
        this.userPersistence = userPersistence;
    }

    public void afterPropertiesSet() {
        Class<?> clazz = getClass();

        _classLoader = clazz.getClassLoader();
    }

    public void destroy() {
    }

    /**
     * Returns the Spring bean ID for this bean.
     *
     * @return the Spring bean ID for this bean
     */
    @Override
    public String getBeanIdentifier() {
        return _beanIdentifier;
    }

    /**
     * Sets the Spring bean ID for this bean.
     *
     * @param beanIdentifier the Spring bean ID for this bean
     */
    @Override
    public void setBeanIdentifier(String beanIdentifier) {
        _beanIdentifier = beanIdentifier;
    }

    @Override
    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        Thread currentThread = Thread.currentThread();

        ClassLoader contextClassLoader = currentThread.getContextClassLoader();

        if (contextClassLoader != _classLoader) {
            currentThread.setContextClassLoader(_classLoader);
        }

        try {
            return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
        } finally {
            if (contextClassLoader != _classLoader) {
                currentThread.setContextClassLoader(contextClassLoader);
            }
        }
    }

    protected Class<?> getModelClass() {
        return Student.class;
    }

    protected String getModelClassName() {
        return Student.class.getName();
    }

    /**
     * Performs an SQL query.
     *
     * @param sql the sql query
     */
    protected void runSQL(String sql) throws SystemException {
        try {
            DataSource dataSource = studentPersistence.getDataSource();

            SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
                    sql, new int[0]);

            sqlUpdate.update();
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
