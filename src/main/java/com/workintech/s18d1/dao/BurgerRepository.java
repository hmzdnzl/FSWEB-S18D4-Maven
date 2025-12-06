package com.workintech.s18d1.dao;

import com.workintech.s18d1.entity.Burger;
import com.workintech.s18d1.entity.BreadType;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BurgerRepository extends JpaRepository<Burger, Long> {
    List<Burger> findByPriceGreaterThanOrderByPriceDesc(double price);
    List<Burger> findByBreadTypeOrderByNameAsc(BreadType breadType);
    List<Burger> findByContentsContaining(String content);
}