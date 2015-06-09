package de.hska.wi.awp.datasource.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Field service. Represents a row in the &quot;jira_Field&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link de.hska.wi.awp.datasource.model.impl.FieldModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link de.hska.wi.awp.datasource.model.impl.FieldImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Field
 * @see de.hska.wi.awp.datasource.model.impl.FieldImpl
 * @see de.hska.wi.awp.datasource.model.impl.FieldModelImpl
 * @generated
 */
public interface FieldModel extends BaseModel<Field> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a field model instance should use the {@link Field} interface instead.
     */

    /**
     * Returns the primary key of this field.
     *
     * @return the primary key of this field
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this field.
     *
     * @param primaryKey the primary key of this field
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the field ID of this field.
     *
     * @return the field ID of this field
     */
    public long getFieldId();

    /**
     * Sets the field ID of this field.
     *
     * @param fieldId the field ID of this field
     */
    public void setFieldId(long fieldId);

    /**
     * Returns the issue ID of this field.
     *
     * @return the issue ID of this field
     */
    @AutoEscape
    public String getIssueId();

    /**
     * Sets the issue ID of this field.
     *
     * @param issueId the issue ID of this field
     */
    public void setIssueId(String issueId);

    /**
     * Returns the created date of this field.
     *
     * @return the created date of this field
     */
    public Date getCreatedDate();

    /**
     * Sets the created date of this field.
     *
     * @param createdDate the created date of this field
     */
    public void setCreatedDate(Date createdDate);

    /**
     * Returns the resolution date of this field.
     *
     * @return the resolution date of this field
     */
    public Date getResolutionDate();

    /**
     * Sets the resolution date of this field.
     *
     * @param resolutionDate the resolution date of this field
     */
    public void setResolutionDate(Date resolutionDate);

    /**
     * Returns the summary of this field.
     *
     * @return the summary of this field
     */
    @AutoEscape
    public String getSummary();

    /**
     * Sets the summary of this field.
     *
     * @param summary the summary of this field
     */
    public void setSummary(String summary);

    /**
     * Returns the updated of this field.
     *
     * @return the updated of this field
     */
    public Date getUpdated();

    /**
     * Sets the updated of this field.
     *
     * @param updated the updated of this field
     */
    public void setUpdated(Date updated);

    /**
     * Returns the timespent of this field.
     *
     * @return the timespent of this field
     */
    @AutoEscape
    public String getTimespent();

    /**
     * Sets the timespent of this field.
     *
     * @param timespent the timespent of this field
     */
    public void setTimespent(String timespent);

    /**
     * Returns the timeestimate of this field.
     *
     * @return the timeestimate of this field
     */
    @AutoEscape
    public String getTimeestimate();

    /**
     * Sets the timeestimate of this field.
     *
     * @param timeestimate the timeestimate of this field
     */
    public void setTimeestimate(String timeestimate);

    /**
     * Returns the timeoriginalestimate of this field.
     *
     * @return the timeoriginalestimate of this field
     */
    @AutoEscape
    public String getTimeoriginalestimate();

    /**
     * Sets the timeoriginalestimate of this field.
     *
     * @param timeoriginalestimate the timeoriginalestimate of this field
     */
    public void setTimeoriginalestimate(String timeoriginalestimate);

    /**
     * Returns the aggregatetimespent of this field.
     *
     * @return the aggregatetimespent of this field
     */
    @AutoEscape
    public String getAggregatetimespent();

    /**
     * Sets the aggregatetimespent of this field.
     *
     * @param aggregatetimespent the aggregatetimespent of this field
     */
    public void setAggregatetimespent(String aggregatetimespent);

    /**
     * Returns the aggregatetimeoriginalestimate of this field.
     *
     * @return the aggregatetimeoriginalestimate of this field
     */
    @AutoEscape
    public String getAggregatetimeoriginalestimate();

    /**
     * Sets the aggregatetimeoriginalestimate of this field.
     *
     * @param aggregatetimeoriginalestimate the aggregatetimeoriginalestimate of this field
     */
    public void setAggregatetimeoriginalestimate(
        String aggregatetimeoriginalestimate);

    /**
     * Returns the aggregatetimeestimate of this field.
     *
     * @return the aggregatetimeestimate of this field
     */
    @AutoEscape
    public String getAggregatetimeestimate();

    /**
     * Sets the aggregatetimeestimate of this field.
     *
     * @param aggregatetimeestimate the aggregatetimeestimate of this field
     */
    public void setAggregatetimeestimate(String aggregatetimeestimate);

    /**
     * Returns the description of this field.
     *
     * @return the description of this field
     */
    @AutoEscape
    public String getDescription();

    /**
     * Sets the description of this field.
     *
     * @param description the description of this field
     */
    public void setDescription(String description);

    /**
     * Returns the storypoints of this field.
     *
     * @return the storypoints of this field
     */
    public long getStorypoints();

    /**
     * Sets the storypoints of this field.
     *
     * @param storypoints the storypoints of this field
     */
    public void setStorypoints(long storypoints);

    /**
     * Returns the creator ID of this field.
     *
     * @return the creator ID of this field
     */
    @AutoEscape
    public String getCreatorId();

    /**
     * Sets the creator ID of this field.
     *
     * @param creatorId the creator ID of this field
     */
    public void setCreatorId(String creatorId);

    /**
     * Returns the assignee ID of this field.
     *
     * @return the assignee ID of this field
     */
    @AutoEscape
    public String getAssigneeId();

    /**
     * Sets the assignee ID of this field.
     *
     * @param assigneeId the assignee ID of this field
     */
    public void setAssigneeId(String assigneeId);

    /**
     * Returns the status ID of this field.
     *
     * @return the status ID of this field
     */
    public long getStatusId();

    /**
     * Sets the status ID of this field.
     *
     * @param statusId the status ID of this field
     */
    public void setStatusId(long statusId);

    @Override
    public boolean isNew();

    @Override
    public void setNew(boolean n);

    @Override
    public boolean isCachedModel();

    @Override
    public void setCachedModel(boolean cachedModel);

    @Override
    public boolean isEscapedModel();

    @Override
    public Serializable getPrimaryKeyObj();

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj);

    @Override
    public ExpandoBridge getExpandoBridge();

    @Override
    public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

    @Override
    public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext);

    @Override
    public Object clone();

    @Override
    public int compareTo(de.hska.wi.awp.datasource.model.Field field);

    @Override
    public int hashCode();

    @Override
    public CacheModel<de.hska.wi.awp.datasource.model.Field> toCacheModel();

    @Override
    public de.hska.wi.awp.datasource.model.Field toEscapedModel();

    @Override
    public de.hska.wi.awp.datasource.model.Field toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}
