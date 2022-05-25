package Aplicacion.OperacionesBanco.BaseDatos;

import java.io.File;
import java.util.Scanner;
import Aplicacion.OperacionesBanco.Cliente;

public class MySQLSingletonModelo {
    
    private static MySQLSingletonModelo baseDeDatos;

    private MySQLSingletonModelo(){}

    /**
     * Metodo para obtner la instacia unicamente por este metodo
     * @return la unica conexion psoible en la que hay.
     */
    public static MySQLSingletonModelo getBaseDeDatos(){
        if(baseDeDatos == null){
            baseDeDatos = new MySQLSingletonModelo();
        }
        return baseDeDatos;
    }

    /**
     * Metodo que nos regresa el cliente el cual recupera la informacion de este cliente.
     * @param usuario es el nombre de usuario de la cuenta de este
     * @param contrasenna es la contrasenna del usuario de su cuenta.
     * @return un cliente en caso de que su nombre de usuario y contrasenna coincidan, false en otro caso.
     */
    public Cliente getCliente(String usuario, String contrasenna){
        Cliente retorno;
        if((retorno = getClienteAyuda(usuario, contrasenna, "src/Aplicacion/OperacionesBanco/BaseDatos/InformacionClientes/Mexico/NombreUsuario.txt")) != null){
            return retorno;
        }
        if((retorno = getClienteAyuda(usuario, contrasenna, "src/Aplicacion/OperacionesBanco/BaseDatos/InformacionClientes/UnitedStates/NombreUsuario.txt")) != null){
            return retorno;
        }
        if((retorno = getClienteAyuda(usuario, contrasenna, "src/Aplicacion/OperacionesBanco/BaseDatos/InformacionClientes/Guatemala/NombreUsuario.txt")) != null){
            return retorno;
        }
        if((retorno = getClienteAyuda(usuario, contrasenna, "src/Aplicacion/OperacionesBanco/BaseDatos/InformacionClientes/Canada/NombreUsuario.txt")) != null){
            return retorno;
        }
        return null;
    }

    /**
     * Metodo de ayuda que nos sirve para buscar en los 4 directorios de los 4 paises disponibles.
     * @param usuario es el nombre de usuario del cliente
     * @param contrasenna es la contrasenna del cliente
     * @param direccion es la direccion donde se encuentra el nombre de Usuario
     * @return null en caso de encontrarse registrado nuestro Cliente, en otro caso regresa nuestro cliente
     */
    private Cliente getClienteAyuda(String usuario, String contrasenna, String direccion){
        float posicion = estaRegistrado(usuario, direccion);
        if(posicion >= 1){
            String rutaComun = direccion.substring(0, 61);
            String pais = direccion.substring(62, direccion.length() - 18);
            String direccionParaEnvios = rutaComun + "/" + pais;
            String contrasennaReal = lecturaInformacion(direccionParaEnvios + "/Contrasenna.txt", posicion);
            if(!contrasenna.equals(contrasennaReal)){
                return null;
            }else{
                String nombreCompleto = lecturaInformacion(direccionParaEnvios + "/NombreReal.txt", posicion);
                long telefono = Long.parseLong(lecturaInformacion(direccionParaEnvios + "/Telefono.txt", posicion));
                String direccionVivienda = lecturaInformacion(direccionParaEnvios + "/Direccion.txt", posicion);    
                String noCuentaBancaria = lecturaInformacion(direccionParaEnvios + "/CuentaBancaria.txt", posicion);
                int nip = Integer.parseInt(lecturaInformacion(direccionParaEnvios + "/Nip.txt", posicion));
                double dineroTotal = Double.parseDouble(lecturaInformacion(direccionParaEnvios + "/DineroTotal.txt", posicion));
                String id = lecturaInformacion(direccionParaEnvios + "/Id.txt", posicion);
                return new Cliente(usuario, contrasenna, nombreCompleto, telefono, direccionVivienda, 
                    noCuentaBancaria, nip, pais, dineroTotal, id);
            }
        }
        return null;
    }

    /**
     * Metodo que nos sirve para verificar si un Usuario esta registrado en nuestra Base De Datos
     * @param usuario es el nombre del usuario de nuestro cliente si es que esta dado de alta
     * @return un float el cual nos dice en que posicion de los archivos txt esta ubicada su informacion, -1 en caso de que no este 
     */
    private float estaRegistrado(String usuario, String direccion){
        File  archivo = new File(direccion);
        Scanner sc = null;
        float contador = 0;
        boolean seEncuentraUsuario = false;
        try {
            sc = new Scanner(archivo);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                ++contador;
                if(line.equals(usuario)){
                    seEncuentraUsuario = true;
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("¡ERROR 404!");
        }finally{
            try {
                sc.close();
            } catch (Exception e) {
                System.out.println("¡ERROR 404!");
            }
        }
        return seEncuentraUsuario?contador:(-1);
    }

    /**
     * Metodo que nos sirve para leer por separado cada dato o atributo del cliente
     * @param direccion es la direccion de un archivo de la base de datos
     * @param posicion es la posicion en la que se encuntra en particular los datos del cliente
     * @return un String, el cual es un atributo del cliente o informacion
     */
    private String lecturaInformacion(String direccion, float posicion){
        File  archivo = new File(direccion);
        Scanner sc = null;
        String informacion = null;
        String linea = null;
        try {
            sc = new Scanner(archivo);
            float contador = 0;
            while(sc.hasNextLine()){
                linea = sc.nextLine();
                ++contador;
                if(contador == posicion){
                    informacion = linea;
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("¡ERROR 404!");
        }finally{
            try {
                sc.close();
            } catch (Exception e) {
                System.out.println("¡ERROR 404!");
            }
        }
        return informacion;
    }

    /**
     * Metodo que comprobar si existe 
     * @param nombreUsuario
     * @return true en caso de que el usuario este ya registrado, false en caso de que no este registrado.
     */
    public boolean existeUsuario(String nombreUsuario){
        String direccionComun = "src/Aplicacion/OperacionesBanco/BaseDatos/InformacionClientes/";
        String corta = "/NombreUsuario.txt";
        if(estaRegistrado(nombreUsuario, (direccionComun + "Mexico" + corta)) != (-1) ||
            estaRegistrado(nombreUsuario, (direccionComun + "UnitedStates" + corta)) != (-1) ||
            estaRegistrado(nombreUsuario, (direccionComun + "Canada" + corta)) != (-1) ||
            estaRegistrado(nombreUsuario, (direccionComun + "Guatemala" + corta)) != (-1)){
            return true;
        }
        return false;
    }
}