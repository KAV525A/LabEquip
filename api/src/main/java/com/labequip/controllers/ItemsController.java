package com.labequip.controllers;

import com.labequip.models.Item;
import com.labequip.repositories.ItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by user on 19/08/2016.
 */
@RestController
@RequestMapping("/api/v1/items")
public class ItemsController implements ResourceController<Item, Long> {
    @Autowired
    ItemsRepository itemsRepository;


    @Override
    public List<Item> getList() {
        return itemsRepository.findAll();
    }

    @Override
    public Item getItem(@PathVariable("id") Long id) {
        return itemsRepository.findOne(id);
    }

    @Override
    public Item postItem(@RequestBody Item item) {
        return itemsRepository.save(item);
    }

    @Override
    public Item putItem(@PathVariable("id") Long id, @RequestBody Item item) {
        return itemsRepository.save(item);
    }

    @Override
    public String deleteItem(@PathVariable("id") Long id) {
        Item savedItem = itemsRepository.findOne(id);

        if(savedItem==null)
            return "Item not found";

        itemsRepository.delete(id);
        return "Delete successful";
    }
}
