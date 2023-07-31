import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXComboBox;
import io.github.palexdev.materialfx.controls.MFXDatePicker;
import io.github.palexdev.materialfx.controls.MFXRadioButton;
import io.github.palexdev.materialfx.controls.MFXTableColumn;
import io.github.palexdev.materialfx.controls.MFXTextField;
import io.github.palexdev.materialfx.controls.legacy.MFXLegacyTableView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
    private TableColumn<pagosDatos, Double> bcvTasaColPago;

    @FXML
    private TableColumn<instructoresDatos, String> casa_inst_col;

    @FXML
    private TableColumn<?, ?> cedulaClienteColPago;

    @FXML
    private MFXTextField cedulaCodigoClienteAddField;

    @FXML
    private TableColumn<pagosDatos, String> cedulaColPago;

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
    private TableColumn<pagosDatos, java.util.Date> fechaInicioColPago;

    @FXML
    private MFXTableColumn<?> fechaPagoClienteCol;

    @FXML
    private MFXDatePicker fechaVencClienteAddDate;

    @FXML
    private TableColumn<pagosDatos, java.util.Date> fechaVencColPago;

    @FXML
    private MFXTableColumn<?> fechaVencimientoClienteCol;

    @FXML
    private TableColumn<pagosDatos, Integer> idPago;

    @FXML
    private AreaChart<String, Number> ingresoMensualChart;

    @FXML
    private MFXButton limpiarCamposClienteBtn;

    @FXML
    private MFXLegacyTableView<pagosDatos> tablaPagosVista;

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
    private TableColumn<pagosDatos, String> metodoClienteColPago;

    @FXML
    private TableColumn<pagosDatos, Double> montoColPago;

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
    private MFXComboBox<Integer> pagoMesCombo;

    @FXML
    private MFXComboBox<?> pagoMetodoCombo;

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
    private TableColumn<pagosDatos, Double> totalColPago;

    @FXML
    private MFXComboBox<?> casaPrefijoInstCombo;
    @FXML
    private MFXComboBox<?> movilPrefijoInstCombo;

    @FXML
    private TableView<miembrosDatos> miembrosTablaVista;

    @FXML
    private TableColumn<miembrosDatos, String> cedula_client_col;

    @FXML
    private TableColumn<miembrosDatos, String> nombres_client_col;

    @FXML
    private TableColumn<miembrosDatos, String> apellidos_client_col;

    @FXML
    private TableColumn<miembrosDatos, String> telefono_client_col;

    @FXML
    private TableColumn<miembrosDatos, String> direccion_client_col;

    @FXML
    private TableColumn<miembrosDatos, String> sexo_client_col;

    @FXML
    private TableColumn<miembrosDatos, Date> fechapago_client_col;

    @FXML
    private TableColumn<miembrosDatos, Date> fechavencimiento_client_col;

    @FXML
    private TableColumn<miembrosDatos, String> estatus_client_col;

    @FXML
    private Label usuarioLabel;

    private PreparedStatement prepare;
    private Connection conexion;
    private ResultSet resultado;
    private Statement statement;

    public void numeroClientes(){
        String sql = "SELECT COUNT(cedula_cliente) AS total_clientes FROM public.clientes WHERE estatus='Activo'";

        conexion = conexionBdd.conexion();

        int nc = 0 ;

        try{
            prepare = conexion.prepareStatement(sql);
            resultado = prepare.executeQuery();

            if(resultado.next()){
                nc = resultado.getInt("total_clientes");

            }
            totalMiembrosLabel.setText(String.valueOf(nc));
            cerrarConexion();
        }catch (Exception e){
            System.out.println(e);
        }

    }

    public void totalInstructores(){
        String sql = "SELECT COUNT(id_instructor) AS total_instructor from public.instructores WHERE estatus='Activo'";

        conexion = conexionBdd.conexion();

        int ti = 0;
        try{
            prepare = conexion.prepareStatement(sql);
            resultado = prepare.executeQuery();

            if(resultado.next()){
                ti = resultado.getInt("total_instructor");
            }
            totalInstructoresLabel.setText(String.valueOf(ti));
            cerrarConexion();
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void totalIngresoMensual(){
        String sql = "SELECT SUM(monto) AS total_monto FROM public.pagos WHERE EXTRACT(MONTH FROM fecha_inicio_pago) = EXTRACT(MONTH FROM CURRENT_DATE)";

        conexion = conexionBdd.conexion();

        double tm = 0;
        try {
            prepare = conexion.prepareStatement(sql);
            resultado = prepare.executeQuery();

            if (resultado.next()) {
                tm = resultado.getDouble("total_monto");
            }
            DecimalFormat df = new DecimalFormat("#.00");
            String tmFormatted = df.format(tm);
            totalIngresosLabel.setText(tmFormatted + "$");
            cerrarConexion();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void mostrarEstadisticas(){
        ingresoMensualChart.getData().clear();

        String sql = "SELECT EXTRACT(YEAR FROM fecha_vencimiento) AS anio,\n" +
                "       EXTRACT(MONTH FROM fecha_vencimiento) AS mes,\n" +
                "       SUM(monto) AS monto_total\n" +
                "FROM public.pagos\n" +
                "WHERE fecha_vencimiento >= CURRENT_DATE\n" +
                "GROUP BY EXTRACT(YEAR FROM fecha_vencimiento), EXTRACT(MONTH FROM fecha_vencimiento)\n" +
                "ORDER BY EXTRACT(YEAR FROM fecha_vencimiento), EXTRACT(MONTH FROM fecha_vencimiento) ASC\n" +
                "LIMIT 10;";

        conexion = conexionBdd.conexion();

        XYChart.Series<String, Number> estadisticas = new XYChart.Series<>();

        try {
            prepare = conexion.prepareStatement(sql);
            resultado = prepare.executeQuery();

            while (resultado.next()) {
                String mes = resultado.getString(2); // Obtener el mes como una cadena
                double montoTotal = resultado.getDouble(3); // Obtener el monto total

                System.out.println("Mes: " + mes + ", Monto Total: " + montoTotal);

                estadisticas.getData().add(new XYChart.Data<>(mes, montoTotal)); // Agregar los datos a la serie
            }

            estadisticas.setName("X: Meses, Y: Cantidades");

            ingresoMensualChart.getData().add(estadisticas); // Agregar la serie al gráfico

        } catch (Exception e) {
            System.out.println(e);
        }
    }
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
                    cerrarConexion();

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

                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Mensaje de confirmacion");
                alert.setHeaderText(null);
                alert.setContentText("Estas seguro que deseas ACTUALIZAR los datos del instructor: " + cedulaInstructorAddField.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();
                if (option.get().equals(ButtonType.OK)){
                    prepare = conexion.prepareStatement(sql);

                    prepare.executeUpdate();

                    alert = new Alert (Alert.AlertType.INFORMATION);
                    alert.setTitle("Mensaje de informacion");
                    alert.setHeaderText(null);
                    alert.setContentText("Registro actualizado exitosamente!");
                    alert.showAndWait();
                    //actualizar datos
                    instructoresMostrarDatos();
                    //limpiar datos
                    instructoresLimpiarDatos();
                }else{
                    alert= new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Mensaje de informacion");
                    alert.setHeaderText(null);
                    alert.setContentText("Registro cancelado!");
                    alert.showAndWait();
                }

            }

        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void instructoresEliminarBoton(){
        String sql = "DELETE FROM instructores WHERE id_instructor = '"+cedulaInstructorAddField.getText()+"'";

        Alert alert;
        conexion = conexionBdd.conexion();

        try{
            if (cedulaInstructorAddField.getText().isEmpty() || nombreInstructorAddField.getText().isEmpty() || apellidosInstructorAddField.getText().isEmpty()
                    || direccionInstructorAddField.getText().isEmpty() || sexoInstructorAddCombo.getSelectionModel().getSelectedItem() == null
                    || movilPrefijoInstCombo.getSelectionModel().getSelectedItem() == null || telefonoMovilInstructorAddField.getText().isEmpty()
                    || casaPrefijoInstCombo.getSelectionModel().getSelectedItem() == null || telefonoCasaInstructorAddField.getText().isEmpty()
                    || estatusInstructorAddCombo.getSelectionModel().getSelectedItem() == null){camposVacios();}else{


                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Mensaje de confirmacion");
                alert.setHeaderText(null);
                alert.setContentText("Estas seguro que deseas ELIMINAR los datos del instructor: " + cedulaInstructorAddField.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();
                if (option.get().equals(ButtonType.OK)){
                    prepare = conexion.prepareStatement(sql);

                    prepare.executeUpdate();

                    alert = new Alert (Alert.AlertType.INFORMATION);
                    alert.setTitle("Mensaje de informacion");
                    alert.setHeaderText(null);
                    alert.setContentText("Registro eliminado exitosamente!");
                    alert.showAndWait();
                    //actualizar datos
                    instructoresMostrarDatos();
                    //limpiar datos
                    instructoresLimpiarDatos();
                }else{
                    alert= new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Mensaje de informacion");
                    alert.setHeaderText(null);
                    alert.setContentText("Registro cancelado!");
                    alert.showAndWait();
                }

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
        cerrarConexion();
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

    public ObservableList<pagosDatos> obtenerPagosDatos (){
        ObservableList<pagosDatos> pagosDatos = FXCollections.observableArrayList();

        String sql = "SELECT * FROM pagos";
        conexion = conexionBdd.conexion();

        try {
            prepare = conexion.prepareStatement(sql);
            resultado = prepare.executeQuery();

            pagosDatos pago;

            while (resultado.next()) {
                int id_pago = resultado.getInt("id_pago");
                String cedula_cliente = resultado.getString("cedula_cliente");
                Date fecha_inicio_pago = resultado.getDate("fecha_inicio_pago");
                Date fecha_vencimiento = resultado.getDate("fecha_vencimiento");
                String metodo_pago = resultado.getString("metodo_pago");
                double tasa_bcv = resultado.getDouble("tasa_bcv");
                double monto = resultado.getDouble("monto");
                double total = resultado.getDouble("total");

                pago = new pagosDatos(id_pago, cedula_cliente, fecha_inicio_pago, fecha_vencimiento, metodo_pago, tasa_bcv, monto, total);
                pagosDatos.add(pago);
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            cerrarConexion();
        }

        return pagosDatos;
    }
    private ObservableList<pagosDatos> datosPagos;
    public void mostrarPagosDatos() {
        datosPagos = obtenerPagosDatos();

        // Asignar los datos a las columnas de la tabla
        idPago.setCellValueFactory(new PropertyValueFactory<>("id_pago"));
        cedulaColPago.setCellValueFactory(new PropertyValueFactory<>("cedula_cliente"));
        fechaInicioColPago.setCellValueFactory(new PropertyValueFactory<>("fecha_inicio_pago"));
        fechaVencColPago.setCellValueFactory(new PropertyValueFactory<>("fecha_vencimiento"));
        metodoClienteColPago.setCellValueFactory(new PropertyValueFactory<>("metodo_pago"));
        bcvTasaColPago.setCellValueFactory(new PropertyValueFactory<>("tasa_bcv"));
        montoColPago.setCellValueFactory(new PropertyValueFactory<>("monto"));
        totalColPago.setCellValueFactory(new PropertyValueFactory<>("total"));

        // Mostrar los datos en la tabla
        tablaPagosVista.setItems(datosPagos);
    }

    public void obtenertasaBCV() {
        String url = "https://api.exchangedyn.com/markets/quotes/usdves/bcv";
        String tasaBCV = null;
        String salida = null;

        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            JSONObject json = new JSONObject(response.toString());
            JSONObject sources = json.getJSONObject("sources");
            JSONObject bcv = sources.getJSONObject("BCV");
            tasaBCV = bcv.getString("quote");
            double doblebcv = Double.parseDouble(tasaBCV);
            salida = doblebcv + "Bs";
        } catch (IOException e) {
            e.printStackTrace();
        }
        bcvCheckLbl.setText(salida);
    }

    private String prefC[] = {"V", "E", "J"};
    public void prefCedula(){
        List<String> cedulaLista = new ArrayList<>();

        for (String data: prefC){
            cedulaLista.add(data);
        }

        ObservableList cedList = FXCollections.observableArrayList(cedulaLista);
        pagoCedulaLetra.setItems(cedList);
    }
    private String metodo[] = {"Pago movil", "Efectivo", "Punto de venta", "Otro"};
    public void metodoPago(){
        List<String> metodoLista = new ArrayList<>();

        for (String data: metodo){
            metodoLista.add(data);
        }

        ObservableList cedList = FXCollections.observableArrayList(metodoLista);
        pagoMetodoCombo.setItems(cedList);
    }
    public void mesesLista() {
        List<Integer> mesesLista = new ArrayList<>();

        for (int i = 1; i <= 12; i++) {
            mesesLista.add(i);
        }

        ObservableList<Integer> mesesObservableList = FXCollections.observableArrayList(mesesLista);
        pagoMesCombo.setItems(mesesObservableList);
    }
    public Date ObtenerFecha() {
        Date fecha_vencimiento = null;
        if (pagoDiaBtn.isSelected()) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            fecha_vencimiento = new Date(calendar.getTime().getTime());
        } else if (pagoSemanaBtn.isSelected()) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DAY_OF_MONTH, 7);
            fecha_vencimiento = new Date(calendar.getTime().getTime());
        } else if (pagoMesBtn.isSelected()) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DAY_OF_MONTH, 30);
            fecha_vencimiento = new Date(calendar.getTime().getTime());
        } else if (pagoMesCombo.getSelectionModel().getSelectedItem() != null) {
            int meses = Integer.parseInt(pagoMesCombo.getValue().toString());
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.MONTH, meses);
            fecha_vencimiento = new Date(calendar.getTime().getTime());
        }
        return fecha_vencimiento;
    }

    public double doubleDesdeString(String texto) {
        String soloNumeros = texto.replaceAll("[^\\d.]", "");
        String primerosSeisDigitos = soloNumeros.substring(0, Math.min(soloNumeros.length(), 6));
        double resultado = Double.parseDouble(primerosSeisDigitos);

        return resultado;
    }

    public void calcularTotal(){
        double tasa_bcv = doubleDesdeString(bcvCheckLbl.getText());
        double monto = doubleDesdeString(montoPagoBtn.getText());
        String resultado = "" + tasa_bcv * monto + " Bs";
        totalPagoLbl.setText(resultado);
    }

    public void nuevoPagoBtn() {
        String sql = "INSERT INTO public.pagos (cedula_cliente, fecha_inicio_pago, fecha_vencimiento, metodo_pago, tasa_bcv, monto, total) VALUES (?, ?, ?, ?, ?, ?, ?)";

        conexion= conexionBdd.conexion();
        Date fecha_venc = ObtenerFecha();

        double tasa_bcv = doubleDesdeString(bcvCheckLbl.getText());
        double monto = doubleDesdeString(montoPagoBtn.getText());
        double total = doubleDesdeString(totalPagoLbl.getText());

        try {
            Alert alert;
            if (pagoCedulaCampo.getText().isEmpty() || pagoCedulaLetra.getSelectionModel().getSelectedItem() == null || ObtenerFecha() == null
                || pagoMetodoCombo.getSelectionModel().getSelectedItem() == null || montoPagoBtn.getText().isEmpty())
            {camposVacios();}else{
                String cedula_cliente = (String) pagoCedulaLetra.getSelectionModel().getSelectedItem() + pagoCedulaCampo.getText();
                java.sql.Date fecha_inicio_pago = new java.sql.Date(System.currentTimeMillis());
                java.sql.Date fecha_vencimiento = new java.sql.Date(fecha_venc.getTime());
                String metodo_pago = (String) pagoMetodoCombo.getSelectionModel().getSelectedItem();

                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Mensaje de confirmacion");
                alert.setHeaderText(null);
                alert.setContentText("Estas a punto de añadir un pago al cliente: " + (String) pagoCedulaLetra.getSelectionModel().getSelectedItem() + pagoCedulaCampo.getText() + "");
                Optional<ButtonType> option = alert.showAndWait();
                if (option.get().equals(ButtonType.OK)){
                    PreparedStatement prepare = conexion.prepareStatement(sql);
                    prepare.setString(1, cedula_cliente);
                    prepare.setDate(2, fecha_inicio_pago);
                    prepare.setDate(3, fecha_vencimiento);
                    prepare.setString(4, metodo_pago);
                    prepare.setDouble(5, tasa_bcv);
                    prepare.setDouble(6, monto);
                    prepare.setDouble(7, total);
                    prepare.executeUpdate();
                    prepare.close();
                    cerrarConexion();
                    alert = new Alert (Alert.AlertType.INFORMATION);
                    alert.setTitle("Mensaje de informacion");
                    alert.setHeaderText(null);
                    alert.setContentText("Pago registrado exitosamente!");
                    alert.showAndWait();
                    mostrarPagosDatos();
                    pagosLimpiarCampos();
                }else {
                    alert= new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Mensaje de informacion");
                    alert.setHeaderText(null);
                    alert.setContentText("Registro de pago cancelado!");
                    alert.showAndWait();
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void pagosLimpiarCampos(){
        pagoCedulaLetra.getSelectionModel().selectFirst();
        pagoCedulaCampo.setText("");
        pagoDiaBtn.setSelected(false);
        pagoMesBtn.setSelected(false);
        pagoSemanaBtn.setSelected(false);
        pagoMesCombo.getSelectionModel().clearSelection();
        pagoMetodoCombo.getSelectionModel().clearSelection();
        montoPagoBtn.setText("");
    }

    public void pagosEliminarPago(){

    }

    public void cambiarForm(ActionEvent event) {

        if (event.getSource() == mainDashboardBtn) {

            mainStatForm.setVisible(true);
            mainInstructorForm.setVisible(false);
            clienteForm.setVisible(false);
            pagoForm.setVisible(false);

            numeroClientes();
            totalInstructores();
            totalIngresoMensual();
            mostrarEstadisticas();

        } else if (event.getSource() == mainInstructorBtn) {

            mainStatForm.setVisible(false);
            mainInstructorForm.setVisible(true);
            clienteForm.setVisible(false);
            pagoForm.setVisible(false);

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

            instructorSexoLista();
            //membersSchedule();
            estatusCliente();

        } else if (event.getSource() == mainPagosBtn) {

            mainStatForm.setVisible(false);
            mainInstructorForm.setVisible(false);
            clienteForm.setVisible(false);
            pagoForm.setVisible(true);

            prefCedula();
            mostrarPagosDatos();
            mesesLista();
            metodoPago();

        }

    }

    //Formulario Clientes
    public ObservableList<miembrosDatos> miembrosDatosLista(){
        ObservableList<miembrosDatos> miemDatos = FXCollections.observableArrayList();

        String sql = "SELECT * FROM clientes";
        conexion = conexionBdd.conexion();

        try{
            prepare = conexion.prepareStatement(sql);
            resultado = prepare.executeQuery();

            miembrosDatos cedulaCliente;

            while(resultado.next()){
                cedulaCliente = new miembrosDatos(resultado.getString("cedulaCliente"), resultado.getString("nombres"),
                        resultado.getString("apellidos"), resultado.getString("telefono"),
                        resultado.getString("direccion"), resultado.getDate("fechaPago"),
                        resultado.getDate("fechaVencimiento"), resultado.getString("sexo"), resultado.getString("estatus"));
                miemDatos.add(cedulaCliente);
            }

        }catch(Exception e){
            System.out.println(e);
        }
        return miemDatos;
    }

    private ObservableList<miembrosDatos> miembrosListaDatos;

    public void miembrosMostrarDatos(){
        miembrosListaDatos = miembrosDatosLista();

        cedula_client_col.setCellValueFactory(new PropertyValueFactory<>("cedulaCliente"));
        nombres_client_col.setCellValueFactory(new PropertyValueFactory<>("nombres"));
        apellidos_client_col.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
        telefono_client_col.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        direccion_client_col.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        fechapago_client_col.setCellValueFactory(new PropertyValueFactory<>("fechaPago"));
        fechavencimiento_client_col.setCellValueFactory(new PropertyValueFactory<>("fechaVencimiento"));
        sexo_client_col.setCellValueFactory(new PropertyValueFactory<>("sexo"));
        estatus_client_col.setCellValueFactory(new PropertyValueFactory<>("estatus"));

        miembrosTablaVista.setItems(miembrosListaDatos);

    }

    //limpiar los campos
    public void clientesLimpiarDatos(){
        //cedulaLetraClienteCombo.getSelectionModel().clearSelection();
        cedulaCodigoClienteAddField.setText("");
        nombreClienteAddField.setText("");
        apellidoClienteAddField.setText("");
        telefonoClienteAddField.setText("");
        direccionClienteAddField.setText("");
        fechaInicioClienteAddDate.setValue(null);
        fechaVencClienteAddDate.setValue(null);
        sexoClienteAddCombo.getSelectionModel().clearSelection();
        estatusClienteAddCombo.getSelectionModel().clearSelection();
    }

    //agregar nuevo cliente
    public void clientesNuevoBoton() {
        String sql = "INSERT INTO public.clientes(\n" +
                "\tcedula_cliente, nombres, apellidos, telefono_movil, direccion, sexo, estatus)\n" +
                "\tVALUES (?, ?, ?, ?, ?, ?, ?);";

        conexion = conexionBdd.conexion();

        try {
            Alert alert;

            if (cedulaCodigoClienteAddField.getText().isEmpty() || nombreClienteAddField.getText().isEmpty() || apellidoClienteAddField.getText().isEmpty()
                    || telefonoClienteAddField.getText().isEmpty() || direccionClienteAddField.getText().isEmpty()
                    || sexoClienteAddCombo.getSelectionModel().getSelectedItem() == null
                    || estatusClienteAddCombo.getSelectionModel().getSelectedItem() == null) {

                camposVacios();
            } else {
                String revisarDatos = "SELECT cedula_cliente from clientes WHERE cedula_cliente = '" + cedulaCodigoClienteAddField.getText() + "'";

                statement = conexion.createStatement();
                resultado = statement.executeQuery(revisarDatos);

                if (resultado.next()) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Faltan campos");
                    alert.setHeaderText(null);
                    alert.setContentText("El número de cedula: " + cedulaCodigoClienteAddField.getText() + "Ya esta registrado");
                    alert.showAndWait();
                } else {
                    prepare = conexion.prepareStatement(sql);
                    prepare.setString(1, cedulaCodigoClienteAddField.getText());
                    prepare.setString(2, nombreClienteAddField.getText());
                    prepare.setString(3, apellidoClienteAddField.getText());
                    prepare.setString(4, telefonoClienteAddField.getText());
                    prepare.setString(5, direccionClienteAddField.getText());
                    //prepare.setString(6, fechaInicioClienteAddDate.getText());
                    //prepare.setString(7, fechaVencClienteAddDate.getText());
                    prepare.setString(6, sexoClienteAddCombo.getText());
                    prepare.setString(7, (String) estatusClienteAddCombo.getSelectionModel().getSelectedItem());

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Registro exitoso");
                    alert.setHeaderText(null);
                    alert.setContentText("Cliente registrado exitosamente");
                    alert.showAndWait();

                    //Para ingresar los datos y mostrarlos denuevo en la tabla
                    prepare.executeUpdate();
                    miembrosMostrarDatos();
                    //Limpiar datos cuando se ingrese el nuevo cliente
                    clientesLimpiarDatos();
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void mostrarNombreUsuario(){
        String usuario = data.usuario;
        usuario = usuario.substring(0, 1).toUpperCase() + usuario.substring(1);

        usuarioLabel.setText(usuario);
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
    private void cerrarConexion() {
        try {
            if (resultado != null) {
                resultado.close();
            }
            if (prepare != null) {
                prepare.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
