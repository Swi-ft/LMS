import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Librarian extends User {
	ArrayList<Student> students = new ArrayList<Student>();
	ArrayList<Faculty> faculty = new ArrayList<Faculty>();
	private Library lib;
	
	public Librarian(String name, Library lib) {
		super(name);
		this.lib = lib;
	}
	public void add_student(String x) {
		Student s = new Student(x);
		students.add(s);
		System.out.println("Added Student "+x);
	}
	public void add_faculty(String x) {
		Faculty f = new Faculty(x);
		faculty.add(f);
		System.out.println("Added Faculty "+x);
	}
	public void add_book(String title, String Author, int year, String ISBN) {
		Book b = new Book(title, Author, year, ISBN);
		lib.add_book(b);
		System.out.println("Added "+title);
	}
	public void remove_student(String x) {
		int n = students.size();
		boolean removed = false;
		for(int i = 0;i<n;i++) {
			if(students.get(i).name == x) {
				students.remove(i);
				removed = true;
				break;
			}
		}
		if(removed) {
			System.out.println("Removed Student "+x);
		}
		else {
			System.out.println("User Doesn't Exist");
		}
	}
	public void remove_faculty(String x) {
		int n = faculty.size();
		boolean removed = false;
		for(int i = 0;i<n;i++) {
			if(faculty.get(i).name == x) {
				faculty.remove(i);
				removed = true;
				break;
			}
		}
		if(removed) {
			System.out.println("Removed Faculty "+x);
		}
		else {
			System.out.println("User Doesn't Exist");
		}
	}
	public void remove_book(String x) {
		lib.remove_book(x);
	}
	public Student get_student(String x) {
		int n = students.size();
		boolean removed = false;
		int loc = -1;
		for(int i = 0;i<n;i++) {
			if(students.get(i).name == x) {
				loc = i;
				removed = true;
				break;
			}
		}
		if(removed) {
			return students.get(loc);
		}
		else {
			System.out.println("User Doesn't Exist");
			return null;
		}
	}
	public Faculty get_faculty(String x) {
		int n = faculty.size();
		boolean removed = false;
		int loc = -1;
		for(int i = 0;i<n;i++) {
			if(faculty.get(i).name == x) {
				loc = i;
				removed = true;
				break;
			}
		}
		if(removed) {
			return faculty.get(loc);
		}
		else {
			System.out.println("User Doesn't Exist");
			return null;
		}
	}
}
