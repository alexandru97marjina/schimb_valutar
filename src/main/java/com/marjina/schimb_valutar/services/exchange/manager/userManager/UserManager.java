package com.marjina.schimb_valutar.services.exchange.manager.userManager;

import com.marjina.schimb_valutar.common.helper.exception.NotFoundException;
import com.marjina.schimb_valutar.common.persistence.models.User;

public interface UserManager {
    User getUserByUserName(String userName) throws NotFoundException;
}
