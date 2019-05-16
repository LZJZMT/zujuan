package com.zujuan.serviceImpl;

import com.zujuan.mapper.UserMapper;
import com.zujuan.pojo.User;
import com.zujuan.pojo.UserExample;
import com.zujuan.pojo.UserExample.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserExample userExample = new UserExample();
        Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<User> users = userMapper.selectByExample(userExample);
        if(users == null || users.size() == 0){
            return null;
        }else {
            users.get(0).setAuthorities(AuthorityUtils.commaSeparatedStringToAuthorityList
                    ("admin"));
            return users.get(0);
        }

    }
}
