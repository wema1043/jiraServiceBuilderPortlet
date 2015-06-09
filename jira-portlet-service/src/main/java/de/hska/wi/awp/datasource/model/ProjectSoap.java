package de.hska.wi.awp.datasource.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link de.hska.wi.awp.datasource.service.http.ProjectServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see de.hska.wi.awp.datasource.service.http.ProjectServiceSoap
 * @generated
 */
public class ProjectSoap implements Serializable {
    private String _projectId;
    private String _key;
    private String _name;

    public ProjectSoap() {
    }

    public static ProjectSoap toSoapModel(Project model) {
        ProjectSoap soapModel = new ProjectSoap();

        soapModel.setProjectId(model.getProjectId());
        soapModel.setKey(model.getKey());
        soapModel.setName(model.getName());

        return soapModel;
    }

    public static ProjectSoap[] toSoapModels(Project[] models) {
        ProjectSoap[] soapModels = new ProjectSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static ProjectSoap[][] toSoapModels(Project[][] models) {
        ProjectSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new ProjectSoap[models.length][models[0].length];
        } else {
            soapModels = new ProjectSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static ProjectSoap[] toSoapModels(List<Project> models) {
        List<ProjectSoap> soapModels = new ArrayList<ProjectSoap>(models.size());

        for (Project model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new ProjectSoap[soapModels.size()]);
    }

    public String getPrimaryKey() {
        return _projectId;
    }

    public void setPrimaryKey(String pk) {
        setProjectId(pk);
    }

    public String getProjectId() {
        return _projectId;
    }

    public void setProjectId(String projectId) {
        _projectId = projectId;
    }

    public String getKey() {
        return _key;
    }

    public void setKey(String key) {
        _key = key;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }
}
