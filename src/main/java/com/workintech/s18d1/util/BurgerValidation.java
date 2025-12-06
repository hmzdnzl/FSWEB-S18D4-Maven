package com.workintech.s18d1.util;

import org.apache.http.HttpStatus;

import com.workintech.s18d1.entity.Burger;
import com.workintech.s18d1.exceptions.BurgerException;


public class BurgerValidation {
    public static void checkName(String name) {
        if (name == null || name.isEmpty()) {
            throw new BurgerException("Burger name cannot be null or empty", org.springframework.http.HttpStatus.BAD_REQUEST);
        }
    }
}
