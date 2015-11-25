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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Phuc
 */
@NamedStoredProcedureQuery(name = "rand_plant", procedureName = "rand_plant",
        parameters = {@StoredProcedureParameter(mode = ParameterMode.IN, name = "lm", type = Integer.class)},
        resultClasses = Plant.class)

@Entity
@Table(name = "plant")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Plant.findAll", query = "SELECT p FROM Plant p"),
    @NamedQuery(name = "Plant.findByCodePlant", query = "SELECT p FROM Plant p WHERE p.codePlant = :codePlant"),
    @NamedQuery(name = "Plant.findByCmname", query = "SELECT p FROM Plant p WHERE p.cmname = :cmname"),
    @NamedQuery(name = "Plant.findByScname", query = "SELECT p FROM Plant p WHERE p.scname = :scname"),
    @NamedQuery(name = "Plant.findByAvatar", query = "SELECT p FROM Plant p WHERE p.avatar = :avatar")})
public class Plant implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "CodePlant")
    private String codePlant;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "cmname")
    private String cmname;
    @Size(max = 45)
    @Column(name = "scname")
    private String scname;
    @Size(max = 45)
    @Column(name = "avatar")
    private String avatar;
    @Lob
    @Size(max = 65535)
    @Column(name = "desc")
    private String desc;
    @JoinColumn(name = "CodeKind", referencedColumnName = "codeKind")
    @ManyToOne(optional = false)
    private Kind codeKind;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "plant")
    private Collection<Detail> detailCollection;

    public Plant() {
    }

    public Plant(String codePlant) {
        this.codePlant = codePlant;
    }

    public Plant(String codePlant, String cmname) {
        this.codePlant = codePlant;
        this.cmname = cmname;
    }

    public String getCodePlant() {
        return codePlant;
    }

    public void setCodePlant(String codePlant) {
        this.codePlant = codePlant;
    }

    public String getCmname() {
        return cmname;
    }

    public void setCmname(String cmname) {
        this.cmname = cmname;
    }

    public String getScname() {
        return scname;
    }

    public void setScname(String scname) {
        this.scname = scname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Kind getCodeKind() {
        return codeKind;
    }

    public void setCodeKind(Kind codeKind) {
        this.codeKind = codeKind;
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
        hash += (codePlant != null ? codePlant.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plant)) {
            return false;
        }
        Plant other = (Plant) object;
        if ((this.codePlant == null && other.codePlant != null) || (this.codePlant != null && !this.codePlant.equals(other.codePlant))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Plant[ codePlant=" + codePlant + " ]";
    }
    
}
