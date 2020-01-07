package cat.wars.foodie.framework.model.response;

import cat.wars.foodie.framework.model.Users;
import lombok.Getter;
import lombok.Setter;

/**
 * @program: foodie
 * @description: User login response model
 * @author: Wars
 * @created: 2019/12/23 00:39
 */
@Getter
@Setter
public class UserLoginResult extends ResponseResult {

    public UserLoginResult(Users user) {
        super(FoodieCode.SUCCESS);
        this.user = user;
    }

    private Users user;
}
