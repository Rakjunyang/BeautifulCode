import java.util.List;

public interface InputManagerInterface {

    default List<String> getInfos() {
        return null;
    }

    default List<String> getOptions() {
        return null;
    }

    default String getKey() {
        return null;
    }

    default String getValue() {
        return null;
    }

    default String getChgKey() {
        return null;
    }

    default String getChgValue() {
        return null;
    }

}
