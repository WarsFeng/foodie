package cat.wars.foodie.framework.model.response;

/**
 * @program: foodie
 * @description: Foodie response code
 * @author: Wars
 * @created: 2019/12/18 00:55
 */
public enum FoodieCode implements ResultCode {

    SUCCESS(true, 10000, "操作成功！"),
    FAIL(false, 11111, "操作失败！"),
    UNAUTHENTICATED(false, 10001, "此操作需要登陆系统！"),
    UNAUTHORISE(false, 10002, "权限不足, 无权操作！"),
    INVALID_PARAM(false, 10003, "非法参数！"),

    // Front and 2XXXX
    //  passport 200xx
    PASSPORT_USERNAME_IS_EXIST(false, 20000, "用户名已存在！"),
    PASSPORT_REGISTER_PASSWORD_INCONSISTENT(false, 20001, "两次密码输入不一致！"),
    PASSPORT_REGISTER_PASSWORD_SHORT(false, 20002, "密码长度不能小于 6 位！"),
    PASSPORT_REGISTER_INVALID_PARAM(false, 20003, "用户名或密码不能为空！"),
    PASSPORT_LOGIN_INVALID_PARAM(false, 20004, "用户名或密码不能为空！"),
    PASSPORT_LOGIN_FAIL(false, 20005, "用户名或密码不正确！"),
    //  category 201xx
    CATEGORY_NOT_EXISTS(false, 20100, "此分类不存在！"),

    // Back andm 3XXXX

    SERVER_ERROR(false, 99999, "抱歉, 系统繁忙, 请稍后重试！");

    boolean success;
    int code;
    String message;

    FoodieCode(boolean success, int code, String message) {
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
