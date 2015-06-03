package de.hska.wi.awp.datasource.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link IssuePriority}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see IssuePriority
 * @generated
 */
public class IssuePriorityWrapper implements IssuePriority,
    ModelWrapper<IssuePriority> {
    private IssuePriority _issuePriority;

    public IssuePriorityWrapper(IssuePriority issuePriority) {
        _issuePriority = issuePriority;
    }

    @Override
    public Class<?> getModelClass() {
        return IssuePriority.class;
    }

    @Override
    public String getModelClassName() {
        return IssuePriority.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("priorityId", getPriorityId());
        attributes.put("priorityName", getPriorityName());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long priorityId = (Long) attributes.get("priorityId");

        if (priorityId != null) {
            setPriorityId(priorityId);
        }

        String priorityName = (String) attributes.get("priorityName");

        if (priorityName != null) {
            setPriorityName(priorityName);
        }
    }

    /**
    * Returns the primary key of this issue priority.
    *
    * @return the primary key of this issue priority
    */
    @Override
    public long getPrimaryKey() {
        return _issuePriority.getPrimaryKey();
    }

    /**
    * Sets the primary key of this issue priority.
    *
    * @param primaryKey the primary key of this issue priority
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _issuePriority.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the priority ID of this issue priority.
    *
    * @return the priority ID of this issue priority
    */
    @Override
    public long getPriorityId() {
        return _issuePriority.getPriorityId();
    }

    /**
    * Sets the priority ID of this issue priority.
    *
    * @param priorityId the priority ID of this issue priority
    */
    @Override
    public void setPriorityId(long priorityId) {
        _issuePriority.setPriorityId(priorityId);
    }

    /**
    * Returns the priority name of this issue priority.
    *
    * @return the priority name of this issue priority
    */
    @Override
    public java.lang.String getPriorityName() {
        return _issuePriority.getPriorityName();
    }

    /**
    * Sets the priority name of this issue priority.
    *
    * @param priorityName the priority name of this issue priority
    */
    @Override
    public void setPriorityName(java.lang.String priorityName) {
        _issuePriority.setPriorityName(priorityName);
    }

    @Override
    public boolean isNew() {
        return _issuePriority.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _issuePriority.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _issuePriority.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _issuePriority.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _issuePriority.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _issuePriority.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _issuePriority.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _issuePriority.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _issuePriority.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _issuePriority.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _issuePriority.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new IssuePriorityWrapper((IssuePriority) _issuePriority.clone());
    }

    @Override
    public int compareTo(
        de.hska.wi.awp.datasource.model.IssuePriority issuePriority) {
        return _issuePriority.compareTo(issuePriority);
    }

    @Override
    public int hashCode() {
        return _issuePriority.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<de.hska.wi.awp.datasource.model.IssuePriority> toCacheModel() {
        return _issuePriority.toCacheModel();
    }

    @Override
    public de.hska.wi.awp.datasource.model.IssuePriority toEscapedModel() {
        return new IssuePriorityWrapper(_issuePriority.toEscapedModel());
    }

    @Override
    public de.hska.wi.awp.datasource.model.IssuePriority toUnescapedModel() {
        return new IssuePriorityWrapper(_issuePriority.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _issuePriority.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _issuePriority.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _issuePriority.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof IssuePriorityWrapper)) {
            return false;
        }

        IssuePriorityWrapper issuePriorityWrapper = (IssuePriorityWrapper) obj;

        if (Validator.equals(_issuePriority, issuePriorityWrapper._issuePriority)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public IssuePriority getWrappedIssuePriority() {
        return _issuePriority;
    }

    @Override
    public IssuePriority getWrappedModel() {
        return _issuePriority;
    }

    @Override
    public void resetOriginalValues() {
        _issuePriority.resetOriginalValues();
    }
}
