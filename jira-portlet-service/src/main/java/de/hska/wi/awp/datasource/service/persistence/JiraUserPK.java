package de.hska.wi.awp.datasource.service.persistence;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class JiraUserPK implements Comparable<JiraUserPK>, Serializable {
    public String creatorId;
    public String groupId;

    public JiraUserPK() {
    }

    public JiraUserPK(String creatorId, String groupId) {
        this.creatorId = creatorId;
        this.groupId = groupId;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    @Override
    public int compareTo(JiraUserPK pk) {
        if (pk == null) {
            return -1;
        }

        int value = 0;

        value = creatorId.compareTo(pk.creatorId);

        if (value != 0) {
            return value;
        }

        value = groupId.compareTo(pk.groupId);

        if (value != 0) {
            return value;
        }

        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof JiraUserPK)) {
            return false;
        }

        JiraUserPK pk = (JiraUserPK) obj;

        if ((creatorId.equals(pk.creatorId)) && (groupId.equals(pk.groupId))) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (String.valueOf(creatorId) + String.valueOf(groupId)).hashCode();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(10);

        sb.append(StringPool.OPEN_CURLY_BRACE);

        sb.append("creatorId");
        sb.append(StringPool.EQUAL);
        sb.append(creatorId);

        sb.append(StringPool.COMMA);
        sb.append(StringPool.SPACE);
        sb.append("groupId");
        sb.append(StringPool.EQUAL);
        sb.append(groupId);

        sb.append(StringPool.CLOSE_CURLY_BRACE);

        return sb.toString();
    }
}
