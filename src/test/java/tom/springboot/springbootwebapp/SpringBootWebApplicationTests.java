package tom.springboot.springbootwebapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import tom.springboot.SpringBootWebappApplication;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootWebappApplication.class)
@WebAppConfiguration
public class SpringBootWebApplicationTests {

    @Test
    public void contextLoads() {
    }

}
