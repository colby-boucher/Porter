package teksystems.porter.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import teksystems.porter.entity.User;
import teksystems.porter.services.SecurityServices;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.nio.file.AccessDeniedException;

@Slf4j
@Controller
@ControllerAdvice
public class ErrorController {

    @Autowired
    SecurityServices securityServices = new SecurityServices();

    @ExceptionHandler(AccessDeniedException.class)
    @RequestMapping(value="/error/404")
    public String error404(HttpServletRequest request){

        User user = securityServices.getSecureUser();

        String originalUri = (String) request.getAttribute("javax.servlet.forward.request_uri");
        log.error("requested URL not found : " + request.getMethod() + " " + originalUri);

        return "error/404";
    }

}
