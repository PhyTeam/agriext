/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.agriext.data;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Phuc
 */
@Entity
@Table(name = "detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detail.findAll", query = "SELECT d FROM Detail d"),
    @NamedQuery(name = "Detail.findByCodePlant", query = "SELECT d FROM Detail d WHERE d.detailPK.codePlant = :codePlant"),
    @NamedQuery(name = "Detail.findByCodeArea", query = "SELECT d FROM Detail d WHERE d.detailPK.codeArea = :codeArea"),
    @NamedQuery(name = "Detail.findByContent", query = "SELECT d FROM Detail d WHERE d.content = :content")})
public class Detail implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetailPK detailPK;
    @Size(max = 10000)
    @Column(name = "Content")
    private String content;
    @JoinColumn(name = "CodeArea", referencedColumnName = "CodeArea", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Area area;
    @JoinColumn(name = "CodeModel", referencedColumnName = "CodeModel")
    @ManyToOne(optional = false)
    private Model codeModel;
    @JoinColumn(name = "CodePlant", referencedColumnName = "CodePlant", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Plant plant;

    public Detail() {
    }

    public Detail(DetailPK detailPK) {
        this.detailPK = detailPK;
    }

    public Detail(String codePlant, String codeArea) {
        this.detailPK = new DetailPK(codePlant, codeArea);
    }

    public DetailPK getDetailPK() {
        return detailPK;
    }

    public void setDetailPK(DetailPK detailPK) {
        this.detailPK = detailPK;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Model getCodeModel() {
        return codeModel;
    }

    public void setCodeModel(Model codeModel) {
        this.codeModel = codeModel;
    }

    public Plant getPlant() {
        return plant;
    }

    public void setPlant(Plant plant) {
        this.plant = plant;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detailPK != null ? detailPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detail)) {
            return false;
        }
        Detail other = (Detail) object;
        if ((this.detailPK == null && other.detailPK != null) || (this.detailPK != null && !this.detailPK.equals(other.detailPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Detail[ detailPK=" + detailPK + " ]";
    }
    
}
