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
    }

    private void iniciarArreglo(){
        this.algoritmo = validarString(this.algoritmo, "b", "i", "q");
        this.tipo = validarString(this.tipo,"n","c"," ");
        this.ordenamiento = validarString(this.ordenamiento, "az", "za", " ");
        this.entrada = validarString(this.entrada, "r", "m", " ");
        System.out.println("Valores: " + "[" + array + "]");
        rellenarArreglo();
        this.velocidad = validarNumeros(this.velocidadImpresion, 1000, 100);
    }

    private char randomArregloCarac(){
        int randomI = (int) (Math.random() * CARACTERES.length);
        char randomCaracter = CARACTERES[randomI];
        return randomCaracter;
    }

    private int randomArregloNum() {
        Random rand = new Random();
        int randomNum = rand.nextInt();
        return randomNum;
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
