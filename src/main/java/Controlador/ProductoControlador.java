package Controlador;

import Entidades.Productos;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ProductoControlador {
    public void mostrarproducto(JTable tbProducto){
        
        DefaultTableModel modeloproducto = new DefaultTableModel();
        
        modeloproducto.addColumn("Id_P");
        modeloproducto.addColumn("Producto");
        modeloproducto.addColumn("Precio");
        
        tbProducto.setModel(modeloproducto);
        
        Modelo.ProductoModelo objetoModeloproducto = new Modelo.ProductoModelo();
        List<Productos> productos = objetoModeloproducto.mostrarproducto();
        
        Object[] datosP = new Object[3];
        
        for(Productos p: productos){    
            datosP[0] = p.getIdP();
            datosP[1] = p.getProducto();
            datosP[2] = p.getPrecio();
            
            modeloproducto.addRow(datosP);
            
        }  
        tbProducto.setModel(modeloproducto);
    }
    
    public void InsertarProducto(JTextField paramProducto, JTextField paramPrecio){
    
        try {
            Modelo.ProductoModelo up = new Modelo.ProductoModelo();
            Productos usp = new Productos();
            usp.setIdP(null);
            usp.setProducto(paramProducto.getText());
            usp.setPrecio(paramPrecio.getText());
           
            up.crearP(usp);
            JOptionPane.showMessageDialog(null, "Se registró correctamente el producto");
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se registró el producto");
        }
    }
    
    public void SeleccionarProducto(JTable paramTablaProducto, JTextField paramId_P, JTextField paramProducto, JTextField paramPrecio){
        
        try {
            int fila = paramTablaProducto.getSelectedRow();
            if (fila>=0){
                paramId_P.setText(paramTablaProducto.getValueAt(fila, 0).toString());
                paramProducto.setText(paramTablaProducto.getValueAt(fila, 1).toString());
                paramPrecio.setText(paramTablaProducto.getValueAt(fila, 2).toString());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se seleccionó producto");
        }
        
    }
    
    public void ModificarProducto(JTextField paramCodigoProducto, JTextField paramProducto, JTextField paramPrecio) {

        try {
            Modelo.ProductoModelo up = new Modelo.ProductoModelo();
            Productos usp = new Productos();

            usp.setIdP(Integer.valueOf(paramCodigoProducto.getText()));
            usp.setProducto(paramProducto.getText());
            usp.setPrecio(paramPrecio.getText());

            up.editarP(usp);
            JOptionPane.showMessageDialog(null, "Se modificó correctamente el producto");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se modificó el producto");
        }
    }
    
    public void EliminarProducto(JTextField paramCodigoProducto){
    
        try {
            Modelo.ProductoModelo up = new Modelo.ProductoModelo();
            Productos usp = new Productos();
            
            usp.setIdP(Integer.valueOf(paramCodigoProducto.getText()));
            
            up.eliminarP(usp);
            JOptionPane.showMessageDialog(null, "Se eliminó correctamente el producto");
                    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se eliminó el producto");
        }
    }
    
    public void limpiarProducto (JTextField paramId_P, JTextField paramProducto, JTextField paramPrecio){
        paramId_P.setText("");
        paramProducto.setText("");
        paramPrecio.setText("");
    }
    
}
