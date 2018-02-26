package com.nanta.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.nanta.base.ApiPath;
import com.nanta.security.JwtAuthenticationEntryPoint;
import com.nanta.security.JwtAuthenticationProcessingFilter;
import com.nanta.security.JwtAuthenticationProvider;
import com.nanta.security.JwtAuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Autowired
  private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

  @Autowired
  private JwtAuthenticationProvider jwtAuthenticationProvider;

  public JwtAuthenticationProcessingFilter authenticationProcessingFilter() throws Exception {
    JwtAuthenticationProcessingFilter jwtAuthenticationProcessingFilter =
        new JwtAuthenticationProcessingFilter();
    jwtAuthenticationProcessingFilter.setAuthenticationManager(this.authenticationManager());
    jwtAuthenticationProcessingFilter
        .setAuthenticationSuccessHandler(new JwtAuthenticationSuccessHandler());
    return jwtAuthenticationProcessingFilter;
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.authenticationProvider(this.jwtAuthenticationProvider);
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    web.ignoring()
        .antMatchers("/", "/**", "/login", "/gallery", "/blog", "/blog/*", "/about", "/sitemap.xml",
            "/administrator/*", "/resource/**", "/static/**", "/api/login", "/api/project",
            "/swagger-ui*", "/webjars/springfox-swagger-ui/**", "/swagger-resources/**",
            "/configuration/**", "/v2/api-docs", "favicon.ico", "/WEB-INF/jsp/**", "/css/**",
            "/js/**", "/img/**")
        .antMatchers(HttpMethod.GET, ApiPath.EDUCATION.toString())
        .antMatchers(HttpMethod.GET, ApiPath.ABOUT.toString())
        .antMatchers(HttpMethod.GET, ApiPath.SKILL.toString())
        .antMatchers(HttpMethod.GET, ApiPath.PROJECT.toString())
        .antMatchers(HttpMethod.GET, ApiPath.PICTURE.toString() + "/*")
        .antMatchers(HttpMethod.POST, ApiPath.CONTACT.toString())
        .antMatchers(HttpMethod.GET, ApiPath.BLOG.toString())
        .antMatchers(HttpMethod.GET, ApiPath.BLOG.toString()+"/*");

  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable().authorizeRequests().anyRequest().authenticated().and().exceptionHandling()
        .authenticationEntryPoint(this.jwtAuthenticationEntryPoint).and().sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    http.addFilterBefore(this.authenticationProcessingFilter(),
        UsernamePasswordAuthenticationFilter.class);
    http.headers().cacheControl();
  }
}
