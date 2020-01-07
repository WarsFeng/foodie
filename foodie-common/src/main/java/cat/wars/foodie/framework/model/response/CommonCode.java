package cat.wars.foodie.framework.model.response;

import lombok.ToString;

/**
 * Created by IntelliJ IDEA.
 * User: wars
 * Date: 10/21/19
 * Time: 11:16 AM
 * 全局返回码和message存储
 */

@ToString
public enum CommonCode implements ResultCode {

    SUCCESS(true, 10000, "操作成功！"),
    FAIL(false, 11111, "操作失败！"),
    UNAUTHENTICATED(false, 10001, "此操作需要登陆系统！"),
    UNAUTHORISE(false, 10002, "权限不足, 无权操作！"),
    INVALIDPARAM(false, 10003, "非法参数！"),
    REQUEST_METHOD_NOT_SUPPORT(false, 10004, "不支持此请求！"),
    SERVER_ERROR(false, 99999, "抱歉, 系统繁忙, 请稍后重试！");

    boolean success;
    int code;
    String message;

    CommonCode(boolean success, int code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    @Override
    public boolean success() {
        return success;
    }

    @Override
    public int code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }
}
