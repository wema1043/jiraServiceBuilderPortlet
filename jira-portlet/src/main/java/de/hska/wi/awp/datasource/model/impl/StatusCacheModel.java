package de.hska.wi.awp.datasource.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import de.hska.wi.awp.datasource.model.Status;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Status in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Status
 * @generated
 */
public class StatusCacheModel implements CacheModel<Status>, Externalizable {
    public long statusId;
    public String name;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(5);

        sb.append("{statusId=");
        sb.append(statusId);
        sb.append(", name=");
        sb.append(name);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Status toEntityModel() {
        StatusImpl statusImpl = new StatusImpl();

        statusImpl.setStatusId(statusId);

        if (name == null) {
            statusImpl.setName(StringPool.BLANK);
        } else {
            statusImpl.setName(name);
        }

        statusImpl.resetOriginalValues();

        return statusImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        statusId = objectInput.readLong();
        name = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(statusId);

        if (name == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(name);
        }
    }
}
