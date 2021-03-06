package de.hska.wi.awp.datasource.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import de.hska.wi.awp.datasource.model.IssueType;
import de.hska.wi.awp.datasource.service.IssueTypeLocalServiceUtil;

/**
 * The extended model base implementation for the IssueType service. Represents a row in the &quot;jira_IssueType&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link IssueTypeImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see IssueTypeImpl
 * @see de.hska.wi.awp.datasource.model.IssueType
 * @generated
 */
public abstract class IssueTypeBaseImpl extends IssueTypeModelImpl
    implements IssueType {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a issue type model instance should use the {@link IssueType} interface instead.
     */
    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            IssueTypeLocalServiceUtil.addIssueType(this);
        } else {
            IssueTypeLocalServiceUtil.updateIssueType(this);
        }
    }
}
