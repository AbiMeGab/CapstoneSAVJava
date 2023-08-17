import java.util.List;

public abstract class AlgoritmoBase {

    List<Object> list;
    public AlgoritmoBase(List<Object> list){
        this.list = list;
    }
    public abstract void ordenar();
}