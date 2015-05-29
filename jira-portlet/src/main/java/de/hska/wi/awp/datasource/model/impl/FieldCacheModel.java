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
    public long createdDate;
    public long resolutionDate;
    public String summary;
    public long updated;
    public long creatorId;
    public long assigneeId;
    public long statusId;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(17);

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

        fieldImpl.setCreatorId(creatorId);
        fieldImpl.setAssigneeId(assigneeId);
        fieldImpl.setStatusId(statusId);

        fieldImpl.resetOriginalValues();

        return fieldImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        fieldId = objectInput.readLong();
        createdDate = objectInput.readLong();
        resolutionDate = objectInput.readLong();
        summary = objectInput.readUTF();
        updated = objectInput.readLong();
        creatorId = objectInput.readLong();
        assigneeId = objectInput.readLong();
        statusId = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(fieldId);
        objectOutput.writeLong(createdDate);
        objectOutput.writeLong(resolutionDate);

        if (summary == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(summary);
        }

        objectOutput.writeLong(updated);
        objectOutput.writeLong(creatorId);
        objectOutput.writeLong(assigneeId);
        objectOutput.writeLong(statusId);
    }
}
