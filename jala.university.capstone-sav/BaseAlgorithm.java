import java.util.List;

public abstract class BaseAlgorithm {

    List<ComparatorIndex> list;
    public BaseAlgorithm(List<ComparatorIndex> list){
        this.list = list;
    }
    public abstract void sort() throws InterruptedException;
}