public class miembrosDatos {

    private String cedula_cliente;
    private String nombres;
    private String apellidos;
    private String telefono_movil;
    private String direccion;
    private String sexo;
    private String estatus;

    public miembrosDatos(String cedulaCliente, String nombres, String apellidos, String telefono, String direccion,
                         String sexo, String estatus){

        this.cedula_cliente = cedulaCliente;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono_movil = telefono;
        this.direccion = direccion;
        this.sexo = sexo;
        this.estatus = estatus;
    }

    public String getCedula_cliente(){
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

    public String getDireccion(){
        return direccion;
    }
    public String getSexo(){
        return sexo;
    }

    public String getEstatus(){
        return estatus;
    }
    public String getPrefijoTelefono() {
        if (telefono_movil != null && telefono_movil.length() >= 4) {
            return telefono_movil.substring(0, 4);
        }
        return "";
    }
    public String getTelefonoMovilRestante() {
        if (telefono_movil != null && telefono_movil.length() >= 11) {
            return telefono_movil.substring(4);
        }
        return "";
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
}
