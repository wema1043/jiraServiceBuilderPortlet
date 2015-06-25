package de.hska.wi.awp.datasource.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Project. This utility wraps
 * {@link de.hska.wi.awp.datasource.service.impl.ProjectLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ProjectLocalService
 * @see de.hska.wi.awp.datasource.service.base.ProjectLocalServiceBaseImpl
 * @see de.hska.wi.awp.datasource.service.impl.ProjectLocalServiceImpl
 * @generated
 */
public class ProjectLocalServiceUtil {
    private static ProjectLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link de.hska.wi.awp.datasource.service.impl.ProjectLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the project to the database. Also notifies the appropriate model listeners.
    *
    * @param project the project
    * @return the project that was added
    * @throws SystemException if a system exception occurred
    */
    public static de.hska.wi.awp.datasource.model.Project addProject(
        de.hska.wi.awp.datasource.model.Project project)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addProject(project);
    }

    /**
    * Creates a new project with the primary key. Does not add the project to the database.
    *
    * @param projectId the primary key for the new project
    * @return the new project
    */
    public static de.hska.wi.awp.datasource.model.Project createProject(
        java.lang.String projectId) {
        return getService().createProject(projectId);
    }

    /**
    * Deletes the project with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param projectId the primary key of the project
    * @return the project that was removed
    * @throws PortalException if a project with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.hska.wi.awp.datasource.model.Project deleteProject(
        java.lang.String projectId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteProject(projectId);
    }

    /**
    * Deletes the project from the database. Also notifies the appropriate model listeners.
    *
    * @param project the project
    * @return the project that was removed
    * @throws SystemException if a system exception occurred
    */
    public static de.hska.wi.awp.datasource.model.Project deleteProject(
        de.hska.wi.awp.datasource.model.Project project)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteProject(project);
    }

    public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return getService().dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.hska.wi.awp.datasource.model.impl.ProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.hska.wi.awp.datasource.model.impl.ProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery, projection);
    }

    public static de.hska.wi.awp.datasource.model.Project fetchProject(
        java.lang.String projectId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchProject(projectId);
    }

    /**
    * Returns the project with the primary key.
    *
    * @param projectId the primary key of the project
    * @return the project
    * @throws PortalException if a project with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.hska.wi.awp.datasource.model.Project getProject(
        java.lang.String projectId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getProject(projectId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
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
    public static java.util.List<de.hska.wi.awp.datasource.model.Project> getProjects(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getProjects(start, end);
    }

    /**
    * Returns the number of projects.
    *
    * @return the number of projects
    * @throws SystemException if a system exception occurred
    */
    public static int getProjectsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getProjectsCount();
    }

    /**
    * Updates the project in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param project the project
    * @return the project that was updated
    * @throws SystemException if a system exception occurred
    */
    public static de.hska.wi.awp.datasource.model.Project updateProject(
        de.hska.wi.awp.datasource.model.Project project)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateProject(project);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    public static java.lang.String getProjectIdForProjectName(
        java.lang.String projectName) {
        return getService().getProjectIdForProjectName(projectName);
    }

    public static java.lang.String getAllProjects() {
        return getService().getAllProjects();
    }

    public static void ParseJsonToProjects(java.lang.String response) {
        getService().ParseJsonToProjects(response);
    }

    public static void deleteAllProjects() {
        getService().deleteAllProjects();
    }

    public static java.util.Properties loadConfigFile() {
        return getService().loadConfigFile();
    }

    public static void clearService() {
        _service = null;
    }

    public static ProjectLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    ProjectLocalService.class.getName());

            if (invokableLocalService instanceof ProjectLocalService) {
                _service = (ProjectLocalService) invokableLocalService;
            } else {
                _service = new ProjectLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(ProjectLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(ProjectLocalService service) {
    }
}
