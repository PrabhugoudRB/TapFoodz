package com.tap.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    
    private Map<Integer, CartItems> cart;

    public Cart() {
        this.cart = new HashMap<>();
    }

    public void addItems(CartItems newItem) {
        int itemId = newItem.getItemId();

        if (cart.containsKey(itemId)) 
        {
            CartItems existingItem = cart.get(itemId);
            existingItem.setQuantity(existingItem.getQuantity() + newItem.getQuantity());
        } 
        else {
            cart.put(itemId, newItem);
        }
    }	 

    public void updateItems(int itemId, int quantity) {
        if (cart.containsKey(itemId)) {
            CartItems existingItem = cart.get(itemId);
            existingItem.setQuantity(quantity);
        }
    }

    public void removeItem(int itemId) {
        cart.remove(itemId);
    }

    public Map<Integer, CartItems> getItems() {
        return cart;
    }

    public void clear() {
        cart.clear();
    }
    
}
