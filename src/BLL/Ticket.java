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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Ticket")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ticket.findAll", query = "SELECT t FROM Ticket t"),
    @NamedQuery(name = "Ticket.findById", query = "SELECT t FROM Ticket t WHERE t.id = :id"),
    @NamedQuery(name = "Ticket.findByTicketName", query = "SELECT t FROM Ticket t WHERE t.ticketName = :ticketName")})
public class Ticket implements Serializable {
    @OneToMany(mappedBy = "ticketID")
    private Collection<BookedTicket> bookedTicketCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    
    @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq" , sequenceName = "INV_SEQ", allocationSize = 1)
    
    private Integer id;
    @Column(name = "TicketName")
    private String ticketName;
    @JoinColumn(name = "CinemaID", referencedColumnName = "ID")
    @ManyToOne
    private Cinema cinemaID;
    @JoinColumn(name = "MovieID", referencedColumnName = "ID")
    @ManyToOne
    private Movie movieID;

    public Ticket() {
    }

    public Ticket(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTicketName() {
        return ticketName;
    }

    public void setTicketName(String ticketName) {
        this.ticketName = ticketName;
    }

    public Cinema getCinemaID() {
        return cinemaID;
    }

    public void setCinemaID(Cinema cinemaID) {
        this.cinemaID = cinemaID;
    }

    public Movie getMovieID() {
        return movieID;
    }

    public void setMovieID(Movie movieID) {
        this.movieID = movieID;
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
        if (!(object instanceof Ticket)) {
            return false;
        }
        Ticket other = (Ticket) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BLL.Ticket[ id=" + id + " ]";
    }

    @XmlTransient
    public Collection<BookedTicket> getBookedTicketCollection() {
        return bookedTicketCollection;
    }

    public void setBookedTicketCollection(Collection<BookedTicket> bookedTicketCollection) {
        this.bookedTicketCollection = bookedTicketCollection;
    }
    
}
