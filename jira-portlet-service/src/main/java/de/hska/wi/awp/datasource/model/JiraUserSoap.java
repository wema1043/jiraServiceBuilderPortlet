package de.hska.wi.awp.datasource.model;

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

    public JiraUserSoap() {
    }

    public static JiraUserSoap toSoapModel(JiraUser model) {
        JiraUserSoap soapModel = new JiraUserSoap();

        soapModel.setCreatorId(model.getCreatorId());
        soapModel.setDisplayname(model.getDisplayname());

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

    public String getPrimaryKey() {
        return _creatorId;
    }

    public void setPrimaryKey(String pk) {
        setCreatorId(pk);
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
}
