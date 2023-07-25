public class instructoresDatos {

    private String idInstructor;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String sexo;
    private String tlfMovilCliente;
    private String tlfCasaCliente;
    private String estatus;
    public instructoresDatos(String idInstructor, String nombres, String apellidos, String direccion, String sexo, String tlfMovilCliente, String tlfCasaCliente, String estatus) {
        this.idInstructor = idInstructor;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.sexo = sexo;
        this.tlfMovilCliente = tlfMovilCliente;
        this.tlfCasaCliente = tlfCasaCliente;
        this.estatus = estatus;
    }
    public String getIdInstructor(){
        return idInstructor;
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
    public String getTlfMovilCliente(){
        return tlfMovilCliente;
    }
    public String getTlfCasaCliente(){
        return tlfCasaCliente;
    }
    public String getEstatus(){
        return estatus;
    }

}
