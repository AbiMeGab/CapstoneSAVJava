public class SAV {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        try {
            String alg = args[0].split("=")[1];
            String tip = args[1].split("=")[1];
            String ord = args[2].split("=")[1];
            String ent = args[3].split("=")[1];
            String arr = args[4].split("=")[1];
            String vel = args[5].split("=")[1];

            if (alg == null) {
                final int OPTIONS = (int) (Math.random() * 3);
                if (OPTIONS == 0) {
                    alg = "b";
                } else if (OPTIONS == 1) {
                    alg = "i";
                } else if (OPTIONS == 2) {
                    alg = "s";
                }
            }

            if (args.length != 6) {
                System.out.println("Debes proporcionar 6 argumentos: algoritmo, tipo, ordenamiento, entrada, arreglo y velocidad");
                return;
            }

            VerificadorDeDatos verificarDatos = new VerificadorDeDatos(alg, tip, ord, ent, arr, vel);

            if (ent.equalsIgnoreCase("m")){
            } else if (verificarDatos.getEnt().equalsIgnoreCase("r")) {
                final int OPTIONS = (int) (Math.random() * 2);
                if (OPTIONS == 0) {
                    char[] caracArray = verificarDatos.randomArregloCarac();
                    String caracString = verificarDatos.charArrayToString(caracArray);
                    arr = caracString;
                } else if (OPTIONS == 1) {
                    int[] numArray = verificarDatos.randomArregloNum();
                    String numString = verificarDatos.intArrayToString(numArray);
                    arr = numString;
                }
            }
                if (verificarDatos.getAlg().equalsIgnoreCase("b")) {
                    OrdenamientoBurbuja ordenamientoBurbuja = new OrdenamientoBurbuja(verificarDatos.getArreglo(), ord);
                    ordenamientoBurbuja.ordenar();
                } else if (verificarDatos.getAlg().equalsIgnoreCase("i")) {
                    OrdenamientoDeInsercion ordenamientoDeInsercion = new OrdenamientoDeInsercion(verificarDatos.getArreglo(), ord);
                    ordenamientoDeInsercion.ordenar();
                } else if (verificarDatos.getAlg().equalsIgnoreCase("s")) {
                    OrdenamientoDeSeleccion ordenamientoDeSeleccion = new OrdenamientoDeSeleccion(verificarDatos.getArreglo(), ord);
                    ordenamientoDeSeleccion.ordenar();
                }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }

        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        System.out.println("Tiempo total: " + timeElapsed / 1000000 + " ms");
    }
}
