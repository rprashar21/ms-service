package com.rohit.accounts.controller.scopeexample;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/scope")
@RequiredArgsConstructor
public class ScopeController {

    private final ShoppingCart shoppingCart;

    @PostMapping("/cart/add")
    public String addCart(@RequestParam String item) {

        shoppingCart.addItem(item);

        return "Item Added" + item;
    }

    @GetMapping("/cart")
    public List<String> getCart() {
        return shoppingCart.getItems();
    }

}
