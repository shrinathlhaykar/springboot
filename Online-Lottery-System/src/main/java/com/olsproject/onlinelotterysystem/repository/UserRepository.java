package com.olsproject.onlinelotterysystem.repository;

import com.olsproject.onlinelotterysystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User , Integer> {

    @Query(value = "select count(*) from user where participate=true",nativeQuery = true)
    public int findCountOfParticipants();
}
