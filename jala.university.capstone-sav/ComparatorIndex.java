public class ComparatorIndex {
    int value;
    String key;


    public ComparatorIndex(int value, String key) {
        this.value = value;
        this.key = key;
    }
    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return key;
    }
}
