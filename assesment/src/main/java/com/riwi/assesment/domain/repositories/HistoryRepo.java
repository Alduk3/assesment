package com.riwi.assesment.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.assesment.domain.entities.History;

@Repository
public interface HistoryRepo extends JpaRepository<History, String>{
  
}
