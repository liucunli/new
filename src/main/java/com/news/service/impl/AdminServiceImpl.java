package com.news.service.impl;

//import com.news.dao.AdminMapper;
import com.news.conf.CodeList;
import com.news.dao.AdminMapper;
import com.news.dao.UserDao;
import com.news.model.Admin;
import com.news.model.res.RespUser;
import com.news.model.User;
import com.news.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private UserDao userDao;


    @Override
    public RespUser saveUser(Admin admin) {
        RespUser respUser = new RespUser();
        User user = new User();
        User user1 = userDao.getUserByUsername(admin.getUsername());
        if(user1 == null){
            user.setUsername(admin.getUsername());
            user.setPassword(admin.getPassword());
            adminMapper.save(user);
            User user2 = userDao.getUserByUsername(admin.getUsername());//获得存入表后的id
            if(user2 != null){
                respUser.setCode(CodeList.SUCCESS);
                respUser.setCredential(user2.getUid());
            } else {
                respUser.setCode(CodeList.UNKNOWN_FAILED);
            }
        } else{
            respUser.setCode(CodeList.FAILED);
        }
        return respUser;
    }

    @Override
    public RespUser findUser(Admin admin) {
        RespUser respUser = new RespUser();

        if(admin != null){
            User user = userDao.getUserByUsername(admin.getUsername());
            if(user != null){
                if(user.getPassword().equals(admin.getPassword())){
                    respUser.setCode(CodeList.SUCCESS);
                    respUser.setCredential(user.getUid());
                } else {
                    respUser.setCode(CodeList.FAILED);
                }
            } else {
                respUser.setCode(CodeList.UNKNOWN_FAILED);
            }
        }
        return respUser;
    }

    @Override
    public User findUserById(Integer uid) {
        User user;

        user = userDao.getUserByUid(uid);
        if(user != null){
            user.setPassword("");
        }

        return user;
    }
}
