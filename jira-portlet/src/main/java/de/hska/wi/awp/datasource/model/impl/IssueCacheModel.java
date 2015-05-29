package de.hska.wi.awp.datasource.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import de.hska.wi.awp.datasource.model.Issue;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Issue in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Issue
 * @generated
 */
public class IssueCacheModel implements CacheModel<Issue>, Externalizable {
    public long issueId;
    public String id;
    public String key;
    public String self;
    public long fieldId;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{issueId=");
        sb.append(issueId);
        sb.append(", id=");
        sb.append(id);
        sb.append(", key=");
        sb.append(key);
        sb.append(", self=");
        sb.append(self);
        sb.append(", fieldId=");
        sb.append(fieldId);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Issue toEntityModel() {
        IssueImpl issueImpl = new IssueImpl();

        issueImpl.setIssueId(issueId);

        if (id == null) {
            issueImpl.setId(StringPool.BLANK);
        } else {
            issueImpl.setId(id);
        }

        if (key == null) {
            issueImpl.setKey(StringPool.BLANK);
        } else {
            issueImpl.setKey(key);
        }

        if (self == null) {
            issueImpl.setSelf(StringPool.BLANK);
        } else {
            issueImpl.setSelf(self);
        }

        issueImpl.setFieldId(fieldId);

        issueImpl.resetOriginalValues();

        return issueImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        issueId = objectInput.readLong();
        id = objectInput.readUTF();
        key = objectInput.readUTF();
        self = objectInput.readUTF();
        fieldId = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(issueId);

        if (id == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(id);
        }

        if (key == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(key);
        }

        if (self == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(self);
        }

        objectOutput.writeLong(fieldId);
    }
}
