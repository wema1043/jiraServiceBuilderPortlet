package de.hska.wi.awp.datasource.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link de.hska.wi.awp.datasource.service.http.IssueTypeServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see de.hska.wi.awp.datasource.service.http.IssueTypeServiceSoap
 * @generated
 */
public class IssueTypeSoap implements Serializable {
    private long _issueTypeId;
    private String _typeName;

    public IssueTypeSoap() {
    }

    public static IssueTypeSoap toSoapModel(IssueType model) {
        IssueTypeSoap soapModel = new IssueTypeSoap();

        soapModel.setIssueTypeId(model.getIssueTypeId());
        soapModel.setTypeName(model.getTypeName());

        return soapModel;
    }

    public static IssueTypeSoap[] toSoapModels(IssueType[] models) {
        IssueTypeSoap[] soapModels = new IssueTypeSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static IssueTypeSoap[][] toSoapModels(IssueType[][] models) {
        IssueTypeSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new IssueTypeSoap[models.length][models[0].length];
        } else {
            soapModels = new IssueTypeSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static IssueTypeSoap[] toSoapModels(List<IssueType> models) {
        List<IssueTypeSoap> soapModels = new ArrayList<IssueTypeSoap>(models.size());

        for (IssueType model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new IssueTypeSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _issueTypeId;
    }

    public void setPrimaryKey(long pk) {
        setIssueTypeId(pk);
    }

    public long getIssueTypeId() {
        return _issueTypeId;
    }

    public void setIssueTypeId(long issueTypeId) {
        _issueTypeId = issueTypeId;
    }

    public String getTypeName() {
        return _typeName;
    }

    public void setTypeName(String typeName) {
        _typeName = typeName;
    }
}
