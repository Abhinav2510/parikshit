package com.midlife.exams.config;

import com.midlife.exams.jpa.entities.security.UserEntity;
import com.midlife.exams.jpa.repo.security.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UsersRepo usersRepo;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserEntity userEntity = usersRepo.findByUsername(userName);
        if ( userEntity == null ) {
            return null;
        }

        return new User(userEntity.getUsername(),userEntity.getPassWord(),true,true,true,true, Collections.singleton((GrantedAuthority) () -> "user"));
    }
}
