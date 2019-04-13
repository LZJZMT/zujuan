package com.zujuan.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: LZJ
 * @Date： 2019/1/8 17:45
 */
@Component
public class MyAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UserDetails userDetails = userDetailsService.loadUserByUsername(authentication.getName());
        if(userDetails == null || !userDetails.getPassword().
                equals(authentication.getCredentials())){
            throw new BadCredentialsException("用户名或密码不正确");
        }else{
            return new UsernamePasswordAuthenticationToken(userDetails,userDetails.getPassword(),userDetails.getAuthorities());
        }


    }

    @Override
    public boolean supports(Class<?> authentication) {
        return  UsernamePasswordAuthenticationToken.class.equals(authentication);
    }
}
