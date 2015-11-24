/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.agriext.data;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Phuc
 */
@Entity
@Table(name = "area")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Area.findAll", query = "SELECT a FROM Area a"),
    @NamedQuery(name = "Area.findByCodeArea", query = "SELECT a FROM Area a WHERE a.codeArea = :codeArea"),
    @NamedQuery(name = "Area.findByNameArea", query = "SELECT a FROM Area a WHERE a.nameArea = :nameArea")})
public class Area implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "CodeArea")
    private String codeArea;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "NameArea")
    private String nameArea;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "area")
    private Collection<Detail> detailCollection;

    public Area() {
    }

    public Area(String codeArea) {
        this.codeArea = codeArea;
    }

    public Area(String codeArea, String nameArea) {
        this.codeArea = codeArea;
        this.nameArea = nameArea;
    }

    public String getCodeArea() {
        return codeArea;
    }

    public void setCodeArea(String codeArea) {
        this.codeArea = codeArea;
    }

    public String getNameArea() {
        return nameArea;
    }

    public void setNameArea(String nameArea) {
        this.nameArea = nameArea;
    }

    @XmlTransient
    public Collection<Detail> getDetailCollection() {
        return detailCollection;
    }

    public void setDetailCollection(Collection<Detail> detailCollection) {
        this.detailCollection = detailCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeArea != null ? codeArea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Area)) {
            return false;
        }
        Area other = (Area) object;
        if ((this.codeArea == null && other.codeArea != null) || (this.codeArea != null && !this.codeArea.equals(other.codeArea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Area[ codeArea=" + codeArea + " ]";
    }
    
}
