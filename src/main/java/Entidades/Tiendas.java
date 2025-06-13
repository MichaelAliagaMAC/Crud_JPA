
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "tiendas")
@NamedQueries({
    @NamedQuery(name = "Tiendas.findAll", query = "SELECT t FROM Tiendas t"),
    @NamedQuery(name = "Tiendas.findByIdT", query = "SELECT t FROM Tiendas t WHERE t.idT = :idT"),
    @NamedQuery(name = "Tiendas.findByTienda", query = "SELECT t FROM Tiendas t WHERE t.tienda = :tienda"),
    @NamedQuery(name = "Tiendas.findByDireccion", query = "SELECT t FROM Tiendas t WHERE t.direccion = :direccion")})
public class Tiendas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_T")
    private Integer idT;
    @Column(name = "Tienda")
    private String tienda;
    @Column(name = "Direccion")
    private String direccion;

    public Tiendas() {
    }

    public Tiendas(Integer idT) {
        this.idT = idT;
    }

    public Integer getIdT() {
        return idT;
    }

    public void setIdT(Integer idT) {
        this.idT = idT;
    }

    public String getTienda() {
        return tienda;
    }

    public void setTienda(String tienda) {
        this.tienda = tienda;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idT != null ? idT.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tiendas)) {
            return false;
        }
        Tiendas other = (Tiendas) object;
        if ((this.idT == null && other.idT != null) || (this.idT != null && !this.idT.equals(other.idT))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Tiendas[ idT=" + idT + " ]";
    }
    
}
