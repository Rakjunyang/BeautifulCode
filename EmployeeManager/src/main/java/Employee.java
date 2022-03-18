import java.util.ArrayList;

public class Employee {

    private String id;
    public int sortKey;
    private String name;
    private String firstName;
    private String lastName;
    private String cl;
    private String phoneNumber;
    private String firstNumber;
    private String midNumber;
    private String lastNumber;
    private String birthDay;
    private String certi;

    public Employee(String id, String name, String firstName, String lastName,
        String cl, String phoneNumber, String firstNumber, String midNumber,
        String lastNumber, String birthDay, String certi) {
        this.id = id;
        this.sortKey = Integer.parseInt(id.substring(0, 2)) < 30 ? 2000000000 + Integer.parseInt(id) :  1900000000 + Integer.parseInt(id);
        this.name = name;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cl = cl;
        this.phoneNumber = phoneNumber;
        this.firstNumber = firstNumber;
        this.midNumber = midNumber;
        this.lastNumber = lastNumber;
        this.birthDay = birthDay;
        this.certi = certi;
    }


    public String getValue(String key){
        if(key == "id"){
            return id;
        }
        if(key == "name"){
            return name;
        }
        if(key == "firstName"){
            return firstName;
        }
        if(key == "lastName"){
            return lastName;
        }
        if(key == "cl"){
            return cl;
        }
        if(key == "phoneNumber"){
            return phoneNumber;
        }
        if(key == "firstNumber"){
            return firstNumber;
        }
        if(key == "midNumber"){
            return midNumber;
        }
        if(key == "lastNumber"){
            return lastNumber;
        }
        if(key == "birthDay"){
            return birthDay;
        }
        return certi;
    }
}
