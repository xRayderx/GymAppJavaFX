import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXComboBox;
import io.github.palexdev.materialfx.controls.MFXDatePicker;
import io.github.palexdev.materialfx.controls.MFXRadioButton;
import io.github.palexdev.materialfx.controls.MFXTableColumn;
import io.github.palexdev.materialfx.controls.MFXTableView;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class dashboardController {

    @FXML
    private MFXButton addInstructorBtn;

    @FXML
    private MFXTextField apellidoClienteAddField;

    @FXML
    private TableColumn<?, ?> apellidoClienteColPago;

    @FXML
    private MFXTableColumn<?> apellidoTablaClienteCol;

    @FXML
    private MFXButton bcvCheckBtn;

    @FXML
    private Label bcvCheckLbl;

    @FXML
    private TableColumn<?, ?> bcvTasaColPago;

    @FXML
    private TableColumn<?, ?> cedulaClienteColPago;

    @FXML
    private MFXTextField cedulaCodigoClienteAddField;

    @FXML
    private TableColumn<?, ?> cedulaColPago;

    @FXML
    private MFXTextField cedulaInstructorAddField;

    @FXML
    private MFXComboBox<?> cedulaLetraClienteCombo;

    @FXML
    private MFXTableColumn<?> cedulaTablaClienteCol;

    @FXML
    private MFXButton cleanInstructorFieldBtn;

    @FXML
    private AnchorPane clienteForm;

    @FXML
    private MFXButton dashboardCloseBtn;

    @FXML
    private MFXButton dashboardMinBtn;

    @FXML
    private MFXButton deleteClienteBtn;

    @FXML
    private MFXButton deleteInstructorBtn;

    @FXML
    private TextArea direccionClienteAddField;

    @FXML
    private MFXTextField direccionInstructorAddField;

    @FXML
    private MFXTableColumn<?> direccionTablaClienteCol;

    @FXML
    private MFXButton editClienteBtn;

    @FXML
    private MFXButton editInstructorBtn;

    @FXML
    private MFXComboBox<?> estatusClienteAddCombo;

    @FXML
    private MFXTableColumn<?> estatusClienteCol;

    @FXML
    private TableColumn<?, ?> estatusClienteColPago;

    @FXML
    private TableColumn<?, ?> fechaClienteInicioColPago;

    @FXML
    private TableColumn<?, ?> fechaClienteVencPago;

    @FXML
    private MFXDatePicker fechaInicioClienteAddDate;

    @FXML
    private TableColumn<?, ?> fechaInicioColPago;

    @FXML
    private MFXTableColumn<?> fechaPagoClienteCol;

    @FXML
    private MFXDatePicker fechaVencClienteAddDate;

    @FXML
    private TableColumn<?, ?> fechaVencColPago;

    @FXML
    private MFXTableColumn<?> fechaVencimientoClienteCol;

    @FXML
    private TableColumn<?, ?> idPago;

    @FXML
    private AreaChart<?, ?> ingresoMensualChart;

    @FXML
    private MFXButton limpiarCamposClienteBtn;

    @FXML
    private MFXButton mainDashboardBtn;

    @FXML
    private AnchorPane mainForm;

    @FXML
    private MFXButton mainInstructorBtn;

    @FXML
    private AnchorPane mainInstructorForm;

    @FXML
    private MFXButton mainLogoutBtn;

    @FXML
    private MFXButton mainMiembrosBtn;

    @FXML
    private MFXButton mainPagosBtn;

    @FXML
    private AnchorPane mainSidebar;

    @FXML
    private AnchorPane mainStatForm;

    @FXML
    private TableColumn<?, ?> metodoClienteColPago;

    @FXML
    private TableColumn<?, ?> montoColPago;

    @FXML
    private MFXTextField montoPagoBtn;

    @FXML
    private MFXTextField nombreClienteAddField;

    @FXML
    private TableColumn<?, ?> nombreClienteColPago;

    @FXML
    private MFXTextField nombreInstructorAddField;

    @FXML
    private MFXTextField nombreInstructorAddField1;

    @FXML
    private MFXTableColumn<?> nombreTablaClienteCol;

    @FXML
    private MFXButton nuevoClienteAddBtn;

    @FXML
    private MFXButton pagadoPagoBtn;

    @FXML
    private MFXTextField pagoCedulaCampo;

    @FXML
    private MFXComboBox<?> pagoCedulaLetra;

    @FXML
    private MFXRadioButton pagoDiaBtn;

    @FXML
    private AnchorPane pagoForm;

    @FXML
    private MFXRadioButton pagoMesBtn;

    @FXML
    private MFXComboBox<?> pagoMesCombo;

    @FXML
    private MFXComboBox<?> pagoMesCombo1;

    @FXML
    private MFXRadioButton pagoSemanaBtn;

    @FXML
    private MFXButton reciboPagoBtn;

    @FXML
    private MFXComboBox<?> sexoClienteAddCombo;

    @FXML
    private MFXComboBox<?> sexoInstructorAddCombo;

    @FXML
    private MFXTableColumn<?> sexoTablaClienteCol;

    @FXML
    private MFXTableView<?> tablaInstructorTable;

    @FXML
    private MFXTextField telefonoCasaInstructorAddField;

    @FXML
    private MFXTextField telefonoClienteAddField;

    @FXML
    private TableColumn<?, ?> telefonoClienteColPago;

    @FXML
    private MFXTextField telefonoMovilInstructorAddField;

    @FXML
    private MFXTableColumn<?> telefonoTablaClienteCol;

    @FXML
    private Label totalIngresosLabel;

    @FXML
    private Label totalInstructoresLabel;

    @FXML
    private Label totalMiembrosLabel;

    @FXML
    private Label totalPagoLbl;

    private PreparedStatement prepare;
    private Connection conexion;
    private ResultSet resultado;
    private Statement statement;

    public ObservableList<instructoresDatos> instructoresDatosLista(){
        ObservableList<instructoresDatos> instDatos = FXCollections.observableArrayList();

        String sql = "SELECT * FROM instructores";
        conexion = conexionBdd.conexion();

        try{
            prepare = conexion.prepareStatement(sql);
            resultado = prepare.executeQuery();

            instructoresDatos id;

            while(resultado.next()){
                id = new instructoresDatos(resultado.getString("id_instructor"), resultado.getString("nombres"),
                        resultado.getString("apellidos"), resultado.getString("direccion"), resultado.getString("sexo"),
                        resultado.getString("telefono_movil"), resultado.getString("telefono_casa"), resultado.getString("estatus"));
                instDatos.add(id);
            }

        }catch(Exception e){
            System.out.println(e);
        }
        return instDatos;
    }

    private ObservableList<instructoresDatos> instructoresListaDatos;
    public void instructoresMostrarDatos(){
        instructoresListaDatos = instructoresDatosLista();
    }

    private String sexo[] = {"Masculino", "Femenino", "Otro"};
    public void instructorSexoLista(){
        List<String> sexoLista = new ArrayList<>();

        for(String data: sexo){
            sexoLista.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(sexoLista);
        sexoInstructorAddCombo.setItems(listData);
        sexoClienteAddCombo.setItems(listData);

    }

    private String status[] = {"Activo", "Inactivo"};

    public void estatusCliente(){
        List<String> estatusLista = new ArrayList<>();

        for (String data: status){
            estatusLista.add(data);
        }

        ObservableList stList = FXCollections.observableArrayList(estatusLista);
        estatusClienteAddCombo.setItems(stList);
    }

    public void cambiarForm(ActionEvent event) {

        if (event.getSource() == mainDashboardBtn) {

            mainStatForm.setVisible(true);
            mainInstructorForm.setVisible(false);
            clienteForm.setVisible(false);
            pagoForm.setVisible(false);

            //dashboardNM();
            //dashboardTC();
            //dashboardTI();
            //dashboardChart();

        } else if (event.getSource() == mainInstructorBtn) {

            mainStatForm.setVisible(false);
            mainInstructorForm.setVisible(true);
            clienteForm.setVisible(false);
            pagoForm.setVisible(false);

            // TO UPDATE WHEN YOU CLICK THE MENU BUTTON LIKE COACHES BUTTON
            instructorSexoLista();
            //coachStatusList();
            //coachesShowData();

        } else if (event.getSource() == mainMiembrosBtn) {


            mainStatForm.setVisible(false);
            mainInstructorForm.setVisible(false);
            clienteForm.setVisible(true);
            pagoForm.setVisible(false);

            //membersShowData();
            instructorSexoLista();
            //membersSchedule();
            estatusCliente();

        } else if (event.getSource() == mainPagosBtn) {

            mainStatForm.setVisible(false);
            mainInstructorForm.setVisible(false);
            clienteForm.setVisible(false);
            pagoForm.setVisible(true);

            //paymentShowData();
            //paymentMemberId();
            //paymentName();

        }

    }
    public void minimizar(){
        Stage stage = (Stage) mainForm.getScene().getWindow();
        stage.setIconified(true);
    }
    public void mainCerrar(){javafx.application.Platform.exit();}

    private double x,y;
    public void cerrarSesion(){
        try {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Mensaje de confirmación");
            alert.setHeaderText(null);
            alert.setContentText("Estás seguro que quieres cerrar la sesión?");
            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {

                // TO HIDE YOUR DASHBOARD FORM
                mainLogoutBtn.getScene().getWindow().hide();

                // LINK YOUR LOGIN FORM
                Parent root = FXMLLoader.load(getClass().getResource("loginView.fxml"));

                Stage stage = new Stage();
                Scene scene = new Scene(root);

                root.setOnMousePressed((MouseEvent event) -> {
                    x = event.getSceneX();
                    y = event.getSceneY();
                });

                root.setOnMouseDragged((MouseEvent event) -> {
                    stage.setX(event.getScreenX() - x);
                    stage.setY(event.getScreenY() - y);

                    stage.setOpacity(.8);
                });

                root.setOnMouseReleased((MouseEvent event) -> {
                    stage.setOpacity(1);
                });

                stage.initStyle(StageStyle.TRANSPARENT);

                stage.setScene(scene);
                stage.show();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
