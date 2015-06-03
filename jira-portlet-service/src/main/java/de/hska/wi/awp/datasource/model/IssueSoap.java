package de.hska.wi.awp.datasource.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link de.hska.wi.awp.datasource.service.http.IssueServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see de.hska.wi.awp.datasource.service.http.IssueServiceSoap
 * @generated
 */
public class IssueSoap implements Serializable {
    private String _issueId;
    private String _key;
    private String _self;
    private long _fieldId;

    public IssueSoap() {
    }

    public static IssueSoap toSoapModel(Issue model) {
        IssueSoap soapModel = new IssueSoap();

        soapModel.setIssueId(model.getIssueId());
        soapModel.setKey(model.getKey());
        soapModel.setSelf(model.getSelf());
        soapModel.setFieldId(model.getFieldId());

        return soapModel;
    }

    public static IssueSoap[] toSoapModels(Issue[] models) {
        IssueSoap[] soapModels = new IssueSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static IssueSoap[][] toSoapModels(Issue[][] models) {
        IssueSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new IssueSoap[models.length][models[0].length];
        } else {
            soapModels = new IssueSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static IssueSoap[] toSoapModels(List<Issue> models) {
        List<IssueSoap> soapModels = new ArrayList<IssueSoap>(models.size());

        for (Issue model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new IssueSoap[soapModels.size()]);
    }

    public String getPrimaryKey() {
        return _issueId;
    }

    public void setPrimaryKey(String pk) {
        setIssueId(pk);
    }

    public String getIssueId() {
        return _issueId;
    }

    public void setIssueId(String issueId) {
        _issueId = issueId;
    }

    public String getKey() {
        return _key;
    }

    public void setKey(String key) {
        _key = key;
    }

    public String getSelf() {
        return _self;
    }

    public void setSelf(String self) {
        _self = self;
    }

    public long getFieldId() {
        return _fieldId;
    }

    public void setFieldId(long fieldId) {
        _fieldId = fieldId;
    }
}
