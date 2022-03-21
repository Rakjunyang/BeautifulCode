import java.util.List;

public interface InputManagerInterface {
    List<String> getInfos();

    List<String> getOptions();

    String getKey();

    String getValue();

    String getChgKey();

    String getChgValue();
}
