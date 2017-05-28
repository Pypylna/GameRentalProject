package Entity;


//import java.sql.Connection;
//import java.sql.Statement;
import java.sql.*;
import Model.dbConnection;
import Repository.GameRepository;

public class Game {
//#todo uzupelnic klase o pozostale pola i metody
	//#todo gettery i settery do name i worth
	private static float MAXWORTH = 10000;
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
	
	
    public void addGameToDb() {
    	int newId = GameRepository.getFirstFreeId();
    	this.setId(newId);
    	
        Connection polaczenie = dbConnection.connect();
        Statement stat = null;
        try {
            stat = polaczenie.createStatement();
            // automatyczne nadawanie id
            String dodajSQL = "INSERT INTO " + "game" + " (ID, name, worth) "
                    + "VALUES ("
                    + this.getId() + ","
                    + "'" + this.getName() + "',"
                    + + this.getWorth()
                    + "  );";
            stat.executeUpdate(dodajSQL);
            stat.close();
            polaczenie.close();
            // Komunikat i wydrukowanie koñcowej formy polecenia SQL
            System.out.println("Polecenie: \n" + dodajSQL + "\n wykonane.");
        } catch (Exception e) {
            System.out.println("Nie mogê dodaæ danych " + e.getMessage());
        }
     }

    
    public static float convertMaxWorth(String maxWorth){
    	float maxW;
    	
    	if(maxWorth.isEmpty()) maxW = Game.MAXWORTH;
		else maxW = Float.parseFloat(maxWorth.replaceAll(",", "."));
    	
    	return maxW;
    }
    
    public static float convertMinWorth(String minWorth){
    	float minW;
    	
    	if(minWorth.isEmpty()) minW = 0;
		else minW = Float.parseFloat(minWorth.replaceAll(",", "."));
    	
    	return minW;
    }
}
