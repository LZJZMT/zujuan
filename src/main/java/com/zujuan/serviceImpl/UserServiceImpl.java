package com.zujuan.serviceImpl;

import com.zujuan.mapper.UserMapper;
import com.zujuan.pojo.User;
import com.zujuan.pojo.UserExample;
import com.zujuan.service.UserService;
import com.zujuan.utils.GetCurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: LZJ
 * @Date： 2019/1/9 14:26
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper um;

    @Override
    public void changePwd(String password) {
        User currentUser = GetCurrentUser.getCurrentUser();
        UserExample example = new UserExample();
        example.createCriteria().andIdEqualTo(currentUser.getId());
        User user = new User();
        user.setPassword(password);
        um.updateByExampleSelective(user, example);
    }

    @Override
    public void insertUser(User u) {
        um.insert(u);
    }

    @Override
    public List getByUsername(String username) {
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(username);
        return um.selectByExample(example);
    }

    @Override
    public List queryByExample(UserExample userExample) {
        return um.selectByExample(userExample);
    }

    @Override
    public void updateUserByExample(User newUser, UserExample userExample1) {
        um.updateByExampleSelective(newUser,userExample1);
    }
}
