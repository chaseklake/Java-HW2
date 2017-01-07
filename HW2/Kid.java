public class Kid extends Person {
	private static int kidCount = 0;
	private String faveCandy;

	public Kid(String f, String l, String num, int a, String c) {
		super(f, l, num, a);
		faveCandy = c;
		kidCount++;
	}

	public Kid() {
		super();
		this.setFName(this.getFName() + " Jr.");
		this.setLName(this.getLName() + " " + this.getCount());
		faveCandy = "Lollipops";
		kidCount++;
	}

	public String getFaveCandy() { return faveCandy; }
	public void setFaveCandy(String c) { faveCandy = c; }
}