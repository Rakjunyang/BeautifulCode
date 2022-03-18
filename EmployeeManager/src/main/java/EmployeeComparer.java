import java.util.Comparator;

public class EmployeeComparer implements Comparator<Employee> {
    @Override
    public int compare(Employee employee1, Employee employee2){
        if(employee1.sortKey > employee2.sortKey)
            return 1;
        return 0;
    }

}
