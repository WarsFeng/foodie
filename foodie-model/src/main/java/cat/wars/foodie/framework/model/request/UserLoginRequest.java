package cat.wars.foodie.framework.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @program: foodie
 * @description: User login request model
 * @author: Wars
 * @created: 2019/12/23 00:31
 */
@Getter
@Setter
@ToString
public class UserLoginRequest extends RequestData {

    @ApiModelProperty(name = "username", value = "用户名", required = true, dataType = "string", example = "Wars")
    private String username;

    @ApiModelProperty(name = "password", value = "密码", required = true, dataType = "string", example = "passwd")
    private String password;
}
