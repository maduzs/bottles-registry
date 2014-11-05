package muni.fi.pa165.liquorbottles.service.services;

import java.util.List;
import muni.fi.pa165.liquorbottles.service.dto.UserDTO;

/**
 *
 * @author Jakub Lipcak, Masaryk University
 */
public interface UserService {

    List<UserDTO> findAll();

    UserDTO findById(long id);

    UserDTO findByUsername(String userName);

    String findPassByUsername(String userName);

    void insertUser(UserDTO user);

    void deleteUser(UserDTO user);

    void updateUser(UserDTO user);
}
