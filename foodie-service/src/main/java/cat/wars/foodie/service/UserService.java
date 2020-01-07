package cat.wars.foodie.service;

import cat.wars.foodie.framework.model.Users;
import cat.wars.foodie.framework.model.request.UserRegisterRequest;

/**
 * @program: foodie
 * @description: User service
 * @author: Wars
 * @created: 2019/12/17 21:02
 */
public interface UserService {

    boolean queryUsernameIsAvailable(String username);

    Users createUser(UserRegisterRequest request);

    Users queryUserForLogin(String username, String password);
}
