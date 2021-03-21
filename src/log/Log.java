/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package log;

import java.sql.Date;

/**
 *
 * @author jahaziel
 */
public class Log {
    
    private String operacion;
    private String figura;
    private String fecha;
    private String ip;
    private int puerto;
    private String datos_entrada;
    private String datos_salida;

    public Log() {
    }

    public Log(String operacion, String figura, String fecha, String ip, int puerto, String datos_entrada, String datos_salida) {
        this.operacion = operacion;
        this.figura = figura;
        this.fecha = fecha;
        this.ip = ip;
        this.puerto = puerto;
        this.datos_entrada = datos_entrada;
        this.datos_salida = datos_salida;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public String getFigura() {
        return figura;
    }

    public void setFigura(String figura) {
        this.figura = figura;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPuerto() {
        return puerto;
    }

    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }

    public String getDatos_entrada() {
        return datos_entrada;
    }

    public void setDatos_entrada(String datos_entrada) {
        this.datos_entrada = datos_entrada;
    }

    public String getDatos_salida() {
        return datos_salida;
    }

    public void setDatos_salida(String datos_salida) {
        this.datos_salida = datos_salida;
    }

    @Override
    public String toString() {
        return "LOG: " + "OPERACION: " + operacion + ", FIGURA: " + figura + ", FECHA: " + fecha + ", IP: " + ip + ", PUERTO:" + puerto + ", ENTRADA: " + datos_entrada + ", SALIDA: " + datos_salida ;
    }
    
}
