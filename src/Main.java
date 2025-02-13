import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Main {
	private static LocalDate currentDate = LocalDate.now();
	public static void main(String[] args) {
		Book b1 = new Book("Concepts of Physics", "HC Verma", 2001, "ISBN1");
		Book b2 = new Book("Java",  "Ranjit", 2005, "ISBN2");
		Book b3 = new Book("Algebra", "Sai", 2016, "ISBN3");
		Book b4 = new Book("Geometry", "Euclid", -300, "ISBN4");
		Book b5 = new Book("Biology", "Darwin", 1859, "ISBN5");
		Book b6 = new Book("Computer Science", "Turing", 1936, "ISBN6");
		Book b7 = new Book("Artificial Intelligence", "McCarthy", 1956, "ISBN7");
		Book b8 = new Book("Modern Economics", "Keynes", 1936, "ISBN8");
		Book b9 = new Book("Physics", "Newton", 1687, "ISBN9");
		Book b10 = new Book("Chemistry", "Lavoisier", 1789, "ISBN10");
		Student s1 = new Student("Sai");
		Student s2 = new Student("Tanvi");
		Faculty f1 = new Faculty("Ranjit");
		Faculty f2 = new Faculty("Anjani");
		s1.borrow(b10, currentDate);
		s1.borrow(b9, currentDate);
		s1.no_of_books();
		f1.no_of_books();
		s1.check_fine(currentDate);
		f1.borrow(b10, currentDate);
		f1.borrow(b1, currentDate);
		System.out.println(currentDate);
		currentDate = currentDate.plusDays(70);
		System.out.println(currentDate);
		f1.borrow(b7, currentDate);
		f1.return_book(b1);
		f1.borrow(b2, currentDate);
		f1.no_of_books();
		s1.borrow(b8, currentDate);
		s1.check_fine(currentDate);
		s1.return_book(b10);
		s1.return_book(b9);
		s1.check_fine(currentDate);
	}
}
