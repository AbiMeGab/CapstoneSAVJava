import java.util.ArrayList;
import java.util.List;

public abstract class AlgoritmoBase {

    List<Object> list = new ArrayList<>();
    public AlgoritmoBase(List<Object> list){

        this.list = list;
    }
    public abstract void ordenar();

}

