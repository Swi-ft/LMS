import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Librarian extends User {
	private Library lib;
	
	public Librarian(String name, Library lib, String password) {
		super(name, password);
		this.lib = lib;
	}
	public void add_student(String x, String password) {
		Student s = new Student(x, password);
		lib.add_student(s);
		System.out.println("Added Student "+x);
	}
	public void add_librarian() {
		lib.add_librarian(this);
		System.out.println("Added Student "+this.name);
	}
	public void add_faculty(String x, String password) {
		Faculty f = new Faculty(x, password);
		lib.add_faculty(f);
		System.out.println("Added Faculty "+x);
	}
	public void add_book(String title, String Author, int year, String ISBN) {
		Book b = new Book(title, Author, year, ISBN);
		lib.add_book(b);
		System.out.println("Added "+title);
	}
	public void remove_student(String x) {
		lib.remove_student(x);
	}
	public void remove_faculty(String x) {
		lib.remove_faculty(x);
	}
	public void remove_book(String x) {
		lib.remove_book(x);
	}
	public Student get_student(String x) {
		return lib.get_student(x);
	}
	public Faculty get_faculty(String x) {
		return lib.get_faculty(x);
	}
}
