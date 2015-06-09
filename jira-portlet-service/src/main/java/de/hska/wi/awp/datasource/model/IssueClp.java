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
    private String _issueId;
    private String _projectId;
    private String _key;
    private String _self;
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
    public String getPrimaryKey() {
        return _issueId;
    }

    @Override
    public void setPrimaryKey(String primaryKey) {
        setIssueId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _issueId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey((String) primaryKeyObj);
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("issueId", getIssueId());
        attributes.put("projectId", getProjectId());
        attributes.put("key", getKey());
        attributes.put("self", getSelf());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        String issueId = (String) attributes.get("issueId");

        if (issueId != null) {
            setIssueId(issueId);
        }

        String projectId = (String) attributes.get("projectId");

        if (projectId != null) {
            setProjectId(projectId);
        }

        String key = (String) attributes.get("key");

        if (key != null) {
            setKey(key);
        }

        String self = (String) attributes.get("self");

        if (self != null) {
            setSelf(self);
        }
    }

    @Override
    public String getIssueId() {
        return _issueId;
    }

    @Override
    public void setIssueId(String issueId) {
        _issueId = issueId;

        if (_issueRemoteModel != null) {
            try {
                Class<?> clazz = _issueRemoteModel.getClass();

                Method method = clazz.getMethod("setIssueId", String.class);

                method.invoke(_issueRemoteModel, issueId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getProjectId() {
        return _projectId;
    }

    @Override
    public void setProjectId(String projectId) {
        _projectId = projectId;

        if (_issueRemoteModel != null) {
            try {
                Class<?> clazz = _issueRemoteModel.getClass();

                Method method = clazz.getMethod("setProjectId", String.class);

                method.invoke(_issueRemoteModel, projectId);
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
        clone.setProjectId(getProjectId());
        clone.setKey(getKey());
        clone.setSelf(getSelf());

        return clone;
    }

    @Override
    public int compareTo(Issue issue) {
        String primaryKey = issue.getPrimaryKey();

        return getPrimaryKey().compareTo(primaryKey);
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

        String primaryKey = issue.getPrimaryKey();

        if (getPrimaryKey().equals(primaryKey)) {
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
        return getPrimaryKey().hashCode();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(9);

        sb.append("{issueId=");
        sb.append(getIssueId());
        sb.append(", projectId=");
        sb.append(getProjectId());
        sb.append(", key=");
        sb.append(getKey());
        sb.append(", self=");
        sb.append(getSelf());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(16);

        sb.append("<model><model-name>");
        sb.append("de.hska.wi.awp.datasource.model.Issue");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>issueId</column-name><column-value><![CDATA[");
        sb.append(getIssueId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>projectId</column-name><column-value><![CDATA[");
        sb.append(getProjectId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>key</column-name><column-value><![CDATA[");
        sb.append(getKey());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>self</column-name><column-value><![CDATA[");
        sb.append(getSelf());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
