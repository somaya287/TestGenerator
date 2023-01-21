package soma_package;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
	
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
	
import Maymoun from /*insert your classe's package here*/;
	

@DisplayName("test the classSoma")
public class SomaTest {
		
	@Test
	public void testSomaM() {
	
		// ***** given :
		
		Maymoun maymoun; 
					
		maymoun = mock(Maymoun.class);
 
		Soma soma = new Soma(maymoun);
	
		// here goes all your additional instructions
				
		// ***** when :
		
		int res = /*write the return value*/;	
		
		when(maymoun.method2(c)).thenReturn(res);
					
		boolean result = soma.somaM(a);
				
		// ***** Then :
		
		// assertNull(result);				
		// assertTrue(result);				
		// assertNotNull(result);				
		// assertFalse(result);				
		// assertEquals(/*your expected value*/,result);				
		// assertNotEquals(/*your expected value*/,result);				
		// assertArrayEquals(/*your expected value*/,result);				
	}
		
	@AfterAll	
	public void () {
		// here goes the code to be excecuted after all tests
	}
	
		
	@AfterEach		
	public void () {
		// here goes the code to be excecuted after each test
	}
	
		
	@BeforeAll		
	public void () {
		// here goes the code to be excecuted before all tests
	}
	
		
	@BeforeEach		
	public void () {
		// here goes the code to be excecuted before each test
	}
	
	
}