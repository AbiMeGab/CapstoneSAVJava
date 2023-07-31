public abstract class AlgoritmoBase {
    public String[] arrayDesordenado;
    public String pivote;
    public String apuntador;

    public void setArrayDesordenado(String[] arrayDesordenado) {
        this.arrayDesordenado = arrayDesordenado;
    }

    public abstract void ordenar();

   // public abstract void mostrarArrayOrdenado();
}
