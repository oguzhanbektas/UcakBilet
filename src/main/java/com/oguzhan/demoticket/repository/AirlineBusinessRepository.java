package com.oguzhan.demoticket.repository;

import com.oguzhan.demoticket.model.AirlineBusiness;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineBusinessRepository extends JpaRepository<AirlineBusiness,Long> {
}
