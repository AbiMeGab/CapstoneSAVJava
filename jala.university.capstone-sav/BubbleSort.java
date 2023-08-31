import java.util.Collections;
import java.util.List;

public class BubbleSort extends BaseAlgorithm {
    private String ord;
    private String speed;
    public BubbleSort(List<ComparatorIndex> list, String ord, String speed) {
        super(list); this.ord = ord;
        this.speed = speed;
    }

    @Override
    public void sort() throws InterruptedException {
        long startTime = System.nanoTime();
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
            Thread.sleep(Long.parseLong(speed));
        }
        if ("az".equalsIgnoreCase(ord)){
            System.out.println("Ordenamiento: " + list);
        } else if ("za".equalsIgnoreCase(ord)) {
            Collections.reverse(this.list);
            System.out.println("Ordenamiento: " + list);
        }
        System.out.println("Algoritmo: Ordenamiento Burbuja");

        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        System.out.println("Tiempo total: " + timeElapsed / 1000000 + " ms");
    }
}
