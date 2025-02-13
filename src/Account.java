import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Account {
	ArrayList<Book> books;
	ArrayList<LocalDate> borrow_date;
	int fine;
	public Account() {
		this.books = new ArrayList<Book>();
		this.borrow_date = new ArrayList<LocalDate>();
		this.fine = 0;
	}
	public void add_book(Book b) {
		this.books.add(b);
		this.borrow_date.add(LocalDate.now());
	}
	public int check_fine(LocalDate l) {
		if(this.books.size() != 0) {
			int x = 0;
			int n = this.books.size();
			for(int i =0;i<n;i++) {
				if(ChronoUnit.DAYS.between(l, this.borrow_date.get(i)) < -15) {
					x = x - 150 - (int)(10 * (ChronoUnit.DAYS.between(l, this.borrow_date.get(i))));
				}
			}
			return (x + this.fine);
		}
		else {
			return this.fine;
		}
	}
}
