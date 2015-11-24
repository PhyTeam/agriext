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
@Table(name = "answer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Answer.findAll", query = "SELECT a FROM Answer a"),
    @NamedQuery(name = "Answer.findByCodeAnswer", query = "SELECT a FROM Answer a WHERE a.codeAnswer = :codeAnswer"),
    @NamedQuery(name = "Answer.findByTime", query = "SELECT a FROM Answer a WHERE a.time = :time")})
public class Answer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "CodeAnswer")
    private String codeAnswer;
    @Column(name = "Time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;
    @Lob
    @Size(max = 65535)
    @Column(name = "Content")
    private String content;
    @JoinColumn(name = "CodeQuestion", referencedColumnName = "CodeQuestion")
    @ManyToOne(optional = false)
    private Question codeQuestion;
    @JoinColumn(name = "Creator", referencedColumnName = "username")
    @ManyToOne(optional = false)
    private User creator;

    public Answer() {
    }

    public Answer(String codeAnswer) {
        this.codeAnswer = codeAnswer;
    }

    public String getCodeAnswer() {
        return codeAnswer;
    }

    public void setCodeAnswer(String codeAnswer) {
        this.codeAnswer = codeAnswer;
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

    public Question getCodeQuestion() {
        return codeQuestion;
    }

    public void setCodeQuestion(Question codeQuestion) {
        this.codeQuestion = codeQuestion;
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
        hash += (codeAnswer != null ? codeAnswer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Answer)) {
            return false;
        }
        Answer other = (Answer) object;
        if ((this.codeAnswer == null && other.codeAnswer != null) || (this.codeAnswer != null && !this.codeAnswer.equals(other.codeAnswer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Answer[ codeAnswer=" + codeAnswer + " ]";
    }
    
}
