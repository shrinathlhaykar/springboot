package com.olsproject.onlinelotterysystem.repository;

import com.olsproject.onlinelotterysystem.entity.User;
import com.olsproject.onlinelotterysystem.entity.Winner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WinnerRepository extends JpaRepository<Winner ,Long> {

    @Override
    boolean existsById(Long aLong);

    Optional<Winner> findByMobileNo(String mobileNo);
}
