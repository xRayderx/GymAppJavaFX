import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXComboBox;
import io.github.palexdev.materialfx.controls.MFXDatePicker;
import io.github.palexdev.materialfx.controls.MFXRadioButton;
import io.github.palexdev.materialfx.controls.MFXTableColumn;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.sql.*;
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
    private TableColumn<instructoresDatos, String> apellidos_inst_col;

    @FXML
    private MFXButton bcvCheckBtn;

    @FXML
    private Label bcvCheckLbl;

    @FXML
    private TableColumn<?, ?> bcvTasaColPago;

    @FXML
    private TableColumn<instructoresDatos, String> casa_inst_col;

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
    private TableColumn<instructoresDatos, String> cedula_inst_col;

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
    private TableColumn<instructoresDatos, String> direccion_inst_col;

    @FXML
    private MFXButton editClienteBtn;

    @FXML
    private TableView<instructoresDatos> instructoresTablaVista;

    @FXML
    private MFXButton editInstructorBtn;

    @FXML
    private MFXComboBox<?> estatusClienteAddCombo;

    @FXML
    private MFXTableColumn<?> estatusClienteCol;

    @FXML
    private TableColumn<?, ?> estatusClienteColPago;

    @FXML
    private MFXComboBox<?> estatusInstructorAddCombo;

    @FXML
    private TableColumn<instructoresDatos, String> estatus_inst_col;

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
    private TableColumn<instructoresDatos, String> movil_inst_col;

    @FXML
    private MFXTextField nombreClienteAddField;

    @FXML
    private TableColumn<?, ?> nombreClienteColPago;

    @FXML
    private MFXTextField nombreInstructorAddField;

    @FXML
    private MFXTextField apellidosInstructorAddField;

    @FXML
    private MFXTableColumn<?> nombreTablaClienteCol;

    @FXML
    private TableColumn<instructoresDatos, String> nombre_inst_col;

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
    private TableColumn<instructoresDatos, String> sexo_inst_col;

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

    @FXML
    private MFXComboBox<?> casaPrefijoInstCombo;
    @FXML
    private MFXComboBox<?> movilPrefijoInstCombo;

    private PreparedStatement prepare;
    private Connection conexion;
    private ResultSet resultado;
    private Statement statement;
    private String prefijosFijo[] = {"0243", "0244", "0246"};
    public void prefijosFijoLista(){
        List<String> prefLista = new ArrayList<>();

        for(String data: prefijosFijo){
            prefLista.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(prefLista);
        casaPrefijoInstCombo.setItems(listData);
    }

    private String prefijosMovil[] = {"0412", "0414", "0424", "0416", "0426"};
    public void prefijosMovilLista(){
        List<String> prefLista = new ArrayList<>();

        for(String data: prefijosMovil){
            prefLista.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(prefLista);
        movilPrefijoInstCombo.setItems(listData);
    }

    public void camposVacios(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Faltan campos");
        alert.setHeaderText(null);
        alert.setContentText("Faltan campos, porfavor llena todos los campos");
        alert.showAndWait();
    }

    public void instructoresNuevoBoton(){
        String sql = "INSERT INTO public.instructores(\n" +
                "\tid_instructor, nombres, apellidos, direccion, sexo, telefono_movil, telefono_casa, estatus)\n" +
                "\tVALUES (?, ?, ?, ?, ?, ?, ?, ?);";

        conexion = conexionBdd.conexion();

        try {
            Alert alert;

            if (cedulaInstructorAddField.getText().isEmpty() || nombreInstructorAddField.getText().isEmpty() || apellidosInstructorAddField.getText().isEmpty()
                    || direccionInstructorAddField.getText().isEmpty() || sexoInstructorAddCombo.getSelectionModel().getSelectedItem() == null
                    || movilPrefijoInstCombo.getSelectionModel().getSelectedItem() == null || telefonoMovilInstructorAddField.getText().isEmpty()
                    || casaPrefijoInstCombo.getSelectionModel().getSelectedItem() == null || telefonoCasaInstructorAddField.getText().isEmpty()
                    || estatusInstructorAddCombo.getSelectionModel().getSelectedItem() == null){camposVacios();}else{
                String revisarDatos = "SELECT id_instructor from instructores WHERE id_instructor = '"+cedulaInstructorAddField.getText()+"'";

                statement = conexion.createStatement();
                resultado = statement.executeQuery(revisarDatos);

                if (resultado.next()){
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Faltan campos");
                    alert.setHeaderText(null);
                    alert.setContentText("El numero de cedula: " + cedulaInstructorAddField.getText() + "Ya esta registrado");
                    alert.showAndWait();
                }else{
                    prepare = conexion.prepareStatement(sql);
                    prepare.setString(1, cedulaInstructorAddField.getText());
                    prepare.setString(2, nombreInstructorAddField.getText());
                    prepare.setString(3, apellidosInstructorAddField.getText());
                    prepare.setString(4, direccionInstructorAddField.getText());
                    prepare.setString(5, sexoInstructorAddCombo.getText());
                    prepare.setString(6, (String)movilPrefijoInstCombo.getSelectionModel().getSelectedItem()+telefonoMovilInstructorAddField.getText());
                    prepare.setString(7, (String)casaPrefijoInstCombo.getSelectionModel().getSelectedItem()+telefonoCasaInstructorAddField.getText());
                    prepare.setString(8, (String)estatusInstructorAddCombo.getSelectionModel().getSelectedItem());

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Registro exitoso");
                    alert.setHeaderText(null);
                    alert.setContentText("Instructor registrado exitosamente");
                    alert.showAndWait();

                    //Para ingresar los datos y mostrarlos denuevo en la tabla
                    prepare.executeUpdate();
                    instructoresMostrarDatos();
                    //Limpiar datos cuando se ingrese el nuevo instructor
                    instructoresLimpiarDatos();

                }

            }

        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void instructoresActualizarBoton(){
        String sql = "UPDATE public.instructores "
                + "SET id_instructor = '" + cedulaInstructorAddField.getText() + "', "
                + "nombres = '" + nombreInstructorAddField.getText() + "', "
                + "apellidos = '" + apellidosInstructorAddField.getText() + "', "
                + "direccion = '" + direccionInstructorAddField.getText() + "', "
                + "sexo = '" + sexoInstructorAddCombo.getText() + "', "
                + "telefono_movil = '" + (String) movilPrefijoInstCombo.getSelectionModel().getSelectedItem()
                + telefonoMovilInstructorAddField.getText() + "', "
                + "telefono_casa = '" + (String) casaPrefijoInstCombo.getSelectionModel().getSelectedItem()
                + telefonoCasaInstructorAddField.getText() + "', "
                + "estatus = '" + (String) estatusInstructorAddCombo.getSelectionModel().getSelectedItem() + "' WHERE id_instructor = '"
                + cedulaInstructorAddField.getText()+"' ";

        Alert alert;
        conexion = conexionBdd.conexion();

        try{
            if (cedulaInstructorAddField.getText().isEmpty() || nombreInstructorAddField.getText().isEmpty() || apellidosInstructorAddField.getText().isEmpty()
                    || direccionInstructorAddField.getText().isEmpty() || sexoInstructorAddCombo.getSelectionModel().getSelectedItem() == null
                    || movilPrefijoInstCombo.getSelectionModel().getSelectedItem() == null || telefonoMovilInstructorAddField.getText().isEmpty()
                    || casaPrefijoInstCombo.getSelectionModel().getSelectedItem() == null || telefonoCasaInstructorAddField.getText().isEmpty()
                    || estatusInstructorAddCombo.getSelectionModel().getSelectedItem() == null){camposVacios();}else{

                prepare = conexion.prepareStatement(sql);
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Registro actualizado");
                alert.setHeaderText(null);
                alert.setContentText("Registro del instructor cedula: " + cedulaInstructorAddField.getText() + " actualizado!");
                alert.showAndWait();
                prepare.executeUpdate();

                instructoresMostrarDatos();

            }

        }catch (Exception e){
            System.out.println(e);
        }
    }

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

        cedula_inst_col.setCellValueFactory(new PropertyValueFactory<>("id_instructor"));
        nombre_inst_col.setCellValueFactory(new PropertyValueFactory<>("nombres"));
        apellidos_inst_col.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
        direccion_inst_col.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        sexo_inst_col.setCellValueFactory(new PropertyValueFactory<>("sexo"));
        movil_inst_col.setCellValueFactory(new PropertyValueFactory<>("telefono_movil"));
        casa_inst_col.setCellValueFactory(new PropertyValueFactory<>("telefono_casa"));
        estatus_inst_col.setCellValueFactory(new PropertyValueFactory<>("estatus"));

        instructoresTablaVista.setItems(instructoresListaDatos);

    }
    public void instructoresLimpiarDatos(){
        cedulaInstructorAddField.setText("");
        nombreInstructorAddField.setText("");
        apellidosInstructorAddField.setText("");
        direccionInstructorAddField.setText("");
        sexoInstructorAddCombo.getSelectionModel().clearSelection();
        telefonoMovilInstructorAddField.setText("");
        movilPrefijoInstCombo.getSelectionModel().clearSelection();
        telefonoCasaInstructorAddField.setText("");
        casaPrefijoInstCombo.getSelectionModel().clearSelection();
        estatusInstructorAddCombo.getSelectionModel().clearSelection();
    }

    public void instructoresSeleccion(){
        instructoresDatos id = instructoresTablaVista.getSelectionModel().getSelectedItem();
        int num = instructoresTablaVista.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1 ) return;

        cedulaInstructorAddField.setText(id.getId_instructor());
        nombreInstructorAddField.setText(id.getNombres());
        apellidosInstructorAddField.setText(id.getApellidos());
        direccionInstructorAddField.setText(id.getDireccion());
        sexoInstructorAddCombo.setText(id.getSexo());
        telefonoMovilInstructorAddField.setText(id.getTelefono_movil());
        //movilPrefijoInstCombo.getText();
        telefonoCasaInstructorAddField.setText(id.getTelefono_casa());
        //casaPrefijoInstCombo.getText();
        estatusInstructorAddCombo.setText(id.getEstatus());

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
        estatusInstructorAddCombo.setItems(stList);
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
            prefijosMovilLista();
            prefijosFijoLista();
            estatusCliente();
            instructoresMostrarDatos();

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
