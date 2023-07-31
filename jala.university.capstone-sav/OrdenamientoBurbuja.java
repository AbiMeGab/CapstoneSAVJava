import java.util.Arrays;

public class OrdenamientoBurbuja extends AlgoritmoBase {

    @Override
    public void ordenar() {
        String[] elementos = arrayDesordenado;

        boolean sonNumeros = false;
        boolean sonLetras = false;

        for (String elemento : elementos) {
            if (esNumero(elemento)) {
                sonNumeros = true;
            } else {
                sonLetras = true;
            }
        }

        if (sonNumeros && !sonLetras) {
            System.out.println("Tipo: [Numérico]");
            System.out.println("Valores: " + Arrays.toString(elementos));
            ordenarNumeros(elementos);
        } else if (!sonNumeros && sonLetras) {
            System.out.println("Tipo: [Caracter]");
            System.out.println("Valores: " + Arrays.toString(elementos));
            ordenarLetras(elementos);
        } else {
            System.out.println("Los valores son inválidos");
        }
    }

    private boolean esNumero(String elemento) {
        try {
            Integer.parseInt(elemento);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void ordenarNumeros(String[] elementos) {
        int tamanio = elementos.length;
        for (int pivote = 0; pivote < tamanio - 1; pivote++) {
            for (int apuntador = 0; apuntador < tamanio - pivote - 1; apuntador++) {
                int nApuntador = Integer.parseInt(elementos[apuntador]);
                int nApuntador1 = Integer.parseInt(elementos[apuntador + 1]);

                if (nApuntador > nApuntador1) {
                    String reserva = elementos[apuntador];
                    elementos[apuntador] = elementos[apuntador + 1];
                    elementos[apuntador + 1] = reserva;
                }
            }
        }
        System.out.print("Ordenamiento: " + Arrays.toString(elementos) + "\n");
    }

    private void ordenarLetras(String[] elementos) {
        int tamanio = elementos.length;
        for (int pivote = 0; pivote < tamanio - 1; pivote++) {
            for (int apuntador = 0; apuntador < tamanio - pivote - 1; apuntador++) {
                if (elementos[apuntador].compareTo(elementos[apuntador + 1]) > 0) {
                    String reserva = elementos[apuntador];
                    elementos[apuntador] = elementos[apuntador + 1];
                    elementos[apuntador + 1] = reserva;
                }
            }
        }
        System.out.print("Ordenamiento: " + Arrays.toString(elementos) + "\n");
    }
}
