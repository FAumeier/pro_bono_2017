package RauAPI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by flo on 22.04.17.
 */
public class Util {

    public static final Connection connection = createConnection();

    private static Connection createConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver"); // Der Datenbanktreiber wird geladen mit Class.forName()
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // Sorgt dafür dass die Klasse, deren Name ich als Parameter übergebe vom Classloader geladen wird und anschließend zur Verfügung steht.
        // Wird die Klasse nicht gefunden ClassNotFoundException
        Connection connection = null; //Hier wird die Verbindung zur Datenbank hergestellt. Das Format des Parameters ist:
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pro-bono?useSSL=false&" + "user=root&password=probono");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //jdbc:[Subprotokoll]:[Datenquellenname][;Attribut=Wert]
        //derby:memory bedeutet das die Daten alle im Zwischenspeicher gespeichert werden. Also sind die Daten nicht persistent
        //Wenn memory weggelassen wird erwartet Derby einen Pfad im Dateisystem -> Persistenz
        //create=true bedeutet dass die Datenbank angelegt werden soll - wenn noch nicht vorhanden.
        return connection;
    }
}
