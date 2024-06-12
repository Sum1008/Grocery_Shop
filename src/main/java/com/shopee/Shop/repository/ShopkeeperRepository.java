package com.shopee.Shop.repository;

import com.shopee.Shop.entity.Shopkeeper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopkeeperRepository extends JpaRepository<Shopkeeper, Long> {
}

