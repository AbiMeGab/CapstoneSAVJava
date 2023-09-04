package university.jala.sav;

import java.util.List;

public abstract class BaseSortingAlgorithm {

    protected List<ComparatorIndex> list;

    public BaseSortingAlgorithm(List<ComparatorIndex> list) {
        this.list = list;
    }

    public abstract void sort() throws InterruptedException;
}