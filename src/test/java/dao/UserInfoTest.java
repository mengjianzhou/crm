//package dao;
//
//import com.robert.schoolMgr.bean.UserInfo;
//import com.robert.schoolMgr.controller.UserInfoController;
//import com.robert.schoolMgr.dao.UserMapper;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
///**
// * @auth mengjianzhou
// * @Date 2017/10/28
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"classpath:applicationContext.xml"})
//public class UserInfoTest {
//
//    private Logger logger = LoggerFactory.getLogger(UserInfoTest.class);
//
//    @Autowired
//    private ApplicationContext applicationContext;
//
//    private UserMapper userMapper;
//
//    @Autowired
//    private UserInfoController userInfoController;
//
//    @Before
//    public void startUp(){
//        userMapper = (UserMapper) applicationContext.getBean("userMapper");
//    }
//
//    @Test
//    public void testUserInfo(){
//        int id = 1;
//        UserInfo userInfo = userMapper.selectUserInfo(id);
//        logger.info("@@"+userInfo.getUsername());
//    }
//
//    @Test
//    public void testQueryUserInfo_Controller(){
//        int id =2;
//        userInfoController.selectUserInfo(id);
//    }
//
//
//}
