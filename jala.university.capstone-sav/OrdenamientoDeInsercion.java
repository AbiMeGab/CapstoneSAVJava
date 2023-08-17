import java.util.List;

public class OrdenamientoDeInsercion extends AlgoritmoBase {

    public OrdenamientoDeInsercion(List<Object> list) {
        super(list);
    }

    @Override
    public void ordenar() {
        for (int index = 1; index < this.list.size(); index++) {
            Object currentElement = this.list.get(index);
            int pointer = index - 1;

            while (pointer >= 0 && compareElements(this.list.get(pointer), currentElement) > 0) {
                this.list.set(pointer + 1, this.list.get(pointer));
                pointer--;
            }

            this.list.set(pointer + 1, currentElement);

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
