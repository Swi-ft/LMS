import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Faculty extends User {
	Account acc;
	
	public Faculty(String name, String password) {
		super(name, password);
		this.acc = new Account();
	}
	public void borrow(String book, LocalDate l, Library lib) {
		Book b = lib.get_book(book);
		if(b != null) {
			if(this.acc.books.size() >= 5) {
				System.out.println("Can't borrrow book (5 books laready borrowed)");
			}
			else if(this.acc.books.size() == 0) {
				if(b.avail == 1) {
					this.acc.books.add(b);
					this.acc.borrow_date.add(l);
					b.avail = 0;
				}
				else {
					System.out.println("Book not Available");
				}
			}
			else if((int)ChronoUnit.DAYS.between(l, Collections.min(this.acc.borrow_date)) < -30) {
				System.out.println("Can't borrrow book (Return book(s) borrowed 30 days or more back)");
			}
			else {
				if(b.avail == 1) {
					this.acc.books.add(b);
					this.acc.borrow_date.add(LocalDate.now());
					b.avail = 0;
					System.out.println("Book "+b.title+" Taken by "+this.name+"!");
				}
				else {
					System.out.println("Book not Available");
				}
			}
		}
		else {
			System.out.println("Wrong Book Name!");
		}
	}
	public void return_book(String book, Library lib) {
		Book b = lib.get_book(book);
		if(b!=null) {
			int x = this.acc.books.indexOf(b);
			if(x < 0) {
				System.out.println("Wrong Book Name!");
			}
			else {
				this.acc.books.remove(b);
				this.acc.borrow_date.remove(x);
				b.avail = 1;
			}
		}
		else {
			System.out.println("Wrong Book Name!");
		}
	}
	public void no_of_books() {
		System.out.println(this.acc.books.size());
	}
}
