package de.hska.wi.awp.datasource.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import de.hska.wi.awp.datasource.service.ClpSerializer;
import de.hska.wi.awp.datasource.service.ProjectLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class ProjectClp extends BaseModelImpl<Project> implements Project {
    private String _projectId;
    private String _key;
    private String _name;
    private BaseModel<?> _projectRemoteModel;
    private Class<?> _clpSerializerClass = de.hska.wi.awp.datasource.service.ClpSerializer.class;

    public ProjectClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return Project.class;
    }

    @Override
    public String getModelClassName() {
        return Project.class.getName();
    }

    @Override
    public String getPrimaryKey() {
        return _projectId;
    }

    @Override
    public void setPrimaryKey(String primaryKey) {
        setProjectId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _projectId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey((String) primaryKeyObj);
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("projectId", getProjectId());
        attributes.put("key", getKey());
        attributes.put("name", getName());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        String projectId = (String) attributes.get("projectId");

        if (projectId != null) {
            setProjectId(projectId);
        }

        String key = (String) attributes.get("key");

        if (key != null) {
            setKey(key);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }
    }

    @Override
    public String getProjectId() {
        return _projectId;
    }

    @Override
    public void setProjectId(String projectId) {
        _projectId = projectId;

        if (_projectRemoteModel != null) {
            try {
                Class<?> clazz = _projectRemoteModel.getClass();

                Method method = clazz.getMethod("setProjectId", String.class);

                method.invoke(_projectRemoteModel, projectId);
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

        if (_projectRemoteModel != null) {
            try {
                Class<?> clazz = _projectRemoteModel.getClass();

                Method method = clazz.getMethod("setKey", String.class);

                method.invoke(_projectRemoteModel, key);
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

        if (_projectRemoteModel != null) {
            try {
                Class<?> clazz = _projectRemoteModel.getClass();

                Method method = clazz.getMethod("setName", String.class);

                method.invoke(_projectRemoteModel, name);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getProjectRemoteModel() {
        return _projectRemoteModel;
    }

    public void setProjectRemoteModel(BaseModel<?> projectRemoteModel) {
        _projectRemoteModel = projectRemoteModel;
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

        Class<?> remoteModelClass = _projectRemoteModel.getClass();

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

        Object returnValue = method.invoke(_projectRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            ProjectLocalServiceUtil.addProject(this);
        } else {
            ProjectLocalServiceUtil.updateProject(this);
        }
    }

    @Override
    public Project toEscapedModel() {
        return (Project) ProxyUtil.newProxyInstance(Project.class.getClassLoader(),
            new Class[] { Project.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        ProjectClp clone = new ProjectClp();

        clone.setProjectId(getProjectId());
        clone.setKey(getKey());
        clone.setName(getName());

        return clone;
    }

    @Override
    public int compareTo(Project project) {
        String primaryKey = project.getPrimaryKey();

        return getPrimaryKey().compareTo(primaryKey);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ProjectClp)) {
            return false;
        }

        ProjectClp project = (ProjectClp) obj;

        String primaryKey = project.getPrimaryKey();

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
        StringBundler sb = new StringBundler(7);

        sb.append("{projectId=");
        sb.append(getProjectId());
        sb.append(", key=");
        sb.append(getKey());
        sb.append(", name=");
        sb.append(getName());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(13);

        sb.append("<model><model-name>");
        sb.append("de.hska.wi.awp.datasource.model.Project");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>projectId</column-name><column-value><![CDATA[");
        sb.append(getProjectId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>key</column-name><column-value><![CDATA[");
        sb.append(getKey());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append(getName());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
