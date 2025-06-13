
package Modelo;

import Entidades.Tiendas;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class TiendaModelo {
    private EntityManager entityManager(){
        return Conexion.CConexion.getInstancia().getEntidadConexion().createEntityManager();
    }
    
    public List<Tiendas>mostrarTienda(){
        Query r = entityManager().createQuery("SELECT t FROM Tiendas t");
        return r.getResultList();
    }
    
    public void crearT(Tiendas tiendas){
        EntityManager entidad = entityManager();
        try {
            entidad.getTransaction().begin();
            entidad.persist(tiendas);
            entidad.getTransaction().commit();
            
        } catch (Exception e){
            entidad.getTransaction().rollback();
        }
    }
    
    public void editarT(Tiendas tiendas){
        EntityManager entidad = entityManager();
        try {
            entidad.getTransaction().begin();
            entidad.merge(tiendas);
            entidad.getTransaction().commit();
            
        } catch (Exception e){
            entidad.getTransaction().rollback();
        }
    }
    
    public void eliminarT(Tiendas Tienda){
        EntityManager entidad = entityManager();
        try {
            entidad.getTransaction().begin();
            entidad.remove(entidad.merge(Tienda));
            entidad.getTransaction().commit();
            
        } catch (Exception e){
            entidad.getTransaction().rollback();
        }
    }
}
