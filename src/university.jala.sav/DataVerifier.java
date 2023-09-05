package university.jala.sav;

import java.util.*;


@SuppressWarnings("unchecked")
public class DataVerifier<T> {
    private String algorithm;
    private String type;
    private String orderingType;
    private String entry;
    private String array;
    private static String printSpeed;
    private int speed;
    private static final char[] CHARACTERS = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private static final List<String> characters = new ArrayList<>();
    List<ComparatorIndex> arrayListComparator;

    private void fillCharacters() {
        for (char character : CHARACTERS) {
            characters.add(String.valueOf(character));
        }
    }

    public DataVerifier(String algorithm, String type, String order, String entry, String array, String velocity) {
        this.algorithm = algorithm;
        this.type = type;
        this.orderingType = order;
        this.entry = entry;
        this.array = array;
        this.printSpeed = velocity;
        this.arrayListComparator = new ArrayList<ComparatorIndex>();
        fillCharacters();
        runArray();
    }

    private String validateAlgorithm(String input, String option1, String option2, String option3) {
        if (input.isBlank()) {
            ConsolePrinter.printError("Error, no existe valor para selección de algoritmo.");
        } else if (input.equals(option1) || input.equals(option2) || input.equals(option3)) {
            return input;
        } else {
            ConsolePrinter.printError("Error, valor invalido para selección de algoritmo.");
        }
        return algorithm;
    }

    private String validateType(String entrada, String option1, String option2) {
        if (entrada.isBlank()) {
            ConsolePrinter.printError("Error, falta valor para Tipo.");
        } else if (entrada.equals(option1) || entrada.equals(option2)) {
            return entrada;
        } else {
            ConsolePrinter.printError("Error, Tipo no reconocido.");
        }
        return type;
    }

    private String validateOrder(String entrada, String option1, String option2, String option3, String option4) {
        if (entrada.isBlank()) {
            ConsolePrinter.printError("Error, falta tipo de ordenamiento.");
        } else if (entrada.equals(option1) || entrada.equals(option2) || entrada.equals(option3) || entrada.equals(option4)) {
            return entrada;
        } else {
            ConsolePrinter.printError("Error, tipo de ordenamiento no reconocido.");
        }
        return orderingType;
    }

    private String validateEntry(String entrada, String option1, String option2) {
        if (entrada.isBlank()) {
            ConsolePrinter.printError("Error, falta tipo de entrada de valores.");
        } else if (entrada.equalsIgnoreCase(option1) || entrada.equalsIgnoreCase(option2)) {
            return entrada;
        } else {
            ConsolePrinter.printError("Error, Tipo de entrada de valores no valido.");
        }
        return entrada;
    }

    private int validateSpeed(String entrada, int valorMax, int valorMin) {
        int limit = Integer.parseInt(entrada);
        if (limit >= valorMin && limit <= valorMax) {
            return limit;
        } else {
            System.out.println("Valores: " + "[" + array + "]");
            System.out.println("Valor para pausa de retardo invalido.");
            System.exit(0);
        }
        return -1;
    }

    private void runArray() {
        this.algorithm = validateAlgorithm(this.algorithm, "b", "i", "s");
        this.type = validateType(this.type, "n", "c");
        this.orderingType = validateOrder(this.orderingType, "az", "za", "AZ", "ZA");
        this.entry = validateEntry(this.entry, "r", "m");
        fillArray();
        this.speed = validateSpeed(this.printSpeed, 1000, 100);
    }

    private void fillArray() {
        boolean hasNumbers = false;
        boolean hasLetters = false;
        if (this.entry.equalsIgnoreCase("m")) {
            String[] temp = this.array.split(",");
            for (int index = 0; index < temp.length; index++) {
                String trimmedElement = temp[index].trim().replace("\"", ""); // Eliminar comillas del arreglo de entrada
                if (this.type.equals("n")) {
                    try {
                        int value = Integer.parseInt(trimmedElement);
                        ComparatorIndex comparatorIndexNumeros = new ComparatorIndex(value, trimmedElement);
                        arrayListComparator.add(comparatorIndexNumeros);
                        hasNumbers = true;
                    } catch (NumberFormatException e) {
                        System.out.println("Tipo: [Numerico]");
                        System.out.println("Valores: " + "[" + array + "]");
                        System.out.println("Valores invalidos.");
                        System.exit(0);
                    }
                } else if (this.type.equals("c")) {
                    try {
                        int value = characters.indexOf(trimmedElement);
                        if (value == -1) {
                            throw new Error("Tipo: [Caracter]" + "\n" + "Valores: " + "[" + array + "]" + "\n" + "Valores invalidos.");
                        }
                        ComparatorIndex comparatorIndexLetras = new ComparatorIndex(value, trimmedElement);
                        arrayListComparator.add(comparatorIndexLetras);
                        hasLetters = true;
                    } catch (Error e) {
                        System.out.println(e.getMessage());
                        System.exit(0);
                    }
                }
            }
            if (hasNumbers) {
                ConsolePrinter.printTypeOfArray("Tipo: [Numerico]");
            } else if (hasLetters) {
                ConsolePrinter.printTypeOfArray("Tipo: [Caracter]");
            }
        } else if (this.entry.equals("r")) {
            if (this.type.equals("c")) {
                arrayListComparator = RandomGenerator.randomCharacters();
                array = Arrays.toString(arrayListComparator.toArray());
            } else if (this.type.equals("n")) {
                arrayListComparator = RandomGenerator.randomNumbers();
                array = Arrays.toString(arrayListComparator.toArray());
            }
        }
        System.out.println("Valores: " + "[" + array + "]");
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public List<ComparatorIndex> getVerifiedArray() {
        return arrayListComparator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataVerifier<?> that = (DataVerifier<?>) o;
        return speed == that.speed && algorithm.equals(that.algorithm) && type.equals(that.type) && orderingType.equals(that.orderingType) && entry.equals(that.entry) && array.equals(that.array) && arrayListComparator.equals(that.arrayListComparator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(algorithm, type, orderingType, entry, array, speed, arrayListComparator);
    }
}
