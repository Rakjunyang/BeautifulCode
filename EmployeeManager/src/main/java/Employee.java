import java.util.ArrayList;
import java.util.Locale;

public class Employee {

    private String id;
    public int sortKey;
    private String name;
    private String cl;
    private String phoneNumber;
    private String birthDay;
    private String certi;

    public Employee(String id, String name, String cl, String phoneNumber, String birthDay, String certi) {
        this.id = id;
        this.sortKey = Integer.parseInt(id.substring(0, 2)) < 30 ? 2000000000 + Integer.parseInt(id)
            : 1900000000 + Integer.parseInt(id);
        this.name = name;
        this.cl = cl;
        this.phoneNumber = phoneNumber;
        this.birthDay = birthDay;
        this.certi = certi;
    }


    public String getValue(String key) {
        if (key.equalsIgnoreCase("id")) {
            return id;
        }
        if (key.equalsIgnoreCase("NAME")) {
            return name;
        }
        if (key.equalsIgnoreCase("CL")) {
            return cl;
        }
        if (key.equalsIgnoreCase( "PHONENUMBER")) {
            return phoneNumber;
        }
        if (key.equalsIgnoreCase("BIRTHDAY")) {
            return birthDay;
        }
        if (key.equalsIgnoreCase("CERTI")) {
            return certi;
        }
        return null;
    }

    public void setValue(String key, String value) {
        if (key.equalsIgnoreCase("NAME")) {
            this.name = value;
            return;
        }
        if (key.equalsIgnoreCase("CL")) {
            this.cl = value;
            return;
        }
        if (key.equalsIgnoreCase("PHONENUMBER")) {
            this.phoneNumber = value;
            return;
        }
        if (key.equalsIgnoreCase( "BIRTHDAY")) {
            this.birthDay = value;
            return;
        }
        if (key.equalsIgnoreCase("CERTI")) {
            this.certi = value;
            return;
        }
        return;
    }
}
