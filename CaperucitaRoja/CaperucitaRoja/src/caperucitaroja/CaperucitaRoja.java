

package CaperucitaRoja;
import controlador.controladorCesta;
import controlador.controladorVista;
import vista.JFInterfaz;
import vista.JFCesta;
import vista.JFDatos;

//Diego Rodriguez

public class CaperucitaRoja {
    public static void main(String[]args){
        JFCesta frmCesta=new JFCesta();
        JFInterfaz frmInterfaz=new JFInterfaz();
        JFDatos frmDatos = new JFDatos();
        
        controladorCesta controlCesta = new controladorCesta(frmCesta);
        controladorVista controlInterfaz =new controladorVista(frmInterfaz,controlCesta, frmDatos);
        frmInterfaz.setVisible(true);
        frmCesta.setVisible(true);
    }
}
