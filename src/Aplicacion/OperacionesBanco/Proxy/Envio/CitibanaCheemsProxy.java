package Aplicacion.OperacionesBanco.Proxy.Envio;

import Aplicacion.OperacionesBanco.Proxy.CitibanaCheemsInterface;

public class CitibanaCheemsProxy implements CitibanaCheemsInterface{

    private CitibanaCheems citibanaCheemsReal;

    public CitibanaCheemsProxy(CitibanaCheems citibanaCheemsReal){
        this.citibanaCheemsReal = citibanaCheemsReal;
    }
    
    @Override
    public boolean iniciarSesion(){
        return citibanaCheemsReal.iniciarSesion();
    }  
    
    @Override
    public boolean registrarse(){
        return citibanaCheemsReal.registrarse();
    }


    @Override
    public void verSaldo() {
        citibanaCheemsReal.verSaldo();

    }

    @Override
    public void verNotificaciones() {
        citibanaCheemsReal.verNotificaciones();

    }

    @Override
    public void retirarDinero() {
        citibanaCheemsReal.retirarDinero();

    }

    @Override
    public void transferirDinero() {
        citibanaCheemsReal.transferirDinero();

    }

    @Override
    public void estadoCuenta() {
        citibanaCheemsReal.estadoCuenta();

    }

    @Override
    public void comprarBoletos() {
        citibanaCheemsReal.comprarBoletos();

    }
}