package com.rasoiyya.security.oauth;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
/**
 * 
 * @author Manish
 *
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfiguration  extends ResourceServerConfigurerAdapter {

	private static final String RESOURCE_ID = "admin";
	
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(RESOURCE_ID);
    }
    
    @Override
    public void configure(HttpSecurity http) throws Exception {
    	http.authorizeRequests()
    	.antMatchers("/v2/api-docs", "/configuration/**", "/swagger*/**","/**" ,"/webjars/**", "/admin/v1/adminRegistration").permitAll()
        .anyRequest().authenticated().and().formLogin().permitAll().and().logout().permitAll();
    }
}
