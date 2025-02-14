import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Collections;

public class Student extends User {
	Account acc;
	
	public Student(String name, String password) {
		super(name, password);
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
			if(book != null) {
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
			else {
				System.out.println("Wrong Book Name!");
			}
		}
	}
	public void clear_fine(int pay) {
		LocalDate l = LocalDate.now();
		int x = this.acc.check_fine(l);
		if(pay <= x) {
			this.acc.fine = this.acc.fine - pay;
		}
		else {
			System.out.println("Payment amount larger than Total fine! Your current fine is "+x);
		}
	}
	public void return_book(String book, LocalDate l, Library lib) {
		Book b = lib.get_book(book);
		if(b!=null) {
			int x = this.acc.books.indexOf(b);
			if(x < 0) {
				System.out.println("Wrong Book Name!");
			}
			else {
				if((int)ChronoUnit.DAYS.between(l, this.acc.borrow_date.get(x)) < -15) {
					this.acc.fine = this.acc.fine - 10 * ((int)ChronoUnit.DAYS.between(l, this.acc.borrow_date.get(x))) - 150;
				}
				this.acc.books.remove(b);
				this.acc.borrow_date.remove(x);
				System.out.println("Returned "+b.title+" successfully!");
				b.avail = 1;
			}
		}
		else {
			System.out.println("Wrong Book Name!");
		}
	}
	public void check_fine(LocalDate l) {
		int x = this.acc.check_fine(l);
		System.out.println(x);
	}
	public void no_of_books() {
		System.out.println(this.acc.books.size());
	}
}
