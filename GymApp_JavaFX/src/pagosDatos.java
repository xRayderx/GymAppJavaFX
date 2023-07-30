import java.util.Date;

public class pagosDatos {
    private int id_pago;
    private String cedula_cliente;
    private Date fecha_inicio_pago;
    private Date fecha_vencimiento;
    private String metodo_pago;
    private double tasa_bcv;
    private double monto;
    private double total;

    public pagosDatos(int id_pago, String cedula_cliente, Date fecha_inicio_pago, Date fecha_vencimiento, String metodo_pago, double tasa_bcv, double monto, double total) {
        this.id_pago = id_pago;
        this.cedula_cliente = cedula_cliente;
        this.fecha_inicio_pago = fecha_inicio_pago;
        this.fecha_vencimiento = fecha_vencimiento;
        this.metodo_pago = metodo_pago;
        this.tasa_bcv = tasa_bcv;
        this.monto = monto;
        this.total = total;
    }

    public int getId_pago() {
        return id_pago;
    }

    public String getCedula_cliente() {
        return cedula_cliente;
    }

    public Date getFecha_inicio_pago() {
        return fecha_inicio_pago;
    }

    public Date getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public String getMetodo_pago() {
        return metodo_pago;
    }

    public double getTasa_bcv() {
        return tasa_bcv;
    }

    public double getMonto() {
        return monto;
    }

    public double getTotal(){ return total; }
}
