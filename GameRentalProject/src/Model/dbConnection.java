package Model;
import  Entity.Game;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class dbConnection {
	
	private static String dbName = "GameRentalDb";

	public static void main(String[] args) {
        // Wywo³anie metody connect, która zwraca obiekt typu Connection
        Connection polaczenie = connect();      
        //createDb(polaczenie);    //<- utworzyc jesli baza pusta
        Game gra1 = new Game();
        gra1.setId(1);
        gra1.setName("Carcassonne");
        gra1.setWorth(70);
        addGameToDb(gra1);
        
    }
    
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
	
    //funkcja tworz¹ca wszystkie tabele bazy (puste)
    public static void createDb(Connection polaczenie) {
        // Obiekt odpowiadaj¹cy za wykonanie instrukcji
            Statement stat = null;
            try {
                stat = polaczenie.createStatement();
                // polecenie SQL tworz¹ce tabelê game
                String tabelaSQL = "CREATE TABLE " + "game"
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
        public static void addGameToDb(Game game) {
            Connection polaczenie = null;
            Statement stat = null;
            try {
                Class.forName("org.sqlite.JDBC");
                polaczenie = DriverManager.getConnection("jdbc:sqlite:" + dbName + ".db");
     
                stat = polaczenie.createStatement();
                //#TODO automatyczne nadawanie id
                String dodajSQL = "INSERT INTO " + "game" + " (ID, name, worth) "
                        + "VALUES ("
                        + game.getId() + ","
                        + "'" + game.getName() + "',"
                        + + game.getWorth()
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
}
