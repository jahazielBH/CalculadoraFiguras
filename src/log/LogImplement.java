/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package log;

import db.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jahaziel
 */
public class LogImplement implements InterfaceLog<Log> {

    ConexionDB con;
    PreparedStatement ps;
    String query;
    ResultSet rs;
    List<Log> logs;
    Log log;

    /**
     *
     * @param log
     */
    @Override
    public void addLog(Log log) {
        query = "INSERT INTO log (operacion, figura, fecha, ip, puerto, datosentrada, datossalida) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            con = ConexionDB.getInstace();
            ps = con.getConnection().prepareStatement(query);
            ps.setString(1, log.getOperacion());
            ps.setString(2, log.getFigura());
            ps.setString(3, log.getFecha());
            ps.setString(4, log.getIp());
            ps.setInt(5, log.getPuerto());
            ps.setString(6, log.getDatos_entrada());
            ps.setString(7, log.getDatos_salida());
            ps.execute();
        } catch (SQLException e) {
            Logger.getLogger(LogImplement.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public List<Log> getAllLog() {
        query = "SELECT * FROM log ORDER BY fecha";
        try {
            con = ConexionDB.getInstace();
            ps = con.getConnection().prepareStatement(query);
            logs = new ArrayList();
            rs = ps.executeQuery();
            while (rs.next()) {
                log = new Log();
                log.setOperacion(rs.getString(1));
                log.setFigura(rs.getString(2));
                log.setFecha(rs.getString(3));
                log.setIp(rs.getString(4));
                log.setPuerto(rs.getInt(5));
                log.setDatos_entrada(rs.getString(6));
                log.setDatos_salida(rs.getString(7));
                logs.add(log);
            }
            return logs;
        } catch (SQLException e) {
            Logger.getLogger(LogImplement.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

}
