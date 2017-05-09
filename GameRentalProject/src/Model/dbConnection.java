package Model;
import java.sql.Connection;
import java.sql.DriverManager;

public class dbConnection {

	public static void main(String[] args) {
        String dbName = "GameRentalDb";
        // Wywo³anie metody polacz, która zwraca obiekt typu Connection
        Connection polaczenie = polacz(dbName);       
    }
    
    /**
     * Metoda odpowiedzialna za po³¹czenie z baz¹
     * jeœli bazy nie ma to zostaje utworzona
     */
    public static Connection polacz(String baza) {
        Connection polaczenie = null;
        try {
            // Wskazanie jaki rodzaj bazy danych bêdzie wykorzystany, tu sqlite
            Class.forName("org.sqlite.JDBC");           
            // Po³¹czenie, wskazujemy rodzaj bazy i jej nazwê
            polaczenie = DriverManager.getConnection("jdbc:sqlite:"+baza+".db");
            System.out.println("Po³¹czy³em siê z baz¹ "+baza);
        } catch (Exception e) {
            System.err.println("B³¹d w po³¹czeniu z baz¹: \n" + e.getMessage());
            return null;
        }
        return polaczenie;
    }
	
	
}
