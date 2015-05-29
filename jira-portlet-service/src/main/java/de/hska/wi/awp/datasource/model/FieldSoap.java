package de.hska.wi.awp.datasource.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link de.hska.wi.awp.datasource.service.http.FieldServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see de.hska.wi.awp.datasource.service.http.FieldServiceSoap
 * @generated
 */
public class FieldSoap implements Serializable {
    private long _fieldId;
    private Date _createdDate;
    private Date _resolutionDate;
    private String _summary;
    private Date _updated;
    private long _creatorId;
    private long _assigneeId;
    private long _statusId;

    public FieldSoap() {
    }

    public static FieldSoap toSoapModel(Field model) {
        FieldSoap soapModel = new FieldSoap();

        soapModel.setFieldId(model.getFieldId());
        soapModel.setCreatedDate(model.getCreatedDate());
        soapModel.setResolutionDate(model.getResolutionDate());
        soapModel.setSummary(model.getSummary());
        soapModel.setUpdated(model.getUpdated());
        soapModel.setCreatorId(model.getCreatorId());
        soapModel.setAssigneeId(model.getAssigneeId());
        soapModel.setStatusId(model.getStatusId());

        return soapModel;
    }

    public static FieldSoap[] toSoapModels(Field[] models) {
        FieldSoap[] soapModels = new FieldSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static FieldSoap[][] toSoapModels(Field[][] models) {
        FieldSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new FieldSoap[models.length][models[0].length];
        } else {
            soapModels = new FieldSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static FieldSoap[] toSoapModels(List<Field> models) {
        List<FieldSoap> soapModels = new ArrayList<FieldSoap>(models.size());

        for (Field model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new FieldSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _fieldId;
    }

    public void setPrimaryKey(long pk) {
        setFieldId(pk);
    }

    public long getFieldId() {
        return _fieldId;
    }

    public void setFieldId(long fieldId) {
        _fieldId = fieldId;
    }

    public Date getCreatedDate() {
        return _createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        _createdDate = createdDate;
    }

    public Date getResolutionDate() {
        return _resolutionDate;
    }

    public void setResolutionDate(Date resolutionDate) {
        _resolutionDate = resolutionDate;
    }

    public String getSummary() {
        return _summary;
    }

    public void setSummary(String summary) {
        _summary = summary;
    }

    public Date getUpdated() {
        return _updated;
    }

    public void setUpdated(Date updated) {
        _updated = updated;
    }

    public long getCreatorId() {
        return _creatorId;
    }

    public void setCreatorId(long creatorId) {
        _creatorId = creatorId;
    }

    public long getAssigneeId() {
        return _assigneeId;
    }

    public void setAssigneeId(long assigneeId) {
        _assigneeId = assigneeId;
    }

    public long getStatusId() {
        return _statusId;
    }

    public void setStatusId(long statusId) {
        _statusId = statusId;
    }
}
