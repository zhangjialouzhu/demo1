package com.yuc.test;


import com.yuc.model.User;
import com.yuc.service.UserService;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.UUID;

/** 
* UserServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>03/06/2018</pre> 
* @version 1.0 
*/
@FixMethodOrder(MethodSorters.NAME_ASCENDING) 
public class UserServiceImplTest {

    @Autowired
    private UserService userService;
@Before
public void before() throws Exception {
    ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:conf/spring.xml"
            ,"classpath:conf/spring-mybatis.xml"});
    userService = (UserService) context.getBean("userServiceImpl");
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: insert(User user) 
* 
*/ 
@Test
public void testInsert() throws Exception { 
//TODO: Test goes here...
    User user = new User();
    user.setId(UUID.randomUUID().toString().replaceAll("-",""));
    user.setName("yuc");
    userService.insert(user);
} 


} 
