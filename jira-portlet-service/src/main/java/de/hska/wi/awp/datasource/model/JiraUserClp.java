package de.hska.wi.awp.datasource.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import de.hska.wi.awp.datasource.service.ClpSerializer;
import de.hska.wi.awp.datasource.service.JiraUserLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class JiraUserClp extends BaseModelImpl<JiraUser> implements JiraUser {
    private String _creatorId;
    private String _displayname;
    private BaseModel<?> _jiraUserRemoteModel;
    private Class<?> _clpSerializerClass = de.hska.wi.awp.datasource.service.ClpSerializer.class;

    public JiraUserClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return JiraUser.class;
    }

    @Override
    public String getModelClassName() {
        return JiraUser.class.getName();
    }

    @Override
    public String getPrimaryKey() {
        return _creatorId;
    }

    @Override
    public void setPrimaryKey(String primaryKey) {
        setCreatorId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _creatorId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey((String) primaryKeyObj);
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("creatorId", getCreatorId());
        attributes.put("displayname", getDisplayname());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        String creatorId = (String) attributes.get("creatorId");

        if (creatorId != null) {
            setCreatorId(creatorId);
        }

        String displayname = (String) attributes.get("displayname");

        if (displayname != null) {
            setDisplayname(displayname);
        }
    }

    @Override
    public String getCreatorId() {
        return _creatorId;
    }

    @Override
    public void setCreatorId(String creatorId) {
        _creatorId = creatorId;

        if (_jiraUserRemoteModel != null) {
            try {
                Class<?> clazz = _jiraUserRemoteModel.getClass();

                Method method = clazz.getMethod("setCreatorId", String.class);

                method.invoke(_jiraUserRemoteModel, creatorId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getDisplayname() {
        return _displayname;
    }

    @Override
    public void setDisplayname(String displayname) {
        _displayname = displayname;

        if (_jiraUserRemoteModel != null) {
            try {
                Class<?> clazz = _jiraUserRemoteModel.getClass();

                Method method = clazz.getMethod("setDisplayname", String.class);

                method.invoke(_jiraUserRemoteModel, displayname);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getJiraUserRemoteModel() {
        return _jiraUserRemoteModel;
    }

    public void setJiraUserRemoteModel(BaseModel<?> jiraUserRemoteModel) {
        _jiraUserRemoteModel = jiraUserRemoteModel;
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

        Class<?> remoteModelClass = _jiraUserRemoteModel.getClass();

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

        Object returnValue = method.invoke(_jiraUserRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            JiraUserLocalServiceUtil.addJiraUser(this);
        } else {
            JiraUserLocalServiceUtil.updateJiraUser(this);
        }
    }

    @Override
    public JiraUser toEscapedModel() {
        return (JiraUser) ProxyUtil.newProxyInstance(JiraUser.class.getClassLoader(),
            new Class[] { JiraUser.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        JiraUserClp clone = new JiraUserClp();

        clone.setCreatorId(getCreatorId());
        clone.setDisplayname(getDisplayname());

        return clone;
    }

    @Override
    public int compareTo(JiraUser jiraUser) {
        String primaryKey = jiraUser.getPrimaryKey();

        return getPrimaryKey().compareTo(primaryKey);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof JiraUserClp)) {
            return false;
        }

        JiraUserClp jiraUser = (JiraUserClp) obj;

        String primaryKey = jiraUser.getPrimaryKey();

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
        StringBundler sb = new StringBundler(5);

        sb.append("{creatorId=");
        sb.append(getCreatorId());
        sb.append(", displayname=");
        sb.append(getDisplayname());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(10);

        sb.append("<model><model-name>");
        sb.append("de.hska.wi.awp.datasource.model.JiraUser");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>creatorId</column-name><column-value><![CDATA[");
        sb.append(getCreatorId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>displayname</column-name><column-value><![CDATA[");
        sb.append(getDisplayname());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
