/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Spectre
 */
@Entity
@Table(name = "ComingSoon")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComingSoon.findAll", query = "SELECT c FROM ComingSoon c"),
    @NamedQuery(name = "ComingSoon.findById", query = "SELECT c FROM ComingSoon c WHERE c.id = :id"),
    @NamedQuery(name = "ComingSoon.findByCSMovieName", query = "SELECT c FROM ComingSoon c WHERE c.cSMovieName = :cSMovieName"),
    @NamedQuery(name = "ComingSoon.findByDate", query = "SELECT c FROM ComingSoon c WHERE c.date = :date")})
public class ComingSoon implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    
    @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq" , sequenceName = "INV_SEQ", allocationSize = 1)
    
    private Integer id;
    @Column(name = "CSMovieName")
    private String cSMovieName;
    @Basic(optional = false)
    @Column(name = "Date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @JoinColumn(name = "CinemaID", referencedColumnName = "ID")
    @ManyToOne
    private Cinema cinemaID;

    public ComingSoon() {
    }

    public ComingSoon(Integer id) {
        this.id = id;
    }

    public ComingSoon(Integer id, Date date) {
        this.id = id;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCSMovieName() {
        return cSMovieName;
    }

    public void setCSMovieName(String cSMovieName) {
        this.cSMovieName = cSMovieName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Cinema getCinemaID() {
        return cinemaID;
    }

    public void setCinemaID(Cinema cinemaID) {
        this.cinemaID = cinemaID;
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
        if (!(object instanceof ComingSoon)) {
            return false;
        }
        ComingSoon other = (ComingSoon) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BLL.ComingSoon[ id=" + id + " ]";
    }
    
}
