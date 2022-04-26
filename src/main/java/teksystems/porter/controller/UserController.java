package teksystems.porter.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import teksystems.porter.dao.CharacterDao;
import teksystems.porter.dao.UserDao;
import teksystems.porter.entity.Character;
import teksystems.porter.entity.User;
import teksystems.porter.formbean.CharacterFormBean;
import teksystems.porter.services.SecurityServices;


import javax.validation.Valid;
import java.util.List;


@Slf4j
@Controller
public class UserController {

    @Autowired
    private UserDao userDao;

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

        response.addObject("userId", userId);


        return response;
    }

    @RequestMapping(value = "/user/characterSubmit", method = { RequestMethod.POST, RequestMethod.GET})
    public ModelAndView characterSubmit(@Valid CharacterFormBean form, BindingResult bindingResult) throws Exception {
        ModelAndView response = new ModelAndView();

        response.addObject("form", form);

        if (bindingResult.hasErrors()) {

            log.info("Errors are happening! can't show you them directly " +
                    "because casting them was problematic");

            response.addObject("form", form);

            response.addObject("bindingResult", bindingResult);

            log.info(String.valueOf(bindingResult.getAllErrors()));

            response.setViewName("user/createCharacterForm");
            return response;
        }

        Character character = new Character();
        character.setUser(userDao.findById(form.getUserId()));
        character.setName(form.getName());
        character.setStrength(form.getStrength());
        characterDao.save(character);

        log.info(form.toString());

        response.setViewName(":redirect/user/characters");

        return response;
    }



}
