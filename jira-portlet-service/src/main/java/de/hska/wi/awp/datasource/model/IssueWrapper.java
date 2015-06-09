package de.hska.wi.awp.datasource.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Issue}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Issue
 * @generated
 */
public class IssueWrapper implements Issue, ModelWrapper<Issue> {
    private Issue _issue;

    public IssueWrapper(Issue issue) {
        _issue = issue;
    }

    @Override
    public Class<?> getModelClass() {
        return Issue.class;
    }

    @Override
    public String getModelClassName() {
        return Issue.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("issueId", getIssueId());
        attributes.put("projectId", getProjectId());
        attributes.put("key", getKey());
        attributes.put("self", getSelf());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        String issueId = (String) attributes.get("issueId");

        if (issueId != null) {
            setIssueId(issueId);
        }

        String projectId = (String) attributes.get("projectId");

        if (projectId != null) {
            setProjectId(projectId);
        }

        String key = (String) attributes.get("key");

        if (key != null) {
            setKey(key);
        }

        String self = (String) attributes.get("self");

        if (self != null) {
            setSelf(self);
        }
    }

    /**
    * Returns the primary key of this issue.
    *
    * @return the primary key of this issue
    */
    @Override
    public java.lang.String getPrimaryKey() {
        return _issue.getPrimaryKey();
    }

    /**
    * Sets the primary key of this issue.
    *
    * @param primaryKey the primary key of this issue
    */
    @Override
    public void setPrimaryKey(java.lang.String primaryKey) {
        _issue.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the issue ID of this issue.
    *
    * @return the issue ID of this issue
    */
    @Override
    public java.lang.String getIssueId() {
        return _issue.getIssueId();
    }

    /**
    * Sets the issue ID of this issue.
    *
    * @param issueId the issue ID of this issue
    */
    @Override
    public void setIssueId(java.lang.String issueId) {
        _issue.setIssueId(issueId);
    }

    /**
    * Returns the project ID of this issue.
    *
    * @return the project ID of this issue
    */
    @Override
    public java.lang.String getProjectId() {
        return _issue.getProjectId();
    }

    /**
    * Sets the project ID of this issue.
    *
    * @param projectId the project ID of this issue
    */
    @Override
    public void setProjectId(java.lang.String projectId) {
        _issue.setProjectId(projectId);
    }

    /**
    * Returns the key of this issue.
    *
    * @return the key of this issue
    */
    @Override
    public java.lang.String getKey() {
        return _issue.getKey();
    }

    /**
    * Sets the key of this issue.
    *
    * @param key the key of this issue
    */
    @Override
    public void setKey(java.lang.String key) {
        _issue.setKey(key);
    }

    /**
    * Returns the self of this issue.
    *
    * @return the self of this issue
    */
    @Override
    public java.lang.String getSelf() {
        return _issue.getSelf();
    }

    /**
    * Sets the self of this issue.
    *
    * @param self the self of this issue
    */
    @Override
    public void setSelf(java.lang.String self) {
        _issue.setSelf(self);
    }

    @Override
    public boolean isNew() {
        return _issue.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _issue.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _issue.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _issue.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _issue.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _issue.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _issue.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _issue.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _issue.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _issue.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _issue.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new IssueWrapper((Issue) _issue.clone());
    }

    @Override
    public int compareTo(de.hska.wi.awp.datasource.model.Issue issue) {
        return _issue.compareTo(issue);
    }

    @Override
    public int hashCode() {
        return _issue.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<de.hska.wi.awp.datasource.model.Issue> toCacheModel() {
        return _issue.toCacheModel();
    }

    @Override
    public de.hska.wi.awp.datasource.model.Issue toEscapedModel() {
        return new IssueWrapper(_issue.toEscapedModel());
    }

    @Override
    public de.hska.wi.awp.datasource.model.Issue toUnescapedModel() {
        return new IssueWrapper(_issue.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _issue.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _issue.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _issue.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof IssueWrapper)) {
            return false;
        }

        IssueWrapper issueWrapper = (IssueWrapper) obj;

        if (Validator.equals(_issue, issueWrapper._issue)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Issue getWrappedIssue() {
        return _issue;
    }

    @Override
    public Issue getWrappedModel() {
        return _issue;
    }

    @Override
    public void resetOriginalValues() {
        _issue.resetOriginalValues();
    }
}
