package com.tw.apistack.repository;

import com.tw.apistack.endpoint.todo.dto.TodoDTO;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

/**
 * Created by jxzhong on 2017/7/3.
 */
@Repository
public class DummyTodoRepository {

    private Set<TodoDTO> todos = new HashSet<>();

    public DummyTodoRepository() {
        this.todos = new HashSet<>(asList(
                new TodoDTO(1, "test-A", false, 1),
                new TodoDTO(2, "test-B", false, 1)));
    }

    public List<TodoDTO> getAll() {
        return todos.stream().collect(Collectors.toList());
    }

    public Optional<TodoDTO> findById(long id) {
        return todos.stream().filter(todo -> todo.getId() == id).findFirst();
    }

    public void delete(TodoDTO todo) {
        todos.remove(todo);
    }

    public void add(TodoDTO todo) {
        todos.add(todo);
    }

}