package de.hska.wi.awp.datasource.service.base;

import de.hska.wi.awp.datasource.service.JiraUserLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class JiraUserLocalServiceClpInvoker {
    private String _methodName0;
    private String[] _methodParameterTypes0;
    private String _methodName1;
    private String[] _methodParameterTypes1;
    private String _methodName2;
    private String[] _methodParameterTypes2;
    private String _methodName3;
    private String[] _methodParameterTypes3;
    private String _methodName4;
    private String[] _methodParameterTypes4;
    private String _methodName5;
    private String[] _methodParameterTypes5;
    private String _methodName6;
    private String[] _methodParameterTypes6;
    private String _methodName7;
    private String[] _methodParameterTypes7;
    private String _methodName8;
    private String[] _methodParameterTypes8;
    private String _methodName9;
    private String[] _methodParameterTypes9;
    private String _methodName10;
    private String[] _methodParameterTypes10;
    private String _methodName11;
    private String[] _methodParameterTypes11;
    private String _methodName12;
    private String[] _methodParameterTypes12;
    private String _methodName13;
    private String[] _methodParameterTypes13;
    private String _methodName14;
    private String[] _methodParameterTypes14;
    private String _methodName15;
    private String[] _methodParameterTypes15;
    private String _methodName70;
    private String[] _methodParameterTypes70;
    private String _methodName71;
    private String[] _methodParameterTypes71;
    private String _methodName76;
    private String[] _methodParameterTypes76;
    private String _methodName77;
    private String[] _methodParameterTypes77;
    private String _methodName78;
    private String[] _methodParameterTypes78;
    private String _methodName79;
    private String[] _methodParameterTypes79;
    private String _methodName80;
    private String[] _methodParameterTypes80;
    private String _methodName81;
    private String[] _methodParameterTypes81;

    public JiraUserLocalServiceClpInvoker() {
        _methodName0 = "addJiraUser";

        _methodParameterTypes0 = new String[] {
                "de.hska.wi.awp.datasource.model.JiraUser"
            };

        _methodName1 = "createJiraUser";

        _methodParameterTypes1 = new String[] {
                "de.hska.wi.awp.datasource.service.persistence.JiraUserPK"
            };

        _methodName2 = "deleteJiraUser";

        _methodParameterTypes2 = new String[] {
                "de.hska.wi.awp.datasource.service.persistence.JiraUserPK"
            };

        _methodName3 = "deleteJiraUser";

        _methodParameterTypes3 = new String[] {
                "de.hska.wi.awp.datasource.model.JiraUser"
            };

        _methodName4 = "dynamicQuery";

        _methodParameterTypes4 = new String[] {  };

        _methodName5 = "dynamicQuery";

        _methodParameterTypes5 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery"
            };

        _methodName6 = "dynamicQuery";

        _methodParameterTypes6 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
            };

        _methodName7 = "dynamicQuery";

        _methodParameterTypes7 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };

        _methodName8 = "dynamicQueryCount";

        _methodParameterTypes8 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery"
            };

        _methodName9 = "dynamicQueryCount";

        _methodParameterTypes9 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery",
                "com.liferay.portal.kernel.dao.orm.Projection"
            };

        _methodName10 = "fetchJiraUser";

        _methodParameterTypes10 = new String[] {
                "de.hska.wi.awp.datasource.service.persistence.JiraUserPK"
            };

        _methodName11 = "getJiraUser";

        _methodParameterTypes11 = new String[] {
                "de.hska.wi.awp.datasource.service.persistence.JiraUserPK"
            };

        _methodName12 = "getPersistedModel";

        _methodParameterTypes12 = new String[] { "java.io.Serializable" };

        _methodName13 = "getJiraUsers";

        _methodParameterTypes13 = new String[] { "int", "int" };

        _methodName14 = "getJiraUsersCount";

        _methodParameterTypes14 = new String[] {  };

        _methodName15 = "updateJiraUser";

        _methodParameterTypes15 = new String[] {
                "de.hska.wi.awp.datasource.model.JiraUser"
            };

        _methodName70 = "getBeanIdentifier";

        _methodParameterTypes70 = new String[] {  };

        _methodName71 = "setBeanIdentifier";

        _methodParameterTypes71 = new String[] { "java.lang.String" };

        _methodName76 = "getAllMembers";

        _methodParameterTypes76 = new String[] { "java.lang.String" };

        _methodName77 = "ParseJsonToMember";

        _methodParameterTypes77 = new String[] { "java.lang.String" };

        _methodName78 = "getDisplayNameForUserId";

        _methodParameterTypes78 = new String[] { "java.lang.String" };

        _methodName79 = "getProjectNameForUserId";

        _methodParameterTypes79 = new String[] { "java.lang.String" };

        _methodName80 = "deleteAllJiraUser";

        _methodParameterTypes80 = new String[] {  };

        _methodName81 = "loadConfigFile";

        _methodParameterTypes81 = new String[] {  };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return JiraUserLocalServiceUtil.addJiraUser((de.hska.wi.awp.datasource.model.JiraUser) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return JiraUserLocalServiceUtil.createJiraUser((de.hska.wi.awp.datasource.service.persistence.JiraUserPK) arguments[0]);
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return JiraUserLocalServiceUtil.deleteJiraUser((de.hska.wi.awp.datasource.service.persistence.JiraUserPK) arguments[0]);
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return JiraUserLocalServiceUtil.deleteJiraUser((de.hska.wi.awp.datasource.model.JiraUser) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return JiraUserLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return JiraUserLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return JiraUserLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return JiraUserLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return JiraUserLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return JiraUserLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                (com.liferay.portal.kernel.dao.orm.Projection) arguments[1]);
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return JiraUserLocalServiceUtil.fetchJiraUser((de.hska.wi.awp.datasource.service.persistence.JiraUserPK) arguments[0]);
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return JiraUserLocalServiceUtil.getJiraUser((de.hska.wi.awp.datasource.service.persistence.JiraUserPK) arguments[0]);
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return JiraUserLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return JiraUserLocalServiceUtil.getJiraUsers(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return JiraUserLocalServiceUtil.getJiraUsersCount();
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return JiraUserLocalServiceUtil.updateJiraUser((de.hska.wi.awp.datasource.model.JiraUser) arguments[0]);
        }

        if (_methodName70.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes70, parameterTypes)) {
            return JiraUserLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName71.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes71, parameterTypes)) {
            JiraUserLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName76.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes76, parameterTypes)) {
            return JiraUserLocalServiceUtil.getAllMembers((java.lang.String) arguments[0]);
        }

        if (_methodName77.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes77, parameterTypes)) {
            JiraUserLocalServiceUtil.ParseJsonToMember((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName78.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes78, parameterTypes)) {
            return JiraUserLocalServiceUtil.getDisplayNameForUserId((java.lang.String) arguments[0]);
        }

        if (_methodName79.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes79, parameterTypes)) {
            return JiraUserLocalServiceUtil.getProjectNameForUserId((java.lang.String) arguments[0]);
        }

        if (_methodName80.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes80, parameterTypes)) {
            JiraUserLocalServiceUtil.deleteAllJiraUser();

            return null;
        }

        if (_methodName81.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes81, parameterTypes)) {
            return JiraUserLocalServiceUtil.loadConfigFile();
        }

        throw new UnsupportedOperationException();
    }
}
