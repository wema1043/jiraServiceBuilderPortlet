package de.hska.wi.awp.datasource.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Status}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Status
 * @generated
 */
public class StatusWrapper implements Status, ModelWrapper<Status> {
    private Status _status;

    public StatusWrapper(Status status) {
        _status = status;
    }

    @Override
    public Class<?> getModelClass() {
        return Status.class;
    }

    @Override
    public String getModelClassName() {
        return Status.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("statusId", getStatusId());
        attributes.put("name", getName());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long statusId = (Long) attributes.get("statusId");

        if (statusId != null) {
            setStatusId(statusId);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }
    }

    /**
    * Returns the primary key of this status.
    *
    * @return the primary key of this status
    */
    @Override
    public long getPrimaryKey() {
        return _status.getPrimaryKey();
    }

    /**
    * Sets the primary key of this status.
    *
    * @param primaryKey the primary key of this status
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _status.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the status ID of this status.
    *
    * @return the status ID of this status
    */
    @Override
    public long getStatusId() {
        return _status.getStatusId();
    }

    /**
    * Sets the status ID of this status.
    *
    * @param statusId the status ID of this status
    */
    @Override
    public void setStatusId(long statusId) {
        _status.setStatusId(statusId);
    }

    /**
    * Returns the name of this status.
    *
    * @return the name of this status
    */
    @Override
    public java.lang.String getName() {
        return _status.getName();
    }

    /**
    * Sets the name of this status.
    *
    * @param name the name of this status
    */
    @Override
    public void setName(java.lang.String name) {
        _status.setName(name);
    }

    @Override
    public boolean isNew() {
        return _status.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _status.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _status.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _status.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _status.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _status.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _status.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _status.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _status.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _status.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _status.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new StatusWrapper((Status) _status.clone());
    }

    @Override
    public int compareTo(de.hska.wi.awp.datasource.model.Status status) {
        return _status.compareTo(status);
    }

    @Override
    public int hashCode() {
        return _status.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<de.hska.wi.awp.datasource.model.Status> toCacheModel() {
        return _status.toCacheModel();
    }

    @Override
    public de.hska.wi.awp.datasource.model.Status toEscapedModel() {
        return new StatusWrapper(_status.toEscapedModel());
    }

    @Override
    public de.hska.wi.awp.datasource.model.Status toUnescapedModel() {
        return new StatusWrapper(_status.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _status.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _status.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _status.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof StatusWrapper)) {
            return false;
        }

        StatusWrapper statusWrapper = (StatusWrapper) obj;

        if (Validator.equals(_status, statusWrapper._status)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Status getWrappedStatus() {
        return _status;
    }

    @Override
    public Status getWrappedModel() {
        return _status;
    }

    @Override
    public void resetOriginalValues() {
        _status.resetOriginalValues();
    }
}
