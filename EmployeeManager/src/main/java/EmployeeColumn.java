import java.util.Arrays;

public enum EmployeeColumn {
    EMPLOYEENUM, NAME, CL, PHONENUM, BIRTHDAY, CERTI;

    public static EmployeeColumn getType(String str){
        return Arrays.stream(values()).filter(k -> str.equalsIgnoreCase(k.toString())).findAny().orElse(null);
    }
}
