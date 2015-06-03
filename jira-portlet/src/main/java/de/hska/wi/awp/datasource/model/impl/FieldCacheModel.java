package de.hska.wi.awp.datasource.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import de.hska.wi.awp.datasource.model.Field;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Field in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Field
 * @generated
 */
public class FieldCacheModel implements CacheModel<Field>, Externalizable {
    public long fieldId;
    public String createdDate;
    public String resolutionDate;
    public String summary;
    public String updated;
    public String timespent;
    public String timeestimate;
    public String timeoriginalestimate;
    public String aggregatetimespent;
    public String aggregatetimeoriginalestimate;
    public String aggregatetimeestimate;
    public String description;
    public long storypoints;
    public String creatorId;
    public String assigneeId;
    public long statusId;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(33);

        sb.append("{fieldId=");
        sb.append(fieldId);
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

        if (createdDate == null) {
            fieldImpl.setCreatedDate(StringPool.BLANK);
        } else {
            fieldImpl.setCreatedDate(createdDate);
        }

        if (resolutionDate == null) {
            fieldImpl.setResolutionDate(StringPool.BLANK);
        } else {
            fieldImpl.setResolutionDate(resolutionDate);
        }

        if (summary == null) {
            fieldImpl.setSummary(StringPool.BLANK);
        } else {
            fieldImpl.setSummary(summary);
        }

        if (updated == null) {
            fieldImpl.setUpdated(StringPool.BLANK);
        } else {
            fieldImpl.setUpdated(updated);
        }

        if (timespent == null) {
            fieldImpl.setTimespent(StringPool.BLANK);
        } else {
            fieldImpl.setTimespent(timespent);
        }

        if (timeestimate == null) {
            fieldImpl.setTimeestimate(StringPool.BLANK);
        } else {
            fieldImpl.setTimeestimate(timeestimate);
        }

        if (timeoriginalestimate == null) {
            fieldImpl.setTimeoriginalestimate(StringPool.BLANK);
        } else {
            fieldImpl.setTimeoriginalestimate(timeoriginalestimate);
        }

        if (aggregatetimespent == null) {
            fieldImpl.setAggregatetimespent(StringPool.BLANK);
        } else {
            fieldImpl.setAggregatetimespent(aggregatetimespent);
        }

        if (aggregatetimeoriginalestimate == null) {
            fieldImpl.setAggregatetimeoriginalestimate(StringPool.BLANK);
        } else {
            fieldImpl.setAggregatetimeoriginalestimate(aggregatetimeoriginalestimate);
        }

        if (aggregatetimeestimate == null) {
            fieldImpl.setAggregatetimeestimate(StringPool.BLANK);
        } else {
            fieldImpl.setAggregatetimeestimate(aggregatetimeestimate);
        }

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
        createdDate = objectInput.readUTF();
        resolutionDate = objectInput.readUTF();
        summary = objectInput.readUTF();
        updated = objectInput.readUTF();
        timespent = objectInput.readUTF();
        timeestimate = objectInput.readUTF();
        timeoriginalestimate = objectInput.readUTF();
        aggregatetimespent = objectInput.readUTF();
        aggregatetimeoriginalestimate = objectInput.readUTF();
        aggregatetimeestimate = objectInput.readUTF();
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

        if (createdDate == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(createdDate);
        }

        if (resolutionDate == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(resolutionDate);
        }

        if (summary == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(summary);
        }

        if (updated == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(updated);
        }

        if (timespent == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(timespent);
        }

        if (timeestimate == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(timeestimate);
        }

        if (timeoriginalestimate == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(timeoriginalestimate);
        }

        if (aggregatetimespent == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(aggregatetimespent);
        }

        if (aggregatetimeoriginalestimate == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(aggregatetimeoriginalestimate);
        }

        if (aggregatetimeestimate == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(aggregatetimeestimate);
        }

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
