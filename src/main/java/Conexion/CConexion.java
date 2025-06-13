
package Conexion;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CConexion {
    
    private static CConexion instancia = new CConexion();
    private EntityManagerFactory entidadConexion;
    
    private CConexion (){
        entidadConexion = Persistence.createEntityManagerFactory("conexionCrud");
    }

    public static CConexion getInstancia() {
        return instancia;
    }

    public EntityManagerFactory getEntidadConexion() {
        return entidadConexion;
    }
    
}
