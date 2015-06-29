package de.hska.wi.awp.datasource.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import de.hska.wi.awp.datasource.model.JiraUser;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing JiraUser in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see JiraUser
 * @generated
 */
public class JiraUserCacheModel implements CacheModel<JiraUser>, Externalizable {
    public String creatorId;
    public String displayname;
    public String groupId;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(7);

        sb.append("{creatorId=");
        sb.append(creatorId);
        sb.append(", displayname=");
        sb.append(displayname);
        sb.append(", groupId=");
        sb.append(groupId);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public JiraUser toEntityModel() {
        JiraUserImpl jiraUserImpl = new JiraUserImpl();

        if (creatorId == null) {
            jiraUserImpl.setCreatorId(StringPool.BLANK);
        } else {
            jiraUserImpl.setCreatorId(creatorId);
        }

        if (displayname == null) {
            jiraUserImpl.setDisplayname(StringPool.BLANK);
        } else {
            jiraUserImpl.setDisplayname(displayname);
        }

        if (groupId == null) {
            jiraUserImpl.setGroupId(StringPool.BLANK);
        } else {
            jiraUserImpl.setGroupId(groupId);
        }

        jiraUserImpl.resetOriginalValues();

        return jiraUserImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        creatorId = objectInput.readUTF();
        displayname = objectInput.readUTF();
        groupId = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        if (creatorId == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(creatorId);
        }

        if (displayname == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(displayname);
        }

        if (groupId == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(groupId);
        }
    }
}
