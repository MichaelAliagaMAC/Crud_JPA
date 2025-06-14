
package Controlador;

import Entidades.Usuarios;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class UsuarioControlador {
    public void mostrar(JTable tbUsuarios){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Id");
        modelo.addColumn("Nombres");
        modelo.addColumn("Apellidos");
        
        tbUsuarios.setModel(modelo);
        Modelo.UsuarioModelo objetoModelo = new Modelo.UsuarioModelo();
        List<Usuarios> usuarios = objetoModelo.mostrar();
        
        Object[] datos = new Object[3];
        
        for (Usuarios u: usuarios){
            datos [0]=u.getId();
            datos [1]=u.getNombres();
            datos [2]=u.getApellidos();
            
            modelo.addRow(datos);
        }
        
        tbUsuarios.setModel (modelo);
    }
    
    public void InsertarUsuario(JTextField paramNombres, JTextField paramApellidos){
    
        try {
            Modelo.UsuarioModelo us = new Modelo.UsuarioModelo();
            Usuarios usr = new Usuarios();
            usr.setId(null);
            usr.setNombres(paramNombres.getText());
            usr.setApellidos(paramApellidos.getText());
            
            us.crear(usr);
            JOptionPane.showMessageDialog(null, "Se registró correctamente el usuario");
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se registró el usuario");
        }
    }
    
    public void SeleccionarUsuario(JTable paramTablaUsuarios, JTextField paramId, JTextField paramNombres, JTextField paramApellidos){
        
        try {
            int fila = paramTablaUsuarios.getSelectedRow();
            if (fila>=0){
                paramId.setText(paramTablaUsuarios.getValueAt(fila, 0).toString());
                paramNombres.setText(paramTablaUsuarios.getValueAt(fila, 1).toString());
                paramApellidos.setText(paramTablaUsuarios.getValueAt(fila, 2).toString());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se seleccionó usuario");
        }
        
    }
    
    public void Modificar(JTextField paramCodigo,JTextField paramNombres, JTextField paramApellidos){
    
        try {
            Modelo.UsuarioModelo us = new Modelo.UsuarioModelo();
            Usuarios usr = new Usuarios();
            
            usr.setId(Integer.valueOf(paramCodigo.getText()));
            usr.setNombres(paramNombres.getText());
            usr.setApellidos(paramApellidos.getText());
            
            us.editar(usr);
            JOptionPane.showMessageDialog(null, "Se modificó correctamente el usuario");
                    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se modificó el usuario");
        }
    }
    
    public void Eliminar(JTextField paramCodigo){
    
        try {
            Modelo.UsuarioModelo us = new Modelo.UsuarioModelo();
            Usuarios usr = new Usuarios();
            
            usr.setId(Integer.valueOf(paramCodigo.getText()));
            
            us.eliminar(usr);
            JOptionPane.showMessageDialog(null, "Se eliminó correctamente el usuario");
                    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se eliminó el usuario");
        }
    }
    
    public void limpiar (JTextField paramId, JTextField paramNombre, JTextField paramApellidos){
        paramId.setText("");
        paramNombre.setText("");
        paramApellidos.setText("");
    }
    
}
