/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protocolo;

import figuras.Figura;

/**
 *
 * @author gabhs
 */
public class Protocolo {

    Figura figura;
    String nombre, cadena, radio, oper, altura, generatriz, arista, perimetroBase, areaBase, apotemaLateral;

    public Figura getFigura(Figura figura) {
        return this.figura = figura;
    }

    public String Cadena(Figura figura) {
        nombre = figura.getNombre();

        if (nombre.equals("cilindro")) {
            System.out.println("---------------------------------");
            System.out.println("FIGURA GEOMETRICA CILINDRO");
            System.out.println("---------------------------------");
            radio = figura.getRadio();
            oper = figura.getOperacion();
            altura = figura.getAltura();
            cadena = oper + "-" + "Cil" + "-" + radio + "-" + altura;

        } else if (nombre.equals("esfera")) {
            System.out.println("---------------------------------");
            System.out.println("FIGURA GEOMETRICA ESFERA");
            System.out.println("---------------------------------");
            radio = figura.getRadio();
            oper = figura.getOperacion();
            cadena = oper + "-" + "Esf" + "-" + radio;

        } else if (nombre.equals("cono")) {
            System.out.println("---------------------------------");
            System.out.println("FIGURA GEOMETRICA CONO");
            System.out.println("---------------------------------");
            oper = figura.getOperacion();
            radio = figura.getRadio();
            altura = figura.getAltura();
            generatriz = figura.getGeneratriz();
            cadena = oper + "-" + "Con" + "-" + radio + "-" + altura + "-" + generatriz;

        } else if (nombre.equals("cubo")) {
            System.out.println("---------------------------------");
            System.out.println("FIGURA GEOMETRICA CUBO");
            System.out.println("---------------------------------");
            oper = figura.getOperacion();
            arista = figura.getArista();
            cadena = oper + "-" + "Cub" + "-" + arista;

        } else if (nombre.equals("prisma")) {
            System.out.println("---------------------------------");
            System.out.println("FIGURA GEOMETRICA PRISMA");
            System.out.println("---------------------------------");
            oper = figura.getOperacion();
            areaBase = figura.getAreaBase();
            perimetroBase = figura.getPerimetroBase();
            altura = figura.getAltura();
            cadena = oper + "-" + "Pri" + "-" + areaBase + "-" + altura + "-" + perimetroBase;

        } else {
            System.out.println("---------------------------------");
            System.out.println("FIGURA GEOMETRICA PIRAMIDE");
            System.out.println("---------------------------------");
            oper = figura.getOperacion();
            areaBase = figura.getAreaBase();
            perimetroBase = figura.getPerimetroBase();
            altura = figura.getAltura();
            apotemaLateral = figura.getApotemaLateral();
            cadena = oper + "-" + "Pir" + "-" + areaBase + "-" + altura + "-" + perimetroBase + "-" + apotemaLateral;
        }
        return cadena;
    }

    public String resultado(String cadena) {
        String[] parts = cadena.split("-");

        String Fig = parts[1];
        String op;
        if (Fig.equals("Cil")) {
            op = parts[4];
        } else if (Fig.equals("Esf")) {
            op = parts[3];
        } else if (Fig.equals("Con")) {
            op = parts[5];
        } else if (Fig.equals("Cub")) {
            op = parts[3];
        } else if (Fig.equals("Pri")) {
            op = parts[5];
        } else {
            op = parts[6];
        }
        return op;
    }
}
