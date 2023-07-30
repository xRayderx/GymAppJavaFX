import java.util.Date;

public class miembrosDatos {

    private String cedulaCliente;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String direccion;
    private Date fechaPago;
    private Date fechaVencimiento;
    private String sexo;
    private String estatus;

    public miembrosDatos(String cedulaCliente, String nombres, String apellidos, String telefono, String direccion,
                         Date fechaPago, Date fechaVencimiento, String sexo, String estatus){

        this.cedulaCliente = cedulaCliente;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fechaPago = fechaPago;
        this.fechaVencimiento = fechaVencimiento;
        this.sexo = sexo;
        this.estatus = estatus;
    }

    public String getCedulaCliente(){
        return cedulaCliente;
    }

    public String getNombres(){
        return nombres;
    }

    public String getApellidos(){
        return apellidos;
    }

    public String getTelefono(){
        return telefono;
    }

    public String getDireccion(){
        return direccion;
    }

    public Date getFechaPago(){
        return fechaPago;
    }

    public Date getFechaVencimiento(){
        return fechaVencimiento;
    }

    public String getSexo(){
        return sexo;
    }

    public String getEstatus(){
        return estatus;
    }
}
