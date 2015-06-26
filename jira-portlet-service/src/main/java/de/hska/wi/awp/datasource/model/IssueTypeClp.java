package de.hska.wi.awp.datasource.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import de.hska.wi.awp.datasource.service.ClpSerializer;
import de.hska.wi.awp.datasource.service.IssueTypeLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class IssueTypeClp extends BaseModelImpl<IssueType> implements IssueType {
    private long _issueTypeId;
    private String _typeName;
    private BaseModel<?> _issueTypeRemoteModel;
    private Class<?> _clpSerializerClass = de.hska.wi.awp.datasource.service.ClpSerializer.class;

    public IssueTypeClp() {
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
    public long getPrimaryKey() {
        return _issueTypeId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setIssueTypeId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _issueTypeId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
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

    @Override
    public long getIssueTypeId() {
        return _issueTypeId;
    }

    @Override
    public void setIssueTypeId(long issueTypeId) {
        _issueTypeId = issueTypeId;

        if (_issueTypeRemoteModel != null) {
            try {
                Class<?> clazz = _issueTypeRemoteModel.getClass();

                Method method = clazz.getMethod("setIssueTypeId", long.class);

                method.invoke(_issueTypeRemoteModel, issueTypeId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getTypeName() {
        return _typeName;
    }

    @Override
    public void setTypeName(String typeName) {
        _typeName = typeName;

        if (_issueTypeRemoteModel != null) {
            try {
                Class<?> clazz = _issueTypeRemoteModel.getClass();

                Method method = clazz.getMethod("setTypeName", String.class);

                method.invoke(_issueTypeRemoteModel, typeName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getIssueTypeRemoteModel() {
        return _issueTypeRemoteModel;
    }

    public void setIssueTypeRemoteModel(BaseModel<?> issueTypeRemoteModel) {
        _issueTypeRemoteModel = issueTypeRemoteModel;
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

        Class<?> remoteModelClass = _issueTypeRemoteModel.getClass();

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

        Object returnValue = method.invoke(_issueTypeRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            IssueTypeLocalServiceUtil.addIssueType(this);
        } else {
            IssueTypeLocalServiceUtil.updateIssueType(this);
        }
    }

    @Override
    public IssueType toEscapedModel() {
        return (IssueType) ProxyUtil.newProxyInstance(IssueType.class.getClassLoader(),
            new Class[] { IssueType.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        IssueTypeClp clone = new IssueTypeClp();

        clone.setIssueTypeId(getIssueTypeId());
        clone.setTypeName(getTypeName());

        return clone;
    }

    @Override
    public int compareTo(IssueType issueType) {
        long primaryKey = issueType.getPrimaryKey();

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

        if (!(obj instanceof IssueTypeClp)) {
            return false;
        }

        IssueTypeClp issueType = (IssueTypeClp) obj;

        long primaryKey = issueType.getPrimaryKey();

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

        sb.append("{issueTypeId=");
        sb.append(getIssueTypeId());
        sb.append(", typeName=");
        sb.append(getTypeName());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(10);

        sb.append("<model><model-name>");
        sb.append("de.hska.wi.awp.datasource.model.IssueType");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>issueTypeId</column-name><column-value><![CDATA[");
        sb.append(getIssueTypeId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>typeName</column-name><column-value><![CDATA[");
        sb.append(getTypeName());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
