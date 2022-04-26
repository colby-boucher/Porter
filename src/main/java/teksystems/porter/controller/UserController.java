package teksystems.porter.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import teksystems.porter.dao.CharacterDao;
import teksystems.porter.entity.Character;
import teksystems.porter.entity.User;
import teksystems.porter.services.SecurityServices;


import java.util.List;


@Slf4j
@Controller
public class UserController {

    @Autowired
    private CharacterDao characterDao;

    @Autowired
    SecurityServices securityServices = new SecurityServices();

    @RequestMapping(value = "/user/characters", method = RequestMethod.GET)
    public ModelAndView characters() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/characters");
        User user = securityServices.getSecureUser();
        String email = user.getEmail();

        List<Character> characters = characterDao.findCharactersByUserEquals(user);

        response.addObject("characters", characters);
        response.addObject("email", email);

        return response;
    }

    @RequestMapping(value = "/user/create", method = RequestMethod.GET)
    public ModelAndView createCharacter() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/createCharacterForm");
        User user = securityServices.getSecureUser();
        Integer userId = user.getId();

        return response;
    }



}
