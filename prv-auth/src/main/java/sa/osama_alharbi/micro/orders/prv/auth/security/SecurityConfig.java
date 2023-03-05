package sa.osama_alharbi.micro.orders.prv.auth.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import sa.osama_alharbi.micro.orders.prv.auth.security.authentication.client.google.ClientGoogleAuthenticationProvider;
import sa.osama_alharbi.micro.orders.prv.auth.security.authentication.client.usernamePassword.ClientUsernamePasswordAuthenticationProvider;
import sa.osama_alharbi.micro.orders.prv.auth.security.authentication.manager.emailPassword.ManagerEmailPasswordAuthenticationProvider;
import sa.osama_alharbi.micro.orders.prv.auth.security.authentication.manager.phoneNumberPassword.ManagerPhoneNumberPasswordAuthenticationProvider;
import sa.osama_alharbi.micro.orders.prv.auth.security.authenticationFilter.CustomAuthenticationFilter;
import sa.osama_alharbi.micro.orders.prv.auth.security.authorization.CustomAuthorizationFilter;

@Configuration
@EnableWebSecurity(debug = false)
@RequiredArgsConstructor
@Slf4j
public class SecurityConfig {
    private CustomAuthenticationFilter customAuthenticationFilter = null;
    private final ClientGoogleAuthenticationProvider clientGoogleAuthenticationProvider;
    private final ClientUsernamePasswordAuthenticationProvider clientUsernamePasswordAuthenticationProvider;
    private final ManagerEmailPasswordAuthenticationProvider managerEmailPasswordAuthenticationProvider;
    private final ManagerPhoneNumberPasswordAuthenticationProvider managerPhoneNumberPasswordAuthenticationProvider;



    @Bean
    public PasswordEncoder passwordEncoder(){
        log.info("Bean PasswordEncoder");
        return new BCryptPasswordEncoder(10);
    }

    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);

        clientUsernamePasswordAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        authenticationManagerBuilder.authenticationProvider(clientUsernamePasswordAuthenticationProvider);

        clientGoogleAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        authenticationManagerBuilder.authenticationProvider(clientGoogleAuthenticationProvider);

        managerEmailPasswordAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        authenticationManagerBuilder.authenticationProvider(managerEmailPasswordAuthenticationProvider);

        managerPhoneNumberPasswordAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        authenticationManagerBuilder.authenticationProvider(managerPhoneNumberPasswordAuthenticationProvider);

        return authenticationManagerBuilder.build();
    }

    @Bean()
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        AuthenticationManager authenticationManager = authenticationManager(http);
        http.authenticationManager(authenticationManager);

        http.csrf().disable();

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.authorizeHttpRequests().antMatchers("/login/**").permitAll();
        http.authorizeHttpRequests().antMatchers("/api/**").authenticated();
        http.authorizeHttpRequests().antMatchers("/a/**").authenticated();
        http.authorizeHttpRequests().anyRequest().permitAll();

        http.httpBasic();

        customAuthenticationFilter = new CustomAuthenticationFilter();
        customAuthenticationFilter.setAuthenticationManager(authenticationManager);
        customAuthenticationFilter.setFilterProcessesUrl("/login/**");
        http.addFilter(customAuthenticationFilter);

        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
