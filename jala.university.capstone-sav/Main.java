import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner arrayNuevo = new Scanner(System.in);
        System.out.print("Ingresa tu arreglo, separando cada elemento por comas: ");
        String input = arrayNuevo.nextLine();

        String[] elementos = input.split(",");
        for (int i = 0; i < elementos.length; i++) {
            elementos[i] = elementos[i].trim();
        }
        OrdenamientoBurbuja ordenarArrayBurbuja = new OrdenamientoBurbuja();

        ordenarArrayBurbuja.setArrayDesordenado(elementos);
        ordenarArrayBurbuja.ordenar();


        System.out.println("""
                \n
                ***********************************************
                   EJEMPLOS DE OUTPUT DADOS EN LA ASIGNACIÓN:
                ***********************************************
                """);

        // Ejemplo 1: Números
        ordenarArrayBurbuja.setArrayDesordenado(new String[]{"0","-1","3","1","10"});
        System.out.println("\nEjemplo 1:");
        ordenarArrayBurbuja.ordenar();

        // Ejemplo 2: Letras
        ordenarArrayBurbuja.setArrayDesordenado(new String[]{"z", "a", "Z", "A", "b"});
        System.out.println("\nEjemplo 2:");
        ordenarArrayBurbuja.ordenar();

        // Ejemplo 3: Números y Letras (inválido)
        ordenarArrayBurbuja.setArrayDesordenado(new String[]{"z", "1", "Z", "A", "b"});
        System.out.println("\nEjemplo 3:");
        ordenarArrayBurbuja.ordenar();
    }
}
