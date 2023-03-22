package Game;
import java.util.concurrent.ThreadLocalRandom;

public class Players {
		
	private String name;
	private int id;
	
	public Players(String name) {
		this.name = name;
		this.id = ThreadLocalRandom.current().nextInt(0, 10);
	}
	
	public String getName() {
		return name;
	}
	
	public int getId() {
		return id;
	}
	
	
}
