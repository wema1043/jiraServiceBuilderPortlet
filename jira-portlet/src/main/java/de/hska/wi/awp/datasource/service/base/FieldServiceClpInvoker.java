package de.hska.wi.awp.datasource.service.base;

import de.hska.wi.awp.datasource.service.FieldServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FieldServiceClpInvoker {
    private String _methodName42;
    private String[] _methodParameterTypes42;
    private String _methodName43;
    private String[] _methodParameterTypes43;

    public FieldServiceClpInvoker() {
        _methodName42 = "getBeanIdentifier";

        _methodParameterTypes42 = new String[] {  };

        _methodName43 = "setBeanIdentifier";

        _methodParameterTypes43 = new String[] { "java.lang.String" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName42.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes42, parameterTypes)) {
            return FieldServiceUtil.getBeanIdentifier();
        }

        if (_methodName43.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes43, parameterTypes)) {
            FieldServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        throw new UnsupportedOperationException();
    }
}
