package university.jala.sav;

import java.util.List;

public class BubbleSort extends BaseSortingAlgorithm {
    private String orderingType;
    private String speed;
    private static final int NANOSECONDS = 1000000;

    public BubbleSort(List<ComparatorIndex> list, String orderingType, String speed) {
        super(list);
        this.orderingType = orderingType;
        this.speed = speed;
    }

    @Override
    public void sort() throws InterruptedException {
        long startTime = System.nanoTime();
        int iteraciones = 0;
        for (int index = 0; index < this.list.size() - 1; index++) {
            boolean swapped = false;
            for (int pointer = 0; pointer < list.size() - index - 1; pointer++) {
                ComparatorIndex element1 = this.list.get(pointer);
                ComparatorIndex element2 = this.list.get(pointer + 1);

                if (element1.getValue() > element2.getValue()) {
                    this.list.set(pointer, element2);
                    this.list.set(pointer + 1, element1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
            iteraciones++;
            ConsolePrinter.sortingList(iteraciones, list);
            Thread.sleep(Long.parseLong(speed));
        }
        ConsolePrinter.inverseConsolePrinter(orderingType, iteraciones, list);
        ConsolePrinter.printSortingType("Algoritmo: Ordenamiento Burbuja");

        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime - Long.parseLong(speed);

        System.out.println("Tiempo total: " + timeElapsed / NANOSECONDS + " ms");
    }
}
