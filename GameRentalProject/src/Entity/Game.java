package Entity;

public class Game {
//#todo uzupelnic klase o pozostale pola i metody
	//#todo gettery i settery do name i worth
	
	private int id;
	private String name;
	private float worth;		//wartosc
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getWorth() {
		return worth;
	}

	public void setWorth(float worth) {
		this.worth = worth;
	}
	
	public int getId(){
		return this.id;
	}
	
	public void setId(int id){
		this.id = id;
	}
}
