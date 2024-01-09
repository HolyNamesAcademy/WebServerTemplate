package com.hna.webserver.repository;

import com.hna.webserver.model.Charby;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CharbyRepository extends JpaRepository<Charby, Long> {
    
}
