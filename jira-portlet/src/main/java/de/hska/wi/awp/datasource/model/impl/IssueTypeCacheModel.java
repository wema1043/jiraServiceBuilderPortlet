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
    public long issueTypeId;
    public String typeName;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(5);

        sb.append("{issueTypeId=");
        sb.append(issueTypeId);
        sb.append(", typeName=");
        sb.append(typeName);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public IssueType toEntityModel() {
        IssueTypeImpl issueTypeImpl = new IssueTypeImpl();

        issueTypeImpl.setIssueTypeId(issueTypeId);

        if (typeName == null) {
            issueTypeImpl.setTypeName(StringPool.BLANK);
        } else {
            issueTypeImpl.setTypeName(typeName);
        }

        issueTypeImpl.resetOriginalValues();

        return issueTypeImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        issueTypeId = objectInput.readLong();
        typeName = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(issueTypeId);

        if (typeName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(typeName);
        }
    }
}
