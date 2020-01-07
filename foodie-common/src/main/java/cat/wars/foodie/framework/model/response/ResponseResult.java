package cat.wars.foodie.framework.model.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by IntelliJ IDEA.
 * User: wars
 * Date: 10/21/19
 * Time: 11:36 AM
 * 全局基础响应
 */

@Getter
@Setter
@NoArgsConstructor
@ApiModel("Global basic response")
public class ResponseResult implements Response {

    @ApiModelProperty("Success?")
    private boolean success = SUCCESS;

    @ApiModelProperty("Code")
    private int code = SUCCESS_CODE;

    @ApiModelProperty("Message")
    private String message = SUCCESS_MESSAGE;

    public ResponseResult(ResultCode resultCode) {
        this.success = resultCode.success();
        this.code = resultCode.code();
        this.message = resultCode.message();
    }

    public static ResponseResult SUCCESS() {
        return new ResponseResult();
    }

    public static ResponseResult FAIL() {
        return new ResponseResult(CommonCode.FAIL);
    }

    public static ResponseResult ERROR() {
        return new ResponseResult(CommonCode.SERVER_ERROR);
    }
}
