import org.junit.Test;
import university.jala.sav.SAV;

public class SAVTest {

    @Test
    public void testEntradaNumeros() throws InterruptedException {
        String[] args = {"a=i", "t=n", "o=az", "in=m", "v=\"1,-387465,5,8,4,-3,6,-1,12,16,13545\"", "s=1000"};
        SAV.main(args);
    }

    @Test
    public void testEntradaLetras() throws InterruptedException {
        String[] args = {"a=b", "t=c", "o=za", "in=m", "v=\"a,A,N,b,z\"", "s=500"};
        SAV.main(args);
    }

    @Test
    public void testEntradaLetrasReverso() throws InterruptedException {
        String[] args = {"a=s", "t=c", "o=ZA", "in=m", "v=\"a,A,N,b,z\"", "s=180"};
        SAV.main(args);
    }

    @Test
    public void testEntradaInvalida() throws InterruptedException {
        String[] args = {"a=x", "t=c", "o=az", "in=m", "v=\"1,2,5,8,X,4\"", "s=250"};
        SAV.main(args);
    }

    @Test
    public void testEntradaRandom() throws InterruptedException {
        String[] args = {"a=b", "t=c", "o=az", "in=r", "v=\"1,q,5,8,X,4\"", "s=250"};
        SAV.main(args);
    }
}
