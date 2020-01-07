package cat.wars.foodie.framework.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @program: foodie
 * @description: Register request model
 * @author: Wars
 * @created: 2019/12/18 01:15
 */
@Getter
@Setter
@ToString
public class UserRegisterRequest extends RequestData {

    @ApiModelProperty(name = "username", value = "用户名", required = true, dataType = "string", example = "Wars")
    private String username;

    @ApiModelProperty(name = "password", value = "密码", required = true, dataType = "string", example = "passwd")
    private String password;

    @ApiModelProperty(name = "confirmPassword", value = "重复输入密码", required = true, dataType = "string", example = "passwd")
    private String confirmPassword;
}
