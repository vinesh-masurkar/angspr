package com.vim.angspr.controller;

import com.vim.angspr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import lombok.Setter;

@RequestMapping("/angspr")
@RestController
@Setter
public class UserController {

    //@Autowired
    //UserService userService;

//    @RequestMapping(Constants.GET_USER_BY_ID)
//    public UserDto getUserById(@PathVariable Integer userId) {
//        return userService.getUserById(userId);
//    }
//
//    @RequestMapping(Constants.GET_ALL_USERS)
//    public List < UserDto > getAllUsers() {
//        return userService.getAllUsers();
//    }
//
//    @RequestMapping(value = Constants.SAVE_USER, method = RequestMethod.POST)
//    public void saveUser(@RequestBody UserDto userDto) {
//        userService.saveUser(userDto);
//    }

    @RequestMapping(
            path = "/ping",
            method = RequestMethod.GET,
            produces = "application/json")
    public ResponseEntity<String> ping() {
        return new ResponseEntity<>("User Service says Hello", HttpStatus.OK);
    }
}