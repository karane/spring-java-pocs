package org.karane.repository;

import org.karane.entity.Role;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

    @Query("SELECT * FROM roles WHERE name = :name")
    Role findByName(@Param("name") String name);
}
