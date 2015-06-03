package de.hska.wi.awp.datasource.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link de.hska.wi.awp.datasource.service.http.IssuePriorityServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see de.hska.wi.awp.datasource.service.http.IssuePriorityServiceSoap
 * @generated
 */
public class IssuePrioritySoap implements Serializable {
    private long _priorityId;
    private String _priorityName;

    public IssuePrioritySoap() {
    }

    public static IssuePrioritySoap toSoapModel(IssuePriority model) {
        IssuePrioritySoap soapModel = new IssuePrioritySoap();

        soapModel.setPriorityId(model.getPriorityId());
        soapModel.setPriorityName(model.getPriorityName());

        return soapModel;
    }

    public static IssuePrioritySoap[] toSoapModels(IssuePriority[] models) {
        IssuePrioritySoap[] soapModels = new IssuePrioritySoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static IssuePrioritySoap[][] toSoapModels(IssuePriority[][] models) {
        IssuePrioritySoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new IssuePrioritySoap[models.length][models[0].length];
        } else {
            soapModels = new IssuePrioritySoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static IssuePrioritySoap[] toSoapModels(List<IssuePriority> models) {
        List<IssuePrioritySoap> soapModels = new ArrayList<IssuePrioritySoap>(models.size());

        for (IssuePriority model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new IssuePrioritySoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _priorityId;
    }

    public void setPrimaryKey(long pk) {
        setPriorityId(pk);
    }

    public long getPriorityId() {
        return _priorityId;
    }

    public void setPriorityId(long priorityId) {
        _priorityId = priorityId;
    }

    public String getPriorityName() {
        return _priorityName;
    }

    public void setPriorityName(String priorityName) {
        _priorityName = priorityName;
    }
}
