package com.allianz.example.util.security;

import com.allianz.example.database.entity.RoleEntity;
import com.allianz.example.database.entity.UserEntity;
import com.allianz.example.database.repository.RoleEntityRepository;
import com.allianz.example.database.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SecurityService implements UserDetailsService {


    @Autowired
    UserEntityRepository userEntityRepository;
    @Autowired
    RoleEntityRepository roleEntityRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        String roleString = "ROLE_";
        Optional<UserEntity> user = userEntityRepository.findByEmail(email);

        if (user.isEmpty()) {
            throw new UsernameNotFoundException("Could not findUser with email =" + email);
        }
        List<RoleEntity> roleEntities = new ArrayList<>(user.get().getRoles());
        roleString += roleEntities.get(0).getName();
        System.err.println(roleString);

        return new User(email,
                user.get().getPassword(),
                //dinamik
                Collections.singletonList(new SimpleGrantedAuthority(roleString)));
    }
}
