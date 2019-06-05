package com.Dao;

import com.Entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component("userDao")
public interface UserDao {

    @Select("SELECT * FROM user_ WHERE user_name=#{user_name} AND user_password=#{user_password} ")
    User LoginPermission(@Param("user_name") String user_name, @Param("user_password") String user_password);

    @Select("SELECT COUNT(*) FROM user_ WHERE user_name=#{user_name} OR email=#{email}")
    Integer Regist_DuplicateChecking(@Param("user_name")String user_name,@Param("email")String email);


    @Insert("INSERT INTO user_(user_name,user_password,email,user_type) value(#{user_name}," +
            "#{user_password},#{email},#{user_type})")
    void InsertUser(@Param("user_name")String user_name,
                    @Param("user_password")String user_password,
                    @Param("email")String email,
                    @Param("user_type")String user_type);

    @Update("UPDATE user_ SET user_password = #{user_password} WHERE user_name =#{user_name}")
    void Update_user_password(@Param("user_password")String user_password,@Param("user_name")String user_name);
}
