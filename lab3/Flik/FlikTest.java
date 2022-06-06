import static org.junit.Assert.*;

import org.junit.Test;

public class FlikTest {

    @Test
    public void testIsSameNumber() {
        Integer A = 128;
        Integer B = 128;
        Integer C = 20;

        assertTrue("They are not the same.", Flik.isSameNumber(A, B));
        assertFalse("They are the same.", Flik.isSameNumber(A, C));
    }
}
