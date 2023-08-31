import java.util.*;


@SuppressWarnings("unchecked")
public class DataVerifier<T> {
    private String algorithm;
    private String type;
    private String ordering;
    private String entry;
    private String array;
    private static String printSpeed;
    private int speed;
    private static final char[] CARACTERES = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private static final List<String> characters = Arrays.asList(Arrays.toString(CARACTERES));
    List<ComparatorIndex> arrayListComparator;

    public DataVerifier(String algorithm, String type, String order, String entry, String array, String velocity) {
        this.algorithm = algorithm;
        this.type = type;
        this.ordering = order;
        this.entry = entry;
        this.array = array;
        this.printSpeed = velocity;
        this.arrayListComparator = new ArrayList<ComparatorIndex>();
        runArray();
    }

    private String validateAlgorithm(String entrada, String op1, String op2, String op3) {
        if (entrada.isBlank()) {
            System.out.println("Error, no existe valor para selección de algoritmo.");
            System.exit(0);
        } else if (entrada.equals(op1) || entrada.equals(op2) || entrada.equals(op3)) {
            return entrada;
        } else {
            System.out.println("Error, valor invalido para selección de algoritmo.");
            System.exit(0);
        }
        return algorithm;
    }

    private String validateType(String entrada, String op1, String op2) {
        if (entrada.isBlank()) {
            System.out.println("Error, falta valor para Tipo.");
            System.exit(0);
        } else if (entrada.equals(op1) || entrada.equals(op2)) {
            return entrada;
        } else {
            System.out.println("Error, Tipo no reconocido.");
            System.exit(0);
        }
        return type;
    }

    private String validateOrder(String entrada, String op1, String op2, String op3, String op4) {
        if (entrada.isBlank()) {
            System.out.println("Error, falta tipo de ordenamiento.");
            System.exit(0);
        } else if (entrada.equals(op1) || entrada.equals(op2) || entrada.equals(op3) || entrada.equals(op4)) {
            return entrada;
        } else {
            System.out.println("Error, tipo de ordenamiento no reconocido.");
            System.exit(0);
        }
        return ordering;
    }

    private String validateEntry(String entrada, String op1, String op2) {
        if (entrada.isBlank()) {
            System.out.println("Error, falta tipo de entrada de valores.");
            System.exit(0);
        } else if (entrada.equalsIgnoreCase(op1) || entrada.equalsIgnoreCase(op2)) {
            return entrada;
        } else {
            System.out.println("Error, Tipo de entrada de valores no valido.");
            System.exit(0);
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
        this.ordering = validateOrder(this.ordering, "az", "za", "AZ", "ZA");
        this.entry = validateEntry(this.entry, "r", "m");
        rellenarArreglo();
        this.speed = validateSpeed(this.printSpeed, 1000, 100);
    }

    private void rellenarArreglo() {
        boolean hasNumbers = false;
        boolean hasLetters = false;
        if (this.entry.equalsIgnoreCase("m")) {
            String[] temp = this.array.split(",");
            for (int index = 0; index < temp.length; index++) {
                String trimmedElement = temp[index].trim().replace("\"", ""); // Eliminar comillas del arreglo de entrada
                if (this.type.equals("n") || (this.type.equals("n") && this.type.isBlank())) {
                    try {
                        int value = Integer.parseInt(trimmedElement);
                        ComparatorIndex comparatorIndexNumeros = new ComparatorIndex(value, trimmedElement);
                        arrayListComparator.add(comparatorIndexNumeros);
                        hasNumbers = true;
                    } catch (Exception e) {
                        System.out.println("Tipo: [Numerico]");
                        System.out.println("Valores: " + "[" + array + "]");
                        System.out.println("Valores invalidos.");
                        System.exit(0);
                    }
                } else if (this.type.equals("c") || ((this.type.equals("c") && this.type.isBlank()))) {
                    try {
                        int value = characters.indexOf(trimmedElement);
                        if (value == -1){
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
                System.out.println("Tipo: [Numerico]");
            } else if (hasLetters) {
                System.out.println("Tipo: [Caracter]");
            }
        }
        else if (this.entry.equals("r")) {
            if (this.type.equals("c")) {
                arrayListComparator = RandomGenerator.randomArregloCarac();
                array = Arrays.toString(arrayListComparator.toArray());
            } else if (this.type.equals("n")) {
                arrayListComparator = RandomGenerator.randomArregloNum();
                array = Arrays.toString(arrayListComparator.toArray());
            }
        }
        System.out.println("Valores: " + "[" + array + "]");
    }

    public String getAlg() {
        return algorithm;
    }

    public List<ComparatorIndex> getVerfiedArray() {
        return arrayListComparator;
    }
}
