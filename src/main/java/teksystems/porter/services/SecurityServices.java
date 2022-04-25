package teksystems.porter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import teksystems.porter.dao.UserDao;
import teksystems.porter.entity.User;

@Service
public class SecurityServices {

    @Autowired
    private UserDao userDao;

    public User getSecureUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();

        User user = userDao.findByEmail(currentUserName);

        return user;
    }
}
