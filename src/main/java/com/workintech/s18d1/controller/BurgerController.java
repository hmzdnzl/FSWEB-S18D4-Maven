package com.workintech.s18d1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.workintech.s18d1.dao.BurgerDao;
import com.workintech.s18d1.dao.BurgerDaoImpl;
import com.workintech.s18d1.entity.BreadType;
import com.workintech.s18d1.entity.Burger;
import com.workintech.s18d1.util.BurgerValidation;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/burger")
public class BurgerController {

    @Autowired
private BurgerDao burgerDao;

@GetMapping
public List<Burger> findAll() {
  return burgerDao.findAll();
}

@GetMapping("/{id}")
public Burger find(@PathVariable long id) {
    return burgerDao.findById(id);
}

@PostMapping
public Burger save(@RequestBody Burger burger) {
BurgerValidation.checkName(burger.getName());
return burgerDao.save(burger);
}
    

@PutMapping
public Burger update(@RequestBody Burger burger) {
    BurgerValidation.checkName(burger.getName());
    return burgerDao.update(burger);

}

@DeleteMapping("/{id}")
public Burger remove(@PathVariable long id) {
    return burgerDao.remove(id);
}

@GetMapping("/price/{price}")
public List<Burger> getByPrice(@PathVariable Integer price) {
    return burgerDao.findByPrice(price);
}

@GetMapping("/breadType/{breadType}")
public List<Burger> getByBreadType(@PathVariable BreadType breadType) {
    return burgerDao.findByBreadType(breadType);
}

@GetMapping("/content/{content}")
public List<Burger> getByContent(@PathVariable String content) {
    return burgerDao.findByContent(content);
}
}
