package ua.vin.lgs.dao;

import ua.vin.lgs.domain.User;
import ua.vin.lgs.shared.AbstractCRUD;

public interface UserDao extends AbstractCRUD<User>{
	User getUserByEmail(String email);
}
