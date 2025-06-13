
package Modelo;

import Entidades.Productos;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ProductoModelo {
    private EntityManager entityManager(){
        return Conexion.CConexion.getInstancia().getEntidadConexion().createEntityManager();
    }
    
    public List<Productos>mostrarproducto(){
        Query r = entityManager().createQuery("SELECT p FROM Productos p");
        return r.getResultList();
    }
    
    public void crearP(Productos productos){
        EntityManager entidad = entityManager();
        try {
            entidad.getTransaction().begin();
            entidad.persist(productos);
            entidad.getTransaction().commit();
            
        } catch (Exception e){
            entidad.getTransaction().rollback();
        }
    }
    
    public void editarP(Productos productos){
        EntityManager entidad = entityManager();
        try {
            entidad.getTransaction().begin();
            entidad.merge(productos);
            entidad.getTransaction().commit();
            
        } catch (Exception e){
            entidad.getTransaction().rollback();
        }
    }
    
    public void eliminarP(Productos producto){
        EntityManager entidad = entityManager();
        try {
            entidad.getTransaction().begin();
            entidad.remove(entidad.merge(producto));
            entidad.getTransaction().commit();
            
        } catch (Exception e){
            entidad.getTransaction().rollback();
        }
    }
}
