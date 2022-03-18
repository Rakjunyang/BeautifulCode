import java.util.ArrayList;
import java.util.Collections;

public class EmployeeManager {

    private ArrayList<Employee> employees = new ArrayList<>();

    public void add(Employee employee) {
        employees.add(employee);
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void del(int i){
        employees.remove(i);
    }

    public void sort() {
        Collections.sort(employees, new EmployeeComparer());
    }
}
