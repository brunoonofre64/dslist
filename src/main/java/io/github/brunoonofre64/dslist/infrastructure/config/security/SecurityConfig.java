package io.github.brunoonofre64.dslist.infrastructure.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String ADMIN = "ADMIN";
    private static final String USER = "USER";
    private static final String GAME_END_POINT = "*/game/**";
    private static final String GAME_LIST_END_POINT = "*/list/**";
    private static final String USER_END_POINT = "*/user/**";
    private static final String ROLE_END_POINT = "*/role/**";

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;
    @Value("${jwt.secret}")
    private String jwtSecret;

    private static final String[] AUTH_WHITELIST = {
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**",
            "/v3/api-docs/**",
            "/swagger-ui/**",
            "*/h2-console/**",
            "/login"
    };

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(STATELESS);

        http.authorizeHttpRequests().antMatchers(AUTH_WHITELIST).permitAll()

                .and()
                .authorizeHttpRequests()
                .antMatchers(HttpMethod.POST, GAME_END_POINT).hasAnyRole(ADMIN, USER)
                .antMatchers(HttpMethod.PUT, GAME_END_POINT).hasAnyRole(ADMIN, USER)
                .antMatchers(HttpMethod.DELETE, GAME_END_POINT).hasRole(ADMIN)
                .antMatchers(HttpMethod.GET, GAME_END_POINT).permitAll()

                .and()
                .authorizeHttpRequests()
                .antMatchers(HttpMethod.POST, GAME_LIST_END_POINT).hasAnyRole(ADMIN, USER)
                .antMatchers(HttpMethod.PUT, GAME_LIST_END_POINT).hasAnyRole(ADMIN, USER)
                .antMatchers(HttpMethod.DELETE, GAME_LIST_END_POINT).hasRole(ADMIN)
                .antMatchers(HttpMethod.GET, GAME_LIST_END_POINT).permitAll()

                .and()
                .authorizeHttpRequests()
                .antMatchers(HttpMethod.POST, USER_END_POINT).hasAnyRole(ADMIN, USER)
                .antMatchers(HttpMethod.PUT, USER_END_POINT).hasAnyRole(ADMIN, USER)
                .antMatchers(HttpMethod.DELETE, USER_END_POINT).hasAnyRole(ADMIN, USER)
                .antMatchers(HttpMethod.GET, USER_END_POINT).hasRole(ADMIN)

                .and()
                .authorizeHttpRequests()
                .antMatchers(HttpMethod.POST, ROLE_END_POINT).hasRole(ADMIN);


        http.addFilter(new CustomAuthenticationFilterConfig(this.authenticationManagerBean(), jwtSecret));
        http.addFilterBefore(new CustomAuthorizationFilterConfig(jwtSecret), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
