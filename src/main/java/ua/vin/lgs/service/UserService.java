package ua.vin.lgs.service;


import ua.vin.lgs.domain.User;
import ua.vin.lgs.shared.AbstractCRUD;

public interface UserService extends AbstractCRUD<User>{
	User getUserByEmail(String email);
}
