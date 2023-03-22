package Game;
import java.util.*;
public class Main {
	
	public static void main(String[] args) {
		
		List<Snakes> snakes = new ArrayList<>();
		List<Ladder> ladder = new ArrayList<>();
		List<Players> players = new ArrayList<>();
		
		
        Scanner input  = new Scanner(System.in);
        
        int noOfSnakes = input.nextInt();
        for(int i=0;i<noOfSnakes;i++) {
        	int start = input.nextInt();
        	int end = input.nextInt();
        	if(start>99 || end >99 && start<1 || end<1) {
        		System.out.println("Invalid input. Please enter value between 1 to 99 range");
        		break;
        	}
        	snakes.add(new Snakes(start, end));
        }
        
        int noOfLadder = input.nextInt();
        for(int i=0;i<noOfLadder;i++) {
        	int start = input.nextInt();
        	int end = input.nextInt();
        	if(start>99 || end>99 && start<1 || end<1) {
        		System.out.println("Invalid input. Please enter value between 1 to 99 range");
        		break;
        	}
        	ladder.add(new Ladder(start, end));
        }
        
        int noOfPlayers = input.nextInt();
        for(int i=0;i<noOfPlayers;i++) {
        	players.add(new Players(input.next()));
        }
        Play p1 = new Play();
        p1.setSnakes(snakes);
        p1.setLadder(ladder);
        p1.setPlayers(players);
        p1.letsPlay();
	}

}
