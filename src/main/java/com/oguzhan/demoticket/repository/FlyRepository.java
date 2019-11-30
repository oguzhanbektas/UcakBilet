package com.oguzhan.demoticket.repository;

import com.oguzhan.demoticket.model.Fly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlyRepository extends JpaRepository<Fly,Long> {
}
