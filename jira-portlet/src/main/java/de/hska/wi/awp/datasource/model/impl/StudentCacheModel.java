package de.hska.wi.awp.datasource.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import de.hska.wi.awp.datasource.model.Student;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Student in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Student
 * @generated
 */
public class StudentCacheModel implements CacheModel<Student>, Externalizable {
    public long studentId;
    public String firstName;
    public String lastName;
    public int studentAge;
    public int studentGender;
    public String studentAddress;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(13);

        sb.append("{studentId=");
        sb.append(studentId);
        sb.append(", firstName=");
        sb.append(firstName);
        sb.append(", lastName=");
        sb.append(lastName);
        sb.append(", studentAge=");
        sb.append(studentAge);
        sb.append(", studentGender=");
        sb.append(studentGender);
        sb.append(", studentAddress=");
        sb.append(studentAddress);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Student toEntityModel() {
        StudentImpl studentImpl = new StudentImpl();

        studentImpl.setStudentId(studentId);

        if (firstName == null) {
            studentImpl.setFirstName(StringPool.BLANK);
        } else {
            studentImpl.setFirstName(firstName);
        }

        if (lastName == null) {
            studentImpl.setLastName(StringPool.BLANK);
        } else {
            studentImpl.setLastName(lastName);
        }

        studentImpl.setStudentAge(studentAge);
        studentImpl.setStudentGender(studentGender);

        if (studentAddress == null) {
            studentImpl.setStudentAddress(StringPool.BLANK);
        } else {
            studentImpl.setStudentAddress(studentAddress);
        }

        studentImpl.resetOriginalValues();

        return studentImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        studentId = objectInput.readLong();
        firstName = objectInput.readUTF();
        lastName = objectInput.readUTF();
        studentAge = objectInput.readInt();
        studentGender = objectInput.readInt();
        studentAddress = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(studentId);

        if (firstName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(firstName);
        }

        if (lastName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(lastName);
        }

        objectOutput.writeInt(studentAge);
        objectOutput.writeInt(studentGender);

        if (studentAddress == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(studentAddress);
        }
    }
}
