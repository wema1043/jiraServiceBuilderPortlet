package de.hska.wi.awp.datasource.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import de.hska.wi.awp.datasource.model.IssuePriority;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing IssuePriority in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see IssuePriority
 * @generated
 */
public class IssuePriorityCacheModel implements CacheModel<IssuePriority>,
    Externalizable {
    public long priorityId;
    public String priorityName;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(5);

        sb.append("{priorityId=");
        sb.append(priorityId);
        sb.append(", priorityName=");
        sb.append(priorityName);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public IssuePriority toEntityModel() {
        IssuePriorityImpl issuePriorityImpl = new IssuePriorityImpl();

        issuePriorityImpl.setPriorityId(priorityId);

        if (priorityName == null) {
            issuePriorityImpl.setPriorityName(StringPool.BLANK);
        } else {
            issuePriorityImpl.setPriorityName(priorityName);
        }

        issuePriorityImpl.resetOriginalValues();

        return issuePriorityImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        priorityId = objectInput.readLong();
        priorityName = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(priorityId);

        if (priorityName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(priorityName);
        }
    }
}
