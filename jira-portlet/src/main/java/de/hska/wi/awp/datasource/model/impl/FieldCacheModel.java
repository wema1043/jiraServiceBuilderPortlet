package de.hska.wi.awp.datasource.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import de.hska.wi.awp.datasource.model.Field;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Field in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Field
 * @generated
 */
public class FieldCacheModel implements CacheModel<Field>, Externalizable {
    public long fieldId;
    public String issueId;
    public long createdDate;
    public long resolutionDate;
    public String summary;
    public long updated;
    public long timespent;
    public long timeestimate;
    public long timeoriginalestimate;
    public long aggregatetimespent;
    public long aggregatetimeoriginalestimate;
    public long aggregatetimeestimate;
    public String description;
    public long storypoints;
    public String creatorId;
    public String assigneeId;
    public long statusId;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(35);

        sb.append("{fieldId=");
        sb.append(fieldId);
        sb.append(", issueId=");
        sb.append(issueId);
        sb.append(", createdDate=");
        sb.append(createdDate);
        sb.append(", resolutionDate=");
        sb.append(resolutionDate);
        sb.append(", summary=");
        sb.append(summary);
        sb.append(", updated=");
        sb.append(updated);
        sb.append(", timespent=");
        sb.append(timespent);
        sb.append(", timeestimate=");
        sb.append(timeestimate);
        sb.append(", timeoriginalestimate=");
        sb.append(timeoriginalestimate);
        sb.append(", aggregatetimespent=");
        sb.append(aggregatetimespent);
        sb.append(", aggregatetimeoriginalestimate=");
        sb.append(aggregatetimeoriginalestimate);
        sb.append(", aggregatetimeestimate=");
        sb.append(aggregatetimeestimate);
        sb.append(", description=");
        sb.append(description);
        sb.append(", storypoints=");
        sb.append(storypoints);
        sb.append(", creatorId=");
        sb.append(creatorId);
        sb.append(", assigneeId=");
        sb.append(assigneeId);
        sb.append(", statusId=");
        sb.append(statusId);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Field toEntityModel() {
        FieldImpl fieldImpl = new FieldImpl();

        fieldImpl.setFieldId(fieldId);

        if (issueId == null) {
            fieldImpl.setIssueId(StringPool.BLANK);
        } else {
            fieldImpl.setIssueId(issueId);
        }

        if (createdDate == Long.MIN_VALUE) {
            fieldImpl.setCreatedDate(null);
        } else {
            fieldImpl.setCreatedDate(new Date(createdDate));
        }

        if (resolutionDate == Long.MIN_VALUE) {
            fieldImpl.setResolutionDate(null);
        } else {
            fieldImpl.setResolutionDate(new Date(resolutionDate));
        }

        if (summary == null) {
            fieldImpl.setSummary(StringPool.BLANK);
        } else {
            fieldImpl.setSummary(summary);
        }

        if (updated == Long.MIN_VALUE) {
            fieldImpl.setUpdated(null);
        } else {
            fieldImpl.setUpdated(new Date(updated));
        }

        fieldImpl.setTimespent(timespent);
        fieldImpl.setTimeestimate(timeestimate);
        fieldImpl.setTimeoriginalestimate(timeoriginalestimate);
        fieldImpl.setAggregatetimespent(aggregatetimespent);
        fieldImpl.setAggregatetimeoriginalestimate(aggregatetimeoriginalestimate);
        fieldImpl.setAggregatetimeestimate(aggregatetimeestimate);

        if (description == null) {
            fieldImpl.setDescription(StringPool.BLANK);
        } else {
            fieldImpl.setDescription(description);
        }

        fieldImpl.setStorypoints(storypoints);

        if (creatorId == null) {
            fieldImpl.setCreatorId(StringPool.BLANK);
        } else {
            fieldImpl.setCreatorId(creatorId);
        }

        if (assigneeId == null) {
            fieldImpl.setAssigneeId(StringPool.BLANK);
        } else {
            fieldImpl.setAssigneeId(assigneeId);
        }

        fieldImpl.setStatusId(statusId);

        fieldImpl.resetOriginalValues();

        return fieldImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        fieldId = objectInput.readLong();
        issueId = objectInput.readUTF();
        createdDate = objectInput.readLong();
        resolutionDate = objectInput.readLong();
        summary = objectInput.readUTF();
        updated = objectInput.readLong();
        timespent = objectInput.readLong();
        timeestimate = objectInput.readLong();
        timeoriginalestimate = objectInput.readLong();
        aggregatetimespent = objectInput.readLong();
        aggregatetimeoriginalestimate = objectInput.readLong();
        aggregatetimeestimate = objectInput.readLong();
        description = objectInput.readUTF();
        storypoints = objectInput.readLong();
        creatorId = objectInput.readUTF();
        assigneeId = objectInput.readUTF();
        statusId = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(fieldId);

        if (issueId == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(issueId);
        }

        objectOutput.writeLong(createdDate);
        objectOutput.writeLong(resolutionDate);

        if (summary == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(summary);
        }

        objectOutput.writeLong(updated);
        objectOutput.writeLong(timespent);
        objectOutput.writeLong(timeestimate);
        objectOutput.writeLong(timeoriginalestimate);
        objectOutput.writeLong(aggregatetimespent);
        objectOutput.writeLong(aggregatetimeoriginalestimate);
        objectOutput.writeLong(aggregatetimeestimate);

        if (description == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(description);
        }

        objectOutput.writeLong(storypoints);

        if (creatorId == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(creatorId);
        }

        if (assigneeId == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(assigneeId);
        }

        objectOutput.writeLong(statusId);
    }
}
