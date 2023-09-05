package university.jala.sav;

import java.util.ArrayList;
import java.util.List;

public class RandomGenerator {
    private static final int MIN_NUM = -1000;
    private static final int MAX_NUM = 1000;
    private static final char[] CHARACTERS = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    public static List<ComparatorIndex> randomCharacters() {
        System.out.println("Tipo: [Caracter]");

        List<String> caracteresLista = new ArrayList<>();
        for (char character : CHARACTERS) {
            caracteresLista.add(String.valueOf(character));
        }
        final int min = 1;
        final int max = caracteresLista.size();

        final int sizeRandomArray = (int) (Math.random() * 40) + min;

        List<ComparatorIndex> list = new ArrayList<>();

        for (int index = 0; index < sizeRandomArray; index++) {
            int randomValue = (int) (Math.random() * max) + min;
            String key = caracteresLista.get(randomValue);
            ComparatorIndex comparatorIndex = new ComparatorIndex(randomValue, key);
            list.add(comparatorIndex);
        }
        return list;

    }

    public static List<ComparatorIndex> randomNumbers() {
        System.out.println("Tipo: [Numerico]");

        final int sizeRandomArray = (int) (Math.random() * 40) + 1;

        List<ComparatorIndex> list = new ArrayList<>();

        for (int index = 0; index < sizeRandomArray; index++) {
            int randomValue = (int) (Math.random() * (MAX_NUM - MIN_NUM + 1)) + MIN_NUM;
            String key = String.valueOf(randomValue);
            ComparatorIndex comparatorIndex = new ComparatorIndex(randomValue, key);
            list.add(comparatorIndex);
        }
        return list;
    }
}
