import java.util.Collections;
import java.util.List;

public class OrdenamientoBurbuja extends AlgoritmoBase {
    private String ord;
    public OrdenamientoBurbuja(List<Object> list, String ord) {
        super(list); this.ord = ord;
    }

    @Override
    public void ordenar() {
        for (int index = 0; index < this.list.size() - 1; index++) {
            boolean swapped = false;
            for (int pointer = 0; pointer < list.size() - index - 1; pointer++) {
                Object element1 = this.list.get(pointer);
                Object element2 = this.list.get(pointer + 1);

                if (compareElements(element1, element2) > 0) {
                    this.list.set(pointer, element2);
                    this.list.set(pointer + 1, element1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        if ("az".equalsIgnoreCase(ord)){
            System.out.println("Ordenamiento: " + list);
        } else if ("za".equalsIgnoreCase(ord)) {
            Collections.reverse(this.list);
            System.out.println("Ordenamiento: " + list);
        }
        System.out.println("Algoritmo: Ordenamiento Burbuja");
    }
    private int compareElements(Object element1, Object element2) throws IllegalArgumentException {
        if (element1 instanceof Integer && element2 instanceof Integer) {
            int comparisonResult = Integer.compare((Integer) element1, (Integer) element2);
            return comparisonResult;
        } else if (element1 instanceof Character && element2 instanceof Character) {
            char letter1 = Character.toLowerCase((Character) element1);
            char letter2 = Character.toLowerCase((Character) element2);
            return Character.compare(letter1, letter2);
        } else if (element1 instanceof String && element2 instanceof String) {
            return ((String) element1).compareTo((String) element2);
        } else if (element1 instanceof Comparable && element2 instanceof Comparable) {
            return ((Comparable) element1).compareTo(element2);
        } else {
            throw new IllegalArgumentException("Unsupported types for comparison.");
        }
    }
}
