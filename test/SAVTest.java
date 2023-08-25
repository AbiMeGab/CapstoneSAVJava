import org.junit.jupiter.api.Test;

class SAVTest {

    @Test
    void testEntradaNumeros() {
        String[] args = {"a=s", "t=n", "o=az", "in=m", "v=\"1,5,8,4\"", "s=100"};
        SAV.main(args);
    } //No encuentro aún por qué selección no funciona

    @Test
    void testEntradaLetras() {
        String[] args = {"a=b", "t=n", "o=az", "in=m", "v=\"a,A,N,b,z\"", "s=180"};
        SAV.main(args);
    }

    @Test
    void testEntradaLetrasReverso() {
        String[] args = {"a=i", "t=n", "o=ZA", "in=m", "v=\"a,A,N,b,z\"", "s=180"};
        SAV.main(args);
    }

    @Test
    void testEntradaInvalida() {
        String[] args = {"a=b", "t=n", "o=az", "in=m", "v=\"1,q,5,8,X,4\"", "s=250"};
        SAV.main(args);
    }

    @Test
    void testEntradaRandom() {
        String[] args = {"a=b", "t=n", "o=az", "in=r", "v=\"1,q,5,8,X,4\"", "s=250"};
        SAV.main(args);
    } //en construcción
}
