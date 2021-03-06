import java.util.ArrayList;

public class School extends Building {
	//Variables
	private ArrayList<Teacher> teachers = new ArrayList<Teacher>();
	private ArrayList<Kid> students = new ArrayList<Kid>();
	private int teacherCount = 0;
	private int kidCount = 0;

	//Constructor
	public School(String n, String a) {
		super(n, a);
	}

	public School() {
		super();
	}

	//Variable Accessor functions
	public int getNumTeachers() { return teacherCount; }
	public int getNumStudents() { return kidCount; }

	//Accessing the occupants
	//Pushes a given teacher into the "teachers" ArrayList
	public void addTeacher(Teacher t) {
		teachers.add(t);
		teacherCount++;
	}

	// Prints out all the teachers' first and last names in the "teachers" ArrayList
	public void getTeachers() {
		System.out.printf("All teachers at %s:\n", this.getName());
		for (Teacher t : teachers)
			System.out.printf("%s %s\n", t.getFName(), t.getLName());
	}

	public void addStudent(Kid k) {
		students.add(k);
		kidCount++;
	}

	public void getStudents() {
		System.out.printf("All students at %s:\n", this.getName());
		for (Kid k : students)
			System.out.printf("%s %s\n", k.getFName(), k.getLName());
	}
}