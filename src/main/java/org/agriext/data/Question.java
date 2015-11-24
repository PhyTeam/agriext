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
@Table(name = "question")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Question.findAll", query = "SELECT q FROM Question q"),
    @NamedQuery(name = "Question.findByCodeQuestion", query = "SELECT q FROM Question q WHERE q.codeQuestion = :codeQuestion"),
    @NamedQuery(name = "Question.findByTitle", query = "SELECT q FROM Question q WHERE q.title = :title"),
    @NamedQuery(name = "Question.findByTime", query = "SELECT q FROM Question q WHERE q.time = :time"),
    @NamedQuery(name = "Question.findByStatus", query = "SELECT q FROM Question q WHERE q.status = :status")})
public class Question implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "CodeQuestion")
    private String codeQuestion;
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
    @Column(name = "Status")
    private Boolean status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codeQuestion")
    private Collection<Answer> answerCollection;
    @JoinColumn(name = "Creator", referencedColumnName = "username")
    @ManyToOne(optional = false)
    private User creator;

    public Question() {
    }

    public Question(String codeQuestion) {
        this.codeQuestion = codeQuestion;
    }

    public String getCodeQuestion() {
        return codeQuestion;
    }

    public void setCodeQuestion(String codeQuestion) {
        this.codeQuestion = codeQuestion;
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<Answer> getAnswerCollection() {
        return answerCollection;
    }

    public void setAnswerCollection(Collection<Answer> answerCollection) {
        this.answerCollection = answerCollection;
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
        hash += (codeQuestion != null ? codeQuestion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Question)) {
            return false;
        }
        Question other = (Question) object;
        if ((this.codeQuestion == null && other.codeQuestion != null) || (this.codeQuestion != null && !this.codeQuestion.equals(other.codeQuestion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Question[ codeQuestion=" + codeQuestion + " ]";
    }
    
}
