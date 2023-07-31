import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.sql.Date;

public class reciboController {
    private String numeroCedula = recibo.cedula_cliente;
    private Date fechaInicioPago = recibo.fecha_inicio_pago;
    private Date fechaVencimiento = recibo.fecha_vencimiento;
    private String metodoPago = recibo.metodo_pago;
    private double tasaBCV = recibo.tasa_bcv;
    private double monto = recibo.monto;
    private double total = recibo.total;

    @FXML
    private Label cedulaValue;

    @FXML
    private Label fechaValue;

    @FXML
    private Label fechaVencValue;

    @FXML
    private Label metodoPagoValue;

    @FXML
    private Label montoValue;

    @FXML
    private GridPane reciboGrid;

    @FXML
    private Label tasaBCValue;

    @FXML
    private Label totalValue;

    public void initialize(){
        cedulaValue.setText(numeroCedula);
        fechaValue.setText(String.valueOf(fechaInicioPago));
        fechaVencValue.setText(String.valueOf(fechaVencimiento));
        metodoPagoValue.setText(metodoPago);
        montoValue.setText(String.valueOf(monto)+"$");
        tasaBCValue.setText(String.valueOf(tasaBCV)+" Bs.");
        totalValue.setText(String.valueOf(total)+ " Bs.");
    }

}
