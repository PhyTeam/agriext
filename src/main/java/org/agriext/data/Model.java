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
import javax.persistence.Lob;
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
@Table(name = "model")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Model.findAll", query = "SELECT m FROM Model m"),
    @NamedQuery(name = "Model.findByCodeModel", query = "SELECT m FROM Model m WHERE m.codeModel = :codeModel"),
    @NamedQuery(name = "Model.findByName", query = "SELECT m FROM Model m WHERE m.name = :name")})
public class Model implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "CodeModel")
    private String codeModel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Name")
    private String name;
    @Lob
    @Size(max = 65535)
    @Column(name = "Content")
    private String content;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codeModel")
    private Collection<Detail> detailCollection;

    public Model() {
    }

    public Model(String codeModel) {
        this.codeModel = codeModel;
    }

    public Model(String codeModel, String name) {
        this.codeModel = codeModel;
        this.name = name;
    }

    public String getCodeModel() {
        return codeModel;
    }

    public void setCodeModel(String codeModel) {
        this.codeModel = codeModel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
        hash += (codeModel != null ? codeModel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Model)) {
            return false;
        }
        Model other = (Model) object;
        if ((this.codeModel == null && other.codeModel != null) || (this.codeModel != null && !this.codeModel.equals(other.codeModel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Model[ codeModel=" + codeModel + " ]";
    }
    
}
