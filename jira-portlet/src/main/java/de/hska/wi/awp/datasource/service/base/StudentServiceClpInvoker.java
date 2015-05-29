package de.hska.wi.awp.datasource.service.base;

import de.hska.wi.awp.datasource.service.StudentServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class StudentServiceClpInvoker {
    private String _methodName42;
    private String[] _methodParameterTypes42;
    private String _methodName43;
    private String[] _methodParameterTypes43;

    public StudentServiceClpInvoker() {
        _methodName42 = "getBeanIdentifier";

        _methodParameterTypes42 = new String[] {  };

        _methodName43 = "setBeanIdentifier";

        _methodParameterTypes43 = new String[] { "java.lang.String" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName42.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes42, parameterTypes)) {
            return StudentServiceUtil.getBeanIdentifier();
        }

        if (_methodName43.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes43, parameterTypes)) {
            StudentServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        throw new UnsupportedOperationException();
    }
}
