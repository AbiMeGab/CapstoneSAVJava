import junit.framework.TestCase;
import org.junit.Test;

public class SAVTest {

    @Test
    public void testEntradaNumeros() {
        String[] args = {"a=b", "t=n", "o=az", "in=m", "v=\"1,-387465,5,8,4,-3,6,-1,12,16,13545\"", "s=1000"};
        SAV.main(args);
    }

    @Test
    public void testEntradaLetras() {
        String[] args = {"a=b", "t=c", "o=az", "in=m", "v=\"a,A,N,b,z\"", "s=35"};
        SAV.main(args);
    }

    @Test
    public void testEntradaLetrasReverso() {
        String[] args = {"a=i", "t=c", "o=ZA", "in=m", "v=\"a,A,N,b,z\"", "s=180"};
        SAV.main(args);
    }

    @Test
    public void testEntradaInvalida() {
        String[] args = {"a=x", "t=c", "o=az", "in=m", "v=\"1,2,5,8,X,4\"", "s=250"};
        SAV.main(args);
    }

    @Test
    public void testEntradaRandom() {
        String[] args = {"a=b", "t=n", "o=az", "in=r", "v=\"1,q,5,8,X,4\"", "s=250"};
        SAV.main(args);
    }
}
