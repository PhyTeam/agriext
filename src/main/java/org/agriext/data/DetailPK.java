/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.agriext.data;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Phuc
 */
@Embeddable
public class DetailPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "CodePlant")
    private String codePlant;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "CodeArea")
    private String codeArea;

    public DetailPK() {
    }

    public DetailPK(String codePlant, String codeArea) {
        this.codePlant = codePlant;
        this.codeArea = codeArea;
    }

    public String getCodePlant() {
        return codePlant;
    }

    public void setCodePlant(String codePlant) {
        this.codePlant = codePlant;
    }

    public String getCodeArea() {
        return codeArea;
    }

    public void setCodeArea(String codeArea) {
        this.codeArea = codeArea;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codePlant != null ? codePlant.hashCode() : 0);
        hash += (codeArea != null ? codeArea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetailPK)) {
            return false;
        }
        DetailPK other = (DetailPK) object;
        if ((this.codePlant == null && other.codePlant != null) || (this.codePlant != null && !this.codePlant.equals(other.codePlant))) {
            return false;
        }
        if ((this.codeArea == null && other.codeArea != null) || (this.codeArea != null && !this.codeArea.equals(other.codeArea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.DetailPK[ codePlant=" + codePlant + ", codeArea=" + codeArea + " ]";
    }
    
}
