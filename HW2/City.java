import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class City {
	public static void main(String[] args) {		
		Scanner input = new Scanner(System.in);
		Random rand = new Random();

		ArrayList<Person> citizens = new ArrayList<Person>();
		School school = new School();
		CityHall cityHall = new CityHall();

		int maxTeachers = (rand.nextInt(30) + 1);
		int maxOfficers = (rand.nextInt(100) + 1);
		int maxKids = (rand.nextInt(500) + 1);

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

		getInfo(school, cityHall, maxTeachers, maxKids, maxOfficers);
		
		boolean done = false;
		do {
			System.out.println("Choose an option:\n\t1. Pay Everyone\n\t2. See who's in school\n\t3. See who's in City Hall\n\t4. List info again\n\t5. Exit");
			int choice = input.nextInt();

			switch(choice) {
				case 1:
				payDay(citizens);
				break;

				case 2:
				school.getTeachers();
				System.out.println("");
				school.getStudents();
				System.out.printf("%d/%d teachers are in school.\n", school.getNumTeachers(), maxTeachers);
				System.out.printf("%d/%d kids are in school.\n", school.getNumStudents(), maxKids);
				break;

				case 3:
				cityHall.getOfficers();
				break;

				case 4:
				getInfo(school, cityHall, maxTeachers, maxKids, maxOfficers);
				break;

				default:
				done = true;
			}
		} while (!done);
	}

	// Get basic info from our program
	public static void getInfo(School s, CityHall c, int t, int k, int o) {
		System.out.printf("Number of teachers: %d\n", t);
		System.out.printf("Number of teachers in school: %d\n", s.getNumTeachers());
		System.out.printf("Number of kids: %d\n", k);
		System.out.printf("Number of kids in school: %d\n", s.getNumStudents());
		System.out.printf("Number of officers: %d\n", o);
		System.out.printf("Number of officers in City Hall: %d\n\n", c.getNumOfficers());
	}

	// Pays all of the employees
	public static void payDay(ArrayList<Person> c) {
		for (Person p : c) {
			if (p instanceof Employee) {
				((Employee)p).getPaid(); 
			}
		}
	}
}