package com.Service;


import com.Dao.UserDao;
import com.Entity.User;
import com.Util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

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
    public User LoginCheck(String user_name,String user_password){
        SqlSession session = MybatisUtil.getSqlSessionFactory().openSession();
        User u = userDao.LoginPermission(user_name, user_password);
        return u;
    }

    /**
     * 注册查重
     * @param user_name 用户名
     * @param email 邮箱
     * @return boolean
     */
    public boolean Regist_DuplicateChecking(String user_name,String email){
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
        userDao.InsertUser(user_name, user_password, email, user_type);
    }

    /**
     * 更新密码
     * @param user_password 密码
     * @param user_name 用户名
     */
    public void Update_user_password(String user_password, String user_name){
        userDao.Update_user_password(user_password, user_name);
    }
}
