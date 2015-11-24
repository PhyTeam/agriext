/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.agriext.data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Phuc
 */
@Entity
@Table(name = "advertise")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Advertise.findAll", query = "SELECT a FROM Advertise a"),
    @NamedQuery(name = "Advertise.findByCodeAd", query = "SELECT a FROM Advertise a WHERE a.codeAd = :codeAd"),
    @NamedQuery(name = "Advertise.findByTitle", query = "SELECT a FROM Advertise a WHERE a.title = :title"),
    @NamedQuery(name = "Advertise.findByTime", query = "SELECT a FROM Advertise a WHERE a.time = :time")})
public class Advertise implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "CodeAd")
    private String codeAd;
    @Size(max = 45)
    @Column(name = "Title")
    private String title;
    @Column(name = "Time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;
    @Lob
    @Size(max = 65535)
    @Column(name = "Content")
    private String content;
    @JoinColumn(name = "Creator", referencedColumnName = "username")
    @ManyToOne(optional = false)
    private User creator;

    public Advertise() {
    }

    public Advertise(String codeAd) {
        this.codeAd = codeAd;
    }

    public String getCodeAd() {
        return codeAd;
    }

    public void setCodeAd(String codeAd) {
        this.codeAd = codeAd;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeAd != null ? codeAd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Advertise)) {
            return false;
        }
        Advertise other = (Advertise) object;
        if ((this.codeAd == null && other.codeAd != null) || (this.codeAd != null && !this.codeAd.equals(other.codeAd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Advertise[ codeAd=" + codeAd + " ]";
    }
    
}
