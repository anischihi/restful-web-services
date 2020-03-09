package com.mycompany.rest.webservices.restfulwebservices.todo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class TodoHardcodedService {
    private static List<Todo> todos = new ArrayList();
    private static int id = 0;


    static {
        todos.add(new Todo(++id, "anischihi", "Learn Java Spring boot 2", new Date(), false));
        todos.add(new Todo(++id, "anischihi", "Learn to Dance", new Date(), false));
        todos.add(new Todo(++id, "anischihi", "Pay bills", new Date(), false));
    }

    public List<Todo> findAll(){
        return todos;
    }
    public boolean deleteById(long id){
        Todo todo = findById(id);
        return todos.remove(todo);
    }



    public Todo findById(long id) {
        return todos.stream().filter(todo -> todo.getId() == id ).findAny().orElse(null);
    }
}
