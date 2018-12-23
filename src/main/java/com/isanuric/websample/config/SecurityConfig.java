package com.isanuric.websample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/*
 * Project: web-sample
 * @author ehsan.salmani
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String USER_01 = "user01";

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/resources/templates/pub/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/anonymous").anonymous()
                .anyRequest().authenticated()

                .and()
                .formLogin()
                .loginPage("/login")
//                .loginProcessingUrl("/mylogin")
//                .defaultSuccessUrl("/welcome.html", true)
//                .failureUrl("/login.html?error=true")
//                .failureHandler((httpServletRequest, httpServletResponse, e) -> {
//                    throw new BadCredentialsException("failed");
//                });

                .and()
                .httpBasic();

//                .and()
//                .logout()
//                .logoutUrl("/perform_logout")
//                .deleteCookies("JSESSIONID")
//                .logoutSuccessHandler(logoutSuccessHandler());
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser(USER_01).password(passwordEncoder().encode(USER_01)).roles("USER")

                .and()
                .withUser("user2").password(passwordEncoder().encode("passUser02")).roles("USER")

                .and()
                .withUser("admin1").password(passwordEncoder().encode("passAdmin01")).roles("ADMIN");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
