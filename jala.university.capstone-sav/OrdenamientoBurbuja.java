import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class OrdenamientoBurbuja extends AlgoritmoBase {


    public OrdenamientoBurbuja(List<Object> list) {
        super(list);
    }

    @Override
    public void ordenar() {
        for (int i = 0; i < this.list.size() - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < list.size() - i - 1; j++) {
                Object element1 = this.list.get(j);
                Object element2 = this.list.get(j + 1);

                if (compareElements(element1, element2) > 0) {
                    this.list.set(j, element2);
                    this.list.set(j + 1, element1);
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }

            System.out.println(list);
        }

        System.out.println();
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
