public abstract class DefaultOperator implements Operator {

    private String operatorName;

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getMatchedString(Employee employee) {
        return this.operatorName + "," + employee.getValue(EmployeeColumn.EMPLOYEENUM) + ","
            + employee.getValue(EmployeeColumn.NAME) + "," + employee.getValue(EmployeeColumn.CL)
            + "," + employee.getValue(EmployeeColumn.PHONENUM) + "," + employee.getValue(
            EmployeeColumn.BIRTHDAY) + "," + employee.getValue(EmployeeColumn.CERTI);
    }
}