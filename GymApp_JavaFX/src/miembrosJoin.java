import java.util.Date;
/*
public class miembrosJoin{
        private String cedula_cliente;
        private String nombres;
        private String apellidos;
        private String telefono_movil;
        private String estatus;
        private Date fecha_inicio_pago;
        private Date fecha_vencimiento;

        public miembrosJoin(String cedula_cliente, String nombres, String apellidos, String telefono_movil, String estatus, Date fecha_inicio_pago, Date fecha_vencimiento){

            this.cedula_cliente = cedula_cliente;
            this.nombres = nombres;
            this.apellidos = apellidos;
            this.fecha_inicio_pago = fecha_inicio_pago;
            this.fecha_vencimiento = fecha_vencimiento;
            this.telefono_movil = telefono_movil;
            this.estatus = estatus;
        }
        public String getCedula_cliente(){return cedula_cliente;}

        public String getsoloCedula_cliente(){
            if (cedula_cliente != null && !cedula_cliente.isEmpty()) {
                // Regex bien bonito mi pana
                return cedula_cliente.replaceAll("[^0-9]", "");
            }
            return "";
        }

        public String getNombres(){
            return nombres;
        }

        public String getApellidos(){
            return apellidos;
        }

        public String getTelefono_movil(){
            return telefono_movil;
        }


        public String getEstatus(){
            return estatus;
        }

        public String getTipoCedula() {
            if (cedula_cliente != null && !cedula_cliente.isEmpty()) {
                char primerCaracter = cedula_cliente.charAt(0);
                if (primerCaracter == 'V' || primerCaracter == 'E') {
                    return String.valueOf(primerCaracter);
                }
            }
            return "";
        }
        public Date getFecha_inicio_pago(){return fecha_inicio_pago;}
        public Date getFecha_vencimiento(){return fecha_vencimiento;}

}
*/
public class miembrosJoin {
    private String cedulaCliente;
    private String nombres;
    private String apellidos;
    private String telefonoMovil;
    private String estatus;
    private Date fechaInicioPago;
    private Date fechaVencimiento;

    public miembrosJoin(String cedulaCliente, String nombres, String apellidos, String telefonoMovil, String estatus, Date fechaInicioPago, Date fechaVencimiento) {
        this.cedulaCliente = cedulaCliente;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefonoMovil = telefonoMovil;
        this.estatus = estatus;
        this.fechaInicioPago = fechaInicioPago;
        this.fechaVencimiento = fechaVencimiento;
    }

    // Métodos getters
    public String getCedulaCliente() {
        return cedulaCliente;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getTelefonoMovil() {
        return telefonoMovil;
    }

    public String getEstatus() {
        return estatus;
    }

    public Date getFechaInicioPago() {
        return fechaInicioPago;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }
}
