public class instructoresDatos {
    private String id_instructor;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String sexo;
    private String telefono_movil;
    private String telefono_casa;
    private String estatus;
    public instructoresDatos(String idInstructor, String nombres, String apellidos, String direccion, String sexo, String telefono_movil, String telefono_casa, String estatus) {
        this.id_instructor = idInstructor;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.sexo = sexo;
        this.telefono_movil = telefono_movil;
        this.telefono_casa = telefono_casa;
        this.estatus = estatus;
    }
    public String getId_instructor(){return id_instructor;}
    public String getsoloId_instructor(){
        if (id_instructor != null && !id_instructor.isEmpty()) {
            // Regex bien bonito mi pana
            return id_instructor.replaceAll("[^0-9]", "");
        }
        return "";
    }
    public String getNombres(){
        return nombres;
    }
    public String getApellidos(){
        return apellidos;
    }
    public String getDireccion(){
        return direccion;
    }
    public String getSexo(){
        return sexo;
    }
    public String getTelefono_movil(){
        return telefono_movil;
    }
    public String getTelefono_casa(){return telefono_casa;}
    public String getEstatus(){
        return estatus;
    }
    public String getPrefijoMovil() {
        if (telefono_movil != null && telefono_movil.length() >= 4) {
            return telefono_movil.substring(0, 4);
        }
        return "";
    }

    public String getPrefijoCasa() {
        if (telefono_casa != null && telefono_casa.length() >= 4) {
            return telefono_casa.substring(0, 4);
        }
        return "";
    }
    public String getTelefonoMovilRestante() {
        if (telefono_movil != null && telefono_movil.length() >= 11) {
            return telefono_movil.substring(4);
        }
        return "";
    }
    public String getTelefonoCasaRestante() {
        if (telefono_casa != null && telefono_casa.length() >= 11) {
            return telefono_casa.substring(4);
        }
        return "";
    }
    public String getTipoCedula() {
        if (id_instructor != null && !id_instructor.isEmpty()) {
            char primerCaracter = id_instructor.charAt(0);
            if (primerCaracter == 'V' || primerCaracter == 'E') {
                return String.valueOf(primerCaracter);
            }
        }
        return "";
    }
}


