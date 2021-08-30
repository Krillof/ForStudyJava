package com.mimimetr.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    public UserDetailsServiceImpl() {
    }


    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

        System.out.println("123");
        userService.AddStandartUser();

        User user = userService.GetUserByName(name);
        if (user == null) throw new UsernameNotFoundException("");
        Set<GrantedAuthority> roles = new HashSet();
        roles.add(new SimpleGrantedAuthority("USER"));

        UserDetails userDetails =
                new org.springframework.security.core.userdetails.User(user.getName(),
                        user.getPassword(),
                        roles);

        return userDetails;
    }

}
