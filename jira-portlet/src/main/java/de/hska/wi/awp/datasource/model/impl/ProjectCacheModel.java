package de.hska.wi.awp.datasource.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import de.hska.wi.awp.datasource.model.Project;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Project in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Project
 * @generated
 */
public class ProjectCacheModel implements CacheModel<Project>, Externalizable {
    public String projectId;
    public String key;
    public String name;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(7);

        sb.append("{projectId=");
        sb.append(projectId);
        sb.append(", key=");
        sb.append(key);
        sb.append(", name=");
        sb.append(name);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Project toEntityModel() {
        ProjectImpl projectImpl = new ProjectImpl();

        if (projectId == null) {
            projectImpl.setProjectId(StringPool.BLANK);
        } else {
            projectImpl.setProjectId(projectId);
        }

        if (key == null) {
            projectImpl.setKey(StringPool.BLANK);
        } else {
            projectImpl.setKey(key);
        }

        if (name == null) {
            projectImpl.setName(StringPool.BLANK);
        } else {
            projectImpl.setName(name);
        }

        projectImpl.resetOriginalValues();

        return projectImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        projectId = objectInput.readUTF();
        key = objectInput.readUTF();
        name = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
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

        if (name == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(name);
        }
    }
}
