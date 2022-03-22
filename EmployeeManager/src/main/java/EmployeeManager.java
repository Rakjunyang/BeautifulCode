import java.util.ArrayList;
import java.util.Collections;

public class EmployeeManager {

    private ArrayList<Employee> employees = new ArrayList<>();
    private String prevCmd = "-";

    public void add(Employee employee) {
        employees.add(employee);
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void del(int i){
        employees.remove(i);
    }

    public void sort(String cmd) {
        if(prevCmd.equals("ADD") && !cmd.equals("ADD"))
            Collections.sort(employees, new EmployeeComparer());
        prevCmd = cmd;
    }
}
