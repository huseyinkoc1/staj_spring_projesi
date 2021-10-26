package com.huseyinkoc.springkayitgirisuygulamasi.repository;

import com.huseyinkoc.springkayitgirisuygulamasi.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by huseyinkoc on 14.02.2019.
 */


public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);

    User findById(String id);

    User findByEmail(String email);
}
