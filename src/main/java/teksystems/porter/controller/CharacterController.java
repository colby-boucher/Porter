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
import teksystems.porter.dao.InventoryDao;
import teksystems.porter.dao.UserDao;
import teksystems.porter.entity.Character;
import teksystems.porter.entity.CharacterItems;
import teksystems.porter.entity.InventoryJoin;
import teksystems.porter.services.SecurityServices;

import java.util.List;
import java.util.Map;

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
    private InventoryDao inventoryDao;

    @Autowired
    SecurityServices securityServices = new SecurityServices();

    @RequestMapping(value = "/character/{id}/inventory", method = RequestMethod.GET)
    public ModelAndView login(@PathVariable Integer id) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("character/inventory");

        Character character = characterDao.findCharacterById(id);


        List<Map<String,Object>> inventory = charactersItemDao.join(id);



        response.addObject("character", character);

        response.addObject("inventory", inventory);



        return response;
    }

    @RequestMapping(value = "/character/{id}/delete", method = {RequestMethod.GET, RequestMethod.DELETE})
    public ModelAndView deleteCharacter(@PathVariable Integer id) throws Exception{
        ModelAndView response = new ModelAndView();

        Character character = characterDao.findCharacterById(id);

        characterDao.delete(character);

        response.setViewName(":redirect/user/characters");

        return response;
    }

}
