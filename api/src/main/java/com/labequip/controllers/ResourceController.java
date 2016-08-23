package com.labequip.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by user on 19/08/2016.
 */
public interface ResourceController<T, I> {

    @RequestMapping(value = "",method = RequestMethod.GET)
    List<T> getList();


    @RequestMapping(value = "/id",method = RequestMethod.GET)
    T getItem(@PathVariable("id") I id);


    @RequestMapping(value = "",method = RequestMethod.POST)
    T postItem(@RequestBody T item);

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    T putItem(@PathVariable("id") I id, @RequestBody T item);


    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    String deleteItem(@PathVariable("id") I id);


}
