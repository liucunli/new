package com.news.service;

import com.news.model.Admin;
import com.news.model.res.RespUser;
import com.news.model.User;

public interface AdminService {

    //保存注册信息
    public RespUser saveUser(Admin admin);

    //查询用户
    public RespUser findUser(Admin admin);

    //返回用户资料
    public User findUserById(Integer uid);
}
