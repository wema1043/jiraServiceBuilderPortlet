package de.hska.wi.awp.datasource.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import de.hska.wi.awp.datasource.service.ClpSerializer;
import de.hska.wi.awp.datasource.service.IssueTypeLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class IssueTypeClp extends BaseModelImpl<IssueType> implements IssueType {
    private String _issueId;
    private String _issueName;
    private BaseModel<?> _issueTypeRemoteModel;
    private Class<?> _clpSerializerClass = de.hska.wi.awp.datasource.service.ClpSerializer.class;

    public IssueTypeClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return IssueType.class;
    }

    @Override
    public String getModelClassName() {
        return IssueType.class.getName();
    }

    @Override
    public String getPrimaryKey() {
        return _issueId;
    }

    @Override
    public void setPrimaryKey(String primaryKey) {
        setIssueId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _issueId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey((String) primaryKeyObj);
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("issueId", getIssueId());
        attributes.put("issueName", getIssueName());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        String issueId = (String) attributes.get("issueId");

        if (issueId != null) {
            setIssueId(issueId);
        }

        String issueName = (String) attributes.get("issueName");

        if (issueName != null) {
            setIssueName(issueName);
        }
    }

    @Override
    public String getIssueId() {
        return _issueId;
    }

    @Override
    public void setIssueId(String issueId) {
        _issueId = issueId;

        if (_issueTypeRemoteModel != null) {
            try {
                Class<?> clazz = _issueTypeRemoteModel.getClass();

                Method method = clazz.getMethod("setIssueId", String.class);

                method.invoke(_issueTypeRemoteModel, issueId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getIssueName() {
        return _issueName;
    }

    @Override
    public void setIssueName(String issueName) {
        _issueName = issueName;

        if (_issueTypeRemoteModel != null) {
            try {
                Class<?> clazz = _issueTypeRemoteModel.getClass();

                Method method = clazz.getMethod("setIssueName", String.class);

                method.invoke(_issueTypeRemoteModel, issueName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getIssueTypeRemoteModel() {
        return _issueTypeRemoteModel;
    }

    public void setIssueTypeRemoteModel(BaseModel<?> issueTypeRemoteModel) {
        _issueTypeRemoteModel = issueTypeRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _issueTypeRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_issueTypeRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            IssueTypeLocalServiceUtil.addIssueType(this);
        } else {
            IssueTypeLocalServiceUtil.updateIssueType(this);
        }
    }

    @Override
    public IssueType toEscapedModel() {
        return (IssueType) ProxyUtil.newProxyInstance(IssueType.class.getClassLoader(),
            new Class[] { IssueType.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        IssueTypeClp clone = new IssueTypeClp();

        clone.setIssueId(getIssueId());
        clone.setIssueName(getIssueName());

        return clone;
    }

    @Override
    public int compareTo(IssueType issueType) {
        String primaryKey = issueType.getPrimaryKey();

        return getPrimaryKey().compareTo(primaryKey);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof IssueTypeClp)) {
            return false;
        }

        IssueTypeClp issueType = (IssueTypeClp) obj;

        String primaryKey = issueType.getPrimaryKey();

        if (getPrimaryKey().equals(primaryKey)) {
            return true;
        } else {
            return false;
        }
    }

    public Class<?> getClpSerializerClass() {
        return _clpSerializerClass;
    }

    @Override
    public int hashCode() {
        return getPrimaryKey().hashCode();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(5);

        sb.append("{issueId=");
        sb.append(getIssueId());
        sb.append(", issueName=");
        sb.append(getIssueName());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(10);

        sb.append("<model><model-name>");
        sb.append("de.hska.wi.awp.datasource.model.IssueType");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>issueId</column-name><column-value><![CDATA[");
        sb.append(getIssueId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>issueName</column-name><column-value><![CDATA[");
        sb.append(getIssueName());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
