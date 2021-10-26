package com.huseyinkoc.springkayitgirisuygulamasi.repository;

import com.huseyinkoc.springkayitgirisuygulamasi.model.Todo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by huseyinkoc on 14.02.2019.
 */


@Repository
public interface TodoDao extends CrudRepository<Todo,Long> {



}
