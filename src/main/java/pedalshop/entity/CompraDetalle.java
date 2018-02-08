/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pedalshop.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "COMPRA_DETALLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CompraDetalle.findAll", query = "SELECT c FROM CompraDetalle c")
    , @NamedQuery(name = "CompraDetalle.findByCompradetalleid", query = "SELECT c FROM CompraDetalle c WHERE c.compradetalleid = :compradetalleid")
    , @NamedQuery(name = "CompraDetalle.findByCantidad", query = "SELECT c FROM CompraDetalle c WHERE c.cantidad = :cantidad")})
public class CompraDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "COMPRADETALLEID")
    private Integer compradetalleid;
    @Column(name = "CANTIDAD")
    private Integer cantidad;
    @JoinColumn(name = "COMPRAID", referencedColumnName = "COMPRAID")
    @ManyToOne(optional = false)
    private Compra compraid;
    @JoinColumn(name = "PRODUCTOID", referencedColumnName = "PRODUCTOID")
    @ManyToOne(optional = false)
    private Producto productoid;

    public CompraDetalle() {
    }

    public CompraDetalle(Integer compradetalleid) {
        this.compradetalleid = compradetalleid;
    }

    public Integer getCompradetalleid() {
        return compradetalleid;
    }

    public void setCompradetalleid(Integer compradetalleid) {
        this.compradetalleid = compradetalleid;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Compra getCompraid() {
        return compraid;
    }

    public void setCompraid(Compra compraid) {
        this.compraid = compraid;
    }

    public Producto getProductoid() {
        return productoid;
    }

    public void setProductoid(Producto productoid) {
        this.productoid = productoid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (compradetalleid != null ? compradetalleid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompraDetalle)) {
            return false;
        }
        CompraDetalle other = (CompraDetalle) object;
        if ((this.compradetalleid == null && other.compradetalleid != null) || (this.compradetalleid != null && !this.compradetalleid.equals(other.compradetalleid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pedalshop.entity.CompraDetalle[ compradetalleid=" + compradetalleid + " ]";
    }
    
}
