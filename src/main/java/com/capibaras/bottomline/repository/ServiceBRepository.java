package com.capibaras.bottomline.repository;

import com.capibaras.bottomline.models.ServiceB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceBRepository extends JpaRepository<ServiceB,Long> {
}
