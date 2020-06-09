/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Spectre
 */
@Entity
@Table(name = "Cinema")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cinema.findAll", query = "SELECT c FROM Cinema c"),
    @NamedQuery(name = "Cinema.findById", query = "SELECT c FROM Cinema c WHERE c.id = :id"),
    @NamedQuery(name = "Cinema.findByName", query = "SELECT c FROM Cinema c WHERE c.name = :name"),
    @NamedQuery(name = "Cinema.findByCity", query = "SELECT c FROM Cinema c WHERE c.city = :city")})
public class Cinema implements Serializable {
    @OneToMany(mappedBy = "cinemaID")
    private Collection<ComingSoon> comingSoonCollection;
    @OneToMany(mappedBy = "cinemaID")
    private Collection<Ticket> ticketCollection;
    @OneToMany(mappedBy = "cinemaID")
    private Collection<Movie> movieCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    
    @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq" , sequenceName = "INV_SEQ", allocationSize = 1)
    
    private Integer id;
    @Column(name = "Name")
    private String name;
    @Column(name = "City")
    private String city;

    public Cinema() {
    }

    public Cinema(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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
        if (!(object instanceof Cinema)) {
            return false;
        }
        Cinema other = (Cinema) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name+" - "+city;
    }

    @XmlTransient
    public Collection<Movie> getMovieCollection() {
        return movieCollection;
    }

    public void setMovieCollection(Collection<Movie> movieCollection) {
        this.movieCollection = movieCollection;
    }

    @XmlTransient
    public Collection<Ticket> getTicketCollection() {
        return ticketCollection;
    }

    public void setTicketCollection(Collection<Ticket> ticketCollection) {
        this.ticketCollection = ticketCollection;
    }

    @XmlTransient
    public Collection<ComingSoon> getComingSoonCollection() {
        return comingSoonCollection;
    }

    public void setComingSoonCollection(Collection<ComingSoon> comingSoonCollection) {
        this.comingSoonCollection = comingSoonCollection;
    }
    
}
