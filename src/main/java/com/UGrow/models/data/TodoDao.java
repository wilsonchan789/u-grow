package com.UGrow.models.data;

import com.UGrow.models.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoDao extends CrudRepository<Todo, Integer> {
}
