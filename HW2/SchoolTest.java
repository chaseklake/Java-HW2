import java.util.ArrayList;

public class SchoolTest {
	public static void main(String[] args) {
		School testSchool = new School();
		// It's like attack of the Joe Schmoe clones
		ArrayList<Teacher> teachers = new ArrayList<Teacher>();
		for (int i = 0; i < 30; i++) {
			Teacher teach = new Teacher();
			teachers.add(teach);
		}
		ArrayList<Kid> students = new ArrayList<Kid>();
		for (int i = 0; i < 500; i++) {
			Kid kid = new Kid();
			students.add(kid);
		}

		for (Teacher t : teachers)
			testSchool.addTeacher(t);
		for (Kid k : students)
			testSchool.addStudent(k);

		testSchool.getTeachers();
		testSchool.getStudents();
	}
}