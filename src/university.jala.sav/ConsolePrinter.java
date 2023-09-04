package university.jala.sav;

import java.util.Collections;
import java.util.List;

public class ConsolePrinter {
    private ConsolePrinter() {
    }

    public static void inverseConsolePrinter(String orderingType, int iteraciones, List<ComparatorIndex> list) {
        if ("za".equalsIgnoreCase(orderingType)) {
            iteraciones++;
            Collections.reverse(list);
            System.out.println("Iteración: " + iteraciones + "\nOrdenamiento: " + list);
        }
    }

    public static void sortingList(int iteraciones, List<ComparatorIndex> list) {
        System.out.println("Iteración: " + iteraciones + "\nOrdenamiento: " + list);
    }

    public static void printError(String msg) {
        System.err.println(msg);
        System.exit(0);
    }

    public static void printTypeOfArray(String type) {
        System.out.println(type);
    }

    public static void printSortingType(String sorting) {
        System.out.println(sorting);
    }
}