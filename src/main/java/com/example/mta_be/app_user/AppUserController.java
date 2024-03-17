package com.example.mta_be.app_user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="api/user")
public class AppUserController {
    private AppUserService appUserService;

    @Autowired
    public AppUserController(AppUserService userService){
        this.appUserService = userService;
    }
    // Return all users
    @GetMapping
    public List<AppUser> returnAllUsers(){
        return appUserService.getAppUsers();
    }
    // Return user by name
    @GetMapping(path = "/{userName}")
    public Optional<AppUser> returnAppUser(@PathVariable("userName") String userName){
        return appUserService.getAppUser(userName);
    }
    // Add user
    @PostMapping
    public void addNewAppUser(@RequestBody AppUser appUser){
        appUserService.addNewAppUser(appUser);
    }
    // Modify user
    @PutMapping(path = "/{userName}")
    public void updateAppUser(@PathVariable("userName") String userName, @RequestParam(required = false)Double height,
                              @RequestParam(required = false)Double weight,@RequestParam(required = false)Integer age,
                              @RequestParam(required = false)String password,@RequestParam(required = false)String newName){
        appUserService.updateAppUser(userName, height, weight, age, password, newName);
    }
    // Delete user
    @DeleteMapping(path = "/{userName}")
    public void deleteAppUser(@PathVariable("userName") String userName){
        appUserService.deleteAppUser(userName);
    }
}
