package com.goldenspace.config;

import com.goldenspace.security.UserDetailsServiceImpl;
import com.goldenspace.security.jwt.AuthEntryPointJwt;
import com.goldenspace.security.jwt.AuthTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        // securedEnabled = true,
        // jsr250Enabled = true,
        prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    private AuthEntryPointJwt unauthorizedHandler;

    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter() {
        return new AuthTokenFilter();
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()
                .antMatchers("/api/auth/**").permitAll()
                .antMatchers("/api/test/**").permitAll()

//                .antMatchers(HttpMethod.GET, "/tacos").permitAll()
//                .antMatchers(HttpMethod.POST,"/tacos").hasRole("ADMIN")
//                .antMatchers(HttpMethod.PUT,"/tacos").hasRole("ADMIN")
//                .antMatchers(HttpMethod.DELETE,"/tacos/{id}").hasRole("ADMIN")
//
//                .antMatchers(HttpMethod.GET, "/ingredients").permitAll()
//                .antMatchers(HttpMethod.POST, "/ingredients").hasRole("ADMIN")
//                .antMatchers(HttpMethod.PUT,"/ingredients").hasRole("ADMIN")
//                .antMatchers(HttpMethod.DELETE, "/ingredients/{id}").permitAll()
//
//                .antMatchers(HttpMethod.GET, "/orders").permitAll()
//                .antMatchers(HttpMethod.POST, "/orders").hasRole("USER")
//                .antMatchers(HttpMethod.DELETE, "/orders/{id}").hasRole("ADMIN")
                .anyRequest().authenticated();

        http.addFilterBefore(authenticationJwtTokenFilter(),
                UsernamePasswordAuthenticationFilter.class);
    }
}

