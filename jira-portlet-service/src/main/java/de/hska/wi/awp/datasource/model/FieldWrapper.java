package de.hska.wi.awp.datasource.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Field}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Field
 * @generated
 */
public class FieldWrapper implements Field, ModelWrapper<Field> {
    private Field _field;

    public FieldWrapper(Field field) {
        _field = field;
    }

    @Override
    public Class<?> getModelClass() {
        return Field.class;
    }

    @Override
    public String getModelClassName() {
        return Field.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("fieldId", getFieldId());
        attributes.put("createdDate", getCreatedDate());
        attributes.put("resolutionDate", getResolutionDate());
        attributes.put("summary", getSummary());
        attributes.put("updated", getUpdated());
        attributes.put("timespent", getTimespent());
        attributes.put("timeestimate", getTimeestimate());
        attributes.put("timeoriginalestimate", getTimeoriginalestimate());
        attributes.put("aggregatetimespent", getAggregatetimespent());
        attributes.put("aggregatetimeoriginalestimate",
            getAggregatetimeoriginalestimate());
        attributes.put("aggregatetimeestimate", getAggregatetimeestimate());
        attributes.put("description", getDescription());
        attributes.put("storypoints", getStorypoints());
        attributes.put("creatorId", getCreatorId());
        attributes.put("assigneeId", getAssigneeId());
        attributes.put("statusId", getStatusId());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long fieldId = (Long) attributes.get("fieldId");

        if (fieldId != null) {
            setFieldId(fieldId);
        }

        String createdDate = (String) attributes.get("createdDate");

        if (createdDate != null) {
            setCreatedDate(createdDate);
        }

        String resolutionDate = (String) attributes.get("resolutionDate");

        if (resolutionDate != null) {
            setResolutionDate(resolutionDate);
        }

        String summary = (String) attributes.get("summary");

        if (summary != null) {
            setSummary(summary);
        }

        String updated = (String) attributes.get("updated");

        if (updated != null) {
            setUpdated(updated);
        }

        String timespent = (String) attributes.get("timespent");

        if (timespent != null) {
            setTimespent(timespent);
        }

        String timeestimate = (String) attributes.get("timeestimate");

        if (timeestimate != null) {
            setTimeestimate(timeestimate);
        }

        String timeoriginalestimate = (String) attributes.get(
                "timeoriginalestimate");

        if (timeoriginalestimate != null) {
            setTimeoriginalestimate(timeoriginalestimate);
        }

        String aggregatetimespent = (String) attributes.get(
                "aggregatetimespent");

        if (aggregatetimespent != null) {
            setAggregatetimespent(aggregatetimespent);
        }

        String aggregatetimeoriginalestimate = (String) attributes.get(
                "aggregatetimeoriginalestimate");

        if (aggregatetimeoriginalestimate != null) {
            setAggregatetimeoriginalestimate(aggregatetimeoriginalestimate);
        }

        String aggregatetimeestimate = (String) attributes.get(
                "aggregatetimeestimate");

        if (aggregatetimeestimate != null) {
            setAggregatetimeestimate(aggregatetimeestimate);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        Long storypoints = (Long) attributes.get("storypoints");

        if (storypoints != null) {
            setStorypoints(storypoints);
        }

        String creatorId = (String) attributes.get("creatorId");

        if (creatorId != null) {
            setCreatorId(creatorId);
        }

        String assigneeId = (String) attributes.get("assigneeId");

        if (assigneeId != null) {
            setAssigneeId(assigneeId);
        }

        Long statusId = (Long) attributes.get("statusId");

        if (statusId != null) {
            setStatusId(statusId);
        }
    }

    /**
    * Returns the primary key of this field.
    *
    * @return the primary key of this field
    */
    @Override
    public long getPrimaryKey() {
        return _field.getPrimaryKey();
    }

    /**
    * Sets the primary key of this field.
    *
    * @param primaryKey the primary key of this field
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _field.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the field ID of this field.
    *
    * @return the field ID of this field
    */
    @Override
    public long getFieldId() {
        return _field.getFieldId();
    }

    /**
    * Sets the field ID of this field.
    *
    * @param fieldId the field ID of this field
    */
    @Override
    public void setFieldId(long fieldId) {
        _field.setFieldId(fieldId);
    }

    /**
    * Returns the created date of this field.
    *
    * @return the created date of this field
    */
    @Override
    public java.lang.String getCreatedDate() {
        return _field.getCreatedDate();
    }

    /**
    * Sets the created date of this field.
    *
    * @param createdDate the created date of this field
    */
    @Override
    public void setCreatedDate(java.lang.String createdDate) {
        _field.setCreatedDate(createdDate);
    }

    /**
    * Returns the resolution date of this field.
    *
    * @return the resolution date of this field
    */
    @Override
    public java.lang.String getResolutionDate() {
        return _field.getResolutionDate();
    }

    /**
    * Sets the resolution date of this field.
    *
    * @param resolutionDate the resolution date of this field
    */
    @Override
    public void setResolutionDate(java.lang.String resolutionDate) {
        _field.setResolutionDate(resolutionDate);
    }

    /**
    * Returns the summary of this field.
    *
    * @return the summary of this field
    */
    @Override
    public java.lang.String getSummary() {
        return _field.getSummary();
    }

    /**
    * Sets the summary of this field.
    *
    * @param summary the summary of this field
    */
    @Override
    public void setSummary(java.lang.String summary) {
        _field.setSummary(summary);
    }

    /**
    * Returns the updated of this field.
    *
    * @return the updated of this field
    */
    @Override
    public java.lang.String getUpdated() {
        return _field.getUpdated();
    }

    /**
    * Sets the updated of this field.
    *
    * @param updated the updated of this field
    */
    @Override
    public void setUpdated(java.lang.String updated) {
        _field.setUpdated(updated);
    }

    /**
    * Returns the timespent of this field.
    *
    * @return the timespent of this field
    */
    @Override
    public java.lang.String getTimespent() {
        return _field.getTimespent();
    }

    /**
    * Sets the timespent of this field.
    *
    * @param timespent the timespent of this field
    */
    @Override
    public void setTimespent(java.lang.String timespent) {
        _field.setTimespent(timespent);
    }

    /**
    * Returns the timeestimate of this field.
    *
    * @return the timeestimate of this field
    */
    @Override
    public java.lang.String getTimeestimate() {
        return _field.getTimeestimate();
    }

    /**
    * Sets the timeestimate of this field.
    *
    * @param timeestimate the timeestimate of this field
    */
    @Override
    public void setTimeestimate(java.lang.String timeestimate) {
        _field.setTimeestimate(timeestimate);
    }

    /**
    * Returns the timeoriginalestimate of this field.
    *
    * @return the timeoriginalestimate of this field
    */
    @Override
    public java.lang.String getTimeoriginalestimate() {
        return _field.getTimeoriginalestimate();
    }

    /**
    * Sets the timeoriginalestimate of this field.
    *
    * @param timeoriginalestimate the timeoriginalestimate of this field
    */
    @Override
    public void setTimeoriginalestimate(java.lang.String timeoriginalestimate) {
        _field.setTimeoriginalestimate(timeoriginalestimate);
    }

    /**
    * Returns the aggregatetimespent of this field.
    *
    * @return the aggregatetimespent of this field
    */
    @Override
    public java.lang.String getAggregatetimespent() {
        return _field.getAggregatetimespent();
    }

    /**
    * Sets the aggregatetimespent of this field.
    *
    * @param aggregatetimespent the aggregatetimespent of this field
    */
    @Override
    public void setAggregatetimespent(java.lang.String aggregatetimespent) {
        _field.setAggregatetimespent(aggregatetimespent);
    }

    /**
    * Returns the aggregatetimeoriginalestimate of this field.
    *
    * @return the aggregatetimeoriginalestimate of this field
    */
    @Override
    public java.lang.String getAggregatetimeoriginalestimate() {
        return _field.getAggregatetimeoriginalestimate();
    }

    /**
    * Sets the aggregatetimeoriginalestimate of this field.
    *
    * @param aggregatetimeoriginalestimate the aggregatetimeoriginalestimate of this field
    */
    @Override
    public void setAggregatetimeoriginalestimate(
        java.lang.String aggregatetimeoriginalestimate) {
        _field.setAggregatetimeoriginalestimate(aggregatetimeoriginalestimate);
    }

    /**
    * Returns the aggregatetimeestimate of this field.
    *
    * @return the aggregatetimeestimate of this field
    */
    @Override
    public java.lang.String getAggregatetimeestimate() {
        return _field.getAggregatetimeestimate();
    }

    /**
    * Sets the aggregatetimeestimate of this field.
    *
    * @param aggregatetimeestimate the aggregatetimeestimate of this field
    */
    @Override
    public void setAggregatetimeestimate(java.lang.String aggregatetimeestimate) {
        _field.setAggregatetimeestimate(aggregatetimeestimate);
    }

    /**
    * Returns the description of this field.
    *
    * @return the description of this field
    */
    @Override
    public java.lang.String getDescription() {
        return _field.getDescription();
    }

    /**
    * Sets the description of this field.
    *
    * @param description the description of this field
    */
    @Override
    public void setDescription(java.lang.String description) {
        _field.setDescription(description);
    }

    /**
    * Returns the storypoints of this field.
    *
    * @return the storypoints of this field
    */
    @Override
    public long getStorypoints() {
        return _field.getStorypoints();
    }

    /**
    * Sets the storypoints of this field.
    *
    * @param storypoints the storypoints of this field
    */
    @Override
    public void setStorypoints(long storypoints) {
        _field.setStorypoints(storypoints);
    }

    /**
    * Returns the creator ID of this field.
    *
    * @return the creator ID of this field
    */
    @Override
    public java.lang.String getCreatorId() {
        return _field.getCreatorId();
    }

    /**
    * Sets the creator ID of this field.
    *
    * @param creatorId the creator ID of this field
    */
    @Override
    public void setCreatorId(java.lang.String creatorId) {
        _field.setCreatorId(creatorId);
    }

    /**
    * Returns the assignee ID of this field.
    *
    * @return the assignee ID of this field
    */
    @Override
    public java.lang.String getAssigneeId() {
        return _field.getAssigneeId();
    }

    /**
    * Sets the assignee ID of this field.
    *
    * @param assigneeId the assignee ID of this field
    */
    @Override
    public void setAssigneeId(java.lang.String assigneeId) {
        _field.setAssigneeId(assigneeId);
    }

    /**
    * Returns the status ID of this field.
    *
    * @return the status ID of this field
    */
    @Override
    public long getStatusId() {
        return _field.getStatusId();
    }

    /**
    * Sets the status ID of this field.
    *
    * @param statusId the status ID of this field
    */
    @Override
    public void setStatusId(long statusId) {
        _field.setStatusId(statusId);
    }

    @Override
    public boolean isNew() {
        return _field.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _field.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _field.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _field.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _field.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _field.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _field.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _field.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _field.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _field.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _field.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new FieldWrapper((Field) _field.clone());
    }

    @Override
    public int compareTo(de.hska.wi.awp.datasource.model.Field field) {
        return _field.compareTo(field);
    }

    @Override
    public int hashCode() {
        return _field.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<de.hska.wi.awp.datasource.model.Field> toCacheModel() {
        return _field.toCacheModel();
    }

    @Override
    public de.hska.wi.awp.datasource.model.Field toEscapedModel() {
        return new FieldWrapper(_field.toEscapedModel());
    }

    @Override
    public de.hska.wi.awp.datasource.model.Field toUnescapedModel() {
        return new FieldWrapper(_field.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _field.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _field.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _field.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof FieldWrapper)) {
            return false;
        }

        FieldWrapper fieldWrapper = (FieldWrapper) obj;

        if (Validator.equals(_field, fieldWrapper._field)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Field getWrappedField() {
        return _field;
    }

    @Override
    public Field getWrappedModel() {
        return _field;
    }

    @Override
    public void resetOriginalValues() {
        _field.resetOriginalValues();
    }
}
