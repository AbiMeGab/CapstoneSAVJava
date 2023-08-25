import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SuppressWarnings("unchecked")
public class VerificadorDeDatos {
    private String algoritmo;
    private String tipo;
    private String ordenamiento;
    private String entrada;
    private String array;
    private String velocidadImpresion;
    private int velocidad;
    private static final char MIN_CHAR_LOWER = 'a';
    private static final char MAX_CHAR_LOWER = 'z';
    private static final char MIN_CHAR_UPPER = 'A';
    private static final char MAX_CHAR_UPPER = 'Z';
    private static final int MIN_NUM = -1000;
    private static final int MAX_NUM = 1000;
    private static final char[] CARACTERES = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    List<Object> arreglo;

    public VerificadorDeDatos(String alg, String tip, String ord, String ent, String array, String vel) {
        this.algoritmo = alg;
        this.tipo = tip;
        this.ordenamiento = ord;
        this.entrada = ent;
        this.array = array;
        this.velocidadImpresion = vel;
        this.arreglo = new ArrayList<Object>();
        iniciarArreglo();
    }

    private String validarString(String entrada, String op1, String op2, String op3){
        if (entrada.equalsIgnoreCase(op1)){
            return entrada;
        } else if (entrada.equalsIgnoreCase(op2)){
            return entrada;
        } else if (entrada.equalsIgnoreCase(op3)) {
            return entrada;
        } else {
            System.exit(0);
        }
        return null;
    }

    private int validarNumeros(String entrada, int valorMax, int valorMin) {

        int numero = Integer.parseInt(entrada);

        if (numero >= valorMin && numero <= valorMax) {
            return numero;
        } else {
            System.exit(0);
        }
        return -1;
    }

    private void rellenarArreglo() {
        boolean hasNumbers = false;
        boolean hasLetters = false;

        if (this.entrada.equalsIgnoreCase("m")) {
            String[] temp = this.array.split(",");
            for (int i = 0; i < temp.length; i++) {
                String trimmedElement = temp[i].trim().replace("\"", ""); // Eliminar comillas del arreglo de entrada

                if (trimmedElement.matches("\\d+")) {
                    hasNumbers = true;
                } else if (trimmedElement.length() == 1) {
                    hasLetters = true;
                }
                arreglo.add(trimmedElement);
            }

            if (hasNumbers && hasLetters) {
                System.out.println("Entrada inválida: contiene tanto números como letras.");
                System.exit(0);
            } else if (hasNumbers) {
                System.out.println("Tipo: [Numérico]");
            } else if (hasLetters) {
                System.out.println("Tipo: [Carácter]");
            }
        }
        System.out.println("Valores: " + "[" + array + "]");
    }

    private void iniciarArreglo(){
        this.algoritmo = validarString(this.algoritmo, "b", "i", "q");
        this.tipo = validarString(this.tipo,"n","c"," ");
        this.ordenamiento = validarString(this.ordenamiento, "az", "za", " ");
        this.entrada = validarString(this.entrada, "r", "m", " ");
        rellenarArreglo();
        this.velocidad = validarNumeros(this.velocidadImpresion, 1000, 100);
    }

    public char[] randomArregloCarac() {
        Random rand = new Random();
        int length = rand.nextInt(5) + 6;
        char[] caracArray = new char[length];

        for (int i = 0; i < length; i++) {
            caracArray[i] = randomCharInRange();
        }

        return caracArray;
    }

    public int[] randomArregloNum() {
        Random rand = new Random();
        int length = rand.nextInt(5) + 6;
        int[] numArray = new int[length];

        for (int i = 0; i < length; i++) {
            numArray[i] = randomNumInRange();
        }

        return numArray;
    }

    private char randomCharInRange() {
        Random rand = new Random();
        int range = (MAX_CHAR_UPPER - MIN_CHAR_UPPER + 1) + (MAX_CHAR_LOWER - MIN_CHAR_LOWER + 1);
        int randomOffset = rand.nextInt(range);

        char randomChar;
        if (randomOffset <= MAX_CHAR_UPPER - MIN_CHAR_UPPER) {
            randomChar = (char) (MIN_CHAR_UPPER + randomOffset);
        } else {
            randomChar = (char) (MIN_CHAR_LOWER + (randomOffset - (MAX_CHAR_UPPER - MIN_CHAR_UPPER + 1)));
        }

        return randomChar;
    }

    private int randomNumInRange() {
        Random rand = new Random();
        int randomNum = rand.nextInt(MAX_NUM - MIN_NUM + 1) + MIN_NUM;
        return randomNum;
    }

    public String charArrayToString(char[] charArray) {
        return new String(charArray);
    }

    public String intArrayToString(int[] intArray) {
        StringBuilder sb = new StringBuilder();
        for (int num : intArray) {
            sb.append(num).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length()); // Elimina la última coma y el espacio
        return sb.toString();
    }


    public String getAlg() {
        return algoritmo;
    }

    public String getOrd() {
        return ordenamiento;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public List<Object> getArreglo() {
        return arreglo;
    }

    public String getTip(){
        return tipo;
    }

    public String getEnt() {
        return entrada;
    }
}
