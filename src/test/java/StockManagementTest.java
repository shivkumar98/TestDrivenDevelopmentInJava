

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;

import java.util.List;

import org.junit.Test;

public class StockManagementTest {
	
	@Test
	public void getLocatorCodeWorks() {
		String isbn = "0141023570";
		ExternalDataService externalDataServiceImp = new ExternalDataService() {
			
			public Book lookup(String isbn) {
				return new Book(isbn, "J. Steinback", "Of Mice and Men");
			}
		};
		
		ExternalDataService testDataService = new ExternalDataService() {
			
		
			public Book lookup(String isbn) {
				// TODO Auto-generated method stub
				return null;
			}
		};
		
		StockManager stockManager = new StockManager();
		stockManager.setWebServive(externalDataServiceImp);
		stockManager.setDatabaseService(testDataService);
		String LocatorCode = stockManager.getLocator(isbn);
		assertEquals("3570S4", LocatorCode);
	}
	
	//testing behaviour 
	// is book in local db? no? then use webService
	// we now want to test qhich method is called
	//database will call BookLookup
	// if nothing returned WebService will call lookup
	
	//if data is in database use database data
	@Test
	public void dataBaseIsUsedIfDateInDatabase() {
		ExternalDataService dataService = mock(ExternalDataService.class);
		ExternalDataService webService = mock(ExternalDataService.class);
		
		/*
		 * String isbn = "0141023570";
		StockManager stockManager = new StockManager();
		stockManager.setWebServive(webService);
		stockManager.setDatabaseService(dataService);
		String LocatorCode = stockManager.getLocator(isbn);
		assertEquals("3570S4", LocatorCode);
		 */
		
	}
	
	//if data not in database use webservice data 
	@Test
	public void webServiceIsUsedIfDataNotInDatabase() {
		
	}
	
	 @Test
	  public void test() {
	    List<String> mockList = mock(List.class);
	    mockList.add("First");
	    when(mockList.get(0)).thenReturn("Mockito");
	    when(mockList.get(1)).thenReturn("JCG");
	    assertEquals("Mockito", mockList.get(0));
	    assertEquals("JCG", mockList.get(1));
	  }
}
