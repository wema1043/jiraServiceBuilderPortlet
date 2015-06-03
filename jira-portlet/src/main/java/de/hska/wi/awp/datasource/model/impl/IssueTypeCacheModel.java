package de.hska.wi.awp.datasource.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import de.hska.wi.awp.datasource.model.IssueType;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing IssueType in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see IssueType
 * @generated
 */
public class IssueTypeCacheModel implements CacheModel<IssueType>,
    Externalizable {
    public long issueId;
    public String issueName;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(5);

        sb.append("{issueId=");
        sb.append(issueId);
        sb.append(", issueName=");
        sb.append(issueName);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public IssueType toEntityModel() {
        IssueTypeImpl issueTypeImpl = new IssueTypeImpl();

        issueTypeImpl.setIssueId(issueId);

        if (issueName == null) {
            issueTypeImpl.setIssueName(StringPool.BLANK);
        } else {
            issueTypeImpl.setIssueName(issueName);
        }

        issueTypeImpl.resetOriginalValues();

        return issueTypeImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        issueId = objectInput.readLong();
        issueName = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(issueId);

        if (issueName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(issueName);
        }
    }
}
