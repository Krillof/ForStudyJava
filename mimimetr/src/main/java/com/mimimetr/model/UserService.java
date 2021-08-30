package com.mimimetr.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService{

    @Autowired
    private UserRepo userRepo;


    public void AddStandartUser(){
        if (!userRepo.existsById(1L))
            userRepo.save(new User(1L, "abc", "123"));
    }


    public boolean TryAddUser(String name, String password){
        if (this.IsUserExists(name, password)){
            return false;
        } else {
            userRepo.save(new User(name, password));
            return true;
        }
    }

    public boolean IsUserExists(String name, String password){
        return ! (userRepo.findByNameAndPassword(name, password).isEmpty());
    }

    public User GetUserByName(String name){
        try{
            return userRepo.findByName(name).get(0);
        } catch (Exception ex){
            return null;
        }

    }
}
