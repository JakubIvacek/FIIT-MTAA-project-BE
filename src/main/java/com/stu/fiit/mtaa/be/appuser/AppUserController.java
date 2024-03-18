package com.stu.fiit.mtaa.be.appuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="users")
public class AppUserController {
    private final AppUserService appUserService;

    @Autowired
    public AppUserController(AppUserService userService){
        this.appUserService = userService;
    }

    // Return all users
    @GetMapping
    public List<AppUser> getAllAppUsers(){
        return appUserService.getAllAppUsers();
    }

    // Return user by name
    @GetMapping(path = "/{userName}")
    public Optional<AppUser> getAppUser(@PathVariable("userName") String userName){
        return appUserService.getAppUser(userName);
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