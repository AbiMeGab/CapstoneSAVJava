public class Main {
    public static void main(String[] args) {
        try {
            if (args.length != 6) {
                System.out.println("Debes proporcionar 6 argumentos: alg, tip, ord, ent, arr y vel");
                return;
            }

            String alg = args[0].split("=")[1];
            String tip = args[1].split("=")[1];
            String ord = args[2].split("=")[1];
            String ent = args[3].split("=")[1];
            String arr = args[4].split("=")[1];
            String vel = args[5].split("=")[1];

            VerificarDatos verificarDatos = new VerificarDatos(alg, tip, ord, ent, arr, vel);

            OrdenamientoBurbuja ordenamientoBurbuja = new OrdenamientoBurbuja(verificarDatos.getArreglo());
            ordenamientoBurbuja.ordenar();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
