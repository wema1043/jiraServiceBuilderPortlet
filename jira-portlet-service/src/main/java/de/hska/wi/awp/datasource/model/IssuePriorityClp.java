package de.hska.wi.awp.datasource.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import de.hska.wi.awp.datasource.service.ClpSerializer;
import de.hska.wi.awp.datasource.service.IssuePriorityLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class IssuePriorityClp extends BaseModelImpl<IssuePriority>
    implements IssuePriority {
    private long _priorityId;
    private String _priorityName;
    private BaseModel<?> _issuePriorityRemoteModel;
    private Class<?> _clpSerializerClass = de.hska.wi.awp.datasource.service.ClpSerializer.class;

    public IssuePriorityClp() {
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
    public long getPrimaryKey() {
        return _priorityId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setPriorityId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _priorityId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
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

    @Override
    public long getPriorityId() {
        return _priorityId;
    }

    @Override
    public void setPriorityId(long priorityId) {
        _priorityId = priorityId;

        if (_issuePriorityRemoteModel != null) {
            try {
                Class<?> clazz = _issuePriorityRemoteModel.getClass();

                Method method = clazz.getMethod("setPriorityId", long.class);

                method.invoke(_issuePriorityRemoteModel, priorityId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getPriorityName() {
        return _priorityName;
    }

    @Override
    public void setPriorityName(String priorityName) {
        _priorityName = priorityName;

        if (_issuePriorityRemoteModel != null) {
            try {
                Class<?> clazz = _issuePriorityRemoteModel.getClass();

                Method method = clazz.getMethod("setPriorityName", String.class);

                method.invoke(_issuePriorityRemoteModel, priorityName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getIssuePriorityRemoteModel() {
        return _issuePriorityRemoteModel;
    }

    public void setIssuePriorityRemoteModel(
        BaseModel<?> issuePriorityRemoteModel) {
        _issuePriorityRemoteModel = issuePriorityRemoteModel;
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

        Class<?> remoteModelClass = _issuePriorityRemoteModel.getClass();

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

        Object returnValue = method.invoke(_issuePriorityRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            IssuePriorityLocalServiceUtil.addIssuePriority(this);
        } else {
            IssuePriorityLocalServiceUtil.updateIssuePriority(this);
        }
    }

    @Override
    public IssuePriority toEscapedModel() {
        return (IssuePriority) ProxyUtil.newProxyInstance(IssuePriority.class.getClassLoader(),
            new Class[] { IssuePriority.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        IssuePriorityClp clone = new IssuePriorityClp();

        clone.setPriorityId(getPriorityId());
        clone.setPriorityName(getPriorityName());

        return clone;
    }

    @Override
    public int compareTo(IssuePriority issuePriority) {
        long primaryKey = issuePriority.getPrimaryKey();

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

        if (!(obj instanceof IssuePriorityClp)) {
            return false;
        }

        IssuePriorityClp issuePriority = (IssuePriorityClp) obj;

        long primaryKey = issuePriority.getPrimaryKey();

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

        sb.append("{priorityId=");
        sb.append(getPriorityId());
        sb.append(", priorityName=");
        sb.append(getPriorityName());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(10);

        sb.append("<model><model-name>");
        sb.append("de.hska.wi.awp.datasource.model.IssuePriority");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>priorityId</column-name><column-value><![CDATA[");
        sb.append(getPriorityId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>priorityName</column-name><column-value><![CDATA[");
        sb.append(getPriorityName());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
