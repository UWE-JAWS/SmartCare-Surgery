/*
 * Copyright © 2020 Simeon Dobchev, William Garthside,
 * Joshua Saxby, Alexander Stratford & Dylan Waters.
 * All rights reserved.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author joshua
 */
@Entity
@Table(name = "CLIENTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clients.findAll", query = "SELECT c FROM Clients c")
    , @NamedQuery(name = "Clients.findByCid", query = "SELECT c FROM Clients c WHERE c.cid = :cid")
    , @NamedQuery(name = "Clients.findByCname", query = "SELECT c FROM Clients c WHERE c.cname = :cname")
    , @NamedQuery(name = "Clients.findByCaddress", query = "SELECT c FROM Clients c WHERE c.caddress = :caddress")
    , @NamedQuery(name = "Clients.findByCtype", query = "SELECT c FROM Clients c WHERE c.ctype = :ctype")})
public class Clients implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CID")
    private Integer cid;
    @Size(max = 50)
    @Column(name = "CNAME")
    private String cname;
    @Size(max = 100)
    @Column(name = "CADDRESS")
    private String caddress;
    @Size(max = 10)
    @Column(name = "CTYPE")
    private String ctype;
    @OneToMany(mappedBy = "cid")
    private Collection<Operations> operationsCollection;
    @JoinColumn(name = "UNAME", referencedColumnName = "UNAME")
    @ManyToOne
    private Users uname;

    public Clients() {
    }

    public Clients(Integer cid) {
        this.cid = cid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCaddress() {
        return caddress;
    }

    public void setCaddress(String caddress) {
        this.caddress = caddress;
    }

    public String getCtype() {
        return ctype;
    }

    public void setCtype(String ctype) {
        this.ctype = ctype;
    }

    @XmlTransient
    public Collection<Operations> getOperationsCollection() {
        return operationsCollection;
    }

    public void setOperationsCollection(Collection<Operations> operationsCollection) {
        this.operationsCollection = operationsCollection;
    }

    public Users getUname() {
        return uname;
    }

    public void setUname(Users uname) {
        this.uname = uname;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cid != null ? cid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clients)) {
            return false;
        }
        Clients other = (Clients) object;
        if ((this.cid == null && other.cid != null) || (this.cid != null && !this.cid.equals(other.cid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Clients[ cid=" + cid + " ]";
    }
    
}
