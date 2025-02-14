import java.util.ArrayList;

public class Library {
	private ArrayList<Book> books = new ArrayList<Book>();
	private ArrayList<Student> students = new ArrayList<Student>();
	private ArrayList<Faculty> faculty = new ArrayList<Faculty>();
	private ArrayList<Librarian> librarian = new ArrayList<Librarian>();
	
	public Book get_book(String title) {
		int n = books.size();
		int x = -1;
		for(int i =0;i<n;i++) {
			if(books.get(i).title.equals(title)) {
				x = i;
				break;
			}
		}
		if(x == -1) {
			System.out.println("Book Doesn't Exist!");
			return null;
		}
		else {
			return books.get(x);
		}
	}
	public Librarian get_librarian(String title) {
		int n = librarian.size();
		int x = -1;
		for(int i =0;i<n;i++) {
			if(librarian.get(i).name.equals(title)) {
				x = i;
				break;
			}
		}
		if(x == -1) {
			System.out.println("User Doesn't Exist!");
			return null;
		}
		else {
			return librarian.get(x);
		}
	}
	public Student get_student(String x) {
		int n = students.size();
		boolean removed = false;
		int loc = -1;
		for(int i = 0;i<n;i++) {
			if(students.get(i).name.equals(x)) {
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
			if(faculty.get(i).name.equals(x)) {
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
	public int verify_student(String name, String password) {
		int n = students.size();
		int x = -1;
		for(int i =0;i<n;i++) {
			if(name.equals(students.get(i).name)) {
				if(students.get(i).password.equals(password)) {
					System.out.println("Successfully Logged In");
					return 1;
				}
			}
		}
		if(x == -1) {
			System.out.println("Entered Wrong Name!");
			return 0;
		}
		else {
			System.out.println("Entered Wrong Password!");
			return 0;
		}
	}
	public int verify_faculty(String name, String password) {
		int n = faculty.size();
		int x = -1;
		for(int i =0;i<n;i++) {
			if(name.equals(faculty.get(i).name)) {
				if(faculty.get(i).password.equals(password)) {
					System.out.println("Successfully Logged In");
					return 1;
				}
			}
		}
		if(x == -1) {
			System.out.println("Entered Wrong Name!");
			return 0;
		}
		else {
			System.out.println("Entered Wrong Password!");
			return 0;
		}
	}
	public int verify_librarian(String name, String password) {
		int n = librarian.size();
		int x = -1;
		for(int i =0;i<n;i++) {
			if(name.equals(librarian.get(i).name)) {
				if(librarian.get(i).password.equals(password)) {
					System.out.println("Successfully Logged In");
					return 1;
				}
			}
		}
		if(x == -1) {
			System.out.println("Entered Wrong Name!");
			return 0;
		}
		else {
			System.out.println("Entered Wrong Password!");
			return 0;
		}
	}
	void add_book(Book b) {
		books.add(b);
	}
	void add_student(Student s) {
		students.add(s);
	}
	void add_librarian(Librarian l) {
		librarian.add(l);
	}
	void add_faculty(Faculty f) {
		faculty.add(f);
	}
	void remove_book(String x) {
		int n = books.size();
		boolean removed = false;
		for(int i =0;i<n;i++) {
			if(books.get(i).title == x) {
				removed = true;
				break;
			}
		}
		if(removed) {
			System.out.println("Successfully removed "+x);
		}
		else {
			System.out.println("Book not found");
		}
	}
	void remove_student(String x) {
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
	void remove_faculty(String x) {
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
	public void show_avail_books() {
		int n = books.size();
		int count  = 1;
		for(int i = 0;i<n;i++) {
			if(books.get(i).avail == 1) {
				System.out.print(count+". "+books.get(i).title+" ");
				count++;
			}
		}
		System.out.println();
	}
}

