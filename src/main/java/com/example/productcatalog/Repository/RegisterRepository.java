package com.example.productcatalog.Repository;

import com.example.productcatalog.models.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterRepository extends JpaRepository<Login, Long> {
    Boolean existsByUsername(String username);
}

