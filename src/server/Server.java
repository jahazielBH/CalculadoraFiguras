/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import log.Log;
import log.LogImplement;


/**
 *
 * @author gabhs
 */
public class Server {

    private static final String _IP = "25.85.157.68";
    private static final int _PORT = 12345;
    private static final int _BACKLOG = 50;

    public static void main(String[] args) throws UnknownHostException {
        // Creamos instancia de clase InetAddress para indicar
        // El host donde se inicia el servidor
        InetAddress ip = InetAddress.getByName(_IP);
        
        // Usamos un manejador de formato para el log del servidor y para los resultados
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        DecimalFormat df = new DecimalFormat("#.00");
        
        try {
            System.out.println("IP de LocalHost = " + InetAddress.getLocalHost().toString());
            System.out.println("\nESCUCHANDO EN : ");
            System.out.println("IP HOST = " + ip.getHostAddress());
            System.out.println("PUERTO = " + _PORT);
        } catch (UnknownHostException uhe) {
            System.err.println("No puedo saber la direccion IP local : " + uhe);
        }
        
        // Abrimos un "Socket de Servidor" TCP en el puerto 12345.
        ServerSocket server = null;
        try {
            server = new ServerSocket(_PORT, _BACKLOG, ip);
        } catch (IOException ioe) {
            System.err.println("Error al abrir el socket de servidor : " + ioe);
            System.exit(-1);
        }

        while (true) {
            try {
                 // Esperemos a que alguien se conecte a nuestro Socket
                Socket socket = server.accept();
                //  Extraemos los flujos de entrada y de salida
                DataInputStream inputCadena = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                DataOutputStream outputCadena = new DataOutputStream(socket.getOutputStream());
                // Obtenemos el IP y Puerto del Cliente
                InetAddress ipRemitente = socket.getInetAddress();
                int puertoRemitente = socket.getPort();

                // Obtenemos la cadena del protocolo
                String cadena = inputCadena.readUTF();

                // variables para realizar los calculos correspindientes 
                double area;
                double volumen;

                // variables para cear instancia de la clase Log y su Implementacion
                Log log;
                LogImplement logImpl;

                // funcion split para dividir la cadena del protocolo
                String[] parts = cadena.split("-");

                // operacion en la posicion 0
                String Ope = parts[0];
                // figura en la posicion 1
                String Fig = parts[1];
                
                // variables para asignarles el valor corespondiente de la cadena del protocolo dividida y poder hacer los calculos
                String radioC, aristaC, areaBaseC, alturaC, generatrizC, perimetroBaseC, apotemaLateralC;
                // variable para poder formar la cadena de salida 
                String cadenaFinal = null;

                // ejecutamos el bloque case corespondiente a la figura que obtuvimos de la cadena del protocolo
                switch (Fig) {
                    case "Cil":
                        {
                            //obtenemos el radio de la cadena del protocolo en la posicion 2
                            radioC = parts[2];
                            double radio = Double.parseDouble(radioC);
                            //obtenemos la altura de la cadena del protocolo en la posicion 3
                            alturaC = parts[3];
                            double altura = Double.parseDouble(alturaC);
                            // si la operacion fue el calculo del area 
                            if (Ope.equals("A")) {
                                // realizamos el calculo corespondiente
                                area = 2 * Math.PI * radio * (altura + radio);
                                // se contruye la cade del protocolo de salida y damos formato al area
                                cadenaFinal = Ope + "-" + Fig + "-" + radioC + "-" + alturaC + "-" + df.format(area);
                                
                                // instanciamos un log y asignamos valores
                                log = new Log();
                                log.setOperacion(Ope);
                                log.setFigura(Fig);
                                log.setFecha(formatter.format(new Date()));
                                log.setIp(ipRemitente.toString());
                                log.setPuerto(puertoRemitente);
                                log.setDatos_entrada(cadena);
                                log.setDatos_salida(cadenaFinal);
                                // instanciamos su implemntacion del log y guardamos el registro en la base de datos
                                logImpl = new LogImplement();
                                logImpl.addLog(log);
                                
                            } else {
                                volumen = Math.PI * (radio * radio) * altura;
                                // se contruye la cade del protocolo de salida y damos formato al volumen
                                cadenaFinal = Ope + "-" + Fig + "-" + radioC + "-" + alturaC + "-" + df.format(volumen);
                                
                                log = new Log();
                                log.setOperacion(Ope);
                                log.setFigura(Fig);
                                log.setFecha(formatter.format(new Date()));
                                log.setIp(ipRemitente.toString());
                                log.setPuerto(puertoRemitente);
                                log.setDatos_entrada(cadena);
                                log.setDatos_salida(cadenaFinal);
                                
                                logImpl = new LogImplement();
                                logImpl.addLog(log);
                            }       break;
                        }
                    case "Esf":
                        {
                            radioC = parts[2];
                            double radio = Double.parseDouble(radioC);
                            if (Ope.equals("A")) {
                                area = 4 * Math.PI * (radio * radio);

                                cadenaFinal = Ope + "-" + Fig + "-" + radioC + "-" + df.format(area);
                                
                                log = new Log();
                                log.setOperacion(Ope);
                                log.setFigura(Fig);
                                log.setFecha(formatter.format(new Date()));
                                log.setIp(ipRemitente.toString());
                                log.setPuerto(puertoRemitente);
                                log.setDatos_entrada(cadena);
                                log.setDatos_salida(cadenaFinal);
                                
                                logImpl = new LogImplement();
                                logImpl.addLog(log);
                            } else {
                                volumen = (4 / 3) * Math.PI * (radio * radio * radio);

                                cadenaFinal = Ope + "-" + Fig + "-" + radioC + "-" + df.format(volumen);
                                
                                log = new Log();
                                log.setOperacion(Ope);
                                log.setFigura(Fig);
                                log.setFecha(formatter.format(new Date()));
                                log.setIp(ipRemitente.toString());
                                log.setPuerto(puertoRemitente);
                                log.setDatos_entrada(cadena);
                                log.setDatos_salida(cadenaFinal);
                                
                                logImpl = new LogImplement();
                                logImpl.addLog(log);
                            }       break;
                        }
                    case "Con":
                        {
                            radioC = parts[2];
                            double radio = Double.parseDouble(radioC);
                            alturaC = parts[3];
                            double altura = Double.parseDouble(alturaC);
                            generatrizC = parts[4];
                            double generatriz = Double.parseDouble(generatrizC);
                            if (Ope.equals("A")) {
                                area = Math.PI * (radio * radio) + Math.PI * radio + generatriz;

                                cadenaFinal = Ope + "-" + Fig + "-" + radioC + "-" + alturaC + "-" + generatrizC + "-" + df.format(area);
                                
                                log = new Log();
                                log.setOperacion(Ope);
                                log.setFigura(Fig);
                                log.setFecha(formatter.format(new Date()));
                                log.setIp(ipRemitente.toString());
                                log.setPuerto(puertoRemitente);
                                log.setDatos_entrada(cadena);
                                log.setDatos_salida(cadenaFinal);
                                
                                logImpl = new LogImplement();
                                logImpl.addLog(log);
                            } else {
                                volumen = (Math.PI * (radio * radio) * altura) / 3;

                                cadenaFinal = Ope + "-" + Fig + "-" + radioC + "-" + alturaC + "-" + generatrizC + "-" + df.format(volumen);
                                
                                log = new Log();
                                log.setOperacion(Ope);
                                log.setFigura(Fig);
                                log.setFecha(formatter.format(new Date()));
                                log.setIp(ipRemitente.toString());
                                log.setPuerto(puertoRemitente);
                                log.setDatos_entrada(cadena);
                                log.setDatos_salida(cadenaFinal);
                                
                                logImpl = new LogImplement();
                                logImpl.addLog(log);
                            }       break;
                        }
                    case "Cub":
                        aristaC = parts[2];
                        double arista = Double.parseDouble(aristaC);
                        if (Ope.equals("A")) {
                            area = 6 * Math.pow(arista, 2);
                            //
                            cadenaFinal = Ope + "-" + Fig + "-" + aristaC + "-" + df.format(area);
                            
                            log = new Log();
                            log.setOperacion(Ope);
                            log.setFigura(Fig);
                            log.setFecha(formatter.format(new Date()));
                            log.setIp(ipRemitente.toString());
                            log.setPuerto(puertoRemitente);
                            log.setDatos_entrada(cadena);
                            log.setDatos_salida(cadenaFinal);
                            
                            logImpl = new LogImplement();
                            logImpl.addLog(log);
                        } else {
                            volumen = Math.pow(arista, 3);

                            cadenaFinal = Ope + "-" + Fig + "-" + aristaC + "-" + df.format(volumen);
                            
                            log = new Log();
                            log.setOperacion(Ope);
                            log.setFigura(Fig);
                            log.setFecha(formatter.format(new Date()));
                            log.setIp(ipRemitente.toString());
                            log.setPuerto(puertoRemitente);
                            log.setDatos_entrada(cadena);
                            log.setDatos_salida(cadenaFinal);
                            
                            logImpl = new LogImplement();
                            logImpl.addLog(log);
                        }   break;
                    case "Pri":
                        {
                            perimetroBaseC = parts[4];
                            double perimetroBase = Double.parseDouble(perimetroBaseC);
                            alturaC = parts[3];
                            double altura = Double.parseDouble(alturaC);
                            areaBaseC = parts[2];
                            double areaBase = Double.parseDouble(areaBaseC);
                            if (Ope.equals("A")) {
                                area = (perimetroBase * altura) + 2 * areaBase;

                                cadenaFinal = Ope + "-" + Fig + "-" + areaBaseC + "-" + alturaC + "-" + perimetroBaseC + "-" + df.format(area);
                                
                                log = new Log();
                                log.setOperacion(Ope);
                                log.setFigura(Fig);
                                log.setFecha(formatter.format(new Date()));
                                log.setIp(ipRemitente.toString());
                                log.setPuerto(puertoRemitente);
                                log.setDatos_entrada(cadena);
                                log.setDatos_salida(cadenaFinal);
                                
                                logImpl = new LogImplement();
                                logImpl.addLog(log);
                            } else {
                                volumen = areaBase * altura;

                                cadenaFinal = Ope + "-" + Fig + "-" + areaBaseC + "-" + alturaC + "-" + perimetroBaseC + "-" + df.format(volumen);
                                
                                log = new Log();
                                log.setOperacion(Ope);
                                log.setFigura(Fig);
                                log.setFecha(formatter.format(new Date()));
                                log.setIp(ipRemitente.toString());
                                log.setPuerto(puertoRemitente);
                                log.setDatos_entrada(cadena);
                                log.setDatos_salida(cadenaFinal);
                                
                                logImpl = new LogImplement();
                                logImpl.addLog(log);
                            }       break;
                        }
                    case "Pir":
                        {
                            perimetroBaseC = parts[4];
                            double perimetroBase = Double.parseDouble(perimetroBaseC);
                            alturaC = parts[3];
                            double altura = Double.parseDouble(alturaC);
                            areaBaseC = parts[2];
                            double areaBase = Double.parseDouble(areaBaseC);
                            apotemaLateralC = parts[5];
                            double apotemaLateral = Double.parseDouble(apotemaLateralC);
                            if (Ope.equals("A")) {
                                area = (perimetroBase * apotemaLateral) / 2 + areaBase;

                                cadenaFinal = Ope + "-" + Fig + "-" + areaBaseC + "-" + alturaC + "-" + perimetroBaseC + "-" + apotemaLateralC + "-" + df.format(area);
                                
                                log = new Log();
                                log.setOperacion(Ope);
                                log.setFigura(Fig);
                                log.setFecha(formatter.format(new Date()));
                                log.setIp(ipRemitente.toString());
                                log.setPuerto(puertoRemitente);
                                log.setDatos_entrada(cadena);
                                log.setDatos_salida(cadenaFinal);
                                
                                logImpl = new LogImplement();
                                logImpl.addLog(log);
                            } else {
                                volumen = (areaBase * altura) / 3;

                                cadenaFinal = Ope + "-" + Fig + "-" + areaBaseC + "-" + alturaC + "-" + perimetroBaseC + "-" + apotemaLateralC + "-" + df.format(volumen);
                                
                                log = new Log();
                                log.setOperacion(Ope);
                                log.setFigura(Fig);
                                log.setFecha(formatter.format(new Date()));
                                log.setIp(ipRemitente.toString());
                                log.setPuerto(puertoRemitente);
                                log.setDatos_entrada(cadena);
                                log.setDatos_salida(cadenaFinal);
                                
                                logImpl = new LogImplement();
                                logImpl.addLog(log);
                            }       break;
                        }
                }
                // mostramos los registros de la base de datos postgres
                mostrarRegistros();
                // escribimos la cadena de protocolo de salida
                outputCadena.writeUTF(cadenaFinal);
                //cerramos los streams
                inputCadena.close();
                outputCadena.close();
                socket.close();

            } catch (Exception e) {
                System.out.println("Se ha producido la excepcion : " + e);
            }
        }
    }
    
    public static void mostrarRegistros(){
        LogImplement logImpl = new LogImplement();
        List<Log> logs;
        logs = logImpl.getAllLog();
        logs.forEach((log) -> {
            System.out.println(log);
        });
    }

}
