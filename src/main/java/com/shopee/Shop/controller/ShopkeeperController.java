package com.shopee.Shop.controller;

import com.shopee.Shop.entity.Shopkeeper;
import com.shopee.Shop.service.ShopkeeperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shopkeepers")
@CrossOrigin
public class ShopkeeperController {

    @Autowired
    private ShopkeeperService shopkeeperService;

    @GetMapping("/all")
    public List<Shopkeeper> getAllShopkeepers() {
        return shopkeeperService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Shopkeeper> getShopkeeperById(@PathVariable Long id) {
        return shopkeeperService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Shopkeeper createShopkeeper(@RequestBody Shopkeeper shopkeeper) {
        return shopkeeperService.save(shopkeeper);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Shopkeeper> updateShopkeeper(@PathVariable Long id, @RequestBody Shopkeeper shopkeeperDetails) {
        return shopkeeperService.findById(id)
                .map(shopkeeper -> {
                    shopkeeper.setName(shopkeeperDetails.getName());
                    shopkeeper.setEmail(shopkeeperDetails.getEmail());
                    return ResponseEntity.ok(shopkeeperService.save(shopkeeper));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteShopkeeper(@PathVariable Long id) {
        return shopkeeperService.findById(id)
                .map(shopkeeper -> {
                    shopkeeperService.deleteById(id);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}

