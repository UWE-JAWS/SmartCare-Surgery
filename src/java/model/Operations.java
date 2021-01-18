/*
 * Copyright © 2020 Simeon Dobchev, William Garthside,
 * Joshua Saxby, Alexander Stratford & Dylan Waters.
 * All rights reserved.
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author joshua
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Operations.findAll", query = "SELECT o FROM Operations o")
    , @NamedQuery(name = "Operations.findById", query = "SELECT o FROM Operations o WHERE o.id = :id")
    , @NamedQuery(name = "Operations.findByStartDate", query = "SELECT o FROM Operations o WHERE o.startDate = :startDate")
    , @NamedQuery(name = "Operations.findByStartTime", query = "SELECT o FROM Operations o WHERE o.startTime = :startTime")
    , @NamedQuery(name = "Operations.findBySlot", query = "SELECT o FROM Operations o WHERE o.slot = :slot")
    , @NamedQuery(name = "Operations.findByCharge", query = "SELECT o FROM Operations o WHERE o.charge = :charge")})
public class Operations implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Column(name = "START_DATE")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "START_TIME")
    @Temporal(TemporalType.TIME)
    private Date startTime;
    private Short slot;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 8, scale = 2)
    private BigDecimal charge;
    @JoinColumn(name = "CLIENT_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Clients clientId;
    @JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Employees employeeId;

    public Operations() {
    }

    public Operations(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Short getSlot() {
        return slot;
    }

    public void setSlot(Short slot) {
        this.slot = slot;
    }

    public BigDecimal getCharge() {
        return charge;
    }

    public void setCharge(BigDecimal charge) {
        this.charge = charge;
    }

    public Clients getClientId() {
        return clientId;
    }

    public void setClientId(Clients clientId) {
        this.clientId = clientId;
    }

    public Employees getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employees employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Operations)) {
            return false;
        }
        Operations other = (Operations) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Operations[ id=" + id + " ]";
    }
    
}
