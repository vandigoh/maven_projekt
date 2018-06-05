import static org.junit.Assert.*;

import org.junit.Test;

public class UtilTest {

	@Test
	public void testIstErstesHalbjahr() {
		assertEquals(true, Util.istErstesHalbjahr(1));
		assertEquals(true, Util.istErstesHalbjahr(6));
		assertEquals(false, Util.istErstesHalbjahr(7));
		assertEquals(false, Util.istErstesHalbjahr(12));
	}
	
	// Hier teste ich die Bereiche ausserhalb der Äquivalenzklassen, also < 1 und > 7
	// Diese Fehlermeldung wird erwartet
	@Test(expected=IllegalArgumentException.class)
	public void testAusserhalbKleiner() {
		Util.istErstesHalbjahr(0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAusserhalbGroesser() {
		Util.istErstesHalbjahr(13);
	}

}
