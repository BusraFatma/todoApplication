package com.kyaa.todoapi.data.repositories;

import com.kyaa.todoapi.data.models.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TodoRepository extends MongoRepository<Todo, String> {
}
