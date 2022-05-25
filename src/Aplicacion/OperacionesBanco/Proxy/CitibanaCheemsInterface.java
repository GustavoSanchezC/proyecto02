package Aplicacion.OperacionesBanco.Proxy;

public interface CitibanaCheemsInterface {

    public boolean iniciarSesion();

    public boolean registrarse();


    public void verSaldo();


    public void verNotificaciones();


    public void retirarDinero();


    public void transferirDinero();


    public void estadoCuenta();

    //posibles cripto monedas
    public void comprarBoletos();


}
