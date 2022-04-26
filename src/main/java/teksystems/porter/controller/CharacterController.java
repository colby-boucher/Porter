package teksystems.porter.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import teksystems.porter.dao.CharacterDao;
import teksystems.porter.dao.CharactersItemDao;
import teksystems.porter.dao.UserDao;
import teksystems.porter.entity.Character;
import teksystems.porter.entity.CharacterItems;
import teksystems.porter.services.SecurityServices;

import java.util.List;

@Slf4j
@Controller
public class CharacterController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private CharacterDao characterDao;

    @Autowired
    private CharactersItemDao charactersItemDao;

    @Autowired
    SecurityServices securityServices = new SecurityServices();

    @RequestMapping(value = "/character/{id}/inventory", method = RequestMethod.GET)
    public ModelAndView login(@PathVariable Integer id) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("character/inventory");

        Character character = characterDao.findCharacterById(id);

        List<CharacterItems> inventory = charactersItemDao.findCharacterItemsByCharacterEquals(character);

        response.addObject("character", character);

        response.addObject("inventory", inventory);

        return response;
    }

}
