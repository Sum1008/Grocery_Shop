package com.shopee.Shop.service;

import com.shopee.Shop.entity.Shopkeeper;
import com.shopee.Shop.repository.ShopkeeperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShopkeeperService {

    @Autowired
    private ShopkeeperRepository shopkeeperRepository;

    public List<Shopkeeper> findAll() {
        return shopkeeperRepository.findAll();
    }

    public Optional<Shopkeeper> findById(Long id) {
        return shopkeeperRepository.findById(id);
    }

    public Shopkeeper save(Shopkeeper shopkeeper) {
        return shopkeeperRepository.save(shopkeeper);
    }

    public void deleteById(Long id) {
        shopkeeperRepository.deleteById(id);
    }
}

