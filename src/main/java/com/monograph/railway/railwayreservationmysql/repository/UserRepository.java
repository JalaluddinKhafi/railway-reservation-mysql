package com.monograph.railway.railwayreservationmysql.repository;

import com.monograph.railway.railwayreservationmysql.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
