import java.util.ArrayList;
import java.util.Locale;

public class Employee {

    private String id;
    public int sortKey;
    private String name;
    private String cl;
    private String phoneNum;
    private String birthDay;
    private String certi;

    public Employee(String id, String name, String cl, String phoneNum, String birthDay, String certi) {
        this.id = id;
        this.sortKey = Integer.parseInt(id.substring(0, 2)) < 30 ? 2000000000 + Integer.parseInt(id)
            : 1900000000 + Integer.parseInt(id);
        this.name = name;
        this.cl = cl;
        this.phoneNum = phoneNum;
        this.birthDay = birthDay;
        this.certi = certi;
    }


    public String getValue(EmployeeColumn key) {
        if (key.equals(EmployeeColumn.ID)) {
            return id;
        }
        if (key.equals(EmployeeColumn.NAME)) {
            return name;
        }
        if (key.equals(EmployeeColumn.CL)) {
            return cl;
        }
        if (key.equals(EmployeeColumn.PHONENUM)) {
            return phoneNum;
        }
        if (key.equals(EmployeeColumn.BIRTHDAY)) {
            return birthDay;
        }
        if (key.equals(EmployeeColumn.CERTI)) {
            return certi;
        }
        return null;
    }

    public void setValue(EmployeeColumn key, String value) {
        if (key.equals(EmployeeColumn.NAME)) {
            this.name = value;
            return;
        }
        if (key.equals(EmployeeColumn.CL)) {
            this.cl = value;
            return;
        }
        if (key.equals(EmployeeColumn.PHONENUM)) {
            this.phoneNum = value;
            return;
        }
        if (key.equals(EmployeeColumn.BIRTHDAY)) {
            this.birthDay = value;
            return;
        }
        if (key.equals(EmployeeColumn.CERTI)) {
            this.certi = value;
            return;
        }
        return;
    }
}
