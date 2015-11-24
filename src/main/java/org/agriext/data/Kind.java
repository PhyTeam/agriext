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
@Table(name = "kind")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kind.findAll", query = "SELECT k FROM Kind k"),
    @NamedQuery(name = "Kind.findByCodeKind", query = "SELECT k FROM Kind k WHERE k.codeKind = :codeKind"),
    @NamedQuery(name = "Kind.findByNameKind", query = "SELECT k FROM Kind k WHERE k.nameKind = :nameKind")})
public class Kind implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "codeKind")
    private String codeKind;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nameKind")
    private String nameKind;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codeKind")
    private Collection<Plant> plantCollection;

    public Kind() {
    }

    public Kind(String codeKind) {
        this.codeKind = codeKind;
    }

    public Kind(String codeKind, String nameKind) {
        this.codeKind = codeKind;
        this.nameKind = nameKind;
    }

    public String getCodeKind() {
        return codeKind;
    }

    public void setCodeKind(String codeKind) {
        this.codeKind = codeKind;
    }

    public String getNameKind() {
        return nameKind;
    }

    public void setNameKind(String nameKind) {
        this.nameKind = nameKind;
    }

    @XmlTransient
    public Collection<Plant> getPlantCollection() {
        return plantCollection;
    }

    public void setPlantCollection(Collection<Plant> plantCollection) {
        this.plantCollection = plantCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeKind != null ? codeKind.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kind)) {
            return false;
        }
        Kind other = (Kind) object;
        if ((this.codeKind == null && other.codeKind != null) || (this.codeKind != null && !this.codeKind.equals(other.codeKind))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Kind[ codeKind=" + codeKind + " ]";
    }
    
}
