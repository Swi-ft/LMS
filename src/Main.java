import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Main {
	private static LocalDate currentDate = LocalDate.now();
	public static void main(String[] args) {
		Library lib = new Library();
		Librarian l = new Librarian("Indranil", lib, "LibPass1");
		l.add_librarian();
		l.add_book("Concepts of Physics", "HC Verma", 2001, "ISBN1");
		l.add_book("Java",  "Ranjit", 2005, "ISBN2");
		l.add_book("Algebra", "Sai", 2016, "ISBN3");
		l.add_book("Geometry", "Euclid", -300, "ISBN4");
		l.add_book("Biology", "Darwin", 1859, "ISBN5");
		l.add_book("Computer Science", "Turing", 1936, "ISBN6");
		l.add_book("Artificial Intelligence", "McCarthy", 1956, "ISBN7");
		l.add_book("Modern Economics", "Keynes", 1936, "ISBN8");
		l.add_book("Physics", "Newton", 1687, "ISBN9");
		l.add_book("Chemistry", "Lavoisier", 1789, "ISBN10");
		l.add_student("Sai","StudPass1");
		l.add_student("Tanvi","StudPass2");
		l.add_faculty("Ranjit","FacPass1");
		l.add_faculty("Anjani","FacPass2");
		runApp(lib);
	}
	private static void runApp(Library lib) {
		Scanner S = new Scanner(System.in);
		System.out.println("Are you a 1.Student, 2.Faculty, 3.Librarian or 4.Do you want to Close App?");
		int type = S.nextInt();
		if(type == 1) {
			System.out.println("Enter Name");
			String name = S.next();
			System.out.println("Enter Password");
			String password = S.next();
			int verified = lib.verify_student(name, password);
			if(verified == 1) {
				Student stud = lib.get_student(name);
				studentApp(lib, stud);
			}
			else {
				runApp(lib);
			}
		}
		else if(type == 2) {
			System.out.println("Enter Name");
			String name = S.next();
			System.out.println("Enter Password");
			String password = S.next();
			int verified = lib.verify_faculty(name, password);
			if(verified == 1) {
				Faculty fac = lib.get_faculty(name);
				facultyApp(lib, fac);
			}
			else {
				runApp(lib);
			}
		}
		else if(type == 3) {
			System.out.println("Enter Name");
			String name = S.next();
			System.out.println("Enter Password");
			String password = S.next();
			int verified = lib.verify_librarian(name, password);
			if(verified == 1) {
				Librarian l = lib.get_librarian(name);
				libApp(lib, l);
			}
			else {
				runApp(lib);
			}
		}
		else if(type == 4) {
			return;
		}
		else {
			System.out.println("Enter Valid Command : ");
			runApp(lib);
		}
	}
	private static void studentApp(Library lib, Student s) {
		Scanner S = new Scanner(System.in);
		System.out.println("What would you like to do (Enter number): 1. Borrow a Book, 2. Return a Book, 3. Check Fines, 4. Clear pending Fines, 5. Check Books Borrowed, 6. Log-Out ?");
		int next = S.nextInt();
		if(next == 1) {
			lib.show_avail_books();
			System.out.println("Enter Book name");
			String book = S.next();
			s.borrow(book, currentDate, lib);
			studentApp(lib, s);
		}
		else if(next == 2) {
			System.out.println("Books you borrowed right now :");
			s.show_books_borrowed();
			System.out.println("Enter Book name");
			String book = S.next();
			s.return_book(book, currentDate, lib);
			studentApp(lib, s);
		}
		else if(next == 3) {
			s.check_fine(currentDate);
			studentApp(lib, s);
		}
		else if(next == 4) {
			System.out.println("Enter Amount : ");
			int add = S.nextInt();
			s.clear_fine(add);
			studentApp(lib, s);
		}
		else if(next == 5) {
			s.show_books_borrowed();
			studentApp(lib, s);
		}
		else if(next == 6){
			runApp(lib);
		}
		else {
			System.out.println("Enter Valid Command : ");
			studentApp(lib, s);
		}
	}
	private static void facultyApp(Library lib, Faculty f) {
		Scanner S = new Scanner(System.in);
		System.out.println("What would you like to do (Enter number): 1. Borrow a Book, 2. Return a Book, 3. Check Books Borrowed, 4. Log-Out ?");
		int next = S.nextInt();
		if(next == 1) {
			lib.show_avail_books();
			System.out.println("Enter Book name");
			String book = S.next();
			f.borrow(book, currentDate, lib);
			facultyApp(lib, f);
		}
		else if(next == 2) {
			System.out.println("Books you borrowed right now :");
			f.show_books_borrowed();
			System.out.println("Enter Book name");
			String book = S.next();
			f.return_book(book, lib);
			facultyApp(lib, f);
		}
		else if(next == 3) {
			f.show_books_borrowed();
			facultyApp(lib, f);
		}
		else if(next == 4){
			runApp(lib);
		}
		else {
			System.out.println("Enter Valid Command : ");
			facultyApp(lib, f);
		}
	}
	private static void libApp(Library lib, Librarian l) {
		Scanner S = new Scanner(System.in);
		System.out.println("What would you like to do (Enter number): 1. Add Book, 2. Delete a Book, 3.Add Student, 4.Remove Student, 5.Add Faculty, 6.Remove Faculty, 7. Log-Out ?");
		int next = S.nextInt();
		if(next == 1) {
			System.out.println("Enter Book Title, Author, Year, ISBN");
			String s1 = S.next();
			String s2 = S.next();
			int i = S.nextInt();
			String s3 = S.next();
			l.add_book(s1, s2, i, s3);
			libApp(lib, l);
		}
		else if(next == 2) {
			lib.show_avail_books();
			System.out.println("Enter Book name");
			String book = S.next();
			l.remove_book(book);
			libApp(lib, l);
		}
		else if(next == 3){
			System.out.println("Enter Name :");
			String name = S.next();
			System.out.println("Enter Password :");
			String password = S.next();
			l.add_student(name, password);
			libApp(lib,l);
		}
		else if(next == 4) {
			System.out.println("Enter Name :");
			String name = S.next();
			l.remove_student(name);
			libApp(lib,l);
		}
		else if(next == 5) {
			System.out.println("Enter Name :");
			String name = S.next();
			System.out.println("Enter Password :");
			String password = S.next();
			l.add_faculty(name, password);
			libApp(lib,l);
		}
		else if(next == 6) {
			System.out.println("Enter Name :");
			String name = S.next();
			l.remove_faculty(name);
			libApp(lib,l);
		}
		else if(next == 7){
			runApp(lib);
		}
		else {
			System.out.println("Enter Valid Command : ");
			libApp(lib, l);
		}
	}
}
