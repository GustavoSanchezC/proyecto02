package Aplicacion;

import java.util.Scanner;
import Aplicacion.MenuAplicacion.MenuStrategy;
import Aplicacion.MenuAplicacion.MenusIdiomasStrategy.AmericanEnglishMenu;
import Aplicacion.MenuAplicacion.MenusIdiomasStrategy.MenuCanadienFrancais;
import Aplicacion.MenuAplicacion.MenusIdiomasStrategy.MenuEspannolLatino;
import Aplicacion.OperacionesBanco.Proxy.Envio.CitibanaCheems;
import Aplicacion.OperacionesBanco.Proxy.Envio.CitibanaCheemsProxy;

public class CitibanaCheemsControlador {

    //public static final String COLOR_NEGRO = "\u001B[30m";
    public static final String COLOR_ROJO = "\u001B[31m";
    public static final String COLOR_VERDE = "\u001B[32m";
    public static final String COLOR_AMARILLO = "\u001B[33m";
    public static final String COLOR_AZUL = "\u001B[34m";
    //public static final String COLOR_MORADO = "\u001B[35m";
    public static final String COLOR_CYAN = "\u001B[36m";
    //public static final String COLOR_BLANCO = "\u001B[37m";
    public static final String COLOR_RESET = "\u001B[0m";

    private String idioma;
    private boolean salir   ;
    private MenuStrategy menu;
    private Scanner leeOpcion = new Scanner(System.in);
    private CitibanaCheemsProxy citibanaCheemsProxy;
    

    /**
     * Metodo que imprime el logo de la empresa "CITIBANACHEEMS"
     */
    private void imprimeEmpresa(){
        System.out.println(COLOR_AZUL + "++++++++++++++++++++++++++++++++++++++++++++++++++++++" + COLOR_RESET + "\n" + 
            COLOR_AZUL + "+                                                    +" + COLOR_RESET +"\n" +
            COLOR_AZUL + "+                   " + COLOR_ROJO +"CITIBANACHEEMS" + COLOR_AZUL + "                   +" + COLOR_RESET +"\n" +
            COLOR_AZUL + "+                                                    +" + COLOR_RESET +"\n" +
            COLOR_AZUL + "++++++++++++++++++++++++++++++++++++++++++++++++++++++" + COLOR_RESET +"\n");
    }

    /**
     * Metodo es para poder seleccionar un idioma o salir de la aplicacion. 
     */
    public void menuPrincipal(){
        int opcionUsuario = opcionMenuPrincipal();
        switch (opcionUsuario) {
            case 1:
                idioma = "ESPANNOL LATINO";
                menu = new MenuEspannolLatino();
                break;
            case 2:
                idioma = "AMERICAN ENGLISH";
                menu = new AmericanEnglishMenu();
                break;
            case 3: 
                idioma = "FRANCAIS CANADIEN";
                menu = new MenuCanadienFrancais();
                break;
            case 4:
                System.out.println(COLOR_CYAN + "¡ADIOS! / GOODBYE! / ADIEU!" + COLOR_RESET);
                System.exit(1);
                salir = true;
                break;
            default:
                break;
        }
        if(opcionUsuario >= 1 && opcionUsuario <=3){
            citibanaCheemsProxy = new CitibanaCheemsProxy(new CitibanaCheems(getIdioma()));
        }
    }

    /**
     * Metodo nos devuelve un int en donde nos indica el idioma para correr la aplicacion, o nos indica si quiere salir.
     * @return 1 si El idioma a escoger es Espannol Latino
     * 2 si El idioma a escoger es Ingles Americano
     * 3 si el usuario desea salir  
     */
    private int opcionMenuPrincipal(){
        salir = false;
        int opcion = 0;
        boolean realizaUnaVez = false;
        while(!realizaUnaVez){
            try {
                imprimeEmpresa();
                System.out.println(COLOR_AMARILLO + "ESCRIBA UN NUMERO, NUESTRAS OPCIONES SON: / TYPE A NUMBER, OUR OPTIONS ARE THESE:" +
                    " / ECRIVEZ UN CHIFFRE, NOS OPTIONS SONT:" + COLOR_RESET + "\n" +
                    COLOR_AMARILLO + "1. ESPANNOL LATINO." + COLOR_RESET + "\n" +
                    COLOR_AMARILLO + "2. AMERICAN ENGLISH." + COLOR_RESET + "\n" +
                    COLOR_AMARILLO + "3. FRANCAIS CANADIEN." + COLOR_RESET + "\n" + 
                    COLOR_AMARILLO + "4. SALIR. / EXIT. / SORTIE." + COLOR_RESET + "\n");
                String opcionUsuario = leeOpcion.nextLine();
                opcion = Integer.parseInt(opcionUsuario);
                if(opcion >= 1 && opcion <= 4){
                    realizaUnaVez = true;
                }else{
                    System.out.println(COLOR_ROJO + "ESCRIBA UNA OPCION VALIDA. / TYPE A VALID OPCION. / ECRIRE UNE OPTION VALIDE."+ COLOR_RESET + "\n");
                }
            } catch (NumberFormatException nfe) {
                System.out.println(COLOR_ROJO + "ESCRIBA UN NUMERO. / TYPE A NUMBER. / ECRIRE UN NUMERO." + COLOR_RESET + "\n");
            }
        }
        return opcion;
    }

    /**
     * Este metodo es para poder iniciar sesion, registrarse o salir.
     */
    public void segundoMenu(){
        int opcionUsuario = 0;
        if(!getSalir()){
            opcionUsuario = opcionSegundoMenu();
            switch (opcionUsuario) {
                case 1:
                    //INICIAR SESION.
                    salir = !(citibanaCheemsProxy.iniciarSesion());
                    break;
                case 2: 
                    //REGISTRARSE.
                    salir = !(citibanaCheemsProxy.registrarse());
                    break;
                case 3: 
                    salir = true;   
                    break;
                default:
                    break;
            }
        }
        if(getSalir()){
            System.out.println(menu.mensajeDeDespedida());
        }
    }

