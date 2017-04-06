package pl.xperios.tdb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AnonymousAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;
import pl.xperios.tdb.security.GuestSecurityService;

import static pl.xperios.tdb.config.GlobalValues.Principals.GUEST;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private GuestSecurityService guestSecurityService;

    @Autowired
    private UserDetailsService detailsService;


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(detailsService).passwordEncoder(passwordEncoder());
        auth.authenticationProvider(new AnonymousAuthenticationProvider("anonymousKey"));
    }

    @Override
    public void init(WebSecurity web) throws Exception {
        super.init(web);
        final HttpSecurity http = getHttp();
//		web.postBuildAction(() -> {
//			FilterSecurityInterceptor securityInterceptor = http.getSharedObject(FilterSecurityInterceptor.class);
//			securityInterceptor.setRejectPublicInvocations(true);
//			web.securityInterceptor(securityInterceptor);
//			securityInterceptor.getAccessDecisionManager();
//		});
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/img/**", "/css/**", "/plugins/**", "/layout/**", "/scripts/**", "/pages/**", "/favicon.ico").permitAll()
                .antMatchers("/rest/**", "/api-doc/**", "/swagger.json").permitAll()

                .and()
                .formLogin().loginPage("/login.html").defaultSuccessUrl("/").failureUrl("/login.html?error").usernameParameter("username").passwordParameter("password").permitAll().and()
                .logout().logoutUrl("/logout.html").logoutSuccessUrl("/").permitAll().and()
                .anonymous().principal(GUEST).authenticationFilter(guestSecurityService).and()
                .rememberMe().and()
                .csrf().disable();
//		http.getSharedObject()
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }


    @Bean
    public RememberMeServices rememberMeServices() {
        // Key must be equal to rememberMe().key()
        TokenBasedRememberMeServices rememberMeServices = new TokenBasedRememberMeServices("your_key", detailsService);
        rememberMeServices.setCookieName("remember_me_cookie");
        rememberMeServices.setParameter("remember_me_checkbox");
        rememberMeServices.setTokenValiditySeconds(2678400); // 1month
        return rememberMeServices;
    }


}