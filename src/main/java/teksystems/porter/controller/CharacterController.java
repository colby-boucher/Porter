package teksystems.porter.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import teksystems.porter.dao.CharacterDao;
import teksystems.porter.dao.UserDao;
import teksystems.porter.entity.Character;
import teksystems.porter.services.SecurityServices;

@Slf4j
@Controller
public class CharacterController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private CharacterDao characterDao;

    @Autowired
    SecurityServices securityServices = new SecurityServices();

    @RequestMapping(value = "/character/{id}/inventory", method = RequestMethod.GET)
    public ModelAndView login(@PathVariable Integer id) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("character/inventory");

        Character character = characterDao.findCharacterById(id);

        response.addObject(character);

        return response;
    }

}
