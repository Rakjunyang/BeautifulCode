import java.util.List;

public class AddInputManager implements InputManagerInterface {

    List<String> infos;

    public AddInputManager(List<String> data) {
        infos = data.subList(4, 10);
    }

    @Override
    public List<String> getInfos() {
        return null;
    }

    @Override
    public List<String> getOptions() {
        return null;
    }

    @Override
    public String getKey() {
        return null;
    }

    @Override
    public String getValue() {
        return null;
    }

    @Override
    public String getChgKey() {
        return null;
    }

    @Override
    public String getChgValue() {
        return null;
    }
}
