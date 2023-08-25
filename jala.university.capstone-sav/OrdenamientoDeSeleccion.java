import java.util.Collections;
import java.util.List;

public class OrdenamientoDeSeleccion extends AlgoritmoBase {
    private String ord;
    public OrdenamientoDeSeleccion(List<Object> list, String ord) {
        super(list); this.ord = ord;
    }

    @Override
    public void ordenar() {
        for (int index = 0; index < this.list.size() - 1; index++) {
            int minIndex = index;

            for (int pointer = index + 1; pointer < this.list.size(); pointer++) {
                if (compareElements(this.list.get(pointer), this.list.get(minIndex)) < 0) {
                    minIndex = pointer;
                }
            }

            if (minIndex != index) {
                Object temp = this.list.get(index);
                this.list.set(index, this.list.get(minIndex));
                this.list.set(minIndex, temp);
            }
        }
        if ("az".equalsIgnoreCase(ord)){
            System.out.println("Ordenamiento: " + list);
        } else if ("za".equalsIgnoreCase(ord)) {
            Collections.reverse(this.list);
            System.out.println("Ordenamiento: " + list);
        }
        System.out.println("Algoritmo: Ordenamiento de Selección");
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
