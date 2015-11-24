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
@Table(name = "surveyresponse")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Surveyresponse.findAll", query = "SELECT s FROM Surveyresponse s"),
    @NamedQuery(name = "Surveyresponse.findByCodeSurveyReponse", query = "SELECT s FROM Surveyresponse s WHERE s.codeSurveyReponse = :codeSurveyReponse"),
    @NamedQuery(name = "Surveyresponse.findByTime", query = "SELECT s FROM Surveyresponse s WHERE s.time = :time")})
public class Surveyresponse implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "CodeSurveyReponse")
    private String codeSurveyReponse;
    @Column(name = "Time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;
    @Lob
    @Size(max = 65535)
    @Column(name = "Content")
    private String content;
    @JoinColumn(name = "CodeSurvey", referencedColumnName = "CodeSurvey")
    @ManyToOne(optional = false)
    private Survey codeSurvey;
    @JoinColumn(name = "Creator", referencedColumnName = "username")
    @ManyToOne(optional = false)
    private User creator;

    public Surveyresponse() {
    }

    public Surveyresponse(String codeSurveyReponse) {
        this.codeSurveyReponse = codeSurveyReponse;
    }

    public String getCodeSurveyReponse() {
        return codeSurveyReponse;
    }

    public void setCodeSurveyReponse(String codeSurveyReponse) {
        this.codeSurveyReponse = codeSurveyReponse;
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

    public Survey getCodeSurvey() {
        return codeSurvey;
    }

    public void setCodeSurvey(Survey codeSurvey) {
        this.codeSurvey = codeSurvey;
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
        hash += (codeSurveyReponse != null ? codeSurveyReponse.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Surveyresponse)) {
            return false;
        }
        Surveyresponse other = (Surveyresponse) object;
        if ((this.codeSurveyReponse == null && other.codeSurveyReponse != null) || (this.codeSurveyReponse != null && !this.codeSurveyReponse.equals(other.codeSurveyReponse))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Surveyresponse[ codeSurveyReponse=" + codeSurveyReponse + " ]";
    }
    
}
