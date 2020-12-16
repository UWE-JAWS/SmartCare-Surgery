/*
 * Copyright © 2020 Simeon Dobchev, William Garthside,
 * Joshua Saxby, Alexander Stratford & Dylan Waters.
 * All rights reserved.
 */
package model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author joshua
 */
@Entity
@Table(name = "OPERATIONS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Operations.findAll", query = "SELECT o FROM Operations o")
    , @NamedQuery(name = "Operations.findByOid", query = "SELECT o FROM Operations o WHERE o.oid = :oid")
    , @NamedQuery(name = "Operations.findByOdate", query = "SELECT o FROM Operations o WHERE o.odate = :odate")
    , @NamedQuery(name = "Operations.findByOtime", query = "SELECT o FROM Operations o WHERE o.otime = :otime")
    , @NamedQuery(name = "Operations.findByNslot", query = "SELECT o FROM Operations o WHERE o.nslot = :nslot")
    , @NamedQuery(name = "Operations.findByCharge", query = "SELECT o FROM Operations o WHERE o.charge = :charge")})
public class Operations implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "OID")
    private Integer oid;
    @Column(name = "ODATE")
    @Temporal(TemporalType.DATE)
    private Date odate;
    @Column(name = "OTIME")
    @Temporal(TemporalType.TIME)
    private Date otime;
    @Column(name = "NSLOT")
    private Integer nslot;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CHARGE")
    private Double charge;
    @JoinColumn(name = "CID", referencedColumnName = "CID")
    @ManyToOne
    private Clients cid;
    @JoinColumn(name = "EID", referencedColumnName = "EID")
    @ManyToOne
    private Employee eid;

    public Operations() {
    }

    public Operations(Integer oid) {
        this.oid = oid;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Date getOdate() {
        return odate;
    }

    public void setOdate(Date odate) {
        this.odate = odate;
    }

    public Date getOtime() {
        return otime;
    }

    public void setOtime(Date otime) {
        this.otime = otime;
    }

    public Integer getNslot() {
        return nslot;
    }

    public void setNslot(Integer nslot) {
        this.nslot = nslot;
    }

    public Double getCharge() {
        return charge;
    }

    public void setCharge(Double charge) {
        this.charge = charge;
    }

    public Clients getCid() {
        return cid;
    }

    public void setCid(Clients cid) {
        this.cid = cid;
    }

    public Employee getEid() {
        return eid;
    }

    public void setEid(Employee eid) {
        this.eid = eid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (oid != null ? oid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Operations)) {
            return false;
        }
        Operations other = (Operations) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Operations[ oid=" + oid + " ]";
    }
    
}
