package de.hska.wi.awp.datasource.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import de.hska.wi.awp.datasource.model.IssuePriority;
import de.hska.wi.awp.datasource.model.IssuePriorityModel;
import de.hska.wi.awp.datasource.model.IssuePrioritySoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the IssuePriority service. Represents a row in the &quot;jira_IssuePriority&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link de.hska.wi.awp.datasource.model.IssuePriorityModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link IssuePriorityImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see IssuePriorityImpl
 * @see de.hska.wi.awp.datasource.model.IssuePriority
 * @see de.hska.wi.awp.datasource.model.IssuePriorityModel
 * @generated
 */
@JSON(strict = true)
public class IssuePriorityModelImpl extends BaseModelImpl<IssuePriority>
    implements IssuePriorityModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a issue priority model instance should use the {@link de.hska.wi.awp.datasource.model.IssuePriority} interface instead.
     */
    public static final String TABLE_NAME = "jira_IssuePriority";
    public static final Object[][] TABLE_COLUMNS = {
            { "priorityId", Types.BIGINT },
            { "priorityName", Types.VARCHAR }
        };
    public static final String TABLE_SQL_CREATE = "create table jira_IssuePriority (priorityId LONG not null primary key,priorityName VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table jira_IssuePriority";
    public static final String ORDER_BY_JPQL = " ORDER BY issuePriority.priorityId ASC";
    public static final String ORDER_BY_SQL = " ORDER BY jira_IssuePriority.priorityId ASC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.de.hska.wi.awp.datasource.model.IssuePriority"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.de.hska.wi.awp.datasource.model.IssuePriority"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = false;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.de.hska.wi.awp.datasource.model.IssuePriority"));
    private static ClassLoader _classLoader = IssuePriority.class.getClassLoader();
    private static Class<?>[] _escapedModelInterfaces = new Class[] {
            IssuePriority.class
        };
    private long _priorityId;
    private String _priorityName;
    private IssuePriority _escapedModel;

    public IssuePriorityModelImpl() {
    }

    /**
     * Converts the soap model instance into a normal model instance.
     *
     * @param soapModel the soap model instance to convert
     * @return the normal model instance
     */
    public static IssuePriority toModel(IssuePrioritySoap soapModel) {
        if (soapModel == null) {
            return null;
        }

        IssuePriority model = new IssuePriorityImpl();

        model.setPriorityId(soapModel.getPriorityId());
        model.setPriorityName(soapModel.getPriorityName());

        return model;
    }

    /**
     * Converts the soap model instances into normal model instances.
     *
     * @param soapModels the soap model instances to convert
     * @return the normal model instances
     */
    public static List<IssuePriority> toModels(IssuePrioritySoap[] soapModels) {
        if (soapModels == null) {
            return null;
        }

        List<IssuePriority> models = new ArrayList<IssuePriority>(soapModels.length);

        for (IssuePrioritySoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    @Override
    public long getPrimaryKey() {
        return _priorityId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setPriorityId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _priorityId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Class<?> getModelClass() {
        return IssuePriority.class;
    }

    @Override
    public String getModelClassName() {
        return IssuePriority.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("priorityId", getPriorityId());
        attributes.put("priorityName", getPriorityName());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long priorityId = (Long) attributes.get("priorityId");

        if (priorityId != null) {
            setPriorityId(priorityId);
        }

        String priorityName = (String) attributes.get("priorityName");

        if (priorityName != null) {
            setPriorityName(priorityName);
        }
    }

    @JSON
    @Override
    public long getPriorityId() {
        return _priorityId;
    }

    @Override
    public void setPriorityId(long priorityId) {
        _priorityId = priorityId;
    }

    @JSON
    @Override
    public String getPriorityName() {
        if (_priorityName == null) {
            return StringPool.BLANK;
        } else {
            return _priorityName;
        }
    }

    @Override
    public void setPriorityName(String priorityName) {
        _priorityName = priorityName;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
            IssuePriority.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public IssuePriority toEscapedModel() {
        if (_escapedModel == null) {
            _escapedModel = (IssuePriority) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        IssuePriorityImpl issuePriorityImpl = new IssuePriorityImpl();

        issuePriorityImpl.setPriorityId(getPriorityId());
        issuePriorityImpl.setPriorityName(getPriorityName());

        issuePriorityImpl.resetOriginalValues();

        return issuePriorityImpl;
    }

    @Override
    public int compareTo(IssuePriority issuePriority) {
        long primaryKey = issuePriority.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof IssuePriority)) {
            return false;
        }

        IssuePriority issuePriority = (IssuePriority) obj;

        long primaryKey = issuePriority.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public void resetOriginalValues() {
    }

    @Override
    public CacheModel<IssuePriority> toCacheModel() {
        IssuePriorityCacheModel issuePriorityCacheModel = new IssuePriorityCacheModel();

        issuePriorityCacheModel.priorityId = getPriorityId();

        issuePriorityCacheModel.priorityName = getPriorityName();

        String priorityName = issuePriorityCacheModel.priorityName;

        if ((priorityName != null) && (priorityName.length() == 0)) {
            issuePriorityCacheModel.priorityName = null;
        }

        return issuePriorityCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(5);

        sb.append("{priorityId=");
        sb.append(getPriorityId());
        sb.append(", priorityName=");
        sb.append(getPriorityName());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(10);

        sb.append("<model><model-name>");
        sb.append("de.hska.wi.awp.datasource.model.IssuePriority");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>priorityId</column-name><column-value><![CDATA[");
        sb.append(getPriorityId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>priorityName</column-name><column-value><![CDATA[");
        sb.append(getPriorityName());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}