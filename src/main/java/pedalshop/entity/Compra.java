/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pedalshop.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author User
 */
@Entity
@Table(name = "COMPRA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Compra.findAll", query = "SELECT c FROM Compra c")
    , @NamedQuery(name = "Compra.findByCompraid", query = "SELECT c FROM Compra c WHERE c.compraid = :compraid")
    , @NamedQuery(name = "Compra.findByFecha", query = "SELECT c FROM Compra c WHERE c.fecha = :fecha")})
public class Compra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "COMPRAID")
    private Integer compraid;
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "USUARIOID", referencedColumnName = "USERID")
    @ManyToOne(optional = false)
    private Usuario usuarioid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compraid")
    private List<CompraDetalle> compraDetalleList;

    public Compra() {
    }

    public Compra(Integer compraid) {
        this.compraid = compraid;
    }

    public Integer getCompraid() {
        return compraid;
    }

    public void setCompraid(Integer compraid) {
        this.compraid = compraid;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Usuario getUsuarioid() {
        return usuarioid;
    }

    public void setUsuarioid(Usuario usuarioid) {
        this.usuarioid = usuarioid;
    }

    @XmlTransient
    public List<CompraDetalle> getCompraDetalleList() {
        return compraDetalleList;
    }

    public void setCompraDetalleList(List<CompraDetalle> compraDetalleList) {
        this.compraDetalleList = compraDetalleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (compraid != null ? compraid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compra)) {
            return false;
        }
        Compra other = (Compra) object;
        if ((this.compraid == null && other.compraid != null) || (this.compraid != null && !this.compraid.equals(other.compraid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pedalshop.entity.Compra[ compraid=" + compraid + " ]";
    }
    
}
