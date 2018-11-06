package com.sheepdivide.master.security;

import com.sheepdivide.master.dataLayer.connection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;
import java.sql.Connection;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    /*
    - admin bruger.
    Hvordan autoriserer vi en bruger?
     */
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                    .authorizeRequests()
//                    .anyRequest().authenticated()
//                .and()
//                    .formLogin()
//                    .loginPage("/login.html")
//                    .permitAll()
//                .and()
//                    .logout()
//                    .permitAll();
//    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/index", "/login", "/newlogin").permitAll()  // "/index", "/login" //"/shared/**"
                    .antMatchers("/user/**").hasAnyRole("USER")
                    .anyRequest().authenticated()
                .and()
                    .formLogin()
                    .loginPage("/login.html")//index eller login? slet .html
                    .defaultSuccessUrl("/user/home.html",true)
                    .permitAll() //slet permitall
                .and()
                    .logout()
                    //.logoutSuccessUrl("/login");
                    .permitAll(); //slet permitall
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**");
    }

    @Override //autowired
    public void configure(AuthenticationManagerBuilder auth) throws  Exception{
        auth
                .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");
    }

    //database
//    @Autowired
//    DataSource dataSource;
//    app.datasource.url=jdbc:mysql://localhost/test
//    app.datasource.username=dbuser
//    app.datasource.password=dbpass
//    app.datasource.pool-size=30


    //database
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .jdbcAuthentication()
//                    .dataSource(dataSource)
//                    .usersByUsernameQuery("select username, password, true " +
//                            "from users where username=?")
//                    .authoritiesByUsernameQuery("select username, 'ROLE_USER' from where username=?");
//    }
}