    /**
     * Metodo para que el usuario puede selecionar un opcion de las cuales tenemos los iguientes casos:
     * @return 1 si quiere iniciar sesion.
     * 2 si quiere registrarse.
     * 3 si quiere salir de la aplicacion
     */
    private int opcionSegundoMenu(){
        salir = false;
        int opcion = 0;
        boolean realizaUnaVez = false;
        System.out.println(menu.mensajeDeBienvenida());
        while(!realizaUnaVez){
            try {
                imprimeEmpresa();
                System.out.println(menu.primerMenu());
                String opcionUsuario = leeOpcion.nextLine();
                opcion = Integer.parseInt(opcionUsuario);
                if(opcion >= 1 && opcion <= 3){
                    realizaUnaVez = true;
                }else{
                    System.out.println(menu.escribaUnaOpcionDelMenu());
                }
            } catch (NumberFormatException nfe) {
                System.out.println(menu.ingresaUnaOpcionValida());
            }
        }
        return opcion;
    }

    /**
     * Este metodo es para poder ver el 3er menu de la aplicacion
     */
    public void tercerMenu(){
        if(!getSalir()){
            //AQUI VA A HABER UN CICLO, HASTA QUE EL USUARIO QUIERA CIERRE SESION O SE SALGA SIN RECURSION.
            boolean terminaEjecucion = false;
            int opcionUusuario = 0;
            while(!terminaEjecucion){
                opcionUusuario = opcionTercerMenu();
                switch (opcionUusuario) {
                    case 1:
                        //VER SALDO.
                        System.out.println("-----------------------------------PELIGRO------------------------------\n" + 
                        "ESTAMOS VIENDO EL SALDO");
                        citibanaCheemsProxy.verSaldo();
                        break;
                    case 2: 
                        //VER NOTIFACIONES.
                        System.out.println("-----------------------------------PELIGRO------------------------------\n" + 
                            "ESTAMOS VIENDO LAS NOTIFICACIONES");
                        citibanaCheemsProxy.verNotificaciones();
                        break;
                    case 3:
                        //Retirar Sin tarjeta
                        System.out.println("-----------------------------------PELIGRO------------------------------\n" + 
                            "ESTAMOS RETIRANDO DINERO");
                        citibanaCheemsProxy.retirarDinero();
                        break;
                    case 4:
                        //TRANFERIR DINERO.
                        System.out.println("-----------------------------------PELIGRO------------------------------\n" + 
                            "ESTAMOS TRANFIRIENDO DINERO");
                        citibanaCheemsProxy.transferirDinero();
                        break;
                    case 5:
                        //ver estados de cuenta.
                        System.out.println("-----------------------------------PELIGRO------------------------------\n" + 
                            "ESTAMOS VIENDO LOS ESTADOS DE CUENTA");
                        citibanaCheemsProxy.estadoCuenta();
                        break;
                    case 6: 
                        //COMPRAR BOLETOS EN TICKET MASTER
                        System.out.println("-----------------------------------PELIGRO------------------------------\n" + 
                        "ESTAMOS COMPRANDO EN TICKET MASTER CHEEMS");
                        citibanaCheemsProxy.comprarBoletos();
                        break;
                    case 7:
                        //BIEN
                        System.out.println(menu.hemosCerradoSesion());
                        terminaEjecucion = true;
                        break;
                    case 8:
                        //BIEN
                        System.out.println(menu.mensajeDeDespedida());
                        salir = true;   
                        terminaEjecucion = true;
                        break;
                    default:
                        break;
                }
            }
            if(opcionUusuario == 7){
                menuPrincipal();
                segundoMenu();
                tercerMenu();
            }
        }
    }

    /**
     * Metodo para poder seleccionar una opcion del menu de nuestra tercera Ventana.
     * @return los siguientes casos:
     * caso 1: si el usuario quiere ver su saldo.
     * caso 2: si el ususario quiere ver sus notificaciones
     * caso 3: si el usuario quiere retirar sin tarjeta.
     * caso 4: si el usuario quiere Transferir Dinero.
     * caso 5: si el usuario quiere ver estados de cuenta.
     * caso 6: si el usuairio quiere comprar boletos en TicketMasterCheems
     * caso 7: si el usuario quiere cerrar sesion.
     * caso 8: si el usuario quiere salir de la aplicacion. 
     */
    private int opcionTercerMenu(){
        salir = false;
        int opcion = 0;
        boolean realizaUnaVez = false;
        while(!realizaUnaVez){
            try {
                imprimeEmpresa();
                System.out.println(menu.segundoMenu());
                String opcionUsuario = leeOpcion.nextLine();
                opcion = Integer.parseInt(opcionUsuario);
                if(opcion >= 1 && opcion <= 8){
                    realizaUnaVez = true;
                }else{
                    System.out.println(menu.escribaUnaOpcionDelMenu());
                }
            } catch (NumberFormatException nfe) {
                System.out.println(menu.ingresaUnaOpcionValida());
            }
        }
        return opcion;
    }

    /**
     * Metodo que nos indica si el usuario desea salir de la aplicacion.
     * @return true en caso de que quiera salir, false en caso de que no.
     */
    public boolean getSalir(){
        return salir;
    }

    /**
     * Metodo que nos regresa un String, el cual es el idioma con el que se correra la aplicacion.
     * @return un String, el cual es el idioma de toda la aplicacion.
     */
    public String getIdioma(){
        return idioma;
    }
}