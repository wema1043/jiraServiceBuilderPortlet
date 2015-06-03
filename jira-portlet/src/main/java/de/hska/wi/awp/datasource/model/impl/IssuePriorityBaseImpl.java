package de.hska.wi.awp.datasource.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import de.hska.wi.awp.datasource.model.IssuePriority;
import de.hska.wi.awp.datasource.service.IssuePriorityLocalServiceUtil;

/**
 * The extended model base implementation for the IssuePriority service. Represents a row in the &quot;jira_IssuePriority&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link IssuePriorityImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see IssuePriorityImpl
 * @see de.hska.wi.awp.datasource.model.IssuePriority
 * @generated
 */
public abstract class IssuePriorityBaseImpl extends IssuePriorityModelImpl
    implements IssuePriority {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a issue priority model instance should use the {@link IssuePriority} interface instead.
     */
    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            IssuePriorityLocalServiceUtil.addIssuePriority(this);
        } else {
            IssuePriorityLocalServiceUtil.updateIssuePriority(this);
        }
    }
}
