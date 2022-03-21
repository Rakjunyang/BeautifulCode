public abstract class NoneExistsResultMaker implements ResultMaker {

    String getNoneResult(String operatorName) {
        return operatorName + ",NONE";
    }

}
