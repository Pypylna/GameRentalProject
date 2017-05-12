package Entity;


//import java.sql.Connection;
//import java.sql.Statement;
import java.sql.*;
import Model.dbConnection;

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
	
	
    public void addGameToDb() {
    	int newId = Game.getFirstFreeId();
    	this.setId(newId);
    	
        Connection polaczenie = dbConnection.connect();
        Statement stat = null;
        try {
            stat = polaczenie.createStatement();
            //#TODO automatyczne nadawanie id
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
    
    
    public static int getFirstFreeId(){
    	int id=0;
    	
    	Connection polaczenie = dbConnection.connect();
        Statement stat = null;
        try {
            stat = polaczenie.createStatement();
            //#TODO automatyczne nadawanie id
            String SQL = "SELECT MAX(id) AS max FROM game";
            
            ResultSet wynik = stat.executeQuery(SQL);
            id = wynik.getInt("max");
            
            wynik.close();
            stat.close();
            polaczenie.close();
            // Komunikat i wydrukowanie koñcowej formy polecenia SQL
            System.out.println("Polecenie: \n" + SQL + "\n wykonane.");
        } catch (Exception e) {
            System.out.println("B³¹d przy sprawdzaniu max id " + e.getMessage());
        }
    	
    	return id+1;
    }
    
    
}
