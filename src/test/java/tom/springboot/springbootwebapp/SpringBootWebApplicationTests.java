package tom.springboot.springbootwebapp;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import tom.springboot.SpringBootWebappApplication;
import tom.springboot.springbootwebapp.domain.User;
import tom.springboot.springbootwebapp.services.UserService;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootWebappApplication.class)
@WebAppConfiguration
public class SpringBootWebApplicationTests {

    private UserService userService;
    private Logger log = Logger.getLogger(SpringBootWebApplicationTests.class);

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Test
    public void contextLoads() {
        User user= userService.findByUsername("user");
        log.info(user.getUsername()+user.getPassword());
    }

}
