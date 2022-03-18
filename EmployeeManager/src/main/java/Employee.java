import java.util.ArrayList;

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
        if (key == "id") {
            return id;
        }
        if (key == "name") {
            return name;
        }
        if (key == "cl") {
            return cl;
        }
        if (key == "phoneNumber") {
            return phoneNumber;
        }
        if (key == "birthDay") {
            return birthDay;
        }
        return certi;
    }

    public void setValue(String key, String value) {
        if (key == "name") {
            this.name = value;
            return;
        }
        if (key == "cl") {
            this.cl = value;
            return;
        }
        if (key == "phoneNumber") {
            this.phoneNumber = value;
            return;
        }
        if (key == "birthDay") {
            this.birthDay = value;
            return;
        }
        if (key == "certi") {
            this.certi = value;
            return;
        }
        return;
    }
}
