package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import com.microsoft.sqlserver.jdbc.SQLServerException;

public class UserInput {
    private static final String hostname = "holynamesacademy.database.windows.net";
    private static final String dbName = "GlassDome";
    private static final String user = "hna-admin";
    private static final String password = "HolyNames123";
    private static final String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;" + "hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostname, dbName, user, password);

    public static void User() throws Exception, SQLException
    {
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(url);

            System.out.println("Connection Established ln");
            Statement query = conn.createStatement();

            String SQL1 = "INSERT INTO dbo.Student VALUES " + "('Bri', 1880, 'Yes', 'Love treats')";

            query.addBatch(SQL1);

            query.executeBatch();

            conn.close();
        }
        catch (SQLServerException sqe)
        {
            System.out.println("A result set was generated for update.");
            sqe.printStackTrace();
        }
        catch (java.sql.BatchUpdateException bae)
        {
            System.out.println("Executed Queries! Terminating Connection...");
            bae.printStackTrace();
        }
    }
}
