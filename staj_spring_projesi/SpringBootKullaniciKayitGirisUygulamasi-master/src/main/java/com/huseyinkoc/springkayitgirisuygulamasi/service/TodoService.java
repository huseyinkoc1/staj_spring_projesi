package com.huseyinkoc.springkayitgirisuygulamasi.service;

import com.huseyinkoc.springkayitgirisuygulamasi.exception.RecordNotFoundException;
import com.huseyinkoc.springkayitgirisuygulamasi.model.Todo;
import com.huseyinkoc.springkayitgirisuygulamasi.repository.TodoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

/**
 * Created by huseyinkoc on 14.02.2019.
 */

@Service
public class TodoService {

    @Autowired
    TodoDao todoDao;

    public Todo getEmployeeById(Long id) throws RecordNotFoundException
    {
        Optional<Todo> employee = Optional.ofNullable(todoDao.findOne(id));

        if(employee.isPresent()) {
            return employee.get();
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }


    public Todo createOrUpdateEmployee(Todo entity)
    {

            Optional<Todo> employee = Optional.ofNullable(todoDao.findOne(entity.getId()));

            if(employee.isPresent())
            {
                Todo newEntity = employee.get();
                newEntity.setDescription(entity.getDescription());
                newEntity.setQuantity(entity.getQuantity());
                newEntity.setNote(entity.getNote());

                newEntity = todoDao.save(newEntity);

                return newEntity;
            } else {
                entity = todoDao.save(entity);

                return entity;
            }

    }


}
