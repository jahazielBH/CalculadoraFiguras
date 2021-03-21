/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figuras;

/**
 *
 * @author gabhs
 */
public class Piramide implements Figura {

    private String operacion, areaBase, perimetroBase, altura, apotemaLateral;

    @Override
    public String getNombre() {
        return "piramide";
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public String getAreaBase() {
        return areaBase;
    }

    public void setAreaBase(String areaBase) {
        this.areaBase = areaBase;
    }

    public String getPerimetroBase() {
        return perimetroBase;
    }

    public void setPerimetroBase(String perimetroBase) {
        this.perimetroBase = perimetroBase;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getApotemaLateral() {
        return apotemaLateral;
    }

    public void setApotemaLateral(String apotemaLateral) {
        this.apotemaLateral = apotemaLateral;
    }

    @Override
    public String getRadio() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getGeneratriz() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getArista() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
