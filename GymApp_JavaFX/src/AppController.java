import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AppController {

    @FXML
    private AnchorPane la_left;

    @FXML
    private MFXButton la_registroBtn;

    @FXML
    private Label la_registroLabel;

    @FXML
    private AnchorPane login_form;

    @FXML
    private MFXButton main_close;

    @FXML
    private AnchorPane main_log_form;

    @FXML
    private MFXPasswordField re_clave;

    @FXML
    private MFXTextField re_correo;

    @FXML
    private MFXButton re_registrar;

    @FXML
    private MFXTextField re_usuario;

    @FXML
    private AnchorPane reg_form;

    @FXML
    private MFXButton si_loginBtn;

    @FXML
    private MFXPasswordField si_pass;

    @FXML
    private MFXTextField si_usuario;

    private Connection conexion;
    private PreparedStatement prepare;
    private ResultSet resultado;

    public void login() {
        conexion = conexionBdd.conexion("proyectodb", "postgres", "admin");
        String sql = "SELECT * FROM public.usuarios WHERE usuarios.usuario = (?) and usuarios.clave = (?)";
        try {
            prepare = conexion.prepareStatement(sql);
            prepare.setString(1, si_usuario.getText());
            prepare.setString(2, si_pass.getText());
            resultado = prepare.executeQuery();

            Alert alerta;

            if (si_usuario.getText().isEmpty() || si_pass.getText().isEmpty()) {
                alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Error inesperado");
                alerta.setHeaderText(null);
                alerta.setContentText("Porfavor llena todos los campos");
                alerta.showAndWait();

            }else{
                if(resultado.next()){
                    alerta = new Alert(Alert.AlertType.INFORMATION);
                    alerta.setTitle("Mensaje de informacion");
                    alerta.setHeaderText(null);
                    alerta.setContentText("Inicio de sesion exitosa");
                    alerta.showAndWait();
                }else{
                    alerta = new Alert(Alert.AlertType.ERROR);
                    alerta.setTitle("Error inesperado");
                    alerta.setHeaderText(null);
                    alerta.setContentText("Usuario y contraseña incorrectos");
                    alerta.showAndWait();
                }

            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    public void main_close() {
        javafx.application.Platform.exit();
    }
}
