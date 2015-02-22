package com.avaz.demos.controller;

import com.avaz.demos.model.Comment;
import com.avaz.demos.model.Post;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Transactional
public class BlogController {
  
  @PersistenceContext
  private EntityManager em;

  @RequestMapping( value = "/", method = RequestMethod.GET )
  public List<Post> index() {
    return em.createQuery( "select p from Post p").getResultList();
  }

  @RequestMapping( value = "/init", method = RequestMethod.GET )
  public String init() {
    Post post = new Post();
    post.setTitle( "Hello");
    post.setBody( "GDG");
    Comment comment = new Comment();
    post.getComments().add( comment );
    em.persist( post );
    return "<h1>Hello GDG|ABC</h1>";
  }

  @ExceptionHandler(Exception.class)
  public String handleError(HttpServletRequest req, Exception exception) {
    exception.printStackTrace();
    return exception.getMessage();
  }
  
}
