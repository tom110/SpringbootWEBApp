package tom.springboot.springbootwebapp.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class loginController {

    private Logger log = LogManager.getLogger(loginController.class);

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(){
        return "/index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request) throws Exception{
        log.info("login()");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        Subject subject= SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(username,password);
        try{
            subject.login(token);
            Session session=subject.getSession();
            return "/monitor/demoMonitor";
        }catch(Exception e){
            e.printStackTrace();
            return "/403";
        }
    }
}
