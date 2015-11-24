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
@Table(name = "post")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Post.findAll", query = "SELECT p FROM Post p"),
    @NamedQuery(name = "Post.findByCodePost", query = "SELECT p FROM Post p WHERE p.codePost = :codePost"),
    @NamedQuery(name = "Post.findByTitle", query = "SELECT p FROM Post p WHERE p.title = :title"),
    @NamedQuery(name = "Post.findByTime", query = "SELECT p FROM Post p WHERE p.time = :time"),
    @NamedQuery(name = "Post.findByCensorship", query = "SELECT p FROM Post p WHERE p.censorship = :censorship")})
public class Post implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "CodePost")
    private String codePost;
    @Size(max = 45)
    @Column(name = "Title")
    private String title;
    @Column(name = "Time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;
    @Column(name = "Censorship")
    private Boolean censorship;
    @Lob
    @Size(max = 65535)
    @Column(name = "Content")
    private String content;
    @JoinColumn(name = "Creator", referencedColumnName = "username")
    @ManyToOne
    private User creator;

    public Post() {
    }

    public Post(String codePost) {
        this.codePost = codePost;
    }

    public String getCodePost() {
        return codePost;
    }

    public void setCodePost(String codePost) {
        this.codePost = codePost;
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

    public Boolean getCensorship() {
        return censorship;
    }

    public void setCensorship(Boolean censorship) {
        this.censorship = censorship;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codePost != null ? codePost.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Post)) {
            return false;
        }
        Post other = (Post) object;
        if ((this.codePost == null && other.codePost != null) || (this.codePost != null && !this.codePost.equals(other.codePost))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Post[ codePost=" + codePost + " ]";
    }
    
}
