import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Main {
	private static LocalDate currentDate = LocalDate.now();
	public static void main(String[] args) {
		Library lib = new Library();
		Librarian l = new Librarian("Indranil Mawa", lib);
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
		l.add_student("Sai");
		l.add_student("Tanvi");
		l.remove_student("Tanvi");
		l.add_faculty("Ranjit");
		l.add_faculty("Anjani");
		Student s = l.get_student("Sai");
		s.borrow("Java", currentDate, lib);
		currentDate = currentDate.plusDays(20);
		s.check_fine(currentDate);
		s.borrow("Algebra", currentDate, lib);
		s.clear_fine(50);
		s.borrow("Algebra", currentDate, lib);
		Faculty f = l.get_faculty("Ranjit");
		f.borrow("Java", currentDate, lib);
		currentDate = currentDate.plusDays(20);
		s.check_fine(currentDate);
		s.clear_fine(250);
		s.borrow("Physics", currentDate, lib);
		s.borrow("Chemistry", currentDate, lib);
		s.check_fine(currentDate);
	}
}
