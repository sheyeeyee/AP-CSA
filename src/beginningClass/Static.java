package beginningClass;

public class Static {
	private String name;
	
	public Static(String name) {
		this.name = name;
	}
	
	public String serve() {
		return "Pow! I just served.";
	}
	
	public static String rankings() { //static is that an object doesn't need to call (it doesn't make sense for an object to call rankings)
		return "1) Djokovic   2) Nadal   3) Federer";
	}
	
	public static void main(String[] args) {
		Static me = new Static("Shelley");
		System.out.println(me.serve());
		System.out.println(rankings());
	}
	
}