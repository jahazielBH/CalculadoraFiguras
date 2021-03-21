/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package log;

import java.util.List;

/**
 *
 * @author jahaziel
 * @param <T>
 */
public interface InterfaceLog<T> {
    public void addLog(Log log);
    public List<T> getAllLog();
}
