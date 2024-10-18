package com.cst8911.auth.service;


import com.cst8911.auth.model.User;
import com.cst8911.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class JwtUserDetailsService implements UserDetailsService {



    @Autowired
    private UserRepository userRepository;



    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Fetch the user from Cosmos DB
        User userEntity = userRepository.findByEmail(email);

        if (userEntity == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }

        System.out.println( userEntity.getRole().getAuthorities());

        // Create a UserDetails object with user's details
        return new org.springframework.security.core.userdetails.User(
                userEntity.getEmail(), userEntity.getPassword(), userEntity.getRole().getAuthorities()
        );
    }

}
