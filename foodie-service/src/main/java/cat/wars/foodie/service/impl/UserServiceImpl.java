package cat.wars.foodie.service.impl;

import cat.wars.foodie.dao.UsersMapper;
import cat.wars.foodie.framework.model.Users;
import cat.wars.foodie.framework.model.enums.Sex;
import cat.wars.foodie.framework.model.request.UserRegisterRequest;
import cat.wars.foodie.framework.utils.DateUtil;
import cat.wars.foodie.framework.utils.MD5Utils;
import cat.wars.foodie.service.UserService;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;

/**
 * @program: foodie
 * @description: User service basic implement
 * @author: Wars
 * @created: 2019/12/17 21:14
 */
@Service
public class UserServiceImpl implements UserService {

    @Value("${face-icon}")
    private String FACE_ICON;

    private Sid sid;
    private final UsersMapper mapper;

    public UserServiceImpl(Sid sid, UsersMapper mapper) {
        this.sid = sid;
        this.mapper = mapper;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public boolean queryUsernameIsAvailable(String username) {
        Example example = new Example(Users.class);
        example.createCriteria().andEqualTo("username", username);
        return null == mapper.selectOneByExample(example);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Users createUser(UserRegisterRequest request) {
        Users user = new Users();
        user.setId(sid.nextShort());
        user.setUsername(request.getUsername());
        try {
            user.setPassword(MD5Utils.getMD5Str(request.getPassword()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Default value
        user.setNickname(user.getUsername());
        user.setFace(FACE_ICON);
        user.setBirthday(DateUtil.stringToDate("1900-01-01"));
        user.setSex(Sex.SECRET.type);

        Date currDate = new Date();
        user.setCreatedTime(currDate);
        user.setUpdatedTime(currDate);
        mapper.insert(user);

        return user;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Users queryUserForLogin(String username, String password) {
        Example example = new Example(Users.class);
        example.createCriteria().andEqualTo("username", username);
        try {
            example.createCriteria().andEqualTo("password", MD5Utils.getMD5Str(password));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mapper.selectOneByExample(example);
    }
}
