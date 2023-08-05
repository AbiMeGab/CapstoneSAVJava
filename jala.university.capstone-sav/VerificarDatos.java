import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SuppressWarnings("unchecked")
public class VerificarDatos{
    String alg;
    String tip;
    String ord;
    String ent;
    String array;
    String vel;
    int velocidad;

    List<Object> arreglo;

    public VerificarDatos(String alg, String tip, String ord, String ent, String array, String vel) {
        this.alg = alg;
        this.tip = tip;
        this.ord = ord;
        this.ent = ent;
        this.array = array;
        this.vel = vel;
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
        if (this.ent.equalsIgnoreCase("m")) {
            String[] temp = this.array.split(",");
            for (int i = 0; i < temp.length; i++) {
                arreglo.add(temp[i].trim());
            }
        } else if (this.ent.equalsIgnoreCase("r")) {
            int size = validarNumeros(this.array, 1, 40);
            if (this.tip.equalsIgnoreCase("n")) {
                for (int i = 0; i < size; i++) {
                    arreglo.add(randomArregloNum());
                }
            } else if (this.tip.equalsIgnoreCase("c")) {
                for (int i = 0; i < size; i++) {
                    arreglo.add(randomArregloCarac());
                }
            }
        }
    }
    private void iniciarArreglo(){
        this.alg = validarString(this.alg, "b", "i", "q");
        System.out.println("pass 1");
        this.tip = validarString(this.tip,"n","c"," ");
        System.out.println("pass 2");
        this.ord = validarString(this.ord, "az", "za", " ");
        System.out.println("pass 3");
        this.ent = validarString(this.ent, "r", "m", " ");
        System.out.println("pass 4");
        rellenarArreglo();
        System.out.println("pass 5");
        this.velocidad = validarNumeros(this.vel, 1000, 100);
        System.out.println("pass 6");
    }

    private char randomArregloCarac(){
        final char[] caracteres = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        int randomI = (int) (Math.random() * caracteres.length);
        char randomCaracter = caracteres[randomI];
        return randomCaracter;
    }

    private int randomArregloNum() {
        Random rand = new Random();
        int randomNum = rand.nextInt();
        return randomNum;
    }

    public String getAlg() {
        return alg;
    }

    public String getOrd() {
        return ord;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public List<Object> getArreglo() {
        return arreglo;
    }

    public String getTip(){
        return tip;
    }

    public String getEnt() {
        return ent;
    }
}
