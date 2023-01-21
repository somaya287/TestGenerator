package first_package;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
	
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
	
import third from /*insert your classe's package here*/;
import anotherONe from /*insert your classe's package here*/;
	

@DisplayName("test the classFirst")
public class FirstTest {
		
	@Test
	public void testSomeMessage() {
	
		// ***** given :
		
		third third; 
		anotherONe anotherONe; 
					
		third = mock(third.class);
		anotherONe = mock(anotherONe.class);
 
		First first = new First(third, anotherONe);
	
		// here goes all your additional instructions
				
		// ***** when :
		
		Double res2 = /*write the return value*/;	
		
		when(third.someOtherMessage()).thenReturn(res2);
		String s = /*write the return value*/;	
		
		when(third.get()).thenReturn(s);
		Float res3 = /*write the return value*/;	
		
		when(anotherONe.lolol()).thenReturn(res3);
		String rrr = /*write the return value*/;	
		
		when(anotherONe.hhh()).thenReturn(rrr);
					
		Int res = first.someMessage();
				
		// ***** Then :
		
		// assertNull(res);				
		// assertTrue(res);				
		// assertNotNull(res);				
		// assertFalse(res);				
		// assertEquals(/*your expected value*/,res);				
		// assertNotEquals(/*your expected value*/,res);				
		// assertArrayEquals(/*your expected value*/,res);				
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