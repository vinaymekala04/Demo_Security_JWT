package com.demosecurity.demosecurity.service;

import com.demosecurity.demosecurity.model.User;
import com.demosecurity.demosecurity.model.UserDetailsImpl;
import com.demosecurity.demosecurity.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=repo.findByUsername(username);
        if(user==null)
        {
            System.out.println("User Not Found 404");
            throw new UsernameNotFoundException("Error 404");
        }
        return new UserDetailsImpl(user);
    }


//    public void addUser(User user) {
//        System.out.println("user in service");
//        repo.save(user);
//    }
}
