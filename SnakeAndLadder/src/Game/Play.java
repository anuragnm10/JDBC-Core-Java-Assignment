package Game;
import java.util.*;
public class Play {
	
	static final int size = 100;
	List<Snakes> snakes;
	List<Ladder> ladder;
	Queue<Players> players;
	Map<Integer, Integer> piece;
	Dice d;
	public Play() {
		this.snakes = new ArrayList<>();
		this.ladder = new ArrayList<>();
		this.players = new LinkedList<>();
		this.piece = new HashMap<>();
		this.d = new Dice();
	}
	
	Board b1 = new Board(size);
	
	public void setPlayers(List<Players> players) {
		List<Players> plyr = players;
		for(Players val : plyr) {
			this.players.add(val);
			piece.put(val.getId(), 0);
		}
		b1.setplayerPiece(piece);
	}
	
	public void setSnakes(List<Snakes> snakes) {
		b1.setsnakeList(snakes);
	}
	
	public void setLadder(List<Ladder> ladder) {
		b1.setladderlist(ladder);
	}
	
	
	boolean gameOver = false;
	public void letsPlay() {
		while(!gameOver) {
			int diceNum  = d.diceRoll();
			Players curPlayer = players.remove();
			movePlayer(curPlayer, diceNum);
			if(b1.getplayerPiece().get(curPlayer.getId()) == b1.getBoardSize()) {
				System.out.println(curPlayer.getName()+" wins the game");
				gameOver = true;
			}else {
				players.add(curPlayer);
			}
		}
	}

	private void movePlayer(Players curPlayer, int diceNum) {
		int currPos = b1.getplayerPiece().get(curPlayer.getId());
		int newPos = currPos+diceNum;
		int size = b1.getBoardSize();
		if(newPos > size) {
			newPos = currPos;
		}else { 
			for(Snakes s : b1.getsnakeList()) {
				if(s.getS()==newPos) {
					newPos = s.getE();
				}
			}
			
			for(Ladder l : b1.getladderList()) {
				if(l.getS()==newPos) {
					newPos = l.getE();
				}
			}
			
		}
		
		b1.getplayerPiece().put(curPlayer.getId(), newPos);
		System.out.println(curPlayer.getName()+" rolled a "+diceNum+" and moved from "+currPos+" to "+newPos);
	}
	

}
