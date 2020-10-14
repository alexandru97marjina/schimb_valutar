package com.marjina.schimb_valutar.services.exchange.manager.userManager;

import com.marjina.schimb_valutar.common.helper.exception.NotFoundException;
import com.marjina.schimb_valutar.common.persistence.models.User;
import com.marjina.schimb_valutar.common.persistence.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserManagerImpl implements UserManager {

    @Autowired
    private UserRepository userDAO;

    /**
     * Get user by userName
     *
     * @param userName String userName
     * @return User
     * @throws NotFoundException in case of notFound user
     */
    @Override
    public User getUserByUserName(String userName) throws NotFoundException {
        return userDAO.findUserByUserName(userName).orElseThrow(() ->
                new NotFoundException("User with userName = " + userName + "not found in database"));
    }

}
