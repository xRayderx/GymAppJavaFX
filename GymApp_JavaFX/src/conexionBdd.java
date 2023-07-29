import java.sql.Connection;
import java.sql.DriverManager;

public class conexionBdd {

    public static Connection conexion() {
        Connection conexion = null;

        try {
            Class.forName("org.postgresql.Driver");
            String dbname = "proyectodb";
            String user = "java";
            String pass = "java";
            conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbname, user, pass);
            if (conexion != null) {
                System.out.println("Conexion a la base de datos establecida");
            } else {
                System.out.println("Conexion a la base de datos fallida");
            }

        } catch (Exception e){
            System.out.println(e);
            e.printStackTrace();
        }
        return conexion;
    }

}
