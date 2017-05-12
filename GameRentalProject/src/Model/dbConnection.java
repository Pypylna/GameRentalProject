package Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import Entity.Game;

public class dbConnection {
	
	private static String dbName = "GameRentalDb";

//	public static void main(String[] args) {
//        // Wywo³anie metody connect, która zwraca obiekt typu Connection
//
//        try{
//        	int newId = Game.getFirstFreeId();
//        	System.out.println(newId);
//        }catch (Exception e) {
//            System.out.println("jakis blad " + e.getMessage());
//        }
//        
//    }
    
    /**
     * Metoda odpowiedzialna za po³¹czenie z baz¹
     * jeœli bazy nie ma to zostaje utworzona
     */
    public static Connection connect() {
        Connection polaczenie = null;
        try {
            // Wskazanie jaki rodzaj bazy danych bêdzie wykorzystany, tu sqlite
            Class.forName("org.sqlite.JDBC");           
            // Po³¹czenie, wskazujemy rodzaj bazy i jej nazwê
            polaczenie = DriverManager.getConnection("jdbc:sqlite:"+dbName+".db");
            System.out.println("Po³¹czy³em siê z baz¹ "+dbName);
        } catch (Exception e) {
            System.err.println("B³¹d w po³¹czeniu z baz¹: \n" + e.getMessage());
            return null;
        }
        return polaczenie;
    }
	
    //funkcja tworz¹ca wszystkie tabele bazy (puste) -> #TODO dodaæ jakiegoœ ifa, ¿eby nie wykonywa³ wszystkich instrukcji, jeœli jest coœ w bazie
    public static void createDb(Connection polaczenie) {
        // Obiekt odpowiadaj¹cy za wykonanie instrukcji
            Statement stat = null;
            try {
                stat = polaczenie.createStatement();
                // polecenie SQL tworz¹ce tabelê game
                String tabelaSQL = "CREATE TABLE IF NOT EXISTS " + "game"
                        + " (ID INT PRIMARY KEY     NOT NULL,"
                        + " name           CHAR(50)    NOT NULL, "
                        + " worth          INT) ";
                // wywo³anie polecenia
                stat.executeUpdate(tabelaSQL);
                // zamykanie wywo³ania i po³¹czenia
                stat.close();
                polaczenie.close();
            } catch (Exception e) {
                System.out.println("Nie mogê stworzyæ tabeli " + e.getMessage());
            }
        }
    	
    //Uwaga, przy wielu danych i bazach na serwerach, efektywniej jest robiæ kilka insertów na jednym po³¹czeniu, zamiast co chwila otwieraæ i zamykaæ kolejne po³¹czenia

        

}
