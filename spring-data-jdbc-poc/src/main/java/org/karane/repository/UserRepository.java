package org.karane.repository;

import org.karane.entity.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query("SELECT * FROM users ORDER BY name LIMIT :limit OFFSET :offset")
    List<User> findAllPaged(@Param("limit") int limit, @Param("offset") int offset);
}
