public abstract class DefaultOperator implements Operator {

    private String operatorName;

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getMatchedString(Employee employee) {
        return this.operatorName + "," + employee.getValue("id") + "," + employee.getValue("NAME")
            + ","
            + employee.getValue("CL") + "," + employee.getValue("PHONENUMBER") + ","
            + employee.getValue(
            "BIRTHDAY") + "," + employee.getValue("CERTI");
    }
}
