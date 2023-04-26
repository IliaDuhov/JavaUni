import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class DbConnection{
    private final String url = "**********************";
    private final String user = "*******";
    private final String password = "******";
    @Bean
    public Connection connect() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to Postgre server");
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery("SELECT * FROM public.\"Department\"");
//            while(rs.next()){
//                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
//            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return con;
    }
}
