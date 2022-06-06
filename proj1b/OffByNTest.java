import static org.junit.Assert.*;
import org.junit.Test;

public class OffByNTest {
    @Test
    public void testEqualChars() {
        CharacterComparator cc = new OffByN(5);
        assertTrue(cc.equalChars('a', 'f'));
        assertTrue(cc.equalChars('f', 'a'));
        assertFalse(cc.equalChars('f', 'h'));
    }
}
