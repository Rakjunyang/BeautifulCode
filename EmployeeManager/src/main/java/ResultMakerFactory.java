import java.util.ArrayList;

public class ResultMakerFactory {

    public ResultMaker getResultMaker(ArrayList<Boolean> pOption){
        if(pOption.get(0)){
            return new POptionResultMaker();
        }
        if(!pOption.get(0)){
            return new NormalResultMaker();
        }
        return null;
    }
}
