package de.hska.wi.awp.datasource.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Issue. This utility wraps
 * {@link de.hska.wi.awp.datasource.service.impl.IssueLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see IssueLocalService
 * @see de.hska.wi.awp.datasource.service.base.IssueLocalServiceBaseImpl
 * @see de.hska.wi.awp.datasource.service.impl.IssueLocalServiceImpl
 * @generated
 */
public class IssueLocalServiceUtil {
    private static IssueLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link de.hska.wi.awp.datasource.service.impl.IssueLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the issue to the database. Also notifies the appropriate model listeners.
    *
    * @param issue the issue
    * @return the issue that was added
    * @throws SystemException if a system exception occurred
    */
    public static de.hska.wi.awp.datasource.model.Issue addIssue(
        de.hska.wi.awp.datasource.model.Issue issue)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addIssue(issue);
    }

    /**
    * Creates a new issue with the primary key. Does not add the issue to the database.
    *
    * @param issueId the primary key for the new issue
    * @return the new issue
    */
    public static de.hska.wi.awp.datasource.model.Issue createIssue(
        java.lang.String issueId) {
        return getService().createIssue(issueId);
    }

    /**
    * Deletes the issue with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param issueId the primary key of the issue
    * @return the issue that was removed
    * @throws PortalException if a issue with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.hska.wi.awp.datasource.model.Issue deleteIssue(
        java.lang.String issueId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteIssue(issueId);
    }

    /**
    * Deletes the issue from the database. Also notifies the appropriate model listeners.
    *
    * @param issue the issue
    * @return the issue that was removed
    * @throws SystemException if a system exception occurred
    */
    public static de.hska.wi.awp.datasource.model.Issue deleteIssue(
        de.hska.wi.awp.datasource.model.Issue issue)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteIssue(issue);
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.hska.wi.awp.datasource.model.impl.IssueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.hska.wi.awp.datasource.model.impl.IssueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

    public static de.hska.wi.awp.datasource.model.Issue fetchIssue(
        java.lang.String issueId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchIssue(issueId);
    }

    /**
    * Returns the issue with the primary key.
    *
    * @param issueId the primary key of the issue
    * @return the issue
    * @throws PortalException if a issue with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.hska.wi.awp.datasource.model.Issue getIssue(
        java.lang.String issueId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getIssue(issueId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the issues.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.hska.wi.awp.datasource.model.impl.IssueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of issues
    * @param end the upper bound of the range of issues (not inclusive)
    * @return the range of issues
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.hska.wi.awp.datasource.model.Issue> getIssues(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getIssues(start, end);
    }

    /**
    * Returns the number of issues.
    *
    * @return the number of issues
    * @throws SystemException if a system exception occurred
    */
    public static int getIssuesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getIssuesCount();
    }

    /**
    * Updates the issue in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param issue the issue
    * @return the issue that was updated
    * @throws SystemException if a system exception occurred
    */
    public static de.hska.wi.awp.datasource.model.Issue updateIssue(
        de.hska.wi.awp.datasource.model.Issue issue)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateIssue(issue);
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

    public static java.util.List<de.hska.wi.awp.datasource.model.Issue> getAllIssuesForProjectId(
        java.lang.String projectId) {
        return getService().getAllIssuesForProjectId(projectId);
    }

    public static java.lang.String getAllIssues() {
        return getService().getAllIssues();
    }

    public static void ParseJsonToIssue(java.lang.String response) {
        getService().ParseJsonToIssue(response);
    }

    public static void deleteAllIssues() {
        getService().deleteAllIssues();
    }

    public static void clearService() {
        _service = null;
    }

    public static IssueLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    IssueLocalService.class.getName());

            if (invokableLocalService instanceof IssueLocalService) {
                _service = (IssueLocalService) invokableLocalService;
            } else {
                _service = new IssueLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(IssueLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(IssueLocalService service) {
    }
}
