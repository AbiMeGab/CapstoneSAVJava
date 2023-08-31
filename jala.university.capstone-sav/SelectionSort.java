import java.util.Collections;
import java.util.List;

public class SelectionSort extends BaseAlgorithm {
    private final String speed;
    private String ord;
    public SelectionSort(List<ComparatorIndex> list, String ord, String speed) {
        super(list); this.ord = ord; this.speed = speed;
    }

    @Override
    public void sort() throws InterruptedException {
        long startTime = System.nanoTime();
        for (int index = 0; index < this.list.size() - 1; index++) {
            int minIndex = index;

            for (int pointer = index + 1; pointer < this.list.size(); pointer++) {
                ComparatorIndex element1 = this.list.get(pointer);
                ComparatorIndex element2 = this.list.get(minIndex);

                if (element1.getValue() < element2.getValue()){
                    minIndex = pointer;
                }
            }

            if (minIndex != index) {
                ComparatorIndex temp = this.list.get(index);
                this.list.set(index, this.list.get(minIndex));
                this.list.set(minIndex, temp);
            }
            Thread.sleep(Long.parseLong(speed));
        }
        if ("az".equalsIgnoreCase(ord)){
            System.out.println("Ordenamiento: " + list);
        } else if ("za".equalsIgnoreCase(ord)) {
            Collections.reverse(this.list);
            System.out.println("Ordenamiento: " + list);
        }
        System.out.println("Algoritmo: Ordenamiento de Selección");

        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        System.out.println("Tiempo total: " + timeElapsed / 1000000 + " ms");
    }
}
