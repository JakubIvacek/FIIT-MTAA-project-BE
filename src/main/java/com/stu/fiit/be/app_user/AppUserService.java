package com.stu.fiit.be.app_user;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppUserService {

    private AppUserRepository appUserRepository;

    @Autowired
    public AppUserService(AppUserRepository userRepository){
        this.appUserRepository = userRepository;
    }

    public List<AppUser> getAppUsers() {
        return appUserRepository.findAll();
    }

    public Optional<AppUser> getAppUser(String username) {
        Optional<AppUser> appUserOptional = appUserRepository.findAppUserByName(username);
        if(appUserOptional.isEmpty()){
            throw new IllegalStateException("user with this username not found " + username);
        }
        return appUserOptional;
    }

    public void deleteAppUser(String userName) {
        // Check if user present
        Optional<AppUser> appUserOptional = appUserRepository.findAppUserByName(userName);
        if(appUserOptional.isEmpty()){
            throw new IllegalStateException("user with this username not found " + userName);
        }
        appUserRepository.deleteAppUserByName(userName);
    }

    public void addNewAppUser(AppUser appUser) {
        // Check if username present
        Optional<AppUser> appUserOptional = appUserRepository.findAppUserByName(appUser.getUsername());
        if(appUserOptional.isPresent()){
            throw new IllegalStateException("user with is username already created : " + appUser.getUsername());
        }
        appUserRepository.save(appUser);
    }

    @Transactional
    public void updateAppUser(String userName, Double height, Double weight, Integer age, String password, String newName) {
        // Check if user present and get user
        AppUser appUser = appUserRepository.findAppUserByName(userName)
                .orElseThrow(() -> new IllegalStateException( "user with this username not found"));
        // Check if new name already taken
        Optional<AppUser> appUserOptional = appUserRepository.findAppUserByName(newName);
        if(appUserOptional.isPresent()){
            throw new IllegalStateException("username already taken or the same : " + newName);
        }
        // Do name check if long enough not the same
        if(newName != null && newName.length() > 0 && !newName.equals(userName))
            appUser.setUsername(newName);
        else throw new IllegalStateException("NewName wrong entry :" + newName);
        // Do password check
        if(password != null && password.length() > 7 && !password.equals(appUser.getPassword()))
            appUser.setPassword(password);
        else throw new IllegalStateException("Password the same or not long enough : " + password);
        // Do check weight
        if(weight != null)
            appUser.setWeight(weight);
        // Do check weight
        if(height != null)
            appUser.setHeight(height);
        // Do check age
        if(age != null)
            appUser.setAge(age);
    }
}
