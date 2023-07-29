import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.util.Duration;

public class AppController {

    @FXML
    private AnchorPane la_left;

    @FXML
    private MFXButton la_registroBtn;

    @FXML
    private MFXButton la_loginBtn;

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
        conexion = conexionBdd.conexion();
        String sql = "SELECT * FROM public.usuarios WHERE usuarios.usuario = (?) and usuarios.clave = (?)";
        try {

            prepare = conexion.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
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

                    si_loginBtn.getScene().getWindow().hide();

                    Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));

                    Stage stage = new Stage();
                    Scene scene = new Scene(root);

                    stage.initStyle(StageStyle.TRANSPARENT);

                    stage.setScene(scene);
                    stage.show();

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

    public void registro(){

        String sql = "INSERT INTO public.usuarios (usuario,correo,clave) VALUES (?,?,?)";

        conexion = conexionBdd.conexion();

        try{
            Alert alerta;

            if (re_correo.getText().isEmpty() || re_usuario.getText().isEmpty() || re_clave.getText().isEmpty()){
                alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Error inesperado");
                alerta.setHeaderText(null);
                alerta.setContentText("Porfavor, llena todos los campos");
                alerta.showAndWait();
            } else{
                if(re_clave.getText().length()<8){
                    alerta = new Alert(Alert.AlertType.ERROR);
                    alerta.setTitle("Error inesperado");
                    alerta.setHeaderText(null);
                    alerta.setContentText("Porfavor, ingresa una contraseña de 8 o mas caracteres");
                    alerta.showAndWait();
                }else{
                    prepare = conexion.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                    prepare.setString(1,re_usuario.getText());
                    prepare.setString(2, re_correo.getText());
                    prepare.setString(3, re_clave.getText());

                    prepare.executeUpdate();


                    alerta = new Alert(Alert.AlertType.INFORMATION);
                    alerta.setTitle("Mensaje de informacion");
                    alerta.setHeaderText(null);
                    alerta.setContentText("Usuario registrado");
                    alerta.showAndWait();


                    re_correo.setText("");
                    re_usuario.setText("");
                    re_clave.setText("");
                }
            }
        } catch (Exception e){
            System.out.println(e);
        }

    }

    public void registroSlider(){

        TranslateTransition slider1 = new TranslateTransition();
        slider1.setNode(la_left);
        slider1.setToX(300);
        slider1.setDuration(Duration.seconds(0.5));
        slider1.play();

        slider1.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                la_registroLabel.setText("Registrate");
                la_registroBtn.setVisible(false);
                la_loginBtn.setVisible(true);
            }
        });

    }

    public void loginSlider(){

        TranslateTransition slider1 = new TranslateTransition();
        slider1.setNode(la_left);
        slider1.setToX(0);
        slider1.setDuration(Duration.seconds(.5));
        slider1.play();

        slider1.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                la_registroLabel.setText("Inicio de sesion");
                la_registroBtn.setVisible(true);
                la_loginBtn.setVisible(false);
            }
        });
    }
    public void mainClose() {
        javafx.application.Platform.exit();
    }
}
