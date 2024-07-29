package com.riwi.assesment.domain.repositories;

import com.riwi.assesment.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {

}
