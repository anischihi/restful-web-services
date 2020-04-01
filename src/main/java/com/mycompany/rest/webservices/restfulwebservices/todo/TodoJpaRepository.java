package com.mycompany.rest.webservices.restfulwebservices.todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//can be called TodoDao
@Repository
public interface TodoJpaRepository extends JpaRepository<Todo, Long> {

  List<Todo> findByUsername(String username);
  // This does not even need to be implemented, jpa transforms this to a query based on name
  // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.details

}
