package com.zujuan.config;

import com.zujuan.serviceImpl.MyAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity // 注解开启Spring Security的功能
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyAuthenticationProvider provider;  //注入我们自己的AuthenticationProvider

    @Autowired
    private AuthenticationSuccessHandler myAuthenticationSuccessHandler;
    @Autowired
    private AuthenticationFailureHandler myAuthenticationFailureHandler;

    @Autowired
    private DataSource dataSource;

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        // 配置数据源
        jdbcTokenRepository.setDataSource(dataSource);
        // 第一次启动的时候自动建表（可以不用这句话，自己手动建表，源码中有语句的）
        //jdbcTokenRepository.setCreateTableOnStartup(true);
        return jdbcTokenRepository;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.formLogin()                    //  定义当需要用户登录时候，转到的登录页面。
//                .loginPage("login.html")
//                .loginProcessingUrl("/user/login").permitAll()
//                .and()
//                .authorizeRequests()       // 定义哪些URL需要被保护、哪些不需要被保护
//                //.antMatchers("/**/register.html","/layuiadmin/**").permitAll()
//                .anyRequest().authenticated()  // 任何请求,登录后可以访问
//                .and()
//                .csrf().disable();          // 关闭csrf防护;

        http.formLogin().loginPage("/views/user/login.html").loginProcessingUrl("/user/login")  //表单登录，permitAll()表示这个不需要验证 登录页面，登录失败页面
                .successHandler(myAuthenticationSuccessHandler)
                .failureHandler(myAuthenticationFailureHandler).permitAll()
                .and()
                .authorizeRequests().antMatchers("/layuiadmin/**",
                    "/**/register.html", "/user/register","/**/forget.html","/user/forget","/user/sendEmail")
                .permitAll()
                .anyRequest().authenticated()
                .and().headers().frameOptions().disable()//关闭frame保护
                .and().rememberMe()                                   // 记住我相关配置
                .tokenRepository(persistentTokenRepository())
                .tokenValiditySeconds(120)
                .and()
                .csrf().disable()
        ;
        http.logout()
                .logoutSuccessUrl("/views/user/login.html")
                .logoutUrl("/user/logout")

                .deleteCookies("JSESSIONID");


    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(provider);
//    }
}