package service;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;


public class ConnectToStudentDatabase {
    public static double percentageCalculation(String teacherName) {//connects to database and returns percentages of yes for specific teacher
        String hostname = "holynamesacademy.database.windows.net";
        String dbName = "GlassDome";
        String user = "hna-admin";
        String password = "HolyNames123";
        String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;" + "hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostname, dbName, user, password);
        Connection connection;
        double percentage = 0;
        int num = 0;

        try {
            connection = DriverManager.getConnection(url);
            String schema = connection.getSchema();
            System.out.println("Successful connection - Schema: " + schema);

            System.out.println("Query data example:");
            System.out.println("==============================");

            String selectSql = " SELECT * from Student; ";

            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(selectSql)) {


                while (resultSet.next()) {
                    if(resultSet.getString(1).equals(teacherName))
                    {
                        if(resultSet.getString(4)=="Yes")
                        {
                            percentage++;
                        }
                        num++;
                    }

                }
                percentage = percentage/num;

                connection.close();

            } catch (SQLException e)//handle any errors
            {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    return percentage;
    }

    public static ArrayList<Recommendations> recommendationInfo()
    {
        ArrayList<Recommendations> studentRecommendation = new ArrayList <Recommendations>();
        Recommendations newRecommendation = new Recommendations("","",0,"","");

            String hostname = "holynamesacademy.database.windows.net";
            String dbName = "GlassDome";
            String user = "hna-admin";
            String password = "HolyNames123";
            String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;" + "hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostname, dbName, user, password);
            Connection connection;
            try
            {
                connection = DriverManager.getConnection(url);

                String query = "SELECT * FROM Student";//SQL SELECT query
                Statement st = connection.createStatement();//create the java statement

                ResultSet rs = st.executeQuery(query);//execute the query and get a java resultset

                while(rs.next())//iterate through java resultset
                {
                    String teacherName = rs.getString("student_TeacherName");
                    newRecommendation.setTeacherName(teacherName);
                    String name = rs.getString("student_Name");
                    newRecommendation.setStudentName(name);
                    int classYear = rs.getInt("student_ClassYear");
                    newRecommendation.setClassYear(classYear);
                    String recommendation = rs.getString("student_Recommendation");
                    newRecommendation.setRecommendation(recommendation);
                    String why = rs.getString("student_Why");
                    newRecommendation.setWhy(why);

                    studentRecommendation.add(newRecommendation);
                    //printing out the results
                    System.out.format(newRecommendation.getTeacherName(), newRecommendation.getStudentName(), newRecommendation.getClassYear(), newRecommendation.getRecommendation(), newRecommendation.getWhy());

                }
                st.close();
            }
            catch (SQLException e)//handle any errors
            {
                e.printStackTrace();
            }

        return studentRecommendation;
    }
}

