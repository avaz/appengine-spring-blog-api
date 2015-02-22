package com.avaz.demos.model;


import com.google.appengine.api.datastore.Key;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Anderson
 */
@Entity
public class Comment {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Key id;
  
  private String body;

  public Key getId() {
    return id;
  }

  public void setId( Key id ) {
    this.id = id;
  }

  public String getBody() {
    return body;
  }

  public void setBody( String body ) {
    this.body = body;
  }
  
}
