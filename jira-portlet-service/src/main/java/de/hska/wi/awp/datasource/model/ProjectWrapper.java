package de.hska.wi.awp.datasource.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Project}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Project
 * @generated
 */
public class ProjectWrapper implements Project, ModelWrapper<Project> {
    private Project _project;

    public ProjectWrapper(Project project) {
        _project = project;
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

    /**
    * Returns the primary key of this project.
    *
    * @return the primary key of this project
    */
    @Override
    public java.lang.String getPrimaryKey() {
        return _project.getPrimaryKey();
    }

    /**
    * Sets the primary key of this project.
    *
    * @param primaryKey the primary key of this project
    */
    @Override
    public void setPrimaryKey(java.lang.String primaryKey) {
        _project.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the project ID of this project.
    *
    * @return the project ID of this project
    */
    @Override
    public java.lang.String getProjectId() {
        return _project.getProjectId();
    }

    /**
    * Sets the project ID of this project.
    *
    * @param projectId the project ID of this project
    */
    @Override
    public void setProjectId(java.lang.String projectId) {
        _project.setProjectId(projectId);
    }

    /**
    * Returns the key of this project.
    *
    * @return the key of this project
    */
    @Override
    public java.lang.String getKey() {
        return _project.getKey();
    }

    /**
    * Sets the key of this project.
    *
    * @param key the key of this project
    */
    @Override
    public void setKey(java.lang.String key) {
        _project.setKey(key);
    }

    /**
    * Returns the name of this project.
    *
    * @return the name of this project
    */
    @Override
    public java.lang.String getName() {
        return _project.getName();
    }

    /**
    * Sets the name of this project.
    *
    * @param name the name of this project
    */
    @Override
    public void setName(java.lang.String name) {
        _project.setName(name);
    }

    @Override
    public boolean isNew() {
        return _project.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _project.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _project.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _project.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _project.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _project.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _project.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _project.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _project.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _project.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _project.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new ProjectWrapper((Project) _project.clone());
    }

    @Override
    public int compareTo(de.hska.wi.awp.datasource.model.Project project) {
        return _project.compareTo(project);
    }

    @Override
    public int hashCode() {
        return _project.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<de.hska.wi.awp.datasource.model.Project> toCacheModel() {
        return _project.toCacheModel();
    }

    @Override
    public de.hska.wi.awp.datasource.model.Project toEscapedModel() {
        return new ProjectWrapper(_project.toEscapedModel());
    }

    @Override
    public de.hska.wi.awp.datasource.model.Project toUnescapedModel() {
        return new ProjectWrapper(_project.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _project.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _project.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _project.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ProjectWrapper)) {
            return false;
        }

        ProjectWrapper projectWrapper = (ProjectWrapper) obj;

        if (Validator.equals(_project, projectWrapper._project)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Project getWrappedProject() {
        return _project;
    }

    @Override
    public Project getWrappedModel() {
        return _project;
    }

    @Override
    public void resetOriginalValues() {
        _project.resetOriginalValues();
    }
}
