import java.util.ArrayList;

public class ResultMakerFactory {

    public ResultMaker getResultMaker(ArrayList<Boolean> pOption, FileManager fileManager){
        if(pOption.get(0)){
            return new POptionResultMaker(fileManager);
        }
        if(!pOption.get(0)){
            return new NormalResultMaker(fileManager);
        }
        return null;
    }
}
