package com.kyaa.todoapi.services;

import com.kyaa.todoapi.data.models.Todo;
import com.kyaa.todoapi.data.repositories.TodoRepository;
import com.kyaa.todoapi.exceptions.TodoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService{
    @Autowired
    private TodoRepository todoRepository;
    @Override
    public Todo createTodo(Todo todo) {
        todo.setCompleted("false");
        return todoRepository.save(todo);
    }

    @Override
    public Optional<Todo> findById(String id) {
        return todoRepository.findById(id);
    }

    @Override
    public Todo updateTodo(String id, Todo updatedTodo) {
//        return findById(id).map(oldTodo->todoRepository.save(updatedTodo));
        Todo foundTodo = findById(id).orElseThrow(()->new TodoException("Todo not found"));
        foundTodo.setTitle(updatedTodo.getTitle());
        foundTodo.setCompleted(updatedTodo.getCompleted());
        return todoRepository.save(foundTodo);
    }

    @Override
    public void deleteTodo(String id) {
        todoRepository.deleteById(id);
    }

    @Override
    public List<Todo> getAllTodo() {
        return todoRepository.findAll();
    }

}
