package de.hska.wi.awp.datasource.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import de.hska.wi.awp.datasource.service.ClpSerializer;
import de.hska.wi.awp.datasource.service.FieldLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class FieldClp extends BaseModelImpl<Field> implements Field {
    private long _fieldId;
    private String _issueId;
    private Date _createdDate;
    private Date _resolutionDate;
    private String _summary;
    private Date _updated;
    private String _timespent;
    private String _timeestimate;
    private String _timeoriginalestimate;
    private String _aggregatetimespent;
    private String _aggregatetimeoriginalestimate;
    private String _aggregatetimeestimate;
    private String _description;
    private long _storypoints;
    private String _creatorId;
    private String _assigneeId;
    private long _statusId;
    private BaseModel<?> _fieldRemoteModel;
    private Class<?> _clpSerializerClass = de.hska.wi.awp.datasource.service.ClpSerializer.class;

    public FieldClp() {
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

    @Override
    public long getFieldId() {
        return _fieldId;
    }

    @Override
    public void setFieldId(long fieldId) {
        _fieldId = fieldId;

        if (_fieldRemoteModel != null) {
            try {
                Class<?> clazz = _fieldRemoteModel.getClass();

                Method method = clazz.getMethod("setFieldId", long.class);

                method.invoke(_fieldRemoteModel, fieldId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getIssueId() {
        return _issueId;
    }

    @Override
    public void setIssueId(String issueId) {
        _issueId = issueId;

        if (_fieldRemoteModel != null) {
            try {
                Class<?> clazz = _fieldRemoteModel.getClass();

                Method method = clazz.getMethod("setIssueId", String.class);

                method.invoke(_fieldRemoteModel, issueId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getCreatedDate() {
        return _createdDate;
    }

    @Override
    public void setCreatedDate(Date createdDate) {
        _createdDate = createdDate;

        if (_fieldRemoteModel != null) {
            try {
                Class<?> clazz = _fieldRemoteModel.getClass();

                Method method = clazz.getMethod("setCreatedDate", Date.class);

                method.invoke(_fieldRemoteModel, createdDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getResolutionDate() {
        return _resolutionDate;
    }

    @Override
    public void setResolutionDate(Date resolutionDate) {
        _resolutionDate = resolutionDate;

        if (_fieldRemoteModel != null) {
            try {
                Class<?> clazz = _fieldRemoteModel.getClass();

                Method method = clazz.getMethod("setResolutionDate", Date.class);

                method.invoke(_fieldRemoteModel, resolutionDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getSummary() {
        return _summary;
    }

    @Override
    public void setSummary(String summary) {
        _summary = summary;

        if (_fieldRemoteModel != null) {
            try {
                Class<?> clazz = _fieldRemoteModel.getClass();

                Method method = clazz.getMethod("setSummary", String.class);

                method.invoke(_fieldRemoteModel, summary);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getUpdated() {
        return _updated;
    }

    @Override
    public void setUpdated(Date updated) {
        _updated = updated;

        if (_fieldRemoteModel != null) {
            try {
                Class<?> clazz = _fieldRemoteModel.getClass();

                Method method = clazz.getMethod("setUpdated", Date.class);

                method.invoke(_fieldRemoteModel, updated);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getTimespent() {
        return _timespent;
    }

    @Override
    public void setTimespent(String timespent) {
        _timespent = timespent;

        if (_fieldRemoteModel != null) {
            try {
                Class<?> clazz = _fieldRemoteModel.getClass();

                Method method = clazz.getMethod("setTimespent", String.class);

                method.invoke(_fieldRemoteModel, timespent);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getTimeestimate() {
        return _timeestimate;
    }

    @Override
    public void setTimeestimate(String timeestimate) {
        _timeestimate = timeestimate;

        if (_fieldRemoteModel != null) {
            try {
                Class<?> clazz = _fieldRemoteModel.getClass();

                Method method = clazz.getMethod("setTimeestimate", String.class);

                method.invoke(_fieldRemoteModel, timeestimate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getTimeoriginalestimate() {
        return _timeoriginalestimate;
    }

    @Override
    public void setTimeoriginalestimate(String timeoriginalestimate) {
        _timeoriginalestimate = timeoriginalestimate;

        if (_fieldRemoteModel != null) {
            try {
                Class<?> clazz = _fieldRemoteModel.getClass();

                Method method = clazz.getMethod("setTimeoriginalestimate",
                        String.class);

                method.invoke(_fieldRemoteModel, timeoriginalestimate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getAggregatetimespent() {
        return _aggregatetimespent;
    }

    @Override
    public void setAggregatetimespent(String aggregatetimespent) {
        _aggregatetimespent = aggregatetimespent;

        if (_fieldRemoteModel != null) {
            try {
                Class<?> clazz = _fieldRemoteModel.getClass();

                Method method = clazz.getMethod("setAggregatetimespent",
                        String.class);

                method.invoke(_fieldRemoteModel, aggregatetimespent);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getAggregatetimeoriginalestimate() {
        return _aggregatetimeoriginalestimate;
    }

    @Override
    public void setAggregatetimeoriginalestimate(
        String aggregatetimeoriginalestimate) {
        _aggregatetimeoriginalestimate = aggregatetimeoriginalestimate;

        if (_fieldRemoteModel != null) {
            try {
                Class<?> clazz = _fieldRemoteModel.getClass();

                Method method = clazz.getMethod("setAggregatetimeoriginalestimate",
                        String.class);

                method.invoke(_fieldRemoteModel, aggregatetimeoriginalestimate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getAggregatetimeestimate() {
        return _aggregatetimeestimate;
    }

    @Override
    public void setAggregatetimeestimate(String aggregatetimeestimate) {
        _aggregatetimeestimate = aggregatetimeestimate;

        if (_fieldRemoteModel != null) {
            try {
                Class<?> clazz = _fieldRemoteModel.getClass();

                Method method = clazz.getMethod("setAggregatetimeestimate",
                        String.class);

                method.invoke(_fieldRemoteModel, aggregatetimeestimate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getDescription() {
        return _description;
    }

    @Override
    public void setDescription(String description) {
        _description = description;

        if (_fieldRemoteModel != null) {
            try {
                Class<?> clazz = _fieldRemoteModel.getClass();

                Method method = clazz.getMethod("setDescription", String.class);

                method.invoke(_fieldRemoteModel, description);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getStorypoints() {
        return _storypoints;
    }

    @Override
    public void setStorypoints(long storypoints) {
        _storypoints = storypoints;

        if (_fieldRemoteModel != null) {
            try {
                Class<?> clazz = _fieldRemoteModel.getClass();

                Method method = clazz.getMethod("setStorypoints", long.class);

                method.invoke(_fieldRemoteModel, storypoints);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getCreatorId() {
        return _creatorId;
    }

    @Override
    public void setCreatorId(String creatorId) {
        _creatorId = creatorId;

        if (_fieldRemoteModel != null) {
            try {
                Class<?> clazz = _fieldRemoteModel.getClass();

                Method method = clazz.getMethod("setCreatorId", String.class);

                method.invoke(_fieldRemoteModel, creatorId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getAssigneeId() {
        return _assigneeId;
    }

    @Override
    public void setAssigneeId(String assigneeId) {
        _assigneeId = assigneeId;

        if (_fieldRemoteModel != null) {
            try {
                Class<?> clazz = _fieldRemoteModel.getClass();

                Method method = clazz.getMethod("setAssigneeId", String.class);

                method.invoke(_fieldRemoteModel, assigneeId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getStatusId() {
        return _statusId;
    }

    @Override
    public void setStatusId(long statusId) {
        _statusId = statusId;

        if (_fieldRemoteModel != null) {
            try {
                Class<?> clazz = _fieldRemoteModel.getClass();

                Method method = clazz.getMethod("setStatusId", long.class);

                method.invoke(_fieldRemoteModel, statusId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getFieldRemoteModel() {
        return _fieldRemoteModel;
    }

    public void setFieldRemoteModel(BaseModel<?> fieldRemoteModel) {
        _fieldRemoteModel = fieldRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _fieldRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_fieldRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            FieldLocalServiceUtil.addField(this);
        } else {
            FieldLocalServiceUtil.updateField(this);
        }
    }

    @Override
    public Field toEscapedModel() {
        return (Field) ProxyUtil.newProxyInstance(Field.class.getClassLoader(),
            new Class[] { Field.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        FieldClp clone = new FieldClp();

        clone.setFieldId(getFieldId());
        clone.setIssueId(getIssueId());
        clone.setCreatedDate(getCreatedDate());
        clone.setResolutionDate(getResolutionDate());
        clone.setSummary(getSummary());
        clone.setUpdated(getUpdated());
        clone.setTimespent(getTimespent());
        clone.setTimeestimate(getTimeestimate());
        clone.setTimeoriginalestimate(getTimeoriginalestimate());
        clone.setAggregatetimespent(getAggregatetimespent());
        clone.setAggregatetimeoriginalestimate(getAggregatetimeoriginalestimate());
        clone.setAggregatetimeestimate(getAggregatetimeestimate());
        clone.setDescription(getDescription());
        clone.setStorypoints(getStorypoints());
        clone.setCreatorId(getCreatorId());
        clone.setAssigneeId(getAssigneeId());
        clone.setStatusId(getStatusId());

        return clone;
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

        if (!(obj instanceof FieldClp)) {
            return false;
        }

        FieldClp field = (FieldClp) obj;

        long primaryKey = field.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    public Class<?> getClpSerializerClass() {
        return _clpSerializerClass;
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
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
