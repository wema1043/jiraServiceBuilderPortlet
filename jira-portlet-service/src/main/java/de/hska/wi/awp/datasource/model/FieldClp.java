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
    private Date _createdDate;
    private Date _resolutionDate;
    private String _summary;
    private Date _updated;
    private long _creatorId;
    private long _assigneeId;
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
        attributes.put("createdDate", getCreatedDate());
        attributes.put("resolutionDate", getResolutionDate());
        attributes.put("summary", getSummary());
        attributes.put("updated", getUpdated());
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

        Long creatorId = (Long) attributes.get("creatorId");

        if (creatorId != null) {
            setCreatorId(creatorId);
        }

        Long assigneeId = (Long) attributes.get("assigneeId");

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
    public long getCreatorId() {
        return _creatorId;
    }

    @Override
    public void setCreatorId(long creatorId) {
        _creatorId = creatorId;

        if (_fieldRemoteModel != null) {
            try {
                Class<?> clazz = _fieldRemoteModel.getClass();

                Method method = clazz.getMethod("setCreatorId", long.class);

                method.invoke(_fieldRemoteModel, creatorId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getAssigneeId() {
        return _assigneeId;
    }

    @Override
    public void setAssigneeId(long assigneeId) {
        _assigneeId = assigneeId;

        if (_fieldRemoteModel != null) {
            try {
                Class<?> clazz = _fieldRemoteModel.getClass();

                Method method = clazz.getMethod("setAssigneeId", long.class);

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
        clone.setCreatedDate(getCreatedDate());
        clone.setResolutionDate(getResolutionDate());
        clone.setSummary(getSummary());
        clone.setUpdated(getUpdated());
        clone.setCreatorId(getCreatorId());
        clone.setAssigneeId(getAssigneeId());
        clone.setStatusId(getStatusId());

        return clone;
    }

    @Override
    public int compareTo(Field field) {
        long primaryKey = field.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
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
        StringBundler sb = new StringBundler(17);

        sb.append("{fieldId=");
        sb.append(getFieldId());
        sb.append(", createdDate=");
        sb.append(getCreatedDate());
        sb.append(", resolutionDate=");
        sb.append(getResolutionDate());
        sb.append(", summary=");
        sb.append(getSummary());
        sb.append(", updated=");
        sb.append(getUpdated());
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
        StringBundler sb = new StringBundler(28);

        sb.append("<model><model-name>");
        sb.append("de.hska.wi.awp.datasource.model.Field");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>fieldId</column-name><column-value><![CDATA[");
        sb.append(getFieldId());
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
