import java.util.Scanner;

public class Run {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		City lakeTown = new City();
		School school = lakeTown.getSchool();
		CityHall cityHall = lakeTown.getCityHall();
		lakeTown.getInfo();
		
		boolean done = false;
		do {
			System.out.println("Choose an option:\n\t1. Pay Everyone\n\t2. See who's in school\n\t3. See who's in City Hall\n\t4. List info again\n\t5. Exit");
			int choice = input.nextInt();

			switch(choice) {
				case 1:
				lakeTown.payDay();
				break;

				case 2:
				school.getTeachers();
				System.out.println("");
				school.getStudents();
				System.out.printf("%d/%d teachers are in school.\n", school.getNumTeachers(), lakeTown.getTeachers());
				System.out.printf("%d/%d kids are in school.\n", school.getNumStudents(), lakeTown.getStudents());
				break;

				case 3:
				cityHall.getOfficers();
				break;

				case 4:
				lakeTown.getInfo();
				break;

				default:
				done = true;
			}
		} while (!done);
		input.close();
	}
}