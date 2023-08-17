import java.util.List;

public class OrdenamientoDeSeleccion extends AlgoritmoBase {

    public OrdenamientoDeSeleccion(List<Object> list) {
        super(list);
    }

    @Override
    public void ordenar() {
        for (int i = 0; i < this.list.size() - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < this.list.size(); j++) {
                if (compareElements(this.list.get(j), this.list.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                Object temp = this.list.get(i);
                this.list.set(i, this.list.get(minIndex));
                this.list.set(minIndex, temp);
            }

            System.out.println(list);
        }

        System.out.println();
    }

    private int compareElements(Object element1, Object element2) {
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
