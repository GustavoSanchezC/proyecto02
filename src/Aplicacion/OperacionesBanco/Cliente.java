package Aplicacion.OperacionesBanco;

public class Cliente {

    private String nombreUsuario;
    private String contrasenna;
    private String nombreCompleto;
    private long telefono;
    private String direccion;
    private String noCuentaBancaria;
    private int nip;
    private String pais;
    private double dineroTotal;
    private String id;
    
    public Cliente(String nombreUsuario, String contrasenna, String nombreCompleto, long telefono, String direccion, 
        String noCuentaBancaria, int nip, String pais, double dineroTotal, String id){
        this.nombreUsuario = nombreUsuario;
        this.contrasenna = contrasenna;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.direccion = direccion;
        this.noCuentaBancaria = noCuentaBancaria;
        this.nip = nip;
        this.pais = pais;
        this.dineroTotal = dineroTotal;
        this.id = id;
    }

    public String getNombreUsuario(){
        return nombreUsuario;
    }    

    public String getContrasenna(){
        return contrasenna;
    }

    public String getNombreCompleto(){
        return nombreCompleto;
    }

    public long getTelefono(){
        return telefono;
    }

    public String getDireccion(){
        return direccion;
    }

    public String getNoCuentaBancaria(){
        return noCuentaBancaria;
    }

    public int getNip(){
        return nip;
    }

    public String getPais(){
        return pais;
    }

    public double getDineroTotal(){
        return dineroTotal;
    }

    public String getId(){
        return id;
    }

    public void setDineroTotal(double dineroTotal){
        this.dineroTotal = dineroTotal;
    }
}