/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.agriext.data;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Phuc
 */
@Entity
@Table(name = "survey")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Survey.findAll", query = "SELECT s FROM Survey s"),
    @NamedQuery(name = "Survey.findByCodeSurvey", query = "SELECT s FROM Survey s WHERE s.codeSurvey = :codeSurvey"),
    @NamedQuery(name = "Survey.findByTimeCreate", query = "SELECT s FROM Survey s WHERE s.timeCreate = :timeCreate"),
    @NamedQuery(name = "Survey.findByTimeFinish", query = "SELECT s FROM Survey s WHERE s.timeFinish = :timeFinish")})
public class Survey implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "CodeSurvey")
    private String codeSurvey;
    @Column(name = "TimeCreate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeCreate;
    @Column(name = "TimeFinish")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeFinish;
    @Lob
    @Size(max = 65535)
    @Column(name = "Content")
    private String content;
    @JoinColumn(name = "Creator", referencedColumnName = "username")
    @ManyToOne(optional = false)
    private User creator;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codeSurvey")
    private Collection<Surveyresponse> surveyresponseCollection;

    public Survey() {
    }

    public Survey(String codeSurvey) {
        this.codeSurvey = codeSurvey;
    }

    public String getCodeSurvey() {
        return codeSurvey;
    }

    public void setCodeSurvey(String codeSurvey) {
        this.codeSurvey = codeSurvey;
    }

    public Date getTimeCreate() {
        return timeCreate;
    }

    public void setTimeCreate(Date timeCreate) {
        this.timeCreate = timeCreate;
    }

    public Date getTimeFinish() {
        return timeFinish;
    }

    public void setTimeFinish(Date timeFinish) {
        this.timeFinish = timeFinish;
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

    @XmlTransient
    public Collection<Surveyresponse> getSurveyresponseCollection() {
        return surveyresponseCollection;
    }

    public void setSurveyresponseCollection(Collection<Surveyresponse> surveyresponseCollection) {
        this.surveyresponseCollection = surveyresponseCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeSurvey != null ? codeSurvey.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Survey)) {
            return false;
        }
        Survey other = (Survey) object;
        if ((this.codeSurvey == null && other.codeSurvey != null) || (this.codeSurvey != null && !this.codeSurvey.equals(other.codeSurvey))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Survey[ codeSurvey=" + codeSurvey + " ]";
    }
    
}
