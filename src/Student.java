import java.time.LocalDate;

public class Student extends User {
	Account acc;
	
	public Student(String name) {
		super(name);
		this.acc = new Account();
	}
	public void borrow(Book b, LocalDate l) {
		this.acc.check_fine(l);
		if(this.acc.books.size() >= 3) {
			System.out.println("Can't borrrow book (3 books already borrowed)");
		}
		else if(this.acc.fine > 0) {
			System.out.println("Can't borrrow book (Please pay fine first)");
		}
		else {
			if(b.avail == 1) {
				this.acc.books.add(b);
				this.acc.borrow_date.add(l);
				b.avail = 0;
			}
			else {
				System.out.println("Book not Available");
			}
		}
	}
	public void clear_fine(int pay) {
		this.acc.fine = this.acc.fine - pay;
	}
	public void return_book(Book b) {
		int x = this.acc.books.indexOf(b);
		this.acc.books.remove(b);
		this.acc.borrow_date.remove(x);
	}
	public void check_fine(LocalDate l) {
		this.acc.check_fine(l);
		System.out.println(this.acc.fine);
	}
	public void no_of_books() {
		System.out.println(this.acc.books.size());
	}
}
