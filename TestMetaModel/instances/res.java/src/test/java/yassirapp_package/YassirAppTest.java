package yassirapp_package;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
	
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
	
import AminaApp from /*insert your classe's package here*/;
import HajarApp from /*insert your classe's package here*/;
import SomiyaApp from /*insert your classe's package here*/;
import MimounApp from /*insert your classe's package here*/;
	

@DisplayName("test the classYassirApp")
public class YassirAppTest {
		
	@Test
	public void testWaYasser() {
	
		// ***** given :
		
		AminaApp aminaApp; 
		HajarApp hajarApp; 
		SomiyaApp somiyaApp; 
		MimounApp mimounApp; 
					
		aminaApp = mock(AminaApp.class);
		hajarApp = mock(HajarApp.class);
		somiyaApp = mock(SomiyaApp.class);
		mimounApp = mock(MimounApp.class);
 
		YassirApp yassirApp = new YassirApp(aminaApp, hajarApp, somiyaApp, mimounApp);
	
		// here goes all your additional instructions
				
		// ***** when :
		
		String waAminaReturnVariable = /*write the return value*/;	
		
		when(aminaApp.waAmina(a)).thenReturn(waAminaReturnVariable);
		String waHajarReturnVariable = /*write the return value*/;	
		
		when(hajarApp.waHajar(a)).thenReturn(waHajarReturnVariable);
		String achnoAHajarReturnVariable = /*write the return value*/;	
		
		when(hajarApp.achnoAHajar(a)).thenReturn(achnoAHajarReturnVariable);
		String achnoASomiyaReturnVariable = /*write the return value*/;	
		
		when(somiyaApp.achnoASomiya(a)).thenReturn(achnoASomiyaReturnVariable);
		Integer waSomyaReturnVariable = /*write the return value*/;	
		
		when(somiyaApp.waSomya(a)).thenReturn(waSomyaReturnVariable);
		Boolean waMimounReturnVariable = /*write the return value*/;	
		
		when(mimounApp.waMimoun(a)).thenReturn(waMimounReturnVariable);
		String achnoAMimounReturnVariable = /*write the return value*/;	
		
		when(mimounApp.achnoAMimoun(a)).thenReturn(achnoAMimounReturnVariable);
					
		String waYasserReturnVariable = yassirApp.waYasser(a);
				
		// ***** Then :
		
		// assertNull(waYasserReturnVariable);				
		// assertTrue(waYasserReturnVariable);				
		// assertNotNull(waYasserReturnVariable);				
		// assertFalse(waYasserReturnVariable);				
		// assertEquals(/*your expected value*/,waYasserReturnVariable);				
		// assertNotEquals(/*your expected value*/,waYasserReturnVariable);				
		// assertArrayEquals(/*your expected value*/,waYasserReturnVariable);				
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