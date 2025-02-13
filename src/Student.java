import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Collections;

public class Student extends User {
	Account acc;
	
	public Student(String name) {
		super(name);
		this.acc = new Account();
	}
	public void borrow(String b, LocalDate l, Library lib) {
		int y = this.acc.check_fine(l);
		if(this.acc.books.size() >= 3) {
			System.out.println("Can't borrrow book (3 books already borrowed)");
		}
		else if(y > 0) {
			System.out.println("Can't borrrow book (Please pay fine first)");
		}
		else {
			Book book = lib.get_book(b);
			if(book.avail == 1) {
				this.acc.books.add(book);
				this.acc.borrow_date.add(l);
				book.avail = 0;
				System.out.println("Book "+book.title+" Taken by "+this.name+"!");
			}
			else {
				System.out.println("Book not Available");
			}
		}
	}
	public void clear_fine(int pay) {
		this.acc.fine = this.acc.fine - pay;
	}
	public void return_book(Book b, LocalDate l) {
		int x = this.acc.books.indexOf(b);
		if((int)ChronoUnit.DAYS.between(l, this.acc.borrow_date.get(x)) < -15) {
			this.acc.fine = this.acc.fine - 10 * ((int)ChronoUnit.DAYS.between(l, this.acc.borrow_date.get(x))) - 150;
		}
		this.acc.books.remove(b);
		this.acc.borrow_date.remove(x);
		System.out.println("Returned "+b.title+" successfully!");
	}
	public void check_fine(LocalDate l) {
		int x = this.acc.check_fine(l);
		System.out.println(x);
	}
	public void no_of_books() {
		System.out.println(this.acc.books.size());
	}
}
