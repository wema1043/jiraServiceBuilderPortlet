package de.hska.wi.awp.datasource.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import de.hska.wi.awp.datasource.service.ClpSerializer;
import de.hska.wi.awp.datasource.service.FieldLocalServiceUtil;
import de.hska.wi.awp.datasource.service.FieldServiceUtil;
import de.hska.wi.awp.datasource.service.IssueLocalServiceUtil;
import de.hska.wi.awp.datasource.service.IssuePriorityLocalServiceUtil;
import de.hska.wi.awp.datasource.service.IssuePriorityServiceUtil;
import de.hska.wi.awp.datasource.service.IssueServiceUtil;
import de.hska.wi.awp.datasource.service.IssueTypeLocalServiceUtil;
import de.hska.wi.awp.datasource.service.IssueTypeServiceUtil;
import de.hska.wi.awp.datasource.service.JiraUserLocalServiceUtil;
import de.hska.wi.awp.datasource.service.JiraUserServiceUtil;
import de.hska.wi.awp.datasource.service.ProjectLocalServiceUtil;
import de.hska.wi.awp.datasource.service.ProjectServiceUtil;
import de.hska.wi.awp.datasource.service.StatusLocalServiceUtil;
import de.hska.wi.awp.datasource.service.StatusServiceUtil;


public class ClpMessageListener extends BaseMessageListener {
    public static String getServletContextName() {
        return ClpSerializer.getServletContextName();
    }

    @Override
    protected void doReceive(Message message) throws Exception {
        String command = message.getString("command");
        String servletContextName = message.getString("servletContextName");

        if (command.equals("undeploy") &&
                servletContextName.equals(getServletContextName())) {
            FieldLocalServiceUtil.clearService();

            FieldServiceUtil.clearService();
            IssueLocalServiceUtil.clearService();

            IssueServiceUtil.clearService();
            IssuePriorityLocalServiceUtil.clearService();

            IssuePriorityServiceUtil.clearService();
            IssueTypeLocalServiceUtil.clearService();

            IssueTypeServiceUtil.clearService();
            JiraUserLocalServiceUtil.clearService();

            JiraUserServiceUtil.clearService();
            ProjectLocalServiceUtil.clearService();

            ProjectServiceUtil.clearService();
            StatusLocalServiceUtil.clearService();

            StatusServiceUtil.clearService();
        }
    }
}
