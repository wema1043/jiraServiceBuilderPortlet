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
    public String issueId;
    public String projectId;
    public String key;
    public String self;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(9);

        sb.append("{issueId=");
        sb.append(issueId);
        sb.append(", projectId=");
        sb.append(projectId);
        sb.append(", key=");
        sb.append(key);
        sb.append(", self=");
        sb.append(self);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Issue toEntityModel() {
        IssueImpl issueImpl = new IssueImpl();

        if (issueId == null) {
            issueImpl.setIssueId(StringPool.BLANK);
        } else {
            issueImpl.setIssueId(issueId);
        }

        if (projectId == null) {
            issueImpl.setProjectId(StringPool.BLANK);
        } else {
            issueImpl.setProjectId(projectId);
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

        issueImpl.resetOriginalValues();

        return issueImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        issueId = objectInput.readUTF();
        projectId = objectInput.readUTF();
        key = objectInput.readUTF();
        self = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        if (issueId == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(issueId);
        }

        if (projectId == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(projectId);
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
    }
}
