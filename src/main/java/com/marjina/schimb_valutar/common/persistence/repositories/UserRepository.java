package com.marjina.schimb_valutar.common.persistence.repositories;

import com.marjina.schimb_valutar.common.persistence.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
