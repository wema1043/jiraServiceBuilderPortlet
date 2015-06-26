package de.hska.wi.awp.datasource.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link IssueType}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see IssueType
 * @generated
 */
public class IssueTypeWrapper implements IssueType, ModelWrapper<IssueType> {
    private IssueType _issueType;

    public IssueTypeWrapper(IssueType issueType) {
        _issueType = issueType;
    }

    @Override
    public Class<?> getModelClass() {
        return IssueType.class;
    }

    @Override
    public String getModelClassName() {
        return IssueType.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("issueTypeId", getIssueTypeId());
        attributes.put("typeName", getTypeName());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long issueTypeId = (Long) attributes.get("issueTypeId");

        if (issueTypeId != null) {
            setIssueTypeId(issueTypeId);
        }

        String typeName = (String) attributes.get("typeName");

        if (typeName != null) {
            setTypeName(typeName);
        }
    }

    /**
    * Returns the primary key of this issue type.
    *
    * @return the primary key of this issue type
    */
    @Override
    public long getPrimaryKey() {
        return _issueType.getPrimaryKey();
    }

    /**
    * Sets the primary key of this issue type.
    *
    * @param primaryKey the primary key of this issue type
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _issueType.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the issue type ID of this issue type.
    *
    * @return the issue type ID of this issue type
    */
    @Override
    public long getIssueTypeId() {
        return _issueType.getIssueTypeId();
    }

    /**
    * Sets the issue type ID of this issue type.
    *
    * @param issueTypeId the issue type ID of this issue type
    */
    @Override
    public void setIssueTypeId(long issueTypeId) {
        _issueType.setIssueTypeId(issueTypeId);
    }

    /**
    * Returns the type name of this issue type.
    *
    * @return the type name of this issue type
    */
    @Override
    public java.lang.String getTypeName() {
        return _issueType.getTypeName();
    }

    /**
    * Sets the type name of this issue type.
    *
    * @param typeName the type name of this issue type
    */
    @Override
    public void setTypeName(java.lang.String typeName) {
        _issueType.setTypeName(typeName);
    }

    @Override
    public boolean isNew() {
        return _issueType.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _issueType.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _issueType.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _issueType.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _issueType.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _issueType.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _issueType.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _issueType.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _issueType.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _issueType.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _issueType.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new IssueTypeWrapper((IssueType) _issueType.clone());
    }

    @Override
    public int compareTo(de.hska.wi.awp.datasource.model.IssueType issueType) {
        return _issueType.compareTo(issueType);
    }

    @Override
    public int hashCode() {
        return _issueType.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<de.hska.wi.awp.datasource.model.IssueType> toCacheModel() {
        return _issueType.toCacheModel();
    }

    @Override
    public de.hska.wi.awp.datasource.model.IssueType toEscapedModel() {
        return new IssueTypeWrapper(_issueType.toEscapedModel());
    }

    @Override
    public de.hska.wi.awp.datasource.model.IssueType toUnescapedModel() {
        return new IssueTypeWrapper(_issueType.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _issueType.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _issueType.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _issueType.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof IssueTypeWrapper)) {
            return false;
        }

        IssueTypeWrapper issueTypeWrapper = (IssueTypeWrapper) obj;

        if (Validator.equals(_issueType, issueTypeWrapper._issueType)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public IssueType getWrappedIssueType() {
        return _issueType;
    }

    @Override
    public IssueType getWrappedModel() {
        return _issueType;
    }

    @Override
    public void resetOriginalValues() {
        _issueType.resetOriginalValues();
    }
}
