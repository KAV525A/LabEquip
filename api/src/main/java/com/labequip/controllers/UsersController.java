package com.labequip.controllers;

import com.labequip.models.User;
import com.labequip.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by user on 19/08/2016.
 */
@RestController
@RequestMapping("/api/v1/users")
public class UsersController {

    @Autowired
    UsersRepository usersRepository;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable("id") Long id) {
        return usersRepository.findOne(id);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public User postSave(@RequestBody User user) {
        // TODO: 19/08/2016 Validation
        return usersRepository.save(user);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public User putUpdate(@PathVariable Long id,@RequestBody User request) {

        User savedUser = usersRepository.findOne(id);

        //merge fields
        if (request.getName() != null)
            savedUser.setName(request.getName());

        if (request.getAddress() != null)
            savedUser.setAddress(request.getAddress());

        return usersRepository.save(savedUser);

    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id){

        User savedUser = usersRepository.findOne(id);

        if(savedUser==null)
            return "User not found";

        usersRepository.delete(savedUser);

        return "Delete successfull";

    }


    @RequestMapping(value = "",method = RequestMethod.GET)
    public List<User> getList(){
        return usersRepository.findAll();
    }


}
