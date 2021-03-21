package cliente;

import protocolo.Protocolo;
import figuras.*;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author gabhs
 */
public class Cliente {

    private static final int _PUERTO = 12345;
    private static final String _IP = "25.85.157.68";

    public static void main(String[] args) throws IOException {
        InetAddress ipServidor = null;
        boolean res = true;
        Scanner sc = new Scanner(System.in);

        try {
            ipServidor = InetAddress.getByName(_IP);
        } catch (UnknownHostException uhe) {
            System.err.println("Host no encontrado : " + uhe);
            System.exit(-1);
        }

        do {
            Socket socketCliente = null;
            DataInputStream inputArea = null;
            DataInputStream inputVolumen = null;
            DataOutputStream outputCadena = null;
            int operation;
            Protocolo protocolo = new Protocolo();
            String cadena, resultado;
            Cilindro cilindro;
            Esfera esfera;
            Cono cono;
            Cubo cubo;
            Prisma prisma;
            Piramide piramide;
            System.out.println("***PARA CALCULAR EL AREA ELIGA UNA FIGURA GEOMETRICA**");
            System.out.println("(1) CILINDRO------------------------------------------");
            System.out.println("(2) ESFERA--------------------------------------------");
            System.out.println("(3) CONO----------------------------------------------");
            System.out.println("(4) CUBO----------------------------------------------");
            System.out.println("(5) PRISMA--------------------------------------------");
            System.out.println("(6) PIRAMIDE------------------------------------------");
            System.out.println("*PARA CALCULAR EL VOLUMEN ELIGA UNA FIGURA GEOMETRICA*");
            System.out.println("(7) CILINDRO------------------------------------------");
            System.out.println("(8) ESFERA--------------------------------------------");
            System.out.println("(9) CONO----------------------------------------------");
            System.out.println("(10) CUBO---------------------------------------------");
            System.out.println("(11) PRISMA-------------------------------------------");
            System.out.println("(12) PIRAMIDE-----------------------------------------");
            System.out.println("(13) SALIR--------------------------------------------");
            System.out.println("***INGRESA UNA DE LAS SIGUENTES OPCIONES DISPONIBLES**");
            System.out.print("OPERACION: ");
            operation = sc.nextInt();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            switch (operation) {
                case 1:
                    cilindro = new Cilindro();
                    cilindro.setOperacion("A");
                    // realizamos la obtencion de variables para la figura cilindro
                    System.out.println("CALCULANDO EL AREA DEL CILINDRO");
                    System.out.println("PROFAVOR DE INGRESAR LOS SIGUENTES DATOS");
                    System.out.print("RADIO: ");
                    cilindro.setRadio(reader.readLine());
                    System.out.print("ALTURA: ");
                    cilindro.setAltura(reader.readLine());
                    // Creamos el socket
                    socketCliente = new Socket(ipServidor, _PUERTO);
                    // Extraemos los streams de entrada y salida
                    inputArea = new DataInputStream(socketCliente.getInputStream());
                    outputCadena = new DataOutputStream(socketCliente.getOutputStream());
                    // obtenemos la cadena del protocolo y la escribimos en el flujo
                    cadena = protocolo.Cadena(cilindro);
                    outputCadena.writeUTF(cadena);
                    // mostramos resultado en pantalla
                    resultado = protocolo.resultado(inputArea.readUTF());
                    System.out.println("---------------------------------");
                    System.out.println("RADIO = " + cilindro.getRadio() + "\nALTURA = " + cilindro.getAltura() + "\nRESULTADO : AREA = " + resultado + "\n");
                    // cerramos los streams y el socket
                    inputArea.close();
                    outputCadena.close();
                    socketCliente.close();
                    break;
                case 2:
                    esfera = new Esfera();
                    esfera.setOperacion("A");
                    // realizamos la obtencion de variables para la figura esfera
                    System.out.println("CALCULANDO EL AREA DE ESFERA");
                    System.out.println("PROFAVOR DE INGRESAR LOS SIGUENTES DATOS");
                    System.out.print("RADIO: ");
                    esfera.setRadio(reader.readLine());

                    socketCliente = new Socket(ipServidor, _PUERTO);
                    inputArea = new DataInputStream(socketCliente.getInputStream());
                    outputCadena = new DataOutputStream(socketCliente.getOutputStream());
                    cadena = protocolo.Cadena(esfera);
                    outputCadena.writeUTF(cadena);

                    resultado = protocolo.resultado(inputArea.readUTF());
                    System.out.println("---------------------------------");
                    System.out.println("RADIO = " + esfera.getRadio() + "\nRESULTADO : AREA = " + resultado + "\n");
                    inputArea.close();
                    outputCadena.close();
                    socketCliente.close();

                    break;
                case 3:
                    cono = new Cono();
                    cono.setOperacion("A");
                    // realizamos la obtencion de variables para la figura cono
                    System.out.println("CALCULANDO AREA DEL CONO");
                    System.out.println("PROFAVOR DE INGRESAR LOS SIGUENTES DATOS");
                    System.out.print("RADIO: ");
                    cono.setRadio(reader.readLine());
                    System.out.print("ALTURA: ");
                    cono.setAltura(reader.readLine());
                    System.out.print("GENERATRIZ: ");
                    cono.setGeneratriz(reader.readLine());

                    socketCliente = new Socket(ipServidor, _PUERTO);
                    inputArea = new DataInputStream(socketCliente.getInputStream());
                    outputCadena = new DataOutputStream(socketCliente.getOutputStream());
                    cadena = protocolo.Cadena(cono);
                    outputCadena.writeUTF(cadena);

                    resultado = protocolo.resultado(inputArea.readUTF());
                    System.out.println("---------------------------------");
                    System.out.println("RADIO = " + cono.getRadio() + "\n" + "ALTURA = " + cono.getAltura()
                            + "\n" + "GENERATRIZ :" + cono.getGeneratriz() + "\nRESULTADO : AREA = " + resultado + "\n");
                    inputArea.close();
                    outputCadena.close();
                    socketCliente.close();
                    break;
                case 4:
                    cubo = new Cubo();
                    cubo.setOperacion("A");
                    // realizamos la obtencion de variables para la figura cono
                    System.out.println("CALCULANDO AREA DEL CUBO");
                    System.out.println("PROFAVOR DE INGRESAR LOS SIGUENTES DATOS");
                    System.out.println("ARISTA: ");
                    cubo.setArista(reader.readLine());

                    socketCliente = new Socket(ipServidor, _PUERTO);
                    inputArea = new DataInputStream(socketCliente.getInputStream());
                    outputCadena = new DataOutputStream(socketCliente.getOutputStream());
                    cadena = protocolo.Cadena(cubo);
                    outputCadena.writeUTF(cadena);

                    resultado = protocolo.resultado(inputArea.readUTF());
                    System.out.println("---------------------------------");
                    System.out.println("ARISTA = " + cubo.getArista() + "\nRESULTADO : AREA = " + resultado + "\n");
                    inputArea.close();
                    outputCadena.close();
                    socketCliente.close();

                    break;
                case 5:
                    prisma = new Prisma();
                    prisma.setOperacion("A");
                    // realizamos la obtencion de variables para la figura prisma
                    System.out.println("CALCULANDO AREA DEL PRISMA");
                    System.out.println("PROFAVOR DE INGRESAR LOS SIGUENTES DATOS");
                    System.out.println("PERIMETRO BASE: ");
                    prisma.setPerimetroBase(reader.readLine());
                    System.out.println("ALTURA: ");
                    prisma.setAltura(reader.readLine());
                    System.out.println("AREA DE LA BASE: ");
                    prisma.setAreaBase(reader.readLine());

                    socketCliente = new Socket(ipServidor, _PUERTO);
                    inputArea = new DataInputStream(socketCliente.getInputStream());
                    outputCadena = new DataOutputStream(socketCliente.getOutputStream());
                    cadena = protocolo.Cadena(prisma);
                    outputCadena.writeUTF(cadena);

                    resultado = protocolo.resultado(inputArea.readUTF());
                    System.out.println("---------------------------------");
                    System.out.println("PERIMETRO DE BASE = " + prisma.getPerimetroBase()
                            + "\nALTURA = " + prisma.getAltura() + "\nAREA DE LA BASE = " + prisma.getAreaBase()
                            + "\nRESULTADO : AREA = " + resultado + "\n");
                    inputArea.close();
                    outputCadena.close();
                    socketCliente.close();

                    break;
                case 6:
                    piramide = new Piramide();
                    piramide.setOperacion("A");
                    // realizamos la obtencion de variables para la figura piramide
                    System.out.println("CALCULANDO AREA DE LA PIRAMIDE");
                    System.out.println("PROFAVOR DE INGRESAR LOS SIGUENTES DATOS");
                    System.out.print("PERIMETRO DE BASE: ");
                    piramide.setPerimetroBase(reader.readLine());
                    System.out.print("ALTURA: ");
                    piramide.setAltura(reader.readLine());
                    System.out.print("AREA DE LA BASE: ");
                    piramide.setAreaBase(reader.readLine());
                    System.out.print("APOTEMA LATERAL: ");
                    piramide.setApotemaLateral(reader.readLine());

                    socketCliente = new Socket(ipServidor, _PUERTO);
                    inputArea = new DataInputStream(socketCliente.getInputStream());
                    outputCadena = new DataOutputStream(socketCliente.getOutputStream());
                    cadena = protocolo.Cadena(piramide);
                    outputCadena.writeUTF(cadena);

                    resultado = protocolo.resultado(inputArea.readUTF());
                    System.out.println("---------------------------------");
                    System.out.println("PERIMETRO DE BASE = " + piramide.getPerimetroBase()
                            + "\nALTURA = " + piramide.getAltura() + "\nAREA DE LA BASE = " + piramide.getAreaBase()
                            + "\nAPOTEMA LATERAL = " + piramide.getApotemaLateral()
                            + "\ntRESPUESTA : AREA = " + resultado + "\n");
                    inputArea.close();
                    outputCadena.close();
                    socketCliente.close();

                    break;
                case 7:
                    cilindro = new Cilindro();
                    cilindro.setOperacion("V");
                    // realizamos la obtencion de variables para la figura cilindro
                    System.out.println("CALCULANDO EL VOLUMEN DEL CILINDRO");
                    System.out.println("PROFAVOR DE INGRESAR LOS SIGUENTES DATOS");
                    System.out.print("RADIO: ");
                    cilindro.setRadio(reader.readLine());
                    System.out.print("ALTURA: ");
                    cilindro.setAltura(reader.readLine());

                    socketCliente = new Socket(ipServidor, _PUERTO);
                    inputVolumen = new DataInputStream(socketCliente.getInputStream());
                    outputCadena = new DataOutputStream(socketCliente.getOutputStream());
                    cadena = protocolo.Cadena(cilindro);
                    outputCadena.writeUTF(cadena);

                    resultado = protocolo.resultado(inputVolumen.readUTF());
                    System.out.println("---------------------------------");
                    System.out.println("RADIO = " + cilindro.getRadio() + "\n" + "ALTURA = " + cilindro.getAltura() + "\nRESULTADO : VOLUMEN = " + resultado + "\n");
                    inputVolumen.close();
                    outputCadena.close();
                    socketCliente.close();
                    break;
                case 8:
                    esfera = new Esfera();
                    esfera.setOperacion("V");
                    // realizamos la obtencion de variables para la figura esfera
                    System.out.println("CALCULANDO EL VOLUMEN DE LA ESFERA");
                    System.out.println("PROFAVOR DE INGRESAR LOS SIGUENTES DATOS");
                    System.out.print("RADIO: ");
                    esfera.setRadio(reader.readLine());

                    socketCliente = new Socket(ipServidor, _PUERTO);
                    inputVolumen = new DataInputStream(socketCliente.getInputStream());
                    outputCadena = new DataOutputStream(socketCliente.getOutputStream());
                    cadena = protocolo.Cadena(esfera);
                    outputCadena.writeUTF(cadena);

                    resultado = protocolo.resultado(inputVolumen.readUTF());
                    System.out.println("---------------------------------");
                    System.out.println("RADIO = " + esfera.getRadio() + "\nRESULTADO : VOLUMNE = " + resultado + "\n");
                    inputVolumen.close();
                    outputCadena.close();
                    socketCliente.close();
                    break;
                case 9:
                    cono = new Cono();
                    cono.setOperacion("V");
                    // realizamos la obtencion de variables para la figura cono
                    System.out.println("CALCULANDO VOLUMEN DEL CONO");
                    System.out.println("PROFAVOR DE INGRESAR LOS SIGUENTES DATOS");
                    System.out.print("RADIO: ");
                    cono.setRadio(reader.readLine());
                    System.out.print("ALTURA: ");
                    cono.setAltura(reader.readLine());
                    System.out.print("GENERATRIZ: ");
                    cono.setGeneratriz(reader.readLine());

                    socketCliente = new Socket(ipServidor, _PUERTO);
                    inputVolumen = new DataInputStream(socketCliente.getInputStream());
                    outputCadena = new DataOutputStream(socketCliente.getOutputStream());
                    cadena = protocolo.Cadena(cono);
                    outputCadena.writeUTF(cadena);

                    resultado = protocolo.resultado(inputVolumen.readUTF());
                    System.out.println("---------------------------------");
                    System.out.println("RADIO = " + cono.getRadio() + "\n" + "ALTURA = " + cono.getAltura()
                            + "\n" + "GENERATRIZ :" + cono.getGeneratriz() + "\nRESULTADO : VOLUMEN = " + resultado + "\n");
                    inputVolumen.close();
                    outputCadena.close();
                    socketCliente.close();
                    break;
                case 10:
                    cubo = new Cubo();
                    cubo.setOperacion("V");
                    // realizamos la obtencion de variables para la figura cono
                    System.out.println("Calculando VOLUMEN de CUBO");
                    System.out.println("PROFAVOR DE INGRESAR LOS SIGUENTES DATOS");
                    System.out.println("ARISTA: ");
                    cubo.setArista(reader.readLine());

                    socketCliente = new Socket(ipServidor, _PUERTO);
                    inputVolumen = new DataInputStream(socketCliente.getInputStream());
                    outputCadena = new DataOutputStream(socketCliente.getOutputStream());
                    cadena = protocolo.Cadena(cubo);
                    outputCadena.writeUTF(cadena);

                    resultado = protocolo.resultado(inputVolumen.readUTF());
                    System.out.println("---------------------------------");
                    System.out.println("ARISTA = " + cubo.getArista() + "\nRESULTADO : VOLUMEN = " + resultado + "\n");
                    inputVolumen.close();
                    outputCadena.close();
                    socketCliente.close();

                    break;
                case 11:
                    prisma = new Prisma();
                    prisma.setOperacion("V");
                    // realizamos la obtencion de variables para la figura prisma
                    System.out.println("Calculando Area de PRISMA");
                    System.out.println("PROFAVOR DE INGRESAR LOS SIGUENTES DATOS");
                    System.out.print("PERIMETRO DE BASE: ");
                    prisma.setPerimetroBase(reader.readLine());
                    System.out.print("ALTURA: ");
                    prisma.setAltura(reader.readLine());
                    System.out.print("AREA DE LA BASE: ");
                    prisma.setAreaBase(reader.readLine());

                    socketCliente = new Socket(ipServidor, _PUERTO);
                    inputVolumen = new DataInputStream(socketCliente.getInputStream());
                    outputCadena = new DataOutputStream(socketCliente.getOutputStream());
                    cadena = protocolo.Cadena(prisma);
                    outputCadena.writeUTF(cadena);

                    resultado = protocolo.resultado(inputVolumen.readUTF());
                    System.out.println("PERIMETRO DE BASE = " + prisma.getPerimetroBase()
                            + "\nALTURA = " + prisma.getAltura() + "\nAREA DE LA BASE = " + prisma.getAreaBase()
                            + "\nRESULTADO : VOLUMEN = " + resultado + "\n");
                    inputVolumen.close();
                    outputCadena.close();
                    socketCliente.close();

                    break;
                case 12:
                    piramide = new Piramide();
                    piramide.setOperacion("V");
                    // realizamos la obtencion de variables para la figura piramide
                    System.out.println("Calculando Area de PIRAMIDE");
                    System.out.println("PROFAVOR DE INGRESAR LOS SIGUENTES DATOS");
                    System.out.print("PERIMETRO DE BASE: ");
                    piramide.setPerimetroBase(reader.readLine());
                    System.out.print("ALTURA: ");
                    piramide.setAltura(reader.readLine());
                    System.out.print("AREA DE LA BASE: ");
                    piramide.setAreaBase(reader.readLine());
                    System.out.print("APOTEMA LATERAL: ");
                    piramide.setApotemaLateral(reader.readLine());

                    socketCliente = new Socket(ipServidor, _PUERTO);
                    inputVolumen = new DataInputStream(socketCliente.getInputStream());
                    outputCadena = new DataOutputStream(socketCliente.getOutputStream());
                    cadena = protocolo.Cadena(piramide);
                    outputCadena.writeUTF(cadena);

                    resultado = protocolo.resultado(inputVolumen.readUTF());
                    System.out.println("---------------------------------");
                    System.out.println("\nPERIMETRO DE BASE = " + piramide.getPerimetroBase()
                            + "\nALTURA = " + piramide.getAltura() + "\nAREA DE LA BASE = " + piramide.getAreaBase()
                            + "\nAPOTEMA LATERAL = " + piramide.getApotemaLateral()
                            + "\nRESULTADO : VOLUMEN = " + resultado + "\n");
                    inputVolumen.close();
                    outputCadena.close();
                    socketCliente.close();

                    break;
                case 13:
                    res = false;
            }
        } while (res == true);

    }
}
