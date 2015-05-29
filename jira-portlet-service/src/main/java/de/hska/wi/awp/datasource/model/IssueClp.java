package de.hska.wi.awp.datasource.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import de.hska.wi.awp.datasource.service.ClpSerializer;
import de.hska.wi.awp.datasource.service.IssueLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class IssueClp extends BaseModelImpl<Issue> implements Issue {
    private long _issueId;
    private String _id;
    private String _key;
    private String _self;
    private long _fieldId;
    private BaseModel<?> _issueRemoteModel;
    private Class<?> _clpSerializerClass = de.hska.wi.awp.datasource.service.ClpSerializer.class;

    public IssueClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return Issue.class;
    }

    @Override
    public String getModelClassName() {
        return Issue.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _issueId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setIssueId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _issueId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("issueId", getIssueId());
        attributes.put("id", getId());
        attributes.put("key", getKey());
        attributes.put("self", getSelf());
        attributes.put("fieldId", getFieldId());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long issueId = (Long) attributes.get("issueId");

        if (issueId != null) {
            setIssueId(issueId);
        }

        String id = (String) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        String key = (String) attributes.get("key");

        if (key != null) {
            setKey(key);
        }

        String self = (String) attributes.get("self");

        if (self != null) {
            setSelf(self);
        }

        Long fieldId = (Long) attributes.get("fieldId");

        if (fieldId != null) {
            setFieldId(fieldId);
        }
    }

    @Override
    public long getIssueId() {
        return _issueId;
    }

    @Override
    public void setIssueId(long issueId) {
        _issueId = issueId;

        if (_issueRemoteModel != null) {
            try {
                Class<?> clazz = _issueRemoteModel.getClass();

                Method method = clazz.getMethod("setIssueId", long.class);

                method.invoke(_issueRemoteModel, issueId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getId() {
        return _id;
    }

    @Override
    public void setId(String id) {
        _id = id;

        if (_issueRemoteModel != null) {
            try {
                Class<?> clazz = _issueRemoteModel.getClass();

                Method method = clazz.getMethod("setId", String.class);

                method.invoke(_issueRemoteModel, id);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getKey() {
        return _key;
    }

    @Override
    public void setKey(String key) {
        _key = key;

        if (_issueRemoteModel != null) {
            try {
                Class<?> clazz = _issueRemoteModel.getClass();

                Method method = clazz.getMethod("setKey", String.class);

                method.invoke(_issueRemoteModel, key);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getSelf() {
        return _self;
    }

    @Override
    public void setSelf(String self) {
        _self = self;

        if (_issueRemoteModel != null) {
            try {
                Class<?> clazz = _issueRemoteModel.getClass();

                Method method = clazz.getMethod("setSelf", String.class);

                method.invoke(_issueRemoteModel, self);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getFieldId() {
        return _fieldId;
    }

    @Override
    public void setFieldId(long fieldId) {
        _fieldId = fieldId;

        if (_issueRemoteModel != null) {
            try {
                Class<?> clazz = _issueRemoteModel.getClass();

                Method method = clazz.getMethod("setFieldId", long.class);

                method.invoke(_issueRemoteModel, fieldId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getIssueRemoteModel() {
        return _issueRemoteModel;
    }

    public void setIssueRemoteModel(BaseModel<?> issueRemoteModel) {
        _issueRemoteModel = issueRemoteModel;
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

        Class<?> remoteModelClass = _issueRemoteModel.getClass();

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

        Object returnValue = method.invoke(_issueRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            IssueLocalServiceUtil.addIssue(this);
        } else {
            IssueLocalServiceUtil.updateIssue(this);
        }
    }

    @Override
    public Issue toEscapedModel() {
        return (Issue) ProxyUtil.newProxyInstance(Issue.class.getClassLoader(),
            new Class[] { Issue.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        IssueClp clone = new IssueClp();

        clone.setIssueId(getIssueId());
        clone.setId(getId());
        clone.setKey(getKey());
        clone.setSelf(getSelf());
        clone.setFieldId(getFieldId());

        return clone;
    }

    @Override
    public int compareTo(Issue issue) {
        long primaryKey = issue.getPrimaryKey();

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

        if (!(obj instanceof IssueClp)) {
            return false;
        }

        IssueClp issue = (IssueClp) obj;

        long primaryKey = issue.getPrimaryKey();

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
        StringBundler sb = new StringBundler(11);

        sb.append("{issueId=");
        sb.append(getIssueId());
        sb.append(", id=");
        sb.append(getId());
        sb.append(", key=");
        sb.append(getKey());
        sb.append(", self=");
        sb.append(getSelf());
        sb.append(", fieldId=");
        sb.append(getFieldId());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(19);

        sb.append("<model><model-name>");
        sb.append("de.hska.wi.awp.datasource.model.Issue");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>issueId</column-name><column-value><![CDATA[");
        sb.append(getIssueId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>key</column-name><column-value><![CDATA[");
        sb.append(getKey());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>self</column-name><column-value><![CDATA[");
        sb.append(getSelf());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>fieldId</column-name><column-value><![CDATA[");
        sb.append(getFieldId());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
