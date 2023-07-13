import java.sql.Connection;
import java.sql.DriverManager;

public class conexionBdd {

    public Connection conexion(String dbname, String user, String pass) {
        Connection conexion = null;

        try {
            Class.forName("org.postgresql.Driver");
            String schema = "public";
            conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?currentSchema=" + schema + dbname, user, pass);
            if (conexion != null) {
                System.out.println("Conexion a la base de datos establecida");
            } else {
                System.out.println("Conexion a la base de datos fallida");
            }

        } catch (Exception e){
            System.out.println(e);
        }
        return conexion;
    }

}
