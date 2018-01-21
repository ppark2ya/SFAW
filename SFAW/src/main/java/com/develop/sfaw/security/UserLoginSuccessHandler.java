package com.develop.sfaw.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class UserLoginSuccessHandler implements AuthenticationSuccessHandler{

	private static final Logger log = LoggerFactory.getLogger(UserLoginSuccessHandler.class);

	@Override
	public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse res, Authentication auth)
			throws IOException, ServletException {
		log.info("Name : {}.", auth.getName());
		log.info("Authorities : {}.", auth.getAuthorities().toString());
		log.info("Details : {}.", auth.getDetails().toString());
		log.info("Principal : {}.", auth.getPrincipal().toString());

		for(GrantedAuthority a : auth.getAuthorities()) {
			log.info("Authority : {}.", a.getAuthority());
		}

		UserDetails u = (UserDetails) auth.getPrincipal();

		log.info("isAccountNonExpired : {}.", String.valueOf(u.isAccountNonExpired()));
		log.info("isAccountNonLocked : {}.", String.valueOf(u.isAccountNonLocked()));
		log.info("isCredentialsNonExpired : {}.", String.valueOf(u.isCredentialsNonExpired()));
		log.info("isEnabled : {}.", String.valueOf(u.isEnabled()));

		res.sendRedirect(req.getContextPath() + "/");
	}
}
