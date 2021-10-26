package com.huseyinkoc.springkayitgirisuygulamasi.repository;

import com.huseyinkoc.springkayitgirisuygulamasi.model.Role;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by huseyinkoc on 14.02.2019.
 */


public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByRole(String role);
}
