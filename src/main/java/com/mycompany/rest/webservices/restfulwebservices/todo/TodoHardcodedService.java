package com.mycompany.rest.webservices.restfulwebservices.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class TodoHardcodedService {
    private static List<Todo> todos = new ArrayList();
    private static long idCounter = -1;


    static {
        todos.add(new Todo(++idCounter, "anischihi", "Learn Java Spring boot 2", new Date(), false));
        todos.add(new Todo(++idCounter, "anischihi", "Learn to Dance", new Date(), false));
        todos.add(new Todo(++idCounter, "anischihi", "Pay bills", new Date(), false));
    }

    public List<Todo> findAll(){
        return todos;
    }
    public static boolean deleteById(long id){
        Todo todo = findById(id);
        return todos.remove(todo);
    }

    public Todo save (Todo todo){
        if(todo.getId() == -1){
            todo.setId(++idCounter);
            todos.add(todo);
        }
        else{
            deleteById(todo.getId());
            todos.add(todo);
        }
        return todo;
    }

    public static Todo findById(long id) {
        return todos.stream().filter(todo -> todo.getId() == id ).findAny().orElse(null);
    }
}
