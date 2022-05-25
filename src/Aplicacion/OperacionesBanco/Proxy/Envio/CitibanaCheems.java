package Aplicacion.OperacionesBanco.Proxy.Envio;

import java.util.Scanner;
import Aplicacion.OperacionesBanco.Cliente;
import Aplicacion.OperacionesBanco.BaseDatos.MySQLSingletonModelo;
import Aplicacion.OperacionesBanco.Proxy.CitibanaCheemsInterface;
import Aplicacion.OperacionesBanco.Proxy.Envio.InicioSesion.IniciarSesionStrategy;
import Aplicacion.OperacionesBanco.Proxy.Envio.InicioSesion.InicioSesionIdiomas.AmericanEnglishSignIn;
import Aplicacion.OperacionesBanco.Proxy.Envio.InicioSesion.InicioSesionIdiomas.IniciarSesionEspannolLatino;
import Aplicacion.OperacionesBanco.Proxy.Envio.InicioSesion.InicioSesionIdiomas.LoginCanadienFrancais;
import Aplicacion.OperacionesBanco.Proxy.Envio.Registro.RegistroTemplate;

public class CitibanaCheems implements CitibanaCheemsInterface{
    
    private Cliente cliente;
    private MySQLSingletonModelo conexionBanco = MySQLSingletonModelo.getBaseDeDatos();
    private String idioma;
    private Scanner leeOpcion = new Scanner(System.in);
    private Verificacion ayudaAVerificar = new Verificacion(); 
    private IniciarSesionStrategy iniciarSesion;
    private RegistroTemplate registro;

    private boolean monadaTrasformada;

    /**
     * Metodo constructor de la clase.
     * @param idioma es el idioma con el cual se esta trabajando en la aplicacion.
     */
    public CitibanaCheems(String idioma){
        this.idioma = idioma;
        if(getIdioma().equals("ESPANNOL LATINO")){
            iniciarSesion = new IniciarSesionEspannolLatino();
            switch (cliente.getPais()){
                case "Mexico":
                    //strategy mexico
                    break;
                case "Guatemala":
                    //strategy guatemala
                    break;
                default:
                    System.out.println("Error 404");
                    break;
            }



        }else if(getIdioma().equals("AMERICAN ENGLISH")){
            iniciarSesion = new AmericanEnglishSignIn();
            switch (cliente.getPais()){
                case "UnitedStates":
                    //strategy eua
                    break;
                case "Canada":
                    //strategy canada
                    break;
                default:
                    System.out.println("Error 404");
                    break;
            }

        }else if(getIdioma(). equals("FRANCAIS CANADIEN")){
            iniciarSesion = new LoginCanadienFrancais();
            switch (cliente.getPais()){
                case "Canada":
                    //strategy canada
                    break;
                default:
                    System.out.println("Error 404");
                    break;
            }


        }
    }





    /**
     * Metodo para poder obtener el idioma con el cual esta trabajando la aplicacion.
     * @return un String, el cual es el idioma de la aplicacion.
     */
    public String getIdioma(){
        return idioma;
    }

    @Override
    public boolean iniciarSesion(){
        boolean inicioSesion = false;
        boolean terminaEjecucion = false;
        System.out.println(iniciarSesion.mensajeInicioSesion());
        while(!terminaEjecucion){
            System.out.println(iniciarSesion.ingreseSuNombreDeUsuario());
            String nombreUsuario = leeOpcion.nextLine();
            System.out.println(iniciarSesion.ingreseSuContrasenna());
            String contrasenna = leeOpcion.nextLine(); 
            if(ayudaAVerificar.tieneEspaciosEnBlanco(nombreUsuario) || ayudaAVerificar.tieneEspaciosEnBlanco(contrasenna)
                || ayudaAVerificar.estaCompuestoSoloEspBlanc(nombreUsuario) || ayudaAVerificar.estaCompuestoSoloEspBlanc(contrasenna)){
                System.out.println(iniciarSesion.escribeBienTuNombre());
                terminaEjecucion = iniciarSesionMensajes();
            }else{
                cliente = conexionBanco.getCliente(nombreUsuario, contrasenna);
                if(cliente != null){
                    terminaEjecucion = true;
                    inicioSesion = true;
                    System.out.println(iniciarSesion.felicidadesIniciasteSesion());
                }else{
                    System.out.println(iniciarSesion.errorIngresasteDatosErroneos());
                    terminaEjecucion = iniciarSesionMensajes();
                }
            }
        }
        return inicioSesion;
    }

    /**
     * Metodo que nos dice si quiere volver a iniciarSesion o Salir
     * @return true en caso de que el Usuario ya no quiera iniciar Sesion, false en caso de que quier volver a iniciar sesion
     */
    private boolean iniciarSesionMensajes(){
        boolean terminaEjecucion = false;
        int opcion = 0;
        while(true && (opcion != 1 || opcion !=2)){
            System.out.println(iniciarSesion.menuMensajes());
            try {
                String opcionUsuario = leeOpcion.nextLine();
                opcion = Integer.parseInt(opcionUsuario);
                if(opcion == 1){
                    System.out.println(iniciarSesion.intentemosloDeNuevo());
                    break;
                } else if(opcion == 2){
                    terminaEjecucion = true;
                    break;
                }else{
                    System.out.println(iniciarSesion.ingreseUnaOpcionValida());
                    }
            }catch (NumberFormatException ex){
                System.out.println(iniciarSesion.ingreseUnaOpcionValida());
            }
        }            
        return terminaEjecucion;
    }

    @Override
    public boolean registrarse(){
        registro = new RegistroTemplate();
        return registro.registroTemplateMethod(conexionBanco);
    }

    @Override
    public void verSaldo() {
        System.out.println("Tu saldo es de ");
        System.out.println(cliente.getDineroTotal());
    }

    @Override
    public void verNotificaciones() {
        System.out.println("podria imprimirse una lista de notificaciones");

    }

    @Override
    public void retirarDinero() {
        System.out.println("retirando dinero");

    }

    @Override
    public void transferirDinero() {
        System.out.println("tranfiriendo dinero");
        //verificar que la cuenta a la que se tranfiere exista

    }

    @Override
    public void estadoCuenta() {

        System.out.println("estado de cuenta");

    }

    @Override
    public void comprarBoletos() {
        System.out.println("comprando");

    }
}