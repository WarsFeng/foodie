package cat.wars.foodie.web.controller;

import cat.wars.foodie.framework.exception.ExceptionCast;
import cat.wars.foodie.framework.model.Users;
import cat.wars.foodie.framework.model.request.UserLoginRequest;
import cat.wars.foodie.framework.model.request.UserRegisterRequest;
import cat.wars.foodie.framework.model.response.FoodieCode;
import cat.wars.foodie.framework.model.response.ResponseResult;
import cat.wars.foodie.framework.model.response.UserLoginResult;
import cat.wars.foodie.framework.utils.CookieUtils;
import cat.wars.foodie.framework.utils.JSONUtils;
import cat.wars.foodie.framework.utils.MD5Utils;
import cat.wars.foodie.framework.web.controller.BaseController;
import cat.wars.foodie.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.apache.commons.lang3.StringUtils.isEmpty;

/**
 * @program: foodie
 * @description: Passport controller
 * @author: Wars
 * @created: 2019/12/18 01:06
 */
@Api(tags = "客户端注册登陆相关接口")
@RestController
@RequestMapping("/passport")
public class PassportController extends BaseController {

    private final UserService userService;

    public PassportController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/usernameIsAvailable")
    @ApiOperation(value = "用户名是否可用", notes = "验证用户名是否可用")
    @ApiImplicitParam(name = "username", value = "用户名", required = true, paramType = "query", dataType = "string")
    public ResponseResult usernameIsAvailable(String username) {
        if (isEmpty(username)) ExceptionCast.cast(FoodieCode.INVALID_PARAM);

        boolean success = userService.queryUsernameIsAvailable(username);

        if (!success) ExceptionCast.cast(FoodieCode.PASSPORT_USERNAME_IS_EXIST);
        return ResponseResult.SUCCESS();
    }

    @PostMapping("/register")
    @ApiOperation(value = "用户注册", notes = "用于注册用户")
    public ResponseResult register(@RequestBody UserRegisterRequest request) {
        if (request.getUsername().isEmpty() || request.getPassword().isEmpty())
            ExceptionCast.cast(FoodieCode.PASSPORT_REGISTER_INVALID_PARAM);
        if (6 > request.getPassword().length())
            ExceptionCast.cast(FoodieCode.PASSPORT_REGISTER_PASSWORD_SHORT);
        if (!request.getPassword().equals(request.getConfirmPassword()))
            ExceptionCast.cast(FoodieCode.PASSPORT_REGISTER_PASSWORD_INCONSISTENT);
        if (!userService.queryUsernameIsAvailable(request.getUsername()))
            ExceptionCast.cast(FoodieCode.PASSPORT_USERNAME_IS_EXIST);

        Users userResult = userService.createUser(request);

        // Save user info to cookie
        setUserInfoToCookie(userResult);

        return ResponseResult.SUCCESS();
    }

    @PostMapping("/login")
    @ApiOperation(value = "用户登陆", notes = "用于注册登陆")
    public UserLoginResult login(@RequestBody UserLoginRequest request
            , HttpServletRequest httpServletRequest
            , HttpServletResponse httpServletResponse) throws Exception {
        if (request.getUsername().isEmpty() || request.getPassword().isEmpty())
            ExceptionCast.cast(FoodieCode.PASSPORT_LOGIN_INVALID_PARAM);

        Users userResult = userService.queryUserForLogin(request.getUsername(), MD5Utils.getMD5Str(request.getPassword()));
        if (null == userResult) ExceptionCast.cast(FoodieCode.PASSPORT_LOGIN_FAIL);

        userResult = this.setNullProperty(userResult); // Ignore property
        // Save user info to cookie
        setUserInfoToCookie(userResult);

        return new UserLoginResult(userResult);
    }

    @PutMapping("/logout/{uid}")
    @ApiOperation(value = "用户登出", notes = "用于用户登出，退出登陆")
    @ApiImplicitParam(name = "uid", value = "User id", required = true, paramType = "path", dataType = "string")
    public ResponseResult logout(@PathVariable("uid") String uid) {
        CookieUtils.deleteCookie(request, response, "user");
        return ResponseResult.SUCCESS();
    }

    public Users setNullProperty(Users user) {
        user.setPassword(null);
        user.setMobile(null);
        user.setEmail(null);
        user.setCreatedTime(null);
        user.setUpdatedTime(null);
        return user;
    }

    public void setUserInfoToCookie(Users userResult) {
        CookieUtils.setCookie(request, response, "user", JSONUtils.objectToJson(userResult), true);
    }
}
