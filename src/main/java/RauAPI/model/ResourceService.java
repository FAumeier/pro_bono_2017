package RauAPI.model;

import RauAPI.Util;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by flo on 22.04.17.
 */
@Component
public class ResourceService {

    private final Connection connection = Util.connection;

    private static void preparedStatmentExample(Connection connection) throws SQLException {
        //Prepared Statement verwenden: Schneller. Da bereits kompiliert, optimiert und wiederverwendbar. Schützt ausserdem gegen SQL injections
        String inserts = "INSERT INTO USERS VALUES (?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(inserts);
        statement.setInt(1, 10);
        statement.setString(2, "Ursula");
        statement.setInt(3, 44);
        statement.setString(4, "w");
        statement.executeUpdate();
    }

    public List<Resource> getAllRessources() {
        List<Resource> resources = new ArrayList<>();
        String query = "SELECT * FROM resources;";
        ResultSet resultSet = null;
        Resource resource;
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                String link = resultSet.getString("link");
                int type = resultSet.getInt("type");
                int user = resultSet.getInt("user");
                resource = new Resource(id, title, description, link, type, user);
                resources.add(resource);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resources;
    }

    public Resource getResource(long id) {
        Resource resource = null;
        ResultSet resultSet = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM resources WHERE id=?");
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                long resourceId = resultSet.getLong("id");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                String link = resultSet.getString("link");
                int type = resultSet.getInt("type");
                int user = resultSet.getInt("user");
                resource = new Resource(resourceId, title, description, link, type, user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resource;
    }

    public int addResource(Resource resource) {
        Resource newResource = null;
        String title = resource.getTitle();
        String description = resource.getDescription();
        String link = resource.getLink();
        int type = resource.getType();
        int user = resource.getUser();
        int result = 0;
        String inserts = "INSERT INTO resources(title, description, link, type, user) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(inserts);
            statement.setString(1, title);
            statement.setString(2, description);
            statement.setString(3, link);
            statement.setInt(4, type);
            statement.setInt(5, user);
            result = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
