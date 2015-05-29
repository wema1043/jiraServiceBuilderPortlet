package de.hska.wi.awp.datasource.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import de.hska.wi.awp.datasource.service.ClpSerializer;
import de.hska.wi.awp.datasource.service.StatusLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class StatusClp extends BaseModelImpl<Status> implements Status {
    private long _statusId;
    private String _name;
    private BaseModel<?> _statusRemoteModel;
    private Class<?> _clpSerializerClass = de.hska.wi.awp.datasource.service.ClpSerializer.class;

    public StatusClp() {
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
    public long getPrimaryKey() {
        return _statusId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setStatusId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _statusId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
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

    @Override
    public long getStatusId() {
        return _statusId;
    }

    @Override
    public void setStatusId(long statusId) {
        _statusId = statusId;

        if (_statusRemoteModel != null) {
            try {
                Class<?> clazz = _statusRemoteModel.getClass();

                Method method = clazz.getMethod("setStatusId", long.class);

                method.invoke(_statusRemoteModel, statusId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getName() {
        return _name;
    }

    @Override
    public void setName(String name) {
        _name = name;

        if (_statusRemoteModel != null) {
            try {
                Class<?> clazz = _statusRemoteModel.getClass();

                Method method = clazz.getMethod("setName", String.class);

                method.invoke(_statusRemoteModel, name);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getStatusRemoteModel() {
        return _statusRemoteModel;
    }

    public void setStatusRemoteModel(BaseModel<?> statusRemoteModel) {
        _statusRemoteModel = statusRemoteModel;
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

        Class<?> remoteModelClass = _statusRemoteModel.getClass();

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

        Object returnValue = method.invoke(_statusRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            StatusLocalServiceUtil.addStatus(this);
        } else {
            StatusLocalServiceUtil.updateStatus(this);
        }
    }

    @Override
    public Status toEscapedModel() {
        return (Status) ProxyUtil.newProxyInstance(Status.class.getClassLoader(),
            new Class[] { Status.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        StatusClp clone = new StatusClp();

        clone.setStatusId(getStatusId());
        clone.setName(getName());

        return clone;
    }

    @Override
    public int compareTo(Status status) {
        long primaryKey = status.getPrimaryKey();

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

        if (!(obj instanceof StatusClp)) {
            return false;
        }

        StatusClp status = (StatusClp) obj;

        long primaryKey = status.getPrimaryKey();

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
        StringBundler sb = new StringBundler(5);

        sb.append("{statusId=");
        sb.append(getStatusId());
        sb.append(", name=");
        sb.append(getName());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(10);

        sb.append("<model><model-name>");
        sb.append("de.hska.wi.awp.datasource.model.Status");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>statusId</column-name><column-value><![CDATA[");
        sb.append(getStatusId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append(getName());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
