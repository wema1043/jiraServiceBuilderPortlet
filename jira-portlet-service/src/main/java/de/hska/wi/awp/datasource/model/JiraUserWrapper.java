package de.hska.wi.awp.datasource.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link JiraUser}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see JiraUser
 * @generated
 */
public class JiraUserWrapper implements JiraUser, ModelWrapper<JiraUser> {
    private JiraUser _jiraUser;

    public JiraUserWrapper(JiraUser jiraUser) {
        _jiraUser = jiraUser;
    }

    @Override
    public Class<?> getModelClass() {
        return JiraUser.class;
    }

    @Override
    public String getModelClassName() {
        return JiraUser.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("creatorId", getCreatorId());
        attributes.put("displayname", getDisplayname());
        attributes.put("groupId", getGroupId());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        String creatorId = (String) attributes.get("creatorId");

        if (creatorId != null) {
            setCreatorId(creatorId);
        }

        String displayname = (String) attributes.get("displayname");

        if (displayname != null) {
            setDisplayname(displayname);
        }

        String groupId = (String) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
        }
    }

    /**
    * Returns the primary key of this jira user.
    *
    * @return the primary key of this jira user
    */
    @Override
    public de.hska.wi.awp.datasource.service.persistence.JiraUserPK getPrimaryKey() {
        return _jiraUser.getPrimaryKey();
    }

    /**
    * Sets the primary key of this jira user.
    *
    * @param primaryKey the primary key of this jira user
    */
    @Override
    public void setPrimaryKey(
        de.hska.wi.awp.datasource.service.persistence.JiraUserPK primaryKey) {
        _jiraUser.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the creator ID of this jira user.
    *
    * @return the creator ID of this jira user
    */
    @Override
    public java.lang.String getCreatorId() {
        return _jiraUser.getCreatorId();
    }

    /**
    * Sets the creator ID of this jira user.
    *
    * @param creatorId the creator ID of this jira user
    */
    @Override
    public void setCreatorId(java.lang.String creatorId) {
        _jiraUser.setCreatorId(creatorId);
    }

    /**
    * Returns the displayname of this jira user.
    *
    * @return the displayname of this jira user
    */
    @Override
    public java.lang.String getDisplayname() {
        return _jiraUser.getDisplayname();
    }

    /**
    * Sets the displayname of this jira user.
    *
    * @param displayname the displayname of this jira user
    */
    @Override
    public void setDisplayname(java.lang.String displayname) {
        _jiraUser.setDisplayname(displayname);
    }

    /**
    * Returns the group ID of this jira user.
    *
    * @return the group ID of this jira user
    */
    @Override
    public java.lang.String getGroupId() {
        return _jiraUser.getGroupId();
    }

    /**
    * Sets the group ID of this jira user.
    *
    * @param groupId the group ID of this jira user
    */
    @Override
    public void setGroupId(java.lang.String groupId) {
        _jiraUser.setGroupId(groupId);
    }

    @Override
    public boolean isNew() {
        return _jiraUser.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _jiraUser.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _jiraUser.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _jiraUser.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _jiraUser.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _jiraUser.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _jiraUser.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _jiraUser.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _jiraUser.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _jiraUser.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _jiraUser.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new JiraUserWrapper((JiraUser) _jiraUser.clone());
    }

    @Override
    public int compareTo(de.hska.wi.awp.datasource.model.JiraUser jiraUser) {
        return _jiraUser.compareTo(jiraUser);
    }

    @Override
    public int hashCode() {
        return _jiraUser.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<de.hska.wi.awp.datasource.model.JiraUser> toCacheModel() {
        return _jiraUser.toCacheModel();
    }

    @Override
    public de.hska.wi.awp.datasource.model.JiraUser toEscapedModel() {
        return new JiraUserWrapper(_jiraUser.toEscapedModel());
    }

    @Override
    public de.hska.wi.awp.datasource.model.JiraUser toUnescapedModel() {
        return new JiraUserWrapper(_jiraUser.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _jiraUser.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _jiraUser.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _jiraUser.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof JiraUserWrapper)) {
            return false;
        }

        JiraUserWrapper jiraUserWrapper = (JiraUserWrapper) obj;

        if (Validator.equals(_jiraUser, jiraUserWrapper._jiraUser)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public JiraUser getWrappedJiraUser() {
        return _jiraUser;
    }

    @Override
    public JiraUser getWrappedModel() {
        return _jiraUser;
    }

    @Override
    public void resetOriginalValues() {
        _jiraUser.resetOriginalValues();
    }
}
