import java.util.ArrayList;
import java.util.Random;

public class City {
	private ArrayList<Person> citizens = new ArrayList<Person>();
	private Random rand = new Random();
	private School school = new School();
	private CityHall cityHall = new CityHall();
	private int maxTeachers;
	private int maxOfficers;
	private int maxKids;
	
	public City() {
		Init();
	}
	
	// Initializes the city with random people in random places
	private void Init() {
		maxTeachers = (rand.nextInt(30) + 1);
		maxOfficers = (rand.nextInt(100) + 1);
		maxKids = (rand.nextInt(500) + 1);
		
		for (int i = 0; i < maxTeachers; i++) {
			Teacher teach = new Teacher();
			citizens.add(teach);
			if (rand.nextInt()%10 < 9) // ~90% chance of teachers being in school
				school.addTeacher(teach);
		}

		for (int i = 0; i < maxOfficers; i++) {
			Police officer = new Police();
			citizens.add(officer);
			if (rand.nextInt()%3 == 1) // ~33% chance officers are in City Hall (most should be "out on patrol")
				cityHall.addOfficer(officer);
		}

		for (int i = 0; i < maxKids; i++) {
			Kid kid = new Kid();
			citizens.add(kid);
			if (rand.nextInt()%10 < 7) // ~70% chance of students being in school
				school.addStudent(kid);
		}
	}

	// Get basic info from our program
	public void getInfo() {
		System.out.printf("Number of teachers: %d\n", maxTeachers);
		System.out.printf("Number of teachers in school: %d\n", school.getNumTeachers());
		System.out.printf("Number of kids: %d\n", maxKids);
		System.out.printf("Number of kids in school: %d\n", school.getNumStudents());
		System.out.printf("Number of officers: %d\n", maxOfficers);
		System.out.printf("Number of officers in City Hall: %d\n\n", cityHall.getNumOfficers());
	}

	// Pays all of the employees
	public void payDay() {
		for (Person p : citizens) {
			if (p instanceof Employee) {
				((Employee)p).getPaid(); 
			}
		}
	}
	
	// Accessing functions
	public int getTeachers() { return maxTeachers; }
	public int getOfficers() { return maxOfficers; }
	public int getStudents() { return maxKids; }
	public School getSchool() { return school; }
	public CityHall getCityHall() { return cityHall; }
}