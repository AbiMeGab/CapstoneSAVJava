public class SAV {
    public static void main(String[] args) {
        try {
            if (args.length != 6) {
                System.out.println("Debes proporcionar 6 argumentos: algoritmo, tipo, ordenamiento, entrada, arreglo y velocidad");
                return;
            }

            String alg = args[0].split("=")[1];
            String tip = args[1].split("=")[1];
            String ord = args[2].split("=")[1];
            String ent = args[3].split("=")[1];
            String arr = args[4].split("=")[1];
            String vel = args[5].split("=")[1];

            if (alg == null){
                final int OPTIONS = (int) (Math.random() * 3);
                if (OPTIONS == 0){
                    alg = "b";
                } else if (OPTIONS == 1){
                    alg = "i";
                } else if (OPTIONS == 2){
                    alg = "s";
                }
            }
            VerificadorDeDatos verificarDatos = new VerificadorDeDatos(alg, tip, ord, ent, arr, vel);

            if (verificarDatos.getAlg().equalsIgnoreCase("b")){
                OrdenamientoBurbuja ordenamientoBurbuja = new OrdenamientoBurbuja(verificarDatos.getArreglo());
                ordenamientoBurbuja.ordenar();
            } else if (verificarDatos.getAlg().equalsIgnoreCase("i")){
                OrdenamientoDeInsercion ordenamientoDeInsercion = new OrdenamientoDeInsercion(verificarDatos.getArreglo());
                ordenamientoDeInsercion.ordenar();
            } else if (verificarDatos.getAlg().equalsIgnoreCase("s")){
                OrdenamientoDeSeleccion ordenamientoSeleccion = new OrdenamientoDeSeleccion(verificarDatos.getArreglo());
                ordenamientoSeleccion.ordenar();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
