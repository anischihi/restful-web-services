package com.mycompany.rest.webservices.restfulwebservices.todo;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mycompany.rest.webservices.restfulwebservices.oldtodo.TodoHardcodedService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class TodoJpaResource {

  @Autowired
  private TodoJpaRepository todoDao;
  private TodoHardcodedService todoService;

  @GetMapping(path = "/jpa/users/{username}/todos")
  public List<Todo> getAllTodos(@PathVariable String username) {
    return todoDao.findByUsername(username);
  }

  @GetMapping(path = "/jpa/users/{username}/todos/{id}")
  public Todo getTodo(@PathVariable String username, @PathVariable long id) {
    return todoDao.findById(id).orElse(null);
  }

  @DeleteMapping(path = "/jpa/users/{username}/todos/{id}")
  public ResponseEntity<Void> removeToDo(@PathVariable String username, @PathVariable long id) {
    todoDao.deleteById(id);
    return ResponseEntity.noContent().build();

  }

  @PutMapping(path = "/jpa/users/{username}/todos/{id}")
  public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable long id, @RequestBody Todo todo) {
    Todo updatedTodo = todoDao.save(todo);
    return new ResponseEntity<Todo>(todo, HttpStatus.OK);
  }

  @PostMapping(path = "/jpa/users/{username}/todos")
  public ResponseEntity<Todo> createTodo(@PathVariable String username, @RequestBody Todo todo) {
    Todo createdTodo = todoDao.save(todo);

    //return /users/{username}/todos/{id}
    URI uri =
        ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
    return ResponseEntity.created(uri).build();
  }

}
