
package com.mycompany.crudjpa;

public class CrudJPA {

    public static void main(String[] args) {
        vista.vistaUsuarios objetoUsuarios = new vista.vistaUsuarios();
        objetoUsuarios.setVisible(true);
        
        vista.VistaProductos objetoProductos = new vista.VistaProductos();
        objetoProductos.setVisible(true);
        
        vista.VistaTiendas objetoTiendas = new vista.VistaTiendas();
        objetoTiendas.setVisible(true);
    }
}
