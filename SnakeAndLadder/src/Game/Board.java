package Game;
import java.util.*;

public class Board {
	
	private int boardSize;
	private List<Snakes> snakeList;
	private List<Ladder> ladderList;
	private Map<Integer, Integer> playerPiece;
	
	public Board(int boardSize) {
		this.boardSize = boardSize;
		this.snakeList = new ArrayList<>();
		this.ladderList = new ArrayList<>();
		this.playerPiece = new HashMap<>();
	}
	
	public int getBoardSize() {
		return this.boardSize;
	}
	
	public List<Snakes> getsnakeList(){
		return this.snakeList;
	}
	
	public void setsnakeList(List<Snakes> snakeList) {
		this.snakeList = snakeList;
	}
	
	public List<Ladder> getladderList(){
		return this.ladderList;
	}
	
	public void setladderlist(List<Ladder> ladderList) {
		this.ladderList = ladderList;
	}
	
	public Map<Integer, Integer> getplayerPiece(){
		return this.playerPiece;
	}
	
	public void setplayerPiece(Map<Integer, Integer> playerPiece) {
		this.playerPiece = playerPiece;
	}
	

}
