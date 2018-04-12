package footstats.dataImport;

import java.sql.*;

public class RankImport {

    private static void insertToDB() {
        try {

            String myUrl = "jdbc:mysql://localhost:3306/footstats";
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(myUrl, "root", "root");

            String query = " Insert into rank (name) values(?)";

            PreparedStatement preparedStmt = conn.prepareStatement(query);

            int i = 1;
            while(i <= 5) {
                preparedStmt.setString(1, "" + i);
                preparedStmt.execute();
                i++;
            }

            conn.close();
        } catch (Exception e) {
            System.out.println("Got an exception!");
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        insertToDB();
    }

}
