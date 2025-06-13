
package Controlador;

import Entidades.Tiendas;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class TiendaControlador {
    public void mostrarTienda(JTable tbTienda){
        
        DefaultTableModel modeloTienda = new DefaultTableModel();
        
        modeloTienda.addColumn("Id_T");
        modeloTienda.addColumn("Tienda");
        modeloTienda.addColumn("Direccion");
        
        tbTienda.setModel(modeloTienda);
        
        Modelo.TiendaModelo objetoModeloTienda = new Modelo.TiendaModelo();
        List<Tiendas> tiendas = objetoModeloTienda.mostrarTienda();
        
        Object[] datosT = new Object[3];
        
        for(Tiendas t: tiendas){    
            datosT[0] = t.getIdT();
            datosT[1] = t.getTienda();
            datosT[2] = t.getDireccion();
            
            modeloTienda.addRow(datosT);
            
        }  
        tbTienda.setModel(modeloTienda);
    }
    
    public void InsertartTienda(JTextField paramTienda, JTextField paramDireccion){
    
        try {
            Modelo.TiendaModelo ut = new Modelo.TiendaModelo();
            Tiendas ust = new Tiendas();
            ust.setIdT(null);
            ust.setTienda(paramTienda.getText());
            ust.setDireccion(paramDireccion.getText());
           
            ut.crearT(ust);
            JOptionPane.showMessageDialog(null, "Se registró correctamente la tienda");
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se registró la tienda");
        }
    }
    
    public void SeleccionarTienda(JTable paramTablaTienda, JTextField paramId_T, JTextField paramTienda, JTextField paramDireccion){
        
        try {
            int fila = paramTablaTienda.getSelectedRow();
            if (fila>=0){
                paramId_T.setText(paramTablaTienda.getValueAt(fila, 0).toString());
                paramTienda.setText(paramTablaTienda.getValueAt(fila, 1).toString());
                paramDireccion.setText(paramTablaTienda.getValueAt(fila, 2).toString());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se seleccionó la tienda");
        }
        
    }
    
    public void ModificarTienda(JTextField paramCodigoTienda, JTextField paramTienda, JTextField paramDireccion) {

        try {
            Modelo.TiendaModelo ut = new Modelo.TiendaModelo();
            Tiendas ust = new Tiendas();

            ust.setIdT(Integer.valueOf(paramCodigoTienda.getText()));
            ust.setTienda(paramTienda.getText());
            ust.setDireccion(paramDireccion.getText());

            ut.editarT(ust);
            JOptionPane.showMessageDialog(null, "Se modificó correctamente la tienda");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se modificó el nombre de la tienda");
        }
    }
    
    public void EliminarTienda(JTextField paramCodigoTienda){
    
        try {
            Modelo.TiendaModelo ut = new Modelo.TiendaModelo();
            Tiendas ust = new Tiendas();
            
            ust.setIdT(Integer.valueOf(paramCodigoTienda.getText()));
            
            ut.eliminarT(ust);
            JOptionPane.showMessageDialog(null, "Se eliminó correctamente la tienda");
                    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se eliminó la tienda");
        }
    }
    
    public void limpiarTienda (JTextField paramId_T, JTextField paramTienda, JTextField paramDireccion){
        paramId_T.setText("");
        paramTienda.setText("");
        paramDireccion.setText("");
    }
    
}
