package com.Test;

import com.Controller.UserAction;
import com.Service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {

    @Test
    public void Connectiosn(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring-mvc.xml");
        UserService userService = (UserService) context.getBean("userService");
      userService.Update_user_password("ka","kh");
    }
}
