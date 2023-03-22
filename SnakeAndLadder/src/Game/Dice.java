package Game;
import java.util.concurrent.ThreadLocalRandom;

public class Dice {
	
	public int diceRoll() {
		return ThreadLocalRandom.current().nextInt(1, 6+1);
		
	}

}
