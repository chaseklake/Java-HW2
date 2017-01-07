import java.util.ArrayList;

public class CityHall extends Building {
	//Variables
	ArrayList<Police> officers = new ArrayList<Police>();
	private int officerCount = 0;

	//Constructors
	public CityHall() {
		super();
	}

	public CityHall(String n, String a) {
		super(n,a);
	}

	//Accessor
	public int getNumOfficers() { return officerCount; }

	//Accessing the array of officers
	public void addOfficer(Police p) {
		officers.add(p);
		officerCount++;
	}

	public void getOfficers() {
		System.out.printf("Officers in %s:\n", this.getName());
		for (Police p : officers)
			System.out.printf("%s %s (Officer number %d)\n", p.getFName(), p.getLName(), p.getEmployeeID());
	}
}