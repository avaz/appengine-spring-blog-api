package com.avaz.demos.model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Anderson
 */
@Entity
public class Post {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  private String title;
  
  private String body;
  @OneToMany(cascade = CascadeType.ALL)
  private List<Comment> comments;

  public Post() {
    this.comments = new ArrayList<>();
  }

  public Long getId() {
    return id;
  }

  public void setId( Long id ) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle( String title ) {
    this.title = title;
  }

  public String getBody() {
    return body;
  }

  public void setBody( String body ) {
    this.body = body;
  }

  public List<Comment> getComments() {
    return comments;
  }

  public void setComments( List<Comment> comments ) {
    this.comments = comments;
  }
}
