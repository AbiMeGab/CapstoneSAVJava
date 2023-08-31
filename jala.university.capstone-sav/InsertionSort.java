import java.util.Collections;
import java.util.List;

public class InsertionSort extends BaseAlgorithm {
    private String ord;
    String speed;

    public InsertionSort(List<ComparatorIndex> list, String ord, String speed) {
        super(list); this.ord = ord; this.speed = speed;
    }

    @Override
    public void sort() throws InterruptedException {
        long startTime = System.nanoTime();
        for (int index = 1; index < this.list.size(); index++) {
            int pointer = index - 1;

            ComparatorIndex element2 = this.list.get(index);

            while (pointer >= 0 && this.list.get(pointer).getValue() > element2.getValue()) {
                this.list.set(pointer + 1, this.list.get(pointer));
                pointer--;
            }
            this.list.set(pointer + 1, element2);
            Thread.sleep(Long.parseLong(speed));
        }
            if ("az".equalsIgnoreCase(ord)){
             System.out.println("Ordenamiento: " + list);
              } else if ("za".equalsIgnoreCase(ord)) {
                 Collections.reverse(this.list);
                 System.out.println("Ordenamiento: " + list);
        }
        System.out.println("Algoritmo: Ordenamiento de Inserción");

        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        System.out.println("Tiempo total: " + timeElapsed / 1000000 + " ms");
    }
}
