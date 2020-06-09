/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "BookedTicket")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BookedTicket.findAll", query = "SELECT b FROM BookedTicket b"),
    @NamedQuery(name = "BookedTicket.findById", query = "SELECT b FROM BookedTicket b WHERE b.id = :id"),
    @NamedQuery(name = "BookedTicket.findByBookedName", query = "SELECT b FROM BookedTicket b WHERE b.bookedName = :bookedName")})
public class BookedTicket implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "BookedName")
    private String bookedName;
    @JoinColumn(name = "TicketID", referencedColumnName = "ID")
    @ManyToOne
    private Ticket ticketID;

    public BookedTicket() {
    }

    public BookedTicket(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookedName() {
        return bookedName;
    }

    public void setBookedName(String bookedName) {
        this.bookedName = bookedName;
    }

    public Ticket getTicketID() {
        return ticketID;
    }

    public void setTicketID(Ticket ticketID) {
        this.ticketID = ticketID;
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
        if (!(object instanceof BookedTicket)) {
            return false;
        }
        BookedTicket other = (BookedTicket) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BLL.BookedTicket[ id=" + id + " ]";
    }
    
}
