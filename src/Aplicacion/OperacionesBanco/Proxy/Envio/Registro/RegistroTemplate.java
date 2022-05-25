package Aplicacion.OperacionesBanco.Proxy.Envio.Registro;

import java.util.Scanner;

import Aplicacion.OperacionesBanco.BaseDatos.MySQLSingletonModelo;
import Aplicacion.OperacionesBanco.Proxy.Envio.Verificacion;

public class RegistroTemplate {

    private Verificacion ayudaAVerificar = new Verificacion();
    private Scanner leeOpcion = new Scanner(System.in);
    private String informacionUsuario;

    public boolean registroTemplateMethod(MySQLSingletonModelo conexionBanco){
        System.out.println("+++++++++++++++++++++++ REGISTRO +++++++++++++++++++++++\n");
        String nombre;
        if(escribeNombreDeUsuarioBien(conexionBanco)){
            nombre = getInformacionUsuario();
            String contrasenna;
            if(escribeContrasennaBien()){
                contrasenna = getInformacionUsuario();
                String nombreReal;
                if(escribeNombreRealBien()){
                    nombreReal = getInformacionUsuario();
                    String telefono;
                    if(escribeTelefonoBien()){
                        telefono = getInformacionUsuario();
                        String direccion;
                        if(escribeDireccionBien()){
                            direccion = getInformacionUsuario();
                            if(escribePaisBien()){
                                String cuentaBancaria;
                                System.out.println("FELICIDADES TE HAS REGISTRADO.");
                                return true;
                            }
                            /**if(escribeCuentaBancariaBien()){
                                cuentaBancaria = getInformacion();
                                String pais;
                                if(escribePaisBien()){
                                    pais = getInformacion();
                                    System.out.println("¡FELICIDADES, TE HAS REGISTRADO EXITOSAMENTE EN CHEEMSMART!");
                                    baseDeDatos.registrarse(nombre, contrasenna, nombreReal, telefono, direccion, cuentaBancaria, pais);
                                    return true;
                                }
                            }*/
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * Metodo para que el usuario Registre su nombre de usuario
     * @return true en caso de que el Usuario se halla registrado bien, false en caso de que el usuario ya no quiera
     * continuar con el registro.
     */
    private boolean escribeNombreDeUsuarioBien(MySQLSingletonModelo conexionBanco){
        boolean realizaUnaVez = false;
        while(!realizaUnaVez){
            System.out.println("ESCRIBE UN NOMBRE DE USUARIO UNICO, SIN ESPACIOS Y SIN BORRAR:");
            String nombreUsuario = leeOpcion.nextLine();
            if(ayudaAVerificar.tieneEspaciosEnBlanco(nombreUsuario) || ayudaAVerificar.estaCompuestoSoloEspBlanc(nombreUsuario)){
                System.out.println("\nLO SENTIMOS, INGRESASTE TU INFORMACION CON ESPACIOS, ESCRIBE DE NUEVO SIN ESPACIOS Y SIN BORRAR.");
                if(!quiereVolverARegistrarse()){
                    break;
                }
            }else{
                //AQUI DEBO VERIFICAR CON LA BASE DE DATOS
                if(conexionBanco.existeUsuario(nombreUsuario)){
                    System.out.println("\nLO SENTIMOS EN NOMBRE DE USUARIO YA EXISTE, POR FAVOR ESCRIBE OTRO.");
                    if(!quiereVolverARegistrarse()){break;}
                }else{
                    if(estaSeguroDeSuInformacion()){
                        setInformacionUsuario(nombreUsuario);
                        realizaUnaVez = true;
                    }
                }
            }   
        }
        return realizaUnaVez;
    }

    /**
     * Metodo para que el usuario registre su contrasenna
     * @return true en caso de que el usuario halla se halla registrado bien, false en caso de que el usuario ya no quiera con-
     * tinuar con el registro.
     */
    private boolean escribeContrasennaBien(){
        boolean realizaUnaVez = false;
        while(!realizaUnaVez){
            System.out.println("ESCRIBE TU CONTRASENNA PARA TU CUENTA, SIN ESPACIOS Y SIN BORRAR:");
            String contrasenna = leeOpcion.nextLine();
            if(ayudaAVerificar.tieneEspaciosEnBlanco(contrasenna) || ayudaAVerificar.estaCompuestoSoloEspBlanc(contrasenna)){
                System.out.println("\nLO SENTIMOS, INGRESASTE TU INFORMACION CON ESPACIOS, ESCRIBE DE NUEVO SIN ESPACIOS Y SIN BORRAR.");
                if(!quiereVolverARegistrarse()){break;}
            }else{
                if(estaSeguroDeSuInformacion()){
                    setInformacionUsuario(contrasenna);
                    realizaUnaVez = true;
                }
            }   
        }
        return realizaUnaVez;
    }

    /**
     * Metodo para escribir el nombre Real del usuario
     * @return true en caso de que halla escrito bien su nombre, false en caso de que ya no quiera continuar el registro
     */
    private boolean escribeNombreRealBien(){
        boolean realizaUnaVez = false;
        while(!realizaUnaVez){
            System.out.println("ESCRIBE TU NOMBRE COMPLETO REAL:");
            String nombre = leeOpcion.nextLine();
            if(ayudaAVerificar.estaCompuestoSoloEspBlanc(nombre)){
                System.out.println("\nLO SENTIMOS, INGRESASTE PUROS ESPACIOS EN BLANCO, ESCRIBE TU NOMBRE REAL.");
                if(!quiereVolverARegistrarse()){break;}
            }else if(ayudaAVerificar.tieneEspaciosEnBlanco(nombre)){///AQUI CUIDADO ESTAN MAL
                System.out.println("\nLO SENTIMOS, INGRESASTE ESPACIOS VACIOS AL INICIO, ESCRIBE TU NOMBRE REAL SIN ESPACIOS AL INICIO.");
                if(!quiereVolverARegistrarse()){break;}
            }else{
                if(estaSeguroDeSuInformacion()){
                    setInformacionUsuario(nombre);
                    realizaUnaVez = true;
                }
            }
        }
        return realizaUnaVez;
    }

    /**
     * Metodo para escribir el telefono correctamente del usuario
     * @return true en caso de que el usuario este de acuerdo con sus datos, false en caso de que no
     */
    private boolean escribeTelefonoBien(){
        boolean realizaUnaVez = false;
        while(!realizaUnaVez){
            System.out.println("ESCRIBE LOS 10 DIGITOS DE TU NUMERO TELEFONICO SIN ESPACIOS:");
            String telefono = leeOpcion.nextLine();
            if(ayudaAVerificar.tieneEspaciosEnBlanco(telefono)){
                System.out.println("\nPOR FAVOR, INGRESA TU NUMERO TELEFONICO SIN ESPACIOS.");
                if(!quiereVolverARegistrarse()){break;}
            }else{
                if(ayudaAVerificar.esUnNumero(telefono)){
                    if(telefono.length() == 10){
                        if(estaSeguroDeSuInformacion()){
                            setInformacionUsuario(telefono);
                            realizaUnaVez = true;
                            break;
                        }
                    }else{
                        System.out.println("\nINGRESA LOS 10 DIGITOS DE TU NUMERO TELEFONICO.");
                        if(!quiereVolverARegistrarse()){break;}
                    }
                }else{
                    System.out.println("\nINGRESA TU NUMERO TELEFONICO SIN OTRO CARACTER.");
                    if(!quiereVolverARegistrarse()){break;}
                }
            }
        }
        return realizaUnaVez;
    }

    /**
     * Metodo para escribir la direccion del usuario
     * @return true en caso de que el usuario halla colocado bien su direccion, false en otro caso.
     */
    private boolean escribeDireccionBien(){
        boolean realizaUnaVez = false;
        while(!realizaUnaVez){
            System.out.println("ESCRIBE SU DIRECCION DE DOMICILIO COMPLETA:");
            String direccion = leeOpcion.nextLine();
            if(ayudaAVerificar.estaCompuestoSoloEspBlanc(direccion)){
                System.out.println("\nLO SENTIMOS, INGRESASTE PUROS ESPACIOS EN BLANCO, ESCRIBE TU DIRECCION:");
                if(!quiereVolverARegistrarse()){break;}
            }else if(ayudaAVerificar.tieneEspaciosEnBlanco(direccion)){
                System.out.println("\nLO SENTIMOS, INGRESASTE ESPACIOS VACIOS AL INICIO, ESCRIBE TU DIRECCION SIN ESPACIOS AL INICIO.");
                if(!quiereVolverARegistrarse()){break;}
            }else{
                if(estaSeguroDeSuInformacion()){
                    setInformacionUsuario(direccion);
                    realizaUnaVez = true;
                }
            }
        }
        return realizaUnaVez;
    }

    /**
     * Metodo para seleccionar correctamente el pais donde vive el usuario
     * @return true en caso de que usuario halla seleccionado correctamente su Pais, false en caso de ya no seguir el registro
     */
    private boolean escribePaisBien(){
        boolean realizaUnaVez = false;
        int opcion = 0; 
        boolean seRegistro = true;
        while(!realizaUnaVez){
            System.out.println("SELECCIONE SU PAIS, ESCRIBA SOLO EL NUMERO:" +
                "\n1. ESTADOS UNIDOS." +
                "\n2. MEXICO." +
                "\n3. CANADA" +
                "\n4. GUATEMALA.");
            try {
                String opcionUsuario = leeOpcion.nextLine();
                opcion = Integer.parseInt(opcionUsuario);
                switch (opcion){
                    case 1:
                        if(estaSeguroDeSuInformacion()){
                            setInformacionUsuario("UnitedStates");
                            realizaUnaVez = true;
                        }
                        break;
                    case 2: 
                        if(estaSeguroDeSuInformacion()){
                            setInformacionUsuario("Mexico");
                            realizaUnaVez = true;
                        }
                        break;
                    case 3: 
                        if(estaSeguroDeSuInformacion()){
                            setInformacionUsuario("Canada");
                            realizaUnaVez = true;
                        }
                        break;
                    case 4:
                        if(estaSeguroDeSuInformacion()){
                            setInformacionUsuario("Guatemala");
                            realizaUnaVez = true;
                        }
                    default:
                        if(!quiereVolverARegistrarse()){
                            realizaUnaVez = true;
                            seRegistro = false;
                        }
                        break;
                }
            }catch (NumberFormatException ex){
                if(!quiereVolverARegistrarse()){
                    realizaUnaVez = true;
                    seRegistro = false;
                }
            }
        }
        return seRegistro;
    }

    /**
     * Metodo que nos asegura si los datos del usuario son correctos 
     * @return en caso de que la informacion dada por el usuario es correcta, false en caso de que no este de acuerdo
     */
    private boolean estaSeguroDeSuInformacion(){
        int opcion = 0;
        while(true && (opcion != 1 || opcion != 2)){
            System.out.println("\n¿QUIERE GUARDAR ESA INFORMACION?"+
            "\n1. SI." +
            "\n2. NO.");    
            try {
                String opcionUsuario = leeOpcion.nextLine();
                opcion = Integer.parseInt(opcionUsuario);
                if(opcion == 1 || opcion == 2){
                    if(opcion == 2){
                        System.out.println("\n¡OKAY, INTENTEMOSLO DE NUEVO!\n");
                    }
                    break;
                }else{
                    System.out.println("\nINGRESE UNA OPCION VALIDA.");
                }
            }catch (NumberFormatException ex){
                System.out.println("\nINGRESE UNA OPCION VALIDA.");
            }
        }
        return (opcion == 1);
    }

    /**
     * Metodo que nos dice si el usuario quiere Volver a Registrarse
     * @return true en caso de que quiera intetar registrarse, false en caso de que ya no quiera registrarse
     */
    private boolean quiereVolverARegistrarse(){
        int opcion = 0;
        boolean seRegistro = false;
        while(true && (opcion != 1 || opcion != 2)){
            System.out.println("\n¿DESEA VOLVER INTENTAR A REGISTRARSE?" +
                "\n1. VOLVER A INTENTAR REGISTRARSE." +
                "\n2. SALIR.");
            try {
                String opcionUsuario = leeOpcion.nextLine();
                opcion = Integer.parseInt(opcionUsuario);
                if(opcion == 1){
                    System.out.println("\n¡OKAY, INTENTEMOSLO DE NUEVO!\n");
                    seRegistro = true;
                    break;
                } else if(opcion == 2){
                    break;
                }else{
                    System.out.println("\nINGRESE UNA OPCION VALIDA.");
                }
            }catch (NumberFormatException ex){
                System.out.println("\nINGRESE UNA OPCION VALIDA.");
            }
        }
        return seRegistro;
    }   

    /**
     * Metodo para poder establecer la informacion del usuario en cada paso
     * @param informacionUsuario es la informacion del usuario a guardar.
     */
    private void setInformacionUsuario(String informacionUsuario){
        this.informacionUsuario = informacionUsuario;
    }

    /**
     * Metodo para poder obtener la informacion del usuario que hemos guardado.
     * @return un String el cual es la informacion que hemos guardado del usuario.
     */
    private String getInformacionUsuario(){
        return informacionUsuario;
    }
}