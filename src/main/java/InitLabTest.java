
import static org.junit.Assert.*;

import org.junit.Test;


public class InitLabTest {
	
	@Test
	public void testSay() {
		InitLab initlab = new InitLab();
		
		//Check that two objects are equal
		assertEquals("Hello World",initlab.say());
	}

}
