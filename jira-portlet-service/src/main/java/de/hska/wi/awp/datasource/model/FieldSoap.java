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
    private String _issueId;
    private Date _createdDate;
    private Date _resolutionDate;
    private String _summary;
    private Date _updated;
    private long _timespent;
    private long _timeestimate;
    private long _timeoriginalestimate;
    private long _aggregatetimespent;
    private long _aggregatetimeoriginalestimate;
    private long _aggregatetimeestimate;
    private String _description;
    private long _storypoints;
    private String _creatorId;
    private String _assigneeId;
    private long _statusId;

    public FieldSoap() {
    }

    public static FieldSoap toSoapModel(Field model) {
        FieldSoap soapModel = new FieldSoap();

        soapModel.setFieldId(model.getFieldId());
        soapModel.setIssueId(model.getIssueId());
        soapModel.setCreatedDate(model.getCreatedDate());
        soapModel.setResolutionDate(model.getResolutionDate());
        soapModel.setSummary(model.getSummary());
        soapModel.setUpdated(model.getUpdated());
        soapModel.setTimespent(model.getTimespent());
        soapModel.setTimeestimate(model.getTimeestimate());
        soapModel.setTimeoriginalestimate(model.getTimeoriginalestimate());
        soapModel.setAggregatetimespent(model.getAggregatetimespent());
        soapModel.setAggregatetimeoriginalestimate(model.getAggregatetimeoriginalestimate());
        soapModel.setAggregatetimeestimate(model.getAggregatetimeestimate());
        soapModel.setDescription(model.getDescription());
        soapModel.setStorypoints(model.getStorypoints());
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

    public String getIssueId() {
        return _issueId;
    }

    public void setIssueId(String issueId) {
        _issueId = issueId;
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

    public long getTimespent() {
        return _timespent;
    }

    public void setTimespent(long timespent) {
        _timespent = timespent;
    }

    public long getTimeestimate() {
        return _timeestimate;
    }

    public void setTimeestimate(long timeestimate) {
        _timeestimate = timeestimate;
    }

    public long getTimeoriginalestimate() {
        return _timeoriginalestimate;
    }

    public void setTimeoriginalestimate(long timeoriginalestimate) {
        _timeoriginalestimate = timeoriginalestimate;
    }

    public long getAggregatetimespent() {
        return _aggregatetimespent;
    }

    public void setAggregatetimespent(long aggregatetimespent) {
        _aggregatetimespent = aggregatetimespent;
    }

    public long getAggregatetimeoriginalestimate() {
        return _aggregatetimeoriginalestimate;
    }

    public void setAggregatetimeoriginalestimate(
        long aggregatetimeoriginalestimate) {
        _aggregatetimeoriginalestimate = aggregatetimeoriginalestimate;
    }

    public long getAggregatetimeestimate() {
        return _aggregatetimeestimate;
    }

    public void setAggregatetimeestimate(long aggregatetimeestimate) {
        _aggregatetimeestimate = aggregatetimeestimate;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    public long getStorypoints() {
        return _storypoints;
    }

    public void setStorypoints(long storypoints) {
        _storypoints = storypoints;
    }

    public String getCreatorId() {
        return _creatorId;
    }

    public void setCreatorId(String creatorId) {
        _creatorId = creatorId;
    }

    public String getAssigneeId() {
        return _assigneeId;
    }

    public void setAssigneeId(String assigneeId) {
        _assigneeId = assigneeId;
    }

    public long getStatusId() {
        return _statusId;
    }

    public void setStatusId(long statusId) {
        _statusId = statusId;
    }
}
