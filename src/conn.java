import java.sql.*;
import java.io.*;

public class conn {

    public void addToDB() throws FileNotFoundException {

    }
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:identifier.sqlite");
            System.out.println(conn.isValid(10));
            Statement stmt = conn.createStatement();


            BufferedReader br = new BufferedReader(new FileReader("lines.txt"));
            int asdf = 1;
            
            String inputLine = br.readLine();
            while (inputLine != null) {
                System.out.println(inputLine);
                String query = String.format("insert into TEST values ('%s')", inputLine);
                stmt.executeUpdate(query);
                inputLine = br.readLine();
            }
            conn.commit();
            System.out.println("##added all");
            ResultSet rs = stmt.executeQuery("select * from test");

            while (rs.next()){
                System.out.println(rs.getString(1));
            }

        } catch (SQLException | FileNotFoundException throwables) {
            throwables.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
