package com.news.dao;

import com.news.model.Admin;
import com.news.model.User;
import org.springframework.data.repository.Repository;

public interface UserDao extends Repository<User,String> {
    User getUserByUsername(String username);
    User getUserByUid(Integer uid);
}
