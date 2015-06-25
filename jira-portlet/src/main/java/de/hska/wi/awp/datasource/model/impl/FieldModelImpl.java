package de.hska.wi.awp.datasource.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import de.hska.wi.awp.datasource.model.Field;
import de.hska.wi.awp.datasource.model.FieldModel;
import de.hska.wi.awp.datasource.model.FieldSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Field service. Represents a row in the &quot;jira_Field&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link de.hska.wi.awp.datasource.model.FieldModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link FieldImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FieldImpl
 * @see de.hska.wi.awp.datasource.model.Field
 * @see de.hska.wi.awp.datasource.model.FieldModel
 * @generated
 */
@JSON(strict = true)
public class FieldModelImpl extends BaseModelImpl<Field> implements FieldModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a field model instance should use the {@link de.hska.wi.awp.datasource.model.Field} interface instead.
     */
    public static final String TABLE_NAME = "jira_Field";
    public static final Object[][] TABLE_COLUMNS = {
            { "fieldId", Types.BIGINT },
            { "issueId", Types.VARCHAR },
            { "createdDate", Types.TIMESTAMP },
            { "resolutionDate", Types.TIMESTAMP },
            { "summary", Types.VARCHAR },
            { "updated", Types.TIMESTAMP },
            { "timespent", Types.BIGINT },
            { "timeestimate", Types.BIGINT },
            { "timeoriginalestimate", Types.BIGINT },
            { "aggregatetimespent", Types.BIGINT },
            { "aggregatetimeoriginalestimate", Types.BIGINT },
            { "aggregatetimeestimate", Types.BIGINT },
            { "description", Types.VARCHAR },
            { "storypoints", Types.BIGINT },
            { "creatorId", Types.VARCHAR },
            { "assigneeId", Types.VARCHAR },
            { "statusId", Types.BIGINT }
        };
    public static final String TABLE_SQL_CREATE = "create table jira_Field (fieldId LONG not null primary key,issueId VARCHAR(75) null,createdDate DATE null,resolutionDate DATE null,summary VARCHAR(1000) null,updated DATE null,timespent LONG,timeestimate LONG,timeoriginalestimate LONG,aggregatetimespent LONG,aggregatetimeoriginalestimate LONG,aggregatetimeestimate LONG,description VARCHAR(1000) null,storypoints LONG,creatorId VARCHAR(75) null,assigneeId VARCHAR(75) null,statusId LONG)";
    public static final String TABLE_SQL_DROP = "drop table jira_Field";
    public static final String ORDER_BY_JPQL = " ORDER BY field.issueId ASC";
    public static final String ORDER_BY_SQL = " ORDER BY jira_Field.issueId ASC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.de.hska.wi.awp.datasource.model.Field"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.de.hska.wi.awp.datasource.model.Field"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.de.hska.wi.awp.datasource.model.Field"),
            true);
    public static long ASSIGNEEID_COLUMN_BITMASK = 1L;
    public static long ISSUEID_COLUMN_BITMASK = 2L;
    public static long STATUSID_COLUMN_BITMASK = 4L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.de.hska.wi.awp.datasource.model.Field"));
    private static ClassLoader _classLoader = Field.class.getClassLoader();
    private static Class<?>[] _escapedModelInterfaces = new Class[] { Field.class };
    private long _fieldId;
    private String _issueId;
    private String _originalIssueId;
    private Date _createdDate;
    private Date _resolutionDate;
    private String _summary;
    private Date _updated;
    private long _timespent;
    private long _timeestimate;
    private long _timeoriginalestimate;
    private long _aggregatetimespent;
    private long _aggregatetimeoriginalestimate;
    private long _aggregatetimeestimate;
    private String _description;
    private long _storypoints;
    private String _creatorId;
    private String _assigneeId;
    private String _originalAssigneeId;
    private long _statusId;
    private long _originalStatusId;
    private boolean _setOriginalStatusId;
    private long _columnBitmask;
    private Field _escapedModel;

    public FieldModelImpl() {
    }

    /**
     * Converts the soap model instance into a normal model instance.
     *
     * @param soapModel the soap model instance to convert
     * @return the normal model instance
     */
    public static Field toModel(FieldSoap soapModel) {
        if (soapModel == null) {
            return null;
        }

        Field model = new FieldImpl();

        model.setFieldId(soapModel.getFieldId());
        model.setIssueId(soapModel.getIssueId());
        model.setCreatedDate(soapModel.getCreatedDate());
        model.setResolutionDate(soapModel.getResolutionDate());
        model.setSummary(soapModel.getSummary());
        model.setUpdated(soapModel.getUpdated());
        model.setTimespent(soapModel.getTimespent());
        model.setTimeestimate(soapModel.getTimeestimate());
        model.setTimeoriginalestimate(soapModel.getTimeoriginalestimate());
        model.setAggregatetimespent(soapModel.getAggregatetimespent());
        model.setAggregatetimeoriginalestimate(soapModel.getAggregatetimeoriginalestimate());
        model.setAggregatetimeestimate(soapModel.getAggregatetimeestimate());
        model.setDescription(soapModel.getDescription());
        model.setStorypoints(soapModel.getStorypoints());
        model.setCreatorId(soapModel.getCreatorId());
        model.setAssigneeId(soapModel.getAssigneeId());
        model.setStatusId(soapModel.getStatusId());

        return model;
    }

    /**
     * Converts the soap model instances into normal model instances.
     *
     * @param soapModels the soap model instances to convert
     * @return the normal model instances
     */
    public static List<Field> toModels(FieldSoap[] soapModels) {
        if (soapModels == null) {
            return null;
        }

        List<Field> models = new ArrayList<Field>(soapModels.length);

        for (FieldSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    @Override
    public long getPrimaryKey() {
        return _fieldId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setFieldId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _fieldId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
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
        attributes.put("issueId", getIssueId());
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

        String issueId = (String) attributes.get("issueId");

        if (issueId != null) {
            setIssueId(issueId);
        }

        Date createdDate = (Date) attributes.get("createdDate");

        if (createdDate != null) {
            setCreatedDate(createdDate);
        }

        Date resolutionDate = (Date) attributes.get("resolutionDate");

        if (resolutionDate != null) {
            setResolutionDate(resolutionDate);
        }

        String summary = (String) attributes.get("summary");

        if (summary != null) {
            setSummary(summary);
        }

        Date updated = (Date) attributes.get("updated");

        if (updated != null) {
            setUpdated(updated);
        }

        Long timespent = (Long) attributes.get("timespent");

        if (timespent != null) {
            setTimespent(timespent);
        }

        Long timeestimate = (Long) attributes.get("timeestimate");

        if (timeestimate != null) {
            setTimeestimate(timeestimate);
        }

        Long timeoriginalestimate = (Long) attributes.get(
                "timeoriginalestimate");

        if (timeoriginalestimate != null) {
            setTimeoriginalestimate(timeoriginalestimate);
        }

        Long aggregatetimespent = (Long) attributes.get("aggregatetimespent");

        if (aggregatetimespent != null) {
            setAggregatetimespent(aggregatetimespent);
        }

        Long aggregatetimeoriginalestimate = (Long) attributes.get(
                "aggregatetimeoriginalestimate");

        if (aggregatetimeoriginalestimate != null) {
            setAggregatetimeoriginalestimate(aggregatetimeoriginalestimate);
        }

        Long aggregatetimeestimate = (Long) attributes.get(
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

    @JSON
    @Override
    public long getFieldId() {
        return _fieldId;
    }

    @Override
    public void setFieldId(long fieldId) {
        _fieldId = fieldId;
    }

    @JSON
    @Override
    public String getIssueId() {
        if (_issueId == null) {
            return StringPool.BLANK;
        } else {
            return _issueId;
        }
    }

    @Override
    public void setIssueId(String issueId) {
        _columnBitmask = -1L;

        if (_originalIssueId == null) {
            _originalIssueId = _issueId;
        }

        _issueId = issueId;
    }

    public String getOriginalIssueId() {
        return GetterUtil.getString(_originalIssueId);
    }

    @JSON
    @Override
    public Date getCreatedDate() {
        return _createdDate;
    }

    @Override
    public void setCreatedDate(Date createdDate) {
        _createdDate = createdDate;
    }

    @JSON
    @Override
    public Date getResolutionDate() {
        return _resolutionDate;
    }

    @Override
    public void setResolutionDate(Date resolutionDate) {
        _resolutionDate = resolutionDate;
    }

    @JSON
    @Override
    public String getSummary() {
        if (_summary == null) {
            return StringPool.BLANK;
        } else {
            return _summary;
        }
    }

    @Override
    public void setSummary(String summary) {
        _summary = summary;
    }

    @JSON
    @Override
    public Date getUpdated() {
        return _updated;
    }

    @Override
    public void setUpdated(Date updated) {
        _updated = updated;
    }

    @JSON
    @Override
    public long getTimespent() {
        return _timespent;
    }

    @Override
    public void setTimespent(long timespent) {
        _timespent = timespent;
    }

    @JSON
    @Override
    public long getTimeestimate() {
        return _timeestimate;
    }

    @Override
    public void setTimeestimate(long timeestimate) {
        _timeestimate = timeestimate;
    }

    @JSON
    @Override
    public long getTimeoriginalestimate() {
        return _timeoriginalestimate;
    }

    @Override
    public void setTimeoriginalestimate(long timeoriginalestimate) {
        _timeoriginalestimate = timeoriginalestimate;
    }

    @JSON
    @Override
    public long getAggregatetimespent() {
        return _aggregatetimespent;
    }

    @Override
    public void setAggregatetimespent(long aggregatetimespent) {
        _aggregatetimespent = aggregatetimespent;
    }

    @JSON
    @Override
    public long getAggregatetimeoriginalestimate() {
        return _aggregatetimeoriginalestimate;
    }

    @Override
    public void setAggregatetimeoriginalestimate(
        long aggregatetimeoriginalestimate) {
        _aggregatetimeoriginalestimate = aggregatetimeoriginalestimate;
    }

    @JSON
    @Override
    public long getAggregatetimeestimate() {
        return _aggregatetimeestimate;
    }

    @Override
    public void setAggregatetimeestimate(long aggregatetimeestimate) {
        _aggregatetimeestimate = aggregatetimeestimate;
    }

    @JSON
    @Override
    public String getDescription() {
        if (_description == null) {
            return StringPool.BLANK;
        } else {
            return _description;
        }
    }

    @Override
    public void setDescription(String description) {
        _description = description;
    }

    @JSON
    @Override
    public long getStorypoints() {
        return _storypoints;
    }

    @Override
    public void setStorypoints(long storypoints) {
        _storypoints = storypoints;
    }

    @JSON
    @Override
    public String getCreatorId() {
        if (_creatorId == null) {
            return StringPool.BLANK;
        } else {
            return _creatorId;
        }
    }

    @Override
    public void setCreatorId(String creatorId) {
        _creatorId = creatorId;
    }

    @JSON
    @Override
    public String getAssigneeId() {
        if (_assigneeId == null) {
            return StringPool.BLANK;
        } else {
            return _assigneeId;
        }
    }

    @Override
    public void setAssigneeId(String assigneeId) {
        _columnBitmask |= ASSIGNEEID_COLUMN_BITMASK;

        if (_originalAssigneeId == null) {
            _originalAssigneeId = _assigneeId;
        }

        _assigneeId = assigneeId;
    }

    public String getOriginalAssigneeId() {
        return GetterUtil.getString(_originalAssigneeId);
    }

    @JSON
    @Override
    public long getStatusId() {
        return _statusId;
    }

    @Override
    public void setStatusId(long statusId) {
        _columnBitmask |= STATUSID_COLUMN_BITMASK;

        if (!_setOriginalStatusId) {
            _setOriginalStatusId = true;

            _originalStatusId = _statusId;
        }

        _statusId = statusId;
    }

    public long getOriginalStatusId() {
        return _originalStatusId;
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
            Field.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public Field toEscapedModel() {
        if (_escapedModel == null) {
            _escapedModel = (Field) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        FieldImpl fieldImpl = new FieldImpl();

        fieldImpl.setFieldId(getFieldId());
        fieldImpl.setIssueId(getIssueId());
        fieldImpl.setCreatedDate(getCreatedDate());
        fieldImpl.setResolutionDate(getResolutionDate());
        fieldImpl.setSummary(getSummary());
        fieldImpl.setUpdated(getUpdated());
        fieldImpl.setTimespent(getTimespent());
        fieldImpl.setTimeestimate(getTimeestimate());
        fieldImpl.setTimeoriginalestimate(getTimeoriginalestimate());
        fieldImpl.setAggregatetimespent(getAggregatetimespent());
        fieldImpl.setAggregatetimeoriginalestimate(getAggregatetimeoriginalestimate());
        fieldImpl.setAggregatetimeestimate(getAggregatetimeestimate());
        fieldImpl.setDescription(getDescription());
        fieldImpl.setStorypoints(getStorypoints());
        fieldImpl.setCreatorId(getCreatorId());
        fieldImpl.setAssigneeId(getAssigneeId());
        fieldImpl.setStatusId(getStatusId());

        fieldImpl.resetOriginalValues();

        return fieldImpl;
    }

    @Override
    public int compareTo(Field field) {
        int value = 0;

        value = getIssueId().compareTo(field.getIssueId());

        if (value != 0) {
            return value;
        }

        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Field)) {
            return false;
        }

        Field field = (Field) obj;

        long primaryKey = field.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public void resetOriginalValues() {
        FieldModelImpl fieldModelImpl = this;

        fieldModelImpl._originalIssueId = fieldModelImpl._issueId;

        fieldModelImpl._originalAssigneeId = fieldModelImpl._assigneeId;

        fieldModelImpl._originalStatusId = fieldModelImpl._statusId;

        fieldModelImpl._setOriginalStatusId = false;

        fieldModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<Field> toCacheModel() {
        FieldCacheModel fieldCacheModel = new FieldCacheModel();

        fieldCacheModel.fieldId = getFieldId();

        fieldCacheModel.issueId = getIssueId();

        String issueId = fieldCacheModel.issueId;

        if ((issueId != null) && (issueId.length() == 0)) {
            fieldCacheModel.issueId = null;
        }

        Date createdDate = getCreatedDate();

        if (createdDate != null) {
            fieldCacheModel.createdDate = createdDate.getTime();
        } else {
            fieldCacheModel.createdDate = Long.MIN_VALUE;
        }

        Date resolutionDate = getResolutionDate();

        if (resolutionDate != null) {
            fieldCacheModel.resolutionDate = resolutionDate.getTime();
        } else {
            fieldCacheModel.resolutionDate = Long.MIN_VALUE;
        }

        fieldCacheModel.summary = getSummary();

        String summary = fieldCacheModel.summary;

        if ((summary != null) && (summary.length() == 0)) {
            fieldCacheModel.summary = null;
        }

        Date updated = getUpdated();

        if (updated != null) {
            fieldCacheModel.updated = updated.getTime();
        } else {
            fieldCacheModel.updated = Long.MIN_VALUE;
        }

        fieldCacheModel.timespent = getTimespent();

        fieldCacheModel.timeestimate = getTimeestimate();

        fieldCacheModel.timeoriginalestimate = getTimeoriginalestimate();

        fieldCacheModel.aggregatetimespent = getAggregatetimespent();

        fieldCacheModel.aggregatetimeoriginalestimate = getAggregatetimeoriginalestimate();

        fieldCacheModel.aggregatetimeestimate = getAggregatetimeestimate();

        fieldCacheModel.description = getDescription();

        String description = fieldCacheModel.description;

        if ((description != null) && (description.length() == 0)) {
            fieldCacheModel.description = null;
        }

        fieldCacheModel.storypoints = getStorypoints();

        fieldCacheModel.creatorId = getCreatorId();

        String creatorId = fieldCacheModel.creatorId;

        if ((creatorId != null) && (creatorId.length() == 0)) {
            fieldCacheModel.creatorId = null;
        }

        fieldCacheModel.assigneeId = getAssigneeId();

        String assigneeId = fieldCacheModel.assigneeId;

        if ((assigneeId != null) && (assigneeId.length() == 0)) {
            fieldCacheModel.assigneeId = null;
        }

        fieldCacheModel.statusId = getStatusId();

        return fieldCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(35);

        sb.append("{fieldId=");
        sb.append(getFieldId());
        sb.append(", issueId=");
        sb.append(getIssueId());
        sb.append(", createdDate=");
        sb.append(getCreatedDate());
        sb.append(", resolutionDate=");
        sb.append(getResolutionDate());
        sb.append(", summary=");
        sb.append(getSummary());
        sb.append(", updated=");
        sb.append(getUpdated());
        sb.append(", timespent=");
        sb.append(getTimespent());
        sb.append(", timeestimate=");
        sb.append(getTimeestimate());
        sb.append(", timeoriginalestimate=");
        sb.append(getTimeoriginalestimate());
        sb.append(", aggregatetimespent=");
        sb.append(getAggregatetimespent());
        sb.append(", aggregatetimeoriginalestimate=");
        sb.append(getAggregatetimeoriginalestimate());
        sb.append(", aggregatetimeestimate=");
        sb.append(getAggregatetimeestimate());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append(", storypoints=");
        sb.append(getStorypoints());
        sb.append(", creatorId=");
        sb.append(getCreatorId());
        sb.append(", assigneeId=");
        sb.append(getAssigneeId());
        sb.append(", statusId=");
        sb.append(getStatusId());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(55);

        sb.append("<model><model-name>");
        sb.append("de.hska.wi.awp.datasource.model.Field");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>fieldId</column-name><column-value><![CDATA[");
        sb.append(getFieldId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>issueId</column-name><column-value><![CDATA[");
        sb.append(getIssueId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>createdDate</column-name><column-value><![CDATA[");
        sb.append(getCreatedDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>resolutionDate</column-name><column-value><![CDATA[");
        sb.append(getResolutionDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>summary</column-name><column-value><![CDATA[");
        sb.append(getSummary());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>updated</column-name><column-value><![CDATA[");
        sb.append(getUpdated());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>timespent</column-name><column-value><![CDATA[");
        sb.append(getTimespent());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>timeestimate</column-name><column-value><![CDATA[");
        sb.append(getTimeestimate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>timeoriginalestimate</column-name><column-value><![CDATA[");
        sb.append(getTimeoriginalestimate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>aggregatetimespent</column-name><column-value><![CDATA[");
        sb.append(getAggregatetimespent());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>aggregatetimeoriginalestimate</column-name><column-value><![CDATA[");
        sb.append(getAggregatetimeoriginalestimate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>aggregatetimeestimate</column-name><column-value><![CDATA[");
        sb.append(getAggregatetimeestimate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>description</column-name><column-value><![CDATA[");
        sb.append(getDescription());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>storypoints</column-name><column-value><![CDATA[");
        sb.append(getStorypoints());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>creatorId</column-name><column-value><![CDATA[");
        sb.append(getCreatorId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>assigneeId</column-name><column-value><![CDATA[");
        sb.append(getAssigneeId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>statusId</column-name><column-value><![CDATA[");
        sb.append(getStatusId());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
