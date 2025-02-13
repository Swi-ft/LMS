import java.util.ArrayList;

public class Library {
	private ArrayList<Book> books = new ArrayList<Book>();
	
	public Book get_book(String title) {
		int n = books.size();
		int x = -1;
		for(int i =0;i<n;i++) {
			if(books.get(i).title == title) {
				x = i;
				break;
			}
		}
		if(x == -1) {
			System.out.println("Book Doesn't Exist!");
			return null;
		}
		else {
			return books.get(x);
		}
	}
	void add_book(Book b) {
		books.add(b);
	}
	void remove_book(String x) {
		int n = books.size();
		boolean removed = false;
		for(int i =0;i<n;i++) {
			if(books.get(i).title == x) {
				removed = true;
				break;
			}
		}
		if(removed) {
			System.out.println("Successfully removed "+x);
		}
		else {
			System.out.println("Book not found");
		}
	}
}
