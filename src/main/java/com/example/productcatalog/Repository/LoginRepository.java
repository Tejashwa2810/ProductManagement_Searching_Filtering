package com.example.productcatalog.Repository;

import com.example.productcatalog.models.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LoginRepository extends JpaRepository<Login, Integer> {


    @Query(value="select * from login l " +
           "where l.password = :password " +
           "and l.username = :username", nativeQuery = true)
    Login getLogin(@Param("username") String username, @Param("password") String password);
}
