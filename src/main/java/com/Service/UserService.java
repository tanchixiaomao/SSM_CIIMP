package com.Service;


import com.Dao.UserDao;
import com.Entity.User;
import com.Util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.ui.Model;

import java.sql.SQLException;

@Service("userService")
@Transactional
public class UserService {

    @Autowired
    private UserDao userDao;


    /**
     *注册查重
     * @param user_name 用户名
     * @param user_password 密码
     * @return user类
     */
    public boolean LoginCheck(String user_name,String user_password){
        int count = 0;
        try{
            count= userDao.LoginPermission(user_name, user_password);
        }catch(Exception e){
            e.printStackTrace();
        }
        return count==1;
    }

    public User LoginType(String user_name){
        User u = new User();
        try{
            u = userDao.LoginType(user_name);
        }catch (Exception e){
            e.printStackTrace();
        }
        return u;
    }

    /**
     * 注册查重
     * @param user_name 用户名
     * @param email 邮箱
     * @return boolean
     */
    public boolean Regist_DuplicateChecking(String user_name,String email){
        int count = 0;
        try{
            count = userDao.Regist_DuplicateChecking(user_name, email);
        }catch (Exception e){
            e.printStackTrace();
        }
        return userDao.Regist_DuplicateChecking(user_name, email)==0;
    }

    /**
     * 插入新用户
     * @param user_name 用户名
     * @param user_password 密码
     * @param email 邮箱
     * @param user_type 用户类型
     */
    public void RegistUser(String user_name, String user_password, String email, String user_type){
        try{userDao.InsertUser(user_name, user_password, email, user_type);}catch(Exception e){e.printStackTrace();}
    }

    /**
     * 更新密码
     * @param user_password 密码
     * @param user_name 用户名
     */
    public void Update_user_password(String user_password, String user_name){
        try{userDao.Update_user_password(user_password, user_name);}catch (Exception e){e.printStackTrace();}
    }
}
