

public class StockManager {

	private ExternalDataService webService;
	private ExternalDataService databaseService;
	
	public void setWebServive(ExternalDataService dataService) {
		this.webService = dataService;
	}
	
	public String getLocator(String isbn) {
		Book book = databaseService.lookup(isbn);
		if (book == null) {
			book = webService.lookup(isbn);
		}
		StringBuilder sb = new StringBuilder();
		sb.append(isbn.substring(isbn.length()-4));
		sb.append(book.getAuthor().split(" ")[1].substring(0, 1));
		sb.append(book.getTitle().split(" ").length);
		return sb.toString();
	}

	public void setDatabaseService(ExternalDataService testDataService) {
		this.databaseService = testDataService;
		
	}

}
