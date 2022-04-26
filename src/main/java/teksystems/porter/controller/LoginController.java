package teksystems.porter.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import teksystems.porter.dao.UserDao;
import teksystems.porter.dao.UserRoleDao;
import teksystems.porter.entity.User;
import teksystems.porter.entity.UserRole;
import teksystems.porter.formbean.RegisterFormBean;

import javax.validation.Valid;
import java.util.Date;


@Slf4j
@Controller
public class LoginController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserRoleDao userRoleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/login/loginForm", method = RequestMethod.GET)
    public ModelAndView login() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("login/loginForm");
        return response;
    }

    @RequestMapping(value="/login/registerForm")
    public ModelAndView index() throws Exception{
        ModelAndView response = new ModelAndView();
        response.setViewName("login/registerForm");

        RegisterFormBean form = new RegisterFormBean();
        return response;
    }


    @RequestMapping(value = "/login/registerSubmit", method = { RequestMethod.POST, RequestMethod.GET})
    public ModelAndView registerSubmit(@Valid RegisterFormBean form, BindingResult bindingResult) throws Exception {
        ModelAndView response = new ModelAndView();

        if (bindingResult.hasErrors()) {

            log.info("Errors are happening! can't show you them directly " +
                            "because casting them was problematic");

            response.addObject("form", form);

            response.addObject("bindingResult", bindingResult);

            log.info(String.valueOf(bindingResult.getAllErrors()));

            response.setViewName("login/registerForm");
            return response;
        }

        User user = new User();

        user.setEmail(form.getEmail());
        user.setCreateDate(new Date());

        String password = passwordEncoder.encode(form.getPassword());
        user.setPassword(password);

        userDao.save(user);

        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setUserRole("USER");

        userRoleDao.save(userRole);

        log.info(form.toString());

        response.setViewName("/login/loginForm");

        return response;
    }

}