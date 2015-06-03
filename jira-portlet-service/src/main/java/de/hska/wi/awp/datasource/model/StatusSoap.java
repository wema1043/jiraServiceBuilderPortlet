package de.hska.wi.awp.datasource.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link de.hska.wi.awp.datasource.service.http.StatusServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see de.hska.wi.awp.datasource.service.http.StatusServiceSoap
 * @generated
 */
public class StatusSoap implements Serializable {
    private String _statusId;
    private String _name;

    public StatusSoap() {
    }

    public static StatusSoap toSoapModel(Status model) {
        StatusSoap soapModel = new StatusSoap();

        soapModel.setStatusId(model.getStatusId());
        soapModel.setName(model.getName());

        return soapModel;
    }

    public static StatusSoap[] toSoapModels(Status[] models) {
        StatusSoap[] soapModels = new StatusSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static StatusSoap[][] toSoapModels(Status[][] models) {
        StatusSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new StatusSoap[models.length][models[0].length];
        } else {
            soapModels = new StatusSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static StatusSoap[] toSoapModels(List<Status> models) {
        List<StatusSoap> soapModels = new ArrayList<StatusSoap>(models.size());

        for (Status model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new StatusSoap[soapModels.size()]);
    }

    public String getPrimaryKey() {
        return _statusId;
    }

    public void setPrimaryKey(String pk) {
        setStatusId(pk);
    }

    public String getStatusId() {
        return _statusId;
    }

    public void setStatusId(String statusId) {
        _statusId = statusId;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }
}
