package com.tdd.demo.repository;

import com.tdd.demo.entity.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface MerchantRepository extends JpaRepository<Merchant, Long> {


    Merchant findByEmail(@Param("email") String email);
}
