//package io.harmed.easyeng.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(final HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.csrf().disable().authorizeRequests()
//                .antMatchers("/registration").not().fullyAuthenticated()
//                .antMatchers("/swagger-ui.html").not().fullyAuthenticated()
//                .antMatchers("/users").hasRole("SYSTEM").anyRequest().authenticated()
//                .and()
//                .formLogin().loginPage("/login")
//                .defaultSuccessUrl("/").permitAll()
//                .and().logout().permitAll().logoutSuccessUrl("/");
//    }
//
//    @Override
//    public void configure(final WebSecurity web) {
//        web.ignoring()
//                .antMatchers("/v3/api-docs/**", "/swagger-ui/**");
//    }
//}
