package com.oguzhan.demoticket.repository;

import com.oguzhan.demoticket.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends JpaRepository<Route,Long> {
}
