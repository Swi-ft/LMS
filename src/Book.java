public class Book {
	String title, Author, ISBN;
	int year;
	int avail;
	
	public Book(String title, String Author, int year, String ISBN) {
		this.Author = Author;
		this.year = year;
		this.title = title;
		this.ISBN = ISBN;
		this.avail = 1;
	}
}
