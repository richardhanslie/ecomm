package id.co.miniproject.ecomm.config;

import id.co.miniproject.ecomm.service.MyCustomerDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
    @Bean
    public UserDetailsService userDetailsService() {
        return new MyCustomerDetailService();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .httpBasic()
//                .and()
//                .authorizeRequests()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin().permitAll().defaultSuccessUrl("/cust", true)
//                .and()
//                .logout().permitAll();
//        return http.build();
        http
                .csrf().disable()
                .httpBasic(Customizer.withDefaults())
                .authorizeHttpRequests()
                .requestMatchers(HttpMethod.GET, "/**").permitAll()
                .requestMatchers(HttpMethod.POST, "/**").permitAll()
                .requestMatchers(HttpMethod.PUT, "/**").permitAll()
//                .requestMatchers(HttpMethod.POST, "/**").hasAnyAuthority("admin", "employee")
//                .requestMatchers(HttpMethod.PUT, "/**").hasAuthority("admin")
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll().defaultSuccessUrl("/cust", true)
                .and()
                .logout().permitAll();
        return http.build();
    }
}
