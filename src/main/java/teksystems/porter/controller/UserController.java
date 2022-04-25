package teksystems.porter.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.crypto.password.PasswordEncoder;
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
public class UserController {







}
