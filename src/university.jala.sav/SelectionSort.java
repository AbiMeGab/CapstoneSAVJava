package university.jala.sav;

import java.util.Collections;
import java.util.List;

public class SelectionSort extends BaseSortingAlgorithm {
    private final String speed;
    private String orderingType;
    private static final int NANOSECONDS = 1000000;

    public SelectionSort(List<ComparatorIndex> list, String orderingType, String speed) {
        super(list);
        this.orderingType = orderingType;
        this.speed = speed;
    }

    @Override
    public void sort() throws InterruptedException {
        long startTime = System.nanoTime();
        int iteraciones = 0;
        for (int index = 0; index < this.list.size() - 1; index++) {
            int minIndex = index;

            for (int pointer = index + 1; pointer < this.list.size(); pointer++) {
                ComparatorIndex element1 = this.list.get(pointer);
                ComparatorIndex element2 = this.list.get(minIndex);

                if (element1.getValue() < element2.getValue()) {
                    minIndex = pointer;
                }
            }

            if (minIndex != index) {
                ComparatorIndex temp = this.list.get(index);
                this.list.set(index, this.list.get(minIndex));
                this.list.set(minIndex, temp);
            }
            iteraciones++;
            ConsolePrinter.sortingList(iteraciones, list);
            Thread.sleep(Long.parseLong(speed));
        }
        ConsolePrinter.inverseConsolePrinter(orderingType, iteraciones, list);
        ConsolePrinter.printSortingType("Algoritmo: Ordenamiento de Selección");

        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime - Long.parseLong(speed);

        System.out.println("Tiempo total: " + timeElapsed / NANOSECONDS + " ms");
    }
}
