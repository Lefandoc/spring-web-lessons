package com.geekbrains.spring.web.controllers;

import com.geekbrains.spring.web.dto.Cart;
import com.geekbrains.spring.web.services.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/carts")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @PostMapping
    public Cart getCurrentCart(@RequestBody String cartName) {
        return cartService.getCurrentCart(cartName);
    }

    @PostMapping("/add/{id}")
    public void addProductToCart(@PathVariable Long id, @RequestBody String cartName) {
        cartService.addProductById(id, cartName);
    }

    @PostMapping("/remove/{id}")
    public void deleteFromCart(@PathVariable Long id, @RequestBody String cartName) {
        cartService.removeProduct(id, cartName);
    }

    @PostMapping("/decrease/{id}")
    public void decreaseFromCart(@PathVariable Long id, @RequestBody String cartName) {
        cartService.decreaseProductQuantity(id, cartName);
    }

    @PostMapping("/clear")
    public void clearCart(@RequestBody String cartName) {
        cartService.getCurrentCart(cartName).clear();
    }

}
