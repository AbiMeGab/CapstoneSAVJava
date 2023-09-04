package university.jala.sav;

import java.util.List;

public class InsertionSort extends BaseSortingAlgorithm {
    private String orderingType;
    private String speed;
    private static final int NANOSECONDS = 1000000;

    public InsertionSort(List<ComparatorIndex> list, String orderingType, String speed) {
        super(list);
        this.orderingType = orderingType;
        this.speed = speed;
    }

    @Override
    public void sort() throws InterruptedException {
        long startTime = System.nanoTime();
        int iteraciones = 0;
        for (int index = 1; index < this.list.size(); index++) {
            int pointer = index - 1;

            ComparatorIndex element2 = this.list.get(index);

            while (pointer >= 0 && this.list.get(pointer).getValue() > element2.getValue()) {
                this.list.set(pointer + 1, this.list.get(pointer));
                pointer--;
            }
            this.list.set(pointer + 1, element2);
            iteraciones++;
            ConsolePrinter.sortingList(iteraciones, list);
            Thread.sleep(Long.parseLong(speed));
        }
        ConsolePrinter.inverseConsolePrinter(orderingType, iteraciones, list);
        ConsolePrinter.printSortingType("Algoritmo: Ordenamiento de Inserción");

        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime - Long.parseLong(speed);

        System.out.println("Tiempo total: " + timeElapsed / NANOSECONDS + " ms");
    }
}
