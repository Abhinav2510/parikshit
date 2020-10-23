package com.midlife.exams.jpa.dao;

import com.midlife.exams.jpa.entities.security.UserEntity;
import com.midlife.exams.jpa.repo.security.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UsersDAO {
    private UsersRepo usersRepo;
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UsersDAO(UsersRepo usersRepo, BCryptPasswordEncoder passwordEncoder) {
        this.usersRepo = usersRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public UserEntity findByEmail(String email){
        return usersRepo.findByEmail(email);
    }

    public UserEntity findByUserNAme(String userName){
        return usersRepo.findByUsername(userName);
    }

    public UserEntity saveUser(UserEntity userEntity){
        userEntity.setPassWord(passwordEncoder.encode(userEntity.getPassWord()));
        return usersRepo.save(userEntity);
    }
}
