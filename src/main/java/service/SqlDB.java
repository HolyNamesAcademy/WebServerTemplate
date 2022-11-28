package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import java.util.List;
import java.sql.*;

@Component
public class SqlDB {
    private String hostName;
    private final String dbName;
    private final String user;
    private final String password;
    private final String connectionUrl;

    @Autowired
    public SqlDB(Environment env) {
        hostName = env.getProperty("db.hostname");
        dbName = env.getProperty("db.db_name");
        user = env.getProperty("db.user");
        password = env.getProperty("db.password");

        connectionUrl = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true"
                + "hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
    }

    // TODO: Add methods to talk to your DB here
    /*
     * Take created post information and add it into the database
     * @param line - 
     */ 
    public static void uploadPost(Post post){
        Connection connect = DriverManger.getConnection(url);
        try {
            // creating the query
            String query1 = "INSERT INTO Post ([PlantID], [Age], [PlantName], [Species], [Status], [NameOfUser], [Caption], [PhotoURL])";
            String value = getValues(post);
            query1 += "VALUES (" + value + ")";

            // adding the post to the table
            Statement st = connection.createStatement();
            st.execute(query1, Statement.RETURN_GENERATED_KEYS);
        } catch (Exception e) {
            System.err.println("Got an error in tags query! ");
            System.err.println(e.getMessage());
        }
    }

    public ArrayList<Post> viewPosts() {
        ArrayList<Post> posts = new ArrayList<>();
        return posts;
    }

    private String getValues(Post post) {
        ArrayList<String> temp = new ArrayList<>();
        temp.add(post.getPlantID);
        temp.add(post.getAge);
        temp.add("N'" + post.getPlantName + "'");
        temp.add("N'" + post.getSpecies + "'");
        temp.add("N'" + post.getStatus + "'");
        temp.add("N'" + post.getNameOfUser + "'");
        temp.add("N'" + post.getCaption + "'");
        temp.add("N'" + post.getPhotoUrl + "'");

        String result = "";
        for (int i = 0; i < temp.length(); i++) {
            result += data;
            if (i != temp.length - 2) {
                result += ", ";
            }
        }
        return result;
    }
}