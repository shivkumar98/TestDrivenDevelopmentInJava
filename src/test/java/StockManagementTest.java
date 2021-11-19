

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;



public class StockManagementTest {
	
	ExternalDataService testWebService;
	ExternalDataService testDatabaseService;
	StockManager stockManager;
	String isbn = "0140177396";
	
	@Before
	public void setup() {
		System.out.println("setup running");
		testWebService = mock(ExternalDataService.class);
		testDatabaseService = mock(ExternalDataService.class);
		stockManager = new StockManager();
		stockManager.setDatabaseService(testDatabaseService);
		stockManager.setWebServive(testWebService);
	}
	
	
	@Test
	public void testCanGetACorrectLocatorCode() {


		stockManager.setWebServive(testWebService);
		stockManager.setDatabaseService(testDatabaseService);
		
		when(testDatabaseService.lookup(anyString())).thenReturn(new Book("0140177396", "J. Steinback", "Of Mice and Men"));		
		String isbn = "0140177396";
		String locatorCode = stockManager.getLocator(isbn);
		assertEquals("7396J4", locatorCode);
	}
	
	@Test
	public void databaseIsUsedIdDataIsPresent() {
		when(testWebService.lookup(anyString())).thenReturn(null);
		when(testDatabaseService.lookup(anyString())).thenReturn(new Book("0140177396", "J. Steinback", "Of Mice and Men"));	
		stockManager.getLocator(isbn);
		verify(testDatabaseService).lookup(isbn);
		verify(testWebService, never()).lookup(isbn);
	}
	
	
	@Test 
	public void testCanGetACorrectLocatorCodeUsingMockitoStub() {

		when(testDatabaseService.lookup("0140177396")).thenReturn(new Book("0140177396", "J. Steinbeck", "Of Mice And Men"));
		
		String locatorCode = stockManager.getLocator(isbn);
		assertEquals("7396J4", locatorCode);
		
	}
	
	
}
