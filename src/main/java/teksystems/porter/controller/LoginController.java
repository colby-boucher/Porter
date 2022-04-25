package teksystems.porter.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
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

    @RequestMapping(value = "/login/login", method = RequestMethod.GET)
    public ModelAndView login() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("login/loginForm");
        return response;
    }

    @RequestMapping(value="/login/register")
    public ModelAndView index() throws Exception{
        ModelAndView response = new ModelAndView();
        response.setViewName("login/registerForm");

        RegisterFormBean form = new RegisterFormBean();
        return response;
    }

    /**
     * when the user submits the form it will call into this method
     * 1) the action on the form itself must match the value here in the request mapping
     * 2) method on the form must match the method here
     * otherwise spring MVC will not be able to respond to the request
     * <p>
     * In this case the @PostMapping and @RequestMapping are the same with the @PostMapping
     * being a shorthand.   This works the same for @GetMapping
     * <p>
     * This method now becomes a create and an edit based on if the id is populated in
     * the RegisterFormBean.
     */
    //@PostMapping( "/user/registerSubmit")
    @RequestMapping(value = "/login/registerSubmit", method = { RequestMethod.POST, RequestMethod.GET})
    public ModelAndView registerSubmit(@Valid RegisterFormBean form, BindingResult bindingResult) throws Exception {
        ModelAndView response = new ModelAndView();

        log.info(form.toString());

        if (bindingResult.hasErrors()) {

            for (ObjectError error : bindingResult.getAllErrors()) {
                log.info( ((FieldError)error).getField() + " " +  error.getDefaultMessage());
            }

            // add the form back to the model so we can fill up the input fields
            // so the user can correct the input and does not have type it all again
            response.addObject("form", form);

            // add the error list to the model
            response.addObject("bindingResult", bindingResult);

            // because there is 1 or more error we do not want to process the logic below
            // that will create a new user in the database.   We want to show the registerForm.jsp
            response.setViewName("login/registerForm");
            return response;
        }

        // we first assume that we are going to try to load the user from
        // the database using the incoming id on the form
        User user = userDao.findById(form.getId());

        // if the user is not null the know it is an edit
        if (user == null) {
            // now, if the user from the database is null then it means we did not
            // find this user.   Therefore, it is a create.
            user = new User();
        }

        user.setEmail(form.getEmail());
        user.setCreateDate(new Date());

        String password = passwordEncoder.encode(form.getPassword());
        user.setPassword(password);

        userDao.save(user);

        // create and save the user role object
        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setUserRole("USER");

        userRoleDao.save(userRole);

        log.info(form.toString());

        // here instead of showing a view, we want to redirect to the edit page
        // the edit page will then be responsible for loading the user from the
        // database and dynamically creating the page
        // when you use redirect: as part of the view name it triggers spring to tell the
        // browser to do a redirect to the URL after the :    The big piece here to
        // recognize that redirect: uses an actual URL rather than a view name path.
        response.setViewName("redirect:/user/edit/" + user.getId());

        return response;
    }

}