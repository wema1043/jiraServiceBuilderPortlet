package de.hska.wi.awp.datasource.model;

import de.hska.wi.awp.datasource.service.persistence.JiraUserPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link de.hska.wi.awp.datasource.service.http.JiraUserServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see de.hska.wi.awp.datasource.service.http.JiraUserServiceSoap
 * @generated
 */
public class JiraUserSoap implements Serializable {
    private String _creatorId;
    private String _displayname;
    private String _groupId;

    public JiraUserSoap() {
    }

    public static JiraUserSoap toSoapModel(JiraUser model) {
        JiraUserSoap soapModel = new JiraUserSoap();

        soapModel.setCreatorId(model.getCreatorId());
        soapModel.setDisplayname(model.getDisplayname());
        soapModel.setGroupId(model.getGroupId());

        return soapModel;
    }

    public static JiraUserSoap[] toSoapModels(JiraUser[] models) {
        JiraUserSoap[] soapModels = new JiraUserSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static JiraUserSoap[][] toSoapModels(JiraUser[][] models) {
        JiraUserSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new JiraUserSoap[models.length][models[0].length];
        } else {
            soapModels = new JiraUserSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static JiraUserSoap[] toSoapModels(List<JiraUser> models) {
        List<JiraUserSoap> soapModels = new ArrayList<JiraUserSoap>(models.size());

        for (JiraUser model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new JiraUserSoap[soapModels.size()]);
    }

    public JiraUserPK getPrimaryKey() {
        return new JiraUserPK(_creatorId, _groupId);
    }

    public void setPrimaryKey(JiraUserPK pk) {
        setCreatorId(pk.creatorId);
        setGroupId(pk.groupId);
    }

    public String getCreatorId() {
        return _creatorId;
    }

    public void setCreatorId(String creatorId) {
        _creatorId = creatorId;
    }

    public String getDisplayname() {
        return _displayname;
    }

    public void setDisplayname(String displayname) {
        _displayname = displayname;
    }

    public String getGroupId() {
        return _groupId;
    }

    public void setGroupId(String groupId) {
        _groupId = groupId;
    }
}
